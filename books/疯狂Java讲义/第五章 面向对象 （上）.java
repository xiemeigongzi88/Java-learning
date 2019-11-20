第五章 面向对象 （上）
面向对象的三大特征： 封装， 继承 多态

5.1 类和对象：
可以用 类来定义变量， 这种类型的变量统称为 引用变量， 所有类是引用数据类型

5.1.1 定义类：
类（class） 和 对象 （Object 也叫实例， instance）
类 是某一批对象的抽象， 可以把类理解为某种概念  对象才是具体存在的实体

类和对象是 面向对象的核心

[修饰符] class 类名
{
	构造器定义。。。
	Field。。。。
	方法。。。
}

[修饰符] ： public final abstract 

类里面各个成员之间的定义顺序没有任何影响，成员之间可以相互调用，
static 修饰的成员不能访问没有 static 修饰的成员 //？？？


Java 通过 new 关键字来调用构造器， 
构造器是一个类创建对象的根本途径，如果一个类没有构造器，这个类无法创建实例



Filed ：
[修饰符]：  1, public  2 protected 3, private, 4 static , 5 final 
其中 public protected private 只能出现一个 
static final 可以同时出现 来修饰 Field 


方法：
[修饰符]： 1, public 2, protected, 3,private, 
4, static , 5 final  6 abstract 

public private protected  三个里 只能出现一个 
abstract final 只能出现一个  都可以和 static 组合来修饰方法




static 是一个特殊的关键字， 可以修饰 方法 ， filed 
static  修饰的成员 表明它属于这个类本身 不属于该类的单个实例

static 真正作用： 区分   Field   方法   内部类   初始化模块 
是属于类本身 还是属于实例 


构造器： 
[修饰符] 构造器名(形参列表)
{
	
}

修饰符： public protected private   // 
// 构造器的 修饰符 只有：  private protected public 3 种 

构造器 不能定义返回值类型  也不能使用 void 定义构造器没有返回值

定义一个 Person 类 

public class Person 
{
	public String name;
	public int age;
	
	public void say(String content)
	{
		System.out.println(content);
	}
}
// 系统自动提供一个默认的构造器 




5.1.2 对象的产生和使用 

创建对象的根本途径是构造器， 通过 new 来调用某个类的构造器 创建这个类的实例

Person p=new Person();
// 通过 new  来创建 构造器 

static 修饰的方法 和 Field 既可以通过类名 来调用 也可以通过实例来调用
没有 static 修饰的普通 方法和 Filed 只能通过 对象 or 实例 来调用


// 赋值
p.name ="lee"; 
p.say("learning is easy");

System.out.println(p.name);



5.1.3 对象， 引用 和 指针

Person p=new Person();
产生2个东西： 一个是 p 变量， 一个是 Person 对象

栈内存里的引用变量并没有真正存储对象的 Field 数据，
对象的 Field 数据实际存放在堆内存里  heap 内存
引用变量只是指向该 堆内存的对象 
也就是说 p 只是存储一个地址 通过这个地址引用到实际对象


当一个对象被创建成功以后， 这个对象将保存在堆内存里，Java 程序
不允许直接访问堆内存中的对象，只能通过该 对象的引用  来 操作该对象

不管是数组还是 对象， 都只能通过引用来访问它们

p 引用变量 本身只是存储了一个 地址值

堆内存的对象 可以有多个引用 ，即 多个引用变量指向同一个对象

Person p2=p;
把 p 变量保存的地址交给 p2 变量，
这样 p2 变量和  p 变量都指向 堆内存中的 同一个对象

如果希望同之垃圾回收机制回收某个对象， 只需要切断该对象的所有引用变量和
它们之间的关系即可， 也就是将这些引用变量赋值为 null



Page 125 

5.1.4 对象的 this 引用

this 关键字总是指向调用该方法的对象

public class Dog
{
	public void jump()
	{
		System.out.println("executing JUMP...");
	}
	
	public void run()
	{
		Dog d=new Dog();
		d.jump();
		System.out.println("executing run method...");
	}
}

// 实现在 run 方法中调用 jump 方法。。。

public class DogTest
{
	public static void main(String[] args)
	{
		Dog dog= new Dog();
		dog.run();
	}
}

需要改写：

public class Dog
{
	public void jump()
	{
		System.out.println("executing jump method");
	}
	
	public void run()
	{
		this.jump();
		System.out.println("executing run method");
	}
}


Java 允许对象的一个成员直接嗲用另一个成员 省略 this 

public void run()
{
	jump();
	System.....
}

这样也是可以的



对于 static 修饰的方法而言， 使用类名来直接调用该方法 
static 修饰的方法中不能使用  this 引用
static 修饰的方法不能访问不使用 static 修饰的普通成员

所以  静态成员不能直接访问非静态成员


public class StaticAccessNonStatic 
{
	public void info()
	{
		System.out.println("simple info() method");
	}
	
	public static void main(String[] args)
	{
		info();
	}
}

无法从静态上下文中引用 非静态方法 info();

书上强调：
Java 编程的时候  不要使用 对象来调用 static 修饰的Field 方法。。。
而是应该使用 类名 去调用 static 修饰的 Field 方法 



由于构造器是直接使用 new 关键字来调用，而不是使用对象来调用的
所以 this 在构造器中的引用的是 该构造器进行初始化的对象

public class ThisInConstructor
{
	public int foo;
	public ThisInConstructor()
	{
		int foo=0;
		
		this.foo=6;
	}
	
	public static void main(String[] args)
	{
		System.out.println(new ThisInConstructor().foo);
	}
}

