5 Chapter 面向对象（上）
面向对象的3大特征： 封装 继承 多态

5.1 类和对象
5.1.1 定义类

所有的类 都是 引用数据类型：

定义类的语法：
【修饰符】 class 类名字
{
	0 到多个 构造器的定义；
	0 到多个 Field；
	0 到多个  方法；
}

【修饰符】： public final abstract  // 用来定义类 class 

类里面： 3种常见成员：
构造器， Field， 方法；
类里 成员之间的顺序没有影响，成员之间可以互相调用， 
static 修饰的成员不能访问没有 static 修饰的成员

public class Person
{
	public String name;
	public int age;
	
	public void say(String content)
	{
		System.out.println(content);
	}
}


5.1.2 对象的产生和使用

public class Person
{
	public String name;
	public int age;
	
	public void say(String content)
	{
		System.out.println(content);
	}
}

Person p=new Person();

static 修饰的方法和 field， 既可以通过类来调用， 也可以通过对象调用
没有经过 static 修饰的普通方法和 Field，只能通过对象调用 //important 
 

5.1.3 对象，引用和指针

Person p= new Person();
产生2个东西： 一个是 p 变量， 一个是 Person 对象

栈内存里的引用变量并未真正存储对象的 Field 数据， 
对象的 Field 数据实际存放在堆内存里
Java；里的引用就是 C的 指针

p 引用变量本身只是存储了一个地址
 
public class Person
{
	public String name;
	public int age;
	
	public void say(String content)
	{
		System.out.println(content);
	}
}
Person p=new Person();

Person p2= p;
把 p 变量的值赋给 p2 变量，也就是说， 将 p 变量保存的地址值赋给 p2，
这样 p2 和 p 变量将指向堆内存里的同一个Person对象
 
如果堆内存里的对下个没有任何变量指向该对象，那么程序将无法再访问这个对象，
这个对象(Person )也就编程垃圾，Java的垃圾回收机制将回收这个对象，释放这个对象所占的内存区

如果主动希望垃圾回收机制回收某个对象，只需要切断该对象的所有引用变量和它之间的关系
，也就是把这些引用变量赋值为null 

5.1.4 对象的 this 引用、
this 关键字总是指向调用该方法的对象
this 默认引用的 两种情形：
1）。 构造器中引用该构造器正在初始化的对象
2）。 在方法中调用该方法的对象

class Dog
{
	public void jump()
	{
		System.out.println("jump method");
	}
	
	public void run()
	{
		Dog d= new Dog();
		d.jump();
		System.out.println("executing RUN method");
	}
}

public class DogTest
{
	public static void main(String[] args)
	{
		Dog dog= new Dog();
		dog.run();
	}
}

//以上的代码是可以执行的


class Dog
{
	public void jump()
	{
		System.out.println("jump method");
	}
	
	public void run()
	{
		//Dog d= new Dog(); // 不需要重新创建一个DOG对象
		jump();
		System.out.println("executing RUN method");
	}
}

public class DogTest
{
	public static void main(String[] args)
	{
		Dog dog= new Dog();
		dog.run();
	}
}
OUTPUT：
jump method
executing RUN method


// 这个也是可以执行的
这本书 这部分可以更新了


程序改写：

public class Dog
{
	public void jump()
	{
		System.out.println("executing JUMP method");
	}
	
	public void run()
	{
		this.jump();
		// Java 允许对象的一个成员直接调用另外一个成员，可以省略 this 前缀
		System.out.println("executing RUN method");
	}
}

一个方法访问该类中定义的其他方法， field时，加不加 this 前缀的效果时一样的

对于 static 修饰的方法而言， 则可以使用类来直接调用该方法，
如果在 static 修饰的方法中使用 this 关键字， 则这个关键字无法指向合适的对象，
所以， static 修饰的方法中不能使用 this 引用、
所以， 静态成员不能直接访问非静态成员
// 我的理解是： static 指向一个固定的堆地址， 如果使用 this 引用的话， this 是指向不同的对象
// 对象的堆地址不同，this 引用对象的地址不同 而 static 的地址是固定的 所以， 
// 用 static 修饰的方法里， 不能使用 this 的引用 


//important 
public class StaticAccessNonStatic
{
	public void info()
	{
		System.out.println("info method");
	}
	
	public static void main(String[] args)
	{
		// main（） 时静态的方法， info() 是非静态的方法
		//省略 this无法指向有效的对象
		info();
	}
}

