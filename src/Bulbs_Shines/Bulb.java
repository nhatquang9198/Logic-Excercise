package bulbs_shines;

public class Bulb {
	private boolean isOn;

	public Bulb() {
		this.isOn = false;
	}

	public boolean isOn() {
		return isOn;
	}

	public void setOn(boolean isOn) {
		this.isOn = isOn;
	}

	@Override
	public String toString() {
		return "Bulb [isOn=" + isOn + "]";
	}
	
	

}
