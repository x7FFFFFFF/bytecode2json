/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: InvalidEntry.java 2018-04-06 18:44 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.exeptions;


public  class InvalidEntry extends ConstantPoolException {
    private static final long serialVersionUID = 1000087545585204447L;
    public InvalidEntry(int index, int tag) {
        super(index);
        this.tag = tag;
    }

    @Override
    public String getMessage() {
        // i18n?
        return "unexpected tag at #" + index + ": " + tag;
    }

    public final int tag;
}