package com.itheima.universalimageloader.adapter;

import java.util.HashMap;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.itheima.universalimageloader.R;
import com.itheima.universalimageloader.bean.CheckBoxStatus;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MyGridViewAdapter extends BaseAdapter {

	private static DisplayImageOptions options;
	private static ImageLoader imageLoader;
	private Context context;
	private HashMap<Integer, CheckBoxStatus> datas;

	
	public MyGridViewAdapter(Context context, HashMap<Integer, CheckBoxStatus> datas){
		this.context = context;
		this.datas = datas;
		int size = datas.size();
		
		imageLoader = ImageLoader.getInstance();
		//已经在Application初始化，这里不需要再次初始化
//		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
		
		options = new DisplayImageOptions.Builder()
		.showImageOnLoading(R.drawable.ic_stub)
		.showImageForEmptyUri(R.drawable.ic_empty)
		.showImageOnFail(R.drawable.ic_error)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		/*.considerExifParams(true)*/
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();
		
		/*options = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.ic_stub)
		.showImageForEmptyUri(R.drawable.ic_empty)
		.showImageOnFail(R.drawable.ic_error)
		.cacheOnDisc(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.cacheInMemory(true).cacheOnDisc(true).build();*/
		
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
		View view = convertView;

		BaseViewHolder holder = BaseViewHolder.getViewHolder(context, convertView, parent, R.layout.gridview_item_layout, position);

		CheckBox chBox = (CheckBox) holder.findViewById(R.id.cBox);
		ImageView imaView = (ImageView) holder.findViewById(R.id.image);
		chBox.setChecked(datas.get(position).isChecked);
		imageLoader.displayImage(datas.get(position).url, imaView, options);
		
		return holder.getConvertView();

	}
	
}
