package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.JavascriptInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2163Zg {
    public static String[] A07 = {"MaUhfef1XHChQSOAsPU", "01oMUC4JT554rhL", "9TYVZPZrh7WqyaB", "ShOi1FYvFM9bF84GqYiu0GZZ4HOF35Af", CmcdData.Factory.STREAMING_FORMAT_SS, "YvdeaQsxQHJ3CZVDgFIjqRdATcpqYXuO", "b384kAccrLIUxrnk6NdGu", "f4PnsWwvvRSNWXAtteJ0H"};
    public final String A00 = C2163Zg.class.getSimpleName();
    public final WeakReference<AtomicBoolean> A01;
    public final WeakReference<AtomicBoolean> A02;
    public final WeakReference<LH> A03;
    public final WeakReference<InterfaceC2164Zh> A04;
    public final WeakReference<C2460eX> A05;
    public final WeakReference<C1783Ki> A06;

    public C2163Zg(C1783Ki c1783Ki, InterfaceC2164Zh interfaceC2164Zh, C2460eX c2460eX, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, C2387dL c2387dL) {
        this.A06 = new WeakReference<>(c1783Ki);
        this.A04 = new WeakReference<>(interfaceC2164Zh);
        this.A05 = new WeakReference<>(c2460eX);
        this.A01 = new WeakReference<>(atomicBoolean);
        this.A02 = new WeakReference<>(atomicBoolean2);
        this.A03 = new WeakReference<>(c2387dL.A0F());
    }

    private LH A00() {
        LH funnel = this.A03.get();
        if (funnel == null) {
            return new C2723j3();
        }
        return funnel;
    }

    @JavascriptInterface
    public void alert(String str) {
        Log.e(this.A00, str);
    }

    @JavascriptInterface
    public String getAnalogInfo() {
        return AbstractC2096Wr.A01(T5.A02());
    }

    @JavascriptInterface
    public void logFunnel(int i10, String str) {
        A00().AK6(i10, str);
    }

    @JavascriptInterface
    public void onMainAssetLoaded() {
        A00().AK7();
        if (this.A06.get() != null && this.A01.get() != null && this.A02.get() != null && this.A02.get().get()) {
            this.A01.get().set(true);
            A00().AK8();
            if (this.A06.get().isShown()) {
                A00().AK9();
                new Handler(Looper.getMainLooper()).post(new C1789Ko(this.A05));
            }
            InterfaceC2164Zh interfaceC2164Zh = this.A04.get();
            if (interfaceC2164Zh != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC2162Zf(this, interfaceC2164Zh));
            }
        }
    }

    @JavascriptInterface
    public void onPageInitialized() {
        C1783Ki webView = this.A06.get();
        if (webView == null || webView.A0J()) {
            A00().AKA(true);
            return;
        }
        InterfaceC2164Zh interfaceC2164Zh = this.A04.get();
        if (interfaceC2164Zh == null) {
            A00().AKA(true);
            return;
        }
        LH lhA00 = A00();
        String[] strArr = A07;
        if (strArr[3].charAt(2) == strArr[5].charAt(2)) {
            throw new RuntimeException();
        }
        A07[6] = "MExJxptNjWm815DyzsGP1";
        lhA00.AKA(false);
        interfaceC2164Zh.AET();
    }
}
