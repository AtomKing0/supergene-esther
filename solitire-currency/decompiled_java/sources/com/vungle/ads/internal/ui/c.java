package com.vungle.ads.internal.ui;

import com.vungle.ads.internal.util.c;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PresenterAppLeftCallback.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c implements c.b {

    @Nullable
    private final com.vungle.ads.internal.presenter.a bus;

    @Nullable
    private final String placementRefId;

    public c(@Nullable com.vungle.ads.internal.presenter.a aVar, @Nullable String str) {
        this.bus = aVar;
        this.placementRefId = str;
    }

    @Override // com.vungle.ads.internal.util.c.b
    public void onLeftApplication() {
        com.vungle.ads.internal.presenter.a aVar = this.bus;
        if (aVar != null) {
            aVar.onNext("open", "adLeftApplication", this.placementRefId);
        }
    }
}
