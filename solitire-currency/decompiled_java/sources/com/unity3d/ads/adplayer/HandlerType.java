package com.unity3d.ads.adplayer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: HandlerType.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum HandlerType {
    CALLBACK("handleCallback"),
    INVOCATION("handleInvocation"),
    EVENT("handleEvent");


    @NotNull
    private final String jsPath;

    HandlerType(String str) {
        this.jsPath = str;
    }

    @NotNull
    public final String getJsPath() {
        return this.jsPath;
    }
}
