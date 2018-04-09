/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_String_info.java 2018-04-06 18:29 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public  class ConstantStringInfo implements IAcceptable, ICPinfo  {
    public ConstantStringInfo(ClassReader cr) throws IOException {
        string_index = cr.readUnsignedShort();
    }


    public int getTag() {
        return CPInfoTypes.CONSTANT_String;
    }

    public int byteLength() {
        return 3;
    }


    public void accept(ConstPoolVisitor visitor) {
        visitor.visitString(this);
    }

    @Override
    public String toString() {
        return "CONSTANT_String_info[class_index: " + string_index + "]";
    }

    public final int string_index;
}