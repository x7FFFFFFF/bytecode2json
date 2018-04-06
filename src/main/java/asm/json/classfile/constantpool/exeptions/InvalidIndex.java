/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: InvalidIndex.java 2018-04-06 18:48 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.exeptions;

public  class InvalidIndex extends ConstantPoolException {
    private static final long serialVersionUID = -4350294289300939730L;
    public InvalidIndex(int index) {
        super(index);
    }

    @Override
    public String getMessage() {
        // i18n
        return "invalid index #" + index;
    }
}