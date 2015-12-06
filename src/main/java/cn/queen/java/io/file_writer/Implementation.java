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
package cn.queen.java.io.file_writer;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 25, 2015
 * Implementation of a fast Writer.
 * 实现一个快速的Writer
 */
import java.io.IOException;
import java.io.Writer;
public final class Implementation extends Writer {
//常量表明这个Writer不是缓存输出
	public static final int NO_BUFFER = 0;
	//常数表明writer是缓冲的,并使用默认缓冲区大小
	public static final int DEFAULT_BUFFER = -1;
	//常数表明writer是缓冲的,是无限的;这个应用于BodyContent
	public static final int UNBOUNDED_BUFFER = -2;
	private int bufferSize;
	private boolean autoFlush;
	private Writer writer;
	private char [] cb;
	private int nextChar;
	private static int defaultCharBufferSize = 8*1024;//default默认的
	//使用default-sized输出缓冲区创建一个character-output缓冲流
	public Implementation(Writer writer){ 
		this(writer,defaultCharBufferSize,true);
	}
	private Implementation(int bufferSize, boolean autoFlush){
		this.bufferSize= bufferSize;
		this.autoFlush= autoFlush;
	}
	//这个方法返回缓存区的大小
	public int getBufferSize(){return bufferSize;}
	//这个方法显示JspWriter是否是自动刷新
	public boolean isAutoFlush(){return autoFlush;}
	//使用一个缓存区大小固定的输出流创建一个新的带缓存的character-output流
	public Implementation(Writer writer, int sz, boolean autoFlush){
		this(sz,autoFlush);
		if(sz<0)throw new IllegalArgumentException("Buffer size<=0");//illegal 非法的 argument 论点
		this.writer = writer;
		cb = sz == 0 ?null:new char[sz];
		nextChar = 0;
	}
	//刷新输出缓冲区的底层字符流,没有刷新流本身。该方法不是私有的，所以它可以被PrintSream调用
	private final void flushBuffer()throws IOException{
		if(bufferSize == 0)
			return;
		if(nextChar == 0)
			return;
		writer.write(cb,0,nextChar);
		nextChar = 0;
	}
	//丢弃输出缓冲区
	public final void clear(){
		nextChar = 0;
	}
	private final void bufferOverflow()throws IOException{//overflow 溢出
		throw new IOException("overflow");
	}
	//刷新流
	public final void flush()throws IOException{
		flushBuffer();
		if(writer !=null){
			writer.flush();
		}
	}
	//关闭流
	public final void close() throws IOException{
		if(writer == null)
			return;
		flush();
	}
	//未使用的缓冲区的字节数
	public final int getRemaining(){
		return bufferSize - nextChar;
	}
	//写入一个唯一的字符
	public final void write(int c) throws IOException{
		if(bufferSize == 0){
			writer.write(c);
		}else{
			if(nextChar >= bufferSize)
				if(autoFlush)
					flushBuffer();
				else
					bufferOverflow();
			cb[nextChar++] = (char) c;
		}
	}
	//我们自己的最小值的方法,以避免加载
	private final int min(int a, int b){
		return(a < b ? a : b);
	}
	//写一个字符数组的一部分
	public final void write(char cbuf[], int off, int len)throws IOException{
	
	/*
	写字符数组的一部分。
	
	参数:cbuf字符的数组
	
	off :抵消开始写的字符
	
	len:写的字符数
	*/

		if(bufferSize == 0){
			writer.write(cbuf, off ,len);
			return;
		}
		if(len == 0){
			return;
		}
		if(len >= bufferSize){
			//如果需求超过输出流缓存区的大小，刷新这个缓存区，然后直接写入数据
			if(autoFlush)
				flushBuffer();
			else
				bufferOverflow();
			writer.write(cbuf,off,len);
			return;
		}
		int b = off, t = off+len;
		while(b<t){
			int d = min(bufferSize - nextChar, t-b);
			System.arraycopy(cbuf,b,cb,nextChar,d);
			b+=d;
			nextChar += d;
			if(nextChar>= bufferSize)
				if(autoFlush)
					flushBuffer();
				else
					bufferOverflow();
		}
	}
	//写入字符数组，这个方法不能继承Writer类,因为它必须抑制I / O例外。
	public final void write(char buf[])throws IOException{
		write(buf,0,buf.length);
	}
	//写入字符串的一部分
	public final void write(String s, int off ,int len)throws IOException{
		if(bufferSize == 0){
			writer.write(s,off,len);
			return;
		}
		int b = off, t = off+len;
		while(b<t){
			int d = min(bufferSize - nextChar, t-b);
			s.getChars(b,b+d,cb,nextChar);
			b+=d;
			nextChar+=d;
			if(nextChar>= bufferSize)
				if(autoFlush)
					flushBuffer();
				else
					bufferOverflow();
		}
	}
	//写入字符，这个方法不能从writer类继承，因为它必须抑制I/O例外
	public final void write(String s)throws IOException{
		if(s!=null){
			write(s,0,s.length());
		}
	}
//重置这个类以便它可以重用
public final void recycle(Writer writer){
	this.writer = writer;
	clear();
}
}

