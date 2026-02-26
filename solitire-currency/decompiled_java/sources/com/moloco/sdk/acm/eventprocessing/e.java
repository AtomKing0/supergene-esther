package com.moloco.sdk.acm.eventprocessing;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.acm.services.g f17373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17374b;

    public e(@NotNull com.moloco.sdk.acm.services.g timeProviderService, long j10) {
        t.i(timeProviderService, "timeProviderService");
        this.f17373a = timeProviderService;
        this.f17374b = j10;
    }

    public final boolean a(@NotNull com.moloco.sdk.acm.db.b eventEntity) {
        t.i(eventEntity, "eventEntity");
        return this.f17373a.invoke() - eventEntity.f() >= this.f17374b * ((long) 1000);
    }
}
