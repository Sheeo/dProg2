import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;

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

	/**
	 * Draw the icon at the specified location.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}
}