OUTPUT:
error:
// 我可以改一下：
两种方法：
1. info() 前面+ static修饰
2。 在 main() 函数里， 创建一个 StaticAccessNonStatic 的对象，
	用这个对象调用 info() 方法，或者创建一个对象去调用这个 info() 方法


public class StaticAccessNonStatic
{
	public static void info() // static 
	{
		System.out.println("info method");
	}
	
	public static void main(String[] args)
	{
		// main（） 时静态的方法， info() 是静态的方法
		//省略 this无法指向有效的对象
		info();
		// 这样是可以的  
	}
}
OUT:

这样是可以的
info method



public class StaticAccessNonStatic
{
	public static void info()
	{
		System.out.println("info method");
	}
	
	public static void main(String[] args)
	{
		// main（） 时静态的方法， info() 是非静态的方法
		//省略 this无法指向有效的对象
		 StaticAccessNonStatic.info();
	}
}
// 这样也是可以的
	
	
public class StaticAccessNonStatic
{
   private static int a=1; 
	public static void info()
	{
		System.out.println("info method");
	}
	
	public static void main(String[] args)
	{
		// main（） 时静态的方法， info() 是非静态的方法
		//省略 this无法指向有效的对象
		 StaticAccessNonStatic.info();
        System.out.println(a);
		info(); 
		// static void info()
		// static int a
		// static 修饰
	}
}
OUT：
info method
1
info method
// 这样也是可以的


 
补充内容：

// 11 2-4 类变量-1 
static + 成员变量
类变量不属于任何一个对象， 任何一个对象都拥有这个类变量
但是类变量不在每一个对象里面
它是类的变量， 类变量属于类
访问类变量：
如：
private static int step =1;
访问类变量：
Display.step=2;
或者： Display d1= new Dispaly();
	 d1.step=2;
	 


package clock;

public class Display {
	private int value=0; // 私有的
	private int limit=0;
	private static int step =1;
	
	public Display(int limit) // 构造函数：
	{
		this.limit=limit;
	}
	
	public void increase() {
		value++;
		if(value==limit) {
			value=0;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d1=new Display(10);
		Display d2=new Display(20);
		d1.increase();
		System.out.println(d1.getValue()); //1
		System.out.println(d2.getValue()); //0
		System.out.println(d1.step); //1
		System.out.println(d2.step);  //1 
		d1.step=2;
		System.out.println(d1.step); //2
		System.out.println(d2.step); //2 
		
	}
}

OUTPUT:
Finished in 92 ms
1 //d1.value
0 //d2.value
1 //d1.step;
1 //d2.step;
2 //d1.step;
2 //d2.step;


public class Display {
	private int value=0; // 私有的
	private int limit=0;
	private static int step =1;
	
	public Display(int limit) // 构造函数：
	{
		this.limit=limit;
	}
	
	public void increase() {
		value++;
		if(value==limit) {
			value=0;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d1=new Display(10);
		Display d2=new Display(20);
		d1.increase();
		System.out.println(d1.getValue());
		System.out.println(d2.getValue());
		System.out.println(d1.step);
		System.out.println(d2.step);
		d1.step=2;
		System.out.println(d1.step);
		System.out.println(d2.step);
		
		Display.step=3; //Display是类， step 是成员变量
		// 这里没有 对象， 也就是 类.成员变量
		System.out.println(d1.step);
		System.out.println(d2.step);
		
		// 如果有：
		Display.value=3; // 这是不能访问这个value
	}
}
// 也就是说， 只有通过 类.成员变量 才能访问 static 的成员变量 
所以， static 叫做 类变量，不是成员变量，是类的变量，
static 类变量 不属于 这个类中的任何一个对象，static 类变量属于 类 class
所以， 任何对象都拥有这个 类变量  
同时， 类变量 不在 对象中




OUTPUT:
1
0
1
1
2
2
3
3

在 class Display 里设置成员变量：
private static int step =1;


//12 2-4 类变量-2  类函数
类函数 有 static

static 函数 不属于任何对象， 它属于这个类
static 函数只能访问 static 函数

public class Display {
	private int value=0; // 私有的
	private int limit=0;
	private static int step =1;
	
	public Display(int limit) // 构造函数：
	{
		this.limit=limit;
	}
	
	public void increase() {
		value++;
		if(value==limit) {
			value=0;
		}
	}
	
	public int getValue(){
		return value;
	}
	
