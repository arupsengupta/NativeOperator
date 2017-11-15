package com.herokuapp.arupepark;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class ScanResultDialog extends DialogFragment
{
	private String title;
	private String content;
	private TextView name;
	private TextView vehicle;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.userbooksuccess, null);
		name = (TextView) view.findViewById(R.id.username);
		vehicle = (TextView) view.findViewById(R.id.vehicle);
		
		Bundle bundle = this.getArguments();
		if(bundle != null){
			title = bundle.getString("title");
			content = bundle.getString("content");
			name.setText(title);
			vehicle.setText(content);
			builder.setView(view);
		}else{
			builder.setMessage("The code is not valid")
				.setTitle("Wrong QR");
		}
		
		builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id){
				
			}
		});
		return builder.create();
	}
}
