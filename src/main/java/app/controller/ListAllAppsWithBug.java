package app.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import app.library.file.FileSupport;
import app.library.file.FileUtilities;

public class ListAllAppsWithBug {

	public FileSupport fileTool = new FileUtilities();

	public List<String> run(String pathToListOfAppsWithBug) {
		String sinnerAppsLite = fileTool.readFrom(pathToListOfAppsWithBug);
		List<String> sinnerAppsDirty = Arrays.asList(sinnerAppsLite.split("\n"));
		List<String> sinnerApps = cleanEntries(sinnerAppsDirty);
		System.out.println(sinnerApps.toString());
		return sinnerApps;
	}

	private List<String> cleanEntries(List<String> sinnerAppsDirty) {
		return sinnerAppsDirty.stream().map((item) -> {
			return item.trim();
		}).collect(Collectors.toList());
	}

}
