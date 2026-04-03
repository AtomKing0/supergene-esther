package com.iab.omid.library.applovin.adsession.media;

import com.ironsource.w8;

/* JADX INFO: loaded from: classes4.dex */
public enum InteractionType {
    CLICK(w8.f16021d),
    INVITATION_ACCEPTED("invitationAccept");

    String interactionType;

    InteractionType(String str) {
        this.interactionType = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.interactionType;
    }
}
