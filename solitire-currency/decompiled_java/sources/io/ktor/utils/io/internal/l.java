package io.ktor.utils.io.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import q8.a;

/* JADX INFO: compiled from: WriteSessionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private io.ktor.utils.io.a f26876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private ByteBuffer f26877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private q8.a f26878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private i f26879d;

    public l(@NotNull io.ktor.utils.io.a channel) {
        t.i(channel, "channel");
        this.f26876a = channel.m0();
        a.d dVar = q8.a.f33167j;
        this.f26877b = dVar.a().g();
        this.f26878c = dVar.a();
        this.f26879d = this.f26876a.K().f26845b;
    }
}
