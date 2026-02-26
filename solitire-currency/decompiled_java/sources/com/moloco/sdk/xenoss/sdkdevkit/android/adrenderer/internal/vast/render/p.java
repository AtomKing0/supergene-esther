package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import android.content.Context;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.a0;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class p {
    @NotNull
    public static final n a(@Nullable a0 a0Var, @Nullable Integer num, @Nullable Integer num2, @Nullable String str, @NotNull o0 scope, @NotNull Context context, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull z externalLinkHandler, @Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2) {
        t.i(scope, "scope");
        t.i(context, "context");
        t.i(customUserEventBuilderService, "customUserEventBuilderService");
        t.i(externalLinkHandler, "externalLinkHandler");
        return new o(a0Var, num, num2, str, scope, context, customUserEventBuilderService, externalLinkHandler, aVar, aVar2);
    }
}
