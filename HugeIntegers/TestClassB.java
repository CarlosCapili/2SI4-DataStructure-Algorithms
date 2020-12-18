public class TestFile {

    public static void main(String[] args) {
        
        HugeInteger a;
        //create HugeInteger b;
        //make try and catches
        
        System.out.println("Integer Generation");
        try{
            a= new HugeInteger(-12);
            System.out.println("a = "+a.toString());
        }catch(IllegalArgumentException e){
            System.out.println("a = "+e);  
        }
        HugeInteger b = new HugeInteger(15);
        System.out.println("b = "+b.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("String Generation");
        try{
            a = new HugeInteger("12a345678933438493848948");
            System.out.println("a = "+a.toString());
        }catch(IllegalArgumentException e){
            System.out.println("a = "+e);
        }
        b = new HugeInteger("");
        System.out.println("b = "+b.toString());
        HugeInteger c = new HugeInteger("-000003432643");
        System.out.println("c = "+c.toString());
        System.out.println("");
        
        //Equal sizes
        System.out.println("Equal Sizes Addition");
        HugeInteger num1 = new HugeInteger("999999999");
        HugeInteger num2 = new HugeInteger("-999999998");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        HugeInteger addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("num1>num2 Addition");
        num1 = new HugeInteger(10);
        num2 = new HugeInteger("");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("num1<num2 Addition");
        num1 = new HugeInteger("-999");
        num2 = new HugeInteger("-99");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
       
       
        System.out.println("-------------------------");
        
        System.out.println("Addition One Negative One Positive");
        num1 = new HugeInteger("10000000");
        num2 = new HugeInteger("-50000000000");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
       // num2.compareTo(num1);
       
        System.out.println("-------------------------");
        
        System.out.println("Addition One Negative One Positive Switched");
        num1 = new HugeInteger("-10000000");
        num2 = new HugeInteger("50000000000");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
       // num2.compareTo(num1);
       
        System.out.println("-------------------------");
        
        System.out.println("Addition Both Negative");
        num1 = new HugeInteger("-34543958918");
        num2 = new HugeInteger("-3857384758374583");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
       // num2.compareTo(num1);
       
       
       
        System.out.println("-------------------------");
        
        System.out.println("Subtraction Both Positive");
        num1 = new HugeInteger("999");
        num2 = new HugeInteger("-99");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num1.subtract(num2);
        System.out.println("Difference = "+addition.toString());
      //  System.out.println(num1.compareTo(num2));
      
        System.out.println("-------------------------");
        
        System.out.println("Subtraction num1=num2 ");
        num1 = new HugeInteger("1000000000000");
        num2 = new HugeInteger("0001000000000000");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num1.subtract(num2);
        System.out.println("Difference = "+addition.toString());
      //  System.out.println(num1.compareTo(num2));
      
       System.out.println("-------------------------");
        
        System.out.println("Subtraction num1<num2 ");
        num1 = new HugeInteger("9938483");
        num2 = new HugeInteger("0001000000000000");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num1.subtract(num2);
        System.out.println("Difference = "+addition.toString());
      //  System.out.println(num1.compareTo(num2));
      
        System.out.println("-------------------------");
        
        System.out.println("Subtraction One negative one positive ");
        num1 = new HugeInteger("999999999");
        num2 = new HugeInteger("999999998");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num1.subtract(num2);
        System.out.println("Difference = "+addition.toString());
      //  System.out.println(num1.compareTo(num2));
      
      
       System.out.println("-------------------------");
        
        System.out.println("Multiply Positive");
        num1 = new HugeInteger("99");
        num2 = new HugeInteger("-0");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num2.multiply(num1);
        System.out.println("Product = "+addition.toString());
        
                System.out.println("-------------------------");
        
        System.out.println("Multiply Negative");
        num1 = new HugeInteger("-00002343445454545");
        num2 = new HugeInteger("-3453503453452");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num2.multiply(num1);
        System.out.println("Product = "+addition.toString());
        
                System.out.println("-------------------------");
        
        System.out.println("Multiply Negative and Positive");
        num1 = new HugeInteger("-2344359679");
        num2 = new HugeInteger("0003430");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num2.multiply(num1);
        System.out.println("Product = "+addition.toString());
        
                        System.out.println("-------------------------");
        
        System.out.println("Multiply By 0");
        num1 = new HugeInteger("-2344359679");
        num2 = new HugeInteger("-0");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition= num2.multiply(num1);
        System.out.println("Product = "+addition.toString());
        
         System.out.println("-------------------------");
        
        System.out.println("CompareTo");
        num1 = new HugeInteger("99");
        num2 = new HugeInteger("99");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        
        int comp= num1.compareTo(num2);
        
        if(comp==1){
            System.out.println("num1 is greater than num2");
        }
        else if(comp==0){
            System.out.println("num1 is equal to num2");
        }
        else{
            System.out.println("num1 is less than num2");
        }
    }//end of main
}///end of class
