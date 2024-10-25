package edu.au.cpsc.module7;

import java.io.*;

public class Db {
    public static final File DEFAULT_FILE = new File("polygraph.dat");
    private static PolygraphDatabase polygraphDatabase = null;

    public synchronized static PolygraphDatabase getDataBase() {
        if (polygraphDatabase == null) {
            polygraphDatabase = loadDataBase();
        }
        return polygraphDatabase;
    }

    private static PolygraphDatabase loadDataBase() {
        try (InputStream is = new FileInputStream(DEFAULT_FILE)) {
            return PolygraphDatabaseIO.load(is);
        } catch (IOException | ClassNotFoundException ex) {
            return new PolygraphDatabase();
        }
    }

    public static void saveDatabase() {
        try (OutputStream os = new FileOutputStream(DEFAULT_FILE)) {
            PolygraphDatabaseIO.save(getDataBase(), os);
        } catch (IOException ex) {
            System.err.println("Error saving database: " + DEFAULT_FILE);
            ex.printStackTrace();
            System.exit(-1);
        }
    }
}