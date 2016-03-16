/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop_datamodel;

import java.util.ArrayList;

/**
 *
 * @author 10512691
 */
public class Main {
    
    public static void sumArraySquared(ArrayList<Integer> input) {
        System.out.println(input.stream()
                                .map(i -> i * i)
                                .reduce(0, (c, i) -> c + i));
    }
    
    public static void printValues(ArrayList<Integer> input) {
        input.forEach(System.out::println);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        
        printValues(numbers);
        sumArraySquared(numbers);
    }
    
}
