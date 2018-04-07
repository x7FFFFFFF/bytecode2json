package asm.json.common;

import asm.json.classfile.ClassFileVisitor;
import asm.json.classfile.constantpool.CPVisitor;
import asm.json.classfile.constantpool.ConstantPool;
import asm.json.common.printer.ILinePrinter;

/**
 * Created on 07.04.2018.
 */
public class SimpleClassFileVisitor implements ClassFileVisitor{
    final ILinePrinter printer;

    public SimpleClassFileVisitor(ILinePrinter lp) {
        this.printer = lp;
    }

    @Override
    public void visitMagic(int magic) {
        printer.printlnf("magic:%d,", magic );
    }

    @Override
    public void visitMinorVersion(int minorVersion) {
        printer.printlnf("minor_version:%d,", minorVersion );

    }

    @Override
    public void visitMajorVersion(int majorVersion) {
        printer.printlnf("major_version:%d,", majorVersion );

    }

    @Override
    public void visitConstantPoolCount(int count) {
        printer.printlnf("constant_pool_count:%d,", count );
    }

    @Override
    public CPVisitor visitConstantPool(ConstantPool constantPool) {
        return new SimpleCPVisitor(printer);
    }

    @Override
    public void visitStart() {
        printer.println("ClassFile:{");
        printer.indent(1);
    }

    @Override
    public void visitEnd() {
        printer.indent(-1);
        printer.println("}");
    }
}
