public class ListNodeTester {
    public static void main(String[] args) {
        SinglyLinkedList<String> newList = new SinglyLinkedList<String>();
        for (int i = 0; i < 8; i++) {
            newList.add("" + i);
        }

        System.out.println(newList.toString());
        System.out.println(newList.size());

        newList.add(0, "added@i");
        System.out.println(newList.toString());
    }
}
