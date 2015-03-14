package com.myheat.customview.widgets; 

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午10:36:58 
 * 类说明 
 */
public class ContainerView extends LinearLayout {

	private Context context;
	private ArrayList<GroupDescriptor> descriptors;

	public ContainerView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public ContainerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public ContainerView(Context context) {
		super(context);
		initView(context);
	}

	
	public void initView(Context context){
		this.context = context;
		setOrientation(VERTICAL);
	}
	
	public void initData(ArrayList<GroupDescriptor> descriptors){
		this.descriptors = descriptors;
	}

	public void notifyDataChanged() {
		// TODO Auto-generated method stub
		if(descriptors != null && descriptors.size() > 0){
			GroupView groupView = null;
			float density = context.getResources().getDisplayMetrics().density;
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
			params.topMargin = (int)(20*density);
			for(GroupDescriptor descriptor:descriptors){
				groupView = new GroupView(context);
				groupView.initData(descriptor);
				groupView.notifyDataChanged();
				addView(groupView,params);
			}
			setVisibility(View.VISIBLE);
		}else {
			setVisibility(View.GONE);
		}
	}
}
 