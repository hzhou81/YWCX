package common;

import java.text.ParseException;
import java.util.regex.*;

import javax.swing.text.DefaultFormatter;

/**
 * <p>����: �����ʾʽ����ƥ��</p>
 *
 * <p>����: </p>
 *
 * <p>��Ȩ: Copyright (c) 2005</p>
 *
 * <p>��˾: �Ϻ����ֳ������г����޹�˾</p>
 *
 * @���� �����
 * @�汾 1.0
 */
public class Regexplain {
    private Pattern pattern;
    private Matcher matcher;

    public Regexplain() {
        super();
    }
    public Regexplain(String pattern) throws PatternSyntaxException {
        this();
        setPattern(Pattern.compile(pattern));
    }
    public Regexplain(Pattern pattern) {
            this();
            setPattern(pattern);
    }
    public void setPattern(Pattern pattern) {
        this.pattern = pattern;
    }
    public Pattern getPattern() {
            return pattern;
    }
    protected void setMatcher(Matcher matcher) {
        this.matcher = matcher;
    }
    protected Matcher getMatcher() {
        return matcher;
    }
    public boolean IsMatch(String regex){
        Pattern pattern=getPattern();
        if(pattern!=null){
            Matcher matcher=pattern.matcher(regex);
            return matcher.matches();
        }else return false;
    }
}
