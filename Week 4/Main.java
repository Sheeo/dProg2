public class Main
{
	public static void main(String[] args)
	{
		if(args[0].equals("cli"))
			return CLIMain.main(args);
		else
			return GUIMain.main();
	}
}
