import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinomialFrame extends JFrame
{
	private JPanel outerPanel;
	private JPanel textFieldPanel;
	private JPanel radioButtonPanel;
	private Binomial selected;

	public BinomialFrame()
	{
		super();
		createOuter();
		add(outerPanel);
	}

	private void createOuter()
	{
		createTextFields();
		createRadioButtons();
		createSubmitButton();
		createResultLabel();
		outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
		outerPanel.add(textFieldPanel);
		outerPanel.add(radioButtonPanel);
	}

	private void createTextFields()
	{
		textFieldPanel = new JPanel();
		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		c.ipadx = 20; // add minimum width
		c.insets = new Insets(3,3,3,3); // add margin

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
		c.fill = GridBagConstraints.HORIZONTAL;
		JTextField text1 = new JTextField();
		gridbag.setConstraints(text1, c);
		textFieldPanel.add(text1);
		++c.gridy;
		JTextField text2 = new JTextField();
		gridbag.setConstraints(text2, c);
		textFieldPanel.add(text2);
	}

	private void createRadioButtons() {
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(1,0));
		radioButtonPanel.add(new BinomialRadioButton("Slow", true, new BinomialSlow(), this));
		radioButtonPanel.add(new BinomialRadioButton("Fast", false, new BinomialLinear(), this));
	}

	private Binomial getStrategy() {
		if (selected != null) {
			return selected;
		}
		return null;
	}

	private void setStrategy(Binomial b) {
		selected = b;
	}

	private void createSubmitButton() {
	}

	private void createResultLabel() {
	}

	private class BinomialRadioButton extends JRadioButton implements ActionListener {
		private Binomial strategy;
		private BinomialFrame parent;

		public BinomialRadioButton(String text, boolean checked, Binomial strategy, BinomialFrame parent) {
			super(text, checked);
			this.strategy = strategy;
			this.parent = parent;
		}

		public Binomial getStrategy() {
			return strategy;
		}

		public void actionPerformed(ActionEvent e) {
			parent.setStrategy(strategy);
		}
	}
}
