package dc.frame.util.dic;

import dc.frame.service.baseDic.IDicStrCode;
import dc.frame.service.baseDic.IDicStrCode_Ext1;
import dc.util.java.arrayoper.ArrayOper;

import java.util.Iterator;
import java.util.List;

public class DicUtil {
	
	/**
	 * 		根据传入的Code 返回 DIC
	 */
	public static IDicStrCode getDic_byCode(List list,String strCode){
		for (Iterator<IDicStrCode> iterator = list.iterator(); iterator.hasNext();) {
			IDicStrCode DicStrCode = (IDicStrCode) iterator.next();
			if(DicStrCode.getStrCode().equals(strCode)){
				return DicStrCode;
			}
			if(ArrayOper.isContain_Class(DicStrCode.getClass().getInterfaces(), IDicStrCode_Ext1.class)){
				if(((IDicStrCode_Ext1)DicStrCode).getStrCode1().equals(strCode)){
					return DicStrCode;
				}
			}
		}
		
		
		return null;
	}
}
