package control;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 * <p>Title: �ͷ�ϵͳ</p>
 *
 * <p>Description: �Զ��п���JTable</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: �Ϻ����ֳ������г�</p>
 *
 * @author  ���
 * @version 1.0
 */
public class DataGrid extends JTable {
    public DataGrid() {
        setRowSelectionAllowed(true);
        enableInputMethods(false);
        getTableHeader().setFont(new java.awt.Font("Dialog", 0, 35)); // ���ñ�ͷ����
        this.setFont(new java.awt.Font("Dialog", 0, 35)); // �����ڲ�����
        enableInputMethods(false);
        this.setRowHeight(40);
    }
      public void setHeaderFont(Font font) {
        getTableHeader().setFont(font);
      }

      //�Ƚ���������ֵ��������������ֵ
      public static int getMax(int i1, int i2) {
        if (i1 < i2) {
          return i2;
        }
        else {
          return i1;
        }
      }

      public int getMaxLength(int c) { //��������кţ��ó������������ݳ���
        int r = this.getRowCount();
        int max = 0, i = 0, ilen = 0;
        String tmp;
        for (i = 0; i < r; i++) {
          //ilen=j.getValueAt(i,c).toString("ISO-8859-1");//UTF-8
          tmp = ( (String)this.getValueAt(i, c));
          ilen = getStrLen(tmp);
          //String tmp1=String(tmp,"UTF-8");
          max = getMax(max, ilen);
        }
        tmp = this.getColumnName(c);
        ilen = getStrLen(tmp);
        max = getMax(max, ilen);
        return max;
      }

      //�����ַ������ȣ������ַ��������λ����
      public static int getStrLen(String s) {
        char c;
        if (s == null) {
          return 0;
        }
        int ilen = s.length();
        for (int i = 0; i < s.length(); i++) {
          c = s.charAt(i);
          if (c > 256) {
            ilen++;
          }
        }
        return ilen;
      }

      //�����б��ؼ���ÿһ����ʾ����
      public void setTableColumnSize(int scale) {
        setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //�������ʾ�б�����ʾ����
        int c = 0, cl;
        String tmp = "";
        for (c = 0; c < this.getColumnCount(); c++) {
          tmp = this.getColumnName(c);
          cl = (getMaxLength(c)) * scale;
          this.getColumn(tmp).setPreferredWidth(cl);
        }
      }

      //����ĳһ��ֵ����ָ��ֵ���кţ��кŴ�0��ʼ
      public int findKey(int key, String value) {
        int ir = this.getRowCount();
        for (int i = 0; i < ir; i++) {
          if (value.equals(this.getValueAt(i, key))) {
            return i;
          }
        }
        return -1;
      }

      //����ĳһ��ֵ����ָ��ֵ���кţ��кŴ�0��ʼ
      public int findKey(String key, String value) {
        int col = getColumnId(key);
        if (col == -1) {
          return -1;
        }
        return findKey(col, value);
      }

      //���б��и�������ȡ��Ӧ���кţ�����-1Ϊδ�ҵ���Ӧ���к�
      public int getColumnId(String colname) {
        int ic = this.getColumnCount();
        for (int i = 0; i < ic; i++) {
          if (colname.equals(this.getColumnName(i))) {
            return i;
          }
        }
        return -1;
      }

      //����ָ����
      public void setRowSelected(int row) {
        this.setRowSelectionInterval(row, row);
      }

      //����ָ����
      public void setRowSelected(String key, String value) {
        int row = findKey(key, value);
        if (row == -1) {
          return;
        }
        this.setRowSelectionInterval(row, row);
      }

      //ȡ��ָ���з�Χ��ָ���е���Сֵ�к�
      public int getMinValueRow(String key, int start, int end) {
        int col = this.getColumnId(key);
        int rowstart = start;
        int i, min = rowstart;
        String minval = "", tmp = "";
        minval = this.getValueAt(rowstart, col).toString();
        for (i = rowstart; i < end; i++) {
          tmp = this.getValueAt(i, col).toString();
          if (minval.compareTo(tmp) > 0) {
            minval = tmp;
            min = i;
          }
        }
        return min;
      }

      //ȡ�������з�Χ��ָ���е���Сֵ�к�
      public int getMinValueRow(String key) {
        return getMinValueRow(key, 0, this.getRowCount());
      }

      //��ָ���а�����������
      public void sortByKey(String key) {
        int col = this.getColumnId(key);
        int start = 0, end = this.getRowCount();
        int i, min;
        String minval = "", tmp = "";
        DefaultTableModel table;
        while (start < end) {
          min = start;
          minval = this.getValueAt(start, col).toString();
          for (i = start; i < end; i++) {
            tmp = this.getValueAt(i, col).toString();
            if (minval.compareTo(tmp) > 0) {
              minval = tmp;
              min = i;
            }
          }
          table = (DefaultTableModel)this.getModel();
          table.moveRow(min, min, start);
          start++;
        }
      }

      public void removeRow(int row) {
        DefaultTableModel table = (DefaultTableModel)this.getModel();
        table.removeRow(row);
      }

      public void sortByKey(String key1, String key2) {
        int col1 = this.getColumnId(key1);
        int col2 = this.getColumnId(key2);
        int start = 0, end = this.getRowCount();
        int i, min;
        String minval = "", tmp = "";
        DefaultTableModel table;
        while (start < end) {
          min = start;
          minval = this.getValueAt(start, col1).toString() +
              this.getValueAt(start, col2).toString();
          for (i = start; i < end; i++) {
            tmp = this.getValueAt(i, col1).toString() +
                this.getValueAt(i, col2).toString();
            if (minval.compareTo(tmp) > 0) {
              minval = tmp;
              min = i;
            }
          }
          table = (DefaultTableModel)this.getModel();
          table.moveRow(min, min, start);
          start++;
        }
      }

      //���Table�����ݣ����������ͷ
      public void clearList() {
        DefaultTableModel dt = (DefaultTableModel)this.getModel();
        while (dt.getRowCount() > 0) {
          dt.removeRow(0);
        }
  }
    public static void main(String[] args) {
    }
}