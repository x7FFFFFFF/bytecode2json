/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ConstantPool.java 2018-04-06 18:03 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.constants.*;
import asm.json.classfile.constantpool.exeptions.InvalidEntry;
import com.sun.org.apache.bcel.internal.classfile.ConstantInterfaceMethodref;

import java.util.concurrent.Callable;

public class ConstantPoolWalker implements Callable<ConstantPool> {

    private final ConstPoolVisitor  visitor;
    private final ClassReader cr;
    private final int count;

    public ConstantPoolWalker( ClassReader cr, ConstPoolVisitor visitor, int count) {
        this.visitor = visitor;
        this.cr = cr;
        this.count = count;
    }

    @Override
    public ConstantPool call() throws Exception {
        ConstantPool res = new ConstantPool(count);
        for (int i = 1; i < count; i++) {
            int tag = cr.readUnsignedByte();
            switch (tag) {
                case CPInfoTypes.CONSTANT_Class:
                    final ConstantClassInfo constantClassInfo = new ConstantClassInfo(cr);
                    res.set(i, constantClassInfo);
                    constantClassInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Double:
                    final ConstantDoubleInfo constantDoubleInfo = new ConstantDoubleInfo(cr);
                    res.set(i, constantDoubleInfo);
                    constantDoubleInfo.accept(visitor);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_Fieldref:
                    final ConstantFieldrefInfo constantFieldrefInfo = new ConstantFieldrefInfo(cr);
                    res.set(i, constantFieldrefInfo);
                    constantFieldrefInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Float:
                    final ConstantFloatInfo constantFloatInfo = new ConstantFloatInfo(cr);
                    res.set(i, constantFloatInfo);
                    constantFloatInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Integer:
                    final ConstantIntegerInfo constantIntegerInfo = new ConstantIntegerInfo(cr);
                    res.set(i, constantIntegerInfo);
                    constantIntegerInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_InterfaceMethodref:
                    final ConstantInterfacemethodrefInfo constantInterfaceMethodref = new ConstantInterfacemethodrefInfo(cr);
                    res.set(i, constantInterfaceMethodref);
                    constantInterfaceMethodref.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_InvokeDynamic:
                    final ConstantInvokedynamicInfo constantInvokedynamicInfo = new ConstantInvokedynamicInfo(cr);
                    res.set(i, constantInvokedynamicInfo);
                    constantInvokedynamicInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Long:
                    final ConstantLongInfo constantLongInfo = new ConstantLongInfo(cr);
                    res.set(i, constantLongInfo);
                    constantLongInfo.accept(visitor);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_MethodHandle:
                    final ConstantMethodhandleInfo constantMethodhandleInfo = new ConstantMethodhandleInfo(cr);
                    res.set(i, constantMethodhandleInfo);
                    constantMethodhandleInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_MethodType:
                    final ConstantMethodtypeInfo constantMethodtypeInfo = new ConstantMethodtypeInfo(cr);
                    res.set(i, constantMethodtypeInfo);
                    constantMethodtypeInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Methodref:
                    final ConstantMethodrefInfo constantMethodrefInfo = new ConstantMethodrefInfo(cr);
                    res.set(i, constantMethodrefInfo);
                    constantMethodrefInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_NameAndType:
                    final ConstantNameandtypeInfo constantNameandtypeInfo = new ConstantNameandtypeInfo(cr);
                    res.set(i, constantNameandtypeInfo);
                    constantNameandtypeInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_String:
                    final ConstantStringInfo constantStringInfo = new ConstantStringInfo(cr);
                    res.set(i, constantStringInfo);
                    constantStringInfo.accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Utf8:
                    final ConstantUtf8Info constantUtf8Info = new ConstantUtf8Info(cr);
                    res.set(i, constantUtf8Info);
                    constantUtf8Info.accept(visitor);
                    break;

                default:
                    throw new InvalidEntry(i, tag);
            }
        }

        return res;
    }
}