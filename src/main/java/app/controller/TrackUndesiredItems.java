package app.controller;

import java.util.Arrays;
import java.util.List;

import app.library.dataStructuresUtilities.CollectionsOperations;
import app.library.file.FileOperations;

public class TrackUndesiredItems {

	public List<String> run(String pathToUndesiredItemsList) {
		String undesiredItemsLite = FileOperations.readFrom(pathToUndesiredItemsList);
		List<String> undesiredItemsDirty = Arrays.asList(undesiredItemsLite.split("\n"));
		List<String> undesiredItems = CollectionsOperations.cleanEntries(undesiredItemsDirty);
		System.out.println("\nTo be moved: \n\t" + undesiredItems.toString());
		return undesiredItems;
	}

}
