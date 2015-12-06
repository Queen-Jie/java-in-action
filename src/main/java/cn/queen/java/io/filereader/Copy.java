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
package cn.queen.java.io.filereader;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 24, 2015
 * Use FileReader and FileWriter
 */
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Copy {
	public static void main(String[] args) {
		FileReader fr = null;
		FileWriter fw = null;
		File f1 = new File("d:/abc.txt");
		File f2 = new File("f:/abc.txt");
		try {
			fr = new FileReader(f1);
			fw = new FileWriter(f2);
			int i;
			while ((i = fr.read()) != -1) {
				fw.write(i);
				fw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
