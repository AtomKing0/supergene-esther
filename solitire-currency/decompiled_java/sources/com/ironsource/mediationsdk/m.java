package com.ironsource.mediationsdk;

import com.ironsource.f5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashSet;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private HashSet<ImpressionDataListener> f13674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.ironsource.r f13675b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected IronSourceSegment f13676c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected AdInfo f13677d;

    public m(HashSet<ImpressionDataListener> hashSet, IronSourceSegment ironSourceSegment) {
        new HashSet();
        this.f13674a = hashSet;
        this.f13675b = new com.ironsource.r();
        this.f13676c = ironSourceSegment;
    }

    protected void a(f5 f5Var, String str) {
        HashSet<ImpressionDataListener> hashSet;
        if (f5Var == null) {
            IronLog.INTERNAL.verbose("no auctionResponseItem or listener");
            return;
        }
        ImpressionData impressionDataA = f5Var.a(str);
        if (impressionDataA != null) {
            synchronized (this) {
                hashSet = (HashSet) this.f13674a.clone();
            }
            for (ImpressionDataListener impressionDataListener : hashSet) {
                IronLog.CALLBACK.info("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + impressionDataA);
                impressionDataListener.onImpressionSuccess(impressionDataA);
            }
        }
    }

    public void b(@NotNull ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f13674a.add(impressionDataListener);
        }
    }

    public void c() {
        synchronized (this) {
            this.f13674a.clear();
        }
    }

    protected String e() {
        return "fallback_" + System.currentTimeMillis();
    }

    public void f() {
        this.f13677d = null;
    }

    protected void a(IronSource.AD_UNIT ad_unit) {
        this.f13675b.a(ad_unit, false);
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.f13676c = ironSourceSegment;
    }

    public void a(ImpressionData impressionData) {
        if (impressionData != null) {
            this.f13677d = new AdInfo(impressionData);
        }
    }

    public void a(@NotNull ImpressionDataListener impressionDataListener) {
        synchronized (this) {
            this.f13674a.remove(impressionDataListener);
        }
    }

    protected void a(JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.f13675b.a(ad_unit, jSONObject != null ? jSONObject.optBoolean(d.f13324e, false) : false);
    }
}
