package com.applovin.impl;

import com.applovin.mediation.MaxError;

/* JADX INFO: loaded from: classes2.dex */
public class q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r4 f6682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f6683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MaxError f6686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f6687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f6688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f6689h;

    public interface a {
        void a(q4 q4Var);
    }

    private q4(r4 r4Var, com.applovin.impl.mediation.g gVar, String str, MaxError maxError, long j10, long j11) {
        this(r4Var, str, maxError, j10, j11, gVar != null ? gVar.i() : null, gVar != null ? gVar.b() : null, false);
    }

    public static q4 a(r4 r4Var, com.applovin.impl.mediation.g gVar, String str, long j10, long j11) {
        if (r4Var == null) {
            throw new IllegalArgumentException("No spec specified");
        }
        if (gVar != null) {
            return new q4(r4Var, gVar, str, null, j10, j11);
        }
        throw new IllegalArgumentException("No adapterWrapper specified");
    }

    public long b() {
        return this.f6688g;
    }

    public MaxError c() {
        return this.f6686e;
    }

    public String d() {
        return this.f6683b;
    }

    public String e() {
        return this.f6685d;
    }

    public r4 f() {
        return this.f6682a;
    }

    public boolean g() {
        return this.f6689h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SignalCollectionResult{mSignalProviderSpec=");
        sb.append(this.f6682a);
        sb.append(", mSdkVersion='");
        sb.append(this.f6683b);
        sb.append('\'');
        sb.append(", mAdapterVersion='");
        sb.append(this.f6684c);
        sb.append('\'');
        sb.append(", mSignalDataLength='");
        String str = this.f6685d;
        sb.append(str != null ? str.length() : 0);
        sb.append('\'');
        sb.append(", mErrorMessage=");
        MaxError maxError = this.f6686e;
        sb.append(maxError != null ? maxError.getMessage() : "");
        sb.append('}');
        return sb.toString();
    }

    private q4(r4 r4Var, String str, MaxError maxError, long j10, long j11, String str2, String str3, boolean z10) {
        this.f6682a = r4Var;
        this.f6685d = str;
        this.f6686e = maxError;
        this.f6687f = j10;
        this.f6688g = j11;
        this.f6683b = str2;
        this.f6684c = str3;
        this.f6689h = z10;
    }

    public static q4 a(r4 r4Var, MaxError maxError) {
        return a(r4Var, (com.applovin.impl.mediation.g) null, maxError, -1L, -1L);
    }

    public static q4 a(r4 r4Var, com.applovin.impl.mediation.g gVar, MaxError maxError, long j10, long j11) {
        if (r4Var != null) {
            return new q4(r4Var, gVar, null, maxError, j10, j11);
        }
        throw new IllegalArgumentException("No spec specified");
    }

    public static q4 a(q4 q4Var) {
        return new q4(q4Var.f(), q4Var.e(), q4Var.c(), q4Var.f6687f, q4Var.f6688g, q4Var.d(), q4Var.a(), true);
    }

    public String a() {
        return this.f6684c;
    }
}
