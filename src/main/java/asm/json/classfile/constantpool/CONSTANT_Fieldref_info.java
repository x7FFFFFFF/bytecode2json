/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Fieldref_info.java 2018-04-06 18:40 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public class CONSTANT_Fieldref_info extends CPRefInfo {
    CONSTANT_Fieldref_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp, cr, CPInfoTypes.CONSTANT_Fieldref);
    }

    public CONSTANT_Fieldref_info(ConstantPool cp, int class_index, int name_and_type_index) {
        super(cp, CPInfoTypes.CONSTANT_Fieldref, class_index, name_and_type_index);
    }

    @Override
    public String toString() {
        return "CONSTANT_Fieldref_info[class_index: " + class_index + ", name_and_type_index: " + name_and_type_index + "]";
    }

    public void accept(CPVisitor visitor) {
        visitor.visitFieldref(this);
    }
}
