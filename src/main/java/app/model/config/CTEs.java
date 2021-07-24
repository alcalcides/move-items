package app.model.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CTEs {
	INTERFACE_CONFIG_FILE("./config.json"),
	
	PROPERTY_BASE_URL("baseURL"),
	PROPERTY_DIRECTORY_FROM("directoryFrom"),
	PROPERTY_DIRECTORY_TO("directoryTo"),
	PROPERTY_FILE_UNDESIRED_ITEMS("fileUndesiredItems");	
	
	private String value;
	
}
