/*****************************************************************
 * Gridnine AB http://www.gridnine.com
 * Project: BOF VIP-Service
 *
 * $Id: ConstantRefInfo.java 2018-04-09 9:45 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;

import java.io.IOException;

public abstract class ConstantRefInfo   implements IAcceptable, ICPinfo {

    protected ConstantRefInfo(ClassReader cr, int tag) throws IOException {
        this.tag = tag;
        class_index = cr.readUnsignedShort();
        name_and_type_index = cr.readUnsignedShort();
    }



    public int getTag() {
        return tag;
    }

    public int byteLength() {
        return 5;
    }



    public final int tag;
    public final int class_index;
    public final int name_and_type_index;
}