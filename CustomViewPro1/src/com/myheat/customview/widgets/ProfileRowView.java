package com.myheat.customview.widgets; 

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.myheat.customview.R;

/** 
 * @author 作者 :  rzq
 * @version 创建时间：2015年3月14日 上午11:18:01 
 * 类说明 
 */
public class ProfileRowView extends BaseRowView implements View.OnClickListener{

	private Context context;
	private ImageView mWidgetRowActionImg;
	private ImageView mWidgetRowIconImg;
	private TextView mWidgetRowLabel;
	private TextView mWidgetRowDetailLabel;
	private ProfileRowDescriptor descriptor;
	private OnRowClickListener listener;
	public ProfileRowView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initializeView(context);
	}

	public ProfileRowView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initializeView(context);
	}

	public ProfileRowView(Context context) {
		super(context);
		initializeView(context);
	}
	
	
	private void initializeView(Context context) {
		this.context = context;
		LayoutInflater.from(context).inflate(R.layout.widget_profile_row, this);
		mWidgetRowActionImg = (ImageView) findViewById(R.id.mWidgetRowActionImg);
		mWidgetRowIconImg = (ImageView) findViewById(R.id.mWidgetRowIconImg);
		mWidgetRowLabel = (TextView)findViewById(R.id.mWidgetRowLabel);
		mWidgetRowDetailLabel = (TextView)findViewById(R.id.mWidgetRowDetailLabel);
		mWidgetRowActionImg.setImageResource(R.drawable.bakchat_submenu_normal);
	}


	@Override
	public void onClick(View v) {
		if (listener != null) {
			listener.onRowClick(descriptor.action);
		}
	}

	public void initializeData(BaseRowDescriptor descriptor) {
		this.descriptor = (ProfileRowDescriptor)descriptor;
		this.listener = descriptor.listener;
	}

	public void notifyDataChanged() {
		if (descriptor != null) {
			mWidgetRowIconImg.setBackgroundResource(R.drawable.ic_launcher);
			mWidgetRowLabel.setText(descriptor.label);
			mWidgetRowDetailLabel.setText(descriptor.detailLabel);
			if (descriptor.action != null) {
				setOnClickListener(this);
				setBackgroundResource(R.drawable.widgets_general_row_selector);
				mWidgetRowActionImg.setVisibility(View.VISIBLE);
			} else {
				setBackgroundColor(Color.WHITE);
				mWidgetRowActionImg.setVisibility(View.GONE);
			}
			setVisibility(View.VISIBLE);
		}else {
			setVisibility(View.GONE);
		}
	}

}
 