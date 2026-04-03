package com.moloco.sdk.internal;

import android.content.Context;
import com.moloco.sdk.internal.services.x;
import com.moloco.sdk.publisher.Banner;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.NativeAd;
import com.moloco.sdk.publisher.RewardedInterstitialAd;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.z;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public interface b {
    @NotNull
    InterstitialAd a(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar);

    @NotNull
    NativeAd b(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull x xVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, @NotNull a aVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar2, @NotNull com.moloco.sdk.internal.services.r rVar2);

    @NotNull
    Banner c(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar, @NotNull a aVar2, @NotNull i iVar);

    @NotNull
    Banner d(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar, @NotNull a aVar2, @NotNull i iVar);

    @NotNull
    Banner e(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar, @NotNull a aVar2, @NotNull i iVar);

    @NotNull
    RewardedInterstitialAd f(@NotNull Context context, @NotNull com.moloco.sdk.internal.services.m mVar, @NotNull String str, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.t tVar, @NotNull z zVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.i iVar, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.r rVar, @NotNull com.moloco.sdk.internal.publisher.a aVar);
}
