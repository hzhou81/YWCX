package common;

/**
 * <p>标题: 公共参数</p>
 *
 * <p>描述: 使用Singleton模型</p>
 *
 * <p>版权: Copyright (c) 2005</p>
 *
 * <p>单位: 上海二手车交易市场有限公司</p>
 *
 * @作者 孙汇洲
 * @版本 1.0
 */
public  class Param {
    public static Param instance = new Param();
    // 窗体停留时间
    private static final int TypeTime=20;
    private static final int NumTime=30;
    private static final int ResultTime=35;
    // 号牌种类和号牌号码
    private String VT="";
    private String VN="";
    private String hphm="",hpzl="",yw="";
    // 数据库连接相关
    private final String url="jdbc:oracle:thin:@10.0.0.203:1521:ora9";
    private final String user="cl";
    private final String password="icannottellyou";
    private DataBase db=new DataBase(url,user,password);
    // 查询类别
    private int SearchType;
    public static final int YWQK=1;
    public static final int CLWZ=2;

    public static int getTypeTime(){
        return TypeTime;
    }
    public static int getNumTime(){
        return NumTime;
    }
    public static int getResultTime(){
            return ResultTime;
    }
    public static Param getInstance(){
        if(instance==null){
            instance=new Param();
        }
        return instance;
    }
    public String getHPHM(){
        return hphm;
    }
    public void setHPHM(String HPHM){
        hphm=HPHM;
    }
    public String getHPZL(){
        return hpzl;
    }
    public void setHPZL(String HPZL){
        hpzl=HPZL;
    }
    public String getYW(){
        return yw;
    }
    public void setYW(String YW){
        yw=YW;
    }
    public DataBase getDB(){
        return db;
    }
    public int GetSearchType(){
        return SearchType;
    }
    public void SetSearchType(int type){
        SearchType=type;
    }
}
