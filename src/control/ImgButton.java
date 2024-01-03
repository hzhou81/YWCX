package control;

import javax.swing.*;
import java.awt.Image;
import java.awt.Graphics;

/**
 * <p>标题: 图片按钮(旧的，暂时不用的ImageButton)</p>
 *
 * <p>描述: </p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 孙汇洲
 * @版本 1.0
 */
public class ImgButton extends JButton {
    private Image img;
    private String imgName;
    int _height, _width;
    JLabel jLabel1 = new JLabel();

    public ImgButton(Image Img) {
      this.img = Img;
    }
    public ImgButton(String ImageName){
        imgName=ImageName;
        ImageIcon ii=new ImageIcon(this.getClass().getResource(imgName));
        img=ii.getImage();
    }
    public ImgButton(String ImageName,int Width,int Height){
        imgName=ImageName;
        ImageIcon ii=new ImageIcon(this.getClass().getResource(imgName));
        img=ii.getImage();
        _height=Height;
        _width=Width;
    }

    public ImgButton() {
    }

    public void GetImage(Image image, int Width, int Height) {
      this.img = image;
      _width = Width;
      _height = Height;
      try {
        jbInit();
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }

    }

    private void jbInit() throws Exception {
        jLabel1.setText("jLabel1");
        this.add(jLabel1);
    }

    public void paint(Graphics g) {
      if (img != null) {
        g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
      }
    }
    public static void main(String[] args) {
        ImgButton imagebutton = new ImgButton();
    }
}
