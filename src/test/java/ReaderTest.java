import asm.json.classfile.ClassFile;
import asm.json.classfile.constantpool.ConstantPool;
import asm.json.classfile.constantpool.exeptions.ConstantPoolException;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;


/**
 * Created on 06.04.2018.
 */
public class ReaderTest {

    @Test
    public void test() throws IOException, ConstantPoolException {
        final InputStream inputStream = ReaderTest.class.getResourceAsStream("Main.class");
        final ClassFile classFile = new ClassFile(inputStream);
        final ConstantPool constantPool = classFile.constant_pool;
        assertEquals(48, constantPool.size());


    }
}
