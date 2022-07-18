package automation.drivers.strategies;

import automation.utils.Constants;

public class DriverStrategyImpl {

    public static DriverStrategy choose(String strategy) {
        switch (strategy) {
            case Constants.CHROME:
                return new Chrome();
            case Constants.PHANTOMJS:
                return new PhantomJs();
            case Constants.FIREFOX:
                return new Firefox();
            default:
                return null;
        }
    }
}
