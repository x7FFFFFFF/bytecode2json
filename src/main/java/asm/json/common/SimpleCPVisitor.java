package asm.json.common;

import asm.json.classfile.constantpool.*;
import asm.json.common.printer.ILinePrinter;

/**
 * Created on 07.04.2018.
 */
public class SimpleCPVisitor implements CPVisitor {
    final ILinePrinter printer;

    public SimpleCPVisitor(ILinePrinter lp) {
        this.printer = lp;
    }

    @Override
    public void visitClass(CONSTANT_Class_info info) {

    }

    @Override
    public void visitDouble(CONSTANT_Double_info info) {

    }

    @Override
    public void visitFieldref(CONSTANT_Fieldref_info info) {

    }

    @Override
    public void visitFloat(CONSTANT_Float_info info) {

    }

    @Override
    public void visitInteger(CONSTANT_Integer_info info) {

    }

    @Override
    public void visitInterfaceMethodref(CONSTANT_InterfaceMethodref_info info) {

    }

    @Override
    public void visitInvokeDynamic(CONSTANT_InvokeDynamic_info info) {

    }

    @Override
    public void visitLong(CONSTANT_Long_info info) {

    }

    @Override
    public void visitNameAndType(CONSTANT_NameAndType_info info) {

    }

    @Override
    public void visitMethodref(CONSTANT_Methodref_info info) {
        printer.println("CONSTANT_Methodref_info:{");
        printer.indent(1);
        printer.printlnf("tag:%d,", info.tag);
        printer.printlnf("class_index:%d,", info.class_index);
        printer.printlnf("name_and_type_index:%d,", info.name_and_type_index);
        printer.indent(-1);
        printer.println("},");
    }

    @Override
    public void visitMethodHandle(CONSTANT_MethodHandle_info info) {

    }

    @Override
    public void visitMethodType(CONSTANT_MethodType_info info) {

    }

    @Override
    public void visitString(CONSTANT_String_info info) {

    }

    @Override
    public void visitUtf8(CONSTANT_Utf8_info info) {

    }

    @Override
    public void visitStart() {
        printer.println("cp_info:[");
        printer.indent(1);


    }

    @Override
    public void visitEnd() {
        printer.indent(-1);
        printer.println("],");

    }
}
