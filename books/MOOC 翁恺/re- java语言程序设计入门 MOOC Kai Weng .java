Java 语言程序设计入门
// https://www.youtube.com/watch?v=e7mySU2hsIo&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX&index=3

3/50 

菜单栏： 
file -- New  Java Project 
hello/src 右键菜单  new -- class 
类的名字 第一个字母是大写 

package hello;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println("中文");
	}

}


// 4- 50 
//https://www.youtube.com/watch?v=y3_FHu77fzA&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX&index=4

Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());


Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());


Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());

Scanner in = new Scanner(System.in);
System.out.println("echo"+in.nextLine());




package hello;

import java.util.Scanner;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World!");
		System.out.println("中文");
		
//		Scanner in = new Scanner(System.in);
//		System.out.println(in.nextLine());
//		
//		Scanner in1= new Scanner(System.in);
//		System.out.println("echo:"+in1.nextLine());
//		
		System.out.println(2+3+"=2+3="+(2+3));
	}

}


OUT:
Hello World!
中文
5=2+3=5


// 5/50 
// https://www.youtube.com/watch?v=2v0wmh2-0xU&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX&index=5

变量 variate 

Scanner in = new Scanner(System.in);
System.out.println(in.nextLine());

update:
Scanner in = new Scanner(System.in);
System.out.println("100-23="+(100-in.nextLine()));

update:
System.out.println("100-"+in.nextLine()+"="+(100-in.nextLine()));


Scanner in = new Scanner(System.in);
System.out.println("100-"+in.nextInt()+"="+(100-in.nextInt()));


public class Hello {
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("100-"+in.nextInt()+"="+(100-in.nextInt()));
	}
}

OUT:
Hello
23
23
100-23=77

Scanner in = new Scanner(System.in);
int price =in.nextInt();
System.out.println("100-"+price+"="+(100-price));

OUT:
23
100-23=77


// 6/50 
// https://www.youtube.com/watch?v=4LUWHWzcuik&index=6&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX
赋值


System.out.println("Hello");

Scanner in = new Scanner(System.in);
int price=in.nextInt();
System.out.println("100-"+price+"="+(100-price));


System.out.println("Hello");
Scanner in =new Scanner(System.in);
final int amount=100;
int price=in.nextInt();
System.out.println(amount+"-"+price+"="+(amount-price));


import java.util.Scanner;

public class Hello{
	public static void main(String[] args)
	{
		System.out.println("Hello");
		Scanner in = new Scanner(System.in);
		int amount=in.nextInt();
		int price= in.nextInt();
		System.out.println(amount+"-"+price+"="+(amount-price));
	}
}



// 7/50 
// 浮点数
// https://www.youtube.com/watch?v=4F21i7KatF0&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX&index=7


import class Hello{
	
	public static void main(String[] args)
	{
		int foot;
		int inch;
		
		Scanner in= new Scanner(System.in);
		foot=in.nextInt();
		inch=in.nextInt();
		System.out.println((foot+inch/12)*0.3048);
	}
}

OUT:
5
7
1.524


update:


import class Hello{
	
	public static void main(String[] args)
	{
		int foot;
		int inch;
		
		Scanner in= new Scanner(System.in);
		foot=in.nextInt();
		inch=in.nextInt();
		System.out.println((foot+inch/12.0)*0.3048); // 这里发生变化
		// 把 原来的 12 改为 12.0
	}
}


Update：

int foot;
double inch;
Scanner in = new Scanner(System.in);
foot=in.nextInt();
inch=in.nextInt();
// inch =in.nextDouble();

System.out.println(10/3);
System.out.println("foot="+foot+", inch="+inch);
System.out.println((foot+inch/12)*0.3048);

OUT：
5
7
3
foot=5, inch=7.0
1.7018


System.out.println(1.2-1.1);

OUT:
0.09999999999999987


// 8/50 
// 优先级
// https://www.youtube.com/watch?v=_BxbasKfHys&index=8&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX


// 9/50 
// 类型转换
// https://www.youtube.com/watch?v=nwc1jtQSv-o&index=9&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX

int foot ;

foot=30/3.0; // Type mismatch: cannot convert from double to int

foot=(int)(30/3.0);



// 11/50 
// 比较
//https://www.youtube.com/watch?v=lEC9QHBNbJU&list=PLC664nq_h8b-ubcLyrvICJ2VI8uFEunVX&index=11









































