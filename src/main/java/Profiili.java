
public class Profiili {
	private String status;
	private int ika;

	public Profiili(String status, int ika) {
		this.status = status;
		this.ika = ika;
	}

	public double getAlennusProsentti() {
		return alennusOn();
	}

	public int getIka() {
		return this.ika;
	}

	public void setIka(int ika) {
		this.ika = ika;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return this.status;
	}

	private double alennusOn() {
		String alennusRyhma = this.status.toLowerCase();
		if (alennusRyhma.equals("opiskelija")) {
			return 25;
		}
		if (alennusRyhma.equals("elakelainen")) {
			return 40;
		}
		if (alennusRyhma.equals("tyoton")) {
			return 60;
		}
		if (this.ika > 60) {
			return 40;
		}
		if (this.ika < 7) {
			return 50;
		}
		return 0;

	}

	@Override
	public String toString() {

		return "\n\tStatus = " + this.status + "\n\tika = " + this.ika + "- vuotias" + "\n\tAlennusprosentti= "
				+ getAlennusProsentti() + " " + UnicodeMerkit.PROSENTTI_MERKKI;
	}
}
