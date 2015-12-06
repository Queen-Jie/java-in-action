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
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
public class TextFileTest {
public static void main(String[] args){
	Employee[] staff = new Employee[3];
	staff[0] = new Employee("Tom",7500,1987,12,15);
	staff[1] = new Employee("Lily",5000,1989,10,1);
	staff[2] = new Employee("King",4000,1990,3,15);
	try{
	//保存所有的员工记录到employee.dat文件
	PrintWriter out= new PrintWriter("employee.dat");
	/*PrintWriter(String name)创建一个新的PrintWriter,没有自动刷新,使用指定文件名。
	这种便利构造函数创建必要的中间OutputStreamWriter,
	它将使用这个实例的默认字符集编码字符的Java虚拟机。*/
		writeData(staff,out);
		//writeData(Employee[] employees, PrintWrinter out)
	out.close();
	//out 是一个输出流，close（）关闭流并释放与之关联的任何系统资源。关闭之前关闭流没有影响。
	//检索所有的记录到一个新的数组
	Scanner in= new Scanner(new FileReader("employee.dat"));
	//scanner(Readable source)构造一个新的扫描仪,扫描从指定源产生的值。
	Employee[] newStaff = readData(in);
	in.close();
	//打印新阅读员工记录
	for(Employee e : newStaff)
		System.out.println(e);
	}catch(IOException e){
		e.printStackTrace();
	}
}
//把在一个组里的员工写到一个print writer
 private static void writeData(Employee[] employees, PrintWriter out)throws IOException{
	 //写入员工成员
	 out.println(employees.length);
	 for(Employee e : employees)
		 e.writeData(out);
 }
 //从Scanner上读取员工数组
 private static Employee[] readData(Scanner in){
	 //检索数组的容量
	 int n = in.nextInt();
	 in.nextLine();//consume newline 使用换行符
	 Employee[] employees = new Employee[n];
	 for(int i=0;i<n;i++){
		 employees[i] = new Employee();
		 employees[i].readData(in);
	 }
	 return employees;
 }
}

  class Employee{
	  public Employee(){}
	  public Employee(String n, double s, int year, int month, int day){
		  name = n;
		  salary = s;
		  GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
		  hireDay = calendar.getTime();
	  }
 
   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public Date getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }

   public String toString()
   {
      return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay=" + hireDay
            + "]";
   }

   //写员工数据到print writer
   public void writeData(PrintWriter out)
   {
      GregorianCalendar calendar = new GregorianCalendar();
      calendar.setTime(hireDay);
      out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR) + "|"
            + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
   }

   //从buffered reader中读取员工数据
   public void readData(Scanner in)
   //scanner一个简单的文本扫描仪,可以使用正则表达式解析基本类型和字符串

   {
      String line = in.nextLine();
      String[] tokens = line.split("\\|");
      name = tokens[0];
      salary = Double.parseDouble(tokens[1]);
      int y = Integer.parseInt(tokens[2]);
      int m = Integer.parseInt(tokens[3]);
      int d = Integer.parseInt(tokens[4]);
      GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
      hireDay = calendar.getTime();
   }

   private String name;
   private double salary;
   private Date hireDay;
}