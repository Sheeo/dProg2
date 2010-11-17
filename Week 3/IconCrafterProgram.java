import javax.swing.*;
import java.awt.*;

public class IconCrafterProgram {
	private IconCrafter crafter;

	public IconCrafterProgram(String[] args) {
		crafter = new IconCrafter();
		parse(args);
	}
	private void parse(String[] args) {
		int argsadded = 0;
		boolean noparams = false;
		for (String arg : args) {
			if (!noparams && arg.charAt(0) == '-') {
				if (arg.equals("--")) {
					noparams = true;
					continue;
				}
				System.err.println("Unrecognised option: "+arg);
				continue;
			}
			int equals = arg.indexOf('=');
			String name;
			if (equals < 0) {
				name = arg;
			} else {
				name = arg.substring(0, equals);
				arg = arg.substring(equals+1);
			}
			int color;
			try {
				color = Integer.parseInt(arg, 16);
			} catch (NumberFormatException e) {
				System.err.println("Not a hexadecimal number: "+arg);
				continue;
			}
			if (color > 0xFFFFFF || color < 0) {
				System.err.println("Hexadecimal number out of bounds: "+arg);
				continue;
			}
			crafter.addColor(name, new Color(color));
			++argsadded;
		}
		if (argsadded == 0) {
			crafter.addColor("Rød", new Color(0xED1C24));
			crafter.addColor("Grøn", new Color(0x228B22));
			crafter.addColor("Blå", new Color(0x007FFF));
		}
	}
	public void execute() {
		crafter.pack();
		crafter.setVisible(true);
		crafter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
}
