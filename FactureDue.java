final class FactureDue extends Facture {
	private Integer nombreRelance = 0;

	public void incrementerNombreRelance() {
		nombreRelance++;
	}

	public boolean aDejaÉtéRelancée() {
		return nombreRelance >= 1;
	}
}
