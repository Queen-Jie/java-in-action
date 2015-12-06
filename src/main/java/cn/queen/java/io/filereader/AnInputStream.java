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
 * 
 * An InputStream backed by a Reader
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
public class AnInputStream extends InputStream{
	//InputStream 此抽象类是表示字节输入流的所有类的超类。
protected Reader reader;
protected ByteArrayOutputStream byteArrayOut;
protected Writer writer;
protected char[] chars;
protected byte[] buffer;
protected int index,length;
//构造方法1
public AnInputStream(Reader reader){
	this.reader=reader;
	byteArrayOut = new ByteArrayOutputStream();
	//创建一个新的字节数组输出流。最初缓冲容量是32个字节。
	writer = new OutputStreamWriter(byteArrayOut);
	//OutputStreamWriter使用默认字符编码创建OutputStreamWriter
	chars=new char[1024];
}
//构造方法2
public AnInputStream(Reader reader,String encoding)throws UnsupportedEncodingException{
	this.reader=reader;
	byteArrayOut=new ByteArrayOutputStream();
	writer= new OutputStreamWriter(byteArrayOut,encoding);
	chars=new char[1024];
}
public int read()throws IOException{
	if(index >= length)
		fillBuffer();
	if(index >=length)
		return -1;
	return 0xff &buffer[index++];
}
protected void fillBuffer()throws IOException{
	if(length<0)
		return;
	int numChars = reader.read(chars);
	if(numChars<0){
		length=-1;
	}else{
		byteArrayOut.reset();
		writer.write(chars,0,numChars);
		writer.flush();
		buffer = byteArrayOut.toByteArray();
		length=buffer.length;
		index=0;
	}
}
		public int read(byte[] data, int off, int len)throws IOException{
			if(index >= length)
				fillBuffer();
			if( index >=length)
				return -1;
			int amount = Math.min(len, length-index);
			System.arraycopy(buffer,index,data, off, amount);
			index += amount;
			return amount;
		}
		public int available()throws IOException{
			return(index<length)?length-index:((length>=0)&& reader.ready())?1:0;
		}
		public void close()throws IOException{
			reader.close();
		}
}


   
    