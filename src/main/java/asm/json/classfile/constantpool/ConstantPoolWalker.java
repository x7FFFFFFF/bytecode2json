/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ConstantPool.java 2018-04-06 18:03 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.constants.ConstantClassInfo;
import asm.json.classfile.constantpool.constants.ConstantDoubleInfo;
import asm.json.classfile.constantpool.constants.ConstantFieldrefInfo;
import asm.json.classfile.constantpool.constants.ConstantFloatInfo;
import asm.json.classfile.constantpool.constants.ConstantIntegerInfo;
import asm.json.classfile.constantpool.constants.ConstantInvokedynamicInfo;
import asm.json.classfile.constantpool.constants.ConstantLongInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodhandleInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodrefInfo;
import asm.json.classfile.constantpool.constants.ConstantMethodtypeInfo;
import asm.json.classfile.constantpool.constants.ConstantNameandtypeInfo;
import asm.json.classfile.constantpool.constants.ConstantStringInfo;
import asm.json.classfile.constantpool.constants.ConstantUtf8Info;
import asm.json.classfile.constantpool.exeptions.InvalidEntry;

import java.util.concurrent.Callable;

public class ConstantPoolWalker implements Callable<Boolean> {

    private final ConstPoolVisitor  visitor;
    private final ClassReader cr;
    private final int count;

    static {
        final Package aPackage = Package.getPackage("asm.json.classfile.constantpool.constants");

    }



    public ConstantPoolWalker( ClassReader cr, ConstPoolVisitor visitor, int count) {
        this.visitor = visitor;
        this.cr = cr;
        this.count = count;
    }





    @Override
    public Boolean call() throws Exception {
        for (int i = 1; i < count; i++) {
            int tag = cr.readUnsignedByte();
            switch (tag) {
                case CPInfoTypes.CONSTANT_Class:
                    new ConstantClassInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Double:
                     new ConstantDoubleInfo(cr).accept(visitor);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_Fieldref:
                     new ConstantFieldrefInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Float:
                     new ConstantFloatInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Integer:
                     new ConstantIntegerInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_InterfaceMethodref:
                     new ConstantIntegerInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_InvokeDynamic:
                     new ConstantInvokedynamicInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Long:
                     new ConstantLongInfo(cr).accept(visitor);
                    i++;
                    break;

                case CPInfoTypes.CONSTANT_MethodHandle:
                     new ConstantMethodhandleInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_MethodType:
                     new ConstantMethodtypeInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Methodref:
                     new ConstantMethodrefInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_NameAndType:
                     new ConstantNameandtypeInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_String:
                     new ConstantStringInfo(cr).accept(visitor);
                    break;

                case CPInfoTypes.CONSTANT_Utf8:
                     new ConstantUtf8Info(cr).accept(visitor);
                    break;

                default:
                    throw new InvalidEntry(i, tag);
            }
        }

        return true;
    }
}