OUT:
6 

Page 128  this 当成普通方法的返回值  这里我不懂 画红线了 









Page 129 

5.2 方法详解

5.2.1 方法的所属性
方法不能独立存在， 逆序属于类 or 对象

如果方法使用 static 修饰， 则这个方法属于 类


方法 的属性：
（1）. 方法不能独立定义， 方法只能在类体里定义
（2）. 方法要么属于该类本身， 要么属于该类的一个对象
(3). 执行方法必须使用类 或者对象作为调用者


没有 static 修饰的方法则属于 该类的对象， 不属于这个类本身，
因此没有 static 修饰的方法只能使用对象对象作为嗲用这  调用，
不能使用类 作为调用者调用


5.2.2 方法的参数传递机制

Java 里的方法参数传递方式只有一种： 值传递；
就是将实际参数值的副本（复制值）传入方法内， 而参数本身不会受到任何影响

public class PrimitiveTransferTest
{
	public static void swap(int a, int b)
	{
		int tmp=a;
		a=b;
		b=tmp;
		
		System.out.println("a="+a+", b="+b);
	}
	
	public static void main(String[] args)
	{
		int a=6;
		int b=9;
		swap(a,b);
		System.out.println("after swapping: a="+a+", b="+b);
	}
}

OUT:
a=9, b=6
after swapping: a=6, b=9



Page 131 
Java 对于引用类型的参数传递，也是值传递

class DataWrap
{
	public int a;
	public int b;
}

public class ReferenceTransferTest
{
	public static void swap(DataWrap dw)
	{
		int tmp=dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		
		System.out.println("dw.a="+dw.a+" , dw.b="+dw.b);
	}
	
	public static void main(String[] args)
	{
		DataWrap dw= new DataWrap();
		dw.a=6;
		dw.b=9;
		swap(dw);
		
		System.out.println("dw.a="+dw.a+" , dw.b="+dw.b);
	}
}

OUT:
dw.a=9 , dw.b=6
dw.a=9 , dw.b=6

main() 方法中的 dw 只是一个引用（就是一个地址，一个指针），
dw 保存了 DataWrap 对象的地址值， 当把 dw 的值 赋值给 swap() 的 dw 形参后
就是让 dw 这个形参也保存了这个地址值

不管是 main() 方法里的dw 变量， 还是 swap() 方法里的 dw 形参，
其实都是 指向了 DataWrap里的那个对象， 它们操作的是同一个对象

如果改成：


	class DataWrap
{
	public int a;
	public int b;
}

public class ReferenceTransferTest
{
	public static void swap(DataWrap dw)
	{
		int tmp=dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		
		System.out.println("dw.a="+dw.a+" , dw.b="+dw.b);
		//add  this statement :
		dw=null; // swap 方法失去 DataWrap的引用
		// 不能再访问堆内存中的 DataWrap 对象，
		// 但是 main() 方法中的 dw 变量 不受任何影响 
	}
	
	public static void main(String[] args)
	{
		DataWrap dw= new DataWrap();
		dw.a=6;
		dw.b=9;
		swap(dw);
		
		System.out.println("dw.a="+dw.a+" , dw.b="+dw.b);
	}
}	

OUT：
dw.a=9 , dw.b=6
dw.a=9 , dw.b=6

	
Page 133 
	
5.2.3 形参个数可变方法 




5.2.4 递归方法

public class Recursive
{
	public static int fn(int n)
	{
		if(n==0)
		{
			return 1;
		}
		else if(n==1)
		{
			return 4;
		}
		else 
			return 2*fn(n-1)+fn(n-2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(fn(10));
	}
	
}


5.2.5 方法重载
Java 允许同一个类里定义多个同名方法，只要形参列表不同就行
如果同一个类中 包含了 两个或者两个以上的方法的方法名字相同 称为  方法重载

方法重载的要求就是两同一不同，  //  两同： 同一个类中 方法名字相同  
// 一不同： 形参列表不同 
同一个类中方法名相同， 参数列表不同

public class Overload
{
	public void test()
	{
		System.out.println("无参数");
	}
	
	public void test(String msg)
	{
		System.out.println("overload test method "+msg);
	}
	
	public static void main(String[] args)
	{
		Overload ol=new Overload();
		ol.test();
		
		ol.test("hello");
	}
}

OUT:
无参数
overload test method hello

Java 里不能使用方法返回值类型作为区分方法重载的依据 

public class OverloadVarargs
{
	public void test(String msg)
	{
		System.out.println("只有一个字符串的 test 方法");
	}
	
	public void test(String ... books)
	{
		System.out.println("****形参长度可变的 test 方法 ****");
	}
	
