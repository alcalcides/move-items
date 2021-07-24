package app.model.config;

import java.util.Map;

import app.library.dataStructuresUtilities.JSONOperations;
import app.library.file.FileOperations;
import lombok.Getter;

public class ConfigLoader {
	private static final String baseURLKey = CTEs.PROPERTY_BASE_URL.getValue();
	private static final String fromDirKey = CTEs.PROPERTY_DIRECTORY_FROM.getValue();
	private static final String toDirKey = CTEs.PROPERTY_DIRECTORY_TO.getValue();
	private static final String undesiredItemsFileKey = CTEs.PROPERTY_FILE_UNDESIRED_ITEMS.getValue();
	private static final String pathToConfigFile = CTEs.INTERFACE_CONFIG_FILE.getValue();

	
	@Getter private String baseURL;
	@Getter private String directoryFrom;
	@Getter private String directoryTo;
	@Getter private String fileUndesiredItems;

	public ConfigLoader() {
		String configLite = FileOperations.readFrom(pathToConfigFile);
		Map<String, String> configs = JSONOperations.deserialize(configLite);

		baseURL = configs.get(baseURLKey).toString();
		directoryFrom = configs.get(fromDirKey).toString();
		directoryTo = configs.get(toDirKey).toString();
		fileUndesiredItems = configs.get(undesiredItemsFileKey).toString();
	}

}
