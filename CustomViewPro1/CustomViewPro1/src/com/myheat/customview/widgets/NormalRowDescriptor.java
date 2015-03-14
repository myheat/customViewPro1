package com.myheat.customview.widgets; 
/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午9:29:33 
 * 类说明 
 */
public class NormalRowDescriptor extends BaseRowDescriptor{

	public int iconResId;
	public String label;
	public int actionImg;
	
	public NormalRowDescriptor(int iconResId,String label,int actionImg,RowActionEnum action,OnRowClickListener listener){
		this.iconResId = iconResId;
		this.label = label;
		this.action = action;
		this.listener = listener;
		this.actionImg = actionImg;
	}
}
 