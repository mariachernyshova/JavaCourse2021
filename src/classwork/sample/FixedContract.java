package classwork.sample;

import java.time.LocalDate;

public class FixedContract<T extends ContractCurrency> implements Contract{
    private LocalDate contractEndDate;
    private T currency;

    @Override
    public LocalDate getContractEndDate() {
        return contractEndDate;
    }
}
