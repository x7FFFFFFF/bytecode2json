/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Class_info.java 2018-04-06 18:36 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;
import asm.json.classfile.constantpool.PoolConstants;

import java.io.IOException;

@PoolConstants
public class ConstantClassInfo implements IAcceptable, ICPinfo {
    public ConstantClassInfo(ClassReader cr) throws IOException {
        name_index = cr.readUnsignedShort();
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_Class;
    }

    public int  byteLength() {
        return 3;
    }



    @Override
    public String toString() {
        return "CONSTANT_Class_info[name_index: " + name_index + "]";
    }

    public void  accept(ConstPoolVisitor visitor) {
        visitor.visitClass(this);
    }

    public  int name_index;



}
