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
 * Copy file character by character with FileReader and FileWriter
 * 通过FileWriter和FileReader以字节的方式复制文件
 */
import java.io.FileReader;
import java.io.FileWriter;

public class CopyFile {
	public static void main(String[] args) throws Exception {
		FileReader fr = new FileReader("d:\\abc.txt");
		FileWriter fw = new FileWriter("f:/abc.txt");
		// create a file writer
		int i;
		while ((i = fr.read()) != -1) {
			fw.write(i);
			// read and copy characters
		}
		fr.close();
		fw.close();
	}
}

    