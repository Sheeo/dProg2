import java.awt.*;
import javax.swing.*;


public class GUIMain
{
	private BinomialFrame binomial;

	public static void main(String[] args)
	{
		GUIMain prog = new GUIMain();
		prog.execute();
	}

	public GUIMain()
	{
		binomial = new BinomialFrame();
	}

	public void execute() {
		binomial.pack();
		binomial.setVisible(true);
		binomial.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
