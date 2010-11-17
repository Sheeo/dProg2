import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;

public class IconCrafter extends JFrame {
	public static void main(String[] args) {
		IconCrafter crafter = new IconCrafter();
		crafter.pack();
		crafter.setVisible(true);
		crafter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}

	private JPanel outerPanel;
	private JPanel buttonPanel;
	private JPanel iconPanel;
	private CompositeIcon ballsIcon;
	private JLabel ballsLabel;

	public IconCrafter() {
		super();
		createOuterPanel();
		add(outerPanel);
	}

	private void createOuterPanel() {
		createButtonPanel();
		createIconPanel();
		outerPanel = new JPanel();
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
		outerPanel.add(buttonPanel);
		outerPanel.add(iconPanel);
	}
	
	private void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(new ColorButton("Rød", new Color(0xED1C24)));
		buttonPanel.add(new ColorButton("Grøn", new Color(0x228B22)));
		buttonPanel.add(new ColorButton("Blå", new Color(0x007FFF)));
	}

	private void createIconPanel() {
		createIcon();
		iconPanel = new JPanel();
		iconPanel.setLayout(new FlowLayout());
		iconPanel.add(ballsLabel);
	}

	private void createIcon() {
		ballsIcon = new CompositeIcon();
		ballsLabel = new JLabel(ballsIcon);
	}

	private class ColorButton extends JButton implements ActionListener {
		private Color color;
		public ColorButton(String label, Color c) {
			super(label);
			color = c;
			addActionListener(this);
			setUI(new ColoredBasicButtonUI());
		}
		public void actionPerformed(ActionEvent e) {
			ballsIcon.addIcon(new BallIcon(color));
			ballsLabel.invalidate();
			pack();
		}
		private class ColoredBasicButtonUI extends BasicButtonUI {
			public void paint(Graphics g, JComponent c) {
				g.setColor(color);
				g.fillRect(0, 0, c.getWidth(), c.getHeight());
				super.paint(g, c);
			}
		}
	}
}
