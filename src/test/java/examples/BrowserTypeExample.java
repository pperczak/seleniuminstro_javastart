package examples;

public enum BrowserTypeExample {
    FF("firefox"),
    CHROME("chrome"),
    IE("internetexplorer");

    private final String browser;

    BrowserTypeExample(String browser) {
        this.browser = browser;
    }
}
