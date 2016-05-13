package src.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainSystem
{
    FileManager fileManager = new FileManager();
    ResultManager resultManager = new ResultManager();
    ViewManager viewManager = new ViewManager();

    //Container
    static JFrame mainFrame = new JFrame("Graphical Clone Checker-Main");
    JFrame resultFrame = new JFrame("Graphical Clone Checker-Result");
    JDialog configureDialog = new JDialog(mainFrame, "Graphical Clone Checker-Configure");

    //Component-Main
    JButton openButton = new JButton("Open");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");
    JButton compareButton = new JButton("Compare");
    JButton displayresultButton = new JButton("Display Result");
    JButton configureButton = new JButton("Configure");
    JButton exitButton = new JButton("Exit");
    static JList fileListVew = new JList();

    //Variable-Main
    static JFileChooser fc;
    ArrayList<String> FileList = new ArrayList<String>();

    //Component-Configure
    JButton configureApplyBtnDialog = new JButton("Ok");
    JButton configureCancelBtnDialog = new JButton("Cancel");

    public void createMainFrame()
    {
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        JPanel sideButtonPanel = new JPanel();

        fc = new JFileChooser();

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickOpenBtn();
            }
        });
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickDeleteBtn();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickClearBtn();
            }
        });
        displayresultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickDisplayResultBtn();
            }
        });
        compareButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickCompareBtn();
            }
        });
        configureButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showConfigureDialog();
            }
        });
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ClickExitBtn();
            }
        });

        JScrollPane scrollPane = new JScrollPane(fileListVew);

        sideButtonPanel.setLayout(new BoxLayout(sideButtonPanel, BoxLayout.PAGE_AXIS));
        sideButtonPanel.add(compareButton);
        sideButtonPanel.add(configureButton);
        sideButtonPanel.add(displayresultButton);
        sideButtonPanel.add(exitButton);


        upPanel.setLayout(new BorderLayout());
        upPanel.add(scrollPane,BorderLayout.CENTER);
        upPanel.add(sideButtonPanel,BorderLayout.EAST);

        downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.LINE_AXIS));

        downPanel.add(openButton);
        downPanel.add(deleteButton);
        downPanel.add(clearButton);

        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(upPanel,BorderLayout.CENTER);
        mainFrame.add(downPanel,BorderLayout.SOUTH);

        //프레임 크기 지정
        mainFrame.setSize(400, 300); // (width,height)
        //Fix mainFrame Size
        mainFrame.setMaximumSize(new Dimension(400,300));
        mainFrame.setMinimumSize(new Dimension(400,300));
        //프레임 보이기
        mainFrame.setVisible(true);

        //swing에만 있는 X버튼 클릭시 종료
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createResultFrame(){
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        JPanel graphPanel = new JPanel();
        graphPanel.setBackground(Color.BLUE);

        JList resultList = new JList();

        upPanel.setLayout(new FlowLayout());

        upPanel.add(new JScrollPane(resultList));
        upPanel.add(graphPanel);

        downPanel.setLayout(new GridLayout(0,3));
        downPanel.add(new JLabel("Check Point"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("Percentage"));

        downPanel.add(new JLabel("Raw Text"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("40%"));

        downPanel.add(new JLabel("Variable & Function"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));

        downPanel.add(new JLabel("Comment"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));

        downPanel.add(new JLabel("Condition"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));

        downPanel.add(new JLabel("Loop"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));

        downPanel.add(new JLabel("Function Merge"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));

        downPanel.add(new JLabel("Total"));
        downPanel.add(new JLabel(""));
        downPanel.add(new JLabel("50%"));




        resultFrame.setLayout(new BorderLayout());
        resultFrame.add(upPanel,BorderLayout.CENTER);
        resultFrame.add(downPanel,BorderLayout.SOUTH);

        resultFrame.setSize(400,300);
        resultFrame.setMaximumSize(new Dimension(400,300));
        resultFrame.setMinimumSize(new Dimension(400,300));
        resultFrame.setVisible(true);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void showConfigureDialog(){
        configureDialog.setLayout(new FlowLayout());
        configureDialog.add(configureApplyBtnDialog);
        configureDialog.add(configureCancelBtnDialog);
        configureDialog.setSize(200,100);
        configureDialog.setVisible(true);
        configureDialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main( String[] args )
    {
        MainSystem frameExam = new MainSystem();
        frameExam.createMainFrame();
    }



    //GUI Function
    public void ClickOpenBtn(){
        FileList = fileManager.OpenFiles(FileList);
        fileManager.DisplayFileList(FileList);
    }

    public void ClickDeleteBtn(){
        fileManager.DeleteFiles(FileList);
    }

    public void ClickClearBtn(){
        fileManager.Clear();
        FileList.clear();
        fileManager.DisplayFileList(FileList);
    }

    public void ClickConfigureBtn(){

    }

    public void ClickCompareBtn(){
        createResultFrame();
    }

    public void ClickDisplayResultBtn(){

    }

    public void ClickExitBtn(){
        Exit();
    }

    public void Exit(){
        System.exit(0);
    }

}
