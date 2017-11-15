package com.herokuapp.arupepark;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class OTPMatchDialog extends DialogFragment
{

	private EditText otp;

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		View view = inflater.inflate(R.layout.otpdialog, null);
		otp = (EditText) view.findViewById(R.id.otp);
		builder.setCancelable(false);
		builder.setView(inflater.inflate(R.layout.otpdialog, null))
			.setPositiveButton("Match", null)
			.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int id){
					dialog.cancel();
				}
			});
		final AlertDialog dialog = builder.create();
		dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
		dialog.show();
		dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View v){
					otp.setError("Error ");
				}
			});
		return dialog;
	}
}
