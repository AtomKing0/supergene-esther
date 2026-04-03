package com.unity3d.ads.adplayer.model;

import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WebViewEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OnWebRequestComplete implements WebViewEvent {

    @NotNull
    private final String category;

    @NotNull
    private final String name;

    @NotNull
    private final Object[] parameters;

    public OnWebRequestComplete(@NotNull List<? extends Object> value) {
        t.i(value, "value");
        this.category = "REQUEST";
        this.name = "COMPLETE";
        this.parameters = value.toArray(new Object[0]);
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    @NotNull
    public String getCategory() {
        return this.category;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    @NotNull
    public String getName() {
        return this.name;
    }

    @Override // com.unity3d.ads.adplayer.model.WebViewEvent
    @NotNull
    public Object[] getParameters() {
        return this.parameters;
    }
}
