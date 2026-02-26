package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.k;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
public final class j {
    @NotNull
    public static final List<k> a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, @NotNull z externalLinkHandler, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, boolean z10, @Nullable Boolean bool, int i10, int i11, int i12, boolean z11, boolean z12) {
        t.i(aVar, "<this>");
        t.i(externalLinkHandler, "externalLinkHandler");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        k[] kVarArr = new k[3];
        kVarArr[0] = new k.c(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.e(aVar.g(), 0, z10, bool, i10, z11, z12, context, customUserEventBuilderService, externalLinkHandler));
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.c cVarC = aVar.c();
        kVarArr[1] = cVarC != null ? new k.a(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.c(cVarC, c0.c(o.e(i11, 0)), context, customUserEventBuilderService, externalLinkHandler, z10, null)) : null;
        s sVarD = aVar.d();
        kVarArr[2] = sVarD != null ? new k.b(new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.c(sVarD, aVar.g().d(), c0.c(o.e(i12, 0)), context, customUserEventBuilderService, externalLinkHandler, null)) : null;
        return v.p(kVarArr);
    }
}
