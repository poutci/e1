
public class LinkedScoreboard {
	public static void main(String[] args) {
		Scoreboard scores = new Scoreboard();
		System.out.println("Top Scores:");
		scores.addNode(1, "Jeff");
		scores.addNode(100,"Vy");
		scores.addNode(6, "Zach");
		scores.addNode(513,"Tyler");
		scores.addNode(591, "Triss");
		scores.addNode(15,"Dan");
		scores.addNode(41, "Bob");
		scores.addNode(713,"Allen");
		scores.addNode(71, "Alex");
		scores.addNode(123,"Zoey");
		
		scores.sort();
		scores.print();
		scores.remove("Jeff");
		System.out.println("New Top Scores:");
		scores.print();
		
	}
	static class Node{
		int score;
		String name;
		Node next;
		
		public Node(int score, String name) {
			this.score = score;
			this.name = name;
			next = null;
		}
	}
	static class Scoreboard{
		public Node head = null;
		public Node tail = null;
		//adds a node to the linked list
		public void addNode(int score, String name) {
			Node newNode = new Node (score, name);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				Node temp = new Node(score, name);
				tail.next = temp;
				tail = temp;
			}
		}
		//sorts the linked list in descending order
		public void sort() {
			Node first = head;
			Node index;
			int temp;
			String temp2;
			
			if(head == null) {
				return;
			}
			else {
				while(first!= null) {
					index = first.next;
					while(index != null) {
						if(first.score < index.score) {
							temp = first.score;
							first.score=index.score;
							index.score = temp;
							temp2 = first.name;
							first.name=index.name;
							index.name = temp2;
						}
						index = index.next;
					}
					first = first.next;
				}
			}
		}
		// deletes a node from the linked list
		public void remove(String name) {
			Node temp = head;
			Node previous = null;
			// if linked list is empty then return
			if(temp == null) {
				return;
			}
			//checks if the head is the node with the value to be deleted
			else if(temp != null && temp.name == name) {
				head = temp.next;
				return;
			}
			//searches for the node to delete in the linked list
			while(temp.name != name) {
				previous = temp;
				temp = temp.next;
			}
			//unlinks the node
			previous.next = temp.next;
		}
		
		 public void print() {  
			 Node first = head; 
		     int index = 0;

		     while(first != null && index!=10) {  
		         System.out.print(first.score + " "+ first.name);  
		         System.out.println();
		         first = first.next; 
		         index++;
		        }  
		        System.out.println();  
		    }  
	}
}
	