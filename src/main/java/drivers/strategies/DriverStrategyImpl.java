package drivers.strategies;

public class DriverStrategyImpl {

    public static DriverStrategy choose(String strategy) {
        switch (strategy) {
            case "Chrome":
                return new Chrome();
            case "PhantomJs":
                return new PhantomJs();
            case "Firefox":
                return new Firefox();
            default:
                return null;
        }
    }
}