	public static void f(){ // important 这个可以调用
	在 static 的函数里面 可以调用 其他 static 的函数
	也可以通过一个对象来调用 static 的函数
	但是  在 static  的函数里面 不能访问一个 non-static 的成员变量
		
	比如说： 在 public static void f(){
		里面， 不能 value++ ; // important 
		// REPEAT： 在 一个 static 函数里面 不能访问一个 non-static 的成员变量
	}

		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Display d1=new Display(10);
		Display d2=new Display(20);
		d1.increase();
		f();
		System.out.println(d1.getValue());
		System.out.println(d2.getValue());
		System.out.println(d1.step);
		System.out.println(d2.step);
		d1.step=2;
		System.out.println(d1.step);
		System.out.println(d2.step);
		
		Display.step=3; //Display是类， step 是成员变量
		// 这里没有 对象， 也就是 类.成员变量
		System.out.println(d1.step);
		System.out.println(d2.step);
		
		// 如果有：
		Display.value=3; // 这是不能访问这个value
	}
}


如果有：
	public int getValue(){
		return value;
	}
	
	public static void f(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	// 可以调用 f（） 函数
		f(); // 因为大家都是 static
		// 不需要通过 对象来调用 static 函数 f();
		// 在static 函数里 可以调用其他的static 函数
		// 也可以：
		d1.f();
	}
	
	如果在public static void f(){
		value++;//important：  是不行的， 你不能在一个 static 函数里访问一个非static的变量
	}
	
static 函数只能调用 static 的函数， 只能访问 static 的成员变量
static 的函数 和 成员变量 都能通过类的名字去访问， 也可以通过某个对象的名字去访问
	
static int step =2;
这个 static 类变量只能初始化一次 // ???
比如说：
d1.step=3;
那么所有的 step 都 step=3;



public class A
{
    static int a=5;
    static void f()
    {
        System.out.println("OK: "+a);
    }
    
    public static void main(String[] args)
    {
        A a= new A();
        a.f();
    }
}

OUT：
OK:5


注意：
Java编程的时候， 不要使用对象去调用 static修饰的 Field，方法，
而是使用类去调用 static修饰的 Field， 方法，


this 引用也可以用于构造器中作为默认引用， 由于构造器直接使用 new 关键字
来调用， 而不是使用对象来调用， 所以 this 在构造器中引用的是该构造器进行
初始化的对象
因为构造器 不可避免使用 this , 而 static 和 this 无法共存，
所以， static 是不能修饰构造器的 


public class ThisConstructor
{
	public int foo;
	
	public ThisConstructor()
	{
		int foo=0;
		this.foo=6; // this - 指的是： 成员变量
	}
	
	public static void main(String[] args)
	{
		System.out.println(new ThisConstructor().foo);
	}
}
OUT： 6



Page 113 

Return this 这个我看不明白： //important




Page 129 


5.2 方法详解：
5.2.1 方法的所属性：
1）。 方法不能独立定义， 方法只能在类体里定义
2）。 方法要么属于该类的本身，要么属于该类的一个对象 // 方法怎么属于 一个类
3）。 永远不要独立执行方法， 执行方法必须使用类或者对象作为调用者
4）。 使用 static 修饰的方法属于这个类本身， 使用 static 修饰的方法
	既可以使用类作为调用者调用， 也可以使用对象作为调用者调用
	
5.2.2 方法的参数转递机制：
public class PrimitiveTransferTest
{
	public static void swap(int a, int b)
	{
		int t=a;
		a=b;
		b=t;
		System.out.println("a="+a+" b="+b );
	}
	
	public static void main(String[] args)
	{
		int a=6;
		int b=5;
		swap(a,b);
		System.out.println("a="+a+" b="+b );
	}
}

OUTPUT:
a=5 b=6
a=6 b=5


引用类型的参数传递：

class DataWrap
{
	public int a;
	public int b;
}

public class ReferenceTransferTest
{
	public static void swap(DataWrap dw) // 这个方法有 static 
	// 所以在 main() 里可以直接调用
	
	{
		int tmp= dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		System.out.println("a="+dw.a+" b="+dw.b );
	}
	
	public static void main(String[] args)
	{
		DataWrap dw= new DataWrap();
		dw.a=6;
		dw.b=9;
		swap(dw);
		System.out.println("a="+dw.a+" b="+dw.b );
	}
}
OUTPUT:
a=9 b=6
a=9 b=6



class DataWrap
{
	public int a;
	public int b;
}

public class ReferenceTransferTest
{
	public static void swap(DataWrap dw) // 这个方法有 static 
	// 所以在 main() 里可以直接调用
	
	{
		int tmp= dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		
	}
	
