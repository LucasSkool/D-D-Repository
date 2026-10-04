import java.awt.Graphics;

/**
 * Implements the list of messages for teletext
 */
public class TeletextList {
  private ListNode2 heading, topNode;

  /**
   * Creates a circular list of headlines.
   * First creates a circular list with one node, "Today's headlines:".
   * Saves a reference to that node in heading.
   * Adds a node holding an empty string before heading
   * and another node holding an empty string after heading.
   * Appends all the strings from headlines to the list, after
   * the blank line that follows heading,
   * preserving their order. Sets topNode equal to heading.
   */
  public TeletextList(String[] headlines) {
    this.heading = new ListNode2("Today's headlines:", null, null);
    this.heading.setPrevious(new ListNode2("", null, this.heading));
    this.heading.setNext(new ListNode2("", this.heading, null));

    ListNode2 previousNode = this.heading.getNext();
    for (int i = 0; i < headlines.length; i++) {
      ListNode2 newNode = new ListNode2(headlines[i], previousNode, null);
      previousNode.setNext(newNode);
      previousNode = newNode;
    }

    previousNode.setNext(this.heading.getPrevious());
    this.topNode = this.heading;
  }

  /**
   * Inserts a node with msg into the headlines list after the blank
   * line that follows heading.
   */
  public void insert(String msg) {
    ListNode2 newNode = new ListNode2(msg, this.heading.getNext(), this.heading.getNext().getNext());
    this.heading.getNext().setNext(newNode);
    this.heading.getNext().getNext().setPrevious(newNode);
  }

  /**
   * Deletes the node that follows topNode from the headlines list,
   * unless that node happens to be heading or the node before or after
   * heading that holds a blank line.
   */
  public void delete() {
    if (!(topNode.getNext().equals(this.heading) || topNode.getNext().equals(this.heading.getNext()) || topNode.getNext().equals(this.heading.getPrevious()))) {

      topNode.setNext(topNode.getNext().getNext());
      topNode.getNext().getNext().setPrevious(topNode);

    }
  }

  /**
   * Scrolls up the headlines list, advancing topNode to the next node.
   */
  public void scrollUp() {
    topNode = topNode.getNext();
  }

  /**
   * Adds a new node with msg to the headlines list before a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addBefore(ListNode2 node, String msg) {
    ListNode2 newNode = new ListNode2(msg, node.getPrevious(), node);
    node.setPrevious(newNode);
    node.getPrevious().getPrevious().setNext(node.getPrevious());
    return newNode;
  }

  /**
   * Adds a new node with msg to the headlines list after a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addAfter(ListNode2 node, String msg) {
    ListNode2 newNode = new ListNode2(msg, node, node.getNext());
    node.setNext(newNode);
    node.getNext().getNext().setPrevious(newNode);
    return newNode;
  }

  /**
   * Removes a given node from the list.
   */
  private void remove(ListNode2 node) {
    node.getPrevious().setNext(node.getNext());
    node.getNext().setPrevious(node.getPrevious());
  }

  /**
   * Draws nLines headlines in g, starting with topNode at x, y
   * and incrementing y by lineHeight after each headline.
   */
  public void draw(Graphics g, int x, int y, int lineHeight, int nLines) {
    ListNode2 node = topNode;
    for (int k = 1; k <= nLines; k++) {
      g.drawString((String) node.getValue(), x, y);
      y += lineHeight;
      node = node.getNext();
    }
  }
}
