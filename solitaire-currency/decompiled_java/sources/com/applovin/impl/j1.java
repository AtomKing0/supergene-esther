package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5433a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f5434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f5435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f5436d;

    public j1(Object obj, long j10) {
        this.f5434b = obj;
        this.f5433a = j10;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) obj;
            this.f5435c = bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null;
            this.f5436d = "AppLovin";
        } else if (obj instanceof q2) {
            q2 q2Var = (q2) obj;
            this.f5435c = q2Var.getFormat().getLabel();
            this.f5436d = q2Var.getNetworkName();
        }
    }

    public Object a() {
        return this.f5434b;
    }

    public long b() {
        return this.f5433a;
    }

    public String c() {
        String str = this.f5435c;
        return str != null ? str : "Unknown";
    }

    public String d() {
        String str = this.f5436d;
        return str != null ? str : "Unknown";
    }
}
