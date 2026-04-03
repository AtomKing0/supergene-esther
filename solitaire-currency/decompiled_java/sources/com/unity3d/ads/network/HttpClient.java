package com.unity3d.ads.network;

import com.unity3d.ads.network.model.HttpRequest;
import com.unity3d.ads.network.model.HttpResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface HttpClient {
    @Nullable
    Object execute(@NotNull HttpRequest httpRequest, @NotNull d<? super HttpResponse> dVar);
}
