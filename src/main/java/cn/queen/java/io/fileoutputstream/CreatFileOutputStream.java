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
package cn.queen.java.io.fileoutputstream;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 23, 2015
 * Create FileOutputStream object from File object
 * 从文件对象中创建文件输出流对象
 * Create FileOutputStream object from String file path
 * 通过文件路径的字符串创建文件输出流对象
 */
import java.io.*;

public class CreatFileOutputStream {
	public static void main(String[] args) throws Exception {
		File f = new File("d:/abc.txt");
		FileOutputStream fos1 = new FileOutputStream(f);
		FileOutputStream fos2 = new FileOutputStream("d:/abc.txt",true);
		fos1.write(10);
		fos2.write(20);
		fos1.close();
		fos2.close();
	}

}
