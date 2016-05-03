package utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 * Created by Dominic on 25/04/2016.
 */
public class HashString {
    public static String Encrypt(String pass)
    {
        String saltEnd = "162300JBKYSCOTT"; // 128 bit key;
        String saltStart = "7hegdChickenu2ys90";
        pass = saltStart + pass +  saltEnd;
        Integer hashedValue = pass.hashCode();
        return Integer.toString(hashedValue);
    }
    
}
