
public class DoublyLinkedScoreboard {
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
		scores.remove("Alex");
		System.out.println("New Top Scores:");
		scores.print();
	}
	
	static class DoubleNode{
		int score;
		String name;
		DoubleNode next;
		DoubleNode previous;
		
		public DoubleNode(int score, String name) {
			this.score = score;
			this.name = name;
			next = null;
			previous = null;
		}
	}
	static class Scoreboard{
		public DoubleNode head;
		public DoubleNode tail;
		
		public void addNode(int score, String name) {
			if(this.head == null) {
			this.head = new DoubleNode(score, name);
			this.tail = this.head;
			}
			else {
				DoubleNode temp = new DoubleNode(score, name);
				tail.next = temp;
				temp.previous = tail;
				tail = temp;
			}
		}
		 public void print() {  
			 DoubleNode first = head; 
		     int index = 0;

		     while(first != null && index!=10) {  
		         System.out.print(first.score + " "+ first.name);  
		         System.out.println();
		         first = first.next; 
		         index++;
		        }  
		        System.out.println();  
		    }
		 public void remove(String n) {
			 DoubleNode current = head;
			 DoubleNode temp = null;
			 if(head.name == n) {
				 head.next.previous = null;
				 head = head.next;
			 }
			 while(current.next != null && current.name != n) {
				 temp = current;
				 current = current.next;
			 }
			 if(current.name == n) {
				 temp.next = temp.next.next;
			 }
				 
		 }
			public void sort() {
				DoubleNode first = head;
				DoubleNode index;
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
		
	}
}