	public static void main(String[] args)
	{
		DataWrap dw= new DataWrap();
		dw.a=6;
		dw.b=9;
		System.out.println("a="+dw.a+" b="+dw.b );
		swap(dw);
		System.out.println("a="+dw.a+" b="+dw.b );
	}
}

OUT：
a=6 b=9
a=9 b=6

也可以把方法里的 static 去掉：


class DataWrap
{
	public int a;
	public int b;
}

public class ReferenceTransferTest
{
	public void swap(DataWrap dw) // 这个方法有 static 
	// 所以在 main() 里可以直接调用
	
	{
		int tmp= dw.a;
		dw.a=dw.b;
		dw.b=tmp;
		
	}
	
	public static void main(String[] args)
	{
		DataWrap dw= new DataWrap();
        ReferenceTransferTest a=new ReferenceTransferTest();
		dw.a=6;
		dw.b=9;
		System.out.println("a="+dw.a+" b="+dw.b );
		a.swap(dw);
		System.out.println("a="+dw.a+" b="+dw.b );
	}
}
OUT：
a=6 b=9
a=9 b=6


注意： 
main() 和 swap() 方法中的 dw 是两个不同的变量；
不管是操作 main() 方法里的 dw变量， 还是 操作 swap() 方法里的 dw变量，
其实都是操作它所引用的 DATa Wrap对象， 他们操作的是同一个对象

其实：
main() 方法中的 dw 是一个引用（也就是一个指针），它保存了DataWrap对象的地址值
当把 dw 的值赋给 swap() 的形参 dw 以后，让 swap() 中的 dw形参也保留了这个地址值

 
5.2.3 参数个数可变的方法：

// 不想看


Page134：

5.2.4 递归方法：

public class Recursive
{
	public static int f(int n)
	{
		if(n==0)
			return 1;
		
		else if(n==1)
			return 4;
		
		else 
			return 2*f(n-1)+f(n-2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(10));
	}
}

10497

public class Recursive
{
	public static int f(int n)
	{
		if(n==20)
			return 1;
		
		else if(n==21)
			return 4;
		
		else 
			return f(n+2)-2*f(n+1);
	}
	
	public static void main(String[] args)
	{
		System.out.println(f(10));
	}
}

OUTPUT:
-3771


5.2.5 方法重载：
Java 不能使用方法返回类型 作为区分方法重载的依据



Page137 

5.3 成员变量和局部变量

Page 138:

class Person
{
	public String name; // null 
	public static int eyeNum; // 0 static 
}

public class PersonTest
{
	public static void main(String[] args)
	{
		System.out.println("Person 的Field 值： "+Person.eyeNum); //0
		
		Person p= new Person();
		System.out.println("p 变量的 name field 值是： "+p.name  //null
		+" p 变量的 eyeNum field 值： "+ p.eyeNum);  //0
		
		p.name="zhang";
		p.eyeNum=2;
		System.out.println("p 变量的 name field 值是： "+p.name // zhang
		+" p 变量的 eyeNum field 值： "+ p.eyeNum);  //2
		
		System.out.println("Person 的Field 值： "+Person.eyeNum); //2
		
		Person p2=new Person();
		System.out.println("p2 变量的 eyeNum field 值： "+ p2.eyeNum); //2
	}
}
		
OUT:
Person 的Field 值： 0
p 变量的 name field 值是： null p 变量的 eyeNum field 值： 0
p 变量的 name field 值是： zhang p 变量的 eyeNum field 值： 2
Person 的Field 值： 2
p2 变量的 eyeNum field 值： 2
		
		
		
public class BlockTest
{
	public static void main(String[] args)
	{
		int a;
		a=5;
		System.out.println("局部变量a: "+a);
	}
	
	System.out.println(a); //error 
}

	
		
		
		
		

Java 允许局部变量和成员变量同名，若果它们同名，局部变量会覆盖成员变量
用 this 调用被覆盖的成员变量

public class VariableOverrideTest
{
	private String name="Lee";
	private static double price= 78;
	
	public void info()
	{
		String name="Sam";
		
		System.out.println(name); //Sam  
		System.out.println(this.name);// 输出成员变量的值 Lee
	}

		
	public static void main(String[] args)
	{
		int price=66;
		System.out.println(price); //66
		
		System.out.println(VariableOverrideTest.price); // 78
		
		new VariableOverrideTest().info();
	}
}

OUTPUT:
66
78.0
Sam
Lee
	
	
public class VariableOverrideTest
{
	private String name="Lee";
//	private static double price= 78;
	
