3 Chapter 数据类型和运算符：

Page 53 

3.1 注释
	单行注释 //
	多行注释 /*  
				*/
	文档注释 /** 
			*/
		中间内容会被提取到 API文档中
	
应用程序接口： API 




3.2 标识符和关键字
	3.2.1 分隔符：
	; {} [] ()  .

	
Page 62 
3.3 数据类型分类
java 所有的变量必须显示声明类型
JAva 支持的类型分为2类： Primitive type 基本类型& Reference Type  引用类型

基本类型：Boolean　＋　数值类型：
引用类型：　类，　接口，　数组类型 // important 
// repeat again： 引用类型： 类， 接口， 数组类型 （+ 字符串？？？)
引用类型就是一个指针， 
　　　

3.4 基本数据类型
3.4.3 字符型：

其实 char 也是整行变量

public class CharTest{
	public static void main(String[] args){
		char zhong='疯';
		int  zhongValue=zhong;
		System.out.println(zhongValue);
		char c=97;
		System.out.println(c); //a
	}
}
OUTPUT:
30127
a

public class CharTest 
{
	public static void main(String[] args)
	{
		char aChar='a';
		char enterChar='\r';
		
		char ch='\u9999';
		System.out.println(ch);
		
		char zhong='疯';
		
		int zhongValue=zhong;
		System.out.println(zhongValue);
		char c=97;
		System.out.println(c);
	}
}

OUTPUT:
香
30127
a





3.4.4 浮点型： 
浮点数有两种表示形式：
1）。 十进制 一定要有小数点
2）。 科学记数法 5.12e2 5.12E2
Java默认是 double 类型， 如当作float类型， 应该在数值后面 + F 或者f

3种特殊的浮点数值： 正无穷大， 负无穷大， 非数
正无穷大： Double or  Float 的 POSITIVE_INFINITY 
负无穷大： Double or Float 的 NEGATIVE_INFINITY 
非数： Double Float 的 NaN表示 // 看来只有 Double 和 float 有 NaN 非数类型

public class FloatTest{
	public static void main(String[] args){
		float af=5.2345556f; //5.2345557
		System.out.println(af);
		
		double c= Double.NEGATIVE_INFINITY;
		float d= Float.NEGATIVE_INFINITY;
		System.out.println(c==d); //true double float 
		
		double a=0.0;
		System.out.println(a/a==Float.NaN);  //false 
		
		System.out.println(6.0/0==555.0/0); //true 
		
		System.out.println(-8/a); //-Infinity
		
		System.out.println(0/0); //java.lang.ArithmeticException: / by zero
	// 只有浮点数 除以0 才能得到无穷大，不管是除数还是被除数， 必须有一个是浮点数类型的 才能得到正负无穷
	//如果一个整数除以0 ， 得到一个异常
	}
}

