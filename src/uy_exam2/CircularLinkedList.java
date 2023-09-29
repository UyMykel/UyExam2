
package uy_exam2;
class Node {
    String name;
    Node next;
    
    public Node(String name){
        this.name = name;
        this.next = null;
    }
}

class CircularLinkedList{
    Node head;
    
    public CircularLinkedList(){
        this.head = null;
    }
    
    public void insertAtpositon(String name, int position){
        Node newNode =new Node(name);
        if (head == null){
            head = newNode;
            newNode.next = head;
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    
    public void display(){
        if(head == null){
            System.out.println("Names of the first 10 classmates");
            return;
        }
        Node current = head;
        do{
            System.out.println(current.name + " -> ");
            current = current.next;
        } while(current != head);
        
        System.out.println();
}
/**
 *
 * @author MJR BROTHERS
 */
public class Main {

    public static void main(String[] args) {
         CircularLinkedList list = new CircularLinkedList();
    
         //Insert the Names of the first 10 classmates
         list.insertAtpositon("Brent", 1);
         list.insertAtpositon("Blaise", 2);
         list.insertAtpositon("Phillip", 3);
         list.insertAtpositon("Heinly", 4);
         list.insertAtpositon("Joseph", 5);
         list.insertAtpositon("Kane", 6);
         list.insertAtpositon("Jetro", 7);
         list.insertAtpositon("Dave", 8);
         list.insertAtpositon("Judy", 9);
         list.insertAtpositon("Zandra", 10);
         
         list.display();
    
     }
  } 
}

class CircularQueue{
    private int maxSize;
    private String[] queueArray;
    private int front;
    private int rear;
    private int itemCount;
    
    public CircularQueue(int size){
        maxSize = size;
        queueArray = new String[maxSize];
        front = 0;
        rear = 1;
        itemCount = 0;
    }
    
    public boolean isEmpty(){
        return itemCount == 0;
    }
    
    public boolean isFull(){
        return itemCount == maxSize;
    }
    
    public int size(){
        return itemCount;
    }
    
    public void insert(String item){
        if (!isFull()){
            if (rear == maxSize - 1){
                rear = -1;
            }
            queueArray[++rear] = item;
            itemCount++;
        } else {
            System.out.println("Queue is Full. Cannot Insert:" + item);
        }
    }
    
    public String delete(){
        if (!isEmpty()) {
            String removedItem = queueArray[front++];
            if (front == maxSize){
                front = 0;
            }
            itemCount--;
            return removedItem;
        } else {
            System.out.println("Queue is Empty. Cannot delete"); 
        }
        return null;
    }
    
    public boolean search(String item) {
        if(!isEmpty()) {
            for (int i = 0; i < itemCount; i++);
            int index = (front + 1) & maxSize;
            if (queueArray[index].equals(item)) {
                return true;
            }
            
        }
        return false;
    }
}





