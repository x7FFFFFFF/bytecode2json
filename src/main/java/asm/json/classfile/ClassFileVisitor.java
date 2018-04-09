package asm.json.classfile;

import asm.json.classfile.constantpool.ConstPoolVisitor;
import asm.json.common.IVisitElement;

/**
 * Created on 07.04.2018.
 */
public interface ClassFileVisitor  extends IVisitElement{
    /*ClassFile {
    u4             magic;
    u2             minor_version;
    u2             major_version;
    u2             constant_pool_count;
    cp_info        constant_pool[constant_pool_count-1];
    u2             access_flags;
    u2             this_class;
    u2             super_class;
    u2             interfaces_count;
    u2             interfaces[interfaces_count];
    u2             fields_count;
    field_info     fields[fields_count];
    u2             methods_count;
    method_info    methods[methods_count];
    u2             attributes_count;
    attribute_info attributes[attributes_count];
}*/

    void visitMagic(int magic);
    void visitMinorVersion(int minorVersion);
    void visitMajorVersion(int majorVersion);
    void visitConstantPoolCount(int count);
    ConstPoolVisitor visitConstantPool(int constantPoolCount);


}
