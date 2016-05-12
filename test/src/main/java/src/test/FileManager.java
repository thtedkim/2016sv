package src.test;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by SuchangKo on 16. 5. 12..
 */
public class FileManager{
    ArrayList<String> FileList;



    public ArrayList<String> OpenFiles(ArrayList<String> FileList){
        int returnVal = MainSystem.fc.showOpenDialog(MainSystem.frame);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = MainSystem.fc.getSelectedFile();
            //This is where a real application would open the file.
            //System.out.println("Opening: " + file.getName() + "."+file.getAbsolutePath() );
            this.FileList = FileList;
            this.FileList.add(file.getAbsolutePath());
        } else {
            System.out.println("Open command cancelled by user.");
        }



        return this.FileList;
    }

    public void DisplayFileList(ArrayList<String> FileList){

        String[] strings = FileList.toArray(new String[]{""});
        MainSystem.jlist = new JList(strings);
    }
}
