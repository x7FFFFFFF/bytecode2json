/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Double_info.java 2018-04-06 18:41 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public class CONSTANT_Double_info extends CPInfo {
    CONSTANT_Double_info(ClassReader cr) throws IOException {
        value = cr.readDouble();
    }

    public CONSTANT_Double_info(double value) {
        this.value = value;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_Double;
    }

    public int  byteLength() {
        return 9;
    }

    @Override
    public int size() {
        return 2;
    }

    @Override
    public String toString() {
        return "CONSTANT_Double_info[value: " + value + "]";
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitDouble(this, data);
    }

    public final double value;
}