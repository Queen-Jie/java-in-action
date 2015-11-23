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
 * Write byte array to a file using FileOutputStream
 * 通过文件输出流写字节数组到文件中
 */
import java.io.*;

public class WriteByteArray {
	public static void main(String[] args) throws Exception {
		String s1 = "d:/abc.txt";
		FileOutputStream fos = new FileOutputStream(s1);
		String s2 = "write file using java fileoutputstream example!";
		fos.write(s2.getBytes());
		// 对这个字符串进行编码为一个字节序列使用平台的默认字符集,结果存储到一个新的字节数组。
		fos.close();
	}

}
