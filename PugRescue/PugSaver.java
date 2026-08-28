import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	// Moves every dog whose breed is "Pug" in the list to the back of the list
	public static void rescuePugs(ArrayList<Dog> list) {
		/*int length = list.size();
		for (int i = 0; i < length; i++) {
			if (list.get(i).getBreed().equals("Pug")) {
				list.add(list.remove(i));
				i--;
				length--;
			}*/

		for (int i = list.size() - 1; i >= 0; i--) {
			if (list.get(i).getBreed().equals("Pug")) {
				list.add(list.remove(i));
			}
		}

	}
}

