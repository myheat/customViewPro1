package com.myheat.customview;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import com.myheat.customview.widgets.BaseRowDescriptor;
import com.myheat.customview.widgets.ContainerView;
import com.myheat.customview.widgets.GroupDescriptor;
import com.myheat.customview.widgets.OnRowClickListener;
import com.myheat.customview.widgets.ProfileRowDescriptor;
import com.myheat.customview.widgets.RowActionEnum;
import com.myheat.customview.widgets.NormalRowDescriptor;

public class MainActivity extends Activity implements OnRowClickListener {

	private ContainerView mWidgetContinerView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mWidgetContinerView =(ContainerView)findViewById(R.id.mWidgetContinerView);
		initView();
		
	}

	private void initView() {
		// TODO Auto-generated method stub
		ArrayList<GroupDescriptor> groupDescriptros = new ArrayList<GroupDescriptor>();
		
		ArrayList<BaseRowDescriptor>  profileRowDescriptors = new ArrayList<BaseRowDescriptor>();
		ProfileRowDescriptor profileRowDescriptor = new ProfileRowDescriptor(R.drawable.ic_launcher, "myheat", "this is joke!", R.drawable.bakchat_submenu_normal,RowActionEnum.MY_PROFILE,this);
		profileRowDescriptors.add(profileRowDescriptor);
		GroupDescriptor profileGroupDescriptor = new GroupDescriptor(profileRowDescriptors);
		groupDescriptros.add(profileGroupDescriptor);
		
		
		ArrayList<BaseRowDescriptor>  descriptors = new ArrayList<BaseRowDescriptor>();
		descriptors.add(new NormalRowDescriptor(R.drawable.more_my_album,"My Posts",R.drawable.bakchat_submenu_normal, RowActionEnum.MY_POST,this));
		descriptors.add(new NormalRowDescriptor(R.drawable.more_my_favorite,"Favorite Messages", R.drawable.bakchat_submenu_normal,RowActionEnum.MY_FAVORITE_MESSAGES,this));
		descriptors.add(new NormalRowDescriptor(R.drawable.more_my_bank_card,"My Bank Cards",R.drawable.bakchat_submenu_normal, RowActionEnum.MY_BANK_CARDS,this));
		GroupDescriptor groupDescriptor = new GroupDescriptor(descriptors);
		groupDescriptros.add(groupDescriptor);
		
		
		ArrayList<BaseRowDescriptor>  descriptors1 = new ArrayList<BaseRowDescriptor>();
		descriptors1.add(new NormalRowDescriptor(R.drawable.more_emoji_store,"Sticker Gallery",R.drawable.bakchat_submenu_normal, RowActionEnum.MY_STICKER_GALLERY,this));
		GroupDescriptor groupDescriptor1 = new GroupDescriptor(descriptors1);
		groupDescriptros.add(groupDescriptor1);
		
		
		
		ArrayList<BaseRowDescriptor>  descriptors2 = new ArrayList<BaseRowDescriptor>();
		descriptors2.add(new NormalRowDescriptor(R.drawable.more_setting,"Settings",R.drawable.bakchat_submenu_normal, RowActionEnum.SETTINGS,this));
		GroupDescriptor groupDescriptor2= new GroupDescriptor(descriptors2);
		groupDescriptros.add(groupDescriptor2);
		
		
		
		mWidgetContinerView.initData(groupDescriptros);
		mWidgetContinerView.notifyDataChanged();
	}

	@Override
	public void onRowClick(RowActionEnum action) {
		// TODO Auto-generated method stub
		
		Toast.makeText(this, "row click on:" + action.name(), 0).show();
	}

}
