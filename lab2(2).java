package lab;
import java.util.*;
import java.io.*;
public class lab7{
	public static void main(String []args) {
		String Path = new String();
		Scanner sc=new Scanner(System.in);
		Path = sc.next();
		File file=new File(Path);
		int level;
		level=sc.nextInt();
		String s[]= {"char","double","enum","float","int","long","short","signed",
				     "struct","union","unsigned","void","for","do","while","break",
				     "continue","if","else","goto","switch","case","default","return",
				     "auto","extern","register","static","const","sizeof","typedef","volatile"};
		int num[]= new int[32];
		int totalNum = 0;
		int switchNum=0;
		int num2=0;
		int n2[]=new int[num2];
		if(file.exists()) {
		    try {
				Scanner scan=new Scanner(file);
				while(scan.hasNext()) {
					CheckAndCount1(s,num,scan.next());
				}
				for(int i=0;i<32;i++) {
					totalNum=totalNum+num[i];
				}
				System.out.println("total num:"+totalNum);//基本要求
				scan=new Scanner(file);
				while(scan.hasNext()) {
					
					for(int i=0;i<32;i++) {
						if(s[i]=="switch") {
							num2=num[i];
						}
					}
					
					CheckAndCount2(s,n2,scan.next(),switchNum);
				}
				System.out.println("switch num: "+switchNum);//高级要求：switch number
				System.out.print("case num: ");
				for(int i=0;i<num2;i++) {
					System.out.print(n2[i]+" ");
				}
				System.out.println();//高级要求：case number
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void CheckAndCount1(String s[],int num[],String str) {
		for(int i=0;i<32;i++) {
			if(str==s[i]) {
				num[i]++;
			}
		}
	}
	public static void CheckAndCount2(String s[],int num[],String str,int switchNum) {
		
		for(int i=0;i<32;i++) {
			if(str=="switch") {
				switchNum++;
			}
			if(str=="case") {
				num[switchNum-1]++;
			}
		}
		
	}
}