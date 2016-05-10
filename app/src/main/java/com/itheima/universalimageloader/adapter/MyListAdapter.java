package com.itheima.universalimageloader.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.itheima.universalimageloader.R;
import com.itheima.universalimageloader.bean.CheckBoxStatus;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.HashMap;

public class MyListAdapter extends BaseAdapter {

	private Context context;
	private HashMap<Integer, CheckBoxStatus> datas;
	private ImageLoader imageLoader;
	private DisplayImageOptions options;

	public MyListAdapter(Context context, HashMap<Integer, CheckBoxStatus> datas){
		this.context = context;
		this.datas = datas;
		
		imageLoader = ImageLoader.getInstance();
		//已经在Application初始化，这里不需要再次初始化
//		imageLoader.init(ImageLoaderConfiguration.createDefault(context));

		options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.ic_stub)
		.showImageForEmptyUri(R.drawable.ic_empty)
		.showImageOnFail(R.drawable.ic_error)
		.cacheInMemory(true)//是否存储到内存
		.cacheOnDisk(true)//是否存储到本地
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
	}
	
	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BaseViewHolder holder = BaseViewHolder.getViewHolder(context, convertView, parent, R.layout.listview_item, position);
		ImageView image = holder.findViewById(R.id.image);
		CheckBox chBox = holder.findViewById(R.id.checkBox);
		chBox.setChecked(datas.get(position).isChecked);
		imageLoader.displayImage(datas.get(position).url, image, options);
		return holder.getConvertView();
	}
	
}
