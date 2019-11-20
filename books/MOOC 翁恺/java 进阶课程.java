MOOC java 进阶课程 Kai Weng
//1  不想看
每个图形都是一个对象；
每个对象都是由它所属的类class
设计一个circle的类， 可以制造很多的circle类的对象

对象 和 类 
对象是实体， 需要被创建，可以做事情 （具体的）
类是规范， 根据类的定义来创建对象 （概括性表达）

对象=属性+服务
数据：属性或状态
操作： 函数 也就是方法

把数据和对数据的操作放在一个地方： 封装
操作保护内部的数据


// 2  1-2 定义类：
File- new - Java Project  ： vendingmachine (project lowercase)
Class: VendingMachine

package vendingmachine;

public class VendingMachine {
	int price=80;  // 成员变量
	int balance;  // 成员
	int total;  // 成员
	
	void showPrompt()  /// 成员函数
	{
		System.out.println("welcome!");
	}
	
	void insertMoney(int amount)
	{
		balance=balance+amount;
	}
	
	void showBalance()
	{
		System.out.println(balance);
	}
	
	void getFood()
	{
		if(balance>=price)
		{
			System.out.println("Here you are");
			balance=balance-price;
			total=total+price;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vm=new VendingMachine();
		// 用 new 创造类的对象 vm  vm 是新创建的具体对象
		vm.showPrompt();  // 用对象来调用 成员函数
		vm.showBalance();
		vm.insertMoney(100);
		vm.getFood();
		vm.showBalance();
	}
}

3个变量 = 3个属性
4个动作 操作  函数=方法


定义一个类： 用new 运算符 创建对象 vm， // new 是一个运算符？？？
new VendingMachine();
VendingMachine vm=new VendingMachine();
对象变量是对象的管理者 // 什么是对象变量？？？
. 运算符

让对象做事情
vm.insertMoney(amount);
VendingMachine vm1=new VendingMachine();
VendingMachine vm2= new VendingMachine();

一个类 可以创建很多的对象  
对象是实体，
vm1 & vm2 是 VendingMachine 同一个类的 两个不同的对象

类： 定义了所有的对象 长什么样
对象： 是类的具体实例


// 3 1-3 成员变量和成员函数
类： 定义了对象中所具有的变量， 这些变量成为  成员变量；
每个对象都有自己的变量， 和同一个类的其他对象是分开的

函数与成员变量： 
1）。 在函数中可以直接写 成员变量的名字来访问成员变量
2）。 函数是通过对象来调用的 // important  对象.函数

vm.insertMoney();
这次调用临时建立了一个 insertMoney() 和 vm 之间的关系；
重点是：  通过对象调用函数， 建立的是 一种临时的关系 ， 
让 insertMoney()内部的成员变量指的是vm 的成员变量

this:
this 是成员函数的一个特殊的固有的本地变量，
它表达了这一次调用这个函数时候的那个对象  准确来说， 就是 this.(XXX= 成员变量的名称)

如：
	void showBalance()
	{
		System.out.println(this.balance);
	}

	void setPrice(int price )
	{
		this.price=price;
		this.getFood(); // 这样是可以的 当然， getFood(); 也是可以的
	    //  this.getFood() & getFood() 这两种形式都是可以的， 
		// 因为 在成员函数的内部 调用其他的成员函数 可以直接调用， 不需要点运算符， 
		//如 this.getFood() , getFood() 也是可以的
	}
	
这里的 this.price 指的是前面的成员变量 int  price=80; 


调用函数：
通过点运算符调用某个对象的函数
在成员函数内部直接调用自己（this）的其他函数
在一个成员函数内部调用另外一个成员函数，不需要用点运算符 // important
如：
void insertMoney(int amount){
	balance=balance+amount;
	showBalance(); // 就可以了 当然 this.showBalance(); 也可以
}

在成员函数内部 调用 成员函数 不需要 . 运算符 ， 当然 用也可以
但是 在成员函数的外部， 比如说， 在 
public static void main() 里面， 就需要用 .运算符调用成员函数 

本地变量：
定义在函数内部的变量是 本地变量：
本地变量的生存期和作用域都是在函数内部

成员变量：
成员变量的生存期是对象的生存期，作用域是类内部的成员函数
成员函数的作用域 在这个类的内部
new 一个新的对象， 这个对象 的生存期就开始了
成员函数 可以用成员变量， 

本地变量： 进入函数就有了， 离开函数 本地变量就不存在了


// 4 1-4 对象初始化
本地变量没有初始化， 编译是不能通过的
类里面的成员变量 会自动有初始值 0 false  null 


new 创建一个新的对象

成员变量定义初始化
1）。 成员变量在定义的地方就可以给出 初始值；
2）。 没有给出初始值的成员变量会自动获得0值；
3）。 对象变量的0值表示没有管理任何对象，也可以主动给null值；
4）。 定义初始化可以调用函数， 甚至可以使用已经定义的成员变量

Boolean 初始值： false 
对象变量 初始值： null

如：
public class VendingMachine{
	int price =80; // 定义一个成员变量的地方给一个初始值；
	int balance =f(); // 甚至可以使用已经定义的函数；
}

	int f()
	{
		return 10;
	}
	
	VendingMachine（） // 构造函数
	{
		total=0;
	}
	
	
	VendingMachine(int price)
	{
		this.price=price;
	}
	// 这个也可以 但是我也不知道为什么这么做
 构造函数的顺序： new 一个新的对象以后，先去构造函数那里初始化对象
 再跳出去去成员变量那里初始化， 再回到构造函数， 最后回到对象
 
	
构造函数：
如果有一个成员函数的而名字和类的名字是完全相同的；
则正在创建这个类的每一个对象的时候会自动调用这个函数
调用完这个构造函数以后，还是顺着原来的顺序走一遍成员变量 和 成员函数，最后回到构造函数

构造函数： 没有返回类型：

重载关系：根据给出的是什么函数来决定自动调用什么构造函数
VendingMachine（） // 构造函数

	{
		total=0;
	}
	
	
	VendingMachine(int price) // 重载 overload
	{
		this(); // 没有参数的构造函数
		// 这个this() 只能在构造函数中出现，
		//并且只能出现在构造函数的第一行，并且只能出现一次
		this.price=price;
	}
	
函数重载：
一个类可以有多个构造函数， 只要它们的参数表不同
创建对象的时候给出不同的参数值， 就会自动调用不同的构造函数
通过 this() 还可以调用其他的构造函数
一个类里的同名但是参数表不同的函数构成了重载关系


// 5 1-5 编程题
// 做出两个类
import java.util.Scanner;

public class Main{
	
	public  static void main(String[] args){
		Scanner in = new Scanner(System.in);
		Fraction a =new Fraction(in.nextInt(), in.nextInt());
		Fraction b =new Fraction(in.nextInt(), in.nextInt());
		a.print();
		b.print();
		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5,6)).print();
		a.print();
		b.print();
		in.close();
	}
}


// 6 2-1 对象交互-1： 对象的识别
new project clock 
class : display 

package clock;
// 构造函数：

public class Display {
	private int value=0;
	private int limit=0;
	
	public Display(int limit)
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
		Display d=new Display(24);
		for(;;)
		{
			d.increase();
			System.out.println(d.getValue());
		}
	}
}



