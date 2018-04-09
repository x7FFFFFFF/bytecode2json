/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Integer_info.java 2018-04-06 18:39 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantIntegerInfo implements IAcceptable, ICPinfo  {
    public ConstantIntegerInfo(ClassReader cr) throws IOException {
        value = cr.readInt();
    }


    public int getTag() {
        return CPInfoTypes.CONSTANT_Integer;
    }

    public int byteLength() {
        return 5;
    }

    @Override
    public String toString() {
        return "CONSTANT_Integer_info[value: " + value + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitInteger(this);
    }

    public final int value;
}