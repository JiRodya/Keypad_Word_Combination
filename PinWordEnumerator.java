import java.util.ArrayList;
import java.util.Scanner;
/**
 * Title:       Converter
 * Semester:    COP3337-Summer2022
 * @author:     Dianelys Rocha
 *
 * This program accepts a string input in number corresponding to a keypad (older phones)
 * and outputs all possible letter combinations
 * 
 * for example "hello: " would be written using back then using: 43556 
 * (due to the letter distribution), but each of those had 3 more letters, and the actual ouput
 * was determined by how many times the button was pressed
 * 
 * In this case, the program would output all possible words (valid or not) that could be 
 * written with 43556
 */

/**
   Converts a numeric pin to an equivalent word using the digit to
   letter mapping on a standard telephone keypad.
 */
public class PinWordEnumerator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a pin numbe: ->");
        String num = scan.nextLine();
        System.out.println();
        System.out.printf("The keypad encodings for %s are:%n",num);
        enumerateWords(num);
        scan.close();
    }

    /**
       A wrapper for a recursive method that enumerates all the
       phone keypad encodings for a number.
       @param n a string representing the number
     */
    public static void enumerateWords(String n)
    {
        //array that later will contain letters corresponding to a PIN
        String [] letter = new String [] {""};

        //will storage all possible combinations
        ArrayList <String> storage = new ArrayList<>();

        //callling the method what will actually print using recursion
        storage = recursivePrint(letter, n, "",storage);

        System.out.println(storage.toString());
    }

    /**
     * This is a method that will "create" all the possible combinations of letters given
     * the PIN Code, and making use of the method switchWord, which maps the number, to the
     * corresponding group of letters.
     * This method assumes that n will always have at least one number, result
     * will contain no characters, and storage will have no elements on it.
     * @param letter holds the array of the possible matches for the corresponding PIN value
     * @param n original PIN Code
     * @param storage the original ArrayList blank
     * @param result to store the possible results
     * @return a list of possible all combinations of letters for the PIN code using a keypad format
     */
    public static ArrayList<String> recursivePrint( String [] letter, String n, String result, ArrayList<String> storage)
    {
        //base: if length <= 0, all PIN numbers have been encoded
        if(n.length()<=0)
        {
            storage.add(result); //adds the combination to the list
        }
        else
        {
            //gets the array corresponfing to the number at char 0
            letter = switchWord(n.charAt(0), letter);

            //checking combinations for non fixed indexes
            for(String i : letter)
            {
                recursivePrint(letter, n.substring(1),result+i,storage);
            }

        }
        return storage;
    }

    /**
     * This is a method to map the corresponding passed number, to the letters
     * assigned in a keypad in a form of an array.
     * This method assumes that numStr will be between 2-9 since keypads usually
     * don't pair 0 and 1 with letters.
     * The method doesn't really handle wrong inputs, it will only add the
     * symbol "@" to prevent the program from stopping.
     * @param numStr holds the individual number from the PIN code
     * @param letter holds the array already initialized
     * @return an array with the letters that are possible matches to numStr
     */
    public static String [] switchWord(char numStr, String letter [])
    {

        switch(numStr)
        {
            case '2':
                letter = new String[]{"A","B","C"};
                break;

            case '3':
                letter = new String[]{"D", "E", "F"};
                break;

            case '4':
                letter =  new String [] {"G", "H", "I"};
                break;

            case '5': 
                letter = new String [] {"J", "K","L"};
                break;

            case '6':
                letter = new String []{"M", "N", "O"};
                break;

            case '7':
                letter = new String []{"P","Q", "R","S"};
                break;

            case '8':
                letter = new String []{"T", "U", "V"};
                break;

            case '9':
                letter = new String []{"W", "X", "Y", "Z"};
                break;

            default:
                letter = new String []{"@"};
                break;
            }
       
       
        return letter;
    }
}