	public static void main(String[] args)
	{
		OverloadVarargs olv=new OverloadVarargs();
		
		olv.test();
		olv.test("aa","bb");
		olv.test("aa");
		
		olv.test(new String[]{"aa"});
	}
}



Page  137 - 175 

5.3 成员变量和局部变量
所有变量：

成员变量：
	实例Field（不用 static 修饰）
	类 Field（用 static 修饰）
	
局部变量：
	形参（方法签名中定义的变量）
	方法局部变量（再方法内定义）
	代码块局部变量（在代码块内定义）
	
类 Field 的作用域与这个类的生存范围相同；
实例 Field 的作用域与对应实例的生存范围相同

只要类存在， 程序就可以访问该类的Field 
只要实例存在， 程序就可以访问该实例的实例field

类的Field 也可以让该类的实例来访问

但是实例并不拥有这个类的Field， 


class Person
{
	public String name;
	public static int eyeNum;
}

public class PersonTest
{
	public static void main(String[] args)
	{
		System.out.println("Person 的 eyeNum 类 Field 值： "
		+Person.eyeNum); // 0
		
		Person p=new Person();
		
		System.out.println("p变量的 name Field值是： "+p.name
		+" p对象的 eyeNum Field 值是： "+p.eyeNum);// null 0 
		
		p.name="孙悟空";
		
		p.eyeNum=2;
		
		System.out.println("p变量的 name Field 值是： "+p.name
		+" p 对象的 eyeNum Field 值是： "+p.eyeNum); //
		
		System.out.println("Person 的eyeNum 类 Field 值： "+Person.eyeNum);  //2
		
		Person p2=new Person();
		
		System.out.println("p2 对象的 eyeNUm 类Field 值： "+p2.eyeNum); //2
	}
}

OUT:

Person 的 eyeNum 类 Field 值： 0
p变量的 name Field值是： null p对象的 eyeNum Field 值是： 0
p变量的 name Field 值是： 孙悟空 p 对象的 eyeNum Field 值是： 2
Person 的eyeNum 类 Field 值： 2
p2 对象的 eyeNUm 类Field 值： 2


实例也可以访问 类Field ， 同一个类的所有实例访问 类field的时候， 实际上访问的是
该 类本身的同一个 Field ， 就是 同一片内存区域 


局部变量：
(1). 形参
(2). 方法局部变量 
(3). 代码块局部变量


与成员变量 不同的是， 局部变量除了形参以外，都必须进行显式初始化
必须给 方法局部变量和代码块局部变量 指定初始值

public class BlockTest
{
	public static void main(String[] args)
	{
		int a;
		a=5;
		System.out.println("a="+a);
	}	
	
	System.out.println(a); // a 变量不存在
}

只要离开了代码块局部变量所在的代码块 这个局部变量就立即被销毁


public class MethodLocalVariableTest
{
	public static void main(String[] args)
	{
		int a;
		
		System.out.println("a="+a);
		// 出错 变量 a 没有初始化 
		a=5;
		System.out.println("a="+a);
	}
}

形参的作用域是整个方法体内有效，而且 形参也无须显式初始化

Java 允许局部变量和成员变量同名 

如果需要在这个方法里引用 被覆盖的成员变量，可使用 
this （实例 Field） 或者 类名 （类 Field ）作为调用者来访问成员变量

public class VariableOverrideTest
{
	private String name="Lee";
	
	private static double price =78.0;
	
	public static void main(String[] args)
	{
		int price =65;
		System.out.println("price="+price);
		
		System.out.println(VariableOverrideTest.price);
		
		new VariableOverrideTest().info();
	}
	
	public void info()
	{
		String name="Java";
		System.out.println(name);
		
		System.out.println(this.name);
	}
}

OUT:

price=65
78.0
Java
Lee

5.3.2 成员变量的初始化和内存中的运行机制

当系统加载类 或者 创建该类的实例的时候， 系统会自动为
成员变量分配内存空间，并在分配内存空间后，自动为成员变量指定初始值

Person p1=new Person();
Person p2=new Person();

p1.name="lee";
p2.name="abel";

p1.eyeNum=2;
p2.eyeNUm=3;

在类的准备阶段，系统会为该类的 类Field 分配内存空间 指定默认初始值


Page 142 

5.3.3  局部变量的初始化和内存中的运行机制

局部变量定义以后，必须经过显式初始化以后才能使用，
系统不会为局部变量执行初始化，
这意味着， 定义局部变量以后，系统并灭有为这个局部变量分配内存空间
直到程序为这个变量赋初始值的时候，系统才会为局部变量分配内存，
并将初始值保存到内存中

局部变量 不属于任何的类 对象和实例，
因为局部变量 总是保存在其所在方法的 栈内存中，（ stack ）
如果局部变量是基本类型的变量，则直接把这个变量的值保存在
该变量对应的内存中，

如果局部变量是一个引用类型的变量，那么这个变量存放的是地址，
通过该地址引用到该变量实际引用的对象或者是  数组

栈内存中的变量无需系统垃圾回收，
局部变量的作用域是从初始化开始，知道该方法或者代码块运行完成而结束

因为局部变量只保存基本类型的值 或者对象引用 
因此 局部变量所占的内存通常比较小


Page 143 
5.3.4 变量的使用规则 ：

定义一个成员变量时候， 成员变量将被放置在堆内存中，
成员变量的 作用域 将扩大到类存在范围 or  对象存在范围
这种范围扩大有2个害处：
（1）. 增大了变量的生存时间，导致更大的内存开销
（2）. 扩大了变量的作用域 不利于程序的内聚性

public class ScopeTest1
{
	static int i;
	public static void main(String[] args)
	{
		for(i=0;i<10;i++)
		{
			System.out.println("Hello");
		}
	}
}


public class ScopeTest2
{
	public static void main(String[] args)
	{
		int i;
		for(i=0;i<10;i++)
		{
			System.out.println("Hello");
		}
	}
}

public class ScopeTest3
{
	public static void main(String[] args)
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("Hello");
		}
	}
}

第三个更符合软件开发规范


Page 144 

5.4 隐藏和封装

5.4.1 理解封装
封装（Encapsulation） 是面向对象的三大特征之一
指的是：  将对象的状态信息隐藏在对象内部，不允许外部程序直接访问对象内部信息
而是通过该类所提供的方法来实现对内部信息的操作和访问

Field 都是被隐藏在独享内部的 


