package app;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import app.controller.ItemsTransfer;
import app.controller.ListAllInsideRepositoryFolder;
import app.controller.TrackUndesiredItems;
import app.model.Actors;
import app.model.config.Config;

@SpringBootApplication
public class App implements CommandLineRunner {	
	private final static Config config = new Config();
	private final String baseURL = config.getBaseURL();
	private final String fromDir = config.getDirectoryFromPath();
	private final String toDir = config.getDirectoryToPath();	
	private final String undesiredItemsFile = config.getPathToUndesiredItems();

	private String pathToListOfUndesiredItems = baseURL + undesiredItemsFile; 
	private String pathToRepositoryOfItems = baseURL + fromDir;
	private String pathToRemovedItemsRepository = baseURL + toDir;

	private Actors actors = new Actors();

	public static void main(String[] args) {
		new SpringApplicationBuilder(App.class).headless(false).run(args);
	}

	@Override
	public void run(String... args) {
		List<String> presentItems = new ListAllInsideRepositoryFolder().run(pathToRepositoryOfItems);
		actors.setItemsDiscovered(presentItems);

		List<String> undesiredItems = new TrackUndesiredItems().run(pathToListOfUndesiredItems);
		actors.setItemsToBeRemoved(undesiredItems);

		new ItemsTransfer().run(undesiredItems, pathToRepositoryOfItems, pathToRemovedItemsRepository);


	}


}
