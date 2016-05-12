package src.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class MainSystem
{
    FileManager fileManager = new FileManager();
    ResultManager resultManager = new ResultManager();
    ViewManager viewManager = new ViewManager();

    //Container
    static JFrame frame = new JFrame("Graphical Clone Checker-Main");
    JFrame frame1 = new JFrame("Graphical Clone Checker-Result");
    JDialog configureDialog = new JDialog(frame, "Graphical Clone Checker-Configure");

    //Component-Main
    JButton openButton = new JButton("Open");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");
    JButton compareButton = new JButton("Compare");
    JButton configureButton = new JButton("Configure");
    JButton exitButton = new JButton("Exit");

    //Variable-Main
    static JList jlist;
    static JFileChooser fc;
    ArrayList<String> FileList = new ArrayList<String>();

    //Component-Configure
    JButton configureApplyBtnDialog = new JButton("apply");
    JButton configureCancelBtnDialog = new JButton("cancel");




    public void createMainFrame()
    {
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        JPanel sideButtonPanel = new JPanel();

        fc = new JFileChooser();



        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileList = fileManager.OpenFiles(FileList);

            }
        });

        configureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showConfigureDialog();
            }
        });

        compareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createResultFrame();
            }
        });


        JScrollPane scrollPane = new JScrollPane(jlist);

        sideButtonPanel.setLayout(new BoxLayout(sideButtonPanel, BoxLayout.PAGE_AXIS));
        sideButtonPanel.add(compareButton);
        sideButtonPanel.add(configureButton);
        sideButtonPanel.add(exitButton);


        upPanel.setLayout(new BorderLayout());
        upPanel.add(scrollPane,BorderLayout.CENTER);
        upPanel.add(sideButtonPanel,BorderLayout.EAST);

        downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.LINE_AXIS));

        downPanel.add(openButton);
        downPanel.add(deleteButton);
        downPanel.add(clearButton);

        frame.setLayout(new BorderLayout());
        frame.add(upPanel,BorderLayout.CENTER);
        frame.add(downPanel,BorderLayout.SOUTH);

        //프레임 크기 지정
        frame.setSize(400, 300); // (width,height)
        //Fix Frame Size
        frame.setMaximumSize(new Dimension(400,300));
        frame.setMinimumSize(new Dimension(400,300));
        //프레임 보이기
        frame.setVisible(true);

        //swing에만 있는 X버튼 클릭시 종료
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createResultFrame(){
        frame1.setSize(400,300);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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




}
