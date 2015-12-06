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
package cn.queen.java.io.file_reader;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 28, 2015
 * Read a file containing an offset, and a String at that offset
 * 读取一个包含一个偏移量的文件,在那个偏移量的位置是一个字符串
 */
import java.io.RandomAccessFile;
import java.io.IOException;

public class Read_A_File {
	final static String FILENAME = "f:/file.txt";
	protected String fileName;
	protected RandomAccessFile seeker;

	public static void main(String[] argv) throws IOException {
		Read_A_File r = new Read_A_File(FILENAME);
		System.out.println("Offset is " + r.readOffset());
		System.out.println("Message is \"" + r.readMessage() + "\".");
	}

	// 构造器
	public Read_A_File(String fname) throws IOException {
		fileName = fname;
		seeker = new RandomAccessFile(fname, "r");
	}

	// 读取偏移量的属性，在文件中0的位置被定义
	public int readOffset() throws IOException {
		seeker.seek(0);// 移动到每一个开始
		return seeker.readInt();// 读取偏移量
	}

	// 在被定义偏移量的位置读取信息
	public String readMessage() throws IOException {
		seeker.seek(readOffset());// 移到偏移量
		return seeker.readLine();// 读取字符串
	}
}
