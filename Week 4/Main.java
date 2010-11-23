public class Main
{
	public static void main(String[] args)
	{
		if(args[0].equals("cli"))
			CLIMain.main(args);
		else
			GUIMain.main(args);
	}
}
