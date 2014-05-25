/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package list;

public interface List {
    //refer http://www.tutorialspoint.com/java/java_linkedlist_class.htm

    public void add(Object o);
    public void addFirst(Object o);
    public void addLast(Object o);
    public void add(int index, Object element) throws Exception;
    
    public Object remove(int index)throws Exception;
    public Object removeFirst()throws Exception;
    public Object removeLast()throws Exception;
    public boolean remove(Object o)throws Exception;
            
    public Object set(int index, Object element)throws Exception;          
    public Object get(int index)throws Exception; 
    
    public int size();
    public Object[] toArray();
    
    @Override
    public String toString();
}
