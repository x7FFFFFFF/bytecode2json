/*****************************************************************
 *
 *
 *
 * $Id: AttributesWalker.java 2018-04-11 12:06 paramonov $
 *****************************************************************/
package asm.json.classfile.attributes;

import asm.json.classfile.ClassReader;

import java.util.concurrent.Callable;

public class AttributesWalker implements Callable<Boolean> {
    private final ClassReader reader;
    private final AttributeVisitor visitor;
    private final int attributesCount;
   // private final ConstantPool constantPool;

    public AttributesWalker(ClassReader cr, AttributeVisitor attrVisitor, int attributesCount) {
        reader = cr;
        visitor = attrVisitor;
        this.attributesCount = attributesCount;
        //this.constantPool = constantPool;
    }

    @Override
    public Boolean call() throws Exception {
        for (int i = 0; i < attributesCount; i++) {
            int attributeNameIndex = reader.readUnsignedShort();
            System.out.println("attributeNameIndex = " + attributeNameIndex);
        }
        return true;
    }
}