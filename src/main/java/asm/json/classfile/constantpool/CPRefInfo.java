/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CPRefInfo.java 2018-04-06 18:35 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public  abstract class CPRefInfo extends CPInfo {
    protected CPRefInfo(ConstantPool cp, ClassReader cr, int tag) throws IOException {
        super(cp);
        this.tag = tag;
        class_index = cr.readUnsignedShort();
        name_and_type_index = cr.readUnsignedShort();
    }

    protected CPRefInfo(ConstantPool cp, int tag, int class_index, int name_and_type_index) {
        super(cp);
        this.tag = tag;
        this.class_index = class_index;
        this.name_and_type_index = name_and_type_index;
    }

    public int getTag() {
        return tag;
    }

    public int byteLength() {
        return 5;
    }

    public CONSTANT_Class_info getClassInfo() throws ConstantPoolException {
        return cp.getClassInfo(class_index);
    }

    public String getClassName() throws ConstantPoolException {
        return cp.getClassInfo(class_index).getName();
    }

    public CONSTANT_NameAndType_info getNameAndTypeInfo() throws ConstantPoolException {
        return cp.getNameAndTypeInfo(name_and_type_index);
    }

    public final int tag;
    public final int class_index;
    public final int name_and_type_index;
}