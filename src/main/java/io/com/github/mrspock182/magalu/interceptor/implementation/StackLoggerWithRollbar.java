package io.com.github.mrspock182.magalu.interceptor.implementation;

import com.rollbar.notifier.Rollbar;
import io.com.github.mrspock182.magalu.interceptor.StackLogger;
import org.springframework.stereotype.Component;

@Component
public class StackLoggerWithRollbar implements StackLogger {
    private final Rollbar rollbar;

    public StackLoggerWithRollbar(Rollbar rollbar) {
        this.rollbar = rollbar;
    }

    @Override
    public void log(Exception exception) {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Error: %s", exception.getMessage())).append('\n');
        sb.append(String.format("Cause: %s", exception.getCause())).append('\n');

        for (StackTraceElement stack : exception.getStackTrace()) {
            sb.append(String.format("Class: %s", stack.getClassName())).append('\n');
            sb.append(String.format("Method: %s", stack.getMethodName())).append('\n');
            sb.append(String.format("File: %s", stack.getFileName())).append('\n');
            sb.append(String.format("Line Error: %d", stack.getLineNumber())).append('\n');
        }

        this.rollbar.critical(sb.toString());
    }
}
