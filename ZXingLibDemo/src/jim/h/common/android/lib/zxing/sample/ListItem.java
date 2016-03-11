package jim.h.common.android.lib.zxing.sample;

public class ListItem {

	private String mt;
	private String st;

	public String getmt() {
		return mt;
	}

	public void setmt(String mt) {
		this.mt = mt;
	}

	public String getst() {
		return st;
	}

	public void setst(String st) {
		this.st = st;
	}

	@Override
	public String toString() {
		return st+":"+mt;
	}
}
