package com.vungle.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import com.vungle.ads.internal.util.c;
import com.vungle.ads.internal.util.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExternalRouter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    @NotNull
    public static final f INSTANCE = new f();
    private static final String TAG = f.class.getSimpleName();

    private f() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0012  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0013 A[Catch: URISyntaxException -> 0x000d, TryCatch #0 {URISyntaxException -> 0x000d, blocks: (B:4:0x0004, B:16:0x001c, B:13:0x0013), top: B:20:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x001a A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.content.Intent getIntentFromUrl(java.lang.String r5, boolean r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = 0
            if (r5 == 0) goto Lf
            int r2 = r5.length()     // Catch: java.net.URISyntaxException -> Ld
            if (r2 != 0) goto Lb
            goto Lf
        Lb:
            r2 = r0
            goto L10
        Ld:
            r5 = move-exception
            goto L22
        Lf:
            r2 = 1
        L10:
            if (r2 == 0) goto L13
            goto L18
        L13:
            android.content.Intent r5 = android.content.Intent.parseUri(r5, r0)     // Catch: java.net.URISyntaxException -> Ld
            r1 = r5
        L18:
            if (r1 == 0) goto L43
            if (r6 == 0) goto L43
            r5 = 268435456(0x10000000, float:2.524355E-29)
            r1.setFlags(r5)     // Catch: java.net.URISyntaxException -> Ld
            goto L43
        L22:
            com.vungle.ads.internal.util.p$a r6 = com.vungle.ads.internal.util.p.Companion
            java.lang.String r0 = com.vungle.ads.internal.util.f.TAG
            java.lang.String r2 = "TAG"
            kotlin.jvm.internal.t.h(r0, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "url format is not correct "
            r2.append(r3)
            java.lang.String r5 = r5.getLocalizedMessage()
            r2.append(r5)
            java.lang.String r5 = r2.toString()
            r6.e(r0, r5)
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.util.f.getIntentFromUrl(java.lang.String, boolean):android.content.Intent");
    }

    public static final boolean launch(@Nullable String str, @Nullable String str2, @NotNull Context context, @Nullable c.b bVar, @Nullable com.vungle.ads.internal.ui.b bVar2) {
        kotlin.jvm.internal.t.i(context, "context");
        boolean z10 = true;
        if (str == null || str.length() == 0) {
            if (str2 == null || str2.length() == 0) {
                return false;
            }
        }
        boolean z11 = !(context instanceof Activity);
        try {
            f fVar = INSTANCE;
            c.Companion.startWhenForeground(context, fVar.getIntentFromUrl(str, z11), fVar.getIntentFromUrl(str2, z11), bVar, bVar2);
            return true;
        } catch (Exception e10) {
            if (str != null && str.length() != 0) {
                z10 = false;
            }
            if (z10) {
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(314, "Fail to open " + str2, (28 & 4) != 0 ? null : "", (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            } else {
                com.vungle.ads.o.INSTANCE.logError$vungle_ads_release(312, "Fail to open " + str, (28 & 4) != 0 ? null : "", (28 & 8) != 0 ? null : null, (28 & 16) != 0 ? null : null);
            }
            p.a aVar = p.Companion;
            String TAG2 = TAG;
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.e(TAG2, "Error while opening url" + e10.getLocalizedMessage());
            kotlin.jvm.internal.t.h(TAG2, "TAG");
            aVar.d(TAG2, "Cannot open url " + str2);
            return false;
        }
    }
}
