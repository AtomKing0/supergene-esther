package v7;

import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.n0;
import org.jetbrains.annotations.NotNull;
import v7.b;
import v8.n;
import z8.g;

/* JADX INFO: compiled from: HttpClientEngineBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class c implements b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f35143d = AtomicIntegerFieldUpdater.newUpdater(c.class, "closed");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f35144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k0 f35145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final v8.l f35146c;

    @NotNull
    private volatile /* synthetic */ int closed;

    /* JADX INFO: compiled from: HttpClientEngineBase.kt */
    static final class a extends v implements h9.a<z8.g> {
        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final z8.g invoke() {
            return g8.m.b(null, 1, null).plus(c.this.i()).plus(new n0(c.this.f35144a + "-context"));
        }
    }

    public c(@NotNull String engineName) {
        t.i(engineName, "engineName");
        this.f35144a = engineName;
        this.closed = 0;
        this.f35145b = d.a();
        this.f35146c = n.a(new a());
    }

    @Override // v7.b
    public void c0(@NotNull s7.a aVar) {
        b.a.h(this, aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (f35143d.compareAndSet(this, 0, 1)) {
            g.b bVar = getCoroutineContext().get(b2.O7);
            a0 a0Var = bVar instanceof a0 ? (a0) bVar : null;
            if (a0Var == null) {
                return;
            }
            a0Var.complete();
        }
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return (z8.g) this.f35146c.getValue();
    }

    @NotNull
    public k0 i() {
        return this.f35145b;
    }

    @Override // v7.b
    @NotNull
    public Set<e<?>> n0() {
        return b.a.g(this);
    }
}