OUTPUT:
5.2345557
true
false
true
-Infinity
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at FloatTest.main(FloatTest.java:17)
		
	
public class FloatTest
{
	public static void main(String[] args)
	{
		float af=5.2345556f;
		System.out.println(af);
		double a=0.0;
		double d=Float.NEGATIVE_INFINITY;
		System.out.println(c==d);
		System.out.println(a/a);
		
		

3.4.6 布尔型
其他基本数据类型的值 必能转换成 boolean 类型
在Java中， Boolean 类型的数值 只能是 true 和 false ， 不能用 0 和 非 0 来代替
洽谈类型的数据；类型也不能转换成 Boolean 类型 

String str=true+"";  // 这样是可行的
System.out.println(str);
OUTPUT: 
true

//使用 boolean 类型的值 和 字符串进行连接运算， Boolean 类型的值 会自动转换成字符串
String str=true+"";
System.out.println(str);

OUTPUT: true 


Page 68 
3.5 基本类型的类型转换
自动类型转化+强制类型转换

3.5.1 自动类型转换：


基本数据类型：
整数类型：
	byte   1 字节
	short  2
	int    4
	long   8
	
字符类型：
	char   2
	
浮点类型：
	float  4 
	double 8
	
布尔类型：
	boolean 1位


public class AutoConversion
{
	public static void main(String[] args)
	{
		int a=6;
		float f=a;
		System.out.println(f);
		
		byte b=9;
		char c=b; // error : 不能把 byte 类型自动转成 char 类型
		
		double d=b;
		System.out.println(d);
	}
}

OUT:
6.0
9.0


Page  69 

public class Display {
	private int value =0;
	private int limit=0;
	private static int step=1;
	
	public Display(int limit){
		this.limit=limit;
	}
	
	public void increase(){
		value++;
		if(value==limit){
			value=0;
		}
	}
	
	
把任何基本类型的值 和 字符串进行连接运算的时候， 基本类型的值
将自动类型转换成字符串类型

虽然字符串类型不是基本类型 是引用类型

如果希望把基本类型的值转换成为对应的字符串的时候， 
可以把基本类型的值和一个空字符串进行连接

public class PrimitiveAndString
{
	public static void main(String[] args)
	{
		String str1=5; // error : integer 不能直接赋值给一个字符串
		
		String str2=3.5+"";
		
		System.out.println(str2);
		
		System.out.println(3+4+"Hello!");
		
		System.out.println("Hello!"+3+4);
	}
}

OUT：
3.5
7Hello!
Hello!34


public class PrimitiveAndString
{
	public static void main(String[] args)
	{
		String str1=5; //error: 不能把一个数值直接赋给一个字符串
		String str2=3.5f+"";
		System.out.println(str2);
		
		System.out.println(3+4+"hello!");
		System.out.println("hello!"+3+4);
	}
}
OUT:
3.5
7hello!
hello!34


Page 69 
3.5.2 强制类型转换

public class NarrowConversion
{
	public static void main(String[] args)
	{
		int iValue=233;
		byte bValue=(byte)iValue;
		System.out.println(bValue);
		
		double dValue=3.98;
		int tol=(int)dValue;
		System.out.println(tol);
	}
}
OUT:
-23
3

public class RandonStr
{
	public static void main(String[] args)
	{
		String result="";
		
		for(int i=0;i<6;i++)
		{
			int intVal=(int)(Math.random()*26+97);
			result=result+(char)intVal;
		}
		System.out.println(result);
	}
}
OUT:
rnluxs


注意：
float a=5.6; // 会出错， 因为 5.6 默认是 double 类型，必须要强制
// 改为：
float a=(float)5.6;

注意： // important：
把字符串改为 int 类型：
String a="45";
int iValue=Integer.parseInt(a);
第六章 有包的类型详解

把字符串换成 int 类型：
String a="45";
int iValue=Integer.parseInt(a);

把字符串 改成 整数类型：
String a="45";
int iValue=Integer.parseInt(a);
System.out.println(iValue);



Page 71 
3.5.3 表达式类型的自动提升

public class A{
	public static void main(String[] args)
	{
		byte b=40;
		char c='a';
		int i=23;
		double d=0.314;
		double result=b+c+i*d;
		
		System.out.println(result);
	}
}
OUT:
144.222


public class A{
	
	public static void main(String[] args)
	{
		int val=3;
		int intResult=23/val;
		System.out.println(intResult);
	}
}

OUT:
7 

如果表达式包含了字符串：

public class A{
	public static void main(String[] args)
	{
		System.out.println("Hello!"+'a'+7);
		
		System.out.println('a'+7+"Hello!");
	}
}

OUT:
Hello!a7
104Hello!


Page 72

3.6 直接量：
基本类型 字符类型 null类型
String s0="hello";
String s1="hello";
String s2="he"+"llo";
System.out.println(s0==s1);
System.out.println(s0==s2);
System.out.println(s1==s2);

OUTPUT:
true
true
true
// 重点： java 会确保每个字符串常量只有一个 


Page 73

3.7 运算符

3.7.1 算数运算符

如果除法运算符的两个操作数都是整数类型， 则计算结果也是整数

如果除法运算符的两个操作数有一个是浮点数， 或者2个都是浮点数，
则计算结果也是浮点数， 这个结果就是自然出发的结果，
此时允许除数是0， 或者 0.0， 得到的结果是 正无穷大 或者是 负无穷大，

public class DivTest
{
	public static void main(String[] args)
	{
		double a=5.2;
		double b=3.1;
		double div=a/b;
		


如果除法运算符的两个操作数有一个是浮点数， 或者两个都是浮点数， 则计算的寄过也是浮点数，
此时允许除数是0， 或者0.0 得到无穷大
如：
System.out.println(-5/0)； // 抛出异常


% 求余运算符 
public class ModTest{
	public static void main(String[] args){
		double a=5.2;
		double b=3.1;
		double mod=a%b;
		System.out.println(mod); //2.1
		
		System.out.println(5%0.0); //NaN
		System.out.println(-5.0%0); //NaN
		
		System.out.println(0%5.0); //0.0
		System.out.println(0%0.0); //NaN
		
		System.out.println(5%0); // 异常
	}
}
OUT:

2.1
NaN
NaN
0.0
NaN
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at FloatTest.main(FloatTest.java:14)
		

Page 75 
开方， 乘方 运算： 借助于 java.lang.Math; 类的工具：
import java.lang.Math;
Math.abs(data); 绝对值
math.round(data) : 四舍五入


public class MathTest{
	public static void main(String[] args){
		
		double a=3.2;
		double b=Math.pow(a,5);
		System.out.println(b);
		
		double c=Math.sqrt(a);
		System.out.println(c);
		
		double d=Math.random();
		System.out.println(d);
		
		double e=Math.sin(1.57);
		System.out.println(e);
	}
}
OUTPUT:
335.5443200000001
1.7888543819998317
0.6618401323644173
0.9999996829318346
		

Page 82 
3.7.7 三目运算符：










