/*****************************************************************
 *
 * Project: asm.json
 *
 * $Id: ClassReader.java 2018-04-06 18:16 paramonov $
 *****************************************************************/
package asm.json.classfile;

import asm.json.classfile.attributes.Attribute;

import java.io.*;

public class ClassReader  implements AutoCloseable{

    private  final DataInputStream in;

    public ClassReader(InputStream in) {
        this.in = new DataInputStream(new BufferedInputStream(in));
    }

    public void close() throws Exception {
        in.close();
    }


    public void readFully(byte[] b) throws IOException {
        in.readFully(b);
    }

    public int readUnsignedByte() throws IOException {
        return in.readUnsignedByte();
    }

    public int readUnsignedShort() throws IOException {
        return in.readUnsignedShort();
    }

    public int readInt() throws IOException {
        return in.readInt();
    }

    public long readLong() throws IOException {
        return in.readLong();
    }

    public float readFloat() throws IOException {
        return in.readFloat();
    }

    public double readDouble() throws IOException {
        return in.readDouble();
    }

    public String readUTF() throws IOException {
        return in.readUTF();
    }

 /*   public Attribute readAttribute() throws IOException {
        int name_index = readUnsignedShort();
        int length = readInt();
        byte[] data = new byte[length];
        readFully(data);

        DataInputStream prev = in;
        in = new DataInputStream(new ByteArrayInputStream(data));
        try {
            return attributeFactory.createAttribute(this, name_index, data);
        } finally {
            in = prev;
        }
    }*/
}