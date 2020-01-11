package top.hombio;

import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, SQLException, TemplateException {
        System.out.println("generating...");
        long time = System.currentTimeMillis();
        Generator.start();
        System.out.println("finished --> time spend: "+(System.currentTimeMillis()-time)/1000 +"s");
    }
}
