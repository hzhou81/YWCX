package control;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.ImageIcon;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * <p>标题: </p>
 *
 * <p>描述: </p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 not attributable
 * @版本 1.0
 */
public class ImagePanel extends JPanel {
    BorderLayout borderLayout1 = new BorderLayout();
    JLabel ImageLabel = new JLabel();
    String imageName;

    public ImagePanel(){

    }
    public ImagePanel(String ImageName) {
        imageName=ImageName;
        try {
            jbInit();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        setLayout(borderLayout1);
        ImageLabel.setText("");
        this.add(ImageLabel, java.awt.BorderLayout.CENTER);
        URL url=this.getClass().getResource(imageName);
        ImageIcon ii=new ImageIcon(url);
        ImageLabel.setIcon(ii);
        Dimension PanelSize=this.getSize();
        ImageLabel.setSize(PanelSize);
    }

    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(new Dimension(1024,768));
        ImagePanel imagePanel=new ImagePanel("background.jpg");
        frame.getContentPane().add(imagePanel);
        // JButton jButton=new JButton();
        // imagePanel.add(jButton);
        frame.setVisible(true);

    }
}
