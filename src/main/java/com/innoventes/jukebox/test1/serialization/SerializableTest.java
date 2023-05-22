package com.innoventes.jukebox.test1.serialization;

import java.io.*;

public class SerializableTest {

    public static void main(String[] args) {
        Demo object = new Demo(1, "GeekForGeeks");
        String filename = "file.ser";
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);
            outputStream.writeObject(object);
            outputStream.close();
            file.close();
            System.out.println("Object is serialized");
        }catch (IOException ex){
            System.out.println("IO Exception happened");
        }

        Demo deserializedObject = null;
        try{
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            deserializedObject = (Demo) in.readObject();
            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
            System.out.println("a = " + deserializedObject.a);
            System.out.println("b = " + deserializedObject.b);

        }catch (FileNotFoundException ex){

        }catch (IOException ex){

        }catch (ClassNotFoundException ex){

        }

    }
}
