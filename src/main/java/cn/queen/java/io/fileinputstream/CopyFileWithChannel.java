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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class CopyFileWithChannel {
	private Logger log = LoggerFactory.getLogger(CopyFileWithChannel.class);

	// java.io.FileOutputStream.getChannel() 方法返回与此文件输出流关联的唯一文件通道对象。
	public void copyFileWithChannel(String from, String to) {
		log.info("from:{},to:{}", from, to);
		FileChannel srcChannel = null;
		FileChannel dstChannel = null;
		try {
			srcChannel = new FileInputStream(from).getChannel();
			dstChannel = new FileOutputStream(to).getChannel();
			// 将一个通道和另一个通道直接相连,这样很容易实现文件拷贝的功能
			dstChannel.transferFrom(srcChannel, 0, srcChannel.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			srcChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			dstChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
