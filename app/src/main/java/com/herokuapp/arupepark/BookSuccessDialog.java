package com.herokuapp.arupepark;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class BookSuccessDialog extends DialogFragment
{

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setCancelable(false);
		builder.setView(inflater.inflate(R.layout.booksuccess, null))
			.setPositiveButton("Ok", null);
		return builder.create();
	}
}
