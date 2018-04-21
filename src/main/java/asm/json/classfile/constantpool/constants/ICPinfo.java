/*****************************************************************
 *
 *
 *
 * $Id: ICPinfo.java 2018-04-09 9:24 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool.constants;

public interface ICPinfo extends Comparable<ICPinfo> {
    int getTag();

    int  byteLength();

    default int size() {
        return 1;
    }


    @Override
    default int compareTo(ICPinfo o) {
        return Integer.compare(this.getTag(), o.getTag());
    }
}