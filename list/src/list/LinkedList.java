package list; 

 
public class LinkedList implements List{
    private Node head;
    private Node tail;
    private int countnum; 
    
    public LinkedList(){
        head = null; 
        tail = null; 
        countnum = 0; 
    }
    
    public LinkedList(Object obj[]) {
        for(int i=0;i<obj.length;i++){
            add(obj[i]);
        }
        //countnum = obj.length;
    }
    
    public void add(Object o){
        Node n = new Node(o);
        if(head == null){
            head = n;          
        }
        if(tail != null){
            tail.next = n;
        }
        tail = n; 
        tail.next = null; 
        countnum++; 
    }
    
    
    public void addFirst(Object o){
        Node n = new Node(o, head);
        head = n;   
        countnum ++; 
     /*  Node n = new Node(o);
        Node t = head; 
        head = n;  
        head.next = t; */
    }
    
    public void addLast(Object o){
    /*    Node n = new Node(o);
        tail = n; 
        tail.next = null; */
        add(o); 
    }
    
    public void add(int index, Object element) throws Exception{       
        if(index > countnum || index < 0){
            throw new Exception("error, illegal index");
        }        
        if(index == 0){
            addFirst(element);
        }else if(index == countnum){
            addLast(element);
        }else{
        
        Node n = new Node(element);
        Node t = head;
        for(int i=0; i<index-1; i++){ 
          //  t = t.getNext();             
            t = t.next; 
        }
        n.next = t.next; 
        t.next = n;   
        countnum ++; 
        }
        
    }
    
    public Object remove(int index) throws Exception{
         if(index >= countnum || index < 0){
            throw new Exception("error, illegal index");
        } 
        Node t = head; 
        for(int i=0; i<index-1; i++){ 
          //  t = t.getNext();             
            t = t.next; 
        }
        t.next = t.next.next; 
        countnum--;
        return t;
    }
    
    public Object removeFirst() throws Exception{
        if(head == null){
            throw new Exception("error, no linklist");
        }
        if(head.next == null){
            Node r = head;
            head = null;
            tail = null;
            countnum --;
            return r.o;
        }
        Node h = head;
        head = head.next; //if there is only one node, after remove, tail should be null
        countnum--; 
        return h.o; //supposed to return the removed node
    }
    
    public Object removeLast()throws Exception{
        if(head == null){
            throw new Exception("error, no linklist");
        }
        if(head.next == null){
            Node r = head;
            head = null;
            tail = null;
            countnum --;
            return r.o;
        }
                
        Node t = head; //what if the linked list only has one node?
        while(t.next.next != null) {
           t = t.next;
       }
       Node last = t.next;
       t.next = null;
       tail = t;
       countnum--;
       return last.o;
       
       /*for(int i=0; i<countnum-2;i++ ){
           t=t.next; 
       }
       t.next = null; 
       tail = t; 
       countnum--;
       return tail; //supposed to return the removed node
       */
    }
    
    public boolean remove(Object o)throws Exception{
        if(head == null){
            throw new Exception("error, no linklist");
        }
        if(head.o.equals(o)) {
            removeFirst();
            return true;
        }
                
        Node t = head;
        while(t.next!=null){
            if(o.equals(t.next.o))
            {
                t.next = t.next.next;               
                countnum--; 
                return true;
            }
            t=t.next;                
        }

        if(t.o.equals(o)){
            removeLast();
            return true;
        }
        return false;
    }
            
    public Object set(int index, Object element)throws Exception{
        if(index >= countnum || index < 0){
            throw new Exception("error, illegal index");
        }   
        Node t = head; 
        for(int i=0; i<index; i++){
            t = t.next; 
        }
        t.o=element;  
        return t.o;
    }
    
    public Object get(int index)throws Exception{
        if(index >= countnum || index < 0){
            throw new Exception("error, illegal index");
        }  
        Node t = head; 
        for(int i=0; i<index; i++){
            t = t.next; 
        }        
        return t.o; 
    }
    
    public int size(){
        return countnum;
    }
    
    public Object[] toArray(){
        Node t = head;
        Object [] obj = new Object [this.countnum];
        int i = 0;
        while(t != null) {
            obj[i] = t.o;
            i++;
            t=t.next;
        }
        return obj;
    }
    
    @Override
    public String toString(){
        Node t = head; 
        String slist = ""; 
        do{ 
            slist += t.o.toString()+" "; 
            t = t.next; 
        } while(t != null); 
        
        return slist;
    }
    
    public void reverse() {
        
    }
    
    public static void main(String args[]) throws Exception{
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
      ll.add(1,"A2");
      System.out.println("Original contents of ll: " + ll.toString());

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