package cce105;

import java.util.*;
public class lab {
    static Scanner sc = new Scanner(System.in);
    static Queue<String> queue = new LinkedList<>();
    public static void main(String[] args) {
    	
        int choice;
        do {
            System.out.println("1. Add Elements to Queue");
            System.out.println("2. Display Queue");
            System.out.println("3. Generate Permutations");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    generatePerm();
                    break;
                case 4:
                	System.out.println("Exit. . . ");
                	break;
            }
        } while (choice != 5);
    }

    static void add() {
        System.out.print("Enter five elements: ");
        int numofelements = sc.nextInt();
        sc.nextLine();
 
      for(int i = 1; i <= numofelements; i++) {
            String blank = "";

            while (blank.isEmpty()) {
                System.out.print("Enter char: ");
                blank = sc.nextLine();
            }

            String single = String.valueOf(blank.charAt(0));
            queue.add(single);
        }
      	if(!queue.isEmpty()) {
      		queue.poll();
      		queue.poll();
      	}
      	System.out.println("Dequeuing elements. . .");
        System.out.println("Updated Queue: " + queue);
    }

    static void display() {
        if(queue.isEmpty()) {
            System.out.println("No queue inside");
        } else {
             System.out.println("Queue Contents: " + queue);
        }
    }

    static void generatePerm() {
        if(queue.isEmpty()) {
            System.out.println("The queue is empty!");
            return;
        }

        List<String> elements = new LinkedList<>(queue);
        int n = elements.size();

        System.out.print("Enter the elements to arrange: ");
        int r = sc.nextInt();
        sc.nextLine();

        if(r < 1 || r > n) {
            System.out.println("Invalid Input!");
            return;
        }

        System.out.println("Generated Permutations: ");
        Queue<String> workingQueue = new LinkedList<>();
        int count = 0;
        
        for(String element : elements) {
            workingQueue.add(element);
        }

        while(!workingQueue.isEmpty()) {
            String current = workingQueue.remove();
            if(current.length() == r) {
                System.out.println(current);
                count++;
            } else {
                for(String nextElement : elements) {
                    if(!current.contains(nextElement)) {
                        workingQueue.add(current + nextElement);
                    }
                }
            }
        }
        System.out.println("Total Permutations: " + count);
    }
}
