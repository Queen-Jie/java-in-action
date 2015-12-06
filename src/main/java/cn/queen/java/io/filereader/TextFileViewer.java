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
package cn.queen.java.io.filereader;

/**
 * @version 0.1
 *
 * @author Jie Wang
 *
 * @since Nov 24, 2015
 * 
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class TextFileViewer extends Frame implements ActionListener {
	// 这个类创建并显示一个包含文本框的窗口，并显示文件的目录
	String directory; // 显示默认的目录
	TextArea textarea;// 显示文件的内容

	public TextFileViewer() {
		this(null, null);
	}

	// 文件浏览器以空白格式开始
	public TextFileViewer(String filename) {
		this(null, filename);
	}

	// 显示当前目录的文件
	public TextFileViewer(String directory, String filename) {
		super();

		// 创建一个FileViewer对象以显示指定的文件目录
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		/*addWindowListener()将指定窗口监听器添加到从这个窗口接收窗口事件。
		如果l是零,没有异常,也没有行动是执行。
		WindowAdapter()一个抽象为接收窗口事件适配器类。
		这个类中的方法是空的。这个类存在方便创建侦听器对象。*/
		// Destroy the window when the user requests it
		textarea = new TextArea("", 24, 80);
		//new TextArea(String text,int rows, int columns)构建一个指定行和列的文本框，
		textarea.setFont(new Font("MonoSpaced", Font.PLAIN, 12));
		//setFont()设置字体  new Font(String name, int style, int size)以指定格式创建字体
		textarea.setEditable(false);
		//setEditable()设置这个组件是否可以编辑，false不可编辑，true可编辑
		this.add("Center", textarea);
		//add(String name,component comp)将指定的组件添加到此容器
		Panel p = new Panel();
		// 创建一个文本框显示文件的内容
		p.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 5));
		//设置这个容器的布局
		this.add(p, "South");

		// 创建一个放一组按钮的按钮面板

		Font font = new Font("SansSerif", Font.BOLD, 14);
		Button openfile = new Button("Open File");
		Button close = new Button("close");
		openfile.addActionListener(this);
		openfile.setActionCommand("open");
		openfile.setFont(font);
		close.addActionListener(this);
		close.setActionCommand("close");
		close.setFont(font);
		p.add(openfile);
		p.add(close);
		this.pack();
		// 创建按钮并且处理按钮点击事件
		// 如果必要，列出文件目录
		if (directory == null) {
			File f;
			if ((filename != null) && (f = new File(filename)).isAbsolute()) {
				directory = f.getParent();
				filename = f.getName();
			} else
				directory = System.getProperty("user.dir");
		}
		this.directory = directory;// Remember the directory, for FileDialog
		setFile(directory, filename);// now load and display the file
	}

	// 加载并显示指定文件夹下的指定文件
	public void setFile(String directory, String filename) {
		if ((filename == null) || (filename.length() == 0))
			return;
		File f;
		FileReader in = null;
		// 读取并显示文件的内容
		try {
			f = new File(directory, filename);// 创建一个文件对象
			in = new FileReader(f);
			char[] buffer = new char[4096];// 一次读取4K的字符
			int len;// 一次读取多少个字符
			textarea.setText("");// 清空文本框
			while ((len = in.read(buffer)) != -1) {// 读取一批字符
				String s = new String(buffer, 0, len);// 传递到一个字符串
				textarea.append(s);// 显示字符串
			}
			this.setTitle("FileViewer:" + filename);// 创建窗口的标题
			textarea.setCaretPosition(0);// 开始文件
		}
		// 如果出错，显示信息
		catch (IOException e) {
			textarea.setText(e.getClass().getName() + ":" + e.getMessage());
			this.setTitle("FileViewer:" + filename + ":I/O Exception");
			;
		}
		// 关闭流
		finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 处理按钮点击事件
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("open")) {// 如果用户点击”open“按钮
			// 创建一个文件对话框提示显示新的文件
			FileDialog f = new FileDialog(this, "Open File", FileDialog.LOAD);
			f.setDirectory(directory);// 设置默认的目录
			// 显示对话框，等待用户输入
			f.show();
			directory = f.getDirectory();// 记住新的默认目录
			setFile(directory, f.getFile());// 加载并显示选项
			f.dispose();// 除去对话框
		} else if (cmd.equals("close"))// 如果用户点击“close”按钮
			this.dispose();// 关闭窗口
	}

	// 方法的入口
	public static void main(String[] args) throws IOException {
		// 创建一个TextFileViewer对象
		Frame f = new TextFileViewer((args.length == 1) ? args[0] : null);
		// 当TextFileViewer关闭时退出
		f.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				System.exit(0);
			}
		});
		// 弹出窗口
		f.show();
	}
}
