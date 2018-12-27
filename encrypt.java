import java.util.*;
import java.io.*;
class encrypt
{
	public static void main(String ar[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
			System.out.println("Enter a username");
			String uname=sc.next();
			System.out.println("Enter a password");
			String password=sc.next();
			System.out.println("Enter the full path of text file to be encrypted");
			String fpath=sc.next();
			FileReader file1=new FileReader(fpath);
			String w="";
			int i,j=0,k=0,s=0;
			while((i=file1.read())!=-1)
			{
      				w=w+(char)i;
			}
			String make="";
			int l=w.length();
			for(i=0;i<l;i++)
			{
				if(i<uname.length() && i<password.length())
				{
					s=(int)(uname.charAt(i))+(int)(password.charAt(i))+(int)(w.charAt(i));
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
						s=s+(int)uname.charAt(j);
						j=j+1;
					}
					if(i>=password.length())
					{
						s=s+(int)password.charAt(k);
						k=k+1;
					}
				}
				char b=(char)s;
				make=make+b;
				s=0;
			}
			make=(uname.concat(" ")).concat(make);
			fpath=fpath.substring(0,fpath.indexOf("."));
			String encrypted_file=fpath.concat("(CryptIt)");
			encrypted_file=encrypted_file.concat(".txt");
			File file = new	 File(encrypted_file);
			System.out.println("The encrypted file is "+encrypted_file);
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(make);
			bw.close();
	}
}
