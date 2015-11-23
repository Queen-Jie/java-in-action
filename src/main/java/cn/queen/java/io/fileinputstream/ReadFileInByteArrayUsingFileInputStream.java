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
 * @since Nov 18, 2015
 * Read file in byte array using FileInputStream
 */
import java.io.*;

public class ReadFileInByteArrayUsingFileInputStream {
	public void readFile(String path)  {
		File file = new File(path);
		FileInputStream fis=null;
		try {
			fis = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			// file.length() 返回文件的长度
			fis.read(bytes);
			System.out.println(new String(bytes));
			//new String(byte[])---->byte[]转换为String  如果输出的是0-9的数字，可以成功输出。
			//如果是中文，不能成功输出。
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		try {
			fis.close();
		} catch (IOException e) {
		}
	}
}	

	   