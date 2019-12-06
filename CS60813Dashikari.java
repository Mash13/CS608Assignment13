import java.util.LinkedList;

public class CS60813Dashikari {
    private int n;
    private LinkedList<Integer> state;

    public CS60813Dashikari(int n){
        this.n = n;
        this.state = new LinkedList<Integer>();
    }
    public CS60813Dashikari(){
        this(8);
    }

    private boolean isValid(LinkedList<Integer> state){
        if(state.size() == 1){
            return true;
        }


        int state_size = state.size() - 1;
        int last_x = state_size;
        int last_y = state.get(last_x);
        for(int i = 0; i < state_size; i++){

            //check horizontal conflict while we are at it:
            if(state.getLast() == state.get(i)){
                return false;
            }

            int xdiff = Math.abs(last_x - i);
            int ydiff = Math.abs(last_y - state.get(i));

            if(xdiff == ydiff){
                return false;
            }
        }
        return true;
    }

    private LinkedList<Integer> compute(LinkedList<Integer> state){

        if(this.n == state.size()){
            return state;
        }

        for(int i = 0; i < this.n; i++){
            
            //push i onto the stack

            state.add(i);

            

            if(isValid(state)){


                LinkedList<Integer> tmp = this.compute(state);
                if(tmp != null){

                    return tmp;
                }
            }


            state.removeLast();

        }

        return null;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(this.state.toString());

        for(int i = 0; i < this.n; i++){
            //s.append("\n");
            //for(int z = 0; z < this.n; z++){s.append("---");}
            s.append("\n");
            for(int j = 0; j < this.n; j++){
                if(this.state.get(i) == j){
                    s.append("| *");
                }
                else{
                    s.append("|  ");
                }
            }
            s.append("|");
        }
        return s.toString();
    }
    
    public void solve(){
        this.state = compute(new LinkedList<Integer>());
    }
    
    public static void main(String args[]){
    	Queens queens = new Queens(8);
    	queens.solve();
            
    	System.out.println(queens);
	}
    
    
}