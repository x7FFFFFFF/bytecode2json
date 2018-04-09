/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Fieldref_info.java 2018-04-06 18:40 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantFieldrefInfo extends ConstantRefInfo {
    public ConstantFieldrefInfo(ClassReader cr) throws IOException {
        super( cr, CPInfoTypes.CONSTANT_Fieldref);
    }

    @Override
    public String toString() {
        return "CONSTANT_Fieldref_info[class_index: " + class_index + ", name_and_type_index: " + name_and_type_index + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitFieldref(this);
    }
}
