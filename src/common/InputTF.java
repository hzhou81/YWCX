package common;


import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.*;
import javax.swing.text.PlainDocument;
import javax.swing.text.Document;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import java.util.*;

/*******************************************
*Copyrights
*
*All rights reserved.
*
*Filename：
*		InputTF.java
*Indentifier：
*
*Description：
*		这个文件是用来控制用户输入的组建集合，一：设定用户只能输入字符（大/小/限长）
*   二：设定用户只能输入限定字符（大/小/限长）三：设定用户只能输入数字（不限/限长）
* 四：设定用户只能输入的数据是日期型 五：设定用户可以输入安通常形式进行输入
*Version：
*		V1.0
*Author:
*		朱辉
*Finished：
*		2003年06月19日
*History:
*       (作者     日期     版本    说明)
*		文件修订历史纪录（一般情况下用中文）
********************************************/



public class InputTF extends JTextField implements FocusListener{

    private final Toolkit toolkit = Toolkit.getDefaultToolkit();
    private int maxlength,type;

    public static final int NormalInput                                         = 0;

    public static final int NumInput                                            = 10;

    public static final int LetterInput                                         = 20;

    public static final int UperLetterInput                                     = 30;

    public static final int LowerLetterInput                                    = 40;

    public static final int DateInput                                           = 50;

    private static final int AcceptInput                                        = 60;

    public static final int UperLetterAndNumInput                               = 70;

