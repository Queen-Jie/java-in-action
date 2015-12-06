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
 * Testing for end of file while reading a byte at a time
 * 读取一个字节时测试文件结束
 */

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestForFile {
//在控制台抛出异常
	public static void main(String[] args)throws IOException{
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("f:/abc.txt")));
		while(in.available()!=0)
			System.out.print((char)in.readByte());
		in.close();
	}
}

