package com.unity3d.ads.adplayer.model;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WebViewEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface WebViewEvent {
    @NotNull
    String getCategory();

    @NotNull
    String getName();

    @NotNull
    Object[] getParameters();
}
