package app.controller;

import java.util.List;

import app.library.file.FileOperations;

public class ItemsTransfer {

	public void run(List<String> itemsToBeRemoved, String pathToRepositoryOfItems, String pathToItemsRemoved) {
		itemsToBeRemoved.forEach((undesiredItem) -> {
			String pathFrom = pathToRepositoryOfItems + undesiredItem;
			String pathTo = pathToItemsRemoved + undesiredItem;
			Boolean moved = FileOperations.move(pathFrom, pathTo);
			if(!moved) {
				throw new RuntimeException("Failed to move " + pathFrom + " to " + pathToItemsRemoved);
			}
		});
	}
}