	public void info()
	{
		String name="Sam";
		
		System.out.println(name); //Sam  
		System.out.println(this.name);// 输出成员变量的值 Lee
	}

		
	public static void main(String[] args)
	{
		int price=66;
		System.out.println(price); //66
		
		System.out.println(VariableOverrideTest.price); // 78
		
		new VariableOverrideTest().info();
	}
}
OUT:
Line 20: error: cannot find symbol: variable price 
也就是说， main() 里面的 price 是局域变量，只在 main() 里面起作用
		关掉 成员变量： private static double price =78;
		结果发生 error ;
		估计是 成员变量 作用在整个类内， 而局域变量只能在它自己的括号里起作用
		
		
		
		
		
	
Page 144：

5.4 隐藏和封装
封装： 指的是将对象的状态信息隐藏在对象内部，
不允许外部程序直接访问对象内部信息，
而是通过该类所提供的方法来实现对内部信息的操作和访问

Java提供 3个访问控制符：
private protected public 
+ 不加任何访问控制符的访问控制


Page 5.4.3 package ， import 和 import static

Java 允许一组功能相关的类放在同一个 package 下

package lee;
public class Hello
{
	public static void main(String[] args)
	{
		
	}
}

Hello.class 必须放在 lee 这个文件夹下才能有效

为Java类 添加包 必须在 Java 源文件中通过 package 语句指定
单靠目录名没有办法指定

Java 的 包机制需要两个方面保证：
1）。 源文件里使用 package 语句指定包； 
2）。 class 文件必须放在对应的路径下

同一个包下的类可以自由访问：

package lee;

class Hello
{
	public static void main(String[] args) //注意这里是 main() 函数
	{
		System.out.println("Hello World!");
	}
}

public class HelloTest
{
	public static void main(String[] args)
	{
		Hello h= new Hello();
	}
}


Or:
class Hello
{
	public static void f()// 注意这里不是 main() 
	{
		System.out.println("Hello World!");
	}
}

public class HelloTest
{
	public static void main(String[] args)
	{
		Hello h= new Hello();
		// 直接访问相同包下的另一个类，无需使用包前缀
        h.f();
	}
}
OUTPUT:
Hello World!


Page 150：

import 关键字， import 可以向某个 Java 文件中导入指定包层次下某个类 or 全部类

import package.subpackage...ClassName 

如：
import java.util.Arrays;
import java.util.ArrayList;

 
如果 import 也没有帮助，只能在源文件中使用类全名：
import java.util.*;
import java.sql.*;

http://blog.csdn.net/benh/article/details/1907586

static import 就是允许在代码中直接引用别的类的static变量和方法（当然，在权限许可范围内），
我们可以简单的把它当成import的延续。

静态导入语法： import  static  单个导入， 全部导入：*

import static java.lang.System.*;
import static java.lang.Math.*;
public class StaticImportTest
{
	public static void main(String[] args)
	{
		out.println(PI); // 这里是 out.println()  没有 System  
		out.println(sqrt(256));
	}
}

import  和 import static 功能非常类似， 只是导入的对象不一样

 
5.5 深入构造器
Java类至少包含一个构造器

如果系统中包含多个构造器，其中一个构造器的知兴替里完全包含另一个构造器的执行体

public class Apple
{
	public String name;
	public String color;
	public double weight;
	
	public Apple(){
	}
	
	public Apple(String name, String color)
	{
		this.name=name;
		this.color=color;
	}
	
	public Apple(String name, String color, double weight)
	{
		this(name, color);// important：
		// 调用表明该类另一个有两个字符串参数的构造器
		this.weight=weight;
	}
}

特别注意 // important
// 是不是 this 只能出现一次， 并且只能出现在第一句 ？？
使用 this 调用另一个重载的构造器只能在构造器中使用，
而且必须作为构造器执行体的第一句语句，
使用 this 调用重载的构造器的时候，系统会根据 this 后面括号里的
实参来调用形参与之对应的构造器。


Page 155
5.6 类的继承
Java的继承具有单继承的特点， 每个子类只有一个直接父类

5.6.1 继承的特点
extends 关键字： 
java 的子类不能获得父类的构造器

