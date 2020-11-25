package com.casasky.core.config;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import javax.annotation.PostConstruct;

import io.sentry.Sentry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;


class SentryInitializer {

    private static final Logger LOG = LogManager.getLogger();

    @PostConstruct
    private void init() {

        String dsn = System.getenv("log.sentry.dsn");

        if (Strings.isNotBlank(dsn)) {

            Sentry.init(options -> options.setDsn(dsn));

            LOG.info("sentry initialized");

        }
        else {

            LOG.info("no sentry dsn is configured - running without sentry");

        }

    }

}
