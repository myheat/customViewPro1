package com.myheat.customview.widgets;

import com.myheat.customview.R;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author 作者 : rzq
 * @version 创建时间：2015年3月13日 下午5:29:46 类说明
 */
public class NormalRowView extends BaseRowView implements View.OnClickListener{

	private Context context;
	private ImageView mWidgetRowActionImg;
	private TextView mWidgetRowLabel;
	private ImageView mWidgetRowIconImg;
	private NormalRowDescriptor normalRowDescriptor;

	public NormalRowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		initView();
	}

	public NormalRowView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		initView();
	}

	public NormalRowView(Context context) {
		super(context);
		this.context = context;
		initView();
	}

	private void initView() {
		LayoutInflater.from(context)
				.inflate(R.layout.widget_generall_row, this);
		mWidgetRowActionImg = (ImageView) findViewById(R.id.mWidgetRowActionImg);
		mWidgetRowLabel = (TextView) findViewById(R.id.mWidgetRowLabel);
		mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);

	}

//	public void initData(NormalRowDescriptor normalRowDescriptor) {
//		this.normalRowDescriptor = normalRowDescriptor;
//	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(normalRowDescriptor.listener != null){
			normalRowDescriptor.listener.onRowClick(normalRowDescriptor.action);
		}
	}

	public void notifyDataChanged() {
		// TODO Auto-generated method stub
		if(normalRowDescriptor != null){
			mWidgetRowIconImg.setBackgroundResource(normalRowDescriptor.iconResId);
			mWidgetRowLabel.setText(normalRowDescriptor.label);
			if(normalRowDescriptor.action != null){
				setOnClickListener(this);
				setBackgroundResource(R.drawable.widgets_general_row_selector);
				mWidgetRowActionImg.setBackgroundResource(normalRowDescriptor.actionImg);
			}else {
				setBackgroundColor(Color.WHITE);
				mWidgetRowActionImg.setVisibility(View.GONE);
			}
		}else {
			setVisibility(View.GONE);
		}
		
	}

	@Override
	public void initializeData(BaseRowDescriptor descriptor) {
		// TODO Auto-generated method stub
		this.normalRowDescriptor = (NormalRowDescriptor)descriptor;
	}

}
