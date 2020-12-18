public class TestFile {

    public static void main(String[] args) {
        
        System.out.println("Integer Generation");
        HugeInteger a= new HugeInteger(12);
        System.out.println("a = "+a.toString());
        HugeInteger b = new HugeInteger(15);
        System.out.println("b = "+b.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("String Generation");
        a = new HugeInteger("12345678933438493848948");
        System.out.println("a = "+a.toString());
        b = new HugeInteger("");
        System.out.println("b = "+b.toString());
        HugeInteger c = new HugeInteger("-0034343");
        System.out.println("c = "+c.toString());
        System.out.println("");
        
        //Equal sizes
        System.out.println("Equal Sizes Addition");
        HugeInteger num1 = new HugeInteger(9);
        HugeInteger num2 = new HugeInteger("999999999");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        HugeInteger addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("num1>num2 Addition");
        num1 = new HugeInteger(10);
        num2 = new HugeInteger("0001");
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
        
        System.out.println("-------------------------");
        
        System.out.println("num1<num2 Addition");
        num1 = new HugeInteger(12);
        num2 = new HugeInteger(10);
        System.out.println("num1 = "+num1.toString());
        System.out.println("num2 = "+num2.toString());
        addition = num1.add(num2);
        System.out.println("addition = "+addition.toString());
       
        }
    
}
