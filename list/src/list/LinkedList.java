package list;

public class LinkedList implements List{
    private Node head;
    private Node tail;
    
    public LinkedList(){
        
    }
    
    public void add(Object o){
        Node n = new Node(o);
        if(tail != null){
            tail.next = n;
        }
        tail = n;
        if(head == null){
            head = n;
        }
    }
    
    public void addFirst(Object o){
        
    }
    
    public void addLast(Object o){
        
    }
    
    public void add(int index, Object element){
        
    }
    
    public Object remove(int index){
        return null;
    }
    
    public Object removeFirst(){
        return null;
    }
    
    public Object removeLast(){
        return null;
    }
    
    public boolean remove(Object o){
        return false;
    }
            
    public Object set(int index, Object element){
        return null;
    }
    
    public int size(){
        return 0;
    }
    
    public Object[] toArray(){
        return null;
    }
    
    @Override
    public String toString(){
        return "";
    }
    
    public static void main(String args[]){
              // create a linked list
      LinkedList ll = new LinkedList();
      // add elements to the linked list
      ll.add("F");
      ll.add("B");
      ll.add("D");
      ll.add("E");
      ll.add("C");
      ll.addLast("Z");
      ll.addFirst("A");
      ll.add(1, "A2");
      System.out.println("Original contents of ll: " + ll);

      // remove elements from the linked list
      ll.remove("F");
      ll.remove(2);
      System.out.println("Contents of ll after deletion: "
       + ll);
      
      // remove first and last elements
      ll.removeFirst();
      ll.removeLast();
      System.out.println("ll after deleting first and last: "
       + ll);

      // get and set a value
      Object val = ll.get(2);
      ll.set(2, (String) val + " Changed");
      System.out.println("ll after change: " + ll);
    }
}

class Node {
    Object o;
    Node next;
    public Node(Object o) {
        this.o = o;
    }
    public Node(Object o, Node next) {
        this.o = o;
        this.next = next;
    }
}