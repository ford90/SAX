package proceeding;

import java.util.ArrayList;
import java.util.List;

public interface Printable {
	
	public static List<Printable> listOfObjects = new ArrayList<Printable>();;

	public String toString();
	
}
