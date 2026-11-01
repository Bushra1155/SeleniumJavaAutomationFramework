package reports;

import com.aventstack.extentreports.ExtentTest;

public class ReportUtils {

    private static String getCallingMethod() {
        for (StackTraceElement element :
                Thread.currentThread().getStackTrace()) {

            if (element.getClassName()
                    .startsWith("stepdefinations.")
                    && !element.getMethodName().equals(
                    "getCallingMethod")) {

                return element.getClassName() + "."
                        + element.getMethodName() + "()";
            }
        }

        return "Unknown method";
    }

    private static void log(
            String status, String message) {

        ExtentTest test = ExtentReportManager.getTest();

        if (test == null) {
            throw new IllegalStateException(
                    "Extent test is not initialized. "
                            + "Check that the Cucumber @Before hook runs.");
        }

        String details = "[Method: "
                + getCallingMethod() + "] " + message;

        switch (status) {
            case "PASS":
                test.pass(details);
                break;
            case "FAIL":
                test.fail(details);
                break;
            case "WARNING":
                test.warning(details);
                break;
            default:
                test.info(details);
        }

        System.out.println(status + " | " + details);
    }

    public static void info(String message) {
        log("INFO", message);
    }

    public static void pass(String message) {
        log("PASS", message);
    }

    public static void fail(String message) {
        log("FAIL", message);
    }

    public static void warning(String message) {
        log("WARNING", message);
    }

    public static void skip(String message) {
        log("skip", message);
    }
}