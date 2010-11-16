import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;

public class IconCrafter extends JFrame {
	public static void main(String[] args) {
		IconCrafter crafter = new IconCrafter();
		crafter.pack();
		crafter.setVisible(true);
		crafter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private JPanel outerPanel;
	private JPanel buttonPanel;
	private CompositeIcon ballsIcon;
	private JLabel ballsLabel;

	public IconCrafter() {
		super();
		createOuterPanel();
		add(outerPanel);
	}

	private void createOuterPanel() {
		createButtonPanel();
		createIcon();
		outerPanel = new JPanel() {{
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			add(buttonPanel);
			add(ballsLabel);
		}};
	}
	
	private void createButtonPanel() {
		buttonPanel = new JPanel() {{
			setLayout(new GridLayout(1,3));
			add(new ColorButton("Rød", Color.RED));
			add(new ColorButton("Grøn", Color.GREEN));
			add(new ColorButton("Blå", Color.BLUE));
		}};
	}

	private void createIcon() {
		ballsIcon = new CompositeIcon();
		ballsLabel = new JLabel(ballsIcon);
	}

	private class ColorButton extends JButton {
		private Color color;
		public ColorButton(String label, Color c) {
			super(label);
			color = c;
			addActionListener(new ColorActionListener());
		}
		private class ColorActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				ballsIcon.addIcon(new BallIcon(color));
			}
		}
	}
}
