/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ConstantPool.java 2018-04-06 18:03 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.EntryNotFound;
import asm.json.classfile.constantpool.exeptions.InvalidEntry;
import asm.json.classfile.constantpool.exeptions.InvalidIndex;
import asm.json.classfile.constantpool.exeptions.UnexpectedEntry;

import java.io.IOException;
import java.util.Iterator;

public class ConstantPool {
    private CPInfo[] pool;

    public ConstantPool(ClassReader cr) throws IOException, InvalidEntry {
        int count = cr.readUnsignedShort();
        pool = new CPInfo[count];
        for (int i = 1; i < count; i++) {
            int tag = cr.readUnsignedByte();
            switch (tag) {
                case CPInfoTypes.CONSTANT_Class:
                    pool[i] = new CONSTANT_Class_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_Double:
                    pool[i] = new CONSTANT_Double_info(cr);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_Fieldref:
                    pool[i] = new CONSTANT_Fieldref_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_Float:
                    pool[i] = new CONSTANT_Float_info(cr);
                    break;

                case CPInfoTypes.CONSTANT_Integer:
                    pool[i] = new CONSTANT_Integer_info(cr);
                    break;

                case CPInfoTypes.CONSTANT_InterfaceMethodref:
                    pool[i] = new CONSTANT_InterfaceMethodref_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_InvokeDynamic:
                    pool[i] = new CONSTANT_InvokeDynamic_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_Long:
                    pool[i] = new CONSTANT_Long_info(cr);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_MethodHandle:
                    pool[i] = new CONSTANT_MethodHandle_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_MethodType:
                    pool[i] = new CONSTANT_MethodType_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_Methodref:
                    pool[i] = new CONSTANT_Methodref_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_NameAndType:
                    pool[i] = new CONSTANT_NameAndType_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_String:
                    pool[i] = new CONSTANT_String_info(this, cr);
                    break;

                case CPInfoTypes.CONSTANT_Utf8:
                    pool[i] = new CONSTANT_Utf8_info(cr);
                    break;

                default:
                    throw new InvalidEntry(i, tag);
            }
        }
    }

    public ConstantPool(CPInfo[] pool) {
        this.pool = pool;
    }


    public int size() {
        return pool.length;
    }

    public int byteLength() {
        int length = 2;
        for (int i = 1; i < size(); ) {
            CPInfo cpInfo = pool[i];
            length += cpInfo.byteLength();
            i += cpInfo.size();
        }
        return length;
    }

    public CPInfo get(int index) throws InvalidIndex {
        if (index <= 0 || index >= pool.length)
            throw new InvalidIndex(index);
        CPInfo info = pool[index];
        if (info == null) {
            // this occurs for indices referencing the "second half" of an
            // 8 byte constant, such as CONSTANT_Double or CONSTANT_Long
            throw new InvalidIndex(index);
        }
        return pool[index];
    }

    public CPInfo get(int index, int expected_type) throws InvalidIndex, UnexpectedEntry {
        CPInfo info = get(index);
        if (info.getTag() != expected_type)
            throw new UnexpectedEntry(index, expected_type, info.getTag());
        return info;
    }

    public CONSTANT_Utf8_info getUTF8Info(int index) throws InvalidIndex, UnexpectedEntry {
        return ((CONSTANT_Utf8_info) get(index, CPInfoTypes.CONSTANT_Utf8));
    }

    public CONSTANT_Class_info getClassInfo(int index) throws InvalidIndex, UnexpectedEntry {
        return ((CONSTANT_Class_info) get(index, CPInfoTypes.CONSTANT_Class));
    }

    public CONSTANT_NameAndType_info getNameAndTypeInfo(int index) throws InvalidIndex, UnexpectedEntry {
        return ((CONSTANT_NameAndType_info) get(index, CPInfoTypes.CONSTANT_NameAndType));
    }

    public String getUTF8Value(int index) throws InvalidIndex, UnexpectedEntry {
        return getUTF8Info(index).value;
    }

    public int getUTF8Index(String value) throws EntryNotFound {
        for (int i = 1; i < pool.length; i++) {
            CPInfo info = pool[i];
            if (info instanceof CONSTANT_Utf8_info &&
                    ((CONSTANT_Utf8_info) info).value.equals(value))
                return i;
        }
        throw new EntryNotFound(value);
    }

    public Iterable<CPInfo> entries() {
        return new Iterable<CPInfo>() {
            public Iterator<CPInfo> iterator() {
                return new Iterator<CPInfo>() {

                    public boolean hasNext() {
                        return next < pool.length;
                    }

                    public CPInfo next() {
                        current = pool[next];
                        switch (current.getTag()) {
                            case CPInfoTypes.CONSTANT_Double:
                            case CPInfoTypes.CONSTANT_Long:
                                next += 2;
                                break;
                            default:
                                next += 1;
                        }
                        return current;
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }

                    private CPInfo current;
                    private int next = 1;

                };
            }
        };
    }
}