5.4.2 使用访问控制符：
Java 提供3个访问控制符：
private protected public 
Java 的访问控制级别从小到大：

private ---  default --- protected --- public 

private （当前类访问权限）
	如果类里的一个成员，（包括 Field 方法 构造器） 使用 private
访问控制符来修饰，那么这个成员只能在当前类的内部被访问，
这个访问控制符用于修饰 Field 最合适，
使用 private 修饰Field 就可以把 Field 隐藏在该类的内部

default （包访问权限）
	类里的一个成员（Field 方法 构造器） 不使用任何访问控制符修饰
	default 访问控制的成员 和 外部类 可以被相同包下的其他类访问
	
	
protected(子类访问权限)
	如果一个成员 （Field 方法， 构造器） 使用 protected 
	访问修饰符来修饰 那么这个成员既可以被同一个包中的其他类访问
	也可以被不同包中的子类访问
	如果 使用 protected 修饰一个方法， 通常是希望其子类来重写这个方法
	
	
public 
	一个成员被 public 修饰符修饰， 这个成员就可以被所有的类访问
	不管访问类和被访问类是否处于同一个包中，是否具有父子继承关系
	
局部变量，其作用域就是在它所在的方法里，不能被其他类访问

外部类只能有 两种访问控制级别： public + default
外部类不能使用 private 和 protected 修饰   // public  abstruct  final  
因为外部类没有处于任何类的内部， 也没有其所在类的内部，所在类的子类的两个范围
因此 private 和 protected 访问控制符对外部类 没有意义

外部类可以被 public 和 default 修饰 
使用 public 修饰的外部类 可以被 所有类使用
default 修饰的外部类可以被同一个包内的其他类使用

Person 类 实现了 很好的 封装（Encapsulation）


public class Person
{
	private String name;
	private int age;
	
	public void setName(String name)
	{
		if(name.length()> 6 || name.length()<2)
		{
			System.out.println("不符合要求");
			return;
		}
		else {
			this.name=name;
		}
	}
	
	public  String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		if(age>100 || age<0)
		{
			System.out.println("不符合要求");
			return;
		}
		else 
		{
			this.age=age;
		}
	}
	
	public int getAge()
	{
		return this.age;
	}
}

public class PersonTest
{
	public static void main(String[] args)
	{
		Person p=new Person();
		
	//	p.age=100;  出现错误
		// age 被 private 修饰， 只能在自己的类中被访问
		
		p.setAge(1000);
		System.out.println("age Field: "+p.getAge());
		
		p.setAge(30);
		System.out.println("age Field: "+p.getAge());
		
		p.setName("abel");
		System.out.println("name Field： "+p.getName());
	}
}


OUT:
不符合要求
age Field: 0
age Field: 30
name Field： abel
	
main() 方法不可以直接修改 Person 对象的 name 和 age 两个 Field  
只能通过各自的 setter 和 get 方法来获得这两个 Field 值 



Page 147 

5.4.3 package import import static  

Java 引入 包机制 package 提供了类的多层命名空间：

Java 源文件只用了 package 这个语句， 意味着 该源文件里定义的所有类都属于这个包含了

如：

package lee;
public class Hello
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!");
	}
}

package  语句必须作为源文件的 第一条非注释性语句
一个源文件只能指定一个包 ， 即只能包含一个 package 语句

同一个包下的类可以自由访问


package lee;
public class Hello
{
	public static void main(String[] args)
	{
		System.out.println("Hello World!");
	}
}

package lee;
public class HelloTest
{
	public static void main(String[] args)
	{
		Hello h=new Hello();
	}
}

import  可以向某个Java文件中导入指定 包层次下某个类 或者全部类 // 
// import  是导入类的 关键字

import 语句中的星号 * 只能代表类： 不能代表包 
使用 import lee.*; 表明导入 lee 包下的所有类

import 这部分 不想看

Page 147 - Page 151 完全没有看


Page 152 

5.5 深入构造器

构造器是创建对象的重要途径  Java类必须包含一个或者一个以上的构造器

5.5.1 使用构造器执行初始化：

构造器最大的用处就是在创建对象的时候执行初始化

系统默认初始化： 
	基本类型 Field ： 0
	boolean 类型： false 
	引用类型 Field ： null 
	
public class ConstructorTest
{
	public String name;
	public int count;
	
	public ConstructorTest(String name, int count)
	{
		this.name=name;
		this.count=count;
	}
	
	public static void main(String[] args)
	{
		ConstructorTest tc=new ConstructorTest("Java",90000);
		System.out.println(tc.name);
		System.out.println(tc.count);
	}
}


Page  154 
5.5.2 构造器重载

同一个类里具有多个构造器，多个构造器的形参列表不同，即 构造器的重载

构造器必须与类名相同，同一类的所有构造器的名字肯定相同
为了区分构造器， 多个构造器的参数列表必须不同


系统通过 new 调用构造器，系统将根据传入的实参列表来决定调用哪个构造器

public class ConstructorOverload 
{
	public String name;
	public int count;
	
	public ConstructorOverload()
	{
	}
	
	public ConstructorOverload(String name, int count)
	{
		this.name=name;
		this.count=count;
	}
	
	public static void main(String[] args)
	{
		ConstructorOverload oc1=new ConstructorOverload();
		ConstructorOverload oc2=new ConstructorOverload(
		"Java",23333);
		
		System.out.println(oc1.name+" "+oc1.count);
		System.out.println(oc2.name+" "+oc2.count);
	}
}

OUT:
null 0
Java 23333



