package com.herokuapp.arupepark;
import android.widget.*;
import android.content.*;
import android.view.*;
import android.view.View.*;
import android.app.DialogFragment;
import android.app.*;

public class ButtonAdapter extends BaseAdapter
{
	private Context mContext;
	private Integer[] iconIdArr = new Integer[]{R.drawable.ic_crop_free, R.drawable.ic_dialpad, R.drawable.ic_assignment};
	
	public ButtonAdapter(Context c){
		mContext=c;
	}

	@Override
	public int getCount()
	{
		// TODO: Implement this method
		return iconIdArr.length;
	}

	@Override
	public Object getItem(int p1)
	{
		// TODO: Implement this method
		return null;
	}

	@Override
	public long getItemId(int p1)
	{
		// TODO: Implement this method
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageButton button;
		if(convertView == null){
			button = new ImageButton(mContext);
			button.setLayoutParams(new GridView.LayoutParams(300, 300));
			button.setScaleType(ImageButton.ScaleType.CENTER_CROP);
			button.setPadding(50, 50, 50, 50);
		}else{
			button = (ImageButton) convertView;
		}
		button.setId(position);
		button.setImageResource(iconIdArr[position]);
		button.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				//Toast.makeText(mContext, "click : " + v.getId(), Toast.LENGTH_SHORT).show();
				switch(v.getId()){
					case 0: 
						if(mContext instanceof MainActivity){
							((MainActivity) mContext).onClick();
						}
						break;
					case 1:
						if(mContext instanceof MainActivity){
							((MainActivity) mContext).newForm();
						}
						break;
					case 2:
						if(mContext instanceof MainActivity){
							((MainActivity) mContext).matchOTP();
						}
						break;
				}
			}
		});
		return button;
	}

}
