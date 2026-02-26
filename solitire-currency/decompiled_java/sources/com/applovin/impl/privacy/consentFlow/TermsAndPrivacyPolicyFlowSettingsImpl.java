package com.applovin.impl.privacy.consentFlow;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings;

/* JADX INFO: loaded from: classes2.dex */
public class TermsAndPrivacyPolicyFlowSettingsImpl implements AppLovinTermsAndPrivacyPolicyFlowSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6622a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6623b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AppLovinSdkConfiguration.ConsentFlowUserGeography f6624c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Uri f6625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Uri f6626e;

    public TermsAndPrivacyPolicyFlowSettingsImpl(boolean z10, boolean z11, AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, Uri uri, Uri uri2) {
        this.f6622a = z10;
        this.f6623b = z11;
        this.f6624c = consentFlowUserGeography;
        this.f6625d = uri;
        this.f6626e = uri2;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return this.f6624c;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    @Nullable
    public Uri getPrivacyPolicyUri() {
        return this.f6625d;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    @Nullable
    public Uri getTermsOfServiceUri() {
        return this.f6626e;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public boolean isEnabled() {
        return this.f6622a;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        n.g("ConsentFlowSettingsImpl", "Setting user debug geography: " + consentFlowUserGeography);
        this.f6624c = consentFlowUserGeography;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setEnabled(boolean z10) {
        n.g("ConsentFlowSettingsImpl", "Setting Terms and Privacy Policy Flow enabled: " + z10);
        this.f6622a = z10;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setPrivacyPolicyUri(Uri uri) {
        n.g("ConsentFlowSettingsImpl", "Setting privacy policy: " + uri);
        this.f6625d = uri;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setShowTermsAndPrivacyPolicyAlertInGdpr(boolean z10) {
        n.g("ConsentFlowSettingsImpl", "Setting show Terms and Privacy Policy alert in GDPR: " + z10);
        this.f6623b = z10;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public void setTermsOfServiceUri(Uri uri) {
        n.g("ConsentFlowSettingsImpl", "Setting terms of service: " + uri);
        this.f6626e = uri;
    }

    @Override // com.applovin.sdk.AppLovinTermsAndPrivacyPolicyFlowSettings
    public boolean shouldShowTermsAndPrivacyPolicyAlertInGdpr() {
        return this.f6623b;
    }

    @NonNull
    public String toString() {
        return "ConsentFlowSettings{isEnabled=" + this.f6622a + ", privacyPolicyUri=" + this.f6625d + ", termsOfServiceUri=" + this.f6626e + '}';
    }
}
