/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_NameAndType_info.java 2018-04-06 18:31 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public   class CONSTANT_NameAndType_info extends CPInfo {
    CONSTANT_NameAndType_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        name_index = cr.readUnsignedShort();
        type_index = cr.readUnsignedShort();
    }

    public CONSTANT_NameAndType_info(ConstantPool cp, int name_index, int type_index) {
        super(cp);
        this.name_index = name_index;
        this.type_index = type_index;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_NameAndType;
    }

    public int byteLength() {
        return 5;
    }

    public String getName() throws ConstantPoolException {
        return cp.getUTF8Value(name_index);
    }

    public String getType() throws ConstantPoolException {
        return cp.getUTF8Value(type_index);
    }

    public void accept(CPVisitor visitor) {
        visitor.visitNameAndType(this);
    }

    @Override
    public String toString() {
        return "CONSTANT_NameAndType_info[name_index: " + name_index + ", type_index: " + type_index + "]";
    }

    public final int name_index;
    public final int type_index;
}