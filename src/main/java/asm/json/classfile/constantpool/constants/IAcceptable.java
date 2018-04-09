/*****************************************************************
 * Gridnine AB http://www.gridnine.com
 * Project: BOF VIP-Service
 *
 * $Id: IAcceptable.java 2018-04-09 9:23 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.constantpool.ConstPoolVisitor;

public interface IAcceptable {
    void accept(ConstPoolVisitor visitor);
}