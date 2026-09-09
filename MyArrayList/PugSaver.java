import java.util.ArrayList;
import java.util.Objects;

public class PugSaver {

	//Moves every dog whose breed is "Pug" in the list to the back of the list
	//All non-pugs must remain in the same relative order they were in originally
	//and all pugs must also remain in the same relative order they were in originally

	//this was my old version, but I guess I shouldn't remove stuff near the beginning.
	/* public static void rescuePugs(ArrayList<Dog> list) {
		int dogsToCheck = list.size();
		for (int i = 0; i < dogsToCheck; i++) { //when we move a pug, dogsToCheck-- (name is not EXACTLY what it is)
			if (list.get(i).getBreed().equals("Pug")) { //if we are at a pug
				list.add(list.get(i));
				list.remove(i);
				dogsToCheck--;
				i--;
			}
		}
	} */
		// Pug, Pug
		// Golden Retriever, GSD, GSD, GSD, Pug, Golden Retriever, GSD, Pug, GSD, Pug, Golden Retriever
		// Golden Retriever, GSD, Pug, GSD, Pug, Golden Retriever, GSD, Pug, GSD, Pug, Golden Retriever

	public static void rescuePugs(ArrayList<Dog> list) {
		ArrayList<Dog> pugs = new ArrayList<Dog>();
		int lookAhead = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBreed().equals("Pug")) {
				pugs.add(list.get(i));
				lookAhead++;
			} else {
				list.set(i - lookAhead, list.get(i));
			}
		}

		for (int i = 0; i < pugs.size(); i++) {
			list.remove(list.size() - 1);
		} //removes the extra stuff at the end

		for (int i = 0; i < pugs.size(); i++) {
			list.add(pugs.get(i));
		} //adds all the pugs back to the OG list in order
	}
}
