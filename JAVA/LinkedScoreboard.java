
public class LinkedScoreboard {
	public static void main(String[] args) {
		Scoreboard scores = new Scoreboard(); //1
		System.out.println("Top Scores:"); //1
		scores.addNode(1, "Jeff"); //5 or 6 operations or O(1)
		scores.addNode(100,"Vy"); //5 or 6 operations or O(1)
		scores.addNode(6, "Zach"); //5 or 6 operations or O(1)
		scores.addNode(513,"Tyler"); //5 or 6 operations or O(1)
		scores.addNode(591, "Triss"); //5 or 6 operations or O(1)
		scores.addNode(15,"Dan"); //5 or 6 operations or O(1)
		scores.addNode(41, "Bob"); //5 or 6 operations or O(1)
		scores.addNode(713,"Allen"); //5 or 6 operations or O(1)
		scores.addNode(71, "Alex"); //5 or 6 operations or O(1)
		scores.addNode(123,"Zoey"); //5 or 6 operations or O(1)
		
		scores.sort(); //6 operations or 9n^3 + 5 operations. O(n^3) or O(1)
		scores.print(); //18 operations or O(1) 
		scores.remove("Jeff"); //either 2n+3 or 6 operation so O(n) or O(1)
		System.out.println("New Top Scores:"); //1
		scores.print(); //19 operations or O(1) 
		
	} // O(n^3)
	
	//a node in a linked list
	static class Node{
		int score; //1
		String name; //1
		Node next; //1
		
		public Node(int score, String name) { 
			this.score = score; //1
			this.name = name; //1
			next = null; //1
		}
	}// 6 operations or O(1)
	//Initializes the scoreboard
	static class Scoreboard{
		public Node head = null; //1
		public Node tail = null; //1
		//adds a node to the linked list
		public void addNode(int score, String name) {
			Node newNode = new Node (score, name); //1
			//if the head of the linked list is empty, add the new node here
			if(head == null) { //2
				head = newNode; //1
				tail = newNode; //1
			}
			//if the head of the linked lsit is not empty, add the new node at the tail
			else { //1
				Node temp = new Node(score, name); //1
				tail.next = temp; //1
				tail = temp; //1
			}
		} //5 or 6 operations or O(1)
		
		//sorts the linked list in descending order
		public void sort() {
			Node first = head; //1
			Node index; //1
			int temp; //1
			String temp2; //1
			//checks if the head if empty
			if(head == null) { //1
				return; //1
			}
			else {
				//if the head isnt empty then, start selection sort. 
				while(first!= null) { // n
					index = first.next; // 1
					while(index != null) { // n
						if(first.score < index.score) { // n
							temp = first.score; // 1
							first.score=index.score; //1
							index.score = temp; //1
							temp2 = first.name; //1
							first.name=index.name; //1
							index.name = temp2; //1
						}
						index = index.next; //1
					} 
					first = first.next; //1 
				}
			}
		} // 6 operations or 9n^3 + 5 operations. O(n^3) or O(1)
		
		// deletes a node from the linked list
		public void remove(String name) {
			Node temp = head; //1 
			Node previous = null; //1 
			// if linked list is empty then return
			if(temp == null) { //1
				return; //1
			}
			//checks if the head is the node with the value to be deleted
			else if(temp != null && temp.name == name) { //1
				head = temp.next; //1
			}
			//searches for the node to delete in the linked list
			while(temp.name != name) { //n
				previous = temp; //1
				temp = temp.next; //1
			}
			//unlinks the node
			previous.next = temp.next; //1
		}// either 2n+3 or 6 operation so O(n) or O(1)
		
		//prints the different nodes
		 public void print() {  
			 Node first = head;  //1
		     int index = 0; //1
		     //prints each node one by one
		     while(first != null && index!=10) { //10  
		         System.out.print(first.score + " "+ first.name);   //1
		         System.out.println(); //1
		         first = first.next; //1
		         index++; //2
		        }  
		        System.out.println(); //1 
		    }//18 operations or O(1)  
	}
}
	