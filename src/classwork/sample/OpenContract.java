package classwork.sample;

import java.time.LocalDate;

public class OpenContract<T extends ContractCurrency> implements Contract {
    private T currency;

    @Override
    public LocalDate getContractEndDate() {
        return null;
    }
}
