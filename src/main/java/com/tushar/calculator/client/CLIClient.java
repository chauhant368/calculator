package com.tushar.calculator.client;

import java.util.Scanner;

public class CLIClient {
    Scanner sc=new Scanner(System.in);
    public void calculatorExecution()
    {
        System.out.println("1.Add");
        System.out.println("2.Subtract");
        System.out.println("3.Multiply");
        System.out.println("4.Divide");
        System.out.println("Enter your choice: ");
        int x=0;
        for(;;)
        {
            int y=sc.nextInt();
            if(y==0)
                break;
            if(y==1)
            {
                for(;;)
                {
                    int z=sc.nextInt();
                    if(z==0)
                        break;
                    System.out.println(z+"+"+x+"=");
                    x=z+x;
                    System.out.println(x);
                }
            }
            else if(y==2)
            {
                for(;;)
                {
                    int z=sc.nextInt();
                    if(z==0)
                        break;
                    if(x==0)
                    {
                        System.out.println(z+"-"+x+"=");
                        x=z-x;
                    }
                    else
                    {
                        System.out.println(x+"-"+z+"=");
                        x=x-z;
                    }
                    System.out.println(x);
                }
            }
            else if(y==3)
            {
                for(;;)
                {
                    int z=sc.nextInt();
                    if(z==0)
                        break;
                    System.out.println(z+"*"+x+"=");
                    x=x*z;
                    System.out.println(x);
                }
            }
            else
            {
                for(;;)
                {
                    int z=sc.nextInt();
                    if(z==0)
                        break;
                    if(x==0)
                    {
                        System.out.println(z+"/"+x+"=");
                        throw new IllegalArgumentException("Denominator cannot be zero for division operation");
                    }
                    else
                    {
                        System.out.println(x+"/"+z+"=");
                        x=x/z;
                    }
                    System.out.println(x);
                }
            }
        }
        System.out.println("Answer is: "+x);
    }
}
