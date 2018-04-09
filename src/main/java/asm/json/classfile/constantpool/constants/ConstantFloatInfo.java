/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Float_info.java 2018-04-06 18:39 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public  class ConstantFloatInfo implements IAcceptable, ICPinfo  {
    public ConstantFloatInfo(ClassReader cr) throws IOException {
        value = cr.readFloat();
    }



    public int getTag() {
        return CPInfoTypes.CONSTANT_Float;
    }

    public int byteLength() {
        return 5;
    }

    @Override
    public String toString() {
        return "CONSTANT_Float_info[value: " + value + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitFloat(this);
    }

    public final float value;
}
