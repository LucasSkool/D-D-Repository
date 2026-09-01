public class MyArrayListTester {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(0));
        System.out.println(list.toString());

        for (int i = 0; i < 5; i++) {
            list.add("Object " + i);
        }
        System.out.println(list.size());
        System.out.println(list.toString());

        list.remove("Object 1");
        System.out.println(list.toString());

        list.remove(0);
        System.out.println(list.toString());

        System.out.println(list.contains("Object 2"));

        System.out.println(list.get(1));

        list.add("New");
        System.out.println(list.toString());

        list.add(1, "New2New");
        System.out.println(list.toString());

    }
}
