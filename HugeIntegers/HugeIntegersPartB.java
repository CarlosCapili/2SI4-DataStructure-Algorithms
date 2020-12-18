import java.util.Random;

public class HugeInteger {
    private int[] ranNum;
    private boolean negative= false;//used to indicate if number is negative
    private static int methodcall=0;//used to check if calling another method like add or subtract so it does not loop
    
    public HugeInteger(String val)throws IllegalArgumentException{
       
        int index=0,control=0,checkZero=0;//checkZero is used to check amount of zeroes
   
        if(val.isEmpty()){//checks if string is empty and assigns ranNum as an empty array
            ranNum = new int[0];
        }
        else{
            if(val.charAt(0)==45){//checks if there is a minus sign
                negative=true;
            }//end of if
            
            for(int i=0;i<val.length();i++){//checks and throws exception
                if(val.lastIndexOf('-')!=0&&(val.charAt(i)<48||val.charAt(i)>57)){//checks if numbers are between 0-9 and if - anywhere but the first element
                    throw new IllegalArgumentException("Invalid characters detected. Only 0-9 are valid");
                }//end of if
            }//end of for
            
            if(negative==true){
                for(int i=1;i<val.length();i++){
                    if(val.charAt(i)-48==0&&control==0){
                        checkZero++;
                        continue;
                    }
                    control=1;//indicates all leading zeroes have been found
                }
                index=1+checkZero;
                
                ranNum = new int[val.length()-1-checkZero];//sets array to size of string,if there is a negative it will ignore extra char
            }
            else
            {
                 for(int i=0;i<val.length();i++){
                    if(val.charAt(i)-48==0&&control==0){
                        checkZero++;
                        continue;
                    }
                    control=1;//indicates all leading zeroes have been found
                }
                index=checkZero;
                ranNum = new int[val.length()-checkZero];
            }

            for(int i=0;i<ranNum.length;i++){
               
                ranNum[i]=val.charAt(index++)-48;//transfer char to array, subtract by 48 since it will convert the value to ascii code
            }//end of for
        }//end of else
    }
    
    public HugeInteger(int n)throws IllegalArgumentException{
        
            if(n<1){
                throw new IllegalArgumentException("Argument must be equal or greater than 1");
            }
       
        Random num = new Random();//create an instance of Random 
        
        ranNum = new int[n];//creates array ranNum of size n
        int rNum;//used to generate random num
      
        for(int i=0;i<n;i++){
          rNum=num.nextInt(10);//generates a random number between 0 and 9 and converts it to a string

          if(rNum==0&&i==0){//ensures 1st digit is not a 0
              rNum=num.nextInt(8)+1; //means the range of values will be 1 and 9
          }//end of if
     
          ranNum[i]=rNum;//assign random generated value in array
      
      }// end of for
    }
    
    public int[] getRanNum(){return ranNum;}//get method
    public void setNegative(boolean f){negative=f;}//set method
    public boolean getNegative(){return negative;}
    
