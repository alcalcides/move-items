package app.library.file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileSupport {
	public List<String> getFilesInDirectory(String path);
	
	public abstract String readFrom(String path);
	public String readFirstLine(String sourcePath) throws FileNotFoundException, IOException;
	
	public abstract boolean writeFile(String path, String message);
	public abstract boolean appendFile(String path, String message);

	public abstract boolean deleteFile(String path);
	public abstract boolean moveFile(String pathFrom, String pathTo);
	public abstract boolean move(String fromAbsolutePath, String toAbsolutePath);
}
