import java.util.Scanner;
public class Calculator {
    private double n1;
    private double n2;
    public  Calculator(double n1,double n2){
        this.n1=n1;
        this.n2=n2;
    }
    public double add(){
        return n1+n2; 
    }
    public double subtract(){
        return n1-n2;
    }
    public double multiply(){
        return n1*n2;
    }
    public double division(){
        if(n2==0){
            System.out.println("division not possible");
        return 0;
        }
    return n1 /n2;
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter n1:");
        double a=sc.nextDouble();
        System.out.println("enter n2:");
        double b=sc.nextDouble();
        Calculator c=new Calculator(a,b);
        System.out.println("\nChoose operation: ");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: System.out.println("Result: " + c.add()); break;
            case 2: System.out.println("Result: " + c.subtract()); break;
            case 3: System.out.println("Result: " + c.multiply()); break;
            case 4: System.out.println("Result: " + c.division()); break;
            default: System.out.println("Invalid choice!");
        }

        sc.close();
        
        
        
    }
    
    
    
}
