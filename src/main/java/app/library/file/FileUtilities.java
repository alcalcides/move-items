package app.library.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Vector;

public class FileUtilities implements FileSupport {
	String lineBreak;

	public FileUtilities() {
		this.lineBreak = "\n";
	}

	public FileUtilities(String lineBreak) {
		this.lineBreak = lineBreak;
	}

	@Override
	public String readFrom(String path) {
		String content = new String();
		try {
			FileReader file = new FileReader(path);
			BufferedReader fileWrapper = new BufferedReader(file);

			String line = fileWrapper.readLine();
			while (line != null) {
				content += line + lineBreak;
				line = fileWrapper.readLine();
			}
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return content;
	}

	@Override
	public boolean writeFile(String path, String message) {
		boolean feedback;
		FileWriter file;
		try {
			file = new FileWriter(path);
			PrintWriter recordFile = new PrintWriter(file);
			recordFile.println(message);
			recordFile.close();
			feedback = true;
		} catch (IOException e) {
			e.printStackTrace();
			feedback = false;
		}

		return feedback;
	}

	@Override
	public boolean appendFile(String path, String message) {
		boolean feedback;
		FileWriter file;
		try {
			file = new FileWriter(path, true);
			PrintWriter recordFile = new PrintWriter(file);
			recordFile.println(message);
			recordFile.close();
			feedback = true;
		} catch (IOException e) {
			e.printStackTrace();
			feedback = false;
		}

		return feedback;
	}

	@Override
	public boolean deleteFile(String path) {
		File file = new File(path);
		boolean wasDeleted = file.delete();

		return wasDeleted;
	}

	@Override
	public String readFirstLine(String sourcePath) throws FileNotFoundException, IOException {
		System.out.println("Getting first line of the file: " + sourcePath);
		FileReader fileReader = new FileReader(sourcePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String firstLine = bufferedReader.readLine();
		bufferedReader.close();
		fileReader.close();
		return firstLine;
	}

	@Override
	public List<String> getFilesInDirectory(String path) {

		File directory = new File(path);
		File listOfFiles[] = directory.listFiles();

		List<String> files = new Vector<>();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			files.add(file.getName());
		}
		return files;
	}

	@Override
	public boolean move(String fromAbsolutePath, String toAbsolutePath) {
		Boolean isMoved = false;
		File from = new File(fromAbsolutePath);
		File to = new File(toAbsolutePath);

		try {
			Path feedback = Files.move(from.toPath(), to.toPath(), StandardCopyOption.REPLACE_EXISTING);
			isMoved = feedback.endsWith(to.toPath());
			System.out.println("Directory moved successfully.");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return isMoved;

	}

}
