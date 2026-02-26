package com.unity3d.services.ads.gmascar.handlers;

import com.unity3d.scar.adapter.common.c;
import com.unity3d.scar.adapter.common.e;
import com.unity3d.services.ads.gmascar.utils.GMAEventSender;
import com.unity3d.services.core.misc.EventSubject;
import com.unity3d.services.core.misc.IEventListener;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ScarAdHandlerBase implements e {
    protected final EventSubject<c> _eventSubject;
    protected final GMAEventSender _gmaEventSender;
    protected final a7.c _scarAdMetadata;

    public ScarAdHandlerBase(a7.c cVar, EventSubject<c> eventSubject, GMAEventSender gMAEventSender) {
        this._scarAdMetadata = cVar;
        this._eventSubject = eventSubject;
        this._gmaEventSender = gMAEventSender;
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClicked() {
        this._gmaEventSender.send(c.AD_CLICKED, new Object[0]);
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdClosed() {
        this._gmaEventSender.send(c.AD_CLOSED, new Object[0]);
        this._eventSubject.unsubscribe();
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdFailedToLoad(int i10, String str) {
        this._gmaEventSender.send(c.LOAD_ERROR, this._scarAdMetadata.c(), this._scarAdMetadata.d(), str, Integer.valueOf(i10));
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdLoaded() {
        this._gmaEventSender.send(c.AD_LOADED, this._scarAdMetadata.c(), this._scarAdMetadata.d());
    }

    @Override // com.unity3d.scar.adapter.common.e
    public void onAdOpened() {
        this._gmaEventSender.send(c.AD_STARTED, new Object[0]);
        this._eventSubject.subscribe(new IEventListener<c>() { // from class: com.unity3d.services.ads.gmascar.handlers.ScarAdHandlerBase.1
            @Override // com.unity3d.services.core.misc.IEventListener
            public void onNextEvent(c cVar) {
                ScarAdHandlerBase.this._gmaEventSender.send(cVar, new Object[0]);
            }
        });
    }
}
