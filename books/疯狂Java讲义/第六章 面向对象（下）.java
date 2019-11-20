第六章 面向对象（下）
Page 178 - Page 233 

Page 178 

6.1 Java7 增强的包装类 

这部分以后再看

Page 182 


6.2 处理对象
6.2.1 打印对象和 toString 方法

class Person
{
	private String name;
	public Person(String name)
	{
		this.name=name;
	}
	
	public void info()
	{
		System.out.println("the name is "+name);
	}
}

public class PrintObject
{
	public static void main(String[] args)
	{
		Person p=new Person("Abel");
		System.out.println(p);
	}
}

OUT：
Person@7852e922

p 是 Person 实例是一个内存中的对象
当输出 Person 对象p 的时候， 实际上输出的是
Person 对象的 toString() 方法的返回值

System.out.println(p) ;
System.out.println(p.toString());

//这两种输出的结果是一样的

Java 对象都可以和字符串进行连接运算
当。。。。 系统自动调用 Java 对象 toString() 方法的返回值和
字符串进行连接运算，下面两行的代码相同

String pStr=p+"";
String pStr=p.toString()+"";

Object 类提供的 toString 方法总是返回该对象实现类 “类名+@hashCode”值
如果用户需要自定义类实现 “自我描述”的功能，
就必须重写 Object 类的 toString() 方法

// toString() 方法是可以 覆盖重写的 
class Apple
{
	private String color;
	private double weight;
	
	public Apple(String color, double weight)
	{
		this.color=color;
		this.weight=weight;
	}
	
	public String toString() // 重写 toString() 方法
	{
		return "apple color: "+color+" weight is "+weight;
	}
}

public class ToStringTest
{
	public static void main(String[] args)
	{
		Apple a= new Apple("red ",5.68);
		System.out.println(a);
	}
}

OUT：
apple color: red  weight is 5.68


Page 6.2.2 == && equals 方法

Java 中 测试两个变量是否相等 2 种方法
== 运算符
equals () 方法 

如果两个变量都是基本数值类型， 且都是 数值类型（不一定数据类型是一样的）
只要两个变量的值相等 就返回 true

对于 两个引用变量， 指向同一个对象的时候， == 才会返回 true
== 不可以用于比较类型上 没有父子关系 的两个对象

public class EqualTest
{
	public static void main(String[] args)
	{
		int it=65;
		float fl=65.0f;
		
		System.out.println("65 equlas to 65.0 ??"+(it==fl));
		
		char ch='A';
		System.out.println("65 euqlas to 'A'??" +(it==ch));
		
		String str1= new String("hello");
		String str2= new String("hello");
		
		System.out.println("str1 == str2 ??? "+(str1==str2));
		System.out.println("str1 equlas str2 "+str1.equlas(str2));
		
		System.out.println("hello"== new EqualTest()); //  incomparable types: String and EqualTest
	}
}

OUT:
65 equlas to 65.0 ??true
65 euqlas to 'A'??true
str1 == str2 ??? false
str1 equlas str2 true

str1 str2 都是引用变量 是两个通过 new 关键字创建的 String 对象，
因此 str1 和 str2 两个变量不同

常量管理池 

public class StringCompareTest
{
	public static void main(String[] args)
	{
		String s1="CrazyJava";
		String s2="Crazy";
		String s3="Java";
		String s4="Crazy"+"Java";
		String s5="Cr"+"azy"+"Java";
		String s6=s2+s3;
		String s7= new String("CrazyJava");
		
		System.out.println(s1==s4); //true
		System.out.println(s1==s5); // true 
		
		System.out.println(s1==s6);  //false 
		System.out.println(s1==s7);  // false 
	}
}

OUT:
true
true
false
false	


equals() 方法是 Object 类提供的一个实例方法，所有的引用变量都可调用
该方法来判断是否与其他引用变量相等

但是这个方法判断两个对象相等的标准与使用 == 运算符没有区别
同样要求两个引用变量指向 同意额对象才会 返回 true。
所以 Object 类提供的 equals () 方法没有实际的意义
可以重写 equals() 方法 

class Person
{
	public boolean equals(Object obj)
	{
		return true;
	}
}

class Dog{}

public class OverrideEqualsError
{
	public static void main()
	{
		Person p= new Person();
		System.out.println("Person equals to Dog??? "+p.equals(new Dog()));
		System.out.println("Person equals String ??? "+p.equals(new String("Hello")));
	}
}


OUT:

Person equals to Dog??? true
Person equals String ??? true

重写 Person 类的 equals() 方法 // 不懂 

class Person
{
	private String name;
	private String idStr;
	
	public Person(){}
	public Person(String name, String idStr)
	{
		this.name=name;
		this.idStr=idStr;
	}
	
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
		
		if(obj!=null && obj.getClass() == Person.class)
		{
			Person personObj=(Person)obj;
			
			if(this.getIdStr().equals(personObj.getIdStr()))
			{
				return true;
			}
		}
		return false;
	}
}

public class OverrideEqualsRight
{
	public static void main(String[] args)
	{
		Person p1=new Person("abel","1111111");
		Person p2=new Person("abel-1","2222222");
		Person p3=new Person("abel-2","3333333");
		
		System.out.println("p1 = p2?? "+p1.equals(p2));
		System.out.println("p2 =p3 ??"+ p2.equals(p3));
	}
}

