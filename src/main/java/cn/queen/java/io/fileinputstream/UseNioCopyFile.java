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
package cn.queen.java.io.fileinputstream;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 16, 2015
 * Use Java NIO to Copy File 使用java NIO复制文件
 */
import java.io.*;
import java.nio.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class UseNioCopyFile {
	public void useNioCopyFile(String s1, String s2){
		FileInputStream fis=null ;
		FileOutputStream fos=null ;
		FileChannel fci=null;
		FileChannel fco=null;
		try{fis= new FileInputStream(s1);
		fos= new FileOutputStream(s2);
		
		 fci=fis.getChannel();
		 fco=fos.getChannel();
		}catch(FileNotFoundException e){
			
		}catch(IOException e){
			
		}ByteBuffer buffer = ByteBuffer.allocate(1024);
		//分配一个新的字节缓冲区，容量是1024  (allocate 分配)
		while(true){
			try{int read = fci.read(buffer);
			if(read==-1) break;
			}catch(IOException e){}
		
			buffer.flip();
			//浏览这个缓冲 区
			try{fco.write(buffer);
			//写一个字节序列通道从给定的缓冲区
			}catch(IOException e){}
			buffer.clear();
			//清空缓冲区
		}
	}

}
