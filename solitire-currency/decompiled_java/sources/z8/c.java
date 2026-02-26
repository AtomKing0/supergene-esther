package z8;

import h9.p;
import java.io.Serializable;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final g f37603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final g.b f37604b;

    /* JADX INFO: compiled from: CoroutineContextImpl.kt */
    static final class a extends v implements p<String, g.b, String> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f37605g = new a();

        a() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String mo4invoke(@NotNull String acc, @NotNull g.b element) {
            t.i(acc, "acc");
            t.i(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(@NotNull g left, @NotNull g.b element) {
        t.i(left, "left");
        t.i(element, "element");
        this.f37603a = left;
        this.f37604b = element;
    }

    private final boolean b(g.b bVar) {
        return t.d(get(bVar.getKey()), bVar);
    }

    private final boolean d(c cVar) {
        while (b(cVar.f37604b)) {
            g gVar = cVar.f37603a;
            if (!(gVar instanceof c)) {
                t.g(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    private final int e() {
        int i10 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f37603a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.e() != e() || !cVar.d(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // z8.g
    public <R> R fold(R r10, @NotNull p<? super R, ? super g.b, ? extends R> operation) {
        t.i(operation, "operation");
        return operation.mo4invoke((Object) this.f37603a.fold(r10, operation), this.f37604b);
    }

    @Override // z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> key) {
        t.i(key, "key");
        c cVar = this;
        while (true) {
            E e10 = (E) cVar.f37604b.get(key);
            if (e10 != null) {
                return e10;
            }
            g gVar = cVar.f37603a;
            if (!(gVar instanceof c)) {
                return (E) gVar.get(key);
            }
            cVar = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f37603a.hashCode() + this.f37604b.hashCode();
    }

    @Override // z8.g
    @NotNull
    public g minusKey(@NotNull g.c<?> key) {
        t.i(key, "key");
        if (this.f37604b.get(key) != null) {
            return this.f37603a;
        }
        g gVarMinusKey = this.f37603a.minusKey(key);
        return gVarMinusKey == this.f37603a ? this : gVarMinusKey == h.f37608a ? this.f37604b : new c(gVarMinusKey, this.f37604b);
    }

    @Override // z8.g
    @NotNull
    public g plus(@NotNull g gVar) {
        return g.a.a(this, gVar);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) fold("", a.f37605g)) + ']';
    }
}
