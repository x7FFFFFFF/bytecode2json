/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_MethodHandle_info.java 2018-04-06 18:37 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public  class ConstantMethodhandleInfo implements IAcceptable, ICPinfo  {
    public ConstantMethodhandleInfo(ClassReader cr) throws IOException {
        reference_kind =  cr.readUnsignedByte();
        reference_index = cr.readUnsignedShort();
    }



    public int getTag() {
        return CPInfoTypes.CONSTANT_MethodHandle;
    }

    public int byteLength() {
        return 4;
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info[ref_kind: " + reference_kind + ", member_index: " + reference_index + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitMethodHandle(this);
    }



    public final int reference_kind;
    public final int reference_index;
}