/*****************************************************************
 *
 *
 *
 * $Id: InterfacesVisitor.java 2018-04-11 11:05 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.common.IVisitArray;
import asm.json.common.IVisitElement;

public interface InterfacesVisitor extends IVisitElement, IVisitArray {

    void visitInterface(int interf);
}