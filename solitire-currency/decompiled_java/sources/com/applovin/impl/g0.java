package com.applovin.impl;

import com.applovin.sdk.AppLovinSdkConfiguration;

/* JADX INFO: loaded from: classes2.dex */
public class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppLovinSdkConfiguration.ConsentFlowUserGeography f5224a;

    public g0(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        this.f5224a = consentFlowUserGeography;
    }

    protected boolean a(Object obj) {
        return obj instanceof g0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        if (!g0Var.a(this)) {
            return false;
        }
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA = a();
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA2 = g0Var.a();
        return consentFlowUserGeographyA != null ? consentFlowUserGeographyA.equals(consentFlowUserGeographyA2) : consentFlowUserGeographyA2 == null;
    }

    public int hashCode() {
        AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyA = a();
        return (consentFlowUserGeographyA == null ? 43 : consentFlowUserGeographyA.hashCode()) + 59;
    }

    public String toString() {
        return "CmpAdapterParameters(debugUserGeography=" + a() + ")";
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography a() {
        return this.f5224a;
    }
}
