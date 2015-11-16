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
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class CopyOneFile {
	private Logger log = LoggerFactory.getLogger(CopyOneFile.class);
	FileInputStream fis = null;
	FileOutputStream fos = null;

	public void copyOneFile(String from, String to) {
		log.info("Form: {}, To: {}", from, to);
		try {
			File file = new File(from);
			fis = new FileInputStream(file);
			fos = new FileOutputStream(to);
			byte[] bytes = new byte[1024];
			int temp = 0;
			while ((temp = fis.read(bytes)) >0) {
				fos.write(bytes, 0, temp);
			fos.flush();
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
		try {
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}