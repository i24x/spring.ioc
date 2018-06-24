package com.github.i24x.spring.ioc.bean;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class AppClassLoader extends ClassLoader {

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		Class<?> c = super.findLoadedClass(name);
		if (c == null) {
			File file = new File(getFileName(name));
			if (file.exists()) {
				return this.findClass(name);
			} else {
				return super.loadClass(name);
			}
		} else {
			return c;
		}
	}

   @Override
   public Class<?> findClass(String name) {
      byte[] data = loadClassData(name);
      return this.defineClass(name, data, 0, data.length);
   }

  

   public byte[] loadClassData(String name) {
      try {
        FileInputStream is= new FileInputStream(new File(getFileName(name)));
        ByteArrayOutputStream baos= new ByteArrayOutputStream();
        int b = 0;
        while ((b = is.read()) != -1) {
           baos.write(b);
        }
        return baos.toByteArray();
      } catch(Exception e) {
        e.printStackTrace();
      }
      return null;
   }
   public static String getFileName(String name){
      name = name.replace(".", "//");
      String path= AppClassLoader.getSystemClassLoader().getResource("").getPath();
      System.out.println(path);
      String fileName= path+ name+ ".class";
      return fileName;

   }

	@Override
	protected void finalize() throws Throwable {
		System.out.println("AppClassLoader Destory ......");
		super.finalize();
	}
}
