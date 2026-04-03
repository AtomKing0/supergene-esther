package com.unity3d.services.ads.gmascar.handlers;

import a7.c;
import com.unity3d.scar.adapter.common.h;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;

/* JADX INFO: loaded from: classes4.dex */
public class ScarInterstitialAdHandler extends ScarAdHandlerBase implements h {
    public ScarInterstitialAdHandler(c cVar, EventSubject<com.unity3d.scar.adapter.common.c> eventSubject, GMAEventSender gMAEventSender) {
        super(cVar, eventSubject, gMAEventSender);
    }

    @Override // com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase, com.unity3d.scar.adapter.common.e
    public void onAdClosed() {
        if (!this._eventSubject.eventQueueIsEmpty()) {
            onAdSkipped();
        }
        super.onAdClosed();
    }

    @Override // com.unity3d.scar.adapter.common.h
    public void onAdFailedToShow(int i10, String str) {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.INTERSTITIAL_SHOW_ERROR, this._scarAdMetadata.c(), this._scarAdMetadata.d(), str, Integer.valueOf(i10));
    }

    @Override // com.unity3d.scar.adapter.common.h
    public void onAdImpression() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.INTERSTITIAL_IMPRESSION_RECORDED, new Object[0]);
    }

    public void onAdLeftApplication() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.AD_LEFT_APPLICATION, new Object[0]);
    }

    public void onAdSkipped() {
        this._gmaEventSender.send(com.unity3d.scar.adapter.common.c.AD_SKIPPED, new Object[0]);
    }
}
