/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Long_info.java 2018-04-06 18:38 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public class CONSTANT_Long_info extends CPInfo {
    CONSTANT_Long_info(ClassReader cr) throws IOException {
        value = cr.readLong();
    }

    public CONSTANT_Long_info(long value) {
        this.value = value;
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

    public void accept(CPVisitor visitor) {
        visitor.visitLong(this);
    }

    public final long value;
}