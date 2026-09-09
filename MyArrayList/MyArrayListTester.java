public class MyArrayListTester {
    public static void main(String[] args) {
        /*
         * MyArrayList<String> list = new MyArrayList<>();
         * 
         * System.out.println(list.size());
         * System.out.println(list.isEmpty());
         * // System.out.println(list.get(0)); //throws an exception
         * System.out.println(list.toString());
         * 
         * for (int i = 0; i < 5; i++) {
         * list.add("Object " + i);
         * }
         * System.out.println(list.size());
         * System.out.println(list.toString());
         * 
         * list.remove("Object 1");
         * System.out.println(list.toString());
         * 
         * list.remove(0);
         * System.out.println(list.toString());
         * 
         * System.out.println(list.contains("Object 2"));
         * 
         * System.out.println(list.get(1));
         * 
         * list.add("New");
         * System.out.println(list.toString());
         * 
         * list.add(1, "New2New");
         * System.out.println(list.toString());
         */

        MyArrayList<Dog> list = new MyArrayList<Dog>();
        int numThings = 50;

        for (int i = 0; i < numThings; i++) {
            if (i % 2 == 0) {
                Dog tempDog = new Dog("Dog #" + i, "Pug");
                list.add(tempDog);
            } else if (i % 3 == 0) {
                Dog tempDog = new Dog("Dog #" + i, "GSD");
                list.add(tempDog);
            } else {
                Dog tempDog = new Dog("Dog #" + i, "Golden Retriever");
                list.add(tempDog);
            }
        }
        System.out.println(list.toString());
        System.out.println();
        System.out.println();

        int dogsToCheck = list.size();
        for (int i = 0; i < dogsToCheck; i++) { // when we move a pug, dogsToCheck-- (name is not EXACTLY what it is)
            if (list.get(i).getBreed().equals("Pug")) { // if we are at a pug
                list.add(list.get(i));
                list.remove(i);
                dogsToCheck--;
                i--;
            }
        }

        System.out.println(list.toString());

    }
}
