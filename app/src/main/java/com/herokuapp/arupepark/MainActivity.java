package com.herokuapp.arupepark;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import com.google.zxing.integration.android.IntentIntegrator;
import android.content.Intent;
import com.google.zxing.integration.android.IntentResult;
import android.widget.Toast;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import org.json.JSONObject;
import android.app.DialogFragment;

public class MainActivity extends Activity implements View.OnClickListener
{
	private Button scanButton;
	private TextView name, vehicle_no, phone;
	private IntentIntegrator qrScan;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		scanButton = (Button) findViewById(R.id.mainButton);
		name = (TextView) findViewById(R.id.name);
		phone = (TextView) findViewById(R.id.phone);
		vehicle_no = (TextView) findViewById(R.id.vehicle_no);
		
		qrScan = new IntentIntegrator(this);
		qrScan.setOrientationLocked(false);
		scanButton.setOnClickListener(this);
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
							name.setText(ex.getMessage());
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
	
	@Override
	public void onClick(View view){
		qrScan.initiateScan();
	}
	
	public void newForm(View v){
		DialogFragment dialog = new NewBookingDialog();
		dialog.show(getFragmentManager(), "newBopkDialog");
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