OUT:




Page 187 
6.3 类成员

类成员有：
Field ， 类方法， 静态初始化块
static 不能修饰构造器  


6.3.1 理解类成员

Java 类里面， 只能包含：
Field  方法  构造器  初始化块  内部类（接口 枚举） 这 5 种 成员

类的 Field 生存范围== 类 的生存范围

当系统创建类的对象的时候， 不会再为了类 Field 分配内存
也不会再次系队类 Field 进行初始化， 对象根本不拥有对应类的 类Field 

由于对象实际上并不拥有 类 Field ， 类field 是由该类持有的 
同一类的所有实例的类 Field 共享一块内存区  // important 

对象来访问类成员的时候， 实际上 是委托给该类来访问类成员，
即使是 某个实例=null ， 它也可以访问它所属的类的 类成员

public class NullAccessStatic 
{
	private static void test()
	{
		System.out.println("static 修饰的类方法");
	}
	
	public static void main(String[] args)
	{
		NullAccessStatic nas=null;
		nas.test();
	}
}

OUT:

static 修饰的类方法


如果一个 null 对象访问 实例成员（ Field 和方法），将会引发 NullPointerException,
因为 null 表明该 对象 实例根本不存在，  既然实例不存在，
那么 它的 Field 和 方法 也不会存在

静态初始化块 也是 类成员的一种， 静态初始化块用于执行类的初始化动作
在类的初始化阶段， 系统会调用该类的静态初始化块来对类 进行初始化，
初始化结束后，静态初始化块 将 永远不会获得执行的机会

static : 
类成员： （方法， 初始化块， 内部类， 枚举类 ）
不能访问实例成员（field, 方法， 初始化块， 内部类。 枚举类）
因为类成员是属于类的 ，类成员的作用域要比实例成员的作用域 更大，
类成员已经初始化完成，但是 实例成员还没有初始化，
这样 类成员访问实例成员将会引发错误




Page  188 
6.3.2 单例 类 （Singleton）

如果 一个类始终只能创建一个实例， 则这个类被称为 单例类
要求不允许自由创建该类的对象，而只允许为该类创建一个对象

把该类的构造器用 private 修饰，把该类的所有构造器隐藏起来

一旦把该类的构造器隐藏起来，就需要提供一个 public 方法作为该类的访问点
用于创建该类的对象，
该方法必须使用 static 修饰（因为调用该方法之前还不存在对象，因此调用该方法
不能是对象，只能是 类）

该类需要使用一个成员变量来保存曾经创建的对象，
因为该成员变量需要被上面的静态方法访问，故该成员变量必须使用 static 修饰

class Singleton 
{
	private static Singleton instance;
	
	private Singleton() {}
	
	public static Singleton getInstance()
	{
		if(instance==null)
		{
			instance = new Singleton();
		}
		return instance;
	}
}

public class SingletonTest
{
	public static void main(String[] args)
	{
		Singleton s1= Singleton.getInstance();
		Singleton s2= Singleton.getInstance();
		
		System.out.println(s1==s2);
	}
}

OUT:
true 

不允许自由访问 类的 Field 和 实现细节，而是通过方法来控制合适暴露
保证 Singleton 类只能产生一个实例
在 main() 方法里， 看到两次产生的 Singleton 实际上是同一个对象



Page 189 

6.4 final 修饰符
final 可以修饰 类 变量 方法 ， 用于表示 它修饰的 类， 方法， 和 变量是不可变的

final 修饰变量的时候，该变量一旦获得了初始值，就不可被改变，

final 既可以修饰成员变量（类 or 实例变量），也可以修饰局部变量 形参
final 修饰的变量不可被改变，一旦获得了初始值，该 final 变量的值就不能重新被赋值


PAge 189 

6.4.1 final 成员变量
在 执行静态初始化块时 可以对 类Field 赋初始值，当执行普通初始化块，构造器时
可以对 实例 Field 赋初始值，
因此，成员变量的初始值可以在定义该变量时指定默认值，也可以在初始化块，构造器中指定初始值

final 修饰的成员变量，一旦有了初始值，就不能被重新赋值了
 
final 修饰的成员变量必须由程序员显式指定初始值

final 修饰的 类Field 实例 Field 能指定初始值的地方：
类： Field： 必须在静态初始化块中 or 声明该 Field 时指定初始值
实例 Field： 必须在非静态初始化块， 声明 该Field 或 构造器中指定初始值

Note：
	final 修饰的实例 field， 要么在定义该Field 的时候指定初始值，
要么在普通初始化块 or 构造器中指定 field 的初始值
如果普通初始化块已经为某个实例field 指定了初始值，则不能再在构造器中为
该实例 field 指定初始值，
final 修饰的 类 field， 要么在定义该 Field 的时候指定初始值，要么在静态初始化块中为
该类field 指定初始值，

实例 field 不能在静态初始化块中指定初始值，
类 field 不能在普通初始化块中 指定初始值，
因为 类 Field 在类初始化阶段已经被初始化了 普通初始化块不能对其重新赋值 



public class FinalVariableTest
{
	final int a=6; // 定义成员变量指定默认值， 
	final String str;
	final int c;
	final static double d;
	
	{
		str="Hello"; // 初始化块中 为实例 Field 指定初始值 
		//a=9; 不能重新赋值， 因为定义 a field 的时候已经指定了 默认值
	}

