/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Methodref_info.java 2018-04-06 18:34 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public   class ConstantMethodrefInfo extends ConstantRefInfo {
    public ConstantMethodrefInfo(ClassReader cr) throws IOException {
        super(cr, CPInfoTypes.CONSTANT_Methodref);
    }



    @Override
    public String toString() {
        return "CONSTANT_Methodref_info[class_index: " + class_index + ", name_and_type_index: " + name_and_type_index + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitMethodref(this);
    }
}