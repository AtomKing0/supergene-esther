package com.braze.enums;

import com.braze.models.IPutIntoJson;
import com.ironsource.u3;

/* JADX INFO: loaded from: classes2.dex */
public enum SdkFlavor implements IPutIntoJson<String> {
    UNITY("unity"),
    REACT("react"),
    CORDOVA("cordova"),
    XAMARIN("xamarin"),
    FLUTTER("flutter"),
    SEGMENT(u3.f15556i),
    TEALIUM("tealium"),
    MPARTICLE("mparticle");

    private final String jsonKey;

    SdkFlavor(String str) {
        this.jsonKey = str;
    }

    @Override // com.braze.models.IPutIntoJson
    public String forJsonPut() {
        return this.jsonKey;
    }
}