	static 
	{
		d=5.6; // 静态初始化块中，为 类 Field 指定初始值
	}
	
	public FinalVariableTest()
	{
		// str="java"; 非法： 不能重新赋值
		c=5; // 构造器中， 为实例变量 指定初始值
	}
	
	public void changeFinal()
	{
		
	}
	
	public static void main(String[] args)
	{
		FinalVariableTest ft= new FinalVariableTest();
		System.out.println(ft.a);
		System.out.println(ft.c);
		System.out.println(ft.d);
	}
}

OUT:

6
5
5.6

与普通成员变量不同： final 的 成员变量（including 实例filed， 类filed）
必须要由程序员显式地初始化，系统不会对 final 成员进行隐式初始化

public class FinalErrorTest
{
	final int age;
	
	{
		System.out.println(age); // variable age might not have been initialized
		age=6;
		System.out.println(age);
	}
	
	public static void main(String[] args)
	{
		new FinalErrorTest();
	}
}

OUT:
variable age might not have been initialized
6 
 
final 成员变量： age 系统不会对 age 成员进行隐式初始化，
把final 去掉 就正确了


Page 191 

6.4.2 final 局部变量
系统不会对 局部变量进行初始化，局部变量必须要由程序员显式初始化
因此， final 修饰局部变量地时候，既可以在定义地时候指定默认值，也可以不指定默认值

final 修饰地局部变量在定义时没有指定默认值，则可以在后面代码中对该 final 变量赋初始值
但是 只能一次 ， 不能重复赋值
如果 final 修饰地 局部变量在定义地时候已经由了默认值，则后面地代码不能对该变量赋值

public class FinalLocalVariableTest
{
	public void test(final int a)
	{
		// a=5;
		// final 修饰的 形参 不能赋值 
	}
	
	public static void main(String[] args)
	{
		final String str="hello";
		
		// str="Java";  // 语句非法
		
		final double d;
		d=5.6;
		// d=3.4; // 不能对局部final变量重复赋值  语句非法 
	}
}

final 修饰形参： 形参在调用该方法的时候，由系统根据传入的参数来完成初始化，
因此 使用  final 修饰的 形参不能被赋值 



Page 192 

6.4.3 final 修饰基本类型变量 和 引用类型变量的 区别 

当使用 final 修饰基本类型变量的时候 ， 不能对基本类型变量重新赋值
所以 基本类型变量布恩那个被改变

引用变量： 它保存的仅仅是一个引用，
final 只保证这个引用类型变量所引用的地址不会发生变化，
既 一直引用同一个对象，但是 这个对象完全可以发生变化 

class Person 
{
	private int age;
	
	public Person(){}
	
	public Person(int age)
	{
		this.age=age;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return age;
	}
}

public class FinalReferenceTest
{
	public static void main(String[] args)
	{
		final int[] iArr={5,6,12,9};
		System.out.println(Arrays.toString(iArr));
		
		Arrays.sort(iArr);
		System.out.println(Arrays.toString(iArr));
		
		iArr[2]=-8;
		System.out.println(Arrays.toString(iArr));
		
		//iArr=null;  cannot assign a value to final variable iArr
		
		final Person p=new Person(45);
		p.setAge(23);
		System.out.println(p.getAge());
		
		//p=null;
	}
}

OUT:
[5, 6, 12, 9]
[5, 6, 9, 12]
[5, 6, -8, 12]
23
	
final 修饰的 引用类型变量 不能被重新赋值，但是可以改变引用类型变量所引用对象的内容
所引用的数组的元素可以被改变
p 变量 也使用了 final 修饰， p 变量虽然不能被重新赋值，
但是 p 变量所引用的 Person 对象的 Field 可以被改变




Page 192 

6.4.4 可执行“宏替换”的 final 变量
final 变量， 不管是 类 field， 实例 field， 还是局部变量
（1）. 使用 final 修饰符
（2）. 定义该 final 变量的时候 制定了初始值
（3）. 初始值在编译的时候就确定下来了

public class FinalLocalTest
{
	public static void main(String[] args)
	{
		final int a=5;
		System.out.println(a);
	}
}

// 这个a 根本不存在，执行System.out.println(a); 就是执行 System.out.println(5);

Note：
final 变量本质就是一个 “宏变量”， 编译器会把程序中所有用到该变量的地方 直接替换成 该变量的值

如果被赋值的表达式只是基本的算术表达式， 或者 字符串连接运算，
没有访问普通的变量，没有 调用方法， final 变量还是 “宏变量”

public class FinalReplaceTest
{
	public static void main(String[] args)
	{
		final int a=5+2;
		final double b=1.2/3;
		final String str="Crazy"+"Java";
		final String book="CrazyJava"+99.0;
		
		final String book2="CrazyJava"+String.valueOf(99.0);
		System.out.println(book=="CrazyJava99.0");
		System.out.println(book2=="CrazyJava99.0");
		// 调用了方法 无法在编译的时候 确定下来
	}
}

OUT:
true
false

	
public class StringJoinTest
{
	public static void main(String[] args)
	{
		String s1="CrazyJava";
		String s2="Crazy"+"Java";
		System.out.println(s1==s2);
		
		String str1="Crazy";
		String str2="Java";
		String s3=str1+str2;
		System.out.println(s1==s3);
	}
}

