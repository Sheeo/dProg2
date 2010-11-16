import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;

public class BallsIcon implements Icon {
	/**
	 * Returns the icon's height.
	 */
	public int getIconHeight() {
		// TODO
		return 100; // dummy value
	}

	/**
	 * Returns the icon's width.
	 */
	public int getIconWidth() {
		// TODO
		return 100; // dummy value
	}

	/**
	 * Draw the icon at the specified location.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		// TODO
	}

	public void addCircle(Color col) {
		System.out.println("Add "+col);
	}
}
