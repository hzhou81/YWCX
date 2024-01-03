package common;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * <p>����: �������</p>
 *
 * <p>����: </p>
 *
 * <p>��Ȩ: Copyright (c) 2005</p>
 *
 * <p>��λ: �Ϻ����ֳ������г����޹�˾</p>
 *
 * @���� �����
 * @�汾 1.0
 */
public class SucemFrame extends JFrame{
    public SucemFrame() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.white);
        CheckScreenSize();
        SetWindowsSize();
    }
    private void CheckScreenSize(){
        // �����ʾ���ֱ���
        Dimension monitorSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (monitorSize.width < 1024 || monitorSize.height < 768) {
          JOptionPane.showMessageDialog(this, "Ϊ����õ�ʹ�ñ���������ʹ��1024*768����Ļ�ֱ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
          System.exit(0);
        }
    }
    private void SetSuitableSize(){
        // ���ú����Ĵ����С
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
        Insets inset = Toolkit.getDefaultToolkit().getScreenInsets(gc);
        int bottom = inset.bottom;
        int top = inset.top;
        int left = inset.left;
        int right = inset.right;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) screenSize.getWidth() - left - right;
        int y = (int) screenSize.getHeight() - top - bottom;
        this.setSize(new Dimension(x, y));
    }
    private void SetWindowsSize(){
        this.setSize(new Dimension(1024,768));
    }
    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        SucemFrame sucemframe = new SucemFrame();
        sucemframe.setVisible(true);
    }
}