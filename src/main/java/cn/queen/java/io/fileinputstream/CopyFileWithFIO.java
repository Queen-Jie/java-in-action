/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.queen.java.io.fileinputstream;


/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 17, 2015
 */
import java.io.*;

public class CopyFileWithFIO {

	  public void copy(String from_name, String to_name) throws IOException {
	    File from_file = new File(from_name); 
	    File to_file = new File(to_name);
	    //原始文件不存在
	    if (!from_file.exists())
	      abort("no such source file: " + from_name);
	    //抛出异常的一个方法
	    //原始文件是一个文件夹
	    if (!from_file.isFile())
	      abort("can't copy directory: " + from_name);
	    //原始文件不能读取
	    if (!from_file.canRead())
	      abort("source file is unreadable: " + from_name);

	    //目的文件是一个文件夹，就在此文件夹里创建一个文件，名字同原始文件
	    if (to_file.isDirectory())
	      to_file = new File(to_file, from_file.getName());
	    //目的文件存在
	    if (to_file.exists()) {
	    	//目的文件不能写
	      if (!to_file.canWrite())
	        abort("destination file is unwriteable: " + to_name);
	      // 询问是否重写文件
	      System.out.print("Overwrite existing file " + to_file.getName() + "? (Y/N): ");
	      System.out.flush();
	      // 得到用户的回答
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      String response = in.readLine();
	      // 核对用户的答案，如果是大小写的y，则抛出存在的文件不重写的异常
	      if (!response.equals("Y") && !response.equals("y"))
	        abort("existing file was not overwritten.");
	    } else {
	      String parent = to_file.getParent(); 
	      if (parent == null) 
	        parent = System.getProperty("user.dir");
	      File dir = new File(parent); 
	      if (!dir.exists())
	        abort("destination directory doesn't exist: " + parent);
	      if (dir.isFile())
	        abort("destination is not a directory: " + parent);
	      if (!dir.canWrite())
	        abort("destination directory is unwriteable: " + parent);
	    }

	    FileInputStream from = null; 
	    FileOutputStream to = null; 
	    try {
	      from = new FileInputStream(from_file); 
	      to = new FileOutputStream(to_file); 
	      byte[] buffer = new byte[4096]; 
	      int bytes_read; 

	      while ((bytes_read = from.read(buffer)) != -1)
	        to.write(buffer, 0, bytes_read); // write
	    }
	    finally {
	      if (from != null)
	        try {
	          from.close();
	        } catch (IOException e) {
	          ;
	        }
	      if (to != null)
	        try {
	          to.close();
	        } catch (IOException e) {
	          ;
	        }
	    }
	  }
	  //声明一个异常的方法
	  private static void abort(String msg) throws IOException {
	    throw new IOException("FileCopy: " + msg);
	  }
	}

	   

