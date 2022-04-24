package Assignment10;

class Node<T>{
    T data ;
    Node<T> next;
    Node(){
        this.data= null;
        this.next =next;

    }
    Node(T data){
        this.data = data;
        this.next =null;
    }
}
class SList<T>{
    Node<T> head;

    SList(){
        this.head= null;
    }
    SList(T data){
        this.head =new  Node(data);

    }
    SListIterator iterator(){
        return new SListIterator(head);
    }
}
class SListIterator<T> {
    Node<T> head;

    SListIterator(Node head) {
        this.head = head;
    }


    public void add(T data)
    {
        if(head == null)
            head = new Node  (data);
        else
        {
            Node <T> temp = head;

            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void insert(int index, T data) {
        if (index == 0) {
            Node obj = new Node(data);
            obj.next = head;
            head = obj;
        } else {
            int count = 0;
            Node<T> obj = head;
            while (obj != null) {
                obj = obj.next;
                count++;
            }
            if (index < count) {
                int count1 = 0;
                Node<T> temp = head;
                while (count1 < index - 1) {
                    temp = temp.next;
                    count1++;
                }
                Node<T> newObj = new Node(data);
                newObj.next = temp.next;
                temp.next = newObj;
            } else {
                System.out.println("Not possible");
            }

        }
    }

    public void remove(int index) {
        if (index == 0) {
            Node<T> temp = head;
            head = temp.next;
        } else {
            int count = 0;
            Node<T> obj = head;
            while (obj != null) {
                obj = obj.next;
                count++;
            }
            if (index < count) {
                Node<T> temp = head;
                int cnt1 = 0;
                while (cnt1 < index - 1) {
                    temp = temp.next;
                    cnt1++;
                }
                temp.next = temp.next.next;
            } else
                System.out.println("not possible");

        }
    }

    public void printList ()
    {
        Node <T> temp = head;
        while(temp != null)
        {
            System.out.print(temp.data +" ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class GenericArraysContainers {
    public static void main(String[] args) {
        SList<Integer>  list = new SList<>();

        SListIterator<Integer> listIterator = list.iterator();

        listIterator.add(4);
        listIterator.add(4);
        listIterator.add(8);
        listIterator.add(12);
        listIterator.add(14);
        listIterator.add(16);
        listIterator.printList();
        listIterator.remove(5);
        listIterator.printList();
        listIterator.insert(4,7);



        listIterator.printList();
    }
}
