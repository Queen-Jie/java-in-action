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
 * Write double to a file using DataOutputStream
 * 使用数据输出流把double类型的数据写入文件
 */
import java.io.*;

public class WriteDouble {
	public static void main(String[] args) throws Exception {
		String s = "d:/abc.txt";
		FileOutputStream fos = new FileOutputStream(s);
		DataOutputStream dos = new DataOutputStream(fos);
		double d = 1;
		dos.writeDouble(d);
		dos.close();
	}
}