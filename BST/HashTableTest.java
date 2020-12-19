import java.util.Random;

public class TestHashTable {
    
    public static void main(String[] args) {
       
        System.out.println("Linear Probe Hash Table");
        HashTableLin hash1 = new HashTableLin(4,0.4); //randomly generate shit
        System.out.println("Current Table Size = "+hash1.getTableSize());
        hash1.insertCount(4);
        hash1.insertCount(11);
        hash1.insertCount(0);
        hash1.insertCount(9);
        hash1.insertCount(9);
        hash1.printKeysAndIndexes();
        hash1.insertCount(21);
        hash1.insertCount(22);    
        hash1.insertCount(23);   
        hash1.insertCount(44);  
        hash1.printKeysAndIndexes();
        hash1.insertCount(3);
        hash1.insertCount(12); 
        hash1.insertCount(109);
        hash1.insertCount(4); 
        hash1.insertCount(6); 
        System.out.println("\nNumber of keys inserted:" +hash1.getKeys());
        System.out.println("Max Load Factor: " +hash1.getMaxLF());
        System.out.println("Table Size:" +hash1.getTableSize());
        System.out.println("\nAll keys inserted:");
        hash1.printKeys();
        hash1.printKeysAndIndexes();
        
        int m=47,n=4;
        System.out.printf("Is %d in hash table?-",m);
        System.out.println(hash1.isIn(m));
        System.out.printf("Is %d in hash table?-",n);
        System.out.println(hash1.isIn(n));
        System.out.println("");
       
        System.out.println("Quadratic Probe Hash Table");
        HashTableQuad hash2 = new HashTableQuad(2,0.1);
        System.out.println("Current Table Size = "+hash2.getTableSize());
        hash2.insertCount(21);
        hash2.insertCount(0);
     hash2.printKeysAndIndexes();
     
        hash2.insertCount(42);
        hash2.printKeysAndIndexes();
        hash2.insertCount(84);
     
        hash2.insertCount(1024);
       
        System.out.println("\nNumber of keys inserted:" +hash2.getKeys());
        System.out.println("Max Load Factor: " +hash2.getMaxLF());
        System.out.println("Table Size:" +hash2.getTableSize());
        System.out.println("\nAll keys inserted:");
        hash2.printKeys();
        hash2.printKeysAndIndexes();
        
        m=0;n=109;
        System.out.printf("Is %d in hash table?-",m);
        System.out.println(hash2.isIn(m));
        System.out.printf("Is %d in hash table?-",n);
        System.out.println(hash2.isIn(n));
        System.out.println("");
        
        //average number of probes for successful search
        measureProbe();
        
        
        
    }//end of main 
    
    public static void measureProbe(){
        int random;//used to hold random num
        int countProbe=0;//used to count probes used
        double average=0, theory=0;//calculate probe averages
        Random rand = new Random();
        
        System.out.println("LINEAR TESTING\n");
        HashTableLin h1 = new HashTableLin(100000,0.1);
         theory = 0.5*(1+(1/(1-0.1)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h1.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.1");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h2 = new HashTableLin(100000,0.2);
         theory = 0.5*(1+(1/(1-0.2)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h2.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.2");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h3 = new HashTableLin(100000,0.3);
         theory = 0.5*(1+(1/(1-0.3)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h3.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.3");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h4 = new HashTableLin(100000,0.4);
         theory = 0.5*(1+(1/(1-0.4)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h4.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.4");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h5 = new HashTableLin(100000,0.5);
         theory = 0.5*(1+(1/(1-0.5)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h5.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.5");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h6 = new HashTableLin(100000,0.6);
         theory = 0.5*(1+(1/(1-0.6)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h6.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.6");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h7 = new HashTableLin(100000,0.7);
         theory = 0.5*(1+(1/(1-0.7)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h7.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.7");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h8 = new HashTableLin(100000,0.8);
         theory = 0.5*(1+(1/(1-0.8)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h8.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.8");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableLin h9 = new HashTableLin(100000,0.9);
         theory = 0.5*(1+(1/(1-0.9)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=h9.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.9");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
          /*System.out.println("QUADRATIC TESTING\n");
        HashTableQuad H1 = new HashTableQuad(100000,0.1);
         theory = 0.5*(1+(1/(1-0.1)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H1.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.1");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H2 = new HashTableQuad(100000,0.2);
         theory = 0.5*(1+(1/(1-0.2)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H2.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.2");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H3 = new HashTableQuad(100000,0.3);
         theory = 0.5*(1+(1/(1-0.3)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H3.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.3");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H4 = new HashTableQuad(100000,0.4);
         theory = 0.5*(1+(1/(1-0.4)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H4.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.4");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H5 = new HashTableQuad(100000,0.5);
         theory = 0.5*(1+(1/(1-0.5)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H5.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.5");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H6 = new HashTableQuad(100000,0.6);
         theory = 0.5*(1+(1/(1-0.6)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H6.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.6");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H7 = new HashTableQuad(100000,0.7);
         theory = 0.5*(1+(1/(1-0.7)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H7.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.7");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H8 = new HashTableQuad(100000,0.8);
         theory = 0.5*(1+(1/(1-0.8)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H8.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.8");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;
            
        HashTableQuad H9 = new HashTableQuad(100000,0.9);
         theory = 0.5*(1+(1/(1-0.9)));
            for(int i=0;i<100000;i++){
                random = rand.nextInt(100000001);//generate numbers between 0 - 100 000 000
                countProbe+=H9.insertCount(random);
            }//end of for
            average=(double)countProbe/100000;//probes divided by number of 
            System.out.println("Load Factor = 0.9");
            System.out.println("countProbe = "+countProbe);
            System.out.println("Average # of Probes = "+average);
            System.out.println("Theoretical # of Probes = "+theory+"\n");
            countProbe=0;    */
        
    }//end of measureProbe
    
}//end of class
