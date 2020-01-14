import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<>();
    private int numOfGuesses = 0;

    private void setUpGame () {
        DotCom one = new DotCom();
        one.setName ("Pets.com");
        DotCom two = new DotCom();
        two.setName ("eToys.com");
        DotCom three = new DotCom();
        three.setName ("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        dotComsList.addAll(Arrays.asList(one, three, two));

        System.out.println("Ваша цель - потопить три коробля.");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Попытайтесь их потопить заминимальное количество ходов");

        for (DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying () {
        while (!dotComsList.isEmpty()) {
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    private void checkUserGuess (String userGuess){
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom dotComToTest : dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Попал")) {
                break;
            }
            if (result.equals("Потопил")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }
    private void finishGame (){
        System.out.println("Все сайті пропали!");
        if (numOfGuesses <= 18) {
            System.out.println("Это заняло у вас всего" + numOfGuesses + "попыток");
        } else {
            System.out.println("Это заняло у вас довольно много времени. А именно" + numOfGuesses + "попыток");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
