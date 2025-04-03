package com.example.traitement;

public record PayementRequest(Double montant, String devise, String benificiaire, String title) {
}