 class Fruit
{
	public double weight;
	public void info()
	{
		System.out.println("Fruit: "+weight+"g!");
	}
}

public class Apple extends Fruit
{
	public static void main(String[] args)
	{
		Apple a = new Apple();
		a.weight=56;
		a.info();
	}
}
OUTPUT:
Fruit: 56.0g!


Java 类只能有一个直接父类， Java类可以有无限多个间接父类 //important
如：
class Fruit extends Plant{...}
class Apple extends Fruit{...}

如果定义一个Java类的时候 没有显示指出 这个类的直接父类，
则这个类默认扩展 java.lang.Object 类



5.6.2 重写父类的方法

class Bird
{
	public void fly()
	{
		System.out.println("FLY");
	}
}

public class Ostrich extends Bird //鸵鸟
{
	public void fly()
	{
		System.out.println("RUN");
	}
	
	public static void main(String[] args)
	{
		Ostrich os= new Ostrich();
		os.fly();
	}
}
OUT:
RUN // 子类

这种子类包含与父类同名方法的现象称之为 方法重写，也叫 方法覆盖（Override）

方法的 重写要遵循 ： “两同两小一大”规则
两同： 方法名相同，形参列表相同
两小： 子类方法返回值类型应该比父类方法返回值类型更小 或者相等
一大： 子类方法的访问权限应该比父类方法的访问权限更大或者相等


注意： 覆盖方法和被覆盖方法要么多是类方法，要么多是 实例方法
不能 一个是类方法 一个是实例方法 
如：

class BaseClass
{
	public static void test(){....} //static 
}	

class SubClass extends BaseClass{ //non-static 
	public void test() {...}
}
引发编译错误

注意： // important
当子类覆盖了父类的方法后，子类的对象将无法访问父类中被覆盖的方法，
但是可以在子类方法中调用父类被覆盖的方法 super()

如果父类中，有 private 访问权限， 那么该方法对其子类是隐藏的，
子类无法访问该方法，也就是无法重写该方法，如果在子类中定义了一个与父类
private 方法具有相同的方法名， 相同的形参列表， 相同的返回值的方法，
依然不是重写，只是在子类中重新定义了一个新的方法


下面的代码是正确的
class BaseClass
{
	private void test(){....} //private 只能在类内部
	//private 方法具有相同的方法名， 相同的形参列表， 相同的返回值的方法，
依然不是重写，只是在子类中重新定义了一个新的方法
	
}	

class SubClass extends BaseClass{
	public static void test() {...}
	//private 方法具有相同的方法名， 相同的形参列表， 相同的返回值的方法，
依然不是重写，只是在子类中重新定义了一个新的方法
}


5.6.3  super 限定

public void callOverrideMethod()
{
	super.fly();
	// 在子类方法中通过 super 显示调用父类被覆盖的实例方法
}



Page 158 - 159 

super 用于限定该对象调用它从父类继承得到的 Field or 方法，
正如 this 不能出现在 static 修饰的方法中一样，
super 也不能出现在 static 修饰的方法中
static 修饰的方法是属于类，该方法的调用这可能是一个类，
而不是对象，因此 super 限定也就失去了意义
// super this 都不能出现在 static 修饰的方法中

如果在构造器中使用 super， 则 super 用于限定该构造器初始化的是
该对象从父类继承得到的Field, 而不是 该类自己定义的Field 


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


Page 160 
因为子类中定义与父类中同名的实例变量并不会完全覆盖父类中定义的实例变量，
它只是简单地隐藏父类中地实例变量

class Parent
{
	public String tag= "Crazy Java Note";
}

class Derived extends Parent
{
	private String tag= "Java EE";
}

public class HideTest
{
	public static void main(String[] args)
	{
		Derived d= new Derived();
	//  System.out.println(d.tag); // error
		
		System.out.println((Parent)d.tag);
	}
}
OUT：
Crazy Java Note
// (Parent)d.tag 发生编译错误
我只在 构造器里 看到 super() 调用， 平时父类的里没有被覆盖的函数都是被隐藏起来的

在 main() 函数里， 把父类里的隐藏的函数体现出来， 用 (Parent)对象.父类里的函数 

 

class Parent
{
	public String tag= "Crazy Java Note";
}

class Derived extends Parent
{
	public  String tag= "Java EE";
}

public class HideTest
{
	public static void main(String[] args)
	{
		Derived d= new Derived();
	  System.out.println(d.tag); // error
		
		System.out.println(((Parent)d).tag);
	}
}
OUT：
Java EE
Crazy Java Note
		
5.6.4 调用父类构造器：
子类不会获得父类的构造器，但是子类构造器里可以调用父类构造器的初始化代码

在子类构造器中调用父类构造器使用 super 调用完成


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
			Sub a= new Sub(5.6, "TestObject","Red"); //important
			System.out.println(a.size +"--"+a.name+"--"+a.color);
		}
}

OUT：
5.6--TestObject--Red

