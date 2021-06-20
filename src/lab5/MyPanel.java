package lab5;

import java.awt.*;
import javax.swing.JPanel;
class JMyPanel extends JPanel{ // ��� ����� �������� ����������� ������ JPanel
    //������� ������������ ������������ ����������
    public static enum Figure {LINE,OVAL,RECT,ROUNDRECT,CLEAR};
    private Figure vibor=Figure.CLEAR; //��������� ���������� ���� ���������� ������������
    //� ����������� �� �������� CLEAR
    public JMyPanel() { } //����������� ������ ������

    public void ris(String s) {//�����, ����� �������� �������� � ����������� ������
//�������� s ��������� �������� �� ����� ������ ������� ������ (��. MyGraph.java)
        vibor=Figure.valueOf(s); //�������������, ��� ����� ����������
        repaint(); //�������������� ���� ������, �.�. �������� ����� paintComponent
    }
    public void paintComponent(Graphics gr){ //���������������� ����� � ���������� ���� Graphics
        super.paintComponent(gr); // ����� ������ �� ������ ������������� ������
// � �������� ��� ��������� ���� Graphics
        Graphics2D g = (Graphics2D)gr; //�������������� ��������� � ���� Graphics2D
//������� ���������� ��� ����������� ������� (������������)
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        switch (vibor){ //� ����������� �� �������������� ������� ris �������� ��� vibor
            case LINE: g.drawLine(20, 20, 100, 100); break; //������ �����
            case OVAL: g.drawOval(20, 20, 100, 100); break; // ����
            case RECT: g.drawRect(20, 20, 100, 100); break; // �������������
            case ROUNDRECT: g.drawRoundRect(20, 20, 100, 100,60,60); break; // ������������� ��
//������������ ������, ������ ������ ��������� � ����� ��, ��� � ��������������,
//��� 2 � ���������� ����� �� � � �� �
            case CLEAR: g.clearRect(0, 0, getSize().width, getSize().height);break; //�������
        }
    }
}