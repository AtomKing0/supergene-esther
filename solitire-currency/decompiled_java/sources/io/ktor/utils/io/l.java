package io.ktor.utils.io;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: Coroutines.kt */
/* JADX INFO: loaded from: classes3.dex */
final class l implements t, v, b2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b2 f26927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c f26928b;

    public l(@NotNull b2 delegate, @NotNull c channel) {
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(channel, "channel");
        this.f26927a = delegate;
        this.f26928b = channel;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public kotlinx.coroutines.u G0(@NotNull kotlinx.coroutines.w child) {
        kotlin.jvm.internal.t.i(child, "child");
        return this.f26927a.G0(child);
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public g1 J(@NotNull h9.l<? super Throwable, k0> handler) {
        kotlin.jvm.internal.t.i(handler, "handler");
        return this.f26927a.J(handler);
    }

    @Override // io.ktor.utils.io.t
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public c mo4208a() {
        return this.f26928b;
    }

    @Override // kotlinx.coroutines.b2
    public void cancel(@Nullable CancellationException cancellationException) {
        this.f26927a.cancel(cancellationException);
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> operation) {
        kotlin.jvm.internal.t.i(operation, "operation");
        return (R) this.f26927a.fold(r10, operation);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> key) {
        kotlin.jvm.internal.t.i(key, "key");
        return (E) this.f26927a.get(key);
    }

    @Override // z8.g.b
    @NotNull
    public g.c<?> getKey() {
        return this.f26927a.getKey();
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public b2 getParent() {
        return this.f26927a.getParent();
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public g1 h0(boolean z10, boolean z11, @NotNull h9.l<? super Throwable, k0> handler) {
        kotlin.jvm.internal.t.i(handler, "handler");
        return this.f26927a.h0(z10, z11, handler);
    }

    @Override // kotlinx.coroutines.b2
    public boolean i() {
        return this.f26927a.i();
    }

    @Override // kotlinx.coroutines.b2
    public boolean isActive() {
        return this.f26927a.isActive();
    }

    @Override // kotlinx.coroutines.b2
    public boolean isCancelled() {
        return this.f26927a.isCancelled();
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> key) {
        kotlin.jvm.internal.t.i(key, "key");
        return this.f26927a.minusKey(key);
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g context) {
        kotlin.jvm.internal.t.i(context, "context");
        return this.f26927a.plus(context);
    }

    @Override // kotlinx.coroutines.b2
    public boolean start() {
        return this.f26927a.start();
    }

    @NotNull
    public String toString() {
        return "ChannelJob[" + this.f26927a + ']';
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public CancellationException x() {
        return this.f26927a.x();
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public Object z(@NotNull z8.d<? super k0> dVar) {
        return this.f26927a.z(dVar);
    }
}
