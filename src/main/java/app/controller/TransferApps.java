package app.controller;

import java.util.List;

import app.library.file.FileSupport;
import app.library.file.FileUtilities;

public class TransferApps {
	public FileSupport fileTool = new FileUtilities();

	public void run(List<String> appsToBeRemoved, String pathToAppsRepository, String pathToAppsRemoved) {
		appsToBeRemoved.forEach((sinnerApp) -> {
			String pathFromFull = pathToAppsRepository + sinnerApp;
			Boolean moved = fileTool.move(pathFromFull, pathToAppsRemoved + sinnerApp);
			if(!moved) {
				throw new RuntimeException("Falhou ao mover " + pathFromFull + " para " + pathToAppsRemoved);
			}
		});
	}
}
