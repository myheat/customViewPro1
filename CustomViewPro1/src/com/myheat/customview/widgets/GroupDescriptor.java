package com.myheat.customview.widgets; 

import java.util.ArrayList;

/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午10:38:21 
 * 类说明 
 */
public class GroupDescriptor {

	public String title;
	public ArrayList<BaseRowDescriptor> descriptors;
	public GroupDescriptor(ArrayList<BaseRowDescriptor> descriptors) {
		super();
		this.descriptors = descriptors;
	}
	public GroupDescriptor(String title, ArrayList<BaseRowDescriptor> descriptors) {
		super();
		this.title = title;
		this.descriptors = descriptors;
	}
	
}
 