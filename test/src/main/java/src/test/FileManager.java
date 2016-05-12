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

        this.FileList = FileList;
        MainSystem.fc.setMultiSelectionEnabled(true);

        int returnVal = MainSystem.fc.showOpenDialog(MainSystem.mainFrame);


        if (returnVal == JFileChooser.APPROVE_OPTION) {


            File[] files = MainSystem.fc.getSelectedFiles();
            for(File file : files){
                this.FileList.add(file.getAbsolutePath());
            }


        } else {
            System.out.println("Open command cancelled by user.");
        }
        return this.FileList;
    }

    public int[] SelectFiles(ArrayList<String> FileList){
        this.FileList = FileList;
        int[] selectedidx = MainSystem.fileListVew.getSelectedIndices();

        return selectedidx;
    }

    public void DeleteFiles(ArrayList<String> FileList){
        int[] selectedidx = SelectFiles(FileList);
        int weight = 0;
        for(int i : selectedidx){
            int tmp = i - weight;
            this.FileList.remove(tmp);
            weight++;
        }
        DisplayFileList(this.FileList);
    }

    public void DisplayFileList(ArrayList<String> FileList){
        String[] strings = FileList.toArray(new String[]{""});
        MainSystem.fileListVew.setListData(strings);
    }

    public void Clear(){
        this.FileList.clear();
    }
}
