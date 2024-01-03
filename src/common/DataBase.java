package common;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DataBase {

  static {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
    }
    catch (Exception e) {

    }
  }

  // 操作类型
  public static final int Update = 0;
  public static final int Insert = 1;

  private String _url;
  private String _user;
  private String _password;
  public DataBase() {}

  public DataBase(String url, String user, String password) {
    _url = url;
    _user = user;
    _password = password;
    try {
      createConnection();
    }
    catch (SQLException ex) {
    }
  }

  private Connection _connection = null;
  private Statement _statement = null;
  private CallableStatement _callablestatement = null;
  private PreparedStatement _pstmt = null;
  private ResultSet _resultset = null;

  public void createConnection(String url, String user, String password) throws
      SQLException {
    _url = url;
    _user = user;
    _password = password;
    createConnection();
  }

  public void createConnection() throws SQLException {
    _connection = DriverManager.getConnection(_url, _user, _password);
  }

  public void closeConnection() {

    if (_resultset != null) {
      try {
        _resultset.close();
      }
      catch (SQLException e) {
      }
      _resultset = null;
    }
    if (_statement != null) {
      try {
        _statement.close();
      }
      catch (SQLException e) {
      }
      _statement = null;
    }
    if (_callablestatement != null) {
      try {
        _callablestatement.close();
      }
      catch (SQLException e) {
      }
      _callablestatement = null;
    }
    if (_connection != null) {
      try {
        _connection.close();
      }
      catch (SQLException e) {
      }
      _connection = null;
    }
  }

  public ResultSet executeQuery(String sql) throws SQLException {
    _statement = _connection.createStatement();
    _resultset = _statement.executeQuery(sql);
    return _resultset;
  }

  public void colseStatement() {
    try {
      if (_statement != null) {
        _statement.close();
      }
    }
    catch (SQLException e) {

    }
  }

  public void executeTransaction(String[] s) throws SQLException {
    try {
      _connection.setAutoCommit(false);
      _statement = _connection.createStatement();
      for (int i = 0; i < s.length; i++) {
        _statement.executeUpdate(s[i]);
      }
      _connection.commit();
    }
    catch (SQLException ex) {
      _connection.rollback();
      throw new SQLException(ex.getMessage(), ex.getSQLState(), ex.getErrorCode());
    }
  }

  public void executeTransaction(Vector v) throws SQLException {
    try {
      _connection.setAutoCommit(false);
      _statement = _connection.createStatement();
      for (int i = 0; i < v.size(); i++) {
        _statement.executeUpdate(v.elementAt(i).toString());
      }
      _connection.commit();
    }
    catch (SQLException ex) {
      _connection.rollback();
      throw new SQLException(ex.getMessage(), ex.getSQLState(), ex.getErrorCode());
    }
  }

  public void executeTransaction(String s) throws SQLException {
    try {
      _connection.setAutoCommit(false);
      _statement = _connection.createStatement();
      _statement.executeUpdate(s);
      _connection.commit();
    }
    catch (SQLException ex) {
      _connection.rollback();
      throw new SQLException(ex.getMessage(), ex.getSQLState(), ex.getErrorCode());
    }
  }

  public void executeTransactionWithoutCommit(String s) throws SQLException {
    try {
      _connection.setAutoCommit(false);
      _statement = _connection.createStatement();
      _statement.executeUpdate(s);
    }
    catch (SQLException ex) {
      throw new SQLException(ex.getMessage(), ex.getSQLState(), ex.getErrorCode());
    }
  }


  //从结果集里得到列名集合
  public String[] getColumnName(ResultSet resultset) throws SQLException {
    if (resultset == null) {
      return null;
    }
    ResultSetMetaData resultmetadata = resultset.getMetaData();
    String[] s = new String[resultmetadata.getColumnCount()];
    for (int i = 0; i < resultmetadata.getColumnCount(); i++) {
      s[i] = resultmetadata.getColumnName(i + 1);
    }
    return s;
  }

  //从结果集里得到列类型名集合
  public String[] getColumnType(ResultSet resultset) throws SQLException {
    if (resultset == null) {
      return null;
    }
    ResultSetMetaData resultmetadata = resultset.getMetaData();
    String[] s = new String[resultmetadata.getColumnCount()];
    for (int i = 0; i < resultmetadata.getColumnCount(); i++) {
      s[i] = resultmetadata.getColumnTypeName(i + 1);
    }
    return s;
  }

  //取得指定列的长度集合
  public int[] getColumnLength(ResultSet resultset) throws SQLException {
    if (resultset == null) {
      return null;
    }
    ResultSetMetaData resultmetadata = resultset.getMetaData();
    int[] l = new int[resultmetadata.getColumnCount()];
    for (int i = 0; i < resultmetadata.getColumnCount(); i++) {
      l[i] = resultmetadata.getPrecision(i + 1);
    }
    return l;
  }

  //取得指定列的小数点后长度集合
  public int[] getColumnScale(ResultSet resultset) throws SQLException {
    if (resultset == null) {
      return null;
    }
    ResultSetMetaData resultmetadata = resultset.getMetaData();
    int[] l = new int[resultmetadata.getColumnCount()];
    for (int i = 0; i < resultmetadata.getColumnCount(); i++) {
      l[i] = resultmetadata.getScale(i + 1);
    }
    return l;
  }


  private String GetTableNameFromInsertSQL(String insertSQL) throws Exception {
    int j = insertSQL.indexOf("into");
    if (j == -1) {
      throw new Exception("不是合法的insert语句!");
    }
    else {
      int k = insertSQL.indexOf("values");
      if (k == -1) {
        throw new Exception("不是合法的insert语句!");
      }
      else {
        //下面肯定是一句合法的insert语句了，加以处理之
        String tmp = insertSQL.substring(j + 4, k);
        int l = tmp.indexOf("(");
        if (l == -1) {
          return tmp;
        }
        else {
          return tmp.substring(0, l);
        }
      }
    }

  }

  public void Commit() throws SQLException {
    _connection.commit();
  }

  public void RollBack() {
    try {
      _connection.rollback();
    }
    catch (SQLException ex) {

    }
  }

  public static void main(String[] args) {

  }
}
