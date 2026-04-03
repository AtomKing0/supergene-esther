package com.applovin.impl;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class j0 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f5431h;

    public j0(String str, com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        super("CommunicatorRequestTask", jVar, str);
        this.f5430g = str;
        this.f5431h = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7677a.j0().a(new a(this.f5431h, this.f7677a, d()));
    }

    class a extends z5 {
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z10) {
            super(aVar, jVar, z10);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, JSONObject jSONObject, int i10) {
            this.f7677a.r().a(j0.this.f5430g, j0.this.f5431h.f(), i10, jSONObject, null, true);
        }

        @Override // com.applovin.impl.z5, com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, JSONObject jSONObject) {
            this.f7677a.r().a(j0.this.f5430g, j0.this.f5431h.f(), i10, jSONObject, str2, false);
        }
    }
}
