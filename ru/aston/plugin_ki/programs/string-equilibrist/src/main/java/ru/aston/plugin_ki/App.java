package ru.aston.plugin_ki;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( StringEquilibrist.findTheLongest("1.	Написать метод для поиска самого длинного слова в тексте") );
        System.out.println("\n" + StringEquilibrist.isPalindrome("Тропа налево повела на порт"));
        System.out.println("\n" + StringEquilibrist.censorship("бяка ычф вааываывм авыакуцу бяка  вывым бяка, аыва" +
                                                        " ыаыа, ваы бяка ы. Ериыаоы бяка выаывап, аыаыпа"));

        System.out.println("\n" + StringEquilibrist.howManyTimes("бяка ычф вааываывм авыакуцу бяка  вывым бяка , аыва", "бяка"));

        System.out.println("\n" + StringEquilibrist.wouldULikeToReverse("Sample Output:\n" +
                "The given string is: This is a test string\n" +
                "The string reversed word by word is:\n" +
                "sihT si a tset gnirts\n"));


    }
}
