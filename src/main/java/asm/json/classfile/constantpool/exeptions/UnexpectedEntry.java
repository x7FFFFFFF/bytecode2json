/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: UnexpectedEntry.java 2018-04-06 18:47 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.exeptions;

public  class UnexpectedEntry extends ConstantPoolException {
    private static final long serialVersionUID = 6986335935377933211L;
    public UnexpectedEntry(int index, int expected_tag, int found_tag) {
        super(index);
        this.expected_tag = expected_tag;
        this.found_tag = found_tag;
    }

    @Override
    public String getMessage() {
        // i18n?
        return "unexpected entry at #" + index + " -- expected tag " + expected_tag + ", found " + found_tag;
    }

    public final int expected_tag;
    public final int found_tag;
}