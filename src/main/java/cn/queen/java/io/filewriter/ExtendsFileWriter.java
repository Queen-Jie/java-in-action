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
package cn.queen.java.io.filewriter;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 24, 2015
 * extends FilterWriter and extends FilterReader
 * 扩展FileWriter和FilterReader
 * filter过滤器
 */
/*import java.io.FileWriter;
import java.io.FileReader;
import java.io.FilterWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;*/
import java.io.*;
public class ExtendsFileWriter {
	public static void main(String[] args) throws Exception {
		CountReader cr = new CountReader(new FileReader("d:/abc.txt"), '人');
		// CountReader(read in, char lookFor)
		CountWriter cw = new CountWriter(new FileWriter("f:/abc.txt"), '人');
		// CountWriter(write in, char lookFor)
		int c = 0;
		while ((c = cr.read()) != -1) {
			cw.write(c);
		}
		System.out.println(cr.getCount());
		System.out.println(cw.getCount());
		cr.close();
		cw.close();
	}
}

class CountWriter extends FilterWriter {
	private int count = 0;
	private char lookFor = 0;

	public CountWriter(Writer in, char lookFor) {
		super(in);
		this.lookFor = lookFor;
	}

	public void write(int character) throws IOException {
		super.write(character);
		if ((char) character == lookFor) {
			count++;
		}
	}

	public void write(char[] cbuf) throws IOException {
		super.write(cbuf);
		int length = cbuf.length;
		for (int i = 0; i < length; i++) {
			if (cbuf[i] == lookFor) {
				count++;
			}
		}
	}

	public void write(char[] cbuf, int off, int len) throws IOException {
		super.write(cbuf, off, len);
		int length = cbuf.length;
		for (int i = 0; i < length; i++) {
			if (cbuf[i] == lookFor) {
				count++;
			}
		}
	}

	public void write(String str) throws IOException {
		super.write(str);
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == lookFor) {
				count++;
			}
		}
	}

	public void write(String str, int off, int len) throws IOException {
		super.write(str, off, len);
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if (str.charAt(i) == lookFor) {
				count++;
			}
		}
	}

	public int getCount() {
		return count;
	}
}
	class CountReader extends FilterReader {
		private int count = 0;
		private char lookFor = 0;

		public CountReader(Reader in, char lookFor) {
			super(in);
			this.lookFor = lookFor;
		}

		public int read() throws IOException {
			int character = super.read();
			if ((char) character == lookFor) {
				count++;
			}
			return character;
		}
	

		public int read(char[] cbuf) throws IOException {
			int numChars = super.read(cbuf);
			int length = cbuf.length;
			for (int i = 0; i < length; i++) {
				if (cbuf[i] == lookFor) {
					count++;
				}
			}
			return numChars;
		}

		public int read(char[] cbuf, int off, int len) throws IOException {
			int numChars = super.read(cbuf, off, len);
			int length = cbuf.length;
			for (int i = 0; i < length; i++) {
				if (cbuf[i] == lookFor) {
					count++;
				}
			}
			return numChars;
		}

		public void reset() throws IOException {
			super.reset();
			count = 0;
		}

		public boolean markSupported() {
			return false;
		}

		public void mark(int readAheadLimit)throws IOException{
			throw new IOException("CountReader does not support the mark() operation.");
			//CountReader不支持这个标记的操作
			//readAheadLimit 前面读取的限制
		}

		public int getCount() {
			return count;
		}
	}