如果系统包含多个构造器，其中一个构造器的执行体里完全包含另一个构造器的执行体

构造器不能直接被调用，构造器必须使用 new 关键字来调用

一旦使用 new 关键字来调用构造器，将会导致系统重新创建一个对象
为了在构造器中调用另外一个构造器的初始化代码，又不会重新创建一个 Java 对象
可以使用 this 关键字来调用相应的构造器


public class Apple
{
	public String name;
	public String color;
	public double weight;
	public Apple()
	{
	}
	
	public Apple(String name, String color)
	{
		this.name=name;
		this.color=color;
	}
	
	public Apple(String name, String color, double weight)
	{
		this(name,color);
		this.weight=weight;
	}
}

this(name,color); 调用表明调用该类另一个有两个字符串参数的构造器

Note：
使用 this 调用另一个重载的构造器只能在 构造器中使用， 而且必须作为构造器执行体中的
第一条语句。 使用 this 调用重载的构造器时，系统会根据 this 括号里面的实参来
调用形参列表与之对应的构造器



Page 156 

5.6 类的继承
继承时 面向对象的三大特征之一
Java的继承具有单继承的特点，每个子类只有一个直接 父类


5.6.1 继承的特点
Java的继承 通过 extends 关键字来实现

修饰符 class SubClass extends SuperClass
{
	...
}

子类是对父类的扩展
Java 子类不能获得父类的 构造器 

public class Fruit 
{
	public double weight;
	
	public void info()
	{
		System.out.println("I am a fruit: "+weight+" g");
	}
}

public class Apple extends Fruit
{
	public static void main(String[] args)
	{
		Apple a=new Apple();
		a.weight=56;
		a.info();
	}
}

OUT:
I am a fruit: 56.0 g


Java 只有一个直接父类， 但是Java可以有无限多个间接父类 
如：
class Fruit  extends Plant {...}
class Apple extends Fruit{...}

Plant 是 Apple 的间接父类

如果定义一个 Java 类的时候，
 并没有显式指定这个类的直接父类，
 则这个类默认扩展 java.lang.Object 类
 
java.lang.Object 类 是所有类的父类


Page 157 

5.6.2 重写父类的方法

子类总是以父类为基础，额外增加新的 field 和方法

public class Bird 
{
	public void fly()
	{
		System.out.println("fly");
	}
}

public class Ostrich extends Bird 
{
	public void fly()
	{
		System.out.println("run");
	}
	
	public static void main(String[] args)
	{
		Ostrich os=new Ostrich();
		os.fly(); // run 
	}
}

OUT：

子类 包含与父类同名方法的现象是 方法重写， or  方法覆盖 Override

方法重写要遵守： “两同两小一大”的规则：
两同： 方法名相同 形参列表  相同 
两小： 子类方法返回值要比父类方法返回值 类型要更小 或者相等
一大： 子类方法的访问权限应该比父类的方法的访问权限更大 or 相等

覆盖方法和被覆盖方法要么都是类方法，要么都是 实例方法， // static 
不能一个是类方法 一个是实例方法

class BaseClass
{
	public static void test(){...}
}

class SubClass extends BaseClass
{
	public void test(){...}
}


当子类覆盖了父类方法后，子类的对象将无法访问父类中被覆盖的方法
但是在子类方法中 可以调用被覆盖的方法
如果需要在子类方法中调用父类中被覆盖的方法，则可以使用 super(被覆盖的实例方法)
或者 父类类名（被覆盖的是类方法）作为调用者来调用父类中被覆盖的方法

如果父类方法具有  private 访问权限，则该方法对其子类是隐藏的，
因此其子类无法访问该方法，也就是无法重写该方法
如果子类中定义了一个与父类 private 方法具有相同方法名，相同的形参列表
形同的返回值的类型的方法， 依然不是重写 是在子类中重新定义了一个新方法 
下面的代码是对的

class BaseClass
{
	private void test(){...}
}

class SubClass extends BaseClass
{
	public static void test(){....}
}



Page 158 

5.6.3 super() 限定

如果需要在子类方法中调用父类被覆盖的实例方法，则可以使用 super限定
来调用父类被覆盖的实例方法

public void callOverrideMethod()
{
	super.fly();
}

super 是Java 提供的一个关键字
正如 this 不能出现在 static 修饰的方法中一样，
super 也不能出现在 static 修饰的方法中，
static 修饰的是 方法不是类， 

super 用于限定该构造器初始化的是该 对象从父类继承得到的 Field 
不是该类自己定义的 Field 

方法的重载： Overload 
方法的重写： Override

造方法不能有任何非访问性质的修饰符修饰，
例如 static 、 final 、 synchronized 、 abstract 等都不能修饰构造方法。

重载主要发生在同一个类的多个同名方法之间
重写发生在 子类和父类的同名方法之间

子类定义了和父类同名的 Field， 则会发生 子类 Field 隐藏父类 Field的情形

子类定义的方法直接访问该 Field 默认会访问到子类中定义的Field，
无法访问到父类中被隐藏的 Field
在子类定义的实例方法中可以通过 super() 来访问父类中被隐藏的 Field

class BaseClass
{
	public int a=5;
}

public class SubClass extends BaseClass
{
	public int a=7;
	
	public void accessOwner()
	{
		System.out.println(a);
	}
	
	public void accessBase()
	{
		System.out.println(super.a);
	}
	
	public static void main(String[] args)
	{
		SubClass sc= new SubClass();
		sc.accessOwner();
		sc.accessBase();
	}
}

OUT:
7
5