// 7 2-2 对象交互-2 
// 两个类： 如何相互交互？？
对象一定要 new  出来
一个类里面，它的成员变量， 可以是其他类的对象， 如：
public class Clock {
	private Display hour= new Display(24);
	private Display minute= new Display(60);
	private Display second= new Display(60);
	
一个对象 ， 也可以由 其他的对象组成
一个 clock 对象， 可以由 2 个 display的对象组成的

public class Clock {
	private Display hour= new Display(24);
	private Display minute= new Display(60);
	private Display second= new Display(60);
	
	public void start()
	{
		while(true) {
		second.increase();
		if(second.getValue()==0)
		{
			minute.increase();
			if(minute.getValue()==0)
			{
				hour.increase();
			}
		}
		System.out.printf("%2d : %2d :%2d\n",hour.getValue(), minute.getValue(),second.getValue());
	}
}
	
	public static void main(String[] args) {
		Clock clock= new Clock();
		clock.start();
	
	}

}



package clock;

public class Display {
	private int value=0; // 私有的
	private int limit=0;
	
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
		Display d=new Display(24);
		for(;;)
		{
			d.increase();
			System.out.println(d.getValue());
		}
	}
}

package clock;

public class Clock {
	private Display hour = new Display(24);
	private Display minute = new Display(60);
	
	public void start() {
		while(true) {
		minute.increase();
		if(minute.getValue()==0){
			
			hour.increase();
		}
		System.out.printf("%02d : %02d\n",hour.getValue(), minute.getValue());
	}
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock clock=new Clock();
		clock.start();
	}
}

// done by myself 

public class Display{
	private int value=0;
	private int limit=0;
	
	public Display(int n){
		limit=n;
	}
	
	public void increase(){
		value++;
		if(value==limit){
			value=0;
		}
	}
	
	public int getValue(){
		return value;
	}
}

public class DisPlayTest{
	Display hour= new Display(24);
	Display minute= new Display(60);
//	Dispaly second= new Display(60);
	
	
	void getStart(){
		while(true){
		minute.increase();
		if(minute.getValue==0){
			hour.increase()++;
		}
		System.out.printf("%2d : %2d\n",hour.getValue(), minute.getValue());
	}
}
	
	
	public static void main(String[] args){
		DisPlayTest d= new DisPlayTest();
		d.getStart();
	}
}

// + second 

public void getStart(){
	while(true ){
		second.increase();
		if(second.getValue()==0){
			minute.increase();
		
		if(minute.getValue()==0){
				hour.increase();
		}
		}
		System.out.printf("%2d : %2d : %2d\n",hour.getValue(), minute.getValue(),second.getValue());
		}
}
		
	
// 能成功执行的 hour: minute: second 
 class Display{
	private int value=0;
	private int limit=0;
	
	public Display(int n){ // 构造函数
		limit=n;
	}
	
	public void increase(){
		value++;
		if(value==limit){
			value=0;
		}
	}
	
	public int getValue(){
		return value;
	}
}

 class PlayTest{
	Display hour= new Display(24);
	Display minute= new Display(60);
   Display second= new Display(60);
	
	
	public void getStart(){
while(true ){
		second.increase();
		if(second.getValue()==0){
			minute.increase();
		if(minute.getValue()==0){
				hour.increase();
		}
}
		System.out.printf("%2d : %2d : %2d\n",hour.getValue(), minute.getValue(),second.getValue());
		}
}
     
	public static void main(String[] args){
		PlayTest d= new PlayTest();
        d.getStart();
	}
}
	
// 如果 不用构造函数  怎么处理？？
public class Display{
	private int value=0;
	private int limit=0;
	
	public void increase(){
		value++;
		if(value==limit)
		{
			value=0;
		}
	}
	
	public void getLimit(int n)
	{
		limit=n;
	}
	
	public void getValue(){
		return value;
	}
}

public class DispalyTest{
	Display hour= new Display();
	Dispaly minute= new Display();
	Display second= new Display();
	
	hour.getLimit(24);
	minute.getLimit(60);
	second.getLimit(60);
	
	public void getStart(){
		while(true){
			second.increase();
			if(second.getValue()==0)
			{
				minute.increase();
				if(minute.getValue()==0)
				{
					hour.increase();
				}
			}
			System.out.printf("%2d : %2d : %2d\n",hour.getValue(), minute.getValue(),second.getValue());
		}
	}
	
	public static void main(String[] args){
		DispalyTest d= new DispalyTest();
		d.getStart();
	}
}

//写不出来出现 error： <identifier> expected

Debug：
class Display{
	private int value=0;
	private int limit=0;
	
	public void increase(){
		value++;
		if(value==limit)
		{
			value=0;
		}
	}
	
	public void getLimit(int n)
	{
		limit=n;
	}
	
	public int getValue(){
		return value;
	}
}

public class DispalyTest{
	
	public static void main(String[] args){
	Display hour= new Display();
	Display minute= new Display();
	Display second= new Display();
	hour.getLimit(24);
	minute.getLimit(60);
	second.getLimit(60);
    
		while(true){
			second.increase();
			if(second.getValue()==0)
			{
				minute.increase();
				if(minute.getValue()==0)
				{
					hour.increase();
				}
			}
			System.out.printf("%2d : %2d : %2d\n",hour.getValue(), minute.getValue(),second.getValue());
		}
    }
}
			
这个结果可以了

// 8 2-2 访问属性-1  封闭的访问属性
对象 类 
封装： 把数据和对数据的操作放在一个地方，通过操作，把数据保护起来
对象=属性+服务
数据： 属性或者状态
操作： 函数  针对对象（or 数据）的操作

手段： 所有的成员 都可以设置 访问属性
private int value=0;
private int limit=0;

value 和 limit 都是成员变量

private: 这个成员是这个类 私有的，只有在这个类的内部才能访问
如：
public int getValue(){
	private int i;
	return value:
}
// 这样是不行的 private关键字 只能用于成员变量 以及 成员函数
// private 私有的， 只有在这个类的内部， 才能访问

能够使用成员变量的地方 只有两个：
在成员函数里面   在定义初始化的地方使用别的定义的成员变量

private： 只有两个地方可以做访问：
1） 。 成员函数里， 构造函数 访问 private 成员变量， 
2）。 定义初始化的地方，如

private int value =0;
private int limit =value;

private 
只有这个类的内部可以访问：
	类内部指的是： 类的成员函数和定义初始化
	这个限制是对 类的 而不是对 对象的
	
一个类的 所有的 不同的对象之间，可以访问别人的私有成员
私有是针对类 不是针对 对象的
基本的原则：
成员变量应该是私有的， 被保护的， 不能被外界随便的使用



// 9 2-2 访问属性-2 

public：
任何人都可以访问：
	任何人指的是 在任何类的函数或者 定义初始化中 可以使用
	使用指的是  调用， 访问 或 定义变量
	
如果没有在一个成员前面 + public or private 关键字来限制
friendly： 位于同一个package 的其他类 可以访问

protected  继承的时候再学

如：
public class Clock
Clock 这个class类， 是public：

如果一个类是public，那么就 要求：
源代码的文件名 必须和这个类的名字相同

如： 
public class Clock {
...}
这个类的文件名 必须是Clock
不能是 public class Clocks 

编译单元： 编译的时候，一次对这一个编译单元做编译的动作

在一个编译单元里，可以有很多 java 的类 class
当一个编译单元有不止一个类 class 的时候，只有一个类 可以是 public 
如：

class A{
...}

public class Clock{
...}

// 不能是  public class A

class A{
。。。}

这个类 class A 只能在这个 包 里起作用，一旦出了这个包，就不能起作用了


// 10 2-3 包 package

src 底下的clock是一个 package

