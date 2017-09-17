package com.herokuapp.arupepark;
import android.app.DialogFragment;
import android.app.Dialog;
import android.os.Bundle;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class ScanResultDialog extends DialogFragment
{
	private String title;
	private String content;
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		Bundle bundle = this.getArguments();
		if(bundle != null){
			title = bundle.getString("title");
			content = bundle.getString("content");
		}
		builder.setMessage(content)
			.setTitle(title);
		builder.setPositiveButton("Ok",new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog, int id){
				
			}
		});
		return builder.create();
	}
}
