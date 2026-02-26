package com.unity3d.services.core.network.core;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: HttpClient.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface HttpClient {
    @Nullable
    Object execute(@NotNull HttpRequest httpRequest, @NotNull d<? super HttpResponse> dVar);

    @NotNull
    HttpResponse executeBlocking(@NotNull HttpRequest httpRequest) throws Exception;
}
