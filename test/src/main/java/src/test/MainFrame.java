package src.test;

import javax.swing.*;

/**
 * Created by SuchangKo on 16. 5. 12..
 */
public class MainFrame extends JFrame {
    private JList fileList;
    private JButton compareButton;
    private JButton exitButton;
    private JButton configureButton;
    private JButton openButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JPanel mainPanel;

    public MainFrame(){
        super("hello,world");
        setContentPane(mainPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
