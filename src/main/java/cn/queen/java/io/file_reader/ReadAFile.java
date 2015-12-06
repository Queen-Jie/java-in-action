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
 * Read a file and print, using BufferedReader and System.out
 * 使用BufferedReader 和System.out读取并打印一个文件
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
public class ReadAFile {
	public static void main(String [] args){
		String[] s={"f:/abc.txt","f:/bc.txt"};
		mian(s);
	}
public static void mian(String[] av){
	ReadAFile c = new ReadAFile();
	if(av.length == 0)
		c.process(new BufferedReader(new InputStreamReader(System.in)));
	else
		for(int i = 0 ; i< av.length;i++)
			try{
				c.process(new BufferedReader(new FileReader(av[i])));
			}catch(FileNotFoundException e){
				System.err.println(e);
			}
}
//通过一个开放的BufferedReader打印一个文件
public void process(BufferedReader is){
	try{
		String inputLine;
		while((inputLine = is.readLine())!=null){
			System.out.println(inputLine);
		}
	}catch(IOException e){
		System.out.println("IOException:"+e);
	}
}
}

