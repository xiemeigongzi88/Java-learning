第四章 流程控制与数组：

4.1 顺序结构：



4.2 分支结构
Page 88 
else 的隐含条件是对前面条件取反 
如：

public class IfErrorTest
{
	public static void main(String[] args)
	{
		int age=45;
		
		if(age>20)
			System.out.println("young");
		
		else if(age>40)
			System.out.println("middle");
		else if(age>60)
			System.out.println("old");
	}
}


public class IfErrorTest2
{
	public static void main(String[] args)
	{
		int age=45;
		if(age>20)
			System.out.println("young");
		
		else if(age>40 && !(age>20))
			System.out.println("middle");
		else if(age>60&&!(age>40 && !(age>20)))
			System.out.println("old");
	}
}
其实 上面的 写错了  就是数值的范围发生了问题

为了达到正确， program 正确的写法是：

public class IfCorrectTest
{
	public static void main(String[] args)
	{
		int age=45;
		
		if(age>60)
			System.out.println("old");
		
		else if(age>40)
			System.out.println("middle");
		
		else if (age >20)
			System.out.println("young");
	}
}

上面的程序等同于下面的代码 ：

public class TestIfCorrect2
{
	public static void main(String[] args)
	{
		int age=45;
		
		if(age>60)
			System.out.println("old");
		
		else if(age>40 && !(age>60))
			System.out.println("middle");
		
		else if(age>20 && !(age>60)&&!(age>40 &&!(age>60)))
			System.out.println("young");
	}
}

case 标签后的值 都不与 expression 表达式的值相等
则执行 default 标签后面的代码块

public class SwitchTest
{
	public static void main(String[] args)
	{
		char score='C';
		
		switch(score)
		{
			case 'A':
				System.out.println("A");
				break;
				
			case 'B':
				System.out.println("B");
				break;
				
			case 'C':
				System.out.println("C");
				break;
				
			case 'D':
				System.out.println("D");
				break;
				
			case 'E':
				System.out.println("E");
				break;
				
			case 'F':
				System.out.println("F");
				break;
				
			default:
				System.out.println("loading...");
		}
	}
}
	
Java 7 增强了 switch 语句的功能，允许switch语句的控制表达式是
java.lang.String 类型的变量或者 表达式

public class StringSwitchTest
{
	public static void main(String[] args)
	{
		String season="夏天";
		
		switch (season)
		{
			case "春天":
				System.out.println("chunnuanhuakai");
				break;
			
			case "Summer";
				System.out.println("xiariyanyan");
				break;
			
			case "Automum":
				System.out.println("qiugaoqishuang");
				break;
				
			case "winter":
				System.out.println("baixueaiai");
				break;
				
			default:
				System.out.println("Error");
		}
	}
}

Note: (1)switch语句后面的 expression 表达式的数据类型只能是
byte, short, char  int 这四种类型和枚举类型

如果省略 case 后面的 break 会出现问题

  
4.3 循环结构



4.4 控制循环结构

4.4.1 使用 break 结束循环

一旦在循环体中遇到 break 系统讲完全结束该循环

public class BreakTest
{
	public static void main(String[] args)
	{
		fot(int i=0;i<10;i++)
		{
			System.out.println(" "+i);
			
			if(i==6)
					break;
		}
	}
}

OUT:
 0
 1
 2
 3
 4
 5
 6
 
 break 还可以结束外层循环 用一个标签 
 public class BreakTest2 
 {
	 public static void main(String[] args)
	 {
		 outer:
		 for(int i=0;i<5;i++)
		 {
			 for(int j=0;j<3;j++)
			 {
				 System.out.println("i="+i+" , j="+j);
				 if(j==i)
					 break outer;
			 }
		 }
	 }
 }
 
OUT:
i=0 , j=0

break 后的标签必须是一个有效的标签， 即 这个标签必须在
break 语句所在的循环之前定义， 或者在其所在循环的外层循环之前定义

通常紧跟 break 之后的标签， 必须在 break 所在循环的外层循环之前定义才有意义



4.4.2 使用 continue 结束本次循环 

continue 只是结束本次循环 接着下一次循环
break 是完全终止循环

public class ContinueTest
{
	public static void main(String[] args)
	{
		for(int i=0;i<3;i++)
		{
			System.out.println(" "+i);
			
			if(i==1)
			{
				continue;
			}
			
			System.out.println("continue 后面的的语句");
		}
	}
}

OUT:
 0
continue 后面的的语句
 1
 2
