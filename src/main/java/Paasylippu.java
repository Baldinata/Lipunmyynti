import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Paasylippu {

	private String nimi;
	private double hinta;
	private String lippuOstettupvm;
	private String lippuEraantyypvm;
	
	public Paasylippu() {
		
	}

	public Paasylippu(String nimi, double hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
		LocalDateTime pvmnow = LocalDateTime.now();
		lippuOstettupvm = pvmnow.format(DateTimeFormatter.ofPattern("dd-MM-yyyy 'Kello: ' HH:mm:ss"));
		LocalDateTime pvmEnd = pvmnow.plusDays(1);
		lippuEraantyypvm = pvmEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy 'Kello: ' HH:mm:ss"));
	}

	public double getHinta() {
		return this.hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

	public String getLippuOstettupvm() {
		return this.lippuOstettupvm;
	}

	public void setLippuEraantyypvm(String lippuEraantyypvm) {
		this.lippuEraantyypvm = lippuEraantyypvm;
	}
	public String getLippuEraantyypvm() {
		return this.lippuEraantyypvm;
	}

	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "\n\tLippu: " + this.nimi + "\n\tAlkuperainen hinta = " + this.hinta + " " + UnicodeMerkit.EURO_MERKKI
				+ "\n\tLippu ostettu pvm = " + this.lippuOstettupvm + "\n\tLippu eraantyy pvm = "
				+ this.lippuEraantyypvm;
	}
}
