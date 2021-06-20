package lab5;

import java.awt.*;
import javax.swing.JPanel;
class JMyPanel extends JPanel{ // наш класс является наследником класса JPanel
    //создаем перечисление используемых параметров
    public static enum Figure {LINE,OVAL,RECT,ROUNDRECT,CLEAR};
    private Figure vibor=Figure.CLEAR; //объявляем переменную типа созданного перечисления
    //и присваиваем ей значение CLEAR
    public JMyPanel() { } //конструктор нашего класса

    public void ris(String s) {//метод, вызов которого приводит к перерисовке панели
//параметр s принимает значение во время вызова данного метода (см. MyGraph.java)
        vibor=Figure.valueOf(s); //устанавливаем, что нужно нарисовать
        repaint(); //перерисовываем нашу панель, т.е. вызываем метод paintComponent
    }
    public void paintComponent(Graphics gr){ //переопределяемый метод с параметром типа Graphics
        super.paintComponent(gr); // вызов такого же метода родительского класса
// и передача ему параметра типа Graphics
        Graphics2D g = (Graphics2D)gr; //преобразование параметра к типу Graphics2D
//задание параметров для сглаживания графики (антиалиасинг)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (vibor){ //в зависимости от установленного методом ris значения для vibor
            case LINE: g.drawLine(20, 20, 100, 100); break; //рисуем линию
            case OVAL: g.drawOval(20, 20, 100, 100); break; // круг
            case RECT: g.drawRect(20, 20, 100, 100); break; // прямоугольник
            case ROUNDRECT: g.drawRoundRect(20, 20, 100, 100,60,60); break; // прямоугольник со
//скругленными краями, первые четыре параметра – такие же, как у прямоугольника,
//еще 2 – скругление углов по х и по у
            case CLEAR: g.clearRect(0, 0, getSize().width, getSize().height);break; //очищаем
        }
    }
}