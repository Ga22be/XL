package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import util.XLException;


public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, Slot> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                String address = string.substring(0, i);
                String command = string.substring(i + 1);
                map.put(address, SlotFactory.generateSlot(command, address));
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
