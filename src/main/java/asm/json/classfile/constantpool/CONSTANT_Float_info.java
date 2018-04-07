/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Float_info.java 2018-04-06 18:39 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public  class CONSTANT_Float_info extends CPInfo {
    CONSTANT_Float_info(ClassReader cr) throws IOException {
        value = cr.readFloat();
    }

    public CONSTANT_Float_info(float value) {
        this.value = value;
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

    public void accept(CPVisitor visitor) {
        visitor.visitFloat(this);
    }

    public final float value;
}
