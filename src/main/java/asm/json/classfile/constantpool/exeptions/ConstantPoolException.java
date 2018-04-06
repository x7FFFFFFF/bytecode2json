/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ConstantPoolException.java 2018-04-06 18:30 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.exeptions;

public class ConstantPoolException extends Exception {

    private static final long serialVersionUID = -2324397349644754565L;
    ConstantPoolException(int index) {
        this.index = index;
    }

    public final int index;
}