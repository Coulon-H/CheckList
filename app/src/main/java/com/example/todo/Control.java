package com.example.todo;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Control {

    public static ArrayList<ArrayList<String>> readListOfTask(ArrayList<ArrayList<String>> Tab, FileInputStream fi){
        try{
            ObjectInputStream ois = new ObjectInputStream(fi);
            Tab = (ArrayList<ArrayList<String>>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return Tab;
    }

    public static void writeListOfTask(ArrayList<ArrayList<String>> Tab, FileOutputStream fo){
        try{
            //FileOutputStream fos = openFileOutput("List of Task.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(Tab);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readNameTask(ArrayList<String> ListTask, FileInputStream fi){
        try{
            //FileInputStream fis = openFileInput("List of NameTask.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            ListTask = (ArrayList<String>) ois.readObject();
            ois.close();
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return ListTask;
    }

    public static void writeNameTask(ArrayList<String> ListTask, FileOutputStream fo){
        try{
            //FileOutputStream fos = openFileOutput("List of NameTask.txt", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(ListTask);
            oos.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