super 调用的是其父类的构造器， 而 this 调用的是同一个类中的重载构造器，
使用super调用父类构造器 也 必须出现在 子类构造器执行体的第一行，
所以 this 调用 和 super 调用不会同时出现
// 注意： important：
this调用同一个类里面的重载构造器， 
super() 调用父类的构造器，但是 this() 和 super() 都必须出现在
构造器的第一行， 而且只能出现一次，
所以 this() 和 super() 调用不能同时出现



创建任何 Java  对象， 最先执行的总是 java.lang.Object 类的构造器

class Creature 
{
	public Creature()
	{
		System.out.println("Creature 无参数构造器");
	}
}

class Animal extends Creature
{
	public Animal(String name)
	{
		System.out.println("Animal 带一个参数的构造器： "+ name);
	}
	
	public Animal(String name, int age)
	{
		this(name);
		System.out.println("Animal 带两个参数的构造器： "+ age);
	}
}

public class Wolf extends Animal
{
	public Wolf()
	{
		super("grey-wolf",3);
		System.out.println("wolf 无参数的构造器");
	}
	
	public static void main(String[] args)
	{
		new Wolf();
	}
}
OUTPUT：
Creature 无参数构造器
Animal 带一个参数的构造器： grey-wolf
Animal 带两个参数的构造器： 3
wolf 无参数的构造器

// 从运行结果上来看：
创建任何对象总是从该类所在继承树最顶层的构造器开始执行，然后依次向下执行，
最后才执行奔雷的构造器。

如果某个父类通过 this 调用了同类中重载的构造器，就会一次执行此父类的多个构造器



Page 163 

5.7 多态：

class BaseClass
{
	public int book=6;
	public void base()
	{
		System.out.println("父类的普通方法");
	}
	
	public void test()
	{
		System.out.println("父类被覆盖的方法");
	}
}

public class SubClass extends BaseClass
{
	public String book ="Java  EE";
	public void test()
	{
		System.out.println("子类的覆盖父类的方法");
	}
	
	public void sub()
	{
		System.out.println("子类的普通方法");
	}
	
	public static void main(String[] args)
	{
		BaseClass bc= new BaseClass();
		System.out.println(bc.book); //6
		
		bc.base();
		bc.test();
		
		SubClass sc= new SubClass();
		System.out.println(sc.book);// Java EE 
		
		sc.base();
		sc.test();
		
		BaseClass ploymophicBc = new SubClass(); //important 
		System.out.println(ploymophicBc.book);  //6
		
		ploymophicBc.base();
		ploymophicBc.test();
		ploymophicBc.sub(); //error
		
	}
}
OUT:
6
父类的普通方法
父类被覆盖的方法
Java  EE
父类的普通方法
子类的覆盖父类的方法
6 //BaseClass 
父类的普通方法  // BaseClass : base() 
子类的覆盖父类的方法 // SubClass: test()

第三个引用变量 ploymophicBc 比较特殊：
编译时的类型是： Base Class， 运行时的类型时 Subclass
Base Class 有 book, base(), test(),
SubClass 有 book， test(), sub(); 



	
http://webcache.googleusercontent.com/search?q=cache:koom7OU5n2MJ:blog.csdn.net/zht666/article/details/7869383+&cd=3&hl=zh-CN&ct=clnk&gl=us
	
@Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处: 
1、可以当注释用,方便阅读；
2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。
 
举例：在重写父类的onCreate时，在方法前面加上@Override 系统可以帮你检查方法的正确性。
@Override
public void onCreate(Bundle savedInstanceState)

{…….}
这种写法是正确的，如果你写成：

@Override
public void oncreate(Bundle savedInstanceState)
{…….}
编译器会报如下错误：The method oncreate(Bundle) of type HelloWorld must override or implement a supertype method，以确保你正确重写onCreate方法（因为oncreate应该为onCreate）。而如果你不加@Override，则编译器将不会检测出错误，而是会认为你为子类定义了一个新方法：oncreate



Page 165 
5.7.2 引用变量的强制类型转换

public class ConverseionTest
{
	public static void main(String[] args)
	{
		double d=13.4;
		long l=(long)d;
		System.out.println(l); //13
		
		int in=5;
		boolean b=(boolean)in; //error 
		
		Object obj="Hello";
		String objStr=(String)obj; // 小 -（强制小）大
		System.out.println(objStr); //Hello 
		
		Object objPri=new Integer(5); // 父类 -- 子类 
		String str=(String) objPri;
		//
		Exception in thread "main" java.lang.ClassCastException:
		java.lang.Integer cannot be cast to java.lang.String
	at ConverseionTest.main(ConverseionTest.java:17)
	}
}
OUT:
Exception in thread "main" java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String
	at ConverseionTest.main(ConverseionTest.java:17)
	

