import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	//All non-pugs must remain in the same relative order they were in originally
	//and all pugs must also remain in the same relative order they were in originally
	public static void rescuePugs(ArrayList<Dog> list) {
		int dogsToCheck = list.size();
		for (int i = 0; i < dogsToCheck; i++) { //when we move a pug, dogsToCheck-- (name is not EXACTLY what it is)
			if (list.get(i).getBreed().equals("Pug")) { //if we are at a pug
				list.add(list.get(i));
				list.remove(i);
				dogsToCheck--;
				i--;
			}
		}
	}
}