    public HugeInteger add(HugeInteger h){
        String hugeInt="";//used to convert array into string
        int token=0;//used as an index for the smaller array
        int choose=0;//used to pick which condition to run h>RanNum or RanNum>h
        int length=ranNum.length;//length var is for the biggest array
        int flip=0;//used to indicate negative number
        int[] newHugeInt;
        int[] sameSize;//used to make h same size as the bigger array
        HugeInteger add;
   
        if(h.getNegative()==true&&getNegative()==true){//just add them then add a negative sign
            h.setNegative(false);
            setNegative(false);//make both positive and then just add them and add a negative sign
            flip=1;
        }
            
        if((h.getNegative()==true||getNegative() == true)&&methodcall!=1&&flip!=1){
            
            int checkNeg = compareTo(h);
            h.setNegative(false);
            setNegative(false);//make both positive and then just add them and add a negative sign
            
            methodcall=1;//control variable since if i do not add a condition like this it will not work. Why? I have no idea. 
            add = subtract(h);
            methodcall=0;//set back to 0 since it is a static of the class
            
            if(checkNeg+compareTo(h)==-2||checkNeg+compareTo(h)==2){
                add.setNegative(false);
            }
            else{
                add.setNegative(true);
            }
            return add;
        }
        
        /*
        Make arrays same size and add accordingly *UPDATE why did i do this the hard way???
        these conditional statements check the size of array and creates a new array of the same size as the bigger one
        while transferring the elements in the smaller array to the new one
        */
        
        if(ranNum.length>h.getRanNum().length){//checks which ranNum is smaller and takes length of array
            newHugeInt = new int[ranNum.length];//initializes newHugeInt to biggest array
            token=h.getRanNum().length-1;//used to index the smaller array
            choose=1;
        }
        else{//when h > ranNum or equal length
            newHugeInt = new int[h.getRanNum().length];//initializes newHugeInt to biggest array
            token=ranNum.length-1;//used to index smaller array
            length = h.getRanNum().length;//sets length to h which is the bigger array
        }
        sameSize = new int[length];//generates array of same size as the bigger array
   
        for(int i=length-1;i>=0;i--){//for loop is for transferring smaller array into bigger array
            if(token<0){//assigns 0 for empty values once all values are transferred
                sameSize[i]=0;
                continue;
            }
            
            if(choose==1){//if choose is 1 that means sameSize will be the length of this HugeInt and will be filled with contents of h
                sameSize[i]=h.getRanNum()[token--];//once token is less than 0 then all elements in smaller array are transferred
            }
            else{
                sameSize[i]=ranNum[token--];
            }
        }//end of for
        
            for(int i=length-1;i>=0;i--){//will add all digits except left most digit
               
                if(ranNum.length==h.getRanNum().length){//choose which condition to add
                    newHugeInt[i]+=ranNum[i]+h.getRanNum()[i];//add right most element first and carry digit
                }
                else if(ranNum.length>h.getRanNum().length){
                    newHugeInt[i]+=ranNum[i]+sameSize[i];
                }
                else{
                    newHugeInt[i]+=sameSize[i]+h.getRanNum()[i];
                }
           
                if(newHugeInt[i]>=10){
       
                    if(i==0&&newHugeInt[i]>=10){//checks if first element will have addition of 10 and will increase size of array accordingly
                   
                        int[] biggerInt = new int[length+1];//creates new array taking into account the carry digit
                        int index = 1;//used to go through newHugeInt

                        //separates number into 2 digits, like 19, places 1 in index 0 and 9 in index 1
                        biggerInt[0]=1;//sets first digit to 1
                        biggerInt[1]=newHugeInt[i]-10;//takes first digit of added numbers 

                        for(int j=2;j<biggerInt.length;j++){//copies contents of newHugeInt into biggerInt
                            biggerInt[j]=newHugeInt[index++];
                        }//end of for

                            newHugeInt = biggerInt;//assign new array to hold one
                            break; //since i=0 and new arrays is created no need to move to next 2 operations
                    }//end of if

                    newHugeInt[i]=newHugeInt[i]-10;//subtract by 10 to get first digit then add carry to adjacent element
                    newHugeInt[i-1]+=1;//add carry
                    
                }//end of if
            }//end of for
      
        for(int i=0;i<newHugeInt.length;i++){//converts new HugeInt to string
            hugeInt+=newHugeInt[i];
        }//end of for
        
        if(flip==1){
            add = new HugeInteger(hugeInt);
            add.setNegative(true);
            return add;
        }
        else{
            add = new HugeInteger(hugeInt);
        }
        return add;
    }//end of add
    
