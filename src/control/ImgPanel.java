package control;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 * <p>标题: 欢迎窗口上的图片Panel</p>
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
public class ImgPanel extends JPanel {
    private Image img;
    float zoom;
    boolean hasShow = false;

    public ImgPanel() {
    }

    public ImgPanel(Image image) {
        img = image;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setImage(Image image) {
        img = image;
        hasShow = false;
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!hasShow) {
            if (img != null) {
                int iw = img.getWidth(this);
                int ih = img.getHeight(this);
                int siw = (int) Math.ceil((float) iw * zoom);
                int sih = (int) Math.ceil((float) ih * zoom);
                Dimension sz = this.getSize();
                int ofx = (sz.width - siw) / 2;
                int ofy = (sz.height - sih) / 2;
                g.clearRect(ofx, ofy, iw, ih);
                g.drawImage(img, ofx, ofy, ofx + siw, ofy + sih, 0, 0, iw, ih, this);
            }
        }
    }
    public void HasShowed() {
        hasShow = true;
    }
    public void ClearImage() {
        this.removeAll();
        if (img != null) {
            int iw = img.getWidth(this);
            int ih = img.getHeight(this);
            int siw = (int) Math.ceil((float) iw * zoom);
            int sih = (int) Math.ceil((float) ih * zoom);
            Dimension sz = this.getSize();
            int ofx = (sz.width - siw) / 2;
            int ofy = (sz.height - sih) / 2;
            this.getGraphics().clearRect(ofx, ofy, iw, ih);
        }
    }
    private void jbInit() throws Exception {
        int PanelHeight = this.getHeight() - 2; // 2边Border的宽度
        int PanelWidth = this.getWidth() - 2;
        int ImageHeight = img.getHeight(this);
        int ImageWidth = img.getWidth(this);
        int WidthDifferenceValue, HeightDifferenceValue;
        float HeightZoom = 0, WidthZoom = 0;
        WidthDifferenceValue = ImageWidth - PanelWidth;
        HeightDifferenceValue = ImageHeight - PanelHeight;
        if (WidthDifferenceValue > 0) {
            WidthZoom = (float) PanelWidth / ImageWidth;
        } else if (WidthDifferenceValue == 0) {
            WidthZoom = 1;
        } else if (WidthDifferenceValue < 0) {
            WidthZoom = (float) ImageWidth / PanelWidth;
        }
        if (HeightDifferenceValue > 0) {
            HeightZoom = (float) PanelHeight / ImageHeight;
        } else if (HeightDifferenceValue == 0) {
            HeightZoom = 1;
        } else if (HeightDifferenceValue < 0) {
            HeightZoom = (float) ImageHeight / PanelHeight;
        }
        if (HeightZoom >= WidthZoom) {
            zoom = WidthZoom;
        } else {
            zoom = HeightZoom;
        }
    }
    public void SetImage(Image image) {
        img = image;
    }
    public float ZoomRate() {
        return zoom;
    }
    public int ZoomPercent() {
        float zoomRatePercent = zoom * 100;
        return (int) zoomRatePercent;
    }
    public static void main(String[] args) {
        ImagePanel imagepanel = new ImagePanel();
    }
}
