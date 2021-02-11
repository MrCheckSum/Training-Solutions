package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private Contract template;

    public ContractCreator(String name, List<Integer> monthlyPrices) {
        template = new Contract(name, monthlyPrices);

    }

    public Contract create(String name) {
        return new Contract(name, new ArrayList<>(template.getMonthlyPrices()));
    }

    public static void main(String[] args) {
        ContractCreator contractCreator = new ContractCreator("client1", new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12)));

        Contract contract1 = contractCreator.create("Jack");
        Contract contract2 = contractCreator.create("James");
        Contract contract3 = contractCreator.create("John");

        System.out.println(contract1);
        System.out.println(contract2);
        System.out.println(contract3);

        contract1.getMonthlyPrices().set(11,20);
        contract2.getMonthlyPrices().set(11,30);

        System.out.println(contract1);
        System.out.println(contract2);
        System.out.println(contract3);



    }
}