    public HugeInteger subtract(HugeInteger h){
        String subInt="";//to final value
        int[] difference;//used to hold values
        int borrow=0,indexH=0,flip=0;
        int[] bigger=new int[ranNum.length];//copy array to not change values
        int[] smaller=new int[h.getRanNum().length];//copy h to not change values
        boolean bothNeg=false;
        HugeInteger diff;
        
        for(int i=0;i<ranNum.length;i++){//copy arrays into new arrays
            bigger[i]=ranNum[i];
        }
          for(int i=0;i<h.getRanNum().length;i++){
            smaller[i]=h.getRanNum()[i];
        }
         
        if(getNegative()==true&&h.getNegative()==true){
            setNegative(false); //make numbers both positive
            h.setNegative(false);
              
            if(compareTo(h)==1||compareTo(h)==-1){//it will just subtract numbers then later determine if positive or negative
                bothNeg=true;//if this int is smaller than h, the difference must be negative
            }
        }//end of if
        
        if((getNegative()==true&&h.getNegative()==false&&methodcall!=1)){
            methodcall=1;//it will not intefere with adding method and loop back and forth
            diff = add(h);
            diff.setNegative(true);
            methodcall=0;//set back to zero for use again
            return diff;
        }
        if(h.getNegative()==true&&getNegative()==false&&methodcall!=1){//if h is negative just add the numbers together
            methodcall=1;
            diff = add(h);
            methodcall=0;//set back to 0 for reuse
            return diff;
        }
         
        if(compareTo(h)==0||compareTo(h)==1){//initialize to the bigger array
            difference = new int[ranNum.length];
            indexH = h.getRanNum().length-1;//used to index through h
            if(bothNeg==true){//makes value negative
                flip=1;//to indicate the value will be negative
            }
        }
        else
        {//if h is bigger
            difference = new int[h.getRanNum().length];
            indexH = ranNum.length-1;
            int[] temp=smaller;
            
            smaller=bigger;//switch bigger array to smaller and vice versa, by default h will be declared smaller
            bigger=temp;
            if(bothNeg==false){//check if both are negative and if so, this combination must be a positive difference
                flip=1;
            }
            else{
                flip=0;//to indicate the value will be negative
            }
           
        }//end of else
        
            for(int i=difference.length-1;i>=0;i--){
                
                if(indexH<0){//since thisInt is larger it will stop when the length of h has been reached and just print out the remainding numbers in the bigger number
                    difference[i]=bigger[i];
                }
                else{
                    if(bigger[i]==0&&bigger[i]<smaller[indexH]){//check whether the current element is 0 search through array for non zero borrower
                   
                        for(int j=i;j>=0;j--){//will go through number to borrow

                            if(bigger[j]!=0){//find a non zero element to borrow from
                                          
                                bigger[j]-=1;//subtract from it and then carry over
                                for(int a=j+1;a!=i;a++){
                                    
                                    bigger[a]=9;//will replace 0s with 9 until it reaches current element to subtract
                                }//end of for
                                bigger[i]=10;//current element will be a 10
                                break;//exit for loop
                            }//end of if
             
                            //System.out.println("plz not here");
                        }//end of for
                    }
                    else if(bigger[i]<smaller[indexH]){
                        bigger[i-1]-=1;//subtract element to the left by 1
                        borrow=10;
                    }
                    
                    difference[i]=bigger[i]-smaller[indexH--]+borrow;
                    borrow=0;//reset to 0
              
                }//end of else
            }//end of for
       
        for(int i=0;i<difference.length;i++){
            subInt+=difference[i];//put it into string
        }
       
        if(flip==1)//if flip is 1 then the number must be a negative
        {
            diff = new HugeInteger(subInt);
            diff.setNegative(true);
        }
        else{
            diff = new HugeInteger(subInt);
        }
        
        return diff;
        
    }// end of subtract
    
