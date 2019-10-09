package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class JavaStepDefs {
    @Given("I write  first  step")
    public void iWriteFirstStep() {
        System.out.println("Welcome to the club of Java learners");
        String firstName="Oksana";
        String lastName="Nahibina";
        System.out.println("My name is "+firstName+" "+lastName);
    }

    @And("I print {string} in console")
    public void iPrintInConsole(String txt) {
        System.out.println();
        System.out.println(txt);
        System.out.println(txt.length());
        System.out.println(txt.toUpperCase());
        System.out.println(txt.toLowerCase());

    }

    @And("I do action with {string} and {string}")
    public void iDoActionWithAnd(String arg0, String arg1) {
        System.out.println("First parametr is: "+arg0);
        System.out.println("Second parametr is: "+arg1);
        System.out.println(arg0+" is equal to "+arg1+"?"+(arg0==arg1));
        System.out.println("Is Apple equal to Orange"+arg0.equals(arg1));

    }

    @And("I compare {string} and {string}")
    public void iCompareAnd(String arg0, String arg1) {
        if (arg0.equalsIgnoreCase(arg1)) {
            System.out.println("Strings are equal "+arg0+" and"+arg1);
        }
        else {
            System.out.println("Strings are not equal "+arg0+" and "+arg1);
        }
    }

    @Given("I run operators with {int} and {int}")
    public void iRunOperatorsWithAnd(int arg0, int arg1) {
        System.out.println("First number is "+arg0);
        System.out.println("Second number is "+arg1);
        if (arg0>arg1) {
            System.out.println(arg0+" is more then "+arg1);
        }
        else {System.out.println(arg0+" is less then "+arg1);
        }
    }

    @And("I do addition with numbers int{int} and int{int}")
    public void iDoAdditionWithNumbersIntAndInt(int int1, int int2) {
        int1 = 45;
        int2= 5;
        System.out.println("________________________________________________");
        System.out.println("Sum of "+int1+"+"+int2+" = "+(int1+int2));
        System.out.println("Sum of "+int1+"/"+int2+" = "+(int1/int2));
        System.out.println("Sum of "+int1+"-"+int2+" = "+(int1-int2));

    }

    @Given("I print arrays")
    public void iPrintArrays() {
        String[]grocery={"milk","apple","pineapple","cucumber"};
        int[]groceryamount={1,2,5,6};
        System.out.println(grocery[0]);
        System.out.println(grocery[3]);
        System.out.println("____________________________________");

        //Use for loop to print all arrays values
        for (int i=0;i<grocery.length;i=i+1){
            System.out.println(grocery[i]);
        }

        //foreach loop that works with array values
        for (String elem:grocery
             ) {
            System.out.println();
            System.out.println(elem);

        }
        Integer[]NumbersArray={1,2,3,4,5,6,7};
        System.out.println("_______________Numbers:_________");
        for (Integer Number:NumbersArray
             ) {
            System.out.println(Number);

        }

    }
}
