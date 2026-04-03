package com.moloco.sdk.internal;

import android.net.Uri;
import androidx.annotation.VisibleForTesting;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
public final class v implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i f18838a;

    public v(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i persistentHttpRequest) {
        kotlin.jvm.internal.t.i(persistentHttpRequest, "persistentHttpRequest");
        this.f18838a = persistentHttpRequest;
    }

    @Override // com.moloco.sdk.internal.u
    public boolean a(@NotNull String url, long j10, @Nullable q qVar) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVarB;
        kotlin.jvm.internal.t.i(url, "url");
        if (qVar != null) {
            try {
                cVarB = qVar.b();
            } catch (Exception e10) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, "SdkEventUrlTrackerImpl", e10.toString(), null, false, 12, null);
                return false;
            }
        } else {
            cVarB = null;
        }
        Uri uriBuild = Uri.parse(b(url, j10, cVarB)).buildUpon().build();
        com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar = this.f18838a;
        String string = uriBuild.toString();
        kotlin.jvm.internal.t.h(string, "preparedUrl.toString()");
        iVar.a(string);
        return true;
    }

    public final String b(String str, long j10, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c cVar) {
        String strC;
        if (cVar != null && (strC = com.moloco.sdk.internal.utils.d.c(str, cVar.a())) != null) {
            str = strC;
        }
        return com.moloco.sdk.internal.utils.d.b(str, j10);
    }
}
