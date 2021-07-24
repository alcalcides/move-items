package app.library.dataStructuresUtilities;

import java.util.List;
import java.util.stream.Collectors;

public class CollectionsOperations {
	public static List<String> cleanEntries(List<String> listOfString) {
		return listOfString.stream().map((item) -> {
			return item.trim();
		}).collect(Collectors.toList());
	}
}
