// MACID: capilc1
// STUDENT#: 400184894
//**********************************************************************************
public class BSTSet {
    private TNode root;
    
    public BSTSet(){
        root = null;
    }
    
    public BSTSet(int[] input){
        if(input==null || input.length==0){
            root = null;
        }
        else{
            int[] sortArr;//holds sorted array with no repetitions
            int temp=0;//holds element to sort array;
            int repetitions=0;//counts the amount of repetitions in the input array

            for(int j=0;j<input.length;j++){//sorts array in increasing order
                for(int i=j+1;i<input.length;i++){
                    if(input[j]>input[i]){
                        temp = input[j];
                        input[j] = input[i];//switch with element with smallest
                        input[i] = temp;//replace with smallest element
                    }
                    if(input[j]==input[i]){
                        repetitions++;//increase amount of repetitions found
                        input[j]=-1;//set to -1
                    }
                }
            }

            sortArr = new int[input.length-repetitions];
            int index=0;

            for(int i=0;i<input.length;i++){//transfer sorted array into new array with no repetitions
                if(input[i]==-1){
                    continue;
                }
                sortArr[index]=input[i];
                index++;//increment to go to next place in new array with no repetitions
            }
            
           root = CreateBST(sortArr,0,sortArr.length-1);//create binary tree using recursion
           
        }//end of else
    }
    
    private TNode CreateBST(int[] array, int left, int right){
        
        if(left>right){//if bounds cross each other 
            return null;
        }
        
        int middle = (left+right)/2;//take the middle element
        TNode node = new TNode(array[middle],null,null); //take middle element
        
        node.right = CreateBST(array,middle+1,right); //creates right subtree of root
        node.left = CreateBST(array,left,middle-1); //creates left subtree of root
          
        return node;
    }//end of CreateBST
    
    public int size(){
        return nodeCount(root);
    }//end of size
    
    private int nodeCount(TNode n){
        if(n==null){//if set is empty
            return 0;
        }
        else{
            return 1+nodeCount(n.left)+nodeCount(n.right);//counts left nodes first then right for each subtree encountered
        }
    }//end of nodeCount
    
    public int height(){
        if(root==null){
            return -1;
        }
        else{
            return maxDepth(root);
        }
    }//end of height
    
    private int maxDepth(TNode n){
        if(n==null){
            return -1;
        }
        else{
            int lDep = maxDepth(n.left);//recursively find the height of each subtree
            int rDep = maxDepth(n.right);
            
            if(lDep>rDep){
                return (lDep+1);
            }
            else{
                return (rDep+1);
            }
        }
    }//end of maxDepth
    
    public boolean isIn(int v){
       TNode node = root;//used to traverse tree
       
       while(node!=null){ //compare value of nodes to check whether to traverse left or right of tree
           if(v<node.element){
               node = node.left;
           }
           else if(v>node.element){
               node = node.right;
           }
           else{
               return true; //value found
           }
       }//end of while

        return false;
    }//end of isIn 
    
    public void add(int v){
        if(isIn(v)==false){ //only add if it is not already in tree
            
            TNode node = root; //traverses tree
            TNode PNode = null; //keep track of parent node
            
            while(node!=null){//loop will insert the node as a leaf
                PNode = node;
                
                if(v<node.element){
                    node = node.left;
                }
                else{
                    node = node.right;
                }
            }//end of while   
                
            if(PNode==null){//if tree is empty then place at root
                root = new TNode(v,null,null);
            }
            else if(v>PNode.element){ 
                PNode.right = new TNode(v,null,null);//if v is bigger then make it the right child of the current node
            }
            else{ 
                PNode.left = new TNode(v,null,null);//if v is less then make it the left child of the current node
            }
        }//end of if
    }//end of add
    
