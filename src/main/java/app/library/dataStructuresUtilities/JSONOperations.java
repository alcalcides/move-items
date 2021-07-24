package app.library.dataStructuresUtilities;

import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSONOperations {
	
	public static <T, K> Map<T, K> deserialize(String configLite) {
		Type generalMapType = new TypeToken<Map<T, K>>() {}.getType();
		Map<T, K> deserializedJSON = new Gson().fromJson(configLite, generalMapType);
		return deserializedJSON;
	}
	
}
