package v7;

import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class j implements g.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final a f35154b = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final z8.g f35155a;

    /* JADX INFO: compiled from: Utils.kt */
    public static final class a implements g.c<j> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public j(@NotNull z8.g callContext) {
        t.i(callContext, "callContext");
        this.f35155a = callContext;
    }

    @NotNull
    public final z8.g b() {
        return this.f35155a;
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) g.b.a.a(this, r10, pVar);
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) g.b.a.b(this, cVar);
    }

    @Override // z8.g.b
    @NotNull
    public g.c<?> getKey() {
        return f35154b;
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return g.b.a.c(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return g.b.a.d(this, gVar);
    }
}
