package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ByteBufferChannelInternals.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26833c = AtomicReferenceFieldUpdater.newUpdater(d.class, Object.class, "_closeWaitJob");

    @NotNull
    private volatile /* synthetic */ Object _closeWaitJob;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.ktor.utils.io.a f26834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f26835b;

    @NotNull
    private volatile /* synthetic */ int closed;

    public final void a() {
        this.closed = 1;
        b2 b2Var = (b2) f26833c.getAndSet(this, null);
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
    }

    public final boolean b() {
        return this.f26835b;
    }

    @NotNull
    public final io.ktor.utils.io.a c() {
        return this.f26834a;
    }
}
