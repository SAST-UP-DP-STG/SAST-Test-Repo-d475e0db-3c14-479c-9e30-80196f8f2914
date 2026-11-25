package org.t246osslab.easybuggy.core.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class to provide application properties. Trimmed from easybuggy to the
 * SMTP credential fields relevant to the CWE-244 (sensitive data in memory) finding.
 */
public final class ApplicationUtils {

    private static final Logger log = LoggerFactory.getLogger(ApplicationUtils.class);

    // default SMTP user: null
    private static String smtpUser = null;

    // default SMTP password: null
    private static String smtpPass = null;

    // default administrator's mail address: null
    private static String adminAddress = null;

    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("application");
            smtpUser = getProperty(bundle, "mail.user", smtpUser);
            smtpPass = getProperty(bundle, "mail.password", smtpPass);
            adminAddress = getProperty(bundle, "mail.admin.address", adminAddress);
        } catch (MissingResourceException e) {
            log.error("MissingResourceException occurs: ", e);
        }
    }

    private ApplicationUtils() {
        throw new IllegalAccessError("Utility class");
    }

    private static String getProperty(ResourceBundle bundle, String key, String defaultValue) {
        String value = bundle.getString(key);
        return (value != null && !value.isEmpty()) ? value : defaultValue;
    }

    public static String getSmtpPass() {
        return smtpPass;
    }
}
