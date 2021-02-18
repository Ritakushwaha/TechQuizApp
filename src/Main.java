
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rita
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[a-zA-Z0-9]{7}", "capgem9"));
        System.out.println(Pattern.matches("[89]{2}\\d{9}", "8853038949"));
    }
}
