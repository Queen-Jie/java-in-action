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
 */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Writer;
import java.io.Reader;

public class ReadAndCopy {
	public static void main(String[] args) throws Exception {
		Writer w = new FileWriter("d:/abc.txt");
		Reader r = new FileReader("f:/abc.txt");
		int i;
		while ((i = r.read()) != -1) {
			w.write(i);
			w.flush();
		}
		r.close();
		w.close();
	
}
}
