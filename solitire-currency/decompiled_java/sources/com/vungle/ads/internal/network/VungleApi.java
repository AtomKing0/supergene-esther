package com.vungle.ads.internal.network;

import androidx.annotation.Keep;
import ga.c0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleApi.kt */
/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface VungleApi {
    @Nullable
    a<com.vungle.ads.internal.model.b> ads(@NotNull String str, @NotNull String str2, @NotNull com.vungle.ads.internal.model.f fVar);

    @Nullable
    a<com.vungle.ads.internal.model.g> config(@NotNull String str, @NotNull String str2, @NotNull com.vungle.ads.internal.model.f fVar);

    @NotNull
    a<Void> pingTPAT(@NotNull String str, @NotNull String str2);

    @Nullable
    a<Void> ri(@NotNull String str, @NotNull String str2, @NotNull com.vungle.ads.internal.model.f fVar);

    @NotNull
    a<Void> sendAdMarkup(@NotNull String str, @NotNull c0 c0Var);

    @NotNull
    a<Void> sendErrors(@NotNull String str, @NotNull String str2, @NotNull c0 c0Var);

    @NotNull
    a<Void> sendMetrics(@NotNull String str, @NotNull String str2, @NotNull c0 c0Var);

    void setAppId(@NotNull String str);
}
