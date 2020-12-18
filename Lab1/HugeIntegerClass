import java.util.Random;

public class HugeInteger {
    private int[] ranNum;
    private int negative=0;//used to indicate if number is negative
    
    public HugeInteger(String val)throws IllegalArgumentException{
   
        if(val.isEmpty()){//checks if string is empty and assigns ranNum as an empty array
            ranNum = new int[0];
        }
        else{
            for(int i=0;i<val.length();i++){//checks and throws exception
                if(val.lastIndexOf('-')!=0&&(val.charAt(i)<48||val.charAt(i)>57)){//checks if numbers are between 0-9 and if - anywhere but the first element
                    throw new IllegalArgumentException("Invalid characters detected. Only 0-9 are valid");
                }//end of if
            }//end of for
          
            int index=0;

            if(val.charAt(0)==45){//checks if there is a minus sign
                negative=-1;
            }//end of if
    
            ranNum = new int[val.length()+negative];//sets array to size of string,if there is a negative it will ignore extra char

            for(int i=0;i<val.length()+negative;i++){

               if(negative==-1&&i==0){//checks if minus is present
                   index=1;//skips minus sign
                   ranNum[i]=(val.charAt(index++)-48);//makes first number negative
                   continue;
               }
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
    
    public HugeInteger add(HugeInteger h){
        String hugeInt="";//used to convert array into string
        int token=0;//used as an index for the smaller array
        int choose=0;//used to pick which condition to run h>RanNum or RanNum>h
        int length=ranNum.length;//length var is for the biggest array
        int[] newHugeInt;
        int[] sameSize;//used to make h same size as the bigger array
        
        /*
        Make arrays same size and add accordingly
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
        
        return new HugeInteger(hugeInt);
    }//end of add*/
    
    @Override
     public String toString(){
        String num="";
        
        for(int i=0;i<ranNum.length;i++){
            if(i==0&&negative==-1){
                num="-";
            }
            num+=ranNum[i];
        }//end of for 
       
         return num;
     }// end of toString
}// end of HugeInteger

   
