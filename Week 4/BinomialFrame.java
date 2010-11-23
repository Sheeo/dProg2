import java.awt.*;
import javax.swing.*;
public class BinomialFrame extends JFrame
{
	private JPanel outerPanel;
	private JPanel textFieldPanel;

	public BinomialFrame()
	{
		super();
		createOuter();
	}

	private void createOuter()
	{
		createTextFields();
		/*
		createRadioButtons();
		createSubmitButton();
		createResultLabel();
		*/
		outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
		outerPanel.add(textFieldPanel);
	}

	private void createTextFields()
	{
		textFieldPanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();

		textFieldPanel.setLayout(gridbag);

		c.gridx = c.gridy = 0;
		JLabel label1 = new JLabel("n");
		gridbag.setConstraints(label1, c);
		textFieldPanel.add(label1);
		++c.gridy;
		JLabel label2 = new JLabel("k");
		gridbag.setConstraints(label2, c);
		textFieldPanel.add(label2);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1.0;
		JTextField text1 = new JTextField();
		gridbag.setConstraints(text1, c);
		textFieldPanel.add(text1);
		++c.gridy;
		JTextField text2 = new JTextField();
		gridbag.setConstraints(text2, c);
		textFieldPanel.add(text2);
	}
}
