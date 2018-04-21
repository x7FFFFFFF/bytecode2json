/*****************************************************************
 *
 *
 *
 * $Id: PoolConstants.java 2018-04-09 10:18 paramonov $
 *****************************************************************/
package asm.json.classfile.constantpool;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface  PoolConstants {
}