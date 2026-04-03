package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.q2;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.MaxNetworkResponseInfo;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MaxAdWaterfallInfoImpl implements MaxAdWaterfallInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final q2 f5914a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5915b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f5916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f5917d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f5918e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f5919f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5920g;

    public MaxAdWaterfallInfoImpl(q2 q2Var, long j10, List<MaxNetworkResponseInfo> list, String str) {
        this(q2Var, q2Var.Q(), q2Var.R(), j10, list, q2Var.P(), str);
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public long getLatencyMillis() {
        return this.f5918e;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public MaxAd getLoadedAd() {
        return this.f5914a;
    }

    public String getMCode() {
        return this.f5920g;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getName() {
        return this.f5915b;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public List<MaxNetworkResponseInfo> getNetworkResponses() {
        return this.f5917d;
    }

    public List<String> getPostbackUrls() {
        return this.f5919f;
    }

    @Override // com.applovin.mediation.MaxAdWaterfallInfo
    public String getTestName() {
        return this.f5916c;
    }

    @NonNull
    public String toString() {
        return "MaxAdWaterfallInfo{name=" + this.f5915b + ", testName=" + this.f5916c + ", networkResponses=" + this.f5917d + ", latencyMillis=" + this.f5918e + '}';
    }

    public MaxAdWaterfallInfoImpl(@Nullable q2 q2Var, String str, String str2, long j10, List<MaxNetworkResponseInfo> list, List<String> list2, String str3) {
        this.f5914a = q2Var;
        this.f5915b = str;
        this.f5916c = str2;
        this.f5917d = list;
        this.f5918e = j10;
        this.f5919f = list2;
        this.f5920g = str3;
    }
}
