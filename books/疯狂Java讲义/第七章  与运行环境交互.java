第七章  与运行环境交互

Page 250 
7.1 与用户互动

Page 251 
7.1.2 使用 Scanner  获得键盘输入

public class ScannerKeyBoardTest
{
	public static void main(String[] args)
	{
		Scanner sc= new Scanner(System.in);
			
		while(sc.hasNext())
		{
			System.out.println("input: "+sc.next());
		}
	}
}


Page  253

7.1.3 使用 BufferedReader 获得键盘输入

public class KeyboardInTest
{
	

