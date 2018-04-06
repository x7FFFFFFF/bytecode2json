/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Integer_info.java 2018-04-06 18:39 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public class CONSTANT_Integer_info extends CPInfo {
    CONSTANT_Integer_info(ClassReader cr) throws IOException {
        value = cr.readInt();
    }

    public CONSTANT_Integer_info(int value) {
        this.value = value;
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

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitInteger(this, data);
    }

    public final int value;
}