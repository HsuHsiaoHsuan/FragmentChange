package idv.anna.test.event;

public class Event_Logout {
	private String data;
	
	// 建構子，事先傳入資料做初始化
	public Event_Logout(String input) {
		data = input;
	}
	
	// 取出資料
	public String getData() {
		return data;
	}
	
	// 傳入資料
	public void setData(String input) {
		data = input;
	}
}
