/*****************************************************************
 *
 *
 *
 * $Id: SimpleInterfacesVisitor.java 2018-04-11 11:07 paramonov $
 *****************************************************************/
package asm.json.common;

import asm.json.classfile.InterfacesVisitor;
import asm.json.common.printer.ILinePrinter;


public class SimpleInterfacesVisitor extends SimpleArrayVisitor implements InterfacesVisitor {
    public SimpleInterfacesVisitor(ILinePrinter printer) {
        super(printer, "interfaces");
    }

    @Override
    public void visitInterface(int interf) {
        printer.printlnf("%d,", interf);
    }
}