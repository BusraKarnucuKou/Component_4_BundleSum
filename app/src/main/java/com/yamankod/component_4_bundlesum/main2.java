package com.yamankod.component_4_bundlesum;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class main2 extends Activity implements OnClickListener {
	EditText editText;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		editText = (EditText) findViewById(R.id.editText21);
		button = (Button) findViewById(R.id.button21);

        Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		Double v1 = bundle.getDouble("value1");
		Double v2 = bundle.getDouble("value2");
		Double Vresult = v1 + v2;
		editText.setText("Data received is \n" + "val1= " + v1 + "\nval2= "
				+ v2 + "\n\nresult= " + Vresult);
		bundle.putDouble("vresult", Vresult);
		intent.putExtras(bundle);
		setResult(Activity.RESULT_OK, intent);
		button.setOnClickListener(this);
	}
	public void onClick (View v) {
		finish();
	}

}