Page 166 
5.7.3 instanceof 运算符
// 不想看


Page 166 
5.8 继承与组合

class Animal 
{
	private void beat()
	{
		System.out.println("心脏跳动 。。。");
	}
	
	public void breath()
	{
		beat(); // important
		System.out.println("呼吸中");
	}
}


class Bird extends Animal
{
	public void fly()
	{
		System.out.println("我在天空中飞翔");
	}
}

class Wolf extends Animal
{
	public void run()
	{
		System.out.println("我在陆地上快速奔跑");
	}
}

public class InheritTest
{
	public static void main(String[] args)
	{
		Bird b= new Bird();
		b.breath();
		b.fly();
		
		Wolf w= new Wolf();
		w.breath();
		w.run();
	}
}
OUT:
心脏跳动 。。。 // important 
呼吸中
我在天空中飞翔
心脏跳动 。。。
呼吸中
我在陆地上快速奔跑


Page 168 
5.8.2 利用组合实现复用

定义一下的形式： 实现相同的复用

class Animal 
{
	private void beat()
	{
		System.out.println("心脏跳动 。。。");
	}
	
	public void breath()
	{
		beat(); // important
		System.out.println("呼吸中");
	}
}


class Bird
{
	private Animal a;
	public Bird(Animal a)
	{
		this.a=a;
	}
	
	public void breath()
	{
		a.breath();
	}
	
	public void fly()
	{
		System.out.println("我在天空中飞翔");
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
		System.out.println("我在陆地上快速奔跑");
	}
}

public class InheritTest
{
	public static void main(String[] args)
	{
		Animal a1= new Animal();
		Bird b= new Bird(a1);
		b.breath();
		b.fly();
		
		Animal a2= new Animal();
		Wolf w= new Wolf(a2);
		w.breath();
		w.run();
		
	}
}

OUT:
心脏跳动 。。。
呼吸中
我在天空中飞翔
心脏跳动 。。。
呼吸中
我在陆地上快速奔跑





Page 171 
5.9 初始化块
这块不想看

Page 174 


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
		System.out.println("Root 无参数的构造器");
	}
}

class Mid extends Root
{
	static 
	{
		System.out.println("Mid 的静态初始化块");
	}
	
	{
		System.out.println("Mid 的普通初始化块");
	}
	
	public Mid()
	{
		System.out.println("Mid 无参数的构造器");
	}
	
	public Mid(String msg)
	{
		this();
		System.out.println("Mid 带参数的构造器： "+msg);
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
		super("crazy Java");
		System.out.println("执行 Leaf 的构造器");
	}
	
}

public class Test
{
	public static void main(String[] args)
	{
		new Leaf();
	//	new Leaf();
	}
}
OUT:
Root 的静态初始化块
Mid 的静态初始化块
Leaf 的静态初始化块
Root 的普通初始化块
Root 无参数的构造器
Mid 的普通初始化块
Mid 无参数的构造器
Mid 带参数的构造器： crazy Java
Leaf 的普通初始化块
执行 Leaf 的构造器



Root 的普通初始化块
Root 无参数的构造器
Mid 的普通初始化块
Mid 无参数的构造器
Mid 带参数的构造器： crazy Java
Leaf 的普通初始化块
执行 Leaf 的构造器



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
		System.out.println("Root 无参数的构造器");
	}
}

class Mid extends Root
{
	static 
	{
		System.out.println("Mid 的静态初始化块");
	}
	
	{
		System.out.println("Mid 的普通初始化块");
	}
	
	public Mid()
	{
		System.out.println("Mid 无参数的构造器");
	}
	
	public Mid(String msg)
	{
		this();
		System.out.println("Mid 带参数的构造器： "+msg);
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
		super("crazy Java");
		System.out.println("执行 Leaf 的构造器");
	}
	
}

public class Test
{
	public static void main(String[] args)
	{
		new Leaf();
	//	new Leaf();
	}
}
OUT：
Root 的静态初始化块
Mid 的静态初始化块
Leaf 的静态初始化块
Root 的普通初始化块
Root 无参数的构造器
Mid 的普通初始化块
Mid 无参数的构造器
Mid 带参数的构造器： crazy Java
Leaf 的普通初始化块
执行 Leaf 的构造器















































