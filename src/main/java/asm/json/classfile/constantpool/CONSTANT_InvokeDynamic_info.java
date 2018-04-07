/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_InvokeDynamic_info.java 2018-04-06 18:38 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public class CONSTANT_InvokeDynamic_info extends CPInfo {
    CONSTANT_InvokeDynamic_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        bootstrap_method_attr_index = cr.readUnsignedShort();
        name_and_type_index = cr.readUnsignedShort();
    }

    public CONSTANT_InvokeDynamic_info(ConstantPool cp, int bootstrap_method_index, int name_and_type_index) {
        super(cp);
        this.bootstrap_method_attr_index = bootstrap_method_index;
        this.name_and_type_index = name_and_type_index;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_InvokeDynamic;
    }

    public int byteLength() {
        return 5;
    }

    @Override
    public String toString() {
        return "CONSTANT_InvokeDynamic_info[bootstrap_method_index: " + bootstrap_method_attr_index + ", name_and_type_index: " + name_and_type_index + "]";
    }

    public void accept(CPVisitor visitor) {
        visitor.visitInvokeDynamic(this);
    }

    public CONSTANT_NameAndType_info getNameAndTypeInfo() throws ConstantPoolException {
        return cp.getNameAndTypeInfo(name_and_type_index);
    }

    public final int bootstrap_method_attr_index;
    public final int name_and_type_index;
}