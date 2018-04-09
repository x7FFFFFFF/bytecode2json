/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_InvokeDynamic_info.java 2018-04-06 18:38 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantInvokedynamicInfo implements IAcceptable, ICPinfo  {
    public ConstantInvokedynamicInfo(ClassReader cr) throws IOException {
        bootstrap_method_attr_index = cr.readUnsignedShort();
        name_and_type_index = cr.readUnsignedShort();
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

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitInvokeDynamic(this);
    }



    public final int bootstrap_method_attr_index;
    public final int name_and_type_index;
}