import asm.json.classfile.ClassFile;
import asm.json.classfile.ClassFileWalker;
import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;
import asm.json.common.SimpleClassFileVisitor;
import asm.json.common.printer.ILinePrinter;
import asm.json.common.printer.LinePrinterBuilder;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;


/**
 * Created on 06.04.2018.
 */
public class ReaderTest {



    @Test
    public void testWalker() throws Exception {
        try( final ClassReader classReader = new ClassReader(ReaderTest.class.getResourceAsStream("Main.class"))) {
            ILinePrinter printer = new LinePrinterBuilder().buildTest();
            final ClassFileWalker classFileWalker = new ClassFileWalker(classReader, new SimpleClassFileVisitor(printer));
            classFileWalker.call();


        }
    }
}
