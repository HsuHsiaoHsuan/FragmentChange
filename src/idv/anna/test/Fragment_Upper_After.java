package idv.anna.test;

import idv.anna.test.event.Event_Logout;
import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_Upper_After extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_upper_after, null);
		Button bt_logout = (Button) view.findViewById(R.id.bt_logout);
		bt_logout.setOnClickListener(
				new Button.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						// 測試: EventBus 傳送自定義事件"Event_Logout"
                        //      在 MainActivity 接收, 換回 Fragment_Upper_Before
						Event_Logout event = new Event_Logout("logout");
						EventBus.getDefault().post(event);
					}
				}
		);
		
		return view;
	}
}
