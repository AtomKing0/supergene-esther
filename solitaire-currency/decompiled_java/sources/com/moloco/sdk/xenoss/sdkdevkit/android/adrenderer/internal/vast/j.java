package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.q;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k a(@NotNull f.a.AbstractC0379a mediaResult) {
        t.i(mediaResult, "mediaResult");
        if (t.d(mediaResult, f.a.AbstractC0379a.p.f19420a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_TMP_FILE_NOT_RENAMED_DISK_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.C0380a.f19405a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_DISK_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.b.f19406a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_IO_DISK_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.c.f19407a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_SECURITY_DISK_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.d.f19408a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_CREATED_UNKNOWN_DISK_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.C0381f.f19410a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_IO_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.g.f19411a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_DISK_SECURITY_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.r.f19422a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_MEDIA_FETCH_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.e.f19409a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_CLIENT_HTTP_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.h.f19412a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_SERVER_HTTP_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.n.f19418a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NO_NETWORK_HTTP_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.k.f19415a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_INVALID_URL_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.o.f19419a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_NOT_FOUND_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.q.f19421a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_UNKNOWN_HOST_HTTP_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.i.f19413a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_SOCKET_HTTP_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.j.f19414a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_HTTP_SSL_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.m.f19417a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_FILE_TIMEOUT_ERROR;
        }
        if (t.d(mediaResult, f.a.AbstractC0379a.l.f19416a)) {
            return com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k.VAST_AD_LOAD_MEDIA_NUMBER_PARSE_ERROR;
        }
        throw new q();
    }
}
