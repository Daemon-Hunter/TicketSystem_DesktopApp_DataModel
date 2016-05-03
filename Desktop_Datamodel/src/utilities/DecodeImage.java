/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Dominic
 */
public  class DecodeImage {
    
public static String encodeToString(BufferedImage image, String type) throws IOException {  
        String imageString = null;  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
  
            ImageIO.write(image, type, bos);  
            byte[] imageBytes = bos.toByteArray();  
  
            BASE64Encoder encoder = new BASE64Encoder();  
            imageString = encoder.encode(imageBytes);  
            bos.close();  
        return imageString;  
    }  
}
