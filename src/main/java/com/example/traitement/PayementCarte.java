package com.example.traitement;

public class PayementCarte implements PayementFacture{
    @Override
    public void Payement(Double montant, String devise, String benificiaire, String title) {
        System.out.println("Paiement de "+ montant + devise +" a ete effectue par carte a Mr."+ benificiaire);
        System.out.println("Motif:"+ title);
    }
}
