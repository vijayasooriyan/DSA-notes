public class doublyLinkedList{
    Node head;
    Node tail;   

class Node{
	int data;
	Node prev;
	Node next;
	Node(int val){
		data=val;
		prev=null;
		next=null;	
	}
}
	
	doublyLinkedList(){
		head=null;
		tail=null;
	}
	
	public void insertAtBeginning(int val){
		Node newnode=new Node(val);
		    
		if(head==null){
			head=newnode;
			tail=newnode;
		}
		else{
			head.prev=newnode;
			newnode.next=head;
			head=newnode;
			}
	}
	public void insertAtPos(int pos, int val){
		if(pos==0){
			insertAtBeginning(val);
			return;
		}
		Node newnode=new Node(val);
		Node temp=head;
		
		for(int i=1;i<pos;i++){
			temp=temp.next;
			if(temp==null)
				System.out.println("Invalid Position!");	
		}  
		newnode.next=temp.next;
		newnode.prev=temp;
		
		if(temp==tail)
			tail=newnode;
		
		else
		    temp.next.prev=newnode;
		    temp.next=newnode;
	}
	public void insertAtEnd(int val){
		Node newnode=new Node(val);
		Node temp=head;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=newnode;
		newnode.prev=temp;
	}
	public void display(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	public void displayRev(){
		Node temp=tail;
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.prev;
		}
	}
	
	public void deleteAtPos(int pos) {
		if(head==null) 
			System.out.println("Deletion attempted on empty list ");
	
		if(pos==0) {
			head = head.next;
			if(head==null)
				tail=null;
			else
				head.prev = null;
			return;
		}
		
		Node temp = head;
		Node prev = null;
		
		//jump till node to be deleted
		for(int i=1;i<=pos;i++) {
			prev = temp; //keep track of prev node
			temp = temp.next; //jump to next node
			if(temp==null)
			System.out.println("Invalid position ");
				
		}
		
		prev.next = temp.next; //reassign pointers
		if(temp.next==null)
			tail = prev;
		else
			temp.next.prev = prev;
	}
	
	
	public void deleteAtBeginning(){
		if(head==null){
			System.out.println("deletion attemped in empty list");
			
		}
		if(head==null)
			tail=null;
		else
			head.next.prev=null;
		    head=head.next;
	}
	
	public int size(){
		Node temp=head;
		int size=0;
		while(temp!=null){
			size++;
			temp=temp.next;
		}
		return size;
	}
	public static void main(String[] args){
		doublyLinkedList list=new doublyLinkedList();
		

        list.insertAtBeginning(3);
		list.insertAtBeginning(2);
		list.insertAtBeginning(1);
		list.display();
		System.out.println(" ");
		list.insertAtPos(1,5);
		list.display();
		
		list.deleteAtPos(1);
		System.out.println(" ");
		list.display();
		
		list.deleteAtBeginning();
		System.out.println(" ");
		list.display();
		System.out.println(" ");
		list.insertAtEnd(400);
		list.display();
		
		System.out.println(" ");
		System.out.println("size is"+list.size());
	}
}