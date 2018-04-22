package asm.json.classfile.constantpool;

import asm.json.classfile.constantpool.constants.ConstantUtf8Info;
import asm.json.classfile.constantpool.constants.ICPinfo;
import asm.json.classfile.constantpool.exeptions.InvalidIndex;
import asm.json.classfile.constantpool.exeptions.UnexpectedEntry;

/**
 * Created on 22.04.2018.
 */
public class ConstantPool {

    private final  ICPinfo[]  cpInfo;
    private final int count;

    public ConstantPool(int count) {
        this.count = count;
        this.cpInfo = new ICPinfo[count-1];

    }

    public String getUTF8Value(int attribute_name_index) throws UnexpectedEntry, InvalidIndex {
        return ((ConstantUtf8Info)get(attribute_name_index, CPInfoTypes.CONSTANT_Utf8)).value;
    }

    public void set(int index, ICPinfo value) {
         cpInfo[index] = value;
    }

    public ICPinfo get(int index){
        return cpInfo[index];
    }

    private ICPinfo get(int index, int expected_type) throws InvalidIndex, UnexpectedEntry {
        checkRange(index);
        ICPinfo info = get(index);
        if (info.getTag() != expected_type)
            throw new UnexpectedEntry(index, expected_type, info.getTag());
        return info;
    }

    private void checkRange(int index) throws InvalidIndex {
        if (index<0  || index > count){
            throw new InvalidIndex(index);
        }
    }
}
