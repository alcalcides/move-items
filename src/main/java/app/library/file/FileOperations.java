package app.library.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class FileOperations {
	private static FileSupport fileTool = new FileUtilities();

	public static List<String> getFilesInDirectory(String path) {
		return fileTool.getFilesInDirectory(path);
	}

	public static String readFrom(String path) {
		return fileTool.readFrom(path);
	}

	public String readFirstLine(String sourcePath) throws FileNotFoundException, IOException {
		return fileTool.readFirstLine(sourcePath);
	}

	public static boolean writeFile(String path, String message) {
		return fileTool.writeFile(path, message);
	}

	public static boolean appendFile(String path, String message) {
		return fileTool.appendFile(path, message);
	}

	public static boolean deleteFile(String path) {
		return fileTool.deleteFile(path);
	}

	public static boolean move(String fromAbsolutePath, String toAbsolutePath) {
		return fileTool.move(fromAbsolutePath, toAbsolutePath);
	}

}
