package app.controller;

import java.util.List;

import app.library.file.FileOperations;

public class ItemsTransfer {

	public void run(List<String> itemsToBeRemoved, String pathToRepositoryOfItems, String pathToItemsRemoved) {
		itemsToBeRemoved.forEach((undesiredItem) -> {
			String pathFrom = pathToRepositoryOfItems + undesiredItem;
			String pathTo = pathToItemsRemoved + undesiredItem;
			Boolean moved = FileOperations.move(pathFrom, pathTo);
			if(moved) {
				FileOperations.appendFile("./log/moved.log", "Moved from " + pathFrom + " to " + pathToItemsRemoved);
				System.out.println("Moved from " + pathFrom + " to " + pathToItemsRemoved);
			}
			else {
				FileOperations.appendFile("./log/notMoved.log", "Failed moving from " + pathFrom + " to " + pathToItemsRemoved);
				System.out.println("Failed moving from " + pathFrom + " to " + pathToItemsRemoved);
			}
		});
	}
}
