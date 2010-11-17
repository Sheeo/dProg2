import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;

public class IconCrafter extends JFrame {
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
		outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.PAGE_AXIS));
		outerPanel.add(buttonPanel);
		outerPanel.add(iconPanel);
	}

	public void addColor(String name, Color color) {
		buttonPanel.add(new ColorButton(name, color));
	}

	private void createButtonPanel() {
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,0));
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
