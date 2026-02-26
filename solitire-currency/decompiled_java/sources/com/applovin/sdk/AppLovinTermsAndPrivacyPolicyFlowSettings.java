package com.applovin.sdk;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.applovin.sdk.AppLovinSdkConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinTermsAndPrivacyPolicyFlowSettings {
    AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography();

    @Nullable
    Uri getPrivacyPolicyUri();

    @Nullable
    Uri getTermsOfServiceUri();

    boolean isEnabled();

    void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography);

    void setEnabled(boolean z10);

    void setPrivacyPolicyUri(Uri uri);

    void setShowTermsAndPrivacyPolicyAlertInGdpr(boolean z10);

    void setTermsOfServiceUri(Uri uri);

    boolean shouldShowTermsAndPrivacyPolicyAlertInGdpr();
}
