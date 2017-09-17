package com.herokuapp.arupepark;
import android.app.*;
import android.os.*;
import android.view.*;
import android.content.*;

public class NewBookingDialog extends DialogFragment
{

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.newentry, null))
			.setPositiveButton("Book", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int id){
					
				}
			})
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int id){
					
				}
			});
		return builder.create();
	}
}
