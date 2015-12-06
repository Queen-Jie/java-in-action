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
 * BufferedWriter out of FileWriter
 */
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
public class BufferedWriter1 {
	 public static void main(String[] args) throws IOException {
		    BufferedReader is = null;
		    BufferedWriter os = null;

		    try {
		      is = new BufferedReader(new FileReader("d:/abc.txt"));
		      os = new BufferedWriter(new FileWriter("f:/abc.txt"));

		      int c;
		      while ((c = is.read()) != -1) {
		       os.write(c);
		      }
		    } finally {
		      if (is != null) {
		        is.close();
		      }
		      if (os != null) {
		        os.close();
		      }
		    }
		  }
}
