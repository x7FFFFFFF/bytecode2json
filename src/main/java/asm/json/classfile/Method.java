/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: Method.java 2018-04-06 18:04 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public class Method {
    Method(ClassReader cr) throws IOException {
       /* access_flags = new AccessFlags(cr);
        name_index = cr.readUnsignedShort();
        descriptor = new Descriptor(cr);
        attributes = new Attributes(cr);*/
    }

   /* public Method(AccessFlags access_flags,
                  int name_index, Descriptor descriptor,
                  Attributes attributes) {
        this.access_flags = access_flags;
        this.name_index = name_index;
        this.descriptor = descriptor;
        this.attributes = attributes;
    }

    public int byteLength() {
        return 6 + attributes.byteLength();
    }

    public String getName(ConstantPool constant_pool) throws ConstantPoolException {
        return constant_pool.getUTF8Value(name_index);
    }

    public final AccessFlags access_flags;
    public final int name_index;
    public final Descriptor descriptor;
    public final Attributes attributes;*/
}