如果在 clock project 里 新建一个 Package 叫display
src  里 多了一个叫 display的 package 文件夹

Clock.java 的文件中， 出现 import display.Display;
引用另外一个包 package里面的Display这个类，
Clock.java 就把 display 这个包里 Display 这个类拿过来
 
只要你用的类不在一个包里面 就要 import
import.包的名字.类的名字

如果不用 import导入另外一个包里的类，后面就需要：

public class Clock{
	private display.Display hour = new display.Display();
	private display.Display minute = new display.Display();
	
如果 import display.*
= import display 这个包里的所有东西 .*


特殊的 display包的形式：
在 clock 里 新建一个 package， 名字取为： display.led
. 表示文件夹的层次
如：

import java.util.Scanner;



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
		System.out.println(d1.getValue());
		System.out.println(d2.getValue());
		System.out.println(d1.step);
		System.out.println(d2.step);
		d1.step=2;
		System.out.println(d1.step);
		System.out.println(d2.step);
		
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
static 函数只能fa

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
		里面， 不能 value++ ;
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
		value++;// 是不行的， 你不能在一个 static 函数里访问一个非static的变量
	}
	
static 函数只能调用 static 的函数， 只能访问 static 的成员变量
static 的函数 和 成员变量 都能通过类的名字去访问， 也可以通过某个对象的名字去访问
	
static int step =2;
这个 static 类变量只能初始化一次 // ???
比如说：
d1.step=3;
那么所有的 step 都 step=3;



// 13 3-1 顺序容器 记事本 
要求：
1). 能存储记录
2). 不限制能存储的记录的数量
3). 能知道已经存储的记录的苏良
4). 能查看存进去的每一条记录
5). 能删除一条记录
6). 能列出所有的记录

接口设计：
add(String note);
getSize();
getNote(int index);
removeNote(int index);
list();

先创建一个新的project ， 创建一个新的 class： NoteBook
在NoteBook里， 定义各个接口

package notebook;

public class NoteBook {

	public void add(String s)
	{
		
	}
	
	public int getSize() {
		return 0;
	}
	
	public String getNote(int index) {
		return "";
	}
	
	public boolean removNote(int index) {
		return true;
	}
	
	public String[] list() { // 函数返回一个 String[] 的数组
		return 

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}


// 14 3-2 顺序容器-2 范型容器类

需要一个容器， 一直 add add add 数组是不行的， 数组由范围的
因此， 我们需要有一个成员变量： 它的类型是：
ArrayList 是一个类的名字：
import java.util.ArrayList;


import java.util.ArrayList;
private ArrayList<String> notes= new ArrayList<String>();

引入一个类： 这个类 属于 java. util 包. ArrayList(这个类)
所以 类的名字就是 ArrayList

 ArrayList<String> 
 = ArrayList of String 
用来存放String 类型数据的 class 类ArrayList
这种类叫做： 范型类， 是一种容器
notes 本身 是一个对象管理者


定义一个变量 notes， 类型是 ArrayList 
notes 是对象管理者, 创建对象的时候 用 new 创建一个对象

容器类： 用来存放对象  存放的是对象？？？？//important
ArrayList<String> notes= new ArrayList<String>;

容器类有两种类型：
	容器的类型； 如： ArrayList
	元素的类型； 如： String
	
	
怎么把东西放进去？
public void add(String s){
	notes.add(s); // 或许是 Array List 这个类 自带的 add() 函数？？？
	// ArrayList 里面有个函数叫做add() 并且 add（）函数只接受 string 类型，不接受其他的类型
}

public int getSize(){
	return notes.size();
}


//

package notebook;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<String> notes= new ArrayList<String>();
	
	public void add(String s)
	{
		notes.add(s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);
	}
	
	public boolean removNote(int index) {
		return true;
	}
	
	public String[] list() {
		return new String[10]; //?

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] a= new String[2];
		a[0]="first";
		a[1]="second";
		NoteBook nb= new NoteBook();
		nb.add("first");
		nb.add("second");
		System.out.println(nb.getSize());
	}

}



// 15 3-1 顺序容器-3 ArrayList 的操作
ArrayList 是系统内部的一个类
能记录元素， 保持加进去元素的数量
，形成下标索引，因此，可以获取其中一个元素

ArrayList <String> notes= new ArrayList<String>();

public String getNote(int index){
	return notes.get(index);
}

public String getNote(int index) {
		return notes.get(index);// ArrayList 里有 get(int index)的函数
	}

因此， 在main() 中：
	System.out.println(nb.getNote(0));
	

增加一个接口：
	public void add(String s, int location){
		notes.add(location, s);
		// 这个是ArrayList 本身自带的函数 add(int index, String Element)
	}
	
	
再更新一个接口：
public String removNote(int index) {
	 return notes.remove(index);
	}
	// 注意： remove（） 函数返回的类型是： string
	// 返回是删掉的东西 所以不用Boolean 
	// 原来的版本是：
	 public boolean removeNote(int index){
		return notes.remove(index);
	}
	// 所以 这个不用 Boolean， 因为出现异常remove()函数自己会有提示的
	// 不用return 任何东西
	
	
	
// 要返回一个数组：数组表达容器中所有的东西
方法1：
构造一个成员函数：

	public  String[] list(){
		String [] a= new String[notes.size()];
		for(int i=0; i<notes.size();i++){
			a[i]=notes.get(i);
		}
		return a; // a 是String[]  类型的数组
	}
	
	在 main 里面：
	NoteBook nb= new NoteBook();
	String[] a= nb.list();
	for(String s: a)
	{
		System.out.println(s);
	}
	
方法2：
public  String[] list(){
		String [] a= new String[notes.size()];
		notes.toArray(a);// 把 notes 里面的数组放进 a 中
		return a;
	}
	
	
	同时， main() 里面加入：
	nb.add("third",1);
	
一种方案实现 String List();
package notebook;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<String> notes= new ArrayList<String>();
	
	public void add(String s)
	{
		notes.add(s);
	}
	
	public void add(String s, int location) {
		notes.add(location, s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);// .get(int index) : 获得 location index 出的内容
	}
	
	public void removNote(int index) {
	 notes.remove(index);
	}
	
	public String[] list() {
		String[] a=new String[notes.size()];
		for(int i=0; i<notes.size(); i++) {
			a[i]=notes.get(i);
		}
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] a= new String[2];
		a[0]="first";
		a[1]="second";
		NoteBook nb= new NoteBook();
		nb.add("first");
		nb.add("second");
		nb.add("third",1);
		System.out.println(nb.getSize());
		System.out.println(nb.getNote(0)); // public String getNode(int index)
		System.out.println(nb.getNote(1));
		System.out.println(nb.getNote(2));
		System.out.println();
		nb.removNote(1);
		String[] b= nb.list();
		for(String s:b) {
			System.out.println(s);
		}
		
	}

}


另外一种方案实现： String[] List:
package notebook;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<String> notes= new ArrayList<String>();
	
	public void add(String s)
	{
		notes.add(s);
	}
	
	public void add(String s, int location) {
		notes.add(location, s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);//
	}
	
	public void removNote(int index) {
	 notes.remove(index);
	}
	
	public String[] list() {
		String[] a=new String[notes.size()];
//		for(int i=0; i<notes.size(); i++) {
//			a[i]=notes.get(i);
//		}
		notes.toArray(a);
		return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] a= new String[2];
		a[0]="first";
		a[1]="second";
		NoteBook nb= new NoteBook();
		nb.add("first");
		nb.add("second");
		nb.add("third",1);
		System.out.println(nb.getSize());
		System.out.println(nb.getNote(0)); //
		System.out.println(nb.getNote(1));
		System.out.println(nb.getNote(2));
		System.out.println();
		nb.removNote(1);
		String[] b= nb.list();
		for(String s:b) {
			System.out.println(s);
		}	
	}
}


