record FactureService(LettrageService lettrageService, RecouvrementService recouvrementService) implements TraitementFacture {

	public void traiterFacture(Facture facture) {
		switch (facture) {
			case FacturePayée facturePayée -> lettrageService.lettrer(facturePayée);
			case FactureDue factureDue && factureDue.aDejaÉtéRelancée() -> recouvrementService.demarrerRecouvrement(factureDue);
			case FactureDue factureDue -> recouvrementService.relancer(factureDue);
		}
	}
}