第十章 异常处理：
Page 360 - 384 

Java 异常机制 主要依赖于：
try catch finally throw throws  这个5个 关键字 


Page  362 
10.2 异常处理机制：
当程序出现意外的情形时， 系统会自动生成一个 Exception 对象来通知程序 

if(一切正常)
{
	// 业务实现代码
}
else
{
	alter 输入不合法 
	goto retry;
}


如果 程序可以顺利完成， 就是一切正常
把系统的业务实现代码放在 try 快中定义，所有的异常处理逻辑放在 catch 块中处理

try
{
	// 业务实现代码
}
catch(Exception e)
{
	alter illegal 
	goto retry
}

如果执行 try 块里 代码出现了异常，系统自动生成一个异常对象，
该异常对象被提交给 Java 运行的环境， 这个过程被称为 抛出 throw 异常

当 Java 运行环境收到异常对象的时候， 会寻找能处理该异常对象的 catch 块
如果找到 合适的 catch 块， 则把该异常对象交给该 catch 块处理，
这个过程 称为 捕获 catch 异常， 
当 Java 运行的环境，找不到 捕获异常的 catch 块，则运行时 环境终止，Java 程序也将退出 


String inputStr=null;

while((inputStr =br.readLine()!=null))
{
	try
	{
		String[] posStrArr=inputStr.split(",");
		int xPos=Integer.parseInt(posStrArr[0]);
		int yPos=Integer.parseInt(posStrArr[1]);
		
		if(!gb.board[xPos-1][yPos-1].equals("+"))
		{
			System.out.println("");


		}
	}
}

// 上面这块完全看不懂 


Page 364 
10.2.2 异常类的继承体系 
 
catch (Exception e):
每个 catch 块 都是专门用于 处理该异常以及其 子类的异常实例 

当Java 运行环境收到异常对象的时候， 会依次判断 该异常对象是否时 catch 
块 后异常类 或 其 子类的实例，
如果是，Java 调用该 catch  块 来处理该异常 
否则 再次拿该异常对象和 下一个 catch 块里的异常类进行比较


try 块后 可以又很多的 catch 块， 这是为了 针对 不同的 异常类提供不同的异常处理方式

当系统发生不同的以外情况时候， 系统会生成不同的异常对象，
Java 会根据该异常对象所属的异常类来决定使用哪个 catch 块来处理该异常

如果  try 块被执行一次， 则 try 块后面只有一个 catch 块被执行，
绝不能有多个 catch 块 被执行 ，
除非 再循环中使用 continue 开始执行下一次循环，
下一次循环又重新运行了 try 块， 才能导致倒戈 catch 块 被执行 


Java 非正常情况： 分为2种： 异常（exception） & 错误（Error）
它们都继承 Throwable 父类：

Error 错误： 无法恢复 或者 不可能捕获， 导致 应用程序中断 
所以 程序不应该用 catch 来 不会 Error 对象 
也无需 在其 throws 子句中 声明该方法可能抛出的 Error 以及其 任何子类 

public class DivTest
{
	public static void main(String[] args)
	{
		try
		{
			int a=Integer.parseInt(args[0]);
			int b=Integer.parseInt(args[1]);
			
			int c=a/b;
			
			System.out.println("the result: "+c);
		}
		
		catch(IndexOutOfBoundsException ie)
		{
			System.out.println("数组越界： 运行程序时输入的参数个数不够");
		}
		catch(NumberFormatException ne)
		{
			System.out.println("数字格式异常： 程序只能接受整数参数");
		}
		catch(ArithmeticException ae)
		{
			System.out.println("算数异常");
			// 如： 除数是  0 
		}
		catch(Exception e)
		{
			System.out.println("未知异常");
			// 异常对象总是  Exception 类 或者 其 子类 的实例 
		}
	}
}


public class NullTest
{
	public static void main(String[] args)
	{
		Date d= null;
		
		try
		{
			System.out.println(d.after(new Date()));
		}
		
		catch
		{
			System.out.println("空指针异常");
		}
		catch(Exception e)
		{
			System.out.println("未知异常");
		}
	}
}

进行 异常捕获的时候， 不仅应该把 Exception  类对应的 catch 块放在最后，
而且 所有父类异常的 catch 块 都应该排在子类异常 catch 块 的 后面 
（简称： 先处理小异常  再处理大异常）

try
{
	statement ...
}
catch (RuntimeException e)
{
	System.out.println("运行异常");
}
catch(NullPointerException ne)
{
	System.out.println("空指针异常");
}


Page 366 
10.2.3 Java7 提供的多异常捕获

public class MultiExceptionTest
{
	public static void main(String[] args)
	{
		try
		{
			int a= Integer.parseInt(args[0]);
			int b= Integer.parseInt(args[1]);
			int c=a/b;
			
			System.out.println("a/b="+c);
		}
		catch(IndexOutOfBoundsException | NumberFormatException 
		| ArithmeticException ie)
		// catch 块 可以同时捕获 这 3 种 类型的异常 
		{
			System.out.println("程序发生数组越界,数字格式异常，算数异常之一");
			// 捕获多异常时， 异常变量默认有 final 修饰
			// 下面代码有错误
			ie= new ArithmeticException("test");
		}
		catch(Exception e)
		{
			System.out.println("未知异常");
			// 捕获一种类型异常时， 异常变量没有 final 修饰
			// 下面正确
			e= new RuntimeErrorException("test");
		}
	}
}


Page 367
10.2.4 访问异常信息 

Java 7 以后
一个 catch 块 可以捕获 多种类型的异常 
Note：
（1）. 用 | 隔开 
（2）.	 隐式 final 修饰 不能对异常变量重新赋值




public class MultiExceptionTest
{
	public static void main(String[] args)
	{
		
		
		
		

Page  367 
10.2.4 
	
 当 Java 运行时 决定 调用某个 catch 块 来处理异常对象的时候， 会将异常对象赋给
catch 块 后的异常参数， 程序可以通过该参数获得异常的信息

getMessage(): 
printStackTrace():
printStackTrace(PrintStream s):
getStackTrace():

 







































