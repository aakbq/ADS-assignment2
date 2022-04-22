public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public MyNode<T> getHead() {
        return head;
    }

    public void setHead(MyNode<T> head) {
        this.head = head;
    }


    public MyNode<T> getTail() {
        return tail;
    }

    public void setTail(MyNode<T> tail) {
        this.tail = tail;
    }

    public MyLinkedList() {}

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> newNode=new MyNode<>(item);
        MyNode<T> current=head;
        if(head==null) head=newNode;
        else if(index==0){
            head=newNode;
            head.next=current;
        }else if(index==length){
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }else{
            int cur=0;
            while(cur<index-1){
                current=current.next;
                cur++;
            }
            current.next.prev=newNode;
            newNode.next=current.next;
            newNode.prev=current;
            current.next=newNode;
        }
        length++;
    }

    @Override
    public boolean remove(T item) {
        if(head==null) return false;
        for(MyNode<T> i=head; i!=null; i=i.next){
            if(item.equals(i.data)){
                i.data=i.next.data;
                i.next=i.next.next;
            }else{
                return false;
            }
        }
        length--;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        if(head==null) return (T) head;
        if(index==0) return (T) head.next;

        MyNode<T> current=head;
        int counter=0;
        Object removed;
        while(counter<index-1){
            current=current.next;
            counter++;
        }
        removed=current.next.data;
        current.next=current.next.next;
        length--;
        return (T) removed;
    }

    @Override
    public void clear() {
        length=0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int counter=0;
        MyNode<T> current=head;
        for(MyNode<T> i=head; i!=null; i=i.next){
            if(o.equals(i.data)) return counter;
            else counter++;
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index=length-1;
        for(MyNode<T> i=tail; i!=null; i=i.prev){
            if(o.equals(i.data)) return index;
            else index--;
        }
        return 0;
    }

    @Override
    public void sort() {
        for(MyNode<T> i=head; i!=null; i=i.next){
            Object temp;
            for(MyNode<T> j=head; j!=tail; j=j.next){
                T a=(T) j.data;
                T b=(T) j.next.data;
                if(a.compareTo(b)>0){
                    temp=j.data;
                    j.data=j.next.data;
                    j.next.data= (T) temp;
                }
            }
        }
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        for(MyNode<T> i=head; i!=null; i=i.next){
            if(o.equals(i.data)) return true;
        }
        return false;
    }
}
