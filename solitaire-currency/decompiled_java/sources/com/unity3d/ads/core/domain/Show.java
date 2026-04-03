package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.ShowEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import v8.k0;

/* JADX INFO: compiled from: Show.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface Show {
    @NotNull
    h<ShowEvent> invoke(@NotNull Context context, @NotNull AdObject adObject, @NotNull UnityAdsShowOptions unityAdsShowOptions);

    @Nullable
    Object terminate(@NotNull AdObject adObject, @NotNull z8.d<? super k0> dVar);
}
