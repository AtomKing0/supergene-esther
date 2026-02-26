package io.ktor.utils.io;

import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Coroutines.kt */
/* JADX INFO: loaded from: classes3.dex */
final class m implements u, w, o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c f26929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ o0 f26930b;

    public m(@NotNull o0 delegate, @NotNull c channel) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(channel, "channel");
        this.f26929a = channel;
        this.f26930b = delegate;
    }

    @Override // io.ktor.utils.io.w
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c mo4209a() {
        return this.f26929a;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f26930b.getCoroutineContext();
    }
}
