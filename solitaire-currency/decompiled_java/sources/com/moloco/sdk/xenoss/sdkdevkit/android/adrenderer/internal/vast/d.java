package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast;

import com.moloco.sdk.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface d {

    public static final class a {
        public static /* synthetic */ Object a(d dVar, String str, String str2, boolean z10, z8.d dVar2, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invoke");
            }
            if ((i10 & 2) != 0) {
                str2 = "UNKNOWN_MTID";
            }
            return dVar.a(str, str2, z10, dVar2);
        }
    }

    @Nullable
    Object a(@NotNull String str, @NotNull String str2, boolean z10, @NotNull z8.d<? super t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> dVar);

    @Nullable
    Object b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a aVar, long j10, @NotNull z8.d<? super t<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.k>> dVar);
}
