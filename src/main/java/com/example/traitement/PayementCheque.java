package com.example.traitement;

public class PayementCheque implements PayementFacture{
    @Override
    public void Payement(Double montant, String devise, String benificiaire, String title) {
        System.out.println("Paiement de "+ montant + devise +" a ete effectue par cheque a Mr."+ benificiaire);
        System.out.println("Motif:"+ title);
    }
}
