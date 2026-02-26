package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum f implements c {
    NATIVE_AD_ORTB_RESPONSE_NULL_ERROR,
    NATIVE_AD_IMAGE_ASSET_MEDIA_FETCH_ERROR,
    NATIVE_AD_IMAGE_PREPARE_ASSET_UNKNOWN_ERROR,
    NATIVE_AD_VIDEO_ASSET_MEDIA_NOT_ENOUGH_ERROR,
    NATIVE_AD_VIDEO_ASSET_MEDIA_FETCH_ERROR;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    @NotNull
    public String a() {
        return name();
    }
}
