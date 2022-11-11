package exercise;

import java.util.ArrayList;

// BEGIN
class App {
    public static boolean scrabble(String symbols, String word) {
        char[] arraySymbols = symbols.toLowerCase().toCharArray();
        char[] arrayWord = word.toLowerCase().toCharArray();
        if (arrayWord.length > arraySymbols.length || arraySymbols.length == 0) {
            return false;
        }
        ArrayList<Character> listArraySymbols =  new ArrayList<Character>(arraySymbols.length);
        for (char symb : arraySymbols) {
            listArraySymbols.add(symb);
        }
        for (char def : arrayWord) {
            if (listArraySymbols.contains(def)) {
                listArraySymbols.remove(new Character(def));
            } else {
                return false;
            }
        }
        return true;
    }
}
//END
