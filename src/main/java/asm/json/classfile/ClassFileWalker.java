package asm.json.classfile;

import asm.json.classfile.constantpool.CPVisitor;
import asm.json.classfile.constantpool.ConstantPool;

import java.io.InputStream;
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
        ConstantPool constantPool = new ConstantPool(cr);
        visitor.visitConstantPoolCount(constantPool.size());
        final CPVisitor cpVisitor = visitor.visitConstantPool(constantPool);
        cpVisitor.visitStart();
        constantPool.entries().forEach(e->e.accept(cpVisitor));
        cpVisitor.visitEnd();
        visitor.visitEnd();
        return true;

    }
}
