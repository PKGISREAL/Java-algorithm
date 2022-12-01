package com.company;

public class InToPost {
    private Stack stackpost;
    private String input;
    private String output = "";


    public InToPost(String in){
        this.input = in;
        int stackSize = input.length();
        stackpost = new Stack(stackSize);
    }

    public String doThings(){
        for (int j = 0; j < input.length() ; j++){
            char ch = input.charAt(j);
            switch (ch){
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stackpost.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!stackpost.isEmpty()){
            output = output + stackpost.take();
        }
        return output;
    }

    public void gotOper(char opThis, int prior1){
        while (!stackpost.isEmpty()){
            char opTop = stackpost.take();
            if(opTop == '('){
                stackpost.push(opTop);
                break;
            } else {
                int prior2;
                if (opTop == '+' || opTop == '-')
                    prior2 = 1;
                else
                    prior2 = 2;
                if (prior2 < prior1){
                    stackpost.push(opTop);
                    break;
                }
                else output = output + opTop;

            }

        }
        stackpost.push(opThis);
    }
    public void gotParen(char ch){
        while (!stackpost.isEmpty()){
            char chx = stackpost.take();
            if ( chx == '(')
                break;
            else output = output + chx;
        }
    }
    
    protected  static int evalPostfix(String express) 
    { 
        Stack stack = new Stack(express.lenght()); 
          
        for(int i=0; i < express.length(); i++) 
        { 
            char ch = express.charAt(i); 
             
            if(Character.isDigit(ch)
            st.push(ch - '0'); 
              
           
            else     
            { 
                int value1 = st.take(); 
                int value2 = st.tale(); 
                  
                switch(ch) 
                { 
                    case '+': 
                    st.push(value2 + value1); 
                    break; 
                      
                    case '-': 
                    st.push(value2 - value1); 
                    break; 
                        
                    case '*': 
                    st.push(value2*value1); 
                    break; 
                    case '/': 
                    st.push(value2/value1); 
                    break; 
              } 
            } 
        } 
        return st.pop();   // result return  
    } 




}
