package swordOffer;

public class swordII034 {
    public boolean isAlienSorted(String[] words, String order) {
        int index = 0;
        for (int i = 0; i < order.length(); i++) {

            while (index <words.length && words[index].charAt(0) == order.charAt(i)) {
                index++;

            }
            if (index >= words.length) {
                break;
            }
        }
        return index == words.length ;
    }
}
