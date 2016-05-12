package src.test;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App 
{

    JFrame frame = new JFrame("Graphical Clone Checker");
    JDialog configureDialog = new JDialog(frame, "JDialog 타이틀");
    JButton configureApplyBtnDialog = new JButton("apply");
    JButton configureCancelBtnDialog = new JButton("cancel");
    JButton openButton = new JButton("Open");
    JButton deleteButton = new JButton("Delete");
    JButton clearButton = new JButton("Clear");
    JButton compareButton = new JButton("Compare");
    JButton configureButton = new JButton("Configure");
    JButton exitButton = new JButton("Exit");
    JList fileList;
    JFileChooser fc;


    public void createFrame()
    {
        JPanel upPanel = new JPanel();
        JPanel downPanel = new JPanel();
        JPanel sideButtonPanel = new JPanel();

        fc = new JFileChooser();

        ArrayList<String> fileListarray = new ArrayList<String>();
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");
        fileListarray.add("/home/a.c");

        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fc.showOpenDialog(frame);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //This is where a real application would open the file.
                    System.out.println("Opening: " + file.getName() + "."+file.getAbsolutePath() );
                } else {
                    System.out.println("Open command cancelled by user.");
                }

            }
        });

        configureButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showConfigureDialog();
            }
        });

        String[] strings = fileListarray.toArray(new String[]{""});
        fileList = new JList(strings);

        JScrollPane scrollPane = new JScrollPane(fileList);

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
        App frameExam = new App();
        frameExam.createFrame();

    }




}
