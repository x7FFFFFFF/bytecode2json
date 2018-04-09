/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Long_info.java 2018-04-06 18:38 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantLongInfo implements IAcceptable, ICPinfo  {
    public ConstantLongInfo(ClassReader cr) throws IOException {
        value = cr.readLong();
    }



    public int getTag() {
        return CPInfoTypes.CONSTANT_Long;
    }

    @Override
    public int size() {
        return 2;
    }

    public int byteLength() {
        return 9;
    }

    @Override
    public String toString() {
        return "CONSTANT_Long_info[value: " + value + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitLong(this);
    }

    public final long value;
}