OUT:
true
false

Note:
对于实例变量而言，可以在定义该变量的时候赋初始值，也可以在非静态初始化块，
构造器中对它赋初始值， 效果一致
对于 final 实例变量而言，只有在定义该变量的时候 指定初始值才会有 “宏变量”的效果



Page 194 

6.4.5 final 方法 
final 修饰的方法不可以被重写
不希望子类重写父类的某个方法，则可以使用 final 修饰 该方法 

Object类里有一个 final 方法， getClass() 
toString() equals() 方法 都可以被重写  没有 final 修饰它们

public class FinalMethodTest
{
	public final void test(){} // final  修饰父类里的方法 不希望子类重写
}

class Sub extends FinalMethodTest
{
	public void test(){}
}

OUT:
 test() in Sub cannot override test() in FinalMethodTest
 
子类试图重写 引发编译错误


private 方法， 只能在当前的类中， 子类无法访问这个方法 ，也无法重写这个方法
如果子类中定义了一个与父类 private 方法具有相同的方法名，相同的形参列表，
相同返回值类型的方法，这不是重写， 这是 重新定义了一个方法

因此 用 final 修饰一个 private 访问权限的方法，
依然可以在子类中 定义与 该方法具有相同方法名字， 相同的形参列表，相同返回值的方法

public class PrivateFinalMethodTest
{
	private final void test() {}
}

class Sub extends PrivateFinalMethodTest
{
	public void test(){}
}

final 修饰的方法仅仅是不能被重写，并不是不能被重载

public class FinalOverload
{
	public final void test(){}
	public final void test(String arg){}
}



Page  195  -243 

6.4.6 final 类
final 修饰的类不可以有子类，
为了保证某个类不可被继承，则使用 final 修饰这个类 

public final class FinalClass{}

class Sub extends FinalClass{}
引发编译错误


Page 195 

6.4.7 不可变类

	immutable 类: 创建该类的实例后，实例的 field 是不可以改变的。
	包装类 和 java.lang.String 类都是不可变类 
	当创建它们的实例后，实例的 field 是不可变的 。
	
	Double d= new Double(6.5);
	String str=new String("Hello");
	
	程序无法修改这个两个实例 field 值
	
如果需要自定义不可变类：
（1）. 使用 private 和 final 修饰符来修饰该类的 Field 
（2）. 提供带参数的构造器，用于根据传入参数来初始化类里的 field 
（3）. 仅仅为该类的 Field 提供 getter 方法，不要为该类的 field 提供 setter方法
		因为普通方法无法修改 final 修饰的 field 
（4）. 如果有必要， 重写 Object 类的 hashCode 和 equals 方法 
	equals() 方法 判断为相等的对象 的 hashCode 也相等 
	
	如 java.lang.String 这个类
	就是根据 String 对象里的字符序列来作为相等的标准，其 hashCode方法也是根据
	字符序列计算得到的 
	下面测试 equals 和  hashCode 方法

public class ImmutableStringTest
{
	public static void main(String[] args)
	{
		String str1= new String("Hello");
		String str2= new String("Hello");
		
		System.out.println(str1==str2);
		
		System.out.println(str1.equals(str2));
		
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}
}

OUT:
false
true
69609650
69609650


	自定义一个不可变的 address 类，程序把 address 类的 detail 和 postCode
成员变量都是用 private 隐藏起来， 并使用 final 修饰这两个成员变量，
不允许其他方法修改这两个 field 值 

	
public class Address
{
	private final String detail;
	private final String postCode;
	
	public Address()
	{
		this.detail="";
		this.postCode="";
	}
	
	public Address(String detail, String postCode)
	{
		this.detail=detail;
		this.postCode=postCode;
	}
	
	public String getDetail()
	{
		return this.detail;
	}
	
	public String getPostCode()
	{
		return this.postCode;
	}
	
	public boolean equals(Object obj)
	{
		if(this==obj)
			return true;
	
		if(obj!=null && obj.getClass() == Address.class)
		{
			Address ad=(Address)obj;
			
			if(this.getDetail().equals(ad.getDetail())
				&& this.getPostCode().equals(ad.getPostCode()))
				{
					return true;
				}
		}
		
		return false;
	}
	
	public int hashCode()
	{
		return detail.hashCode()+postCode.hashCode()*31;
	}
}


	
	当使用 final 
	
// Page 195- 200
// 6.4.7 - 6.4.8  不可变类 缓存实例的不可变类  不想看 


Page 201 
6.5 抽象类：

父类只是知道其子类应该包含怎么样的方法，但是无法准确知道 这些子类如何实现这些方法
如： 定义了 一个 Shape class， 这个类提供一个计算周长的方法 calPerimeter()
但是 不同的 Shape 子类对周长的计算方法是不一样的， 即 Shape 无法准确知道子类的计算周长的方法

抽象方法 只有方法签名，没有方法实现的 方法 

6.5.1 抽象方法和抽象类

	抽象方法 和 抽象类 必须使用 abstract 修饰符来 定义， 
抽象方法的类只能被定义成抽象类， 抽象类里 可以没有抽象方法 

抽象方法 和 抽象类的规则：
（1）. 抽象类必须使用 abstract 修饰， 抽象方法也必须使用 abstract 修饰，
	抽象方法 里 没有 方法体 
