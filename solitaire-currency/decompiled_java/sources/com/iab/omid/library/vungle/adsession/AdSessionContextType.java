package com.iab.omid.library.vungle.adsession;

import com.king.amp.sa.AbmAdPlayer;

/* JADX INFO: loaded from: classes4.dex */
public enum AdSessionContextType {
    HTML(AbmAdPlayer.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");

    private final String typeString;

    AdSessionContextType(String str) {
        this.typeString = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.typeString;
    }
}
