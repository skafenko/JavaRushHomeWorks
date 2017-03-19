package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Mykhailo on 10.03.2016.
 */
public class ImageReaderFactory {
    public static ImageReader getReader(ImageTypes imageTypes){
        if (imageTypes == ImageTypes.BMP)
        {
            return new BmpReader();
        }
        else if (imageTypes == ImageTypes.JPG)
        {
            return new JpgReader();
        }
        else if (imageTypes == ImageTypes.PNG)
        {
            return new PngReader();
        }
        else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