因为子类中定义与父类中同名的实例变量 并不会完全覆盖父类中定义的实例变量
它只是简单隐藏了 父类中的实例变量

class Parent 
{
	public String tag="Crazy Java Note";
}

class Derived extends Parent
{
	private String tag="Abel Batholomew";
	// 这个实例变量会隐藏父类中定义的 tag 实例变量
}

public class HideTest
{
	public static void main(String[] args)
	{
		Derived d=new Derived();
		
		System.out.println(d.tag); // error tag 是 private 变量
		
		System.out.println(((Parent)d).tag); //error: tag has private access in Derived
		// error: tag has private access in Derived
		
	}
}

OUT:
Crazy Java Note

((Parent)d).tag  先将 d 变量强制向上转型为 Parent 类型
再通过 d 来访问实例变量 tag 是可以的




PAge 160 
5.6.4 调用父类构造器
子类不会获得父类的构造器，但是
子类构造器里可以调用父类构造器的初始化代码 
在一个构造器中，调用另一个重载构造器使用 this 调用完成
在子类构造器中调用父类构造器使用 super 调用来完成

class Base
{
	public double size;
	public String name;
	public Base(double size, String name)
	{
		this.size=size;
		this.name=name;
	}
}

public class Sub extends Base
{
	public String color;
	public Sub(double size, String name, String color)
	{
		super(size, name);
		this.color=color;
	}
	
	public static void main(String[] args)
	{
		Sub s= new Sub(5.6, "test", "red");
		System.out.println(s.size+" "+s.name+" "+s.color);
	}
}

super 调用其父类的构造器， this 调用的是 同一个类中重载的构造器
使用 super 调用 父类构造器也必须出现在子类构造器执行体的第一行，
所以 this() 和 super() 调用不会同时出现

不管是否 使用 super 调用来执行 父类构造器的初始化代码
子类构造器总会调用父类构造器一次
（1）.子类构造器中显式执行体中第一行使用 super 显式调用父类构造器
（2）.子类构造器执行体的第一行使用 this 显式调用本类中重载的构造器
	系统根据 this 调用 里传入的形参列表调用 本类中的另一个构造器
	执行本类中另一个构造器时 会调用父类构造器
（3）.子类构造器执行体中 没有 super 和  this 调用，系统会在执行子类构造器之前，
	隐式调用父类无参数的构造器// 父类无参数 构造器 


创建任何 Java 对象，最先执行的总是 java.lang.Object 类的构造器


class Creature 
{
	public Creature () // 父类 无参数构造器 
	{
		System.out.println("Creature 无参数的构造器");
	}
}

class Animal extends Creature
{
	public Animal(String name)
	{
		System.out.println("Animal 带一个参数的构造器，"+name);
	}
	
	public Animal(String name, int age)
	{
		System.out.println("Animal 带两个参数的构造器，"+name+" age="+age);
	}
}

public class Wolf extends Animal
{
	public Wolf()
	{
		super("wolf",3);
		System.out.println("wolf 无参数的构造器");
	}
	
	public static void main(String[] args)
	{
		new Wolf();
	}
}

OUT:
Creature 无参数的构造器
Animal 带两个参数的构造器，wolf age=3
wolf 无参数的构造器


创建任何对象总是从该类所在继承树顶层类的构造器开始执行
然后一次向下执行，最后才执行本类的构造器
如果父类 通过 this 调用了同类中重载的构造器
就会依次执行父类的多个构造器




Page 163 

5.7 多态

5.7.1 多态性：

class BaseClass
{
	public int book=6;
	public void base()
	{
		System.out.println("父类普通方法");
	}
	
	public void test()
	{
		System.out.println("父类的被覆盖方法");
	}
}

public class SubClass extends BaseClass
{
	public String book="Java Note Book";
	
	public void test()
	{
		System.out.println("子类的 覆盖父类的方法");
	}
	
	public void sub()
	{
		System.out.println("子类的普通方法");
	}
	
	public static void main(String[] args)
	{
		BaseClass bc= new BaseClass();
		System.out.println(bc.book);
		
		bc.base();
		bc.test();
		
		SubClass sc=new SubClass();
		System.out.println(sc.book);
		
		sc.base();
		sc.test();
		
		BaseClass ploymophicBc= new SubClass();
		System.out.println(ploymophicBc.book);
		ploymophicBc.base();
		ploymophicBc.test();
		
		// ploymophicBc.sub(); // error 
	}
}

OUT:
6
父类普通方法
父类的被覆盖方法

Java Note Book
父类普通方法
子类的 覆盖父类的方法
6
父类普通方法
子类的 覆盖父类的方法	
		


BaseClass ploymophicBc= new SubClass();
		System.out.println(ploymophicBc.book);
		ploymophicBc.base();
		ploymophicBc.test();
		ploymophicBc.sub(); // error 
		
		
编译类型是 BaseClass, 运行类型是 SubClass
Java允许 把子类的对象直接赋给一个父类引用变量， 无需任何类型转换
叫做 向上转型（upcasting）

当运行时调用该引用变量的方法的时候，其方法行为总是表现出子类方法的行为特征
而不是父类方法的行为特征，这就可能出现：
相同的变量， 调用同一个方法的时候 呈现出多种不同的行为特征 这就是多态

ploymophicBc.sub(); // error  
虽然 ploymophicBc 引用变量实际上却是包含 sub() 方法，但是
编译类型是 BaseClass , 编译无法调用 sub() 方法。。。

对象的 Field 则不具备多态性，