// 16 3-2 对象数组-1 

String[] 这个数组里， 放着什么？

String[] a= new String[10];
做了10个格子 ， 每个格子都是 String 类的管理者， a[0], a[1], a[2],...a[9],
但是没有管理任何人 所以全部都是 null 
怎么给 String[] a 赋值？？？

String[] a= new String[10];
for(int i=0;i<a.length;i++)
{
	a[i]=""+i;
}
System.out.println(a[0].length());

注意下这里： 
第一个 a.length 指的是数组的长度， 所以length 不用+ ();
但是 a[0].length() 指的是 字符串的长度， 所以要是 a[0].length(); +括号
完整的代码：

public class Test{
    
    public static void main(String[] args)
    {
        String[] a= new String[10];
        for(int i=0;i<a.length;i++)
{
	a[i]=""+i;
}
System.out.println(a[0].length());
    }
}




public String[] list() {
		String[] a=new String[notes.size()];
		
//		for(int i=0; i<notes.size(); i++) {
//			a[i]=notes.get(i);
//		}
		notes.toArray(a);
		return a;
	}

	如果有：
	int [] ia=new int[10];
	String[] a=new String[notes.size()];
	
	a 里放着什么东西？？？
	测试一下：
	public static void main(String[] args){
		int [] ia=new int [10];
		String[] a= new String[10];
		System.out.println(ia[0]); // 0
		System.out.println(a[0]); //null
	}	
	
OUTPUT:
0
null // 说明现在a[0] 并不存在

再次测试：
public static void main(String[] args){
		int [] ia=new int [10];
		String[] a= new String[10];
		System.out.println(ia[0]+2);
		System.out.println(a[0]+"a");
	}	

OUTPUT:
2
nulla // ？？？


再次测试：
public static void main(String[] args){
		int [] ia=new int [10];
		String[] a= new String[10];
		System.out.println(ia[0]+2);
		System.out.println(a.length()); // 应该是这里出现问题： 只能是 a.length, 不能是 a.length(); 
		// 因为 a 是String 类型的数组管理者， a[i].length() 应该这种方式是可以的
		System.out.println(a[0].length()); // 长度： 出现异常
		// 
	}	

OUTPUT:
Line 6: error: cannot find symbol: method length()

String s=null;
System.out.println(s.length());

OUTPUT:
NUllPointerException 

再次测试：
String s=null;
System.out.println(s.length());
结果一样：  OUTPUT:
NUllPointerException 

用 string 做一个数组出来： String 类型的数组 里面每一个元素到底是什么？


再次测试：
public static void main(String[] args){
		int [] ia=new int [10];
		String[] a= new String[10];
		System.out.println(ia[0]);
		
		for (int i=0; i<a.length;i++ ){
			a[i]=""+i;
		}
		System.out.println(a[0].length());
	}


public class Test{
    public static void main(String[] args){
		int [] ia=new int [10];
		String[] a= new String[10];
	//	System.out.println(ia[0]);
		
		for (int i=0; i<a.length;i++ ){
			a[i]=""+i;
		}
		System.out.println(a[0].length());
}
}

OUTPUT: 1

在对象数组中的每个元素都是对象的管理者 而非 对象本身



//17 3-2 对象数组-2  for-each 
//http://blog.csdn.net/mcy478643968/article/details/3488861
1 java中的length属性是针对数组说的,比如说你声明了一个数组,想知道这个数组的长度则用到了length这个属性.

2 java中的length()方法是针对字符串String说的,如果想看这个字符串的长度则用到length()这个方法.

3.java中的size()方法是针对泛型集合说的,如果想看这个泛型有多少个元素,就调用此方法来查看!

 

这个例子来演示这两个方法和一个属性的用法

 public static void main(String[] args) {
        String []list={"ma","cao","yuan"};
        String a="macaoyuan";
        System.out.println(list.length);
        System.out.println(a.length());


        List<Object> array=new ArrayList();
        array.add(a);
        System.out.println(array.size());
    }

 
输出的值为:

3

9

1


public static void main(String[] args )
{
	int [] ia=new int[10];
	
	for(int i=0; i<ia.length;i++){
		ia[i]=i;
	}
	
	for(int k:ia){
		System.out.println(k);
	}
	
	for(int k:ia){
		k++;
	}
	
	for(int k:ia){
		System.out.println(k); // 这里不会发生任何变化 
	}   // k++ 并没有起作用
}

OUTPUT：
0
1
2
3
4
5
6
7
8
9
0
1
2
3
4
5
6
7
8
9


class Value{
	private int i;
	
	public void set(int i)
	{
		this.i=i;
	}
	
	public int get(){
		return i;
	}			


	public static void main(String[] args){
		
		Value[] a= new Value[10];
		for(int i=0; i<a.length;i++){
			a[i]= new Value(); // important
			a[i].set(i);
		}
		
		for(Value v:a){
			System.out.println(v); //？？？
		}
	}
}

OUTPUT:
Value@6d06d69c
Value@7852e922
Value@4e25154f
Value@70dea4e
Value@5c647e05
Value@33909752
Value@55f96302
Value@3d4eac69
Value@42a57993
Value@75b84c92


改：
class Value{
	private int i;
	
	public void set(int i)
	{
		this.i=i;
	}
	
	// 下面这里发生改变， return i；
	public int get(){
		return i;
	}			


	public static void main(String[] args){
		
		Value[] a= new Value[10];
		for(int i=0; i<a.length;i++){
			a[i]= new Value();
			a[i].set(i);
		}
		
		for(Value v:a){
			System.out.println(v.get()); //？？？
		}
	}
}	

进一步测试：
class Value{
	private int i;
	
	public void set(int i)
	{
		this.i=i;
	}
	
	public int get(){
		return i;
	}			

	public static void main(String[] args){
		
		Value[] a= new Value[10];
		for(int i=0; i<a.length;i++){
			a[i]= new Value();
			a[i].set(i); // 这里改成0
		}
		
		for(Value v: a){  // for-each 循环： 
			System.out.println(v.get());  // 0 1 2 3 4 5 6 7 8 9 
			v.set(0);
		}
		
		
		for(Value v:a){
			System.out.println(v.get()) //？？？
		}
	}
}

OUTPUT:
0
1
2
3
4
5
6
7
8
9
0
0
0
0
0
0
0
0
0
0

在 for each 循环里 无法改变整数型的数组每个元素的值
但是在 Value[] a 这里数组里是可以的 (对象数组)
for each 循环的意思是：

for(Value v: a)
1.	v=a[0]  //第一轮
2.  v=a[1]
.
.
.
.

for each 循环对  对象数组来说：
在循环的每一轮： 循环可以拿到那个数组 元素所管理的对象
可以对 对象 做操作了
package notebook;

import java.util.ArrayList;

public class NoteBook {
	private ArrayList<String> notes= new ArrayList<String>();
	
	public void add(String s)
	{
		notes.add(s);
	}
	
	public int getSize() {
		return notes.size();
	}
	
	public String getNote(int index) {
		return notes.get(index);
	}
	
	public boolean removNote(int index) {
		return true;
	}
	
	public String[] list() {
		return new String[10]; //?

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] a= new String[2];
		a[0]="first";
		a[1]="second";
		NoteBook nb= new NoteBook();
		nb.add("first");
		nb.add("second");
		System.out.println(nb.getSize());
	}

}


