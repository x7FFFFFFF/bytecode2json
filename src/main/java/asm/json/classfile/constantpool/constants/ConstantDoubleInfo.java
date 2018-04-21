/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Double_info.java 2018-04-06 18:41 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantDoubleInfo implements IAcceptable, ICPinfo {
    public ConstantDoubleInfo(ClassReader cr) throws IOException {
        value = cr.readDouble();
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

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitDouble(this);
    }

    public  double value;
}