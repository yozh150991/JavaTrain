import java.util.ArrayList;
public class DotCom {
    private ArrayList<Integer> locationCells;
    int numOfHits = 0;

    public void setLocationCells(ArrayList<Integer> locs) {
        locationCells = locs;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        int index = locationCells.indexOf(Integer.parseInt(userInput));
        if (index >= 0){
            locationCells.remove(index);
            if (locationCells.isEmpty()){
                result = "Потопил";
            } else {
                result = "Попал";
            }
        }
        System.out.println(result);
        return result;
    }
}
