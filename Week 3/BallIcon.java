import java.awt.*;
import javax.swing.*;

public class BallIcon implements Icon {
	private final int width = 50;
	private final int height = 50;

	private Color color;

	public BallIcon(Color c) {
		color = c;
	}

	/**
	 * Returns the icon's height.
	 */
	public int getIconHeight() {
		return height;
	}

	/**
	 * Returns the icon's width.
	 */
	public int getIconWidth() {
		return width;
	}

	private boolean tryEnableAntiAlias(Graphics g) {
		Graphics2D o;
		try {
			o = (Graphics2D) g;
		} catch (ClassCastException e) {
			// wasn't a Graphics2D
			return false;
		}
		o.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		return true;
	}

	/**
	 * Draw the icon at the specified location.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		tryEnableAntiAlias(g);
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
