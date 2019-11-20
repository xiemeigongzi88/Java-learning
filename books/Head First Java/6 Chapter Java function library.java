6 Chapter Java function library

Page 131 
如果能找到一种数组会在删除掉某些元素的时候自动缩小就好了，
这样就不用检查所有的元素了

Page 132 

ArrayList Java函数库里的另一个类 

ArrayList

add(Object elem)
向 list 中加入对象参数 
	
remove(int index)
在索引参数中移除对象

remove(Object elem)
移除该对象

contains(Object elem)
如果和对象参数匹配 返回“true”

isEmpty()
如果 list 中没有元素返回“true”

indexOf(Object elem)
返回对象参数的索引 or -1 

size()
返回list中元素的一个数

get(int index)
返回当前索引参数的对象


Page 133

ArrayList 的操作：
1. 创建：
ArrayList<Egg> myList= new ArrayList<Egg>();

2. 加入元素：
Egg s = new Egg();

myList.add(s);

3.再加入元素：
Egg b= new Egg();

myList(b);

4. 查询大小
int size= myList.size();  //2 

5. 查询特定元素：  // Boolean -> contains 
boolean isIn= myList.contains(s); //true

6. 查询特定元素的位置：
int idx=myList.indexOf(b); // 1

7. 判断集合是否为空
boolean empty= myList.isEmpty();//false 

8. 删除元素：
myList.remove(s);


Page 134:

//ArrayList 数组：

ArrayList<String> myList= new ArrayList<String>();

String a= new String("whoohoo");
myList.add(a);

String b= new String("Frog");
myList.add(b);

int theSize=myList.size();

Object o=myList.get(1); // get(int index) 返回的是对象
/*
	get(int index)
返回当前索引参数的对象
*/

myList.remove(1);
// remove(int index)

boolean isIn= myList.contains(b);


一般数组：
String[] myList= new String[2];
String a= new String("whoohoo");
String b= new String("Frog");


Page 135 
没有兴趣看


Page 136
ArrayList 与数组的比较

ArrayList <String> myList = new ArrayList<String>();

String a= new String("whoohoo");
myList.add(a);

String b= new String("Frog");
myList.add(b);

int theSize=myList.size();

Object o=myList.get(1); // get(int index) 返回的是： 对象

//一般数组：
String [] myList= new String[2];

String a= new String("whoohoo");
myList[0]=a;

String b= new String("Frog");
myList[1]=b;

int theSize=myList.length;

String o= myList[1];
myList[1]=null;

boolean isIn=false;

for(String item: myList)
{
	if(b.equals(item))
	{
		isIn=true;
		
		break;
	}
}

完整代码：
public class A{ 
    
    public static void main(String[] args){
    String []myList= new String[2];
    String a= new String("whoohoo");
     myList [0]= a;

	String b= new String("Frog");
	myList[1]=b;

	int theSize=myList.length;

	String o= myList[1];
	myList[1]=null;

	boolean isIn=false;

	for(String item: myList)
{
	if(b.equals(item))
	{
		isIn=true;
		
		break;
	}
}
    System.out.println(isIn);
}
}

OUTPUT： false

目前我看到的， 数组有 
String [] a = new String[5];
int size= a.length;

Page 137
比较 Array List 与一般数组：
1. 一般数组在创建时候就必须确定大小：

2. 存放对象给一般数组时 必须制定位置：
myList[1]=b;

ArrayList, 用 .add(Int, Object) 指定索引值
or add(Object)自行管理大小
myList.add(b);// 不需要索引值

ArrayList<String>
<String> 是类型参数


NOte:
public class A{
    public static void main(String[] args)
    {
        String a=new String("Hello");
        String b=" World!";
        System.out.print(a);
        System.out.println(b);
    }
}

a b 这两种方式都可以

 
Page 138：
如何修改DotCom 代码：
// 有问题的代码
public class DotCom{
	int[] locationCells;
	int numOfHits=0;
	
	public void setLocationCells(int[] locs){
		locationCells=locs;
	}
	
	public String checkYourself(String stringGuess){
		int guess= Integer.parseInt(stringGuess);
		/*
			parseInt(String s): 返回用十进制参数表示的整数值。
		*/
		String result="miss";
		
		for(int cell: locationCells){
			if(guess==cell){
				result="hit";
				numOfHits++;
				
				break;
			}
		}
		
		if(numOfHits==locationCells.length){
			result="kill";
		}
		
		System.out.println(result);
			return result;
	}
}

//修改完以后的 Dot Com 

import java.util.ArrayList;

public class DotCom{
	
	private ArrayList<String> locationCells;
	
	public void setLocationCells(ArrayList<String> loc){
		locationCells=loc;
	}
	
	public String checkYourself(String userInput){
		String result="miss";
		
		int index=locationCells.indexOf(userInput);
		
		if(index>=0){
			locationCells.remove(index);
			
			if(locationCells.isEmpty()){
				resutl="kill";
			}
			else{
				result="hit";
			}
		}
		
		return result;
	}
}

Page 151
// 以前的不想看
&& || ！=
	
(1)对于字符串变量来说,equal比较的两边对象的内容，所以内容相同返回的是true。

if(!brand.equals("X"));
// Note: equals 返回的是 ： true or  false 
 
用下面方式来避免调用内容为null 的指针变量：

if(refVar !=null && refVar.isValidType())
{
	// 执行有效变量的工作；
}


Page  154
使用函数库 （Java API） 
类class在包里package

要使用函数库里的类， 就要知道类在哪个包里
















