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
 * @since Nov 18, 2015
 * Resettable File InputStream 可重复调用的文件输入流
 */
import java.io.*;
public class ResettableFileInputStream {

	protected static final int DEFAULT_BUFFER_SIZE = 1024;

	protected final String m_filename;
	protected int m_bufferSize;
	protected InputStream m_inputStream;
	protected long m_position;
	protected long m_mark;
	protected boolean m_isMarkSet;

	public ResettableFileInputStream(final File file) throws IOException {
		this(file.getCanonicalPath());
		// 返回此抽象路径名的规范路径名字符串。
	}

	public ResettableFileInputStream(final String filename) throws IOException {
		this(filename, DEFAULT_BUFFER_SIZE);
	}

	public ResettableFileInputStream(final String filename, final int bufferSize)
			throws IOException {
		m_bufferSize = bufferSize;
		m_filename = filename;
		m_position = 0;

		m_inputStream = newStream();
	}

	public void mark(final int readLimit) {
		m_isMarkSet = true;
		m_mark = m_position;
		m_inputStream.mark(readLimit);
	}

	public boolean markSupported() {
		return true;
	}

	public void reset() throws IOException {
		if (!m_isMarkSet) {
			throw new IOException("Unmarked Stream");
		}
		try {
			m_inputStream.reset();
		} catch (final IOException ioe) {
			try {
				m_inputStream.close();
				m_inputStream = newStream();
				m_inputStream.skip(m_mark);
				m_position = m_mark;
			} catch (final Exception e) {
				throw new IOException("Cannot reset current Stream: "
						+ e.getMessage());
			}
		}
	}

	protected InputStream newStream() throws IOException {
		return new BufferedInputStream(new FileInputStream(m_filename),
				m_bufferSize);
	}

	public int available() throws IOException {
		return m_inputStream.available();
	}

	public void close() throws IOException {
		m_inputStream.close();
	}

	public int read() throws IOException {
		m_position++;
		return m_inputStream.read();
	}

	public int read(final byte[] bytes, final int offset, final int length)
			throws IOException {
		final int count = m_inputStream.read(bytes, offset, length);
		m_position += count;
		return count;
	}

	public long skip(final long count) throws IOException {
		m_position += count;
		return m_inputStream.skip(count);
	}
}
