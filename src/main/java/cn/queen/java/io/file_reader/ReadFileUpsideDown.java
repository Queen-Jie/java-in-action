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
 * read file upside down
 * 倒序读取文件
 */
import java.io.File;
import java.io.FileReader;

public class ReadFileUpsideDown {
	public static void main(String[] args) throws Exception {
		File f = new File("f:/abc.txt");
		FileReader fr = new FileReader(f);
		int len = (int) f.length();
		char[] c = new char[len];
		StringBuffer sbuf = new StringBuffer();
		fr.read(c, 0, len);
		for (int j = len - 1; j>=0; j--) {
			sbuf.append(c[j]);
		}
		System.out.println(sbuf.toString());
		fr.close();
	}
}

