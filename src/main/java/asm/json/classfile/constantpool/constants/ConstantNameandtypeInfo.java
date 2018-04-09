/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_NameAndType_info.java 2018-04-06 18:31 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.IOException;

public   class ConstantNameandtypeInfo implements IAcceptable, ICPinfo  {
    public ConstantNameandtypeInfo(ClassReader cr) throws IOException {
        name_index = cr.readUnsignedShort();
        type_index = cr.readUnsignedShort();
    }


    public int getTag() {
        return CPInfoTypes.CONSTANT_NameAndType;
    }

    public int byteLength() {
        return 5;
    }



    public void accept(ConstPoolVisitor visitor) {
        visitor.visitNameAndType(this);
    }

    @Override
    public String toString() {
        return "CONSTANT_NameAndType_info[name_index: " + name_index + ", type_index: " + type_index + "]";
    }

    public final int name_index;
    public final int type_index;
}