package control;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

/**
 * <p>����: ��ӭ�����ϵ�ͼƬPanel</p>
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
        int PanelHeight = this.getHeight() - 2; // 2��Border�Ŀ��
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
