package common;

import java.sql.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 * <p>����: ����ģ��</p>
 *
 * <p>����: ��ResultSetת����JTable��ʶ���ģ��</p>
 *
 * <p>�汾: Copyright (c) 2005</p>
 *
 * <p>��˾: �Ϻ����ֳ������г����޹�˾</p>
 *
 * @����:   �����
 * @version 1.0
 */
public class DataSet
    implements TableModel {
  int columnCount;
  Vector columnNames = new Vector();
  Vector rowData = new Vector();
  Vector tableData = new Vector();

  public DataSet(ResultSet resultSet) throws SucemException {
    if (resultSet != null) {
      try {
        ResultSetMetaData rsmd = resultSet.getMetaData();
        columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
          columnNames.addElement(rsmd.getColumnName(i));
        }
        while (resultSet.next()) {
          rowData = new Vector(columnCount);
          for (int j = 1; j <= columnCount; j++) {
            rowData.addElement(resultSet.getObject(j));
          }
          tableData.addElement(rowData);
        }

      }
      catch (SQLException ex) {
        throw new SucemException(ex);
      }
      finally{
        try {
            resultSet.close();
            Param.getInstance().getDB().colseStatement();
        } catch (SQLException ex1) {
            throw new SucemException(ex1);
        }
      }
    }
  }

  public int getColumnCount() {
    return columnNames.size();
  }

  public int getRowCount() {
    return tableData.size();
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    Vector theRow = (Vector) tableData.elementAt(rowIndex);
    return theRow.elementAt(columnIndex);
  }

  public String getColumnName(int column) {
    return columnNames.elementAt(column).toString();
  }

  public boolean isCellEditable(int rowIndex, int columnIndex) {
    return false;
  }

  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    Vector theRow = (Vector) tableData.elementAt(rowIndex);
    theRow.elementAt(columnIndex).equals(aValue);
  }

  public Class getColumnClass(int columnIndex) {
    return columnNames.elementAt(columnIndex).getClass();
  }

  public void addTableModelListener(TableModelListener l) {
  }

  public void removeTableModelListener(TableModelListener l) {
  }
}