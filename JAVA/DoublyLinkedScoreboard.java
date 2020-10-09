
public class DoublyLinkedScoreboard {
	public static void main(String[] args) {
		Scoreboard scores = new Scoreboard();//1
		System.out.println("Top Scores:"); //1 
		scores.addNode(1, "Jeff");//4 operations or 7 operations or O(1)
		scores.addNode(100,"Jake");//4 operations or 7 operations or O(1)
		scores.addNode(6, "Zach");//4 operations or 7 operations or O(1)
		scores.addNode(513,"Tyler");//4 operations or 7 operations or O(1)
		scores.addNode(591, "Triss");//4 operations or 7 operations or O(1)
		scores.addNode(15,"Dan");//4 operations or 7 operations or O(1)
		scores.addNode(41, "Bob");//4 operations or 7 operations or O(1)
		scores.addNode(713,"Allen");//4 operations or 7 operations or O(1)
		scores.addNode(71, "Alex");//4 operations or 7 operations or O(1)
		scores.addNode(123,"Zoey");//4 operations or 7 operations or O(1)
		scores.sort();//6 operations or 9n^3 + 5 operations. O(n^3) or O(1)
		scores.print();//18 operations or O(1) 
		scores.remove("Alex"); //2n + 7 or 2n +9 operations or O(n)
		System.out.println("New Top Scores:"); //1
		scores.print();//18 operations or O(1) 
	} // O(n^3)
	//node in a double linked list
	static class DoubleNode{
		int score;//1
		String name;//1
		DoubleNode next;//1
		DoubleNode previous;//1
		
		public DoubleNode(int score, String name) {
			this.score = score;//1
			this.name = name;//1
			next = null;//1
			previous = null;//1
		}
	}// 8 Operations O(1)
	//Initializes the scoreboard
	static class Scoreboard{
		public DoubleNode head; // 1
		public DoubleNode tail;// 1
		
		//adds a node to the linekd list
		public void addNode(int score, String name) {
			//if the head of the linked list is empty, add the new node here
			if(this.head == null) { //2
			this.head = new DoubleNode(score, name); //1
			this.tail = this.head; //1
			}
			//if the head of the linked lsit is not empty, add the new node at the tail
			else { //1
				DoubleNode temp = new DoubleNode(score, name);//1
				tail.next = temp;//1
				temp.previous = tail;//1
				tail = temp;//1
			}
		}//4 operations or 7 operations or O(1)
		
		//prints the different nodes
		 public void print() {  
			 DoubleNode first = head;  //1
		     int index = 0; //1
		     //prints each node one by one
		     while(first != null && index!=10) { //10  
		         System.out.print(first.score + " "+ first.name);   //1
		         System.out.println(); //1
		         first = first.next; //2
		         index++; //2
		        }  
		        System.out.println(); //1 
		    }//19 operations or O(1)
		 
		 //removes a node from the listed list
		 public void remove(String n) {
			 DoubleNode current = head;//1
			 DoubleNode temp = null;//1
			 //if the head is the target of removal then remove the head
			 if(head.name == n) {//2
				 head.next.previous = null;//1
				 head = head.next;//1
			 }
			 // look for the target in the linked list
			 while(current.next != null && current.name != n) { //n
				 temp = current;//1
				 current = current.next;//1
			 }
			 //removes the target from the linked list
			 if(current.name == n) {//2
				 temp.next = temp.next.next;//1
			 }
				 
		 }//2n + 7 or 2n +9 operations or O(n)
		 
			//sorts the linked list in descending order
			public void sort() {
				DoubleNode first = head; //1
				DoubleNode index; //1
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
		
	}
}
