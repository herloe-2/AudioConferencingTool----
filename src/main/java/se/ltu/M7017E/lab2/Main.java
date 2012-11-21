package se.ltu.M7017E.lab2;

import javax.swing.SwingUtilities;

import org.gstreamer.Gst;

import se.ltu.M7017E.lab2.ui.Gui;

public class Main {
	public static void main(String[] args) {

		args = Gst.init("Audio conferencing tool", args);

		final App app = new App();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui gui = new Gui(app);
				gui.setVisible(true);
			}
		});
	}
}
