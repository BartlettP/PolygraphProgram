package edu.au.cpsc.module7;

import java.io.*;
public class PolygraphDatabaseIO {
    public static void save(PolygraphDatabase database, OutputStream strm) throws IOException{
        ObjectOutputStream oos = new ObjectOutputStream(strm);
        oos.writeObject(database);
    }
    public static PolygraphDatabase load(InputStream strm) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(strm);
        return (PolygraphDatabase) ois.readObject();
    }
}
