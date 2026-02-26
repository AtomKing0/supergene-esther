package com.applovin.impl;

import androidx.annotation.Nullable;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface r3 {
    s3 getAdEventTracker();

    @Nullable
    String getOpenMeasurementContentUrl();

    String getOpenMeasurementCustomReferenceData();

    List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources();

    boolean isOpenMeasurementEnabled();
}
