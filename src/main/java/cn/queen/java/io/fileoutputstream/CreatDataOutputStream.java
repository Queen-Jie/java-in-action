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
 * Create DataOutputStream from FileOutputStream
 * 通过文件输出流创建数据输出流
 */
import java.io.*;

public class CreatDataOutputStream {
	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("d:/demo.txt");

		DataOutputStream dos = new DataOutputStream(fos);
		//new DataOutputStream()创建一个新的数据输出流写入数据到指定的基础输出流。
		fos.close();
		dos.close();
	}

}
