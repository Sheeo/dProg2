import java.io.*;
import java.util.*;


public class CeasarCrypt
{
	
	InputStream input;
	OutputStream output;
	
	public static void main(String[] args)
	{
		try
		{
			CeasarCrypt c = new CeasarCrypt(new FileInputStream(args[0]), FileOutputStream(args[1]));
			c.Encrypt(13);
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong, but I'm not going to bother telling you what.");
		}
	}

	public CeasarCrypt(InputStreamReader input, OutputStreamWriter output)
	{
		this.input = input;
		this.output = output;
	}

	public void Encrypt(int cipher)
	{
		char[] characterBuffer = new char[1024];
		int n = 0;
		while(true)
		{
			int read = input.read(characterBuffer);
			if(read == -1) break;
			n += read;
			output.write(characterBuffer, 0, read);
		}	
	}
}
