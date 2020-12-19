public class MaxHeap {
    private Integer[] heap;//stores the heap
    private int heapSize;//tracks array size
    private int items;//tracks number of elements in array
    
    public MaxHeap(int size){
        this.heapSize = size;
        this.heap = new Integer[size];//creates empty array with specific size;
    }
    
    public MaxHeap(Integer[] someArray){
        this.heapSize=someArray.length;
        this.items = someArray.length; //number of items in the array is the same as the length
        this.heap = someArray;
        buildHeap(this.heap,this.items);//creates MaxHeap
    }
    
    //accessors
    public Integer[] getHeap(){return heap;}
    public int getSize(){return items;}
    public int getCapacity(){return heapSize;}
    
    private void percolateUp(Integer[] arr, int index){
        int parent = index;//define parent node for subtree
        int left = 2*index+1;//define left and right child of parent node
        int right = 2*index+2;
              
        if(left<this.items && arr[left]>arr[parent]){//check if indexes are within bounds and if children are greater in value than the parent
            parent = left;
        }
        
        if(right<this.items && arr[right]>arr[parent]){
            parent = right;
        }
        
        if(parent!=index){
            int temp = this.heap[index];//save original parent value
            this.heap[index] = this.heap[parent];//replace the bigger value to the parent node
            this.heap[parent] = temp;
            percolateUp(arr,parent);//repeat process for subtrees
        }
    }//end of percolateUp
    
     private void buildHeap(Integer[] arr,int item){
        for(int i=(item/2)-1;i>=0;i--){//Divided by 2 to obtain last node with children on it for comparison           
            percolateUp(arr,i);//checks each node at each level except last level
        }
    }//end of createMaxHeap
        
    public void insert(int n){
        this.items++;//indicate number of items in array is increasing
        Integer[] newArr;
        
        if(this.items>this.heapSize){//check if the number of items exceeds the array size, if so create an array twice the size
            newArr = new  Integer[2*heapSize];
            int index = 0;//used to keep track of this heap size
            
            for(int i=0;i<newArr.length;i++){
                if(index!=this.heapSize){
                    newArr[i]=this.heap[index++];//transfer contents into new array
                }
            }
          
            newArr[this.heapSize]=n;//place value in the index next to the last element
            this.heapSize = 2*this.heapSize;//set size of array to double the original size
            this.heap = newArr;
            
            buildHeap(this.heap,this.items);//rebuild a Max Heap   
        }
        else{
            this.heap[this.items-1]=n;//place at last spot
            buildHeap(this.heap,this.items);//rebuild a Max Heap
        }
    }//end of insert
    
    public int deleteMax(){
        this.items--;//decrease amount of items in array
        int max = this.heap[0];//root node
        int temp = this.heap[items];//take last element in array
        
        this.heap[0] = temp;//replace first node with last element
        this.heap[items] = null;
        buildHeap(heap,this.items);//rebuild heap
        
        return max;
    }//end of findMax
    
     public static void heapsort(Integer[] arrayToSort){
         MaxHeap sort = new MaxHeap(arrayToSort);
         int end = arrayToSort.length-1;//pointer to the last index in array
         int max=0;//used to hold max value in array
         
         while(end!=0){//repeat deleteMax until first element
            max = sort.deleteMax(); //remove max
            arrayToSort[end--]=max; //place at the end of the array
         }
   
        for(int i=0;i<arrayToSort.length/2;i++){//swap array values in place until midpoint is reached
           int temp = arrayToSort[i];
           arrayToSort[i] = arrayToSort[arrayToSort.length-i-1];
           arrayToSort[arrayToSort.length-1-i] = temp;
        }
    }//end of heapsort
    
    public String toString(){//add commas in between
        String arr="";
        for(int i=0;i<this.heapSize;i++){
           if(this.heap[i]==null) 
                continue;
           if(i!=this.items-1)
                arr+=this.heap[i]+", ";
           else
                arr+=this.heap[i];
        }
        return arr;
    }//end of toString
    
}//end of MaxHeap
