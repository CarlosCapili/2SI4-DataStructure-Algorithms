
public class MaxHeapTest {

    public static void main(String[] args) {
       Integer[] arr = {3,10,4,5,6,7,8,9,5};
        MaxHeap test = new MaxHeap(arr);
        
        System.out.println("MAXHEAP");
        System.out.println(test.toString());
        System.out.println("");
        
        System.out.println("INSERTING 78");
        test.insert(78);
        System.out.println(test.toString());
        System.out.println("");
        
        System.out.println("INSERTING 89");
        test.insert(89);
        System.out.println(test.toString());
        System.out.println(""); 
        
        System.out.println("DELETING MAX");
        test.deleteMax();
        System.out.println(test.toString());
        System.out.println("");
        
        System.out.println("INSERTING -54");
        test.insert(-54);
        System.out.println(test.toString());
        System.out.println(""); 
        
        System.out.println("INSERTING 20");
        test.insert(20);
        System.out.println(test.toString());
        System.out.println(""); 
        
        System.out.println("HEAP SIZE = "+test.getCapacity());  
        System.out.println("ITEMS SIZE = "+test.getSize ());       
        System.out.println("");
          
        System.out.println("HEAP SORT");
        Integer[] arr2 = {23,24,25,78,90,1,34,67,78,55,23,98,45};
        System.out.println("BEFORE");
        for(int i=0;i<arr2.length;i++){
            if(i==arr2.length-1)
                System.out.println(""+arr2[i]);
            else
                System.out.printf("%d, ",arr2[i]);
        }
        
        MaxHeap.heapsort(arr2);
        
        System.out.println("AFTER");
          for(int i=0;i<arr2.length;i++){
            if(i==arr2.length-1)
                System.out.println(""+arr2[i]);
            else
                System.out.printf("%d, ",arr2[i]);
        }
    }
}
