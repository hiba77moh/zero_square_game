import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class algorithm {
    Queue<State> qu = new LinkedList<>();
    Stack<State> st = new Stack<>();



    public void BFS(State initial_state) {
        int v= 1;
        int p =0;
        ArrayList<State> visited = new ArrayList<>();
        qu.add(initial_state);

        while (!qu.isEmpty()) {
            State currentState = qu.poll();
            visited.add(initial_state);

            if (currentState.check_win()) {
                Stack<State> path = new Stack<>();
                while (currentState != null) {
                    path.add(currentState);
                    currentState = currentState.parent;
                }

                while (!path.isEmpty()) {
                    State state = path.pop();
//                    System.out.println(state); // Assuming a suitable toString() method in State
                    State.print_grid(state);
                    p++;
                }
                break;
            }

            for (State nextState : currentState.next_state(currentState)) {
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    v++;
                    nextState.parent = currentState; // Set the parent for path reconstruction
                    qu.add(nextState);
                }
            }
        }
        System.out.println("visited length : " +v);
        System.out.println("path length : " +p);


    }




}