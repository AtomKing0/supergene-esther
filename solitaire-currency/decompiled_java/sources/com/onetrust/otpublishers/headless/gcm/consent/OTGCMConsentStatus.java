package com.onetrust.otpublishers.headless.gcm.consent;

import androidx.annotation.Keep;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public enum OTGCMConsentStatus {
    GRANTED("granted"),
    DENIED("denied"),
    UNDEFINED("undefined"),
    UNASSIGNED("unassigned");


    @NotNull
    private final String status;

    OTGCMConsentStatus(String str) {
        this.status = str;
    }

    @NotNull
    public final String getStatus() {
        return this.status;
    }
}