    public HugeInteger multiply(HugeInteger h){
        String hugeProducts="";
        int[] bigger = new int[ranNum.length];
        int[]smaller = new int[h.getRanNum().length];
        int[] hugeProduct; //used to store product
        int bigLength = ranNum.length;
        int smallLength = h.getRanNum().length;
        HugeInteger bigProduct;
    
        if(bigLength==0||smallLength==0){
            return new HugeInteger("0");//multiply by 0 gives 0
        }
        
        for(int i=0;i<ranNum.length;i++){//copy arrays into new arrays
            bigger[i]=ranNum[i];
        }
          for(int i=0;i<h.getRanNum().length;i++){
            smaller[i]=h.getRanNum()[i];
        }
        
          hugeProduct = new int[smallLength+bigLength];//take the lengths and add together, since max amount of digits in product will not be greater than the sum of the 2 numbers lengths
          //keeps answer in reverse order
          
          int indexBig=0; //used to index through hugeProduct array where answers are stored
          int indexSmall=0;
       
          
          for(int i=bigLength-1;i>=0;i--){//start at right most element
              
              int carry=0;//used to carry digit
              indexSmall=0;//reset back
                
              for(int j=smallLength-1;j>=0;j--){//multiply a single digit of the second number to every digit in the first number, take 

                int result= bigger[i]*smaller[j]+hugeProduct[indexBig+indexSmall]+carry;//multiply numbers together,add the corresponding digit of the previously added number and add a carry if there is one
                carry = result/10; //integer division to take first digit
                hugeProduct[indexBig+indexSmall] = result%10;// take second digit in a 2 digit number and store the result in the current index (array is in reverse order)

                indexSmall++;//increment to next index in array
              }//end of for
        
              if(carry>0){//used for when the last digit is reached, it will just add the 2 digit number into the array into the last column of hugeProduct
                  hugeProduct[indexBig+indexSmall]+=carry;//add carry 
              }
    
              indexBig++;//increment this since the first element is done, move to next starting position in array, basically like adding a zero when we move to next digit in multiplication
              //move this one over since you are just gonna add zeroes to it
          }//end of for
                
          int length = hugeProduct.length-1;
          while(length>=0){//leading zeroes will be removed when printed out
              hugeProducts+=hugeProduct[length--];//answer is in reverse so we need to start at end of index
          }
          
          bigProduct = new HugeInteger(hugeProducts);//create new hugeInteger 
          
          if(getNegative()==true&&h.getNegative()==true){//return positive
              return bigProduct;
          }
          
          if(getNegative()==true||h.getNegative()==true){
              bigProduct.setNegative(true);//give negative answer
          }
          return bigProduct;
       
    }//end of multiply
    
    public int compareTo(HugeInteger h){
      if(this.ranNum.length<h.getRanNum().length){//checks if lengths are different and determines if it is greater or less than h
       //   System.out.println("The number is -1");
        if(h.getNegative()==true){
            return 1;//since negative makes it smaller
        }
          return -1;
      }
      else if(this.ranNum.length>h.getRanNum().length){
        if(getNegative()==true){
            return -1;//since negative makes it smaller
        }
          return 1;
      }
      else{//check each element since they are same size and determines which is bigger
          
          if(h.getNegative()==true&&getNegative()==true){
            for(int i=0;i<this.ranNum.length;i++){//will check which number is bigger and that will be the smaller number
                if(this.ranNum[i]>h.getRanNum()[i]){
                    return -1;
                }
                else if(this.ranNum[i]<h.getRanNum()[i]){
                    return 1;
                }
            }//end of for
          }
          
          else if(h.getNegative()==true){
              return 1;//since this hugeint is bigger
          }
          else if(getNegative()==true){
              return -1;
          }
          else{//positive numbers
            for(int i=0;i<this.ranNum.length;i++){//will check left most digit if it is greater or less than h. If they are equal then 0 is returned
                if(this.ranNum[i]>h.getRanNum()[i]){
              //      System.out.println("The number is 1");
                    return 1;
                }
                else if(this.ranNum[i]<h.getRanNum()[i]){
               //     System.out.println("The number is -1");
                    return -1;
                }
            }//end of for
          }
      }//end of else
       return 0;//default return 
    }//end of compareTo
    
    @Override
     public String toString(){
        String num="";
        int checkZero=0;//used to check if number is all zeroes
        
        if(negative==true){//checks to see if number is negative
            num="-";
        }
      
        for(int i=0;i<ranNum.length;i++){
            num+=ranNum[i];
        }//end of for 
       
        if(ranNum.length==checkZero)//checks if number of elements equal to number of zeroes
            return "0";
        
         return num;
     }// end of toString
}// end of HugeInteger
