/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Class_info.java 2018-04-06 18:36 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;

import java.io.IOException;

public class CONSTANT_Class_info extends CPInfo {
    CONSTANT_Class_info(ConstantPool cp, ClassReader cr) throws IOException {
        super(cp);
        name_index = cr.readUnsignedShort();
    }

    public CONSTANT_Class_info(ConstantPool cp, int name_index) {
        super(cp);
        this.name_index = name_index;
    }

    public int getTag() {
        return CPInfoTypes.CONSTANT_Class;
    }

    public int  byteLength() {
        return 3;
    }

    /**
     * Get the raw value of the class referenced by this constant pool entry.
     * This will either be the name of the class, in internal form, or a
     * descriptor for an array class.
     * @return the raw value of the class
     */
    public String getName() throws ConstantPoolException {
        return cp.getUTF8Value(name_index);
    }

    /**
     * If this constant pool entry identifies either a class or interface type,
     * or a possibly multi-dimensional array of a class of interface type,
     * return the name of the class or interface in internal form. Otherwise,
     * (i.e. if this is a possibly multi-dimensional array of a primitive type),
     * return null.
     * @return the base class or interface name
     */
    public String getBaseName() throws ConstantPoolException {
        String name = getName();
        if (name.startsWith("[")) {
            int index = name.indexOf("[L");
            if (index == -1)
                return null;
            return name.substring(index + 2, name.length() - 1);
        } else
            return name;
    }

    public int getDimensionCount() throws ConstantPoolException {
        String name = getName();
        int count = 0;
        while (name.charAt(count) == '[')
            count++;
        return count;
    }

    @Override
    public String toString() {
        return "CONSTANT_Class_info[name_index: " + name_index + "]";
    }

    public <R, D> R accept(Visitor<R, D> visitor, D data) {
        return visitor.visitClass(this, data);
    }

    public final int name_index;
}