Note：
（1）. 引用变量在编译阶段只能调用其编译时候所具有的方法，
	但是运行则执行它 运行时则执行它运行时类型所具有的方法 ，
	所以， 引用变量只能嗲用声明该变量时所用类里包含的方法 
	Object p= new Person() 
	定义一个变量 p, p 只能调用 Object 类的方法
	不能调用 Person 类里的方法
（2）. 通过引用变量来访问其 包含的实例变量 Field 的时候， 系统总是访问
它编译时候所定义的 Field， 而不是它运行时所定义的 Field 



Page 164 

5.7.2 引用变量的强制类型转换

引用变量只能调用它编译时候的方法， 不能调用它运行时候方法
如果需要让这个引用变量调用它运行时类型的方法，则必须把它强制类型转化成 运行类型
() 类型转换运算符 可以将一个基本类型变量转换成 另一个类型
()  可以将 一个引用类型变量转换成其子类型
Note：
(1). 基本类型之间的转换 只能在数值类型之间进行 数值类型和 波尔类型之间不能进行类型转换
(2). 引用类型之间的转换只能在具有继承关系的两个类型之间进行 // important 
	如果试图把一个父类实例转换成 子类类型，则这个对象必须时子类实例
(3).

public class ConversionTest
{
	public static void main(String[] args)
	{
		double d=13.4;
		long l=(long)d;
		System.out.println(l);
		
		int in=5;
		boolean b=(boolean)in; // error 
		
		Object obj="Hello";
		
		String objStr=(String)obj;
		System.out.println(objStr);
		
		Object objPri=new Integer(5);
		String str=(String)objPri;
	}
}

强制类型转换可能出现异常
因此 进行强制类型转换 要 通过  instanceof 运算符来判断是否能转换成功

if(objPri instanceof String)
{
	String str=(String)objPri;
}

Note :
把子类对象赋给父类引用变量的时候， 是 向上转型（upcasting） 是可以成功的
但是在实际执行它的方法的时候，依然表现出子类对象的行为方式

把一个父类对象赋给一个子类变量引用的时候，需要强制类型转换
还有可能产生 ClassException 
可以使用 instanceof 运算符让强制类型转换更安全


Page 166 

5.7.3 instanceof 运算符
instanceof 运算符的前一个操作数 通常是一个引用类型变量
后一个操作数是一个类
用于判断 前面的对象是否是后面的 类，子类 是 返回 true 不是 返回 false 

instanceof 运算符前面的操作数的编译时类型要么与后面的类相同
要么与后面的类具有父子继承关系

public class InstanceofTest
{
	public static void main(String[] args)
	{
		Object hello="Hello";
		System.out.println("字符串是否是 Object 类的实例 "
		+(hello instanceof Object));
		
		System.out.println("字符串是否是 String 类的实例： "
		+(hello instanceof String));
		
		System.out.println("字符串是否是 Comparable 接口的实例"
		+(hello instanceof Comparable));
		
		String a="hello";
		System.out.println("字符串是否是 Math 类的实例"
		+(a instanceof Math)); //error

	}
}
字符串是否是 Object 类的实例 true
字符串是否是 String 类的实例： true
字符串是否是 Comparable 接口的实例 true

OUT：
Line 17: error: incompatible types:
String cannot be converted to Math

Note :
instanceof 运算符的作用是： 在强制类型转换前，先判断前一个对象是否是后一个类的实例
是否可以保证成功转换

instanceof 和(type)是 Java提供的
先用 instanceof 判断一个对象是否可以强制类型转换
再用 (type) 来 进行强制类型转换


Page 166 

5.8 继承与组合 

5.8.1 使用继承的注意点

子类可以从父类继承得到 Field 和 方法，继承破坏了 父类的封装性
每一个类都应该封装它内部信息和实现细节，只暴露必要的方法给其他类使用

父类设计：
（1）。 尽量隐藏父类的内部数据
（2）. 不要让子类随意访问 修改父类的方法 
（3）. 尽量不要在 父类 构造器中 调用 将要被子类重写的方法

class Base
{
	public Base()
	{
		test();
	}
	
	public void test() //1-test
	{
		System.out.println("将被子类重写的方法");
	}
}

public class Sub extends Base
{
	private String name;
	public void test()  //2-test
	{
		System.out.println("子类重写父类方法： "+name.length());
	}
	
	public static void main(String[] args)
	{
		Sub s=new Sub();
	}
}
// 出现 空指针异常 
OUT:
Error:
Exception in thread "main" java.lang.NullPointerException
	at Sub.test(Sub.java:19)
	at Base.<init>(Sub.java:5)
	at Sub.<init>(Sub.java:14)
	at Sub.main(Sub.java:24)
	
	
创建 Sub 对象的时候，同样会先执行父类构造器，
如果 父类构造器调用了 被子类重写的方法，则变成调用被子类重写后的方法

创建 Sub 对象的时候，会先执行 Base 中的 构造器，而构造器 调用了 test() 方法。。。
2- test 被调用，而 name Field  = null 引发空指针异常



Page 168 

5.8.2 利用组合实现复用

子类 可以直接获得父类的 public 方法，程序使用子类时候，将可以直接访问子类
从父类那里继承得到的方法， 
组合是 把旧类对象作为 新类的 Field 嵌入， 实现新类的功能


class Animal 
{
	private void beat()
	{
		System.out.println("heart beats ...");
	}
	
	public void breath()
	{
		beat();
		System.out.println("breath, breath, breathe...");
	}
}

class Bird extends Animal
{
	public void fly()
	{
		System.out.println("I am flying ...");
	}
}

