package automation.utils;

public enum TestCases {
    T1("Testing the authentication"),
    T2("Testing the purchase of two items");

    private String testName;

    TestCases(String testName) {
        this.testName = testName;
    }

    public String getTestName() {
        return testName;
    }
}
