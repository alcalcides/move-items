package app;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import app.controller.ListAllAppsWithBug;
import app.controller.ListAllDirectoriesInFolder;
import app.controller.TransferApps;
import app.model.Actors;

@SpringBootApplication
public class IndisponibilizarAppsComBugApplication implements CommandLineRunner {
	private final String baseURL = "/home/consiste/thorsysMigra/";
	private final String fromDir = "XTRBrasilOperacoes/";
	private final String toDir = "XTRBrasilAppsEmManutencao/";
	
	private final String pathToListOfAppsWithBug = "./input/listOfAppsWithBug.txt";
	
	private String pathToAppsRepository = baseURL + fromDir;
	private String pathToAppsRemoved = baseURL + toDir;
	
	private Actors actors = new Actors();
	

	public static void main(String[] args) {
		new SpringApplicationBuilder(IndisponibilizarAppsComBugApplication.class).headless(false).run(args);
	}

	@Override
	public void run(String... args) {
		List<String> currentlyApps = new ListAllDirectoriesInFolder().run(pathToAppsRepository);
		actors.setAppsAlreadyLaunched(currentlyApps);
		
		List<String> sinnerApps = new ListAllAppsWithBug().run(pathToListOfAppsWithBug);
		actors.setAppsToBeRemoved(sinnerApps);
		
		new TransferApps().run(actors.getAppsToBeRemoved(), pathToAppsRepository, pathToAppsRemoved);
		
		JFrame frame = new JFrame("Spring Boot Swing App");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		JPanel panel = new JPanel(new BorderLayout());
		JTextField listOfApps = new JTextField(actors.getAppsAlreadyLaunched().toString());
		JTextField listOfSinnerApps = new JTextField(actors.getAppsToBeRemoved().toString());
		panel.add(listOfApps, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(listOfSinnerApps);
		frame.setContentPane(panel);
		frame.setVisible(true);
	}

}
