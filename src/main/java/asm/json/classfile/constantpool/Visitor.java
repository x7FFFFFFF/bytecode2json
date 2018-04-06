/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: Visitor.java 2018-04-06 18:25 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

public interface Visitor<R,P> {
    R visitClass(CONSTANT_Class_info info, P p);
    R visitDouble(CONSTANT_Double_info info, P p);
    R visitFieldref(CONSTANT_Fieldref_info info, P p);
    R visitFloat(CONSTANT_Float_info info, P p);
    R visitInteger(CONSTANT_Integer_info info, P p);
    R visitInterfaceMethodref(CONSTANT_InterfaceMethodref_info info, P p);
    R visitInvokeDynamic(CONSTANT_InvokeDynamic_info info, P p);
    R visitLong(CONSTANT_Long_info info, P p);
    R visitNameAndType(CONSTANT_NameAndType_info info, P p);
    R visitMethodref(CONSTANT_Methodref_info info, P p);
    R visitMethodHandle(CONSTANT_MethodHandle_info info, P p);
    R visitMethodType(CONSTANT_MethodType_info info, P p);
    R visitString(CONSTANT_String_info info, P p);
    R visitUtf8(CONSTANT_Utf8_info info, P p);
}