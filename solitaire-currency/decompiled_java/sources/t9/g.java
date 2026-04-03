package t9;

import kotlinx.coroutines.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.e;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class g<S, T> extends e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    protected final s9.h<S> f34123d;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowOperator$collectWithContextUndispatched$2", f = "ChannelFlow.kt", l = {152}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<s9.i<? super T>, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34124j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f34125k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ g<S, T> f34126l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g<S, T> gVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f34126l = gVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f34126l, dVar);
            aVar.f34125k = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34124j;
            if (i10 == 0) {
                v8.u.b(obj);
                s9.i<? super T> iVar = (s9.i) this.f34125k;
                g<S, T> gVar = this.f34126l;
                this.f34124j = 1;
                if (gVar.q(iVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull s9.i<? super T> iVar, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(iVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull s9.h<? extends S> hVar, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(gVar, i10, aVar);
        this.f34123d = hVar;
    }

    static /* synthetic */ <S, T> Object n(g<S, T> gVar, s9.i<? super T> iVar, z8.d<? super k0> dVar) {
        if (gVar.f34114b == -3) {
            z8.g context = dVar.getContext();
            z8.g gVarE = j0.e(context, gVar.f34113a);
            if (kotlin.jvm.internal.t.d(gVarE, context)) {
                Object objQ = gVar.q(iVar, dVar);
                return objQ == a9.d.e() ? objQ : k0.f35197a;
            }
            e.b bVar = z8.e.R7;
            if (kotlin.jvm.internal.t.d(gVarE.get(bVar), context.get(bVar))) {
                Object objP = gVar.p(iVar, gVarE, dVar);
                return objP == a9.d.e() ? objP : k0.f35197a;
            }
        }
        Object objCollect = super.collect(iVar, dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    static /* synthetic */ <S, T> Object o(g<S, T> gVar, r9.r<? super T> rVar, z8.d<? super k0> dVar) {
        Object objQ = gVar.q(new w(rVar), dVar);
        return objQ == a9.d.e() ? objQ : k0.f35197a;
    }

    private final Object p(s9.i<? super T> iVar, z8.g gVar, z8.d<? super k0> dVar) {
        Object objC = f.c(gVar, f.d(iVar, dVar.getContext()), null, new a(this, null), dVar, 4, null);
        return objC == a9.d.e() ? objC : k0.f35197a;
    }

    @Override // t9.e, s9.h
    @Nullable
    public Object collect(@NotNull s9.i<? super T> iVar, @NotNull z8.d<? super k0> dVar) {
        return n(this, iVar, dVar);
    }

    @Override // t9.e
    @Nullable
    protected Object h(@NotNull r9.r<? super T> rVar, @NotNull z8.d<? super k0> dVar) {
        return o(this, rVar, dVar);
    }

    @Nullable
    protected abstract Object q(@NotNull s9.i<? super T> iVar, @NotNull z8.d<? super k0> dVar);

    @Override // t9.e
    @NotNull
    public String toString() {
        return this.f34123d + " -> " + super.toString();
    }
}
