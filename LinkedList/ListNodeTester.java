public class ListNodeTester {
    public static void main(String[] args) {
        String[] array = { "This 1", "That 1", "This 2", "That 2", "This 3", "That 3" };
        SinglyLinkedList<String> nextList = new SinglyLinkedList<String>(array);
        System.out.println(nextList.toString());

        nextList.remove("This 2");
        System.out.println(nextList.toString());

        nextList.remove("This 1"); //something wrong when we are at the beginning -- just doesn't do anything
        System.out.println(nextList.toString());

        nextList.remove("That 3");
        System.out.println(nextList.toString());

    }
}