（2）. 抽象类不能被实例化， 无法使用 new 关键字来调用 抽象类的 构造器创建
	抽象类的实例，
	即使是 抽象类里没有抽象方法， 这个抽象类也不能创建实例
（3）. 抽象类 包含： Field 方法（普通方法 和 抽象方法） 都可以，
	构造器，初始化块，内部类，枚举类 等 6种 成分，
	抽象类的构造器 不能用于创建实例，主要是用于被子类调用。
（4）.	 含有抽象方法的类， 只能被定义成 抽象类。

in conclusion： 抽象类不能创建实例

定义抽象方法 只需要  在普通方法上增加 abstract 修饰符， 把方法体全部去掉
方法后面增加 分号 即可 


定义抽象类 的  在普通类上 增加 abstract 修饰符即可，
普通类 （没有包含 抽象方法的类）增加 abstract 修饰符以后 也变成 抽象类

public abstract class Shape 
{
	{
		System.out.println("执行 Shape 的初始化块。。。");
	}
	
	private String color;
	
	public abstract double calPerimeter();
	
	public abstract String getType();
	
	public Shape() {}
	
	public Shape(String color)
	{
		System.out.println("执行 Shape 的构造器 。。。");
		this.color=color;
	}
	//...
}

这个 Shape 类里 有初始化块 构造器，这些不是在创建 Shape 对象时被调用的，
而是在创建其子类的实例的时候 被调用

抽象类 不能用于 创建实例， 只能被当作父类被其他子类继承

子类必须实现 Shape 类里 所有的抽象方法  abstract method 

public abstract class Shape 
{
	{
		System.out.println("执行 Shape 的初始化块。。。");
	}
	
	private String color;
	
	public abstract double calPerimeter(); // 抽象类-1 
	
	public abstract String getType(); // 抽象类-2  
	
	public Shape() {}
	
	public Shape(String color)
	{
		System.out.println("执行 Shape 的构造器 。。。");
		this.color=color;
	}
	//...
}

public class Triangle extends Shape
{
	private double a;
	private double b;
	private double c;
	
	public Triangle(String color, double a, double b, double c)
	{
		super(color);
		this.setSides(a,b,c);
	}
	
	public void setSides(double a, double b, double c)
	{
		if(a>=(b+c) || b>=(a+c) || c>=(a+b))
		{
			System.out.println("三角形两边之和大于第三遍。。。");
			return;
		}
		
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	public double calPerimeter()
	{
		return a+b+c;
	}
	
	public String getType()
	{
		return "Triangle";
	}
}


创建一个 Triangle 类的对象， 可以让一个 Shape 类型的引用变量指向 Triangle 对象

public class Circle extends Shape
{
	private double radius;
	
	public Circle (String color, double radius)
	{
		super(color);
		this.radius=radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius=radius;
	}
	
	public double calPerimeter()
	{
		return 2*Math.PI*radius;
	}
	
	public String getType()
	{
		return "round";
	}
	
	public static void main(String[] args)
	{
		Shape s1=new Triangle("black",3,4,5);
		Shape s2=new Circle("yellow",3);
		
		System.out.println(s1.getType());
		System.out.println(s1.calPerimeter());
		
		System.out.println(s2.getType());
		System.out.println(s2.calPerimeter());
	}
}

这时 多态： 
编译的时候时 Shape 类， 执行的时  Triangle 和 Circle 类
但是调用的时候， 只能调用 Shape 类里面有的 方法 ，
执行的是  其子类的 方法 这是 多态： 无需强制类型转换成 其子类 类型

当使用 abstract 修饰类的时候， 表明这个类只能被 继承， 
当使用 abstract  修饰方法的时候， 表明 这个方法必须 由子类提供实现
（即 子类 必须重写 父类中  用 abstract 修饰的 方法 ）

final 修饰的 类 不能被 继承，
final  修饰的 方法 不能被 重写， 
所以，  final  abstract  永远不能同时  使用 

abstract 不能 用于 修饰 field 不能用于修饰 局部变量 
即 没有抽象变量 没有  抽象 field 
abstract 也不能用于 修饰构造器， 
抽象类里面的 构造器 也只能是 普通构造器 

static 和 abstract 不能同时 修饰某个方法 
即 没有所谓的 类抽象方法 

abstract 关键字 修饰的方法 必须 被其子类重写才有意义，
abstract 修饰的 方法 是没有方法体的 
因此， abstract 方法 不能定义为 private 访问权限，
即  private 和 abstract 不能 同时使用 

http://blog.csdn.net/u014453898/article/details/69473907

4.abstract 关键字 

1. abstract可以修饰类和方法，修饰类就是抽象类，修饰方法就是抽象方法，只有抽象类中才能有抽象方法。

2. 抽象方法用于被子类继承后重写。即是父类的抽象方法是空的，必须由子类继承之后在子类中由子类实现，这可以达到不同子类可以根据自己的特性来定义自己从父类继承过来的抽象方法。

3. abstract不能与final关键字共存，因为final关键字修饰的类是不能被继承的。

4. abstract不能与private关键字共存，因为私有的东西不能继承。

5. abstract不能与static关键字共存，当static修饰方法时，该方法可以通过类名直接调用，而abstract修饰的抽象方法是不能被调用的。
		

Page 204 
6.5.2  抽象类的作用
抽象类不能创建实例， 只能当成 父类来 被继承 

从多个 具有相同特征的类中 抽象出 一个抽象类， 以这个抽象类作为其子类的模板
从文避免了 子类设计的随意性 

子类总体是大致保留了抽象类的 行为方式

父类的普通方法依赖于一个抽象方法，而抽象方法则推迟到子类中提供实现：

public abstract class SpeedMeter
{
	private double turnRate;
	
