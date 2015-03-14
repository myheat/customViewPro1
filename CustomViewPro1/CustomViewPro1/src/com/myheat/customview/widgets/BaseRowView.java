package com.myheat.customview.widgets; 

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午11:37:44 
 * 类说明 
 */
public abstract class BaseRowView extends LinearLayout{

	public BaseRowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public BaseRowView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public BaseRowView(Context context) {
		super(context);
	}
	
	public abstract void initializeData(BaseRowDescriptor descriptor);
	
	public abstract void notifyDataChanged();
}
 