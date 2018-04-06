/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: RefKind.java 2018-04-06 18:43 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

public enum RefKind {
    REF_getField(1, "getfield"),
    REF_getStatic(2, "getstatic"),
    REF_putField(3, "putfield"),
    REF_putStatic(4, "putstatic"),
    REF_invokeVirtual(5, "invokevirtual"),
    REF_invokeStatic(6, "invokestatic"),
    REF_invokeSpecial(7, "invokespecial"),
    REF_newInvokeSpecial(8, "newinvokespecial"),
    REF_invokeInterface(9, "invokeinterface");

    public final int tag;
    public final String name;

    RefKind(int tag, String name) {
        this.tag = tag;
        this.name = name;
    }

    static RefKind getRefkind(int tag) {
        switch(tag) {
            case 1:
                return REF_getField;
            case 2:
                return REF_getStatic;
            case 3:
                return REF_putField;
            case 4:
                return REF_putStatic;
            case 5:
                return REF_invokeVirtual;
            case 6:
                return REF_invokeStatic;
            case 7:
                return REF_invokeSpecial;
            case 8:
                return REF_newInvokeSpecial;
            case 9:
                return REF_invokeInterface;
            default:
                return null;
        }
    }
}