/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ClassFile.java 2018-04-06 18:01 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.classfile.attributes.Attributes;
import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;



import java.io.IOException;

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

    public ClassFile() throws IOException, ConstantPoolException {


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
    public Attributes attributes;


}