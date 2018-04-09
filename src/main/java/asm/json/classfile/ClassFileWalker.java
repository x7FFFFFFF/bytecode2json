package asm.json.classfile;

import asm.json.classfile.constantpool.ConstPoolVisitor;
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

    @Override
    public Boolean call() throws Exception {
        visitor.visitStart();
        visitor.visitMagic(cr.readInt());
        visitor.visitMinorVersion(cr.readUnsignedShort());
        visitor.visitMajorVersion(cr.readUnsignedShort());

        int constantPoolCount = cr.readUnsignedShort();
        visitor.visitConstantPoolCount(constantPoolCount);

       // ConstantPool constantPool = new ConstantPool(cr);

        final ConstPoolVisitor cpVisitor = visitor.visitConstantPool(constantPoolCount);
        cpVisitor.visitStart();
        final ConstantPoolWalker constantPoolWalker = new ConstantPoolWalker(cr, cpVisitor, constantPoolCount);

        if (!constantPoolWalker.call()) {
            throw new Exception("constantPoolWalker.call()");
        }
        cpVisitor.visitEnd();
        visitor.visitEnd();
        return true;

    }
}
