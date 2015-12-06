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
package cn.queen.java.io.file_writer;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 25, 2015
 * Demonstrate FileWriter
 * 展示FileWriter
 */
import java.io.FileWriter;

public class DmonstrateFileWriter {
	public static void main(String[] args) throws Exception {
		String source = "test";
		char[] buffer = new char[source.length()];
		source.getChars(0, source.length(), buffer, 0);
		/*
		 * getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
		 * 字符从这个字符串复制到目标字符数组。
		 * 第一个字符是在复制指数srcBegin;最后一个字符复制指数srcEnd-1(因此被拷贝的字符总数是srcEnd-srcBegin)。
		 * dst是目标数组
		 * int dstBegin 从dsrBegin这个下标开始
		 * The first character to be copied is at index srcBegin; 
		 * the last character to be copied is at index srcEnd-1 (thus the total number of characters to be copied is srcEnd-srcBegin). 
		 * The characters are copied into the subarray of dst starting at index dstBegin and ending at index: 
  		*/
		FileWriter f0 = new FileWriter("f:/file1.txt");
		for (int i = 0; i < buffer.length; i += 2) {
			f0.write(buffer[i]);
		}
		f0.close();
		
		FileWriter f1 = new FileWriter("f:/file2.txt");
		f1.write(buffer);
		f1.close();
		
		FileWriter f2 = new FileWriter("f:/file3.txt");
		f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
		//write(buffer,3,1)
		//从buffer数组的第三个下标开始写入，写入长度是1
		f2.close();
	}
}
//f1:ts  f2:test  :t