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
 * @since Nov 23, 2015
 * Create BufferedReader from FileReader and process lines from file
 *通过文件中的文件读取和行处理创建BufferedReader
 */
import java.io.*;

public class CreateBufferedReader {
	public static void main(String[] args)throws Exception{
		FileReader f=new FileReader("E://abc.txt");
		BufferedReader b = new BufferedReader(f);
		String line;
		//process lines from file 从文件中处理
		while((line = b.readLine())!=null){
			//readLine()从文件中读取整行
			char array[] = line.toCharArray();
			//toCharArray将此字符串转换为一个新的字符数组。
			System.out.print(array[0]);
			b.close();
		}
	}
}