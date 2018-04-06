/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: EntryNotFound.java 2018-04-06 18:48 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.exeptions;

public  class EntryNotFound extends ConstantPoolException {
    private static final long serialVersionUID = 2885537606468581850L;
    public EntryNotFound(Object value) {
        super(-1);
        this.value = value;
    }

    @Override
    public String getMessage() {
        // i18n?
        return "value not found: " + value;
    }

    public final Object value;
}