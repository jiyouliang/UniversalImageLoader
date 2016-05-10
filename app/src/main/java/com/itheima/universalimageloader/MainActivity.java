package com.itheima.universalimageloader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		initView();
	}

	private void initView() {
		findViewById(R.id.listView).setOnClickListener(this);
		findViewById(R.id.gridView).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.listView:
			startActivity(new Intent(this, ListViewActivity.class));
			break;
		case R.id.gridView:
			startActivity(new Intent(this, GridViewActivity.class));
			break;

		default:
			break;
		}
	}


}
