package asm.json.common;

import asm.json.classfile.attributes.AttributeVisitor;
import asm.json.common.printer.ILinePrinter;

public class SimpleAttributeVisitor extends SimpleArrayVisitor implements AttributeVisitor {


    public SimpleAttributeVisitor(ILinePrinter printer) {
       super(printer, "attributes");
    }
}