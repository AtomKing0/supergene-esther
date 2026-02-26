package t9;

import kotlin.jvm.internal.n0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i<T, R> extends g<T, R> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final h9.q<s9.i<? super R>, T, z8.d<? super k0>, Object> f34127e;

    /* JADX INFO: compiled from: Merge.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3", f = "Merge.kt", l = {27}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f34128j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f34129k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ i<T, R> f34130l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ s9.i<R> f34131m;

        /* JADX INFO: renamed from: t9.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Merge.kt */
        static final class C0693a<T> implements s9.i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n0<b2> f34132a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ o0 f34133b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ i<T, R> f34134c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ s9.i<R> f34135d;

            /* JADX INFO: renamed from: t9.i$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Merge.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1$2", f = "Merge.kt", l = {34}, m = "invokeSuspend")
            static final class C0694a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                int f34136j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                final /* synthetic */ i<T, R> f34137k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                final /* synthetic */ s9.i<R> f34138l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                final /* synthetic */ T f34139m;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0694a(i<T, R> iVar, s9.i<? super R> iVar2, T t10, z8.d<? super C0694a> dVar) {
                    super(2, dVar);
                    this.f34137k = iVar;
                    this.f34138l = iVar2;
                    this.f34139m = t10;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C0694a(this.f34137k, this.f34138l, this.f34139m, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.f34136j;
                    if (i10 == 0) {
                        v8.u.b(obj);
                        h9.q qVar = ((i) this.f34137k).f34127e;
                        s9.i<R> iVar = this.f34138l;
                        T t10 = this.f34139m;
                        this.f34136j = 1;
                        if (qVar.invoke(iVar, t10, this) == objE) {
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
                    return ((C0694a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX INFO: renamed from: t9.i$a$a$b */
            /* JADX INFO: compiled from: Merge.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest$flowCollect$3$1", f = "Merge.kt", l = {30}, m = "emit")
            static final class b extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                Object f34140j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                Object f34141k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                Object f34142l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                /* synthetic */ Object f34143m;

                /* JADX INFO: renamed from: n, reason: collision with root package name */
                final /* synthetic */ C0693a<T> f34144n;

                /* JADX INFO: renamed from: o, reason: collision with root package name */
                int f34145o;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                b(C0693a<? super T> c0693a, z8.d<? super b> dVar) {
                    super(dVar);
                    this.f34144n = c0693a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f34143m = obj;
                    this.f34145o |= Integer.MIN_VALUE;
                    return this.f34144n.emit(null, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0693a(n0<b2> n0Var, o0 o0Var, i<T, R> iVar, s9.i<? super R> iVar2) {
                this.f34132a = n0Var;
                this.f34133b = o0Var;
                this.f34134c = iVar;
                this.f34135d = iVar2;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // s9.i
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof t9.i.a.C0693a.b
                    if (r0 == 0) goto L13
                    r0 = r9
                    t9.i$a$a$b r0 = (t9.i.a.C0693a.b) r0
                    int r1 = r0.f34145o
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f34145o = r1
                    goto L18
                L13:
                    t9.i$a$a$b r0 = new t9.i$a$a$b
                    r0.<init>(r7, r9)
                L18:
                    java.lang.Object r9 = r0.f34143m
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f34145o
                    r3 = 1
                    if (r2 == 0) goto L3b
                    if (r2 != r3) goto L33
                    java.lang.Object r8 = r0.f34142l
                    kotlinx.coroutines.b2 r8 = (kotlinx.coroutines.b2) r8
                    java.lang.Object r8 = r0.f34141k
                    java.lang.Object r0 = r0.f34140j
                    t9.i$a$a r0 = (t9.i.a.C0693a) r0
                    v8.u.b(r9)
                    goto L5e
                L33:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L3b:
                    v8.u.b(r9)
                    kotlin.jvm.internal.n0<kotlinx.coroutines.b2> r9 = r7.f34132a
                    T r9 = r9.f29834a
                    kotlinx.coroutines.b2 r9 = (kotlinx.coroutines.b2) r9
                    if (r9 == 0) goto L5d
                    t9.j r2 = new t9.j
                    r2.<init>()
                    r9.cancel(r2)
                    r0.f34140j = r7
                    r0.f34141k = r8
                    r0.f34142l = r9
                    r0.f34145o = r3
                    java.lang.Object r9 = r9.z(r0)
                    if (r9 != r1) goto L5d
                    return r1
                L5d:
                    r0 = r7
                L5e:
                    kotlin.jvm.internal.n0<kotlinx.coroutines.b2> r9 = r0.f34132a
                    kotlinx.coroutines.o0 r1 = r0.f34133b
                    r2 = 0
                    kotlinx.coroutines.q0 r3 = kotlinx.coroutines.q0.UNDISPATCHED
                    t9.i$a$a$a r4 = new t9.i$a$a$a
                    t9.i<T, R> r5 = r0.f34134c
                    s9.i<R> r0 = r0.f34135d
                    r6 = 0
                    r4.<init>(r5, r0, r8, r6)
                    r5 = 1
                    kotlinx.coroutines.b2 r8 = kotlinx.coroutines.i.d(r1, r2, r3, r4, r5, r6)
                    r9.f29834a = r8
                    v8.k0 r8 = v8.k0.f35197a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: t9.i.a.C0693a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i<T, R> iVar, s9.i<? super R> iVar2, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f34130l = iVar;
            this.f34131m = iVar2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f34130l, this.f34131m, dVar);
            aVar.f34129k = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f34128j;
            if (i10 == 0) {
                v8.u.b(obj);
                o0 o0Var = (o0) this.f34129k;
                n0 n0Var = new n0();
                i<T, R> iVar = this.f34130l;
                s9.h<S> hVar = iVar.f34123d;
                C0693a c0693a = new C0693a(n0Var, o0Var, iVar, this.f34131m);
                this.f34128j = 1;
                if (hVar.collect(c0693a, this) == objE) {
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

    public /* synthetic */ i(h9.q qVar, s9.h hVar, z8.g gVar, int i10, r9.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(qVar, hVar, (i11 & 4) != 0 ? z8.h.f37608a : gVar, (i11 & 8) != 0 ? -2 : i10, (i11 & 16) != 0 ? r9.a.SUSPEND : aVar);
    }

    @Override // t9.e
    @NotNull
    protected e<R> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return new i(this.f34127e, this.f34123d, gVar, i10, aVar);
    }

    @Override // t9.g
    @Nullable
    protected Object q(@NotNull s9.i<? super R> iVar, @NotNull z8.d<? super k0> dVar) {
        Object objF = p0.f(new a(this, iVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull h9.q<? super s9.i<? super R>, ? super T, ? super z8.d<? super k0>, ? extends Object> qVar, @NotNull s9.h<? extends T> hVar, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(hVar, gVar, i10, aVar);
        this.f34127e = qVar;
    }
}
