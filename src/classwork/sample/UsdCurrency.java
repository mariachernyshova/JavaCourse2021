package classwork.sample;

public class UsdCurrency implements ContractCurrency {
    @Override
    public String getCurrencyBrief() {
        return "USD";
    }

    @Override
    public String getCurrencyName() {
        return "Доллары";
    }
}
