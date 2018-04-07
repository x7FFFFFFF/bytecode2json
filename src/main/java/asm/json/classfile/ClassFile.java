/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ClassFile.java 2018-04-06 18:01 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;



import java.io.IOException;
import java.io.InputStream;

public class ClassFile {
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

    public ClassFile(ClassReader reader) throws IOException, ConstantPoolException {
        ClassReader cr = reader;
        magic = cr.readInt();
        minor_version = cr.readUnsignedShort();
        major_version = cr.readUnsignedShort();
        constant_pool = new ConstantPool(cr);
        access_flags = new AccessFlags(cr);
        this_class = cr.readUnsignedShort();
        super_class = cr.readUnsignedShort();

        int interfaces_count = cr.readUnsignedShort();
        interfaces = new int[interfaces_count];
        for (int i = 0; i < interfaces_count; i++)
            interfaces[i] = cr.readUnsignedShort();

        int fields_count = cr.readUnsignedShort();
        /*fields = new Field[fields_count];
        for (int i = 0; i < fields_count; i++)
            fields[i] = new Field(cr);

        int methods_count = cr.readUnsignedShort();
        methods = new Method[methods_count];
        for (int i = 0; i < methods_count; i++)
            methods[i] = new Method(cr);

        attributes = new Attributes(cr);*/

    }

    public  int magic;
    public  int minor_version;
    public  int major_version;
    public ConstantPool constant_pool;
    public  AccessFlags access_flags;
    public  int this_class;
    public  int super_class;
    public  int[] interfaces;
    public  Field[] fields;
    public  Method[] methods;
    public  Attributes attributes;


}