public class HashTableQuad {
    private int[] table;//stores keys 
    private int tableSize;//size of hash table
    private int keys=0;//keep track of number of keys in table
    private double loadFactor;
    private int probeCount=1;
    
    public HashTableQuad(int maxNum, double load){
        
        loadFactor = load;
        tableSize = (int)(maxNum/load);//takes the size of the hash table
       
        if(tableSize%2==0){//ensures the smallest prime number is taken
            tableSize++;//takes prime number
        }
        
        table = new int[tableSize];
        
        for(int i=0;i<tableSize;i++){//makes an empty hashtable using -1's
            table[i]=-1;
        }//end of for
        
    }
    
    public int getTableSize(){return tableSize;}
    public int getKeys(){return keys;}
    public double getMaxLF(){return loadFactor;}
    public int getProbeCount(){return probeCount;}
    
    public void insert(int n){
        int index = n%tableSize;
        int current=index;//used to refer back to orginal index
        int square = 1;//used for quadratic probing
        double exceedLF;//used to calculate the load factor
      
        if(isIn(n)==false){//insert if the key is not already there

            while(table[current]!=-1){//checks to see if spot is filled
                current=(index+(square*square))%tableSize;//go to next index
                square++;//go to next square prob value
                probeCount++;//increment probe tracker
            }//end of while
            
            table[current] = n;
            keys++;//update amount of keys in table
            //System.out.println("Probes to insert "+n+" is "+probeCount);
        }//end of if
        
        exceedLF = (double)keys/tableSize;//calculate load factor if exceeding max rehash table
        
        if(exceedLF>loadFactor){
            System.out.println("\nCurrent load factor is  "+exceedLF);
            System.out.println("Maximum Load Factor has been exceeded. Rehashing.");
            rehash();
        }
        
    }//end of insert
    
    private void rehash(){
       keys=0;//reset
       int tempSize=tableSize;//save previous size
       tableSize = tableSize*2;
       int[] temp = table;//saves previous hash
       //int[] newHash; 
       
        if(tableSize%2==0){//ensures the smallest prime number is taken
            tableSize++;//takes prime number
        }
        
        System.out.println("New Table Size is "+tableSize+"\n");    
        table = new int[tableSize];
    
        for(int i=0;i<tableSize;i++){//set all an emptyHash using -1's
            table[i]=-1;
        }//end of for
        
        for(int i=0;i<tempSize;i++){//transfer elements from old hash to new one
            if(temp[i]==-1)//skip empty places
                continue;
            insert(temp[i]);
        }//end of for
        
    }//end of rehash
    
    public boolean isIn(int n){
        int index = n%tableSize;//mod value
        int current = index;
        int square = 1;
        
        do{
            
            if(table[current]==n)
               return true;
            current=(index+(square*square))%tableSize;//stay within bounds
            square++;//increase probe
            
        }while(table[current]!=-1);//keep linear probing until it reaches an empty index and stops there
        
        return false;
    }//end of boolean isIn
    
    public int insertCount(int n){
        int probe;
        insert(n);
        probe = probeCount;
        probeCount=1;//reset
        return probe;
    }//end of insertCount
    
    public void printKeysAndIndexes(){
        System.out.println("\n\nHash Table Quadratic Probing");
        System.out.println("-------------------------------------------------------------");
        for(int i=0;i<tableSize;i++){
            if(table[i]==-1){//ignore empty indexes which are represented by -1
                System.out.printf("%d - \n",i);//only print elements in the hash table
                continue;
            }
            System.out.printf("%d - %d \n",i,table[i]);//only print elements in the hash table
        }//end of for
        System.out.println("-------------------------------------------------------------\n\n"); 
    }//end of printKeysAndIndexes
    
    public void printKeys(){
      
        for(int i=0;i<tableSize;i++){
            if(table[i]==-1)//ignore empty indexes which are represented by -1
                continue;
            System.out.printf("%d \n",table[i]);//only print elements in the hash table
        }//end of for
        
    }//end of printKeys
    
}//end of HashTableQuad
