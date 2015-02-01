package idv.anna.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment_Upper_Before extends Fragment {

	private static final int HELLO = 999;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_upper_before, null);
		Button bt_login = (Button) view.findViewById(R.id.bt_login);
		bt_login.setOnClickListener(
				new Button.OnClickListener() {
					@Override
					public void onClick(View arg0) {
						Intent intent = new Intent(getActivity(), LoginActivity.class);
						// 這裡有些技巧，看是要用 MainActivity 處理登入成功的回傳事件，還是用這個小 Fragment 去處理
						// 1. 用 Fragment 寄居的 MainActivity 去處理登入成功的回傳事件
						//    這樣，我們就必須把處理回傳結果的函式 onActivityResult 放回 MainActivity
						//    getActivity() --> 取得這個 Fragment 寄居的 Activity
						getActivity().startActivityForResult(intent, HELLO);
						// 2. 單純就這個 Fragment 來處理
						// startActivityForResult(intent, HELLO);
					}
				}
		);
		
		
		return view;
	}
	
	
}
