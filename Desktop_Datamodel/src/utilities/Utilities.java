/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 *
 * @author 10512691
 */
public class Utilities {
    public static String formatPrice(Double price) {

        DecimalFormat df = new DecimalFormat("£0.00");
        df.setRoundingMode(RoundingMode.FLOOR);
        String formattedPrice = df.format(price);

        return formattedPrice;
    }
}
