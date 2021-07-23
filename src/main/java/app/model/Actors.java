package app.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Actors {
	private List<String> appsAlreadyLaunched;
	private List<String> appsToBeRemoved;
	
}
