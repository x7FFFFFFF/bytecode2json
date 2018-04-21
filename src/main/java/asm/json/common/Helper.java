/*****************************************************************
 *
 *
 *
 * $Id: Helper.java 2018-04-09 10:28 paramonov $
 *****************************************************************/
package asm.json.common;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Helper {

    public static Class[] getClasses(String packageName,  Class<? extends Annotation> annotationClass)          {
        ArrayList<Class> classes = new ArrayList<>();
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

            assert classLoader != null;

            String path = packageName.replace('.', '/');

            Enumeration<URL>  resources = classLoader.getResources(path);

            List<File> dirs = new ArrayList<>();

            while (resources.hasMoreElements()) {

                URL resource = resources.nextElement();

                dirs.add(new File(resource.getFile()));

            }



            for (File directory : dirs) {

                classes.addAll(findClasses(directory, packageName, annotationClass));

            }


        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
        return classes.toArray(new Class[classes.size()]);

    }

    private static List<Class> findClasses(File directory, String packageName, Class<? extends Annotation> annotationClass) throws ClassNotFoundException {
        List<Class> classes = new ArrayList<>();
        if (!directory.exists()) {
            return classes;
        }
        File[] files = directory.listFiles();
        for (File file : files) {
         /*   if (file.isDirectory()) {
                assert !file.getName().contains(".");
                classes.addAll(findClasses(file, packageName + "." + file.getName()));
            } else */
           if (file.getName().endsWith(".class")) {
               final Class<?> aClass = Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6));
               if (aClass.isAnnotationPresent(annotationClass)) {
                   classes.add(aClass);
               }
            }
        }
        return classes;
    }


}