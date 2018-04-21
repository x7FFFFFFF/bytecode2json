package asm.json.common;

import asm.json.classfile.ClassFileVisitor;
import asm.json.classfile.FieldsVisitor;
import asm.json.classfile.InterfacesVisitor;
import asm.json.classfile.constantpool.ConstPoolVisitor;
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
    public ConstPoolVisitor visitConstantPool(int constantPoolCount) {
        return new SimpleCPVisitor(printer);
    }


    @Override
    public void visitAccessFlags(int accessFlag) {

            printer.printlnf("access_flags:%s,", Integer.toBinaryString(accessFlag));
    }

    @Override
    public void visitThisClass(int thisClass) {
            printer.printlnf("this_class:%d,", thisClass);
    }

    @Override
    public void visitSuperClass(int superClass) {
        printer.printlnf("super_class:%d,", superClass);
    }

    @Override
    public void visitInterfacesCount(int interfacesCount) {
        printer.printlnf("interfaces_count:%d,", interfacesCount);
    }

    @Override
    public InterfacesVisitor visitInterfaces(int interfacesCount) {
        return new SimpleInterfacesVisitor(printer);
    }

    @Override
    public void visitFieldsCount(int fieldsCount) {
        printer.printlnf("fields_count:%d,", fieldsCount);
    }


    @Override
    public FieldsVisitor visitFields() {
        return new SimpleFieldsVisitor(printer);
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
