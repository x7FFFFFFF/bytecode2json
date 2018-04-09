/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CPVisitor.java 2018-04-06 18:25 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.constantpool.constants.ConstantClassInfo;
import asm.json.classfile.constantpool.constants.ConstantDoubleInfo;
import asm.json.classfile.constantpool.constants.ConstantFieldrefInfo;
import asm.json.classfile.constantpool.constants.ConstantFloatInfo;
import asm.json.classfile.constantpool.constants.ConstantIntegerInfo;
import asm.json.classfile.constantpool.constants.ConstantInterfacemethodrefInfo;
import asm.json.classfile.constantpool.constants.ConstantInvokedynamicInfo;
import asm.json.classfile.constantpool.constants.ConstantLongInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodhandleInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodrefInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodtypeInfo;
import asm.json.classfile.constantpool.constants.ConstantNameandtypeInfo;
import asm.json.classfile.constantpool.constants.ConstantStringInfo;
import asm.json.classfile.constantpool.constants.ConstantUtf8Info;
import asm.json.common.IVisitElement;

public interface ConstPoolVisitor extends IVisitElement {
    void visitClass(ConstantClassInfo info);
    void visitDouble(ConstantDoubleInfo info);
    void visitFieldref(ConstantFieldrefInfo info);
    void visitFloat(ConstantFloatInfo info);
    void visitInteger(ConstantIntegerInfo info);
    void visitInterfaceMethodref(ConstantInterfacemethodrefInfo info);
    void visitInvokeDynamic(ConstantInvokedynamicInfo info);
    void visitLong(ConstantLongInfo info);
    void visitNameAndType(ConstantNameandtypeInfo info);
    void visitMethodref(ConstantMethodrefInfo info);
    void visitMethodHandle(ConstantMethodhandleInfo info);
    void visitMethodType(ConstantMethodtypeInfo info);
    void visitString(ConstantStringInfo info);
    void visitUtf8(ConstantUtf8Info info);
}