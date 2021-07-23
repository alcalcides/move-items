package app.controller;

import java.util.List;

import app.library.file.FileSupport;
import app.library.file.FileUtilities;

public class ListAllDirectoriesInFolder {

	public FileSupport fileTool = new FileUtilities();

	public List<String> run(String path) {

		List<String> foldersAndFiles = fileTool.getFilesInDirectory(path);
		System.out.println(foldersAndFiles.toString());
		return foldersAndFiles;

	}
}
