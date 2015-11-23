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

import java.io.FileInputStream;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 17, 2015
 */
import org.junit.Before;
import org.junit.Test;
import cn.queen.java.test.BasicTestSuit;

public class CountCharactersWithInputStreamTest extends BasicTestSuit {
	private CountCharactersWithFileInputStream cc;

	@Before
	public void setUp() {
		if (cc == null) {
			cc = new CountCharactersWithFileInputStream();
		}
	}

	@Test
	public void countChars() throws Exception {
		String path = "d:/abc.txt";
		if (path.length() >= 1)
			cc.countChars(new FileInputStream(path));
		else
			System.err.println("Usage: Count filename");
		// “标准”错误输出流。这流已打开并准备接受输出数据.
	}
}
