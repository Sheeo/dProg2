import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.awt.*;
import javax.swing.event.*;

public class CompositeIcon implements Icon {
	private ArrayList<Icon> icons;

	public CompositeIcon() {
		icons = new ArrayList<Icon>();
	}

	/**
	 * Returns the icon's height.
	 */
	public int getIconHeight() {
		return Collections.max(new ArrayList<Integer>() {{
			add(1); // minimum value
			for (Icon i : icons) {
				add(i.getIconHeight());
			}
		}});
	}

	/**
	 * Returns the icon's width.
	 */
	public int getIconWidth() {
		int x = 0;
		for (Icon i : icons) {
			x += i.getIconWidth();
		}
		return x;
	}

	/**
	 * Draw the icon at the specified location.
	 */
	public void paintIcon(Component c, Graphics g, int x, int y) {
		int dx = 0;
		for (Icon i : icons) {
			i.paintIcon(c, g, x+dx, y);
			dx += i.getIconWidth();
		}
	}

	public void addIcon(Icon icon) {
		icons.add(icon);
	}
}
