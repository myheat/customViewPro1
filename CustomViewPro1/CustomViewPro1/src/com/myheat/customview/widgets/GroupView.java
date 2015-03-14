package com.myheat.customview.widgets; 

import java.util.ArrayList;
import com.myheat.customview.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午9:26:33 
 * 类说明 
 */
public class GroupView extends LinearLayout{

	private ArrayList<BaseRowDescriptor> descriptors;
	private Context context;

	public GroupView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initView(context);
	}

	public GroupView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initView(context);
	}

	public GroupView(Context context) {
		super(context);
		initView(context);
	}
	
	public void initView(Context context){
		this.context = context;
	}

	public void initData(GroupDescriptor descriptor){
		this.descriptors = descriptor.descriptors;
		setOrientation(VERTICAL);
	}
	
	public void notifyDataChanged(){
		if(descriptors != null && descriptors.size() > 0){
			BaseRowView row = null;
			View line = null;
			float density = context.getResources().getDisplayMetrics().density;
			LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,1);
			params.leftMargin = (int)(10*density);
			BaseRowDescriptor descriptor = null;
			for(int i = 0; i < descriptors.size(); i++){
				descriptor = descriptors.get(i);
				
				if(descriptor instanceof NormalRowDescriptor){
					row = new NormalRowView(context);
				}else if(descriptor instanceof ProfileRowDescriptor){
					row = new ProfileRowView(context);
				}
				
				row.initializeData(descriptor);
				row.notifyDataChanged();
				addView(row);
				if(i != descriptors.size() -1){
					line = new View(context);
					line.setBackgroundResource(R.color.widget_general_row_line);
					addView(line,params);
				}
			}
		}else {
			setVisibility(View.GONE);
		}
	}
}
 