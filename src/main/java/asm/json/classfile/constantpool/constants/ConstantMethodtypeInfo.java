/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_MethodType_info.java 2018-04-06 18:31 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public class ConstantMethodtypeInfo implements IAcceptable, ICPinfo  {
    public ConstantMethodtypeInfo( ClassReader cr) throws IOException {
        descriptor_index = cr.readUnsignedShort();
    }



    public int getTag() {
        return CPInfoTypes.CONSTANT_MethodType;
    }

    public int byteLength() {
        return 3;
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodType_info[signature_index: " + descriptor_index + "]";
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitMethodType(this);
    }



    public final int descriptor_index;
}