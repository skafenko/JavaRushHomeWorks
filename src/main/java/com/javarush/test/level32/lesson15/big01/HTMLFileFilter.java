package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by Mykhailo on 30.10.2016.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        String fileName = f.getName();
        String substring = fileName.substring(fileName.lastIndexOf("."));
        boolean isHtml = substring.equalsIgnoreCase(".html");
        boolean isHtm = substring.equalsIgnoreCase(".htm");
        return f.isDirectory() || isHtml || isHtm;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
