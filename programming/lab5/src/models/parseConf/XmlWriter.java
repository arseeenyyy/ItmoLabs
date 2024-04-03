package models.parseConf;

import managers.DragonManager;
import models.Dragon;
import utility.Console;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Класс для записи коллекции в XML файл
 * @author Arseniy Rubtsov
*/
public class XmlWriter {
    /**
     * Запись коллекции
     * @param console
     * @see Console
    */
    public static void writeCollection(Console console, String filePath) {
        StringBuilder xmlString = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n<collection>\n\t<dragons>");
        for (Dragon d : DragonManager.getInstance().getCollection())
            xmlString.append(d.toXml());
        xmlString.append("\n\t</dragons>\n</collection>");
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(filePath));
            writer.println(xmlString);
            writer.close();
            DragonManager.getInstance().setLastSaveTime();
        }catch (FileNotFoundException exception) {
            console.printError("file wasn't found");
        }catch (IOException exception) {
            console.printError("can't write into file");
        }
    }

}
