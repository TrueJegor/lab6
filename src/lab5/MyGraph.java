package lab5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGraph extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JMenu menu;
    private JMyPanel myPanel=new JMyPanel();//объ€вл€ем и создаем нашу панель дл€ рисовани€

    public static void main(String[] args) {
        new MyGraph("ќкно с графикой");//создаем окно
    }

    public MyGraph(String s){
        super(s);
        Box myBox=new Box(BoxLayout.X_AXIS);//создаем компоновку в виде горизонтального €щика
        menuBar = new JMenuBar();
        menu = new JMenu("‘игура");
        menuBar.add(menu);
        JMenuItem[] figs = new JMenuItem[5];
        for (int i = 0; i < 5; i++) {
            figs[i]=new JMenuItem(JMyPanel.Figure.values()[i].toString());
            figs[i].addActionListener(this);
            myBox.add(figs[i]);//добавл€ем кнопку в компоновку
            if (i!=4){ //дл€ всех кнопок кроме последней вставл€ем пружину после кнопки
                myBox.add(Box.createHorizontalGlue());
            }
            menu.add(figs[i]);
        }
        myBox.setAlignmentX(CENTER_ALIGNMENT);//устанавливаем дл€ компоновки выравнивание по центру
//хот€ в нашем случае это не важно, т.к. мы используем пружины
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(myBox,BorderLayout.NORTH);
        add(myPanel,BorderLayout.CENTER);
        Dimension size=getSize();//записываем в переменную size текущий размер окна
        size.setSize(size.width+400, size.height+400);//устанавливаем новый размер окна, увеличива€
//текущий по высоте на 200
        setMinimumSize(size);
        pack();
        setVisible(true);
        setJMenuBar(menuBar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        myPanel.ris(e.getActionCommand());//вызываем метод ris нашей панели (см. JMyPanel.java)
    }
}