那么 容器类： 可以这样吗？
class A{
	private ArrayList<String> notes=new ArrayList<String>();
	
	public void add(String s){
		notes.add(s);
	}

public static void main(String[] args){
	ArrayList<String> a= new ArrayList<String>();
	a.add("first");
	a.add("second");
	
	for(String s:a){
		System.out.println(s);
		}
	}
}

OUTPUT:
first
second

for-each 循环对象数组是不一样的 ， 它可以拿到数组元素所管理的对象， 对那个对象做操作
比如说， ArrayList是一个类， 用 ArrayList 创造对象数组
 
是不是可以这么做： public static void main() 之前的就没有什么作用

public class Test{
    
    public static void main(String[] args)
    {
	ArrayList<String> a= new ArrayList<String>();
	a.add("first");
	a.add("second");
	
	System.out.println(a); // 这个是可以接受的
	
	for(String s:a){
		System.out.println(s);
		}
	}
}


// 18 3-3 集合容器 集合set

set 容器
HashSet<String> s= new HashSet<String>;
s.add("first");
s.add("second");
s.add("first");
for(String k:s)
	System.out.println(k);

System.out.println(s);




public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int balance =0;
	while(true){
		System.out.println("请投币");
		int amount=in.nextInt();
		balance=balance+amount;
		if(balance>=10)
		{
			System.out.println("***************");
			System.out.println("Java 专线");
			System.out.println("票价");
			System.out.println("************");
			System.out.println("找零： "+ (balance-10));
		System.out.println();
			balance=0;
		}	
	}
}



public static void main(String[] args)
{
	ArrayList<String> a= new ArrayList<String>();
	a.add("first");
	a.add("second");
	a.add("first");
	
	for(String s :a){
		System.out.println(s);
	}
	
	System.out.println(a);
	
	System.out.println("*************");
	
	HashSet<String> s= new HashSet<String>();
	// important: HashSet 
	
	s.add("first");
	s.add("second");
	s.add("first");
		
	for(String k :s){
		System.out.println(k);
	}
	System.out.println(s);
	
}

OUTPUT:

first
second
first
[first, second, first]
*************
first
second
[first, second]

[] 代表 容器， set 是集合的意思， 
HashSet 是不排序的， 


class Value{
	private int i;
	public void set(int i)
	{
		this.i=i;
	}
	
	public int get(){
		return i;
	}

	public String toString(){
		return ""+i;
	}
	// 任何一个Java类，只要实现了一个 
	// public String toString()  必须完全一样的函数
	就可以直接输出： System.out.println(v); 输出这个v对象
	会 主动调用这个 String toString();
	用toString函数 产生的String ， 直接输出 出来
}


public class A{
	
public static void main(String[] args)
{
	Value v= new value();
	System.out.println(v);
	
	ArrayList<String> a= new ArrayList<String>();
	a.add("first");
	a.add("second");
	a.add("third");
	
		System.out.println(a);
	
	System.out.println("*************");
	
	HashSet<String> s= new HashSet<String>();
	
	s.add("first");
	s.add("second");
	s.add("first");
		
	System.out.println(s);
	}
}

OUTPUT:
[first, second, third]
*************
[first, second]


//19 3-4 Hash表
1 penny
5 nickel
10 dime
25 quarter
50 half dollar

// 给一个整数， 出来一个 单词
Integer 是 int 的包裹类型， 为了放进 int 类型的数据， 所以这里是 Integer 包裹类型
coinnames.put(1,"penny ");
因为一个包裹类型的变量可以直接接收一个对应的基础类型的变量

package coins;

import java.util.Scanner;
import java.util.HashMap;


public class Coin{
	private HashMap<Integer, String> coinnames= new HashMap<Integer, String>();
	
	public Coin()
	{
		coinnames.put(1,"penny ");
		coinnames.put(5,"nickel");
		coinnames.put(10,"dime");
		coinnames.put(25,"quarter ");
		coinnames.put(50,"half-dollar");
		coinnames.put(50,"五毛"); // 留下来的 一定是相同键值的最后一个
		//KeySet() 告诉你有多少键值 ，所有的 Key 有多少个
		//把所有的key 做成了 HashSet 这种类型的集合， HashSet 本身就有 .size()
		
		System.out.println(coinnames.keySet().size()); // 这是什么意思？
		System.out.println(coinnames);
		// HashTable 也可以直接输出
		
		for(Integer k: coinnames.keySet()) // KeySet给出Hash表所有Key的集合
		{
			String s = coinnames.get(k);
			System.out.println(s);
		}
	}
	
	
	public String getName(int amount){
		if(coinnames.containsKey(amount))//如果存在着 amount 的key 的话
			return coinnames.get(amount);
		else 
			return "Not Found";
	}
	
	public static void main(String[] args){
		Scanner in= new Scanner (System.in);
		int amount=in.nextInt();
		Coin coin=new Coin();
		String name = coin.getName(amount);
		System.out.println(name);
		
	}
}

Hash table 里面的键值是唯一的

// 20 4-1 继承-1  资料库的故事

CD
title 
artist 
number of tracks 
playing time 
got it 
comment 


//1
package cdPlayer;

public class Database {
	private ArrayList<CD> listCD= new ArrayList<CD>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
	}

}


package cdPlayer;

public class CD {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt;
	private String comment;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}




如何让 CD 里面的
title 
artist 
number of tracks 
playing time 
got it 
初始化起来 等等

source-- Generate Constructor using Fileds 建造一个构造器
然后就变成了：

//2 
package cdPlayer;

public class CD {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
	//	super(); 
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	private boolean gotIt=false;
	
}


// 3
package cdPlayer;

import java.util.ArrayList;


public class Database {
	
	private ArrayList<CD> listCD= new ArrayList<CD>();
	
	public void add(CD cd) {
		listCD.add(cd);
	}
	
	public void list() {
		for(CD cd: listCD) {
			cd.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 4, 60, "..."));
		db.list();
		
	}

}


package cdPlayer;

public class CD {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super();
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(title+":"+artist);
		
	}

}

// 放进DVD

package cdPlayer;

public class DVD {
	
	private String title;
	private String director;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;

	public DVD(String title, String director, int playingTime, String comment) {
		super();
		this.title = title;
		this.director = director;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("DVD"+title+":"+director);
	}

}


package cdPlayer;

public class CD {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super();
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("CD "+title+":"+artist);
		
	}
}


package cdPlayer;

import java.util.ArrayList;


public class Database {  // 
	
	private ArrayList<CD> listCD= new ArrayList<CD>();
	private ArrayList<DVD> listDVD= new ArrayList<DVD>();
	
	public void add(CD cd) {
		listCD.add(cd);
	}
	
	public void add(DVD dvd) {
		listDVD.add(dvd);
	}
	
	public void list() {
		for(CD cd: listCD) {
			cd.print();
		}
		
		for(DVD dvd: listDVD) {
			dvd.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 4, 60, "..."));
		
		db.add(new DVD("xxx", "aaa", 60,"..."));
		
		db.list();
	}
}

最新补充：
new complete code :

package demo;

public class CD {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playTime;
	private boolean gotIt=false;
	private String comment;

	public CD(String title, String artist, int numOfTracks, int playTime, String comment) {
	//	super();
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playTime = playTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("CD: "+title+":"+ artist);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}


package demo;

public class DVD {