	public SpeedMeter()
	{
	}
	
	public abstract double getRadius();
	
	public void setTurnRate(double turnRate)
	{
		this.turnRate=turnRate;
	}
	
	public double getSpeed()
	{
		return java.lang.Math.PI*2*getRadius()*turnRate;
	}
}

public  class CarSpeedMeter extends SpeedMeter
{
	public double getRadius()
	{
		return 0.28;
	}
	
	public static void main(String[] args)
	{
		CarSpeedMeter csm= new CarSpeedMeter();
		csm.setTurnRate(15);
		System.out.println(csm.getSpeed());
	}
}



Page  205 

6.6 接口：
接口： interface 接口里不能报价按普通方法，接口里所有的方法都是 抽象方法 

6.6.1 接口的概念：

接口定义了某一批类 所需要遵守的规范，
接口不关心类的内部状态数据， 也不关心这些类里方法的实现细节，
接口只规定这批类里西部提供的某些方法，提供这些方法的类 就可以满足实际需要

接口是从多个相似类中抽象出来的规范，接口不提供任何实现


Page 206 
6.6.2 接口的定义：
接口定义的基本语法：
[修饰符] interface 接口名 extends 父接口1， 父接口2.。。
{
	0- 多个 常量定义；
	0- 多个 抽象方法 定义。。。
}

（1） public 可以省略 相同包结构才能访问 接口 
（2） 首字母大写 
（3） 一个接口可以有多个直接父接口，但是 接口只能继承接口，不能继承类  // important 

接口的成员比 类里的成员 少了 2个 
接口里的 field 只能是常量， 接口里的方法只能是 抽象方法 

因为 接口里定义的是 多个 类 共同 的公共行为 规范，
因此 接口里的所有成员，包括 常量 ， 方法 ， 内部类 ， 枚举类 都是 public 访问权限的方法，
因此 只能使用 public 访问控制 修饰符 

接口里的 field 由于是常量， 系统会自动为 filed 增加 final static 修饰符
因此 接口里的 field 都是用  public  static  final 修饰的 

接口里 没有 构造器 和 初始化块 ，
所以 接口里的 field 只能在 定义的时候 指定 默认值 

接口里定义 Field  下面两行代码结果完全一样

int max=50;
public static final int max=50;


接口里的 方法只能是抽象方法， 所以不能是 静态方法， 
即 不可以使用 static 修饰接口里定义的方法，
接口里的方法总是使用 public abstract  来修饰

package lee;
public interface Output
{
	int MAX=50; // public static final 默认修饰  
	// static 可以通过类名调用  final  不能重新赋值 
	// public 任何情况下 都可以调用  
	void out();
	
	void getData(String msg);
}


因为 接口里  field 默认使用 public static final 来修饰的，
因为即使在不同的包下， 也可以通过 接口来访问 接口里 的 常量 field，

package yeeku;

public class OutputPropertyTest
{
	public static void main(String[] args)
	{
		System.out.println(lee.Output.MAX);
		
		lee.Output.MAX=20;// error final 已经下过定义 不能重新赋值
	}
}


Page 207 
6.6.3 接口的继承

接口完全支持多继承， 
即一个接口可以有多个直接 父接口 
子接口 扩展 某个父接口， 将会得到 父接口里定义的 
所有抽象方法， 常量 field, 内部类 和 枚举类 

interface interfaceA
{
	int A=5;
	void testA();
}

interface interfaceB
{
	int B=6;
	void testB();
}

interface interfaceC extends interfaceA, interfaceB
{
	int C=7;
	void testC();
}

public class InterfaceExtendsTest
{
	public static void main(String[] args)
	{
		System.out.println(interfaceC.A);
		System.out.println(interfaceC.B);
		System.out.println(interfaceC.C);
	}
}
// 接口只能继承 接口 接口不能继承类 
OUT:
5
6
7
interfaceC 获得 AB 里的 常量 main() 方法里调用 ABC 


Page 208 
6.6.4 使用接口：

接口不能用于 创建实例，但是 接口可以用于 声明引用类型变量，
当使用 接口来声明引用类型变量的时候， 
这个引用类型变量必须引用到 其  实现类的 对象

一个类可以实现一个或者 多个接口， 继承使用 extends 关键字， 实现则使用 
implements 关键字 

[修饰符] class 类名 extends 父类 implements 接口1， 接口2 .。。
{
   。。。。	
}


实现接口 可以获得 接口里 定义的 常量 field 抽象方法， 内部类， 枚举类 


一个类实现了 一个或者 多个 接口后， 这个类 必须完全实现 这些接口里 所定义的 
全部抽象方法（也就是重写这些 抽象方法） 
否则， 该类将保留从父接口那里继承得到的抽象方法，该类也必须定义成 抽象类 

接口  相当于 一个 彻底的 抽象类 

interface Product 
{
	int getProduceTime(); // public abstract 
}

interface Output
{
	int max=50; // public static  final 
	void out();
	void getData(String msg);
}

public class Printer implements Output, Product
{
	private String[] printData=new String[max];
	
