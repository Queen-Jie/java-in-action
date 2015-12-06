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
 * File locking
 *锁定文件
 */
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
public class FileLocking {
public static void main(String[] args)throws Exception{
	FileOutputStream fos = new FileOutputStream("f:/file.txt");
	FileLock f1 = fos.getChannel().tryLock();
	/*getChannel()返回唯一FileChannel对象与该文件输出流。
	返回初始位置的通道将等于写入文件的字节数到目前为止,除非这流append模式,
	在这种情况下,它将等于文件的大小。字节写入此流将增加相应通道的位置。
	改变通道的位置,明确或写作,将改变这条小溪的文件位置。
	tryLock()试图获得独占锁定在这个频道的文件。*/
	if(f1!=null){
		System.out.println("Locked file");
		Thread.sleep(100);
		f1.release();
		System.out.println("released file");
	}
	fos.close();
}
}

