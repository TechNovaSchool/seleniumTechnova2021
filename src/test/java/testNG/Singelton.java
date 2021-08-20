package testNG;

public class Singelton {

    private Singelton(){

    }

    private static String example;

    public static String getExample(){
        if(example == null) {
            System.out.println("My singelton setup");
            example = "This is NOT a null value";
        }
        else {
            System.out.println("Already has a value");
        }
        return example;
    }


}
