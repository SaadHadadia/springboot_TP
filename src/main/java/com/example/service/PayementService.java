package com.example.service;

import com.example.traitement.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PayementService {

    private Map<String,PayementFacture> payementFactureMap;

    public PayementService(List<PayementFacture> payementFactures) {
        System.out.println(payementFactures);
        payementFactureMap = payementFactures.stream().collect(
                Collectors.toMap(
                        p -> p.getClass().getName(),
                        Function.identity()
                )
        );
    }

    // Mode de paiement
    public PayementResponse payementResponse(String mode, PayementRequest payementRequest) {
        try {
//            this.getPayementFacture(mode).Payement(
//                    payementRequest.montant(),
//                    payementRequest.devise(),
//                    payementRequest.benificiaire(),
//                    payementRequest.title()
//            );
            payementFactureMap.get(mode).Payement(
                    payementRequest.montant(),
                    payementRequest.devise(),
                    payementRequest.benificiaire(),
                    payementRequest.title()
                );
            return new PayementResponse(true);
        }catch (Exception e){
            return new PayementResponse(false);
        }
    }

    public PayementFacture getPayementFacture(String mode) throws Exception {
        PayementFacture payementFacture = null;
        switch (mode) {
            case "cheque":
                payementFacture = new PayementCheque();
                break;
            case "carte":
                payementFacture = new PayementCarte();
                break;
            default:
                throw new Exception("Payment mode error");
        }
        return payementFacture;

    }
}
