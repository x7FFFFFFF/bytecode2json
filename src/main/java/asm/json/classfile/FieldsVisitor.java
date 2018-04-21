/*****************************************************************
 *
 *
 *
 * $Id: FieldsVisitor.java 2018-04-11 11:32 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.classfile.attributes.AttributeVisitor;
import asm.json.common.IVisitArray;
import asm.json.common.IVisitElement;

public interface FieldsVisitor extends IVisitElement, IVisitArray {
 /*   field_info {
        u2             access_flags;
        u2             name_index;
        u2             descriptor_index;
        u2             attributes_count;
        attribute_info attributes[attributes_count];
    }
    */
    void visitAccessFlags(int value);
    void visitNameIndex(int value);
    void visitDescriptorIndex(int value);
    void visitAttributesCount(int value);
    AttributeVisitor visitAttributes(int attributesCount);



}