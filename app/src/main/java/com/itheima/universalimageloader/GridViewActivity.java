package com.itheima.universalimageloader;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.GridView;

import com.itheima.universalimageloader.adapter.MyGridViewAdapter;
import com.itheima.universalimageloader.bean.CheckBoxStatus;
import com.itheima.universalimageloader.util.ImageUtil;

import java.util.HashMap;

public class GridViewActivity extends Activity implements OnItemClickListener{

	private GridView gridView;
	private MyGridViewAdapter adapter;
	private HashMap<Integer, CheckBoxStatus> mediaImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridview_activity_layout);
		
		init();
	}

	private void init() {
		gridView = (GridView) findViewById(R.id.gridview);
		mediaImage = ImageUtil.getMediaImage(this);
		adapter = new MyGridViewAdapter(this, mediaImage);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
		CheckBox cbBox = (CheckBox) view.findViewById(R.id.cBox);
		mediaImage.put(position, new CheckBoxStatus(mediaImage.get(position).url, !cbBox.isChecked()));
		cbBox.setChecked(!cbBox.isChecked());
	}
}
