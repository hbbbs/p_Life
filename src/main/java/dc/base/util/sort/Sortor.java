package dc.base.util.sort;

import java.util.Comparator;
/**
 *		排序比较器
 */
public class Sortor implements  Comparator<ISortable>{

	public int compare(ISortable o1, ISortable o2) {
		if(o1.getIntOrder() == o2.getIntOrder()){
			return 0;
		}else if (o1.getIntOrder() > o2.getIntOrder() ){
			return 1;
		}else{
			return -1;
		}
	}

}
