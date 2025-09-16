package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("Application starting");

        logger.debug("Debug message: args length = {}", args.length);

        if (args.length == 0) {
            logger.warn("No arguments supplied, using defaults");
        }

        Thread th = new Thread(() -> {
            try {
                logger.info("Background thread started");
                Thread.sleep(500);
                logger.info("Background thread completed work");
            } catch (InterruptedException e) {
                logger.error("Background thread interrupted", e);
            }
        });
        th.start();
        Thread.sleep(100);
        logger.info("Main thread waiting for background thread to finish");
        th.join();

        for (int i = 1; i <= 3; i++) {
            logger.info("Processing step {}", i);
            Thread.sleep(200);
        }

        try {
            simulateError();
        } catch (Exception e) {
            logger.error("Unhandled error in main", e);
        }

        logger.info("Application exiting");
    }

    private static void simulateError() {
        throw new IllegalStateException("simulated failure for demo");
    }
}
