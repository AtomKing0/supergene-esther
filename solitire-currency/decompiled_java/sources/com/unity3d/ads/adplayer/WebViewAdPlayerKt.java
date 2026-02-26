package com.unity3d.ads.adplayer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WebViewAdPlayer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class WebViewAdPlayerKt {

    @NotNull
    private static final String[] SHOW_EVENTS = {ExposedFunctionLocation.STARTED, ExposedFunctionLocation.CLICKED, ExposedFunctionLocation.COMPLETED, ExposedFunctionLocation.FAILED, ExposedFunctionLocation.CANCEL_SHOW_TIMEOUT, ExposedFunctionLocation.LEFT_APPLICATION};

    @NotNull
    private static final String[] LOAD_EVENTS = {ExposedFunctionLocation.LOAD_COMPLETE, ExposedFunctionLocation.LOAD_ERROR};

    @NotNull
    private static final String[] REQUEST_EVENTS = {ExposedFunctionLocation.REQUEST_GET, ExposedFunctionLocation.REQUEST_POST, ExposedFunctionLocation.REQUEST_HEAD};
}