    public boolean remove(int v){
        if(isIn(v)==true){
          //  System.out.println("FOUND IN TREE");
            TNode current = root;
            TNode node = null; //used to traverse throught the tree
            TNode PNode = null; //used to identify parent node
            
            while(current.element!=v){//find node 
                PNode = current;//keep track of parent node
                
                if(v>current.element){
                    current = current.right;
                }
                else{
                    current = current.left;
                }
           
            }//end of while
            
            if(current.left!=null && current.right!=null){ //if the node has 2 children
      
                TNode parent = null;//used to track parent of node variable
                node = current.left;//take the largest node on the left side and replace it with the current node 
                
                while(node.right!=null){
                    parent = node;//keeps track of parent
                    node = node.right;//find largest node in left subtree
                }
           
                current.element = node.element; //set largest element in left sub tree to be new parent
                    
                if(node.left!=null){
                    parent.right = node.left; //point to next node
                }
                else{
                    parent.right = null;
                }
            
            }
            else if(current.left!=null || current.right!=null){ //if the node has 1 child

                node = current;
                
                if(PNode.left!=null && v==PNode.left.element){
   
                    if(current.left!=null){ //check left and right leaves
                        node = current.left;
                    }
                    else{
                        node = current.right;
                    }
                    
                    PNode.left = node; //point to next node
                }
                else{
          
                    if(current.left!=null){
                        node = current.left;
                    }
                    else{
                        node = current.right;
                    }
                    
                    PNode.right = node; //point to next node
                }
            }
            else{ //remove a leaf

                if(PNode.left!=null && PNode.left.element == v)
                    PNode.left = null;
                else
                    PNode.right = null;
            }
            return true;
        }
        return false;
    }//end of remove
    
    public BSTSet union(BSTSet s){
        int[] arr1 = arraystart(root);
        int[] arr2 = arraystart(s.root);
        int[] combined = new int[arr1.length+arr2.length];
        
        int index=0;//keeps track of combined array index
        
        for(int i=0;i<arr1.length;i++){ //transfer elements into combined array
            combined[index++]=arr1[i];
        }
        
        for(int j=0;j<arr2.length;j++){
            combined[index++]=arr2[j];
        }
        
        BSTSet union = new BSTSet(combined); //combine the array since the constructor will not allow repetitions
        return union;    
    }//end union
    
    public BSTSet intersection(BSTSet s){
        if(s.root==null){
            return this; //if s is empty then return this
        }
        
        int[] arr1 = arraystart(s.root);
        int[] arr2 = new int[arr1.length];
        int[] combined;
        int totalSize=0;
        
        for(int i=0;i<arr1.length;i++){
            if(isIn(arr1[i])==true){
                totalSize++; //find how many elements are in both sets
            }
        }
        
        int index=0;
        combined = new int[totalSize];//create array to hold similar elements
        
        for(int i=0;i<arr1.length;i++){
            if(isIn(arr1[i])==true){
                combined[index++]=arr1[i];//transfer elements that are similar into new array
            }
        }
        
        BSTSet intersection = new BSTSet(combined);
        return intersection;
    }//end of intersection
    
    public BSTSet difference(BSTSet s){
        int[] arr1 = arraystart(root);
        int[] arr2 = arraystart(s.root);
        int[] combined;
        int totalSize=0;
     
        for(int i=0;i<arr1.length;i++){
            if(s.isIn(arr1[i])==false){//check what is not in the passed BST
                totalSize++;
            }
        }
        
        int index=0;
        combined = new int[totalSize];
        
        for(int i=0;i<arr1.length;i++){//take what is in this tree but not in the passed tree
            if(s.isIn(arr1[i])==false){
                combined[index++]=arr1[i];
            }
        }
        
        BSTSet difference = new BSTSet(combined);
        return difference;
    }//end of difference
    
    private int[] arraystart(TNode n){//starts array
        int size1=nodeCount(n);
        int i=0;
        int set[]=new int[size1];
        arrayFill(set,n,i);
        return set;   
    }//end of arraystart
    
    private int arrayFill(int[] set, TNode n,int index){//fills array with elements
       if(n.left!=null){
           index=arrayFill(set,n.left,index);
       }
       if(n.right!=null){
           index=arrayFill(set,n.right,index);
       }
       set[index]=n.element;
       return index+1;
    }//end of arrayFill
   
    public void printBSTSet(){
        if(root==null)
            System.out.println("The set is empty");
        else{
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }   
    }//end of printBSTSet
    
    private void printBSTSet(TNode t){
        if(t!=null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ");
            printBSTSet(t.right);
        }
    }//end of printBSTSet 

    public void printNonRec(){
        TNode current=root;
        
        if(current==null){
            return;
        }
        
        MyStack s = new MyStack(100);
        
        while(current!=null){
         //   System.out.println("CURRENT ELEMENT = "+current.element);
            s.push(current);
            current=current.left;
        }
        
        while(s.size()>-1){
            //System.out.printf("size=%d/n",s.size());
           try{
               TNode t = s.pop();
          
               System.out.print(t.element+", ");
            
               if(t.right!=null){//check right subtree
                   TNode temp=t.right;
                   while(temp!=null){//take lowest element in left subtree
                       s.push(temp);
                       temp=temp.left;
                    }//end of while
                }//end of if
               
            }catch (NullPointerException e){break;}
        }//end of while
        
        System.out.println("");
    }//end of printNonRec
    
    
}//end of BSTSet


