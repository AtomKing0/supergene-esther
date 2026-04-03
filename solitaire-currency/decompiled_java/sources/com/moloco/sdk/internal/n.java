package com.moloco.sdk.internal;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum n implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c {
    AD_LOAD_LIMIT_REACHED,
    BID_LOAD_ERROR_CANNOT_PROCESS_BID_RESPONSE,
    BID_LOAD_ERROR_CANNOT_PARSE_BID_RESPONSE,
    AD_SHOW_ERROR_NOT_LOADED,
    AD_SHOW_ERROR_ALREADY_DISPLAYING;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    @NotNull
    public String a() {
        return name();
    }
}
