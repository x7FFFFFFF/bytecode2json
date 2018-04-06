/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_MethodType_info.java 2018-04-06 18:31 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public class CONSTANT_MethodType_info extends CPInfo {
    CONSTANT_MethodType_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        descriptor_index = cr.readUnsignedShort();
    }

    public CONSTANT_MethodType_info(ConstantPool cp, int signature_index) {
        super(cp);
        this.descriptor_index = signature_index;
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

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitMethodType(this, data);
    }

    public String getType() throws ConstantPoolException {
        return cp.getUTF8Value(descriptor_index);
    }

    public final int descriptor_index;
}