continue 后面的的语句3

i=1 的时候， 没有执行 档次循环中 continue 后面的代码 
如果把 continue 放在单词循环的最后一行 是没有意义的

 
与 break 类似，continue 后面也可以跟着一个 标签 
用于 直接跳过标签所表示的当此 循环的剩下语句 重新开始下一个新的循环 


public class ContinueTest2
{
	public static void main(String[] args)
	{
		outer:
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.println("i="+i+", j="+j);
				
				if(j==i)
				{
					continue outer;
				}
			}
		}
	}
}

OUT：
i=0, j=0
i=1, j=0
i=1, j=1
i=2, j=0
i=2, j=1
i=2, j=2
i=3, j=0
i=3, j=1
i=3, j=2
i=4, j=0
i=4, j=1
i=4, j=2


4.3 使用 return 结束方法

return 的功能是结束一个方法
当一个方法执行到一个 return 语句的时候， 这个方法将会被结束


public class ReturnTest 
{
	public static void main(String[] args)
	{
		for(int i=0;i<3;i++)
		{
			System.out.println("i="+i);
			
			if(i==1)
				return;
			
			System.out.println("return 后面的语句");
		}
	}
}

OUT：
i=0
return 后面的语句
i=1

与 continue break 不用的是， return 直接结束这个方法
不管这个 return 处于多少层之内 




4.5  数组 array 

4.5.1 数组也是一种类型
一旦数组的初始化完成， 数组在内存中所占的空间也将被固定下来，
因此数组的长度不可变，
即使是把某个数组元素的数据清空，但是它所占的空间依然被保存下来，
数组的长度依然不可变

Java 的数组既可以存储基本类型的数据， 也可以存储引用类型的数据，
只要所有的数组元素具有相同的类型即可  // important 
// 数组元素可以是 引用类型的 只要数组元素 类型相同即可


数组是一种引用类型的变量， 
使用数组定义一个变量的时候， 仅仅表示定义了一个引用变量 （也就是指针）
这个引用变量还没有指向任何有效的内存，因此定义数组的时候不能指定数组的长度

而且 由于数组只是定义了一个引用变量，并没有指向任何有效的内存空间，
所以还没有内存空间来存储数组元素，因此这个数组也不能使用，
只有对数组进行初始化才能使用

Note： 定义数组时候  不能指定 数组的长度 

4.5.3 数组的初始化：
初始化： 为数组的数组元素分配内存空间， 并为每个元素赋初始值

能不能只分配内存空间，不赋初始值？？？
No 一旦为数组的每个数组元素分配内存空间， 每个内存空间里存储的内容就
是该数组元素的值，即使是这个内存空间的内容是空的，
这个空 也是一个 值 null , 
因此，不管以哪种方式来初始化数组， 只要为数组元素分配内存空间， 
数组元素就有了初始值，
初始值的获得有两种形式： 一种是由系统自动分配，一种是自己决定的

数组的初始化： 两种方式：
（1） 静态初始化： programmer 指定每个数组元素的初始值，由系统决定数组长度
（2）动态初始化： programmer 只需要指定数组长度，由系统为数组元素分配初始值

1. 静态初始化：

int[] intArr;
intArr = new int[]{5,6,8,20};

int [] a=new int[]{1,2,3,4,5};

Object[] objArr= new String[]{"Java","crazy"};

Object[] objArr2=new Object[] {"Java","Crazy"};

Java 是面向对象的编程语言， 能很好支持子类和父类的继承关系： 子类实例是一种特殊的父类实例
String 类型是 Object 类型的子类， 即 字符串是一种特殊的 Object 实例


simplify:

int [] a={1,2,3,4,5};


2. 动态初始化：
动态初始化 只需要指定数组的长度
int[] a=new int [length];

int [] prices=new int [5];

Object [] books=new String[4];

执行动态初始化的时候， 只需要只能 指定 数组的长度，即为每个数组指定所需的内存空间
系统讲自动为这些数组元素分配初始值

int short byte long 0 
float double 0.0 
char '\u0000'
boolean false 
引用类型（类 接口 数组）  数组元素的初始值是 null

不要同时使用 静态初始化 和  动态初始化  
即 不要 既指定数组的长度 又为每个数组元素分配初始值


4.5.4 使用数组
System.out.println(objArr[1]);
objArr2[0]="String";

数组的 length 属性：

for(int i=0;i<prices.length;i++)
{
	System.out.println(prices[i]);
}

// 动态初始化以后 对数组元素进行赋值
books[0]="Crazy Java Note";
books[1]="Practice of Java";
for(int i=0;i<books.length;i++)
	System.out.println(books[i]);


4.5.5 for-each 循环

如何使用 foreach 循环来遍历数组元素

public class ForEachTest
{
	public static void main(String[] args)
	{
		String[] books={"Crazy", "Java","Practice","Miss","You"};
		
		for(String book:books)
			System.out.println(book);
		
	}
}


通常不要对循环变量赋值：

public class ForEachErrorTest
{
	public static void main(String[] args)
	{
		String[] books={"Crazy", "Java","Practice","Miss","You"};
		
		for(String book: books)
		{
			book="brave";
			System.out.println(book);
		}
		
		System.out.println(books[0]);
	}
}

OUT:
brave
brave
brave
brave
brave
Crazy

当再次访问第一个数组元素的时， 发现数组元素的值 依然没有改变

当使用 for-each 来访问数组元素的时候， foreach 中的循环变量相当于一个临时变量
系统会把数组元素一次赋给这个临时变量 这个临时变量并不是数组元素
它只是保存了数组元素的值
如果希望希望改变数组元素的值，则不能使用这种 for-each 循环 

Note： 
使用 for-each 循环迭代数组元素的时候， 并不能改变数组元素的值，
因此不要对 for-each 的循环变量进行赋值


4.6 深入数组

4.6。1 内存中的数组：

数组引用变量只是一个引用，只有当该引用指向有效内存后，才能通过数组变量来访问数组元素

实际的数组对象（数组中的每一个元素）都被存储在 heap(堆)中，
如果引用该数组对象的数组引用变量是一个局部变量，
那么 引用变量被存储在 栈 stack 中。

数组引用变量是访问堆 heap 内存中数组元素的根本方式


如果heap 堆内存中数组不再有任何引用变量指向自己， 这个数组将成为垃圾

为了让垃圾回收机制回收一个数组所占的内存空间， 可以将该数组变量赋值为 null 
切断了数组引用变量 和 实际数组之间的引用关系， 实际数组也就编程了垃圾

public class ArrayInRam
{
	public static void main(String[] args)
	{
		int [] a={5,7,20};
		
		int [] b=new int [4];
		
		System.out.println("the length of b array:"+b.length);
		
		for(int i=0,len=a.length;i<len;i++)
		{
			System.out.println(a[i]);
		}
		
		for(int i,len=b.length;i<len;i++)
			System.out.println(b[i]);
		
		b=a;  // 改变引用变量 a 和 b 指向同一个数组 把a 赋给 b 
		System.out.println("the length of b array :"+b.length);
	}
}

OUT:
the length of b array:4
5
7
20
0
0
0
0
the length of b array :3

这部分要结合书 一起看 书上有图



4.6.2 基本类型数组的初始化：

动态初始化的方式， 

public class PrimitiveArrayTest
{
	public static void main(String[] args)
	{
		int [] iArr;
		iArr=new int[5];
		
		for(int i=0;i<iArr.length;i++)
		{
			iArr[i]=i+10;
			System.out.println(iArr[i]);
		}
	}
}

OUT:
10
11
12
13
14



4.6.3 引用类型数组的初始化 

每个数组元素里存储的还是引用，指向另一个内存，另一个内存里存储了有效数据

class Person
{
	public int age;
	
	public double height;
	
	public void info()
	{
		System.out.println("age: "+age+", height: "+height);
	}
}

public class ReferenceArrayTest
{
	public static void main(String[] args)
	{
		Person[] students=new Person[2];
		
		Person zhang = new Person();
		
		zhang.age=15;
		zhang.height=158;
		
		Person lee=new Person();
		
		lee.age=16;
		lee.height=161;
		
		students[0]=zhang;
		students[1]=lee;
		
		lee.info();
		students[1].info();
	}
}


OUT：
age: 16, height: 161.0
age: 16, height: 161.0

这部分需要结合书上的图看

4.6.4 没有二维数组




后面的内容没有看

public class TwoDimensionTest
{
	publci static void main(String[] args)
	{
		int [][]a=new int[4][];
		
		for(int i=0,len=a.length;i<len;i++)
		{
			System.out.println(a[i]);
		}
		
		a[0]=new int[2];
		a[0][1]=6;
		
		for(int i=0, len=a[0].length;i<len;i++)
		{
			System.out.println(a[0][i]);
		}
	}
}

OUT:













