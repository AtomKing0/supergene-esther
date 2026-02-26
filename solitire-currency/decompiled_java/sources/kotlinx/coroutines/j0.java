package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.g;

/* JADX INFO: compiled from: CoroutineContext.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 {

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<z8.g, g.b, z8.g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f29908g = new a();

        a() {
            super(2);
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z8.g mo4invoke(@NotNull z8.g gVar, @NotNull g.b bVar) {
            return bVar instanceof h0 ? gVar.plus(((h0) bVar).L()) : gVar.plus(bVar);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class b extends kotlin.jvm.internal.v implements h9.p<z8.g, g.b, z8.g> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0<z8.g> f29909g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ boolean f29910h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(kotlin.jvm.internal.n0<z8.g> n0Var, boolean z10) {
            super(2);
            this.f29909g = n0Var;
            this.f29910h = z10;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [T, z8.g] */
        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final z8.g mo4invoke(@NotNull z8.g gVar, @NotNull g.b bVar) {
            if (!(bVar instanceof h0)) {
                return gVar.plus(bVar);
            }
            g.b bVar2 = this.f29909g.f29834a.get(bVar.getKey());
            if (bVar2 != null) {
                kotlin.jvm.internal.n0<z8.g> n0Var = this.f29909g;
                n0Var.f29834a = n0Var.f29834a.minusKey(bVar.getKey());
                return gVar.plus(((h0) bVar).W(bVar2));
            }
            h0 h0VarL = (h0) bVar;
            if (this.f29910h) {
                h0VarL = h0VarL.L();
            }
            return gVar.plus(h0VarL);
        }
    }

    /* JADX INFO: compiled from: CoroutineContext.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.p<Boolean, g.b, Boolean> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final c f29911g = new c();

        c() {
            super(2);
        }

        @NotNull
        public final Boolean a(boolean z10, @NotNull g.b bVar) {
            return Boolean.valueOf(z10 || (bVar instanceof h0));
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Boolean mo4invoke(Boolean bool, g.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final z8.g a(z8.g gVar, z8.g gVar2, boolean z10) {
        boolean zC = c(gVar);
        boolean zC2 = c(gVar2);
        if (!zC && !zC2) {
            return gVar.plus(gVar2);
        }
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        n0Var.f29834a = gVar2;
        z8.h hVar = z8.h.f37608a;
        z8.g gVar3 = (z8.g) gVar.fold(hVar, new b(n0Var, z10));
        if (zC2) {
            n0Var.f29834a = ((z8.g) n0Var.f29834a).fold(hVar, a.f29908g);
        }
        return gVar3.plus((z8.g) n0Var.f29834a);
    }

    @Nullable
    public static final String b(@NotNull z8.g gVar) {
        return null;
    }

    private static final boolean c(z8.g gVar) {
        return ((Boolean) gVar.fold(Boolean.FALSE, c.f29911g)).booleanValue();
    }

    @NotNull
    public static final z8.g d(@NotNull o0 o0Var, @NotNull z8.g gVar) {
        z8.g gVarA = a(o0Var.getCoroutineContext(), gVar, true);
        return (gVarA == e1.a() || gVarA.get(z8.e.R7) != null) ? gVarA : gVarA.plus(e1.a());
    }

    @NotNull
    public static final z8.g e(@NotNull z8.g gVar, @NotNull z8.g gVar2) {
        return !c(gVar2) ? gVar.plus(gVar2) : a(gVar, gVar2, false);
    }

    @Nullable
    public static final h3<?> f(@NotNull kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof a1) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof h3) {
                return (h3) eVar;
            }
        }
        return null;
    }

    @Nullable
    public static final h3<?> g(@NotNull z8.d<?> dVar, @NotNull z8.g gVar, @Nullable Object obj) {
        if (!(dVar instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (!(gVar.get(i3.f29907a) != null)) {
            return null;
        }
        h3<?> h3VarF = f((kotlin.coroutines.jvm.internal.e) dVar);
        if (h3VarF != null) {
            h3VarF.V0(gVar, obj);
        }
        return h3VarF;
    }
}
