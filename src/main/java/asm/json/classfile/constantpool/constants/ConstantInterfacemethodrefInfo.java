/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_InterfaceMethodref_info.java 2018-04-06 18:38 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;
import asm.json.classfile.constantpool.ConstantPool;

import java.io.IOException;

public class ConstantInterfacemethodrefInfo extends ConstantRefInfo  {
    public ConstantInterfacemethodrefInfo(ConstantPool cp, ClassReader cr) throws IOException {
        super( cr, CPInfoTypes.CONSTANT_InterfaceMethodref);
    }



    @Override
    public String toString() {
        return "CONSTANT_InterfaceMethodref_info[class_index: " + class_index + ", name_and_type_index: " + name_and_type_index + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitInterfaceMethodref(this);
    }
}