package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes obj) {
        ImageReader reader;
        if (obj != null && obj.equals(ImageTypes.BMP)) {
            reader = new BmpReader();
        } else if (obj != null && obj.equals(ImageTypes.JPG)) {
            reader = new JpgReader();
        } else if (obj != null && obj.equals(ImageTypes.PNG)) {
            reader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return reader;
    }
}
