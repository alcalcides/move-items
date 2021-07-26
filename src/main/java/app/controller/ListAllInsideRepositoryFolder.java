package app.controller;

import java.util.List;

import app.library.file.FileOperations;

public class ListAllInsideRepositoryFolder {

	public List<String> run(String path) {

		List<String> foldersAndFiles = FileOperations.getFilesInDirectory(path);
		System.out.println("\nDiscovered:\n\t" + foldersAndFiles.toString());
		return foldersAndFiles;

	}
}
