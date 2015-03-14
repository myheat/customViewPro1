package com.myheat.customview.widgets; 
/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午11:19:42 
 * 类说明 
 */
public class ProfileRowDescriptor extends BaseRowDescriptor{

	public int iconResId;
	public String label;
	public String detailLabel;
	public int actionImg;
	
	
	public ProfileRowDescriptor(int iconResId, String label, String detailLabel,
			int actionImg,RowActionEnum action,OnRowClickListener listener) {
		super();
		this.iconResId = iconResId;
		this.label = label;
		this.detailLabel = detailLabel;
		this.actionImg = actionImg;
		this.listener = listener;
		this.action = action;
	}
	
	
	
	
	
	
}
 