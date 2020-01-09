import java.util.ArrayList;
import java.util.Arrays;

public class SimpleDotComGame {
    public static void main(String[] args) {
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        DotCom theDotCom = new DotCom();
        int randomNum = (int) (Math.random() * 5);
        ArrayList<Integer> locations = new ArrayList<>(Arrays.asList(randomNum, randomNum+1, randomNum+2));
        System.out.println(locations);
        //int [] locations = {randomNum, randomNum+1, randomNum+2};
        locations.add(randomNum);
        theDotCom.setLocationCells(locations);
        boolean isAlive = true;
        while (isAlive == true) {
            String guess = helper.getUserInput("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("Потопил")){
                isAlive = false;
                System.out.println("Вам потребовалось " + numOfGuesses + " попыток(и)");
            }
        }
    }
}
