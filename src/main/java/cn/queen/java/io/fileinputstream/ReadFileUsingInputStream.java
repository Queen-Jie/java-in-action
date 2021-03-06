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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 15, 2015
 */
import java.io.*;

/**
 * @author Hefei-Li
 *Alt+shift+j  加这样的注释
 */
public class ReadFileUsingInputStream {
	private Logger log = LoggerFactory
			.getLogger(ReadFileUsingInputStream.class);

	
	public void readFile(String path) {
		log.info(path + "文件已读取");
		FileInputStream fis = null;
		try {
			File file = new File(path);
			StringBuffer sb = new StringBuffer();
			fis = new FileInputStream(file);
			int temp;
			while ((temp = fis.read()) != -1) {
				sb.append((char) temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
