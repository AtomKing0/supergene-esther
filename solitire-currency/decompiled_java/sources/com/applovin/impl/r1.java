package com.applovin.impl;

import android.app.Activity;
import android.view.ViewGroup;
import com.applovin.adview.AppLovinAdView;

/* JADX INFO: loaded from: classes2.dex */
public class r1 extends o1 {
    public r1(com.applovin.impl.sdk.ad.b bVar, Activity activity, com.applovin.impl.sdk.j jVar) {
        super(bVar, activity, jVar);
    }

    @Override // com.applovin.impl.o1
    public /* bridge */ /* synthetic */ void a(com.applovin.impl.adview.g gVar) {
        super.a(gVar);
    }

    public void a(com.applovin.impl.adview.g gVar, com.applovin.impl.adview.k kVar, AppLovinAdView appLovinAdView, ViewGroup viewGroup) {
        this.f6454d.addView(appLovinAdView);
        if (gVar != null) {
            a(this.f6453c.l(), (this.f6453c.x0() ? 3 : 5) | 48, gVar);
        }
        if (kVar != null) {
            this.f6454d.addView(kVar, this.f6455e);
        }
        if (viewGroup != null) {
            viewGroup.addView(this.f6454d);
        } else {
            this.f6452b.setContentView(this.f6454d);
        }
    }
}