	private String title;
	private String director;
	private int playTime;
	private boolean gotIt=false;
	private String comment;
	
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("DVD: "+title+":"+ director);
	}

	public DVD(String title, String director, int playTime, String comment) {
	//	super();
		this.title = title;
		this.director = director;
		this.playTime = playTime;
		this.comment = comment;
	}
}


package demo;

import java.util.ArrayList;

public class Database {
	private ArrayList<CD> listCD= new ArrayList<CD>();  
	private ArrayList<DVD> listDVD= new ArrayList<DVD>();
	
	public void add(CD cd) {
		listCD.add(cd);
	}
	
	public void add(DVD dvd)
	{
		listDVD.add(dvd);
	}
	
	public void list() {
		for(CD cd: listCD)
		{
			cd.print();
		}
		
		for(DVD dvd: listDVD) {
			dvd.print();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db= new Database();
		db.add(new CD("abc","abc",4, 60,"..."));
		db.add(new CD("abc","abc",4, 60,"..."));
		
		db.add(new DVD("xxx","aaa", 60,"..."));

		db.list();	
	}

}


// 21 4-1 继承-2 
出了什么问题？？？
大量的代码复制

在 class Item 里面不妨任何东西 也可以出结果
package cdPlayer;

public class CD extends Item { //
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super();  // important super();
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("CD"+title+":"+artist);
		
	}

}


package cdPlayer;

public class DVD extends Item { //
	
	private String title;
	private String director;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public DVD(String title, String director, int playingTime, String comment) {
		super();
		this.title = title;
		this.director = director;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("DVD"+title+":"+director);
	}
}

package cdPlayer;

public class Item {

	public void print() {
		
	}
}


package cdPlayer;

import java.util.ArrayList;


public class Database {
	
//	private ArrayList<CD> listCD= new ArrayList<CD>();
//	private ArrayList<DVD> listDVD= new ArrayList<DVD>();
	
	private ArrayList<Item> listItem = new ArrayList<Item>();
	
//	public void add(CD cd) {
//		listCD.add(cd);
//	}
//	
//	public void add(DVD dvd) {
//		listDVD.add(dvd);
//	}
//	
	
	public void add(Item item) {
		listItem.add(item);
	}
	
//	public void list() {
//		for(CD cd: listCD) {
//			cd.print();
//		}
//		
//		for(DVD dvd: listDVD) {
//			dvd.print();
//		}
//	}

		public void list() {
			for(Item item: listItem) {
				item.print();
			}
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 4, 60, "..."));
		
		db.add(new DVD("xxx", "aaa", 60,"..."));
		
		db.list();
	}

}


OUTPUT：
CDabc:abc
CDdef:def
DVDxxx:aaa

Database 对Item 的全部认识 是：
Item 应该有一个 print（） 函数；
这是在 Database 里唯一用到 Item 的地方

当 Database 要item的时候， item是有print（） 函数的
具体 print（） 函数是什么样的 不关心
要的就是 有print 就可以了

如果把 CD里面的print() 注释掉，也不会出错

注释掉 class CD 里面的 print() 函数：
然后，将 class Item 改成：
package cdPlayer;

public class Item {

	public void print() {
		System.out.println("Item");
	}
}


OUTPUT：
Item
Item
DVDxxx:aaa

也就是说， CD 将 Item里面所有的东西都得到了，所以不会出错
CD 自己没有 print() 函数， 但是 CD得到了Item里面的 print() 函数



如果：
将CD改一下： CD 没有自己的 print() 函数：
package cdPlayer;

public class Item {

	public void print() {
		System.out.println("Item");
	}
}


package cdPlayer;

public class CD extends Item {
	
	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super();
		this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CD cd= new CD("a","b",2,2,"...");
		cd.print();
	}

//	public void print() {
//		// TODO Auto-generated method stub
//		System.out.println("CD"+title+":"+artist);
//		
//	}
}

OUTPUT：
Item

Item 父类定义了什么函数， 子类 CD 就天然地继承了 父类的函数


// 22 4-2 父类子类关系-1 

把 String title 去掉 会发生 问题
package cdPlayer;

public class CD extends Item {
	
	// delete private String title;  // delete
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super();
		this.title = title; // 这里会发生抱怨 this field Item.title is not visible
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CD cd= new CD("a","b",2,2,"...");
		cd.print();
	}
}

package cdPlayer;

public class Item {
	
   private String title;
	
	public void print() {
		System.out.println("Item");
	}
}

方法 1 ：

因为 CD 继承 Item 里面的Title， CD 自己是没有 title 的；

this.title = title; 里面的 this.title 应该就是 父类 Item 里面的title

但是在父类 Item里面 title 是private 东西， 只有父类自己可以用

把Item里面的 private 搞成 protected 

package cdPlayer;

public class Item {
	
   protected String title;
	
	public void print() {
		System.out.println("Item");
	}
}

protected 在这里的的意思是： 自己可以访问 同一个包内的其他类可以访问 子类可以访问（在不同的包package里面）
protected 可以让子类访问到父类标识为 protected 的成员
同时保证，没有关系的类 不能访问



http://blog.csdn.net/ladofwind/article/details/774072


在说明这四个关键字之前，我想就class之间的关系做一个简单的定义，对于继承自己的class，base class可以认为他们都是自己的子女，而对于和自己一个目录下的classes，认为都是自己的朋友。

 

1、public：public表明该数据成员、成员函数是对所有用户开放的，所有用户都可以直接进行调用

 

2、private：private表示私有，私有的意思就是除了class自己之外，任何人都不可以直接使用，私有财产神圣不可侵犯嘛，即便是子女，朋友，都不可以使用。

 

3、protected：protected对于子女、朋友来说，就是public的，可以自由使用，没有任何限制，而对于其他的外部class，protected就变成private。

作用域 当前类 同一package 子孙类 其他package 


public       √ √ √ √ 

protected √ √ √ × 

friendly     √ √ × × 

private     √ × × × 

不写时默认为friendly 


方法 2 ：
为Item做一个构造器：
做出 Item 的初始化：
package cdPlayer;

public class Item {
	
   private String title;
	
	public void print() {
		System.out.println("Item");
	}

	public Item(String title) { // Item 初始化 Item  构造器
		super(); // Item 初始化
		this.title = title; // Item 初始化
	}
}

然后把 CD 的构造器的第一句话 ： title 传过去：
	super(title);
//  this.title=title;

顺序： 先去做父类的部分的初始化（or 构造）
	再做定义初始化 
	最后 进 构造函数， 做初始化 


DVD里： 构造函数 里面有个 super();
super() 的意思是： 调用父类里面 没有参数的构造器
不能去掉 super() : Eclipse 认为 Item 父类里面 应该有一个 不带参数的构造器

	public DVD(String title, String director, int playingTime, String comment) {
		super();
		this.title = title;
		this.director = director;
		this.playingTime = playingTime;
		this.comment = comment;
	}

如果要去掉 DVD 构造函数里的 super() 也可以
// super（）； 在DVD里面

在 Item里面建一个没有参数的构造函数：

  public Item() { //Item 里面的没有参数的 构造器
	   
   }

DVD 的构造函数里 没有 super();
如果构造一个子类的 对象 ， 对象会先去调用父类的构造器，
子类没有通过参数 传递给父类的构造器， 子类会去寻找 不带参数的构造器

通过参数，可以寻找适合的 匹配的 父类构造器：

原则是：
当我们构造一个子类的对象的时候
首先要确保 子类的父类的 成员变量有恰当的初始化（定义初始化+构造器）// 一般先做定义初始化，再做构造器
先做 父类的 定义初始化 + 构造器
再做  子类的 定义初始化 + 构造器
以上的程序顺序是存在的

