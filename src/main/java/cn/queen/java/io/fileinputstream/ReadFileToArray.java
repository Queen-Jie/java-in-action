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
 * Reading a File into a Byte Array: reads the entire contents of a file into a byte array
 * 读取一个文件为一个字节数组:读取一个文件的全部内容到一个字节数组
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class ReadFileToArray {
	private Logger log = LoggerFactory.getLogger(ReadFileToArray.class);

	public void readFileToArray(String path) {

		File file = null;
		InputStream is = null;
		try {
			file = new File(path);
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			log.info("File is too large");
		}

		byte[] bytes = new byte[(int) length];

		int offset = 0;
		int numRead = 0;//CPU的时钟，返回当前读了多长
		while (numRead >= 0) {
			try {
				//                读取的内容，开始的位置，可以读取的长度
				numRead = is.read(bytes, offset, bytes.length - offset);
				offset += numRead;
			} catch (IOException e) {
			}
		}

		if (offset < bytes.length) {
			try {
				throw new IOException("Could not completely read file "
						+ file.getName());
			} catch (IOException e) {
			}
		}
		try {
			is.close();
		} catch (IOException e) {
		}

		log.info(new String(bytes));
	}
}
