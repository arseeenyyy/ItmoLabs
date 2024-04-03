package commands;

import exceptions.WrongArgumentException;
import models.parseConf.XmlReader;
import models.parseConf.XmlWriter;
import utility.Console;
/**
 * Команда 'save'. Сохраняет элемент в коллекцию
 * @author Arseniy Rubtsov
*/
public class Save extends BaseCommand {
    private final Console console;

    public Save(Console console) {
        super("save", "saves collection to file");
        this.console = console;
    }
    /**
     * Выполняет команду
     * @return boolean Успешность выполнения команды
     */
    @Override
    public boolean execute(String[] args) {
        try {
            if (!args[1].isEmpty()) throw new WrongArgumentException();
            XmlWriter.writeCollection(console, XmlReader.path);
            console.println("collection was saved");
            return true;
        }catch (WrongArgumentException exception) {
            console.printError("command '" + getName() + "' has no arguments!");
        }
        return false;
    }

}
