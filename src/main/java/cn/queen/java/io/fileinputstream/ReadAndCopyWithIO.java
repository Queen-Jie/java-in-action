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
 * @since Nov 17, 2015
 */
import java.io.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class ReadAndCopyWithIO {
	private Logger log=LoggerFactory.getLogger(ReadAndCopyWithIO.class);
	public void readAndCopy(String s1, String s2) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(s1);
			fos = new FileOutputStream(s2);
			int temp;
			while ((temp = fis.read()) != -1) {
				System.out.println((char) temp);
				fos.write(temp);
			}
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
