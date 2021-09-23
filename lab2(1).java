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
		if(file.exists()) {
		    try {
				Scanner scan=new Scanner(file);
				while(scan.hasNext()) {
					CheckAndCount(s,num,scan.next());
				}
				for(int i=0;i<32;i++) {
					totalNum=totalNum+num[i];
				}
				System.out.print("total num:"+totalNum);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void CheckAndCount(String s[],int num[],String str) {
		for(int i=0;i<32;i++) {
			if(str==s[i]) {
				num[i]++;
			}
		}
	}
}