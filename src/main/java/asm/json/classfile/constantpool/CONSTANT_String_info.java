/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_String_info.java 2018-04-06 18:29 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public  class CONSTANT_String_info extends CPInfo {
    CONSTANT_String_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        string_index = cr.readUnsignedShort();
    }

    public CONSTANT_String_info(ConstantPool cp, int string_index) {
        super(cp);
        this.string_index = string_index;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_String;
    }

    public int byteLength() {
        return 3;
    }

    public String getString() throws ConstantPoolException {
        return cp.getUTF8Value(string_index);
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitString(this, data);
    }

    @Override
    public String toString() {
        return "CONSTANT_String_info[class_index: " + string_index + "]";
    }

    public final int string_index;
}