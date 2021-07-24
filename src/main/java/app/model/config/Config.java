package app.model.config;

public class Config {
	public static final ConfigLoader configLoader = new ConfigLoader();
	
	public String getBaseURL() {
		return configLoader.getBaseURL();
	}
	
	public String getDirectoryFromPath() {
		return configLoader.getDirectoryFrom();
	}
	
	public String getDirectoryToPath() {
		return configLoader.getDirectoryTo();
	}
	
	public String getPathToUndesiredItems() {
		return configLoader.getFileUndesiredItems();
	}
	
	
}
