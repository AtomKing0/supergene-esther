package com.onetrust.otpublishers.headless.Public;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class OTVendorListMode {
    public static final String GENERAL = "general";
    public static final String GOOGLE = "google";
    public static final String IAB = "iab";

    @Retention(RetentionPolicy.SOURCE)
    public @interface VendorListMode {
    }
}
