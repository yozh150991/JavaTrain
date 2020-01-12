import java.util.*;

public class DotComBust {
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void SetUpGame () {
        DotCom one = new DotCom();
        one.setName ("Pets.com");
        DotCom two = new DotCom();
        two.setName ("eToys.com");
        DotCom three = new DotCom();
        three.setName ("Go2.com");
        dotComsList.add(one, two, three);

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
}
