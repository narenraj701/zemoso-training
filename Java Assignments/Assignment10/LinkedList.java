//Single Linked List Implementation with Iterator to Iterate through List
class Node<T> {
	T data;
	Node<T> next;

	Node() {
		this.data = null;
		this.next = null;
	}

	Node(T data) {
		this.data = data;
		this.next = null;
	}
}

class SList<T> {
	Node<T> head;

	SList() {
		this.head = null;
	}

	SList(String data) {
		this.head = new Node(data);
	}

	public SListIterator<T> getIterator() {
		return new SListIterator<T>(head);
	}
}

class SListIterator<T> {
	Node<T> head;
	Node<T> tail;

	public SListIterator(Node<T> head) {
		this.head = head;
	}

	void insert(T data) {
		if (head == null) {
			head = new Node(data);
			tail = head;
		} else {
			tail.next = new Node(data);
			tail = tail.next;
		}
	}
	void delete(T data) {
		if (head == null) {
			System.out.println("Empty List cannot be deleted");
			return;
		} else if((head.data).equals(data)) {
			head = head.next;
			if(head==null)
				tail=null;
		}
		else {
			Node<T> prev = head;
			Node<T> temp = head.next;
			while (temp != null) {
				if ((temp.data).equals(data))
					break;
				prev = prev.next;
				temp = temp.next;
			}
			if (temp == null) {
				System.out.println("No element Found");
				return;
				}
			else if(temp == tail) {
				tail = prev;
				tail.next=null;
			}
			else
				prev.next = temp.next;
			}

		}

	void display() {
		if (head == null) {
			System.out.println("Empty List");
			return;
		}
		System.out.println("The elements in List are:");
		Node<T> temp = head;
		do {
			System.out.println(temp.data);
			temp = temp.next;
		} while (temp != null);

	}
}

public class LinkedList {

	public static void main(String[] args) {
		SList<String> names = new SList<>();
		SListIterator it = names.getIterator();
		it.insert("Naren");
		it.insert("Sush");
		it.insert("raj");
		it.display();
		it.delete("Sush");
		it.delete("raj");
		it.display();
	}

}