class Wolf extends Animal
{
	public void run()
	{
		System.out.println("I am running...");
	}
}

public class InheritTest
{
	public static void main(String[] args)
	{
		Bird b= new Bird();
		b.breath();
		b.fly();
		
		Wolf w=new Wolf();
		w.breath();
		w.run();
	}
}

OUT:
heart beats ...
breath, breath, breathe...
I am flying ...
heart beats ...
breath, breath, breathe...
I am running...

也可以：

class Animal 
{
	private void beat()
	{
		System.out.println("heart beats...");
	}
	
	public void breath()
	{
		System.out.println("breath, breath, breathe...");
	}
}

class Bird 
{
	private Animal a;
	public Bird(Animal a)
	{
		this a=a;
	}
	
	public void breath()
	{
		a.breath();
	}
	
	public void fly()
	{
		System.out.println("I am flying ...");
	}
}

class Wolf
{
	private Animal a;
	
	public Wolf(Animal a)
	{
		this.a=a;
	}
	
	public void breath()
	{
		a.breath();
	}
	
	
	public void run()
	{
		System.out.println("I am running...");
	}
}

public class CompositionTest
{
	public static void main(String[] args)
	{
		Animal a1=new Animal();
		Bird b=new Bird(a1);
		b.breath();
		b.fly();
		
		Animal a2=new Animal();
		Wolf w=new Wolf(a2);
		w.breath();
		w.run();
	}
}


OUT:
breath, breath, breathe...
I am flying ...
breath, breath, breathe...
I am running...	
	
	
继承要表达的是 is-a 关系  组合表达的是 has-a 关系


Page 171 

5.9 初始化块
 
Java 的类里面有 4种 成员 ：  Filed 方法  构造器  初始化块
一个类里可以有多个初始化块， 相同类型的初始化块之间有顺序
前面的初始化块先执行  后面定义的初始化块 后执行

初始化块的修饰符只能是 static 使用 static 修饰的初始化块被称为 静态初始化块

public class Person
{
	{
		int a=6;
		
		if(a>4)
		{
			System.out.println("Person 初始化块： a>4");
		}
	
		System.out.println("Person 的初始化块");
	}
	
	{
		System.out.println("Person 第二块初始化块");
	}
	
	public Person()
	{
		System.out.println("Person 无参数构造器");
	}
	
	public static void main(String[] args)
	{
		new Person();
	}
}

OUT:
Person 初始化块： a>4
Person 的初始化块
Person 第二块初始化块
Person 无参数构造器

初始化块 和 构造器的 差异：

普通初始化块， 声明实例 Field 指定的默认值都可以认为是对象的初始化代码
它们的执行顺序与 源程序种的排列顺序相同

public class InstanceInitTest
{
	{
		a=6;
	}
	
	int a=9;
	
	public static void main(String[] args)
	{
		System.out.println(new InstanceInitTest().a);
	}
}

OUT:
9

初始化顺序：
先执行 初始化块 or 声明 Field 时指定的初始值，在执行构造器里的指定的初始值



Page 172 
5.9.2 初始化块和构造器

初始化块在 构造器之前 执行
初始化块时一段固定的代码 不能接受任何参数 

	
	
	
Page 173 

5.9.3 静态初始化块：

静态初始化块和 类相关的，系统将 类初始化阶段执行静态初始化块，
而不是在创建对象的时候才执行， 静态初始化块总是比普通初始化块先执行

静态初始化块 不能对实例 Field 进行初始化处理

静态初始化块 不能访问非静态成员 

// 这部分不懂
class Root
{
	static 
	{
		System.out.println("Root 的静态初始化块");
	}
	
	{
		System.out.println("Root 的普通初始化块");
	}
	
	public Root()
	{
		System.out.println("Root 的无参数的构造器");
	}
}

class Mid extends Root
{
	static {
		System.out.println("Mid 的静态初始化块");
	}
	
	{
		System.out.println("Mid 的普通初始化块");
	}
	
	
	public Mid()
	{
		System.out.println("Mid 的无参数的构造器");
	}
	
	public Mid(String msg)
	{
		this();
		System.out.println("Root 的参数的构造器 "+msg);
		
	}
}

class Leaf extends Mid
{
	static 
	{
			System.out.println("Leaf 的静态初始化块");
	}
	
	{
		System.out.println("Leaf 的普通初始化块");
	}
	
	public Leaf()
	{
		super("Crazy Java");
		System.out.println("executing Leaf constructor ...");
	}
}

public class Test
{
	public static void main(String[] args)
	{
		new Leaf();
		 System.out.println();
		new Leaf();
	}
}


OUT:

Root 的静态初始化块
Mid 的静态初始化块
Leaf 的静态初始化块
Root 的普通初始化块
Root 的无参数的构造器
Mid 的普通初始化块
Mid 的无参数的构造器
Root 的参数的构造器 Crazy Java
Leaf 的普通初始化块
executing Leaf constructor ...

Root 的普通初始化块
Root 的无参数的构造器
Mid 的普通初始化块
Mid 的无参数的构造器
Root 的参数的构造器 Crazy Java
Leaf 的普通初始化块
executing Leaf constructor ...
	
	
静态初始化块 和 声明 静态 Field 时是指定的 初始值都是该类的初始化代码
它们的执行顺序与 源程序中 的排列 相同

public class StaticInitTest
{
	static 
	{
		a=6;
	}
	
	static int a=6;
	
	public static void main(String[] args)
	{
		System.out.println(StaticInitTest.a);
	}
}

6


	
	
	
	
	
	
	
	
	
	
	
	
	













