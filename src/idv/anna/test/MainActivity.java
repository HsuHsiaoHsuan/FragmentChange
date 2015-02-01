package idv.anna.test;

import idv.anna.test.event.Event_Logout;
import de.greenrobot.event.EventBus;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class MainActivity extends FragmentActivity {

	private static final int HELLO = 999;
	FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		fm = getSupportFragmentManager();
		if (savedInstanceState == null) {
			// 上面的
			fm.beginTransaction()
					.add(R.id.frame_upper, new Fragment_Upper_Before()).commit();
			// 下面的
			fm.beginTransaction()
					.add(R.id.frame_lower, new Fragment_Lower()).commit();
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		switch (requestCode) {
			case HELLO:
				fm.beginTransaction()
						.replace(R.id.frame_upper, new Fragment_Upper_After()).commit();
				break;
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		// 測試： EventBus 範例，註冊此 Activity 為監聽者
		EventBus.getDefault().register(this);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		// 測試： EventBus 範例, 取消註冊，不在收到事件通知
		EventBus.getDefault().unregister(this);
	}
	
	// 宣告這個方法, 去過濾&處理 Event_Logout 事件
	public void onEventMainThread(Event_Logout event) {
		String data = event.getData();
		if (data.equals("logout")) {
			fm.beginTransaction()
			  .replace(R.id.frame_upper, new Fragment_Upper_Before()).commit();
		}
	}
}
