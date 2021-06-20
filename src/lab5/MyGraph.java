package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGraph extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMyPanel myPanel=new JMyPanel();//��������� � ������� ���� ������ ��� ���������

    public static void main(String[] args) {
        new MyGraph("���� � ��������");//������� ����
    }

    public MyGraph(String s){
        super(s);
        Box myBox=new Box(BoxLayout.X_AXIS);//������� ���������� � ���� ��������������� �����
        menuBar = new JMenuBar();
        menu = new JMenu("������");
        menuBar.add(menu);
        JMenuItem[] figs = new JMenuItem[5];
        for (int i = 0; i < 5; i++) {
            figs[i]=new JMenuItem(JMyPanel.Figure.values()[i].toString());
            figs[i].addActionListener(this);
            myBox.add(figs[i]);//��������� ������ � ����������
            if (i!=4){ //��� ���� ������ ����� ��������� ��������� ������� ����� ������
                myBox.add(Box.createHorizontalGlue());
            }
            menu.add(figs[i]);
        }
        myBox.setAlignmentX(CENTER_ALIGNMENT);//������������� ��� ���������� ������������ �� ������
//���� � ����� ������ ��� �� �����, �.�. �� ���������� �������
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(myBox,BorderLayout.NORTH);
        add(myPanel,BorderLayout.CENTER);
        Dimension size=getSize();//���������� � ���������� size ������� ������ ����
        size.setSize(size.width+400, size.height+400);//������������� ����� ������ ����, ����������
//������� �� ������ �� 200
        setMinimumSize(size);
        pack();
        setVisible(true);
        setJMenuBar(menuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myPanel.ris(e.getActionCommand());//�������� ����� ris ����� ������ (��. JMyPanel.java)
    }
}
