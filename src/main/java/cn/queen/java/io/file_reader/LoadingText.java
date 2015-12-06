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
 * Loading text from a file
 * 从文件中加载文本
 */
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
public class LoadingText {
	public static void main(String[] args)throws Exception{
		File f=new File("f:/test.txt");
		FileReader fr= new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		StringBuffer sb= new StringBuffer();
		String eachLine=br.readLine();
		while(eachLine!=null){
			sb.append(eachLine);
			sb.append("\n");
			eachLine= br.readLine();
			//readLine();读取文本的一行
		}
		br.close();
		System.out.println(sb.toString());
	}
}