package com.herokuapp.arupepark;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import com.android.volley.*;
import com.android.volley.toolbox.*;
import com.google.zxing.integration.android.*;
import org.json.*;

public class ScanActivity extends Activity
{
	private IntentIntegrator qrScan;
	
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		qrScan = new IntentIntegrator(this);
		qrScan.setOrientationLocked(false);
		qrScan.initiateScan();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		if(result != null){
			if(result.getContents() == null){
				Toast.makeText(this, "Result not found", Toast.LENGTH_LONG).show();
			}else{
				//textView.setText(result.getContents());
				RequestQueue queue = Volley.newRequestQueue(this);
				String url = "https://arupepark.herokuapp.com/users/" + result.getContents();
				JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>(){
						@Override
						public void onResponse(JSONObject response){
							try{
								/*name.setText(response.getString("name"));
								 vehicle_no.setText(response.getString("vehicle_no"));
								 phone.setText(response.getString("phone"));*/
								showUser(response.getString("name"), response.getString("vehicle_no"));
							}/*catch(JSONException ex){
							 name.setText(ex.getMessage());
							 }*/
							catch(Exception ex){
								//name.setText(ex.getMessage());
							}
						}
					}, new Response.ErrorListener(){
						@Override
						public void onErrorResponse(VolleyError error){

						}
					});
				queue.add(request);
			}
		}else{
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
	
	public void showUser(String name, String vehicle){
		DialogFragment dialog = new ScanResultDialog();
		Bundle bundle = new Bundle();
		bundle.putString("title",name);
		bundle.putString("content", vehicle);
		dialog.setArguments(bundle);
		dialog.show(getFragmentManager(), "scanResultFragment");
	}
}
