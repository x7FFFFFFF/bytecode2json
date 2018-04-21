/*****************************************************************
 *
 *
 *
 * $Id: SimpleFieldsVisitor.java 2018-04-11 11:51 paramonov $
 *****************************************************************/
package asm.json.common;

import asm.json.classfile.FieldsVisitor;
import asm.json.classfile.attributes.AttributeVisitor;
import asm.json.common.printer.ILinePrinter;

public class SimpleFieldsVisitor extends SimpleArrayVisitor implements FieldsVisitor {


    public SimpleFieldsVisitor(ILinePrinter printer) {
        super(printer, "fields");

    }


    @Override
    public void visitAccessFlags(int value) {
        printer.printlnf("access_flags:%s,", Integer.toBinaryString(value));
    }

    @Override
    public void visitNameIndex(int value) {
        printer.printlnf("name_index:%d,", value);
    }

    @Override
    public void visitDescriptorIndex(int value) {
        printer.printlnf("descriptor_index:%d,", value);
    }

    @Override
    public void visitAttributesCount(int value) {
        printer.printlnf("attributes_count:%d,", value);
    }

    @Override
    public AttributeVisitor visitAttributes(int attributesCount) {
        return new SimpleAttributeVisitor(printer);
    }
}