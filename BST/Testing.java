public class Test {
    public static void main(String[] args) {
        int[] a = {37,24,42,7,32,40,55,2,48,90};
        int[] b = {37,24,42,2,1,4,5};
        
        BSTSet tree = new BSTSet(a);
        System.out.printf("DEFAULT TREE\n");
        tree.printBSTSet();
        
        int v=34;
        System.out.printf("\nCheck if %d is in tree\n",v);
        if(tree.isIn(v)==true)
            System.out.printf("%d is in the tree\n",v);
        else
            System.out.printf("%d is NOT in the tree\n",v);//
        
        int x = 91;
        System.out.printf("\nAdding %d to the tree - not in tree\n",x);// 
        tree.add(x);
        tree.printBSTSet();
        
        x = 48;
        System.out.printf("\nAdding %d to the tree - already in tree\n",x); 
        tree.add(x);
        tree.printBSTSet();
        
        x = 42;
        System.out.printf("\nRemoving %d from tree - in tree: ",x); 
        boolean cut = tree.remove(x);
        System.out.println(cut);
        tree.printBSTSet();
        
        x = 1023;
        System.out.printf("\nRemoving %d from tree - not in tree: ",x); 
        cut = tree.remove(x);
        System.out.println(cut);
        tree.printBSTSet();
        System.out.printf("\n");
        
        BSTSet tree2 = new BSTSet(b);
        System.out.printf("UNION between these 2 sets\n");
        tree.printBSTSet();
        tree2.printBSTSet();
        BSTSet tree3 = tree.union(tree2);
        System.out.printf("Union set\n");
        tree3.printBSTSet();
        System.out.printf("\n");
        
        System.out.printf("INTERSECTION between these 2 sets\n");
        tree.printBSTSet();
        tree2.printBSTSet();
        BSTSet tree4 = tree.intersection(tree2);
        System.out.printf("Intersection set\n");
        tree4.printBSTSet();
        System.out.printf("\n");
        
        System.out.printf("DIFFERENCE between these 2 sets\n");
        tree.printBSTSet();
        tree2.printBSTSet();
        BSTSet tree5 = tree.difference(tree2);
        System.out.printf("Difference set\n");
        tree5.printBSTSet();
        System.out.printf("\n");
        
        System.out.printf("Size of set\n");
        tree.printBSTSet();
        System.out.printf("Size = %d",tree.size());
        System.out.printf("\n");
        
        System.out.printf("\nHeight of set\n");
        tree.printBSTSet();
        System.out.printf("Height = %d",tree.height());
        System.out.printf("\n");
        
        System.out.println("\nNON RECURSIVE PRINTING");
        tree.printNonRec();
	}

}

    
    
