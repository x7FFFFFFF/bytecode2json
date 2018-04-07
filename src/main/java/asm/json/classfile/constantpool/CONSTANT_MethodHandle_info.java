/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_MethodHandle_info.java 2018-04-06 18:37 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public  class CONSTANT_MethodHandle_info extends CPInfo {
    CONSTANT_MethodHandle_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        reference_kind =  RefKind.getRefkind(cr.readUnsignedByte());
        reference_index = cr.readUnsignedShort();
    }

    public CONSTANT_MethodHandle_info(ConstantPool cp, RefKind ref_kind, int member_index) {
        super(cp);
        this.reference_kind = ref_kind;
        this.reference_index = member_index;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_MethodHandle;
    }

    public int byteLength() {
        return 4;
    }

    @Override
    public String toString() {
        return "CONSTANT_MethodHandle_info[ref_kind: " + reference_kind + ", member_index: " + reference_index + "]";
    }

    public void accept(CPVisitor visitor) {
        visitor.visitMethodHandle(this);
    }

    public CPRefInfo getCPRefInfo() throws ConstantPoolException {
        int expected = CPInfoTypes.CONSTANT_Methodref;
        int actual = cp.get(reference_index).getTag();
        // allow these tag types also:
        switch (actual) {
            case CPInfoTypes.CONSTANT_Fieldref:
            case CPInfoTypes.CONSTANT_InterfaceMethodref:
                expected = actual;
        }
        return (CPRefInfo) cp.get(reference_index, expected);
    }

    public final RefKind reference_kind;
    public final int reference_index;
}