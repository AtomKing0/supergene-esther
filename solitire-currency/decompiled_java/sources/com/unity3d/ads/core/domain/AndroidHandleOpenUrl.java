package com.unity3d.ads.core.domain;

import android.content.Context;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidHandleOpenUrl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidHandleOpenUrl implements HandleOpenUrl {

    @NotNull
    private final Context context;

    public AndroidHandleOpenUrl(@NotNull Context context) {
        t.i(context, "context");
        this.context = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0019  */
    @Override // com.unity3d.ads.core.domain.HandleOpenUrl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void invoke(@org.jetbrains.annotations.NotNull java.lang.String r4, @org.jetbrains.annotations.Nullable java.lang.String r5) {
        /*
            r3 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.t.i(r4, r0)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            r1 = 0
            if (r5 == 0) goto L19
            int r2 = r5.length()
            if (r2 <= 0) goto L15
            r2 = 1
            goto L16
        L15:
            r2 = 0
        L16:
            if (r2 == 0) goto L19
            goto L1a
        L19:
            r5 = r1
        L1a:
            r0.setPackage(r5)
            java.lang.String r5 = "android.intent.action.VIEW"
            r0.setAction(r5)
            android.net.Uri r4 = android.net.Uri.parse(r4)
            r0.setData(r4)
            r4 = 268435456(0x10000000, float:2.524355E-29)
            r0.setFlags(r4)
            android.content.Context r4 = r3.context
            r4.startActivity(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidHandleOpenUrl.invoke(java.lang.String, java.lang.String):void");
    }
}
