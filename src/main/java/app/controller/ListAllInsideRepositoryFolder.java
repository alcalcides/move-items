package app.controller;

import java.util.List;

import app.library.file.FileOperations;

public class ListAllInsideRepositoryFolder {

	public List<String> run(String path) {

		List<String> foldersAndFiles = FileOperations.getFilesInDirectory(path);
		System.out.println(foldersAndFiles.toString());
		return foldersAndFiles;

	}
}