	private int dataNum=0;
	
	public void out()
	{
		while(dataNum>0)
		{
			System.out.println("Print: "+printData[0]);
			
			System.arraycopy(printData,1,printData,0,--dataNum);
		}
	}
	
	public void getData(String msg)
	{
		if(dataNum >= max)
		{
			System.out.println("full & error ");
		}
		else 
		{
			printData[dataNum++]=msg;
		}
	}
	
	public int getProduceTime()
	{
		return 45;
	}
	
	public static void main(String[] args)
	{
		Output o=new Printer();
		o.getData("Java EE");
		o.getData("Crazy Java");
		o.out();
		o.getData("Crazy Android Note");
		o.getData("Crazy Ajax Note");
		o.out();
		
		Product p= new Printer();
		System.out.println(p.getProduceTime());
		
		Object obj=p;
		// 所有接口类型的引用变量都可以直接赋给 Object 类型的变量
	}
}

OUT：
Print: Java EE
Print: Crazy Java
Print: Crazy Android Note
Print: Crazy Ajax Note
45

实现接口方法的时候， 必须使用 public 访问控制修饰符 ，
因为接口里的方法都是 public 的， 而子类（相当于实现类）重写父类方法的时候
访问权限只能更大或者相等，所以 实现类实现接口里的方法只能使用 public 来修饰


接口类型的 引用变量都可以直接 赋给 Object 类型的 引用变量
这是利用向上转型来实现的 
Java 对象 都必须是 Object 或其子类的实例 




Page 209 
6，6。5  接口和抽象类：

接口和 抽象类：
（1） 抽象和接口都不能实例化，都位于继承树的顶端，用于被其他类实现和继承
（2） 接口和抽象类都可以包含抽象方法， 实现接口 或者 抽象类的普通子类都必须实现这些抽象方法 

差别：
接口体现的是一种规范 
（1） 接口里只能 包含抽象方法，不能包含 已经提供实现的方法，抽象类里可以包含普通方法
（2） 接口里不能定义静态方法 ， 抽象类里可以定义抽象方法
（3） 接口里只能定义 static final 静态常量 Field， 不能包含普通 Field，
	抽象类里 既可以 定义普通 field， 也可以定义静态常量 Field 
（4） 接口里不能有 构造器，抽象类里可有构造器，
	抽象类里的构造器不是用于创建对象的， 而是 让其子类调用这些构造器来完成抽象类的初始化操作
（5） 接口里不能有 初始化块， 抽象类里 可以有 
（6） 一个类 最多只能有一个抽象的直接父类， 但是一个类 可以直接实现多个接口，
	通过实现多个接口可以弥补 Java 单继承的不足 
	
	
	
Page 210  -213
6.6.6 面向接口编程

不想看  




Page 214 
6.7 内部类 

内部类作用：
（1） 内部类提供更好的封装， 可以把内部类隐藏在外部类之内，
	不允许同一包中的其他类访问 该类 
（2） 内部类成员可以直接访问 外部类的私有数据，
	但是 外部类不能访问内部类的实现细节，如内部类的成员变量
（3） 匿名内部类适合用于创建那些仅仅需要一次使用的类 


6.7.1 非静态内部类：
内部类 可以在类中的任何位置， 甚至在方法中 也可以定义内部类

大部分时候， 内部类被当作 成员来定义，而非 局部变量，

成员内部类是一种 与 field 方法 构造器 初始化块 相似的类成员，
局部内部类和匿名内部类 不是 类 成员

成员内部类 分为2 种： 
静态内部类 （ static 修饰 ）和  非静态内部类 （没有 static 修饰）

class A{}
public class B{}
不是 内部类 ， 是两个相互独立的类 

因为 内部类 作为 其 外部类的 成员， 
所以可以使用 任意访问控制符 如 private protected public 等修饰

如下所示：
 在 Cow 类里 定义一个 CowLeg 非静态内部类， 并在 CowLeg 类的
实例方法中 直接访问 Cow 的 private 访问权限的实例 field 

public class Cow
{
	private double weight;
	
	public Cow(){}
	
	public Cow(double weight)
	{
		this.weight=weight;
	}
	
	private class CowLeg
	{
		private double length;
		private String color;
		
		public CowLeg(){}
		
		public CowLeg(double length, String color)
		{
			this.length=length;
			this.color=color;
		}
		
		public void setLength(double lenght)
		{
			this.length=length;
		}
		
		public double getLength()
		{
			return this.length;
		}
		
		public void setColor(String color)
		{
			this.color=color;
		}
		
		public String getColor()
		{
			return this.color;
		}
		
		public void info()
		{
			System.out.println("color is: "+color+" length is: "+length);
			System.out.println("the weight: "+weight);
			// 直接访问 外部类的 private 修饰的 field 
		}
	}
	
	public void test()
	{
		CowLeg c1=new CowLeg(1.12, "black-white");
		c1.info();
	}
	
