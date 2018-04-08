package asm.json.common;

import asm.json.classfile.constantpool.*;
import asm.json.common.printer.ILinePrinter;

import java.util.function.Consumer;

/**
 * Created on 07.04.2018.
 */
public class SimpleCPVisitor implements CPVisitor {
    private final ILinePrinter printer;
    private int counter;

    public SimpleCPVisitor(ILinePrinter lp) {
        this.printer = lp;
    }
    /*
      CONSTANT_Class_info {
            u1 tag;
            u2 name_index;
        }
    */
    private <T extends CPInfo> void wrap(T value, Consumer<T> consumer){
        counter++;
        printer.printlnf("%d:{", counter);
        printer.indent(1);
        printer.printlnf("tag:\"%s\",", value.getTag());
        consumer.accept(value);
        printer.indent(-1);
        printer.println("},");
    }

    @Override
    public void visitClass(CONSTANT_Class_info info) {
        wrap(info, i-> printer.printlnf("name_index:%d,", info.name_index));
     }

  /*  CONSTANT_Double_info {
        u1 tag;
        u4 high_bytes;
        u4 low_bytes;
    }*/
    @Override
    public void visitDouble(CONSTANT_Double_info info) {
        wrap(info, i-> printer.printlnf("value:%f,", i.value)); //TODO

    }
 /*   CONSTANT_Fieldref_info {
        u1 tag;
        u2 class_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitFieldref(CONSTANT_Fieldref_info info) {
        wrap(info, i-> {
            printer.printlnf("class_index:%d,", i.class_index);
            printer.printlnf("name_and_type_index:%d,", i.name_and_type_index);
        });

    }
   /* CONSTANT_Float_info {
        u1 tag;
        u4 bytes;
    }*/
    @Override
    public void visitFloat(CONSTANT_Float_info info) {
        wrap(info, i-> printer.printlnf("value:%f,", i.value)); //TODO

    }
 /*   CONSTANT_Integer_info {
        u1 tag;
        u4 bytes;
    }*/
    @Override
    public void visitInteger(CONSTANT_Integer_info info) {
        wrap(info, i-> printer.printlnf("value:%d,", i.value)); //TODO

    }
   /* CONSTANT_InterfaceMethodref_info {
        u1 tag;
        u2 class_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitInterfaceMethodref(CONSTANT_InterfaceMethodref_info info) {
        wrap(info, i-> {
            printer.printlnf("class_index:%d,", i.class_index);
            printer.printlnf("name_and_type_index:%d,", i.name_and_type_index);
        });

    }
  /*  CONSTANT_InvokeDynamic_info {
        u1 tag;
        u2 bootstrap_method_attr_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitInvokeDynamic(CONSTANT_InvokeDynamic_info info) {
        wrap(info, i-> {
            printer.printlnf("bootstrap_method_attr_index:%d,", i.bootstrap_method_attr_index);
            printer.printlnf("name_and_type_index:%d,", i.name_and_type_index);
        });

    }
  /*  CONSTANT_Long_info {
        u1 tag;
        u4 high_bytes;
        u4 low_bytes;
    }*/
    @Override
    public void visitLong(CONSTANT_Long_info info) {
        wrap(info, i-> printer.printlnf("value:%d,", i.value)); //TODO

    }
   /* CONSTANT_NameAndType_info {
        u1 tag;
        u2 name_index;
        u2 descriptor_index;
    }*/
    @Override
    public void visitNameAndType(CONSTANT_NameAndType_info info) {
        wrap(info, i-> {
            printer.printlnf("name_index:%d,", i.name_index);
            printer.printlnf("descriptor_index:%d,", i.type_index);
        });

    }
 /*   CONSTANT_Methodref_info {
        u1 tag;
        u2 class_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitMethodref(CONSTANT_Methodref_info info) {
        wrap(info, i-> {
            printer.printlnf("class_index:%d,", i.class_index);
            printer.printlnf("name_and_type_index:%d,", i.name_and_type_index);
        });

    }
/*    CONSTANT_MethodHandle_info {
        u1 tag;
        u1 reference_kind;
        u2 reference_index;
    }*/
    @Override
    public void visitMethodHandle(CONSTANT_MethodHandle_info info) {
        wrap(info, i-> {
            printer.printlnf("reference_kind:%d,", i.reference_kind);  //TODO
            printer.printlnf("reference_index:%d,", i.reference_index);
        });

    }
  /*  CONSTANT_MethodType_info {
        u1 tag;
        u2 descriptor_index;
    }*/
    @Override
    public void visitMethodType(CONSTANT_MethodType_info info) {
        wrap(info, i-> printer.printlnf("descriptor_index:%d,", i.descriptor_index));

    }
  /*  CONSTANT_String_info {
        u1 tag;
        u2 string_index;
    }*/
    @Override
    public void visitString(CONSTANT_String_info info) {
        wrap(info, i-> printer.printlnf("string_index:%d,", i.string_index));

    }
 /*   CONSTANT_Utf8_info {
        u1 tag;
        u2 length;
        u1 bytes[length];
    }*/
    @Override
    public void visitUtf8(CONSTANT_Utf8_info info) {
        wrap(info, i-> printer.printlnf("value:\"%s\",", i.value));

    }

    @Override
    public void visitStart() {
        printer.println("cp_info:[");
        printer.indent(1);


    }

    @Override
    public void visitEnd() {
        printer.indent(-1);
        printer.println("],");

    }
}
