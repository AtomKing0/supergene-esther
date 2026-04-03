package com.moloco.sdk.internal;

import android.net.Uri;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f17639a;

    public g(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        this.f17639a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.f
    public void a(@NotNull String burl) {
        kotlin.jvm.internal.t.i(burl, "burl");
        try {
            Uri uri = Uri.parse(burl);
            com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f17639a;
            String string = uri.toString();
            kotlin.jvm.internal.t.h(string, "preparedUrl.toString()");
            iVar.a(string);
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "BUrlTrackerImpl", e10.toString(), null, false, 12, null);
        }
    }
}
