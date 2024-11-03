import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        //Priority queue
        Deque<Integer> sd=new ArrayDeque<>();
        Deque<Integer> sd1=new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
      pq.add(1);

      pq.add(4);
      pq.add(5);
      pq.add(2);
      pq.add(3);
        System.out.println("\nData in Priority Queue is:\n");
        System.out.println(pq);
        System.out.println("\nPq peek "+pq.peek());
        System.out.println("\npq.poll() "+pq.poll());
        System.out.println("\nPq peek "+pq.peek());

        ArrayList<Integer> list = new ArrayList<>(pq);

        System.out.println("Data in the ArrayList is:\n");
//        for (int i = 0; i < 5; i++) {
//            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
//            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
//            System.out.println("i = " + list.get(i));
//        }
        while (pq.size() > 0) {
            System.out.println(pq);
            System.out.println(pq.poll());

        }
        list.sort(Comparator.reverseOrder());
       // list.sort(Comparator.comparing(Integer::intValue));
        System.out.println("\nData in List is:\n"+list);
    }
}