public class MyStack {
    private TNode[] items;
    private int topIndex=-1;
    
    public MyStack(){
        this(100);
    }
    public MyStack(int n){
        items = new TNode[n];//create array of type TNode with size n
    }
    
    public boolean isEmpty(){
        return(topIndex<0);
    }
    
    public int size(){
        int amt=0;
        for(int i=0;i<items.length;i++){
            amt++;
        }
        return amt;
    }
    
    public void push(TNode e){
        if(topIndex==items.length-1){
            TNode[] newArr = new TNode[2*items.length];
            for(int i=0;i<items.length;i++){
                newArr[i] = items[i];
            }
            items = newArr;
        }//end of if
        items[++topIndex]=e;
    }
    
    public TNode top(){
        if(isEmpty()){
            return null;
        }
        else
            return(items[topIndex]);
    }
    
    public TNode pop(){
        if(isEmpty()){
            return null;
        }
        else{
        TNode temp = items[topIndex];
        items[topIndex--]=null;
        return temp;
        }
    }
            
}//end of stack
