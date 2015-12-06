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
 * @since Nov 26, 2015
 * Read the file one buffer at a time
 * 一次读取一个文件的缓存区
 */
import java.io.FileReader;

public class ReadFile {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("f:/abc.txt");
		int i;
		char[] c = new char[80];
		do {
			i = fr.read(c);
			for (int m = 0; m < c.length; m++)
			System.out.print(c[m]);
		} while (i == -1);
		fr.close();

	}
}