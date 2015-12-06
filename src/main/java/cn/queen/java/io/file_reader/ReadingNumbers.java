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
 * Reading Numbers from a Text File, Line by Line
 * 从一个文本文件中逐行的读取数字
 */
import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.FileReader;
import java.io.LineNumberReader;

public class ReadingNumbers {
	public static void main(String[] a) throws IOException {
		sumLines("f:/file.txt");
	}

	private static void sumLines(String filename) throws IOException {
		LineNumberReader lnr = new LineNumberReader(new FileReader(filename));
		lnr.setLineNumber(1);
		StreamTokenizer stok = new StreamTokenizer(lnr);
		/*
		StreamTokenizer类需要一个输入流并解析成“令牌”,允许标记读取一次。
		解析过程是由一个表和一个可以设置为各种状态的标志。
		流记号赋予器可以识别标识符、数字引用字符串,和各种评论风格。
		parse 解析
		*/
		stok.parseNumbers();
		stok.eolIsSignificant(true);
		stok.nextToken();
		while (stok.ttype != StreamTokenizer.TT_EOF) {
			int lineno = lnr.getLineNumber();
			double sum = 0;
			while (stok.ttype != StreamTokenizer.TT_EOL) {
				if (stok.ttype == StreamTokenizer.TT_NUMBER)
					sum += stok.nval;
				stok.nextToken();
			}
			System.out.println("Sum of line " + lineno + " is " + sum);
			stok.nextToken();
		}
	}
}
