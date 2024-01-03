package common;

import java.text.ParseException;
import java.util.regex.*;

import javax.swing.text.DefaultFormatter;

/**
 * <p>标题: 正则表示式进行匹配</p>
 *
 * <p>描述: </p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>公司: 上海二手车交易市场有限公司</p>
 *
 * @作者 孙汇洲
 * @版本 1.0
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
