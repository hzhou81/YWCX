package common;

import java.io.*;

/**
 * <p>Title: 自定义异常类</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class SucemException
    extends Exception {
  private Exception _exp = null;
  public SucemException() {
    super();
  }

  public SucemException(String ErrorMessage) {
    super(ErrorMessage);
  }

  public SucemException(Exception exception) {
    super(exception.getMessage());
    _exp = exception;
  }

  public Exception getException() {
    return this._exp;
  }

  public void printStackTrace() {
    if (_exp != null) {
      _exp.printStackTrace();
    }
  }

  public void printStackTrace(PrintStream s) {
    if (_exp != null) {
      _exp.printStackTrace(s);
    }
  }

  public void printStackTrace(PrintWriter pw) {
    if (_exp != null) {
      _exp.printStackTrace(pw);
    }
  }
}
