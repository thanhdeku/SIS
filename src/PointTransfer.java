package src;

public class PointTransfer {

    public static String transfer(float result){
        String evaluate;
        if(result >= 9.5)
            evaluate = "A+";
        else if(result >= 8.5)
            evaluate = "A";
        else if(result >= 8)
            evaluate = "B+";
        else if(result >= 7)
            evaluate = "B";
        else if(result >= 6.5)
            evaluate = "C+";
        else if(result >= 5.5)
            evaluate = "C";
        else if(result >= 5)
            evaluate = "D+";
        else if(result >= 4)
            evaluate = "D";
        else
            evaluate = "F";

        return evaluate;
    }



}
