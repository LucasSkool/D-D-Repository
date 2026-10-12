public class RecursionTester {
    public static String toString(String[][] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                result += array[i][j] + ", ";
            }
            result += "\n";
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode("headString");
        ListNode whereImLooking = head;
        for (int i = 0; i < 5; i++) {
            whereImLooking.setNext(new ListNode("" + i + "th object"));
            whereImLooking = whereImLooking.getNext();
        }
        whereImLooking.setNext(null);
        // this is immitating a SinglyLinkedList
        whereImLooking = head;
        for (int i = 0; i < 6; i++) {
            System.out.println(whereImLooking.getValue());
            whereImLooking = whereImLooking.getNext();
        }

        System.out.println();
        Recursion.printListInReverse(head); // ok ts works

        System.out.println();

        System.out.println(Recursion.countWaysToJumpUpStairs(1)); // should be 1
        System.out.println(Recursion.countWaysToJumpUpStairs(3)); // should be 4
        System.out.println(Recursion.countWaysToJumpUpStairs(10)); // should be 274

        System.out.println();

        System.out.println(Recursion.countNonConsecutiveSubsets(4)); // should return 8
        System.out.println(Recursion.countNonConsecutiveSubsets(0)); // 1
        System.out.println(Recursion.countNonConsecutiveSubsets(1)); // 2
        System.out.println(Recursion.countNonConsecutiveSubsets(10)); // 144

        System.out.println();

        String[][] losAngeles = {
                { "suzy", "ben", "vaccinated", "vaccinated" },
                { "vaccinated", "vaccinated", "egor", "lucas" },
                { "egor2", "vaccinated", "ohno", "pitman" },
                { "suzuki", "vaccinated", "max", "runshi" }
        };

        System.out.println(toString(losAngeles));
        System.out.println();
        Recursion.infect(losAngeles, 2, 2);
        System.out.println(toString(losAngeles));

    }
}
