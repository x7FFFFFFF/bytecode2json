package asm.json.common;

import asm.json.classfile.constantpool.ConstPoolVisitor;
import asm.json.classfile.constantpool.constants.*;
import asm.json.common.printer.ILinePrinter;

import java.util.function.Consumer;

/**
 * Created on 07.04.2018.
 */
public class SimpleCPVisitor implements ConstPoolVisitor {
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
    private <T extends ICPinfo> void wrap(T value, Consumer<T> consumer){
        counter++;
        printer.printlnf("%d:{", counter);
        printer.indent(1);
        printer.printlnf("tag:\"%s\",", value.getTag());
        consumer.accept(value);
        printer.indent(-1);
        printer.println("},");
    }

    @Override
    public void visitClass(ConstantClassInfo info) {
        wrap(info, i-> printer.printlnf("name_index:%d,", info.name_index));
     }

  /*  CONSTANT_Double_info {
        u1 tag;
        u4 high_bytes;
        u4 low_bytes;
    }*/
    @Override
    public void visitDouble(ConstantDoubleInfo info) {
        wrap(info, i-> printer.printlnf("value:%f,", i.value)); //TODO

    }
 /*   CONSTANT_Fieldref_info {
        u1 tag;
        u2 class_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitFieldref(ConstantFieldrefInfo info) {
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
    public void visitFloat(ConstantFloatInfo info) {
        wrap(info, i-> printer.printlnf("value:%f,", i.value)); //TODO

    }
 /*   CONSTANT_Integer_info {
        u1 tag;
        u4 bytes;
    }*/
    @Override
    public void visitInteger(ConstantIntegerInfo info) {
        wrap(info, i-> printer.printlnf("value:%d,", i.value)); //TODO

    }
   /* CONSTANT_InterfaceMethodref_info {
        u1 tag;
        u2 class_index;
        u2 name_and_type_index;
    }*/
    @Override
    public void visitInterfaceMethodref(ConstantInterfacemethodrefInfo info) {
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
    public void visitInvokeDynamic(ConstantInvokedynamicInfo info) {
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
    public void visitLong(ConstantLongInfo info) {
        wrap(info, i-> printer.printlnf("value:%d,", i.value)); //TODO

    }
   /* CONSTANT_NameAndType_info {
        u1 tag;
        u2 name_index;
        u2 descriptor_index;
    }*/
    @Override
    public void visitNameAndType(ConstantNameandtypeInfo info) {
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
    public void visitMethodref(ConstantMethodrefInfo info) {
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
    public void visitMethodHandle(ConstantMethodhandleInfo info) {
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
    public void visitMethodType(ConstantMethodtypeInfo info) {
        wrap(info, i-> printer.printlnf("descriptor_index:%d,", i.descriptor_index));

    }
  /*  CONSTANT_String_info {
        u1 tag;
        u2 string_index;
    }*/
    @Override
    public void visitString(ConstantStringInfo info) {
        wrap(info, i-> printer.printlnf("string_index:%d,", i.string_index));

    }
 /*   CONSTANT_Utf8_info {
        u1 tag;
        u2 length;
        u1 bytes[length];
    }*/
    @Override
    public void visitUtf8(ConstantUtf8Info info) {
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