不管你是不是主动的用 super() 去传递参数， 指定去调用哪一个父类哪一个构造函数
子类里 如果没有 super() ， 就回去找没有父类里没有参数的构造器
如果子类里有  super(), 子类就会根据参数去找恰当的父类里的构造器


完整的代码：
package cdPlayer;

public class CD extends Item {
	
//	private String title;
	private String artist;
	private int numOfTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super(title);
	//	this.title = title;
		this.artist = artist;
		this.numOfTracks = numOfTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CD cd= new CD("a","b",2,2,"...");
		cd.print();
	}

//	public void print() {
//		// TODO Auto-generated method stub
//		System.out.println("CD"+title+":"+artist);
//		
//	}

}


package cdPlayer;

public class DVD extends Item {
	
	private String title;
	private String director;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	

	public DVD(String title, String director, int playingTime, String comment) {
	//	super();
		this.title = title;
		this.director = director;
		this.playingTime = playingTime;
		this.comment = comment;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println("DVD "+title+":"+director);
	}
	
	public static void main(String[] args) {
		DVD dvd= new DVD("a", "b", 1,"...");
		dvd.print();
	}
}


package cdPlayer;

public class Item {
	
   private String title;
   
   public Item() {
	   
   }
   
	
	public void print() {
		System.out.println("Item");
	}

	public Item(String title) {
		super();
		this.title = title;
	}
}


package cdPlayer;

import java.util.ArrayList;


public class Database {
	
//	private ArrayList<CD> listCD= new ArrayList<CD>();
//	private ArrayList<DVD> listDVD= new ArrayList<DVD>();
	
	private ArrayList<Item> listItem = new ArrayList<Item>();
	
//	public void add(CD cd) {
//		listCD.add(cd);
//	}
//	
//	public void add(DVD dvd) {
//		listDVD.add(dvd);
//	}
//	
	
	public void add(Item item) {
		listItem.add(item);
	}
	
//	public void list() {
//		for(CD cd: listCD) {
//			cd.print();
//		}
//		
//		for(DVD dvd: listDVD) {
//			dvd.print();
//		}
//	}

		public void list() {
			for(Item item: listItem) {
				item.print();
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Database db = new Database();
		db.add(new CD("abc", "abc", 4, 60, "..."));
		db.add(new CD("def", "def", 4, 60, "..."));
		
		db.add(new DVD("xxx", "aaa", 60,"..."));
		
		db.list();
	}

}


// 23 4-2 子类父类关系-2
把事情做完  相同的东西。。。
这块 今晚我不想看 明早补上 

//1  CD
package dome;

public class CD extends Item {
	
	private String artist;
	private int numOfTracks;
	
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super(title,playingTime, false, comment);
		this.artist = artist;
		this.numOfTracks = numOfTracks;
	
	}

	public static void main(String[] args) {
		CD cd= new CD("a","b",2,2,"...");
		cd.print();

	}

}


//2  DVD 

package dome;

public class DVD extends Item{


	private String director;

	public DVD(String title, String director, int playingTime, String comment) {
		super(title,playingTime, false, comment);
		
		setTitle("b");
		this.director = director;
	
	}

	public static void main(String[] args) {
		DVD dvd= new DVD("a","b",1,"...");
		dvd.print();
	}

	public void print() {
		System.out.print("DVD: ");
		super.print();
		System.out.println(director);
	}

}

//3 Item

package dome;

public class Item {

	private String title;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	
	
	
	public Item(String title, int playingTime, boolean gotIt, String comment) {
		super();
		this.title = title;
		this.playingTime = playingTime;
		this.gotIt = gotIt;
		this.comment = comment;
	}

	
	public void setTitle(String title) {
		this.title=title;
	}

	public void print() {
		// TODO Auto-generated method stub
		System.out.println(title);
	}

}

// 4 database
 
package dome;

import java.util.ArrayList;

public class Database {
	
	private ArrayList<Item> listItem= new ArrayList<Item>();

	
	public void add(Item item) {
		listItem.add(item);
	}
	
	public void list() {
		
		for(Item item: listItem)
		{
			item.print();
		}
	}
	
	public static void main(String[] args) {
		Database db= new Database();
		db.add(new CD("abc","abc",4,60,"..."));
		db.add(new CD("abd","abd",4,60,"..."));
		db.add(new DVD("xx","aaa",60,"..."));
		db.list();

	}

}




//24  5-1 多态变量和向上造型 -1 
子类 和 子类型：
类定义了类型
子类定义了子类型
子类的对象可以被当作父类的对象来使用
	赋值给父类的变量
	传递给需要父类对象的函数
	放进存放父类对象的容器
	
对象的变量是管理者
	
	
子类型与赋值：

vehicle（car bicycle）
子类的对象可以赋值给父类的变量？？？

Vehicle v1= new Vehicle();
Vehicle v2= new Car();
Vehicle v3= new Bicycle();

子类和参数传递：

public class Database{
	
	public void add(Item theItem)
	{
		...
	}
}


多态变量：
Java的对象变量是多态的， 他们能保存不止一种类型的对象
它们可以保存的是声明类型的对象，或者声明类型的子类的对象
当把子类的对象赋给父类的变量的时候， 就发生了向上造型

声明类型 Item （Database） 静态的
动态类型 

多态变量： 这个变量运行的时候， 在具体某个时刻，它所管理的对象是会变化的

把子类的对象 交给父类的变量（静态类型为父类的变量）： 向上造型

//25 5-1 多态变量和向上造型 -2

造型： 把一个类型的对象 赋给 另外一个类型的变量
子类的对象 可以赋值给 父类的变量的

造型 Cast
子类的对象 可以赋值给 父类的变量的
	Note Java 中不存在对象 给 对象 的赋值
	
父类的对象不能赋值给子类的变量

Vechicle v;
Car c= new Car();
v=c; // 可以使用
c=v; // 编译错误
可以用造型：
c=(Car)v;
只有当v 这个变量实际管理的是 Car 才行

public class Database {
	
	private ArrayList<Item> listItem= new ArrayList<Item>();

	
	public void add(Item item) {
		listItem.add(item);
	}
	
	public void list() {
		
		for(Item item: listItem)
		{
			item.print();
		}
	}
	
	public static void main(String[] args) {
		Database db= new Database();
		db.add(new CD("abc","abc",4,60,"..."));
		db.add(new CD("abd","abd",4,60,"..."));
		db.add(new DVD("xx","aaa",60,"..."));
		db.list();
	}
}


对象变量的赋值：

具体说：
String s="hello";
s="bye";
原来 s 是管理“hello”的，后来s去管理 叫“bye”的对象

Item item = new Item("a",0,true, "...");
CD cd = item;  // 类型不匹配

CD cd = new CD("a","a",0,0,"...");
item=cd;  // 安全
CD cc=cd; // 安全
CD cc=(CD) item; //
 
假如说：
Item item = new Item("a",0,true, "...");
CD cd = new CD("a","a",0,0,"...");
//item=cd;
CD cc= (CD)item;
OUTPUT:
Item cannot be cast to dome 


造型：
用括号围起来放在值的前面
对象本身并没有发生任何变化
	所以不是“类型转换”
运行时有机质来检查这样的转化是否是合理的
ClassCastException 


int i= (int)10.2; // 类型转换 10.2 不存在了
造型是： 把你当作另外一个类型看待 ， 并没有改造这个类型

