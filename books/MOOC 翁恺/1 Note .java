Java 程序设计
北京大学 


// 1.2 面相对象 程序设计：
// https://www.coursera.org/learn/java-chengxu-sheji/lecture/cHkrB/1-2-1-mian-xiang-dui-xiang-cheng-xu-she-ji

类：
	具有共同属性的行为的对象集合 
  属性：  变量（field）
  行为：  函数（方法 method ）
  
  class Person {
	  int age;
	  String name;
	  void sayHello(){...}
  }
  
  
类与对象的关系：
	类是对象的抽象（模板）
	对象是类的 实例 
	
	Person p=new Person();
	
	
面向对象 的 三大特征：
（1）.封装性
（2）.继承性
（3）.多态性



（1）. 封装性：
模快化： 
	将 属性和 行为都封装在类里面， 程序定义很多的类

信息隐蔽：
	将类的细节部分隐藏起来
	用户只能通过受保护的接口访问某个类
	
class Person{
	private int age;
	
	public int getAge() 
	{
		return age;
	}
	
	public void setAge(int a)
	{
		age = a;
	}
	
	String name;
	
	void sayHello(){
		...
	}
}

(2). 继承性：
   父类和子类之间共享数据和方法  
   
   class Person{
	   int age;
	   String name;
	   void sayHello(){...}
   }
   
   class Student extends Person {
	   String school;
	   double score;
	   void meetTeacher(){
		   ...
	   }
   }
  
	继承的好处：
	1. 更好的进行抽象与分类
	2. 增强代码的重用率
	3. 提高可维护性
	
	
(3). 多态：
不同的对象收到同一个消息（调用方法）可以产生完全
不同的效果

实现的细节则由接受对象自行决定 

foo(Person P )
{
	p.sayHello();
}

foo(new Student());

foo(new Teacher());





   
	
	
	
	
	
	
	
	
	
	
	