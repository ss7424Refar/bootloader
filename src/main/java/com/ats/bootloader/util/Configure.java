package com.ats.bootloader.util;

import org.springframework.stereotype.Component;

public class Configure {
    public static String IP = "http://localhost/";

    public static final String UPDATE_URL = IP + "ats/services/UpdateTask/updater";

    public static final String SENDMAIL_BASELINE_URL = IP + "ats/services/SendMail/sendBaseLine";

    public static final String SENDMAIL_URL = IP + "ats/services/sendMail/sendStepsResult";

}
