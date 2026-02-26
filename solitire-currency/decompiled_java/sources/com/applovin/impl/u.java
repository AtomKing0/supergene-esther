package com.applovin.impl;

import android.content.Context;
import com.amazon.aps.ads.Aps;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.DTBAdCallback;
import com.amazon.device.ads.DTBAdRequest;
import com.amazon.device.ads.DTBAdResponse;
import com.amazon.device.ads.DTBAdSize;
import com.applovin.mediation.MaxAdFormat;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class u implements DTBAdCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaxAdFormat f7486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f7487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DTBAdRequest f7488c;

    public interface a {
        void onAdLoadFailed(AdError adError, MaxAdFormat maxAdFormat);

        void onAdResponseLoaded(DTBAdResponse dTBAdResponse, MaxAdFormat maxAdFormat);
    }

    public u(v vVar, MaxAdFormat maxAdFormat, Context context, a aVar) {
        this(Arrays.asList(vVar.a()), maxAdFormat, context, aVar);
    }

    public void a() {
        DTBAdRequest dTBAdRequest = this.f7488c;
        if (dTBAdRequest == null) {
            this.f7487b.onAdLoadFailed(null, this.f7486a);
        } else {
            dTBAdRequest.loadAd(this);
        }
    }

    public void onFailure(AdError adError) {
        this.f7487b.onAdLoadFailed(adError, this.f7486a);
    }

    public void onSuccess(DTBAdResponse dTBAdResponse) {
        this.f7487b.onAdResponseLoaded(dTBAdResponse, this.f7486a);
    }

    public u(List list, MaxAdFormat maxAdFormat, Context context, a aVar) {
        this.f7486a = maxAdFormat;
        this.f7487b = aVar;
        try {
            DTBAdSize[] dTBAdSizeArr = new DTBAdSize[list.size()];
            for (int i10 = 0; i10 < list.size(); i10++) {
                Object obj = list.get(i10);
                if (obj instanceof DTBAdSize) {
                    dTBAdSizeArr[i10] = (DTBAdSize) obj;
                }
            }
            if (z6.a(Aps.getSdkVersion(), "10.0.0") >= 0) {
                Class<?> cls = Class.forName("com.amazon.aps.ads.model.ApsAdNetwork");
                Class<?> cls2 = Class.forName("com.amazon.device.ads.DTBAdNetworkInfo");
                this.f7488c = (DTBAdRequest) DTBAdRequest.class.getConstructor(Context.class, cls2).newInstance(context.getApplicationContext(), cls2.getConstructor(cls).newInstance(cls.getField("MAX").get(null)));
            } else {
                this.f7488c = (DTBAdRequest) DTBAdRequest.class.getConstructor(null).newInstance(null);
            }
            this.f7488c.setSizes(dTBAdSizeArr);
        } catch (Throwable unused) {
        }
    }
}
