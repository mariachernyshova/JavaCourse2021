package classwork.sample;

public class RubCurrency implements ContractCurrency{
    @Override
    public String getCurrencyBrief() {
        return "RUB";
    }

    @Override
    public String getCurrencyName() {
        return "Рубли";
    }
}
