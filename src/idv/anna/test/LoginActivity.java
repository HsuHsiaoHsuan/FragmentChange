package idv.anna.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button bt_login = (Button) findViewById(R.id.bt_login);
		bt_login.setOnClickListener(
				new Button.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// 如果登入是成功，就送回RESULT_OK，並且結束這個Activity
						setResult(RESULT_OK);
						finish();
					}
				}
		);
	}
}
