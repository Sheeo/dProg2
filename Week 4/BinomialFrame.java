import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BinomialFrame extends JFrame
{
	private JPanel outerPanel;
	private JPanel textFieldPanel;
	private JPanel radioButtonPanel;
	private JTextField nField;
	private JTextField kField;
	private BinomialRadioButton selected;
	private JButton submit;
	private JLabel resultLabel;

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
		outerPanel.add(submit);
		outerPanel.add(resultLabel);
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
		nField = new JTextField();
		gridbag.setConstraints(nField, c);
		textFieldPanel.add(nField);
		++c.gridy;
		kField = new JTextField();
		gridbag.setConstraints(kField, c);
		textFieldPanel.add(kField);
	}

	private long getN() {
		return Long.parseLong(nField.getText());
	}

	private long getK() {
		return Long.parseLong(kField.getText());
	}

	private void createRadioButtons() {
		radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(1,0));
		radioButtonPanel.add(new BinomialRadioButton("Slow", true, new BinomialSlow(), this));
		radioButtonPanel.add(new BinomialRadioButton("Fast", false, new BinomialLinear(), this));
	}

	private Binomial getStrategy() {
		if (selected != null) {
			return selected.getStrategy();
		}
		return null;
	}

	private void setStrategy(BinomialRadioButton b) {
		selected = b;
	}

	private void createSubmitButton() {
		submit = new JButton("Calculate");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BinomialContext ctxt = new BinomialContext(getStrategy(), getN(), getK());
				setResult(new Long(ctxt.binomial()).toString());
			}
		});
	}

	private void createResultLabel() {
		resultLabel = new JLabel();
	}

	private void setResult(String res) {
		resultLabel.setText(res);
		System.out.println(res);
	}

	private class BinomialRadioButton extends JRadioButton implements ActionListener {
		private Binomial strategy;
		private BinomialFrame parent;

		public BinomialRadioButton(String text, boolean checked, Binomial strategy, BinomialFrame parent) {
			super(text, checked);
			this.strategy = strategy;
			this.parent = parent;
			this.addActionListener(this);
			if (checked) parent.setStrategy(this);
		}

		public Binomial getStrategy() {
			return strategy;
		}

		public void actionPerformed(ActionEvent e) {
			parent.setStrategy(this);
		}
	}
}
