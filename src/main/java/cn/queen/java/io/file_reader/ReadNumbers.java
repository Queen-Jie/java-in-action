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
 * Reading Numbers from a Text File
 * 从一个文本文件中读取数字
 */
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.io.StreamTokenizer;
public class ReadNumbers {

	  public static void main(String[] a) throws IOException {
	      sumfile("f:/file.txt");
	  }


	  static void sumfile(String filename) throws IOException {
	    Reader r = new BufferedReader(new FileReader(filename));
	    StreamTokenizer stok = new StreamTokenizer(r);
	   /* StreamTokenizer类需要一个输入流并解析成“令牌”,允许标记读取一次。
	       解析过程是由一个表和一个可以设置为各种状态的标志。
	       流记号赋予器可以识别标识符、数字引用字符串,和各种评论风格。*/
	    stok.parseNumbers();
	    double sum = 0;
	    stok.nextToken();
	    while (stok.ttype != StreamTokenizer.TT_EOF) {
	      if (stok.ttype == StreamTokenizer.TT_NUMBER)
	        sum += stok.nval;
	      else
	        System.out.println("Nonnumber: " + stok.sval);
	      stok.nextToken();
	    }
	    System.out.println("The file sum is " + sum);
	  }
}
