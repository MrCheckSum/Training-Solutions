package algorithmsmax.sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {

    public Salesperson selectSalespersonWithFurthestAboveTarget(List<Salesperson> salespeople) {
        Salesperson salespersonWithFurthestAboveTarget = null;

        for (Salesperson salesperson : salespeople) {
            if (salespersonWithFurthestAboveTarget == null || salesperson.getDifferenceFromTarget() > 0 && salesperson.getDifferenceFromTarget() > salespersonWithFurthestAboveTarget.getDifferenceFromTarget()) {
                salespersonWithFurthestAboveTarget = salesperson;
            }
        }
        return salespersonWithFurthestAboveTarget;
    }
}
