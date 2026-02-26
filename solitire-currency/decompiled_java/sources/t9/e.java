package t9;

import java.util.ArrayList;
import kotlin.collections.d0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class e<T> implements p<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final z8.g f34113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f34114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final r9.a f34115c;

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {123}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34116j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f34117k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ s9.i<T> f34118l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ e<T> f34119m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(s9.i<? super T> iVar, e<T> eVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f34118l = iVar;
            this.f34119m = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f34118l, this.f34119m, dVar);
            aVar.f34117k = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34116j;
            if (i10 == 0) {
                v8.u.b(obj);
                o0 o0Var = (o0) this.f34117k;
                s9.i<T> iVar = this.f34118l;
                r9.t<T> tVarM = this.f34119m.m(o0Var);
                this.f34116j = 1;
                if (s9.j.r(iVar, tVarM, this) == objE) {
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
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: ChannelFlow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", l = {60}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<r9.r<? super T>, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34120j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f34121k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ e<T> f34122l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e<T> eVar, z8.d<? super b> dVar) {
            super(2, dVar);
            this.f34122l = eVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(this.f34122l, dVar);
            bVar.f34121k = obj;
            return bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34120j;
            if (i10 == 0) {
                v8.u.b(obj);
                r9.r<? super T> rVar = (r9.r) this.f34121k;
                e<T> eVar = this.f34122l;
                this.f34120j = 1;
                if (eVar.h(rVar, this) == objE) {
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
        public final Object mo4invoke(@NotNull r9.r<? super T> rVar, @Nullable z8.d<? super k0> dVar) {
            return ((b) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public e(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        this.f34113a = gVar;
        this.f34114b = i10;
        this.f34115c = aVar;
    }

    static /* synthetic */ <T> Object g(e<T> eVar, s9.i<? super T> iVar, z8.d<? super k0> dVar) {
        Object objF = p0.f(new a(iVar, eVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013 A[PHI: r4
      0x0013: PHI (r4v5 int) = (r4v2 int), (r4v2 int), (r4v4 int) binds: [B:8:0x0011, B:13:0x0019, B:16:0x001d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // t9.p
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s9.h<T> b(@org.jetbrains.annotations.NotNull z8.g r2, int r3, @org.jetbrains.annotations.NotNull r9.a r4) {
        /*
            r1 = this;
            z8.g r0 = r1.f34113a
            z8.g r2 = r2.plus(r0)
            r9.a r0 = r9.a.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f34114b
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r4 = r4 + r3
            if (r4 < 0) goto L20
            goto L13
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            r9.a r4 = r1.f34115c
        L25:
            z8.g r0 = r1.f34113a
            boolean r0 = kotlin.jvm.internal.t.d(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f34114b
            if (r3 != r0) goto L36
            r9.a r0 = r1.f34115c
            if (r4 != r0) goto L36
            return r1
        L36:
            t9.e r2 = r1.i(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t9.e.b(z8.g, int, r9.a):s9.h");
    }

    @Override // s9.h
    @Nullable
    public Object collect(@NotNull s9.i<? super T> iVar, @NotNull z8.d<? super k0> dVar) {
        return g(this, iVar, dVar);
    }

    @Nullable
    protected String f() {
        return null;
    }

    @Nullable
    protected abstract Object h(@NotNull r9.r<? super T> rVar, @NotNull z8.d<? super k0> dVar);

    @NotNull
    protected abstract e<T> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar);

    @Nullable
    public s9.h<T> j() {
        return null;
    }

    @NotNull
    public final h9.p<r9.r<? super T>, z8.d<? super k0>, Object> k() {
        return new b(this, null);
    }

    public final int l() {
        int i10 = this.f34114b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    @NotNull
    public r9.t<T> m(@NotNull o0 o0Var) {
        return r9.p.e(o0Var, this.f34113a, l(), this.f34115c, q0.ATOMIC, null, k(), 16, null);
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strF = f();
        if (strF != null) {
            arrayList.add(strF);
        }
        if (this.f34113a != z8.h.f37608a) {
            arrayList.add("context=" + this.f34113a);
        }
        if (this.f34114b != -3) {
            arrayList.add("capacity=" + this.f34114b);
        }
        if (this.f34115c != r9.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f34115c);
        }
        return s0.a(this) + '[' + d0.r0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
