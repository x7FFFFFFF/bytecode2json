/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CPVisitor.java 2018-04-06 18:25 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.common.IVisitElement;

public interface CPVisitor extends IVisitElement {
    void visitClass(CONSTANT_Class_info info);
    void visitDouble(CONSTANT_Double_info info);
    void visitFieldref(CONSTANT_Fieldref_info info);
    void visitFloat(CONSTANT_Float_info info);
    void visitInteger(CONSTANT_Integer_info info);
    void visitInterfaceMethodref(CONSTANT_InterfaceMethodref_info info);
    void visitInvokeDynamic(CONSTANT_InvokeDynamic_info info);
    void visitLong(CONSTANT_Long_info info);
    void visitNameAndType(CONSTANT_NameAndType_info info);
    void visitMethodref(CONSTANT_Methodref_info info);
    void visitMethodHandle(CONSTANT_MethodHandle_info info);
    void visitMethodType(CONSTANT_MethodType_info info);
    void visitString(CONSTANT_String_info info);
    void visitUtf8(CONSTANT_Utf8_info info);
}