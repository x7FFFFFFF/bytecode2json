/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: CONSTANT_Utf8_info.java 2018-04-06 18:27 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

import asm.json.classfile.ClassReader;
import asm.json.classfile.constantpool.CPInfoTypes;
import asm.json.classfile.constantpool.ConstPoolVisitor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public  class ConstantUtf8Info implements IAcceptable, ICPinfo  {
    public ConstantUtf8Info(ClassReader cr) throws IOException {
        value = cr.readUTF();
    }


    public int getTag() {
        return CPInfoTypes.CONSTANT_Utf8;
    }

    public int byteLength() {
        class SizeOutputStream extends OutputStream {
            @Override
            public void write(int b) {
                size++;
            }
            int size;
        }
        SizeOutputStream sizeOut = new SizeOutputStream();
        DataOutputStream out = new DataOutputStream(sizeOut);
        try { out.writeUTF(value); } catch (IOException ignore) { }
        return 1 + sizeOut.size;
    }

    @Override
    public String toString() {
        if (value.length() < 32 && isPrintableAscii(value))
            return "CONSTANT_Utf8_info[value: \"" + value + "\"]";
        else
            return "CONSTANT_Utf8_info[value: (" + value.length() + " chars)]";
    }

    static boolean isPrintableAscii(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 32 || c >= 127)
                return false;
        }
        return true;
    }

    public void accept(ConstPoolVisitor visitor) {
        visitor.visitUtf8(this);
    }

    public final String value;
}