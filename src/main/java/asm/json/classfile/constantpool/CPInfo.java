/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CPInfo.java 2018-04-06 18:22 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;


public  abstract class CPInfo {
    /*
    cp_info {
        u1 tag;
        u1 info[];
    }

    * */
    CPInfo() {
        this.cp = null;
    }

    CPInfo(ConstantPool cp) {
        this.cp = cp;
    }

    public abstract int getTag();

    /** The number of slots in the constant pool used by this entry.
     * 2 for CONSTANT_Double and CONSTANT_Long; 1 for everything else. */
    public int size() {
        return 1;
    }

    public abstract int byteLength();

    public abstract void accept(CPVisitor visitor);

    protected final ConstantPool cp;
}