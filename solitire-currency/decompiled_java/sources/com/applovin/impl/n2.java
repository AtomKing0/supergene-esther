package com.applovin.impl;

import android.os.Bundle;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.unity3d.ads.core.domain.InitializeAndroidBoldSDK;
import io.sentry.protocol.ViewHierarchyNode;

/* JADX INFO: loaded from: classes2.dex */
public class n2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StringBuilder f6379a = new StringBuilder();

    public n2 a(String str, Object obj) {
        return a(str, obj, "");
    }

    public n2 b(String str) {
        this.f6379a.append(str);
        return this;
    }

    public String toString() {
        return this.f6379a.toString();
    }

    public n2 a(String str, Object obj, String str2) {
        StringBuilder sb = this.f6379a;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    public n2 b(com.applovin.impl.sdk.ad.b bVar) {
        a("Target", bVar.a0()).a("close_style", bVar.n()).a("close_delay_graphic", Long.valueOf(bVar.p()), CmcdData.Factory.STREAMING_FORMAT_SS);
        if (bVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) bVar;
            a("HTML", aVar.f1().substring(0, Math.min(aVar.f1().length(), 64)));
        }
        if (bVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(bVar.h0()), CmcdData.Factory.STREAMING_FORMAT_SS).a("skip_style", bVar.Y()).a("Streaming", Boolean.valueOf(bVar.H0())).a("Video Location", bVar.N()).a("video_button_properties", bVar.f0());
        }
        return this;
    }

    public n2 a(String str) {
        StringBuilder sb = this.f6379a;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    public n2 a() {
        this.f6379a.append("\n========================================");
        return this;
    }

    public n2 a(com.applovin.impl.sdk.ad.b bVar) {
        boolean z10 = bVar instanceof a7;
        a("Format", bVar.getAdZone().d() != null ? bVar.getAdZone().d().getLabel() : null).a("Ad ID", Long.valueOf(bVar.getAdIdNumber())).a("Zone ID", bVar.getAdZone().e()).a("Ad Class", z10 ? "VastAd" : "AdServerAd");
        String dspName = bVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            a("DSP Name", dspName);
        }
        if (z10) {
            a("VAST DSP", ((a7) bVar).m1());
        }
        return this;
    }

    public n2 a(q2 q2Var) {
        return a(InitializeAndroidBoldSDK.MSG_NETWORK, q2Var.c()).a("Adapter Version", q2Var.z()).a("Format", q2Var.getFormat().getLabel()).a("Ad Unit ID", q2Var.getAdUnitId()).a("Placement", q2Var.getPlacement()).a("Network Placement", q2Var.O()).a("Serve ID", q2Var.N()).a("Creative ID", StringUtils.isValidString(q2Var.getCreativeId()) ? q2Var.getCreativeId() : "None").a("Ad Domain", StringUtils.isValidString(q2Var.v()) ? q2Var.v() : "None").a("DSP Name", StringUtils.isValidString(q2Var.getDspName()) ? q2Var.getDspName() : "None").a("DSP ID", StringUtils.isValidString(q2Var.getDspId()) ? q2Var.getDspId() : "None").a("Server Parameters", q2Var.l());
    }

    public n2 a(AppLovinAdView appLovinAdView) {
        return a("Size", appLovinAdView.getSize().getWidth() + ViewHierarchyNode.JsonKeys.X + appLovinAdView.getSize().getHeight()).a("Alpha", Float.valueOf(appLovinAdView.getAlpha())).a("Visibility", q7.a(appLovinAdView.getVisibility()));
    }

    public n2 a(com.applovin.impl.sdk.j jVar) {
        return a("Muted", Boolean.valueOf(jVar.g0().isMuted()));
    }

    public n2 a(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String str : bundle.keySet()) {
            a(str, bundle.get(str));
        }
        return this;
    }
}