向上造型： 
item =(Item)cd;
cd 没有被换掉：
就是把 cd 当作item来看待 ， 不需要把cd 转变成 item 类型

cast: 造型

向上造型：
拿一个子类的对象，当作父类的对象来用
向上造型是默认的， 不需要运算符
向上造型总是安全的

对于 int double 这些 是类型转换
对于对象类型 是造型


//26 5-2 多态
database 中：
public void list(){
	for(Item item: listItem){
		item.print();
	}
}

Item 中：
public void print(){
	System.out.println(title);
}

不只是看到了 Item给出的title 还有其他的输出内容
CD DVD 的print() 函数都被调用了

管理 CD类的对象： Item 的print() 会到 CD 里的print（）

Item 里是实际是什么类型， 会做什么类型的动作
这就是多态， 这件事情的基础是：

函数调用的绑定：
当通过对象变量调用函数的时候， 调用哪个函数这件事情叫做绑定
	静态绑定： 根据变量的声明类型来决定
	动态绑定： 根据变量的动态类型来决定
在成员函数中调用其他成员函数也是通过 this 这个对象变量来调用的

覆盖： override：
子类和父类中存在名称和参数完全相同的函数， 这一对函数构成覆盖关系
比如说， cd 的 print() 就覆盖了 item 的 print()

通过父类的变量调用存在覆盖关系的函数时，会调用变量当时所管理的对象所属的类的函数



//27 5-3 类型系统 Object 类
单根结构
object 类：
所有的类都是继承自 object 的
xxx extends Object 

Object 类的函数：
toString();
equals();
public static void main(String[] args)
{
	CD cd = new CD("a","b",2,2,"...");
	cd.print();
	System.out.println(cd.toString());
	
	Object o= new Object();
	o.toString(); //返回 用一个字符串表达一个对象
}
	

public class CD{
    private String title;
    private String artist;
    private int numOfTracks;
    private int playingTime;
    private String comment;
    
    public CD(String title, String artist, int numOfTracks, int playingTime, String comment){
        this.title=title;
        this.artist=artist;
        this.numOfTracks=numOfTracks;
        this.playingTime=PlyingTime;
        this.comment=comment;
    }
    
    public void print(){
        System.out.println(title);
    }
    
    public static void main(String[] args)
    {
        CD cd= new CD("a","b",2,2,"...");
        cd.print();
		System.out.println(cd.toString()); //important 
        
        System.out.println(cd); 
    }
}
OUTPUT:
a
CD@6d06d69c
CD@6d06d69c

也就是说 ： cd.toString() 和 cd 的输出结果是一样的 
有：

String s= "aa"+cd; // 自动寻找方案， 把不是字符串的东西转换成字符串
System.out.println(s);

OUT:
aaCD@6d06d69c


source -  Generate toString()
	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numOfTracks=" + numOfTracks + ", toString()=" + super.toString() + "]";
	}
	
完整代码：
package dome;

public class CD extends Item {
	
	private String artist;
	private int numOfTracks;
	
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super(title,playingTime, false, comment);
		this.artist = artist;
		this.numOfTracks = numOfTracks;	
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numOfTracks=" + numOfTracks + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		CD cd= new CD("a","b",2,2,"...");
		cd.print();
System.out.println(cd.toString()); //important 
        
        System.out.println(cd); 
        String s= "aa"+cd; 
        System.out.println(s);

	}

}
OUTPUT：
a
CD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]
CD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]
aaCD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]


== 只能说明 这两个字符串 数组 是否管理同一个对象
比较两者是否相同， 要用 equals();


CD cd= new CD("a","b",2,2,"...");
CD cd1= new CD("a","b",2,2,"...");
System.out.println(cd.equals(cd1));
OUTPUT: 
false 
// 没有做自己的 equals 需要自己的 equals 判断两者的值 是否相同

Object 的 equals() 只是判断两者是不是管理同一个对象，而不是内容是否是相同的
自己写一个 cd 类的 equals();

source - Override / Implement Methods 
列出父类有什么样的函数， 重新改写 哪个函数
Object 里面有 equals(Object)

CD cd= new CD("a","b",2,2,"...");
CD cd1= new CD("a","b",2,2,"...");
System.out.println(cd.equals(cd1));

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		CD cc=(CD)obj;
		return artist.equals(cc.artist);
	}
	
	OUTPUT:
	true
	
Override:
告诉编译器， 下面的函数是覆盖了 父类的函数，
和父类有完全相同的父类签名 或者是 函数原型
函数的名字， 函数的参数表 完全是一样的 
如果有一个不相同， 就是错误的
比如： 去掉 public 就错误了
因为 Object 这类里面的 equals() 函数是 public 的
把 Object 类型 换成 CD 类型 也是不行的
取消 @Override ， 可以把 Object 改成 CD 

    boolean equals(CD obj) {
		// TODO Auto-generated method stub
		CD cc=(CD)obj;
		return artist.equals(cc.artist);
	}

	
Complete code :

package dome;

public class CD extends Item {
	
	private String artist;
	private int numOfTracks;
	
	
	public CD(String title, String artist, int numOfTracks, int playingTime, String comment) {
		super(title,playingTime, false, comment);
		this.artist = artist;
		this.numOfTracks = numOfTracks;	
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + ", numOfTracks=" + numOfTracks + ", toString()=" + super.toString() + "]";
	}

	public static void main(String[] args) {
		CD cd= new CD("a","b",2,2,"...");
		cd.print();
		System.out.println(cd.toString()); //important 
        
        System.out.println(cd); 
        String s= "aa"+cd; 
        System.out.println(s);
  
        CD cd1= new CD("a","b",2,2,"...");
        System.out.println(cd.equals(cd1));

	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		CD cc=(CD)obj;
		return artist.equals(cc.artist);
	}

}

OUTPUT:
a
CD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]
CD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]
aaCD [artist=b, numOfTracks=2, toString()=dome.CD@70dea4e]
true

//28 5-3 类型系统-2 Dome的新媒体类型

可扩展性： 代码不朽要经过修改
可维护性

更深的继承


//29 6-1 城堡游戏
下载代码， 在哪里？？？

//30 6-2消除代码复制
原则1： 
	代码复制是不良设计的一种表现
	
//31 6-3 封装：
增加可扩展性：
可以运行的代码！=良好的代码
对代码做维护的时候最能看出代码的质量
如果想要增加一个方向， 如 down up

用封装来降低耦合
Room类和 Game类 都有大量的代码和出口相关
尤其是Game类中大量使用了ROOM类的成员变量
类和类之间的关系称作耦合
耦合越低越好， 保持距离是形成良好代码的关键





 https://www.bilibili.com/video/av10912258/?from=search&seid=13554981374342867724
6.1 抽象
抽象函数没有 {}；
一个类里面有一个抽象函数，这个类也必须是抽象的
抽象的类  是不能产生对象的 


public abstract class Shape{
	
	public abstract void draw(Graphics g);
	
	
	public static void main(String[] args){
		Shape s= new Shape();// cannot instantiate the type Shape 
	// 不能实例化 Shape 这个类型
	// 因为 class Shape 是抽象的
	
	}
}


抽象函数/抽象类：
抽象函数--- 表达概念而无法实现具体代码的函数
抽象类 --- 表达概念而无法构造出实体的类

带有abstract修饰符的函数

有抽象函数的类一定是抽象类
抽象类不能制造对象
但是可以定义变量
	任何继承了抽象类的非抽象类的对象可以付给这个变量
	

	
	

// 6.2 抽象




