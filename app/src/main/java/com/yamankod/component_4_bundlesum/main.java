package com.yamankod.component_4_bundlesum;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class main extends Activity {
	private Button button;
	private TextView textView;
	private EditText editText1, editText2;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		button = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.textView1);
		editText1 = (EditText) findViewById(R.id.editText1);
		editText2 = (EditText) findViewById(R.id.editText2);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				Double v1 = Double.parseDouble(editText1.getText().toString());
				Double v2 = Double.parseDouble(editText2.getText().toString());
				Intent intent = new Intent(getApplicationContext(),main2.class);
				Bundle mydata = new Bundle();
				mydata.putDouble("value1", v1);
				mydata.putDouble("value2", v2);
				intent.putExtras(mydata);
				startActivityForResult(intent, 101);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		try {
			if ((requestCode == 101) && (resultCode == Activity.RESULT_OK)) {
				Bundle myResult = data.getExtras();
				Double vresult = myResult.getDouble("vresult");
				textView.setText("Sum is " + vresult);
			}
		} catch (Exception e) {
			textView.setText("Problems - " + requestCode + " " + resultCode);
		}
	}
}