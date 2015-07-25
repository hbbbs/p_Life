package zen.frame.domain.model.dic;

import dc.base.util.sort.ISortable;
import dc.base.util.sort.Sortor;
import dc.frame.service.baseDic.IDicStrCode;
import dc.frame.service.baseDic.IDicStrDecorate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 是、否
 */
public enum YesNo implements ISortable, IDicStrDecorate, IDicStrCode {
    是("是", "是", 10),
    否("否", "否", 20),;

    private boolean blnUse = true; //是否有效
    private int intOrder; //排序字段
    private String strDecorate; //文字装饰
    private String strCode; //CODE

    private YesNo() {
    }

    ;

    private YesNo(boolean blnUse) {
        this.blnUse = blnUse;
    }

    private YesNo(int intOrder) {
        this.intOrder = intOrder;
    }

    private YesNo(String strCode, String strDecorate, int intOrder) {
        this.strDecorate = strDecorate;
        this.intOrder = intOrder;
        this.strCode = strCode;
    }

    private YesNo(int intOrder, boolean blnUse) {
        this.blnUse = blnUse;
        this.intOrder = intOrder;
    }

    private YesNo(String strDecorate) {
        this.strDecorate = strDecorate;
    }

    private YesNo(String strDecorate, int intOrder) {
        this.strDecorate = strDecorate;
        this.intOrder = intOrder;
    }

    public static List<YesNo> getList() {
        List<YesNo> list = new ArrayList<YesNo>();
        for (int i = 0; i < YesNo.values().length; i++) {
            if (YesNo.values()[i].isBlnUse()) {
                list.add(YesNo.values()[i]);
            }
        }
        Collections.sort(list, new Sortor()); //排序
        return list;
    }

    public boolean isBlnUse() {
        return blnUse;
    }

    public void setBlnUse(boolean blnUse) {
        this.blnUse = blnUse;
    }

    public int getIntOrder() {
        return intOrder;
    }

    public void setIntOrder(int intOrder) {
        this.intOrder = intOrder;
    }

    public String getStrDecorate() {
        return strDecorate;
    }

    public void setStrDecorate(String strDecorate) {
        this.strDecorate = strDecorate;
    }

    public String getStrCode() {
        return strCode;
    }

    public void setStrCode(String strCode) {
        this.strCode = strCode;
    }
}