	public static void main(String[] args)
	{
		Cow c= new Cow(2333);
		c.test();
	}
}

OUT:
color is: black-white length is: 1.12
the weight: 2333.0

在非静态内部类中 可以直接访问外部类的 private 成员，

在非静态内部类对象里，保存了 一个 它寄存的外部类对象的引用，
（当引用非静态内部类的实例方法时，必须有一个非静态内部类实例，
而非静态内部类实例 必须 及存在外部类实例里 ）

当 在 非静态内部类的方法内 访问某个变量的时候， 系统优先在该方法中查找 是否存在
改名字的 局部变量，如果存在就使用该变量，如果不存在，
则到该方法所在的内部类中 查找 是否存在该名字的成员变量
如果存在则使用该成员变量， 如果不存在
则到该内部类所在的外部类中 查找 
如果存在则使用， 如果不存在 则发生编译错误 找不到该变量 


如果 外部类成员变量 内部类成员变量 内部类里方法 的 局部变量同名，
则 可以通过 this  外部类类名.this 来区分 

public class DiscernVariable
{
	private String prop="外部类的实例变量";
	
	private class InClass
	{
		private String prop="内部类的实例变量";
		
		public void info()
		{
			String prop="局部变量";
			
			System.out.println("OUT: "+DiscernVariable.this.prop);
			
			System.out.println("INNER: "+this.prop);
			
			System.out.println("LOCAL: "+prop);
		}
	}
	
	public void test()
	{
		InClass in= new InClass();
		in.info();
	}
	
	public static void main(String[] args)
	{
		new DiscernVariable().test();
	}
}

OUT:
	OUT: 外部类的实例变量
INNER: 内部类的实例变量
LOCAL: 局部变量


非静态 内部类 的成员可以访问外部类的 private 成员，

非静态内部的成员只在非静态内部类 的范围内， 并不能被外部类直接使用 

如果外部类需要 访问 非静态内部类的 成员， 
则必须显式创建 非静态内部类 对象来 调用访问 其 实例成员 

public class Outer
{
	private int outProp=9;
	
	class Inner
	{
		private int inProp=5;
		
		public void acessOuterProp()
		{
			System.out.println("Outer value:"+outProp);
		}
	}
	
	
	public void accessInnerProp()
	{
		// 要访问内部类的实例 field， 则要显式创建内部类对象 
		System.out.println("Inner value: "+new Inner().inProp);
	}
	
	public static void main(String[] args)
	{
		Outer out =new Outer();
		out.accessInnerProp();
	}
}

OUT:
Inner value: 5
			

静态成员 不能访问 非静态成员  
外部类的静态方法 静态代码块 不能访问 非静态内部类，
包括 不能 使用 非静态内部类定义变量 创建实例等 

总之， 不允许外部类的静态成员 中 直接 使用 非静态内部类 

public class StaticTest
{
	private class In{}
	
	public static void main(String[] args)
	{
		// 静态 main() 不能 访问 非静态成员 In();
		new In();
	}
}


Java  不允许 在非静态内部类里定义静态成员 

public  class InnerNoStatic
{
	private class InnerClass
	{
		static 
		{
			System.out.println("***********");
		}
		
		private static int inProp;
		private static void test(){}
	}
}

非静态内部类里 不能有 静态方法， 静态 field 静态初始化块 




Page 218 
6.7.2 静态内部类 
用 static 修饰一个内部类，这个内部类就属于 外部类的本身，
不属于外部类的某个对象，  就是静态内部类 

static 修饰的成员属于整个类，不属于单个对象 

静态内部类可以包含静态成员，也可以包含非静态成员，
静态内部类不能访问外部类的 实例成员，只能访问外部类的类成员，
即使是  静态内部类 的实例方法也不能 访问外部类的实例成员 只能访问外部类的 静态成员


public class StaticInnerClassTest
{
	private int prop1=5;
	private static int prop2=9;
	static class StaticInnerClass
	{
		private static int age;
		
		public void accessOuterProp()
		{
			System.out.println(prop1);
			// error: 静态内部类 无法访问外部类的实例成员 
			
			System.out.println(prop2);
		}
	}
}


静态内部类 是外部类的 一个静态成员， 因此外部类的静态方法， 静态初始化块 
可以使用 静态内部类来定义变量 创建对象 等 

public class AccessStaticInnerClass
{
	static class StaticIneerClass
	{
		private static int prop1=5;
		private int prop2=9;
	}
	
	public void acessInnerProp()
	{
		System.out.println(StaticIneerClass.prop1);
		
		System.out.println(new StaticIneerClass().prop2);
	}
}

接口里定义的内部类默认使用 public static 修饰
接口内部类 只能是 静态内部类 
如果定义接口内部类时 省略访问控制符， 则该内部类默认是 public 访问控制符 



Page 220 

Page 6.7.3 使用内部类
定义类的作用 就是定义变量 创建实例 和  作为父类被继承
（1） 在外部类 内部 使用 内部类
    一样可以 直接通过 内部类 类名来定义变量，通过 new 调用 内部类构造器创建实例。
	
	唯一的区别：
	不要在外部类的静态成员（包括 静态方法 和 静态初始化块）中使用非静态内部类
	因为 静态成员 不能访问非静态成员
	
（2） 在外部类以外使用非静态内部类 


class Out
{
	class In
	{
		public In(String msg)
		{
			System.out.println(msg);
		}
	}
}

public class CreateInnerInstance 
{
	public static void main(String[] args)
	{
		Out.In in = new Out().new In("Test info");
		
		/*
			上面的代码可以改为：
			Out.In in;
			Out out = new Out();
			in= out.new In("Test info");
		*/
	}
}























	
	
	
	
	
	
	
	
