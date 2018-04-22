package asm.json.classfile;

import asm.json.classfile.attributes.AttributeVisitor;
import asm.json.classfile.attributes.AttributesWalker;
import asm.json.classfile.constantpool.ConstPoolVisitor;
import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.ConstantPoolWalker;

import java.util.concurrent.Callable;

/**
 * Created on 07.04.2018.
 */
public class ClassFileWalker implements Callable<Boolean> {
    private  final ClassReader cr;
    private  final ClassFileVisitor visitor;
    public ClassFileWalker(ClassReader cr, ClassFileVisitor visitor) {
        this.cr = cr;
        this.visitor = visitor;
    }
    /*
    ClassFile {
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
    }


    */

    @Override
    public Boolean call() throws Exception {
        visitor.visitStart();
        visitor.visitMagic(cr.readInt());
        visitor.visitMinorVersion(cr.readUnsignedShort());
        visitor.visitMajorVersion(cr.readUnsignedShort());

        int constantPoolCount = cr.readUnsignedShort();
        visitor.visitConstantPoolCount(constantPoolCount);

       // ConstantPool constantPool = new ConstantPool(cr);
        //ConstantPool constantPool = new ConstantPool(cr);  //FIXME
        final ConstPoolVisitor cpVisitor = visitor.visitConstantPool(constantPoolCount);
        cpVisitor.visitStart();
        final ConstantPoolWalker constantPoolWalker = new ConstantPoolWalker(cr, cpVisitor, constantPoolCount);

        final ConstantPool constantPool = constantPoolWalker.call();

        cpVisitor.visitEnd();

        visitor.visitAccessFlags(cr.readUnsignedShort());
        visitor.visitThisClass(cr.readUnsignedShort());
        visitor.visitSuperClass(cr.readUnsignedShort());
        final int interfacesCount = cr.readUnsignedShort();
        visitor.visitInterfacesCount(interfacesCount);
        final InterfacesVisitor interfacesVisitor = visitor.visitInterfaces(interfacesCount);
        interfacesVisitor.visitStartArray();
        for (int i = 0; i < interfacesCount; i++) {
            interfacesVisitor.visitStart();
            interfacesVisitor.visitInterface(cr.readUnsignedShort());
            interfacesVisitor.visitEnd();
        }
        interfacesVisitor.visitEndArray();
        final int fieldsCount = cr.readUnsignedShort();
        visitor.visitFieldsCount(fieldsCount);
        final FieldsVisitor fieldsVisitor = visitor.visitFields();
        fieldsVisitor.visitStartArray();
        for (int i = 0; i < fieldsCount; i++) {
            fieldsVisitor.visitStart();
            fieldsVisitor.visitAccessFlags(cr.readUnsignedShort());
            fieldsVisitor.visitNameIndex(cr.readUnsignedShort());
            fieldsVisitor.visitDescriptorIndex(cr.readUnsignedShort());
            final int attributesCount = cr.readUnsignedShort();
            fieldsVisitor.visitAttributesCount(attributesCount);
            final AttributeVisitor attributeVisitor = fieldsVisitor.visitAttributes(attributesCount);
            final AttributesWalker attributesWalker = new AttributesWalker(cr, attributeVisitor, attributesCount);
            if (!attributesWalker.call()) {
                throw new Exception("attributesWalker.call()");
            }
            fieldsVisitor.visitEnd();
        }
        fieldsVisitor.visitEndArray();



        visitor.visitEnd();
        return true;

    }
}
