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
 * @since Nov 28, 2015
 * Getting channels from streams
 *从流中获得通道
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
public class GettingChannels {
private static final int BSIZE = 1024;
public static void main(String[] args)throws Exception{
	//写入一个文件
	FileChannel fc = new FileOutputStream("f:/abc.txt",true).getChannel();
	fc.write(ByteBuffer.wrap("some text".getBytes()));
	fc.close();
	//添加到文件的末尾
	fc = new RandomAccessFile("f:/abc.txt","rw").getChannel();
	fc.position(fc.size());//移动到文件的末尾
	fc.write(ByteBuffer.wrap("some text".getBytes()));
	//wrap包装  wrap(byte[] array)包装一个字节数组缓冲区。
	fc.close();
	//读取文件
	fc = new FileInputStream("f:/abc.txt").getChannel();
	ByteBuffer buff = ByteBuffer.allocate(BSIZE);
	//allocate分配  allocate(int)  分配一个新的字节缓冲区
	fc.read(buff);
	buff.flip();
	//flip()翻转这个缓冲区。限制设置为当前位置然后位置设置为零。如果定义了标记,那么它就会被丢弃。
	while(buff.hasRemaining())
		//hasRemaining()判断当前位置和限制之间是否有其他元素
		System.out.print((char)buff.get());
	//ByteBuffer.get()相对的get方法。读取字节缓冲区的当前位置,然后增量的位置。
	fc.close();
}

}

