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

import java.io.InputStreamReader;
import java.io.StringWriter;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 25, 2015
 * Using a Reader and a Writer, returns a String from an InputStream
 * 使用Reader和Writer,从InputStream中返回一个字符串
 * 
 */
import java.io.InputStream;
import java.io.IOException;
import java.io.FileInputStream;

public class UsingReaderWriter {
	public static final byte[] HEXBYTES = { (byte) '0', (byte) '1', (byte) '2',
			(byte) '3', (byte) '4', (byte) '5', (byte) '6', (byte) '7',
			(byte) '8', (byte) '9', (byte) 'a', (byte) 'b', (byte) 'c',
			(byte) 'd', (byte) 'e', (byte) 'f', };
	//hexbytes 十六进制的字节

	public static String inputStreamToString(InputStream x, String encoding)
			throws IOException {
		InputStreamReader in = new InputStreamReader(x, encoding);
		StringWriter writer = new StringWriter();
		int blocksize = 8 * 1024;
		char[] buffer = new char[blocksize];
		for (;;) {
			int read = in.read(buffer);
			if (read == -1) {
				break;
			}
			writer.write(buffer, 0, read);
		}
		writer.close();
		return writer.toString();
	}
	public static void main(String[] args)throws Exception{
		InputStream is = new FileInputStream("f:/file2.txt");
		inputStreamToString(is,"t");
	}
}
