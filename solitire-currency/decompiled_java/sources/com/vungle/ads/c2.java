package com.vungle.ads;

import com.ironsource.zk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VunglePrivacySettings.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c2 {

    @NotNull
    public static final c2 INSTANCE = new c2();

    private c2() {
    }

    @NotNull
    public static final String getCCPAStatus() {
        return q7.c.INSTANCE.getCcpaStatus();
    }

    @NotNull
    public static final String getCOPPAStatus() {
        return q7.c.INSTANCE.getCoppaStatus().name();
    }

    @NotNull
    public static final String getGDPRMessageVersion() {
        return q7.c.INSTANCE.getConsentMessageVersion();
    }

    @NotNull
    public static final String getGDPRSource() {
        return q7.c.INSTANCE.getConsentSource();
    }

    @NotNull
    public static final String getGDPRStatus() {
        return q7.c.INSTANCE.getConsentStatus();
    }

    public static final long getGDPRTimestamp() {
        return q7.c.INSTANCE.getConsentTimestamp();
    }

    public static final void setCCPAStatus(boolean z10) {
        q7.c.INSTANCE.updateCcpaConsent(z10 ? q7.b.OPT_IN : q7.b.OPT_OUT);
    }

    public static final void setCOPPAStatus(boolean z10) {
        q7.c.INSTANCE.updateCoppaConsent(z10);
    }

    public static final void setGDPRStatus(boolean z10, @Nullable String str) {
        q7.c.INSTANCE.updateGdprConsent(z10 ? q7.b.OPT_IN.getValue() : q7.b.OPT_OUT.getValue(), zk.f16432b, str);
    }
}
