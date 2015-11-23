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
 */
import java.io.*;

public class FileIO {
	public static void main(String args[]) throws Exception {
		FileOutputStream fos = new FileOutputStream("text.txt");
		String s = "This is a test.";
		for (int i = 0; i < s.length(); ++i)
			fos.write(s.charAt(i));
		//charAt()返回字符的值在指定的索引。索引范围从0到长度()- 1。
		//第一个字符值序列的索引0,第二索引1,等等,至于数组索引。
		fos.close();
		FileInputStream fis = new FileInputStream("test.txt");
		int bytes = fis.available();
		//available()返回一个估计的剩余字节数
		System.out.println("fis has" + bytes + "available bytes");
		byte inBuf[] = new byte[bytes];
		int bytesRead = fis.read(inBuf, 0, bytes);
		//读取数据从这个输入流到一个字节数组。
		System.out.println(bytesRead + " bytes were read");
		System.out.println("They are:" + new String(inBuf));
		//new String()构造一个新的字符串解码的字节数组指定使用平台的默认字符集
		fis.close();
		File f = new File("test.txt");
		//创建文件
		f.delete();
	}

}
