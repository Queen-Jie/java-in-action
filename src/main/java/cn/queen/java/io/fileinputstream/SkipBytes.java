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
 * @since Nov 15, 2015
 */
import java.io.*;
public class SkipBytes {
	public void skipBytes(String path, String to) {
		File file = new File(path);
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(file);
			fos = new FileOutputStream(to);
			int temp = 0;
		//	跳过开始的4个字节
			fis.skip(4);
			byte[] bytes = new byte[1024];
			temp = fis.read(bytes);
			fos.write(bytes, 0, temp);
			fos.flush();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		try {
			fis.close();

		} catch (IOException e) {
		}
		try {
			fos.close();
		} catch (IOException e) {
		}
	}
}