    private boolean limited = false;
    private static Object current = null;
    private Vector accept = null;
    public InputTF() {

        limited = false;
        maxlength = 0;
        setDocument(createDefaultModel());
        this.addFocusListener(this);
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public InputTF(int column) {
        super(column);
        setDocument(createDefaultModel());
        this.addFocusListener(this);
    }
    public InputTF(int type,int column) {
        super(column);
        this.type = type;
        setDocument(createDefaultModel());
        this.addFocusListener(this);
    }
    public InputTF(int type,int column,int maxlength) {
        this.type = type;
        this.maxlength = maxlength;
        setDocument(createDefaultModel());
        this.addFocusListener(this);
    }
    /*
    public void setNotNull(boolean flg)
    {
        if(flg)
            addFocusListener(this);
        else
            removeFocusListener(this);
    }
    */
    public void focusGained(FocusEvent e)
    {
        if(current == null)
            current = this;
        this.select(0,getText().trim().length());
    }
    public void focusLost(FocusEvent e){}
/*
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()== current )
        {
            if(getText().trim().length() ==0)
            {
                //JOptionPane option = new JOptionPane("不能为空值，请输入！",JOptionPane.WARNING_MESSAGE);
                //option.createDialog(this.getParent(),"非空校验").show();
                JOptionPane.showMessageDialog(this,"不能为空值，请输入！","非空校验",JOptionPane.WARNING_MESSAGE);
                grabFocus();
            }
        }
        else
        {
                current = null;
        }
    }
*/
    public void setMaxLength(int length)
    {
        this.maxlength = length;
        setDocument(this.createDefaultModel());
    }
    public void setInputOnly(int type)
    {
        this.type = type;
        setDocument(this.createDefaultModel());
    }
    public void setInputOnly(char[] accepts)
    {
        accept = new Vector();
        for(int i=0; i<accepts.length;i++)
        {
            char[] temp = {accepts[i]};
            accept.add(new String(temp));
        }
        this.type = this.AcceptInput;
        this.setDocument(this.createDefaultModel());
    }
    public void setInputOnly(String[] accepts)
    {
        accept = new Vector();
        for(int i=0; i<accepts.length;i++)
        {
            accept.add(accepts[i]);
        }
        this.type = this.AcceptInput;
        this.setDocument(this.createDefaultModel());
    }
    public Document createDefaultModel() {
        Document temp = null;
        if(type == NormalInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedInputDocument();
            else
                temp = super.createDefaultModel();
        }
        else if(type == this.NumInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedNumInputDocument();
            else
                temp = new NumInputDocument();
        }
        else if(type == this.LetterInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedLetterInputDocument();
            else
                temp = new LetterInputDocument();
        }
        else if(type == this.LowerLetterInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedLowerLetterInputDocument();
            else
                temp = new LowerLetterInputDocument();
        }
        else if(type == this.UperLetterInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedUperLetterInputDocument();
            else
                temp = new UperLetterInputDocument();
        }
        else if(type == this.DateInput)
        {
            temp = new DateInputDocument(this);
        }
        else if(type == this.AcceptInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedAcceptInputDocument();
            else
                temp = new AcceptInputDocument();

        }
        else if(type == this.UperLetterAndNumInput)
        {
            if(this.maxlength != 0)
                temp = new LimitedUperLetterAndNumInputDocument();
            else
                temp = new UperLetterAndNumInputDocument();//AcceptInputDocument();

        }//UperLetterAndNumInput
        return temp;
    }

    private void jbInit() throws Exception {
    }

    private class LimitedInputDocument extends PlainDocument
    {

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException
        {
            int length = this.getContent().length();
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs,str,a);
        }
    }
    private class LimitedNumInputDocument extends PlainDocument {
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str == null)
                return;
            int length = this.getContent().length();
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isDigit(source[i]))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs,str,a);
        }
    }
    private class LowerLetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null)
                str = str.toLowerCase();
            else
                return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else
                {
                    toolkit.beep();
                    return;
                }
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class LimitedLowerLetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            int length = this.getContent().length();
            if(str != null)
                str = str.toLowerCase();
            else
                return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else
                {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class LimitedLetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str == null)
                return;
            int length = this.getContent().length();
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class LetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str == null)
                return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            int length = this.getContent().length();
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class NumInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str == null)
                return;
            int length = this.getContent().length();

            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;

            for (int i = 0; i < result.length; i++) {
                if (Character.isDigit(source[i]))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            super.insertString(offs, str, a);
        }
    }
    private class UperLetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null)
                str = str.toUpperCase();
            else
                return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else
                {  toolkit.beep();
                    return;
                }
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class UperLetterAndNumInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null){
                //System.out.println(str);
                str = str.toUpperCase();
                //System.out.println(str);
            }
            else
                return;
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i])||Character.isDigit(source[i]))
                    result[j++] = source[i];
                else
                {
                    System.out.println(str);
                    toolkit.beep();
                    return;
                }
            }
            //super.insertString(offs, str, a);
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class LimitedUperLetterAndNumInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null)
                str = str.toUpperCase();
            else
                return;
            int length = this.getContent().length();
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i])||Character.isDigit(source[i]))
                    result[j++] = source[i];
                else
                {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class LimitedUperLetterInputDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            if(str != null)
                str = str.toUpperCase();
            else
                return;
            int length = this.getContent().length();
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isLetter(source[i]))
                    result[j++] = source[i];
                else
                {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
        }
    }
    private class DateInputDocument extends PlainDocument {
        private JTextField field = null;
        public DateInputDocument(JTextField field)
        {
            this.field = field;
        }
        private SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException {
            Date value = null;
            if(str == null)
                return;
            int length = getContent().length();
            String txt = getContent().getString(0,length);
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++) {
                if (Character.isDigit(source[i]))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            if(9 <= txt.length())
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs, new String(result, 0, j), a);
            length = getContent().length();
            txt = getContent().getString(0,length);
            if(length == 2)
            {
                if(!set0_2(length,txt)) return;
            }
            if(length==6)
            {
                if(!check4_5(length,txt)) return;
            }
            if(length==7)
            {
                if(!check4_6(length,txt)) return;
            }
            if(length==8)
            {
                if(!check4_5(length,txt)) return;
                if(!check4_6(length,txt)) return;
                if(!check6_7(length,txt)) return;
            }
            String date = null;
            if(length == 9)
            {
                if(!check4_5(length,txt)) return;
                if(!check4_6(length,txt)) return;
                if(!check6_7(length,txt)) return;
                if(!check0_6(length,txt)) return;
            }
        }
        private boolean set0_2(int length,String txt)
        {
            String year = txt.substring(0,1);
            int qianwei = Integer.parseInt(year);
            if(qianwei == 0)
            {
                long current = System.currentTimeMillis();
                String currStr = format.format(new Date(current));
                currStr = currStr.substring(0,4);
                field.setText(currStr);
                return false;
            }
            return true;
        }
        private boolean check4_5(int length, String txt)
        {
            String month = txt.substring(4,5);
            int shiwei = Integer.parseInt(month);
            if(shiwei > 1)
            {
                showInvalidateMonth();
                String year = txt.substring(0,4);
                field.setText(year);
                return false;
            }
            return true;
        }
        private boolean check4_6(int length,String txt)
        {
            String month = txt.substring(4,6);
            String _1 = month.substring(0,1);
            String _0 = month.substring(1,2);
            int shiwei = Integer.parseInt(_1);
            int gewei = Integer.parseInt(_0);
            if(shiwei > 1 || (shiwei == 1 && gewei > 2) || (shiwei == 0 && gewei == 0))
            {
                showInvalidateMonth();
                String year = txt.substring(0,5);
                field.setText(year);
                return false;
            }
            return true;
        }
        private boolean check6_7(int length,String txt)
        {
            String month = txt.substring(6,7);
            int shiwei = Integer.parseInt(month);
            if(shiwei > 3)
            {
                showInvalidateDayNum();
                String year = txt.substring(0,6);
                field.setText(year);
                return false;
            }
            return true;
        }
        private boolean check0_6(int length,String txt)
        {
            String y_month = txt.substring(0,6);
            //System.out.println(month);
            String date = txt.substring(6,8);
            String _1 = date.substring(0,1);
            String _0 = date.substring(1,2);
            int shiwei = Integer.parseInt(_1);
            int gewei = Integer.parseInt(_0);
            if(shiwei > 3 || (shiwei == 3 && gewei > 1) || (shiwei == 0 && gewei == 0) )
            {
                showInvalidateDayNum();
                field.setText(y_month);
                return false;
             }
            return true;
        }
        private void showInvalidateMonth()
        {
            JOptionPane.showMessageDialog(field,"无效月份,请按照重新输入！","错误信息",JOptionPane.ERROR_MESSAGE);
        }
        private void showInvalidateDayNum()
        {
            JOptionPane.showMessageDialog(field,"无效日数,请按照重新输入！","错误信息",JOptionPane.ERROR_MESSAGE);
        }
    }
    private class AcceptInputDocument extends PlainDocument
    {

        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException
        {
            if(str != null)
                str = str.toUpperCase();
            else
                return;

            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++)
            {
                char[] temp = {source[i]};
                if(accept.contains(new String(temp)))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            super.insertString(offs,str,a);
        }
    }
    private class LimitedAcceptInputDocument extends PlainDocument
    {
        public void insertString(int offs, String str, AttributeSet a)
                throws BadLocationException
        {
            if(str != null)
                str = str.toUpperCase();
            else
                return;
            int length = this.getContent().length();
            char[] source = str.toCharArray();
            char[] result = new char[source.length];
            int j = 0;
            for (int i = 0; i < result.length; i++)
            {
                char[] temp = {source[i]};
                if(accept.contains(new String(temp)))
                    result[j++] = source[i];
                else {
                    toolkit.beep();
                    return;
                }
            }
            if(maxlength < length)
            {
                toolkit.beep();
                return;
            }
            super.insertString(offs,str,a);
        }
    }
}
