import java.util.*;
import java.io.*;
class decrypt
{
	public static void main(String ar[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
    System.out.println("Enter a username");
    String uname=sc.next();
    System.out.println("Enter a password");
    String password=sc.next();
    System.out.println("Enter the full path of text file to be decrypted");
    String fpath=sc.next();
    FileReader file1=new FileReader(fpath);
		String w="",make="";
		int i,j=0,k=0,s=0;
		while((i=file1.read())!=-1)
		{
			w=w+(char)i;
		}
		w=w.substring(w.indexOf(' ')+1,w.length());
		for(i=0;i<w.length();i++)
		{
			if(i<uname.length() && i<password.length())
			{
				s=(int)(w.charAt(i))-(int)(uname.charAt(i))-(int)(password.charAt(i));
			}
			else
			{
				s=(int)(w.charAt(i));
				if(j>=uname.length())
				{
					j=0;
				}
				if(k>=password.length())
				{
					k=0;
				}
				if(i>=uname.length())
				{
					s=s-(int)uname.charAt(j);
					j=j+1;
				}
				if(i>=password.length())
				{
					s=s-(int)password.charAt(k);
					k=k+1;
				}
			}
			char b=(char)s;
			make=make+b;
			s=0;
		}
		System.out.println(make);
	}
}
