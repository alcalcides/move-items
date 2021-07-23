package app;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import app.controller.ListAllDirectoriesInFolder;

@SpringBootApplication
public class IndisponibilizarAppsComBugApplication implements CommandLineRunner {
	public String pathToAppsRepository = "/home/consiste/upon/";

	public static void main(String[] args) {
		new SpringApplicationBuilder(IndisponibilizarAppsComBugApplication.class).headless(false).run(args);
	}

	@Override
	public void run(String... args) {
		String currentlyApps = new ListAllDirectoriesInFolder().run(pathToAppsRepository);
		
		
		JFrame frame = new JFrame("Spring Boot Swing App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JPanel panel = new JPanel(new BorderLayout());
		JTextField listOfApps = new JTextField(currentlyApps);
		panel.add(listOfApps, BorderLayout.CENTER);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
