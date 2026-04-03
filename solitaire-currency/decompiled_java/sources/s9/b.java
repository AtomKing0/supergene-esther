package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes5.dex */
final class b<T> extends f<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final h9.p<r9.r<? super T>, z8.d<? super v8.k0>, Object> f33647e;

    /* JADX INFO: compiled from: Builders.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.CallbackFlowBuilder", f = "Builders.kt", l = {334}, m = "collectTo")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33648j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33649k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ b<T> f33650l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33651m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(b<T> bVar, z8.d<? super a> dVar) {
            super(dVar);
            this.f33650l = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33649k = obj;
            this.f33651m |= Integer.MIN_VALUE;
            return this.f33650l.h(null, this);
        }
    }

    public /* synthetic */ b(h9.p pVar, z8.g gVar, int i10, r9.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(pVar, (i11 & 2) != 0 ? z8.h.f37608a : gVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? r9.a.SUSPEND : aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s9.f, t9.e
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected java.lang.Object h(@org.jetbrains.annotations.NotNull r9.r<? super T> r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof s9.b.a
            if (r0 == 0) goto L13
            r0 = r6
            s9.b$a r0 = (s9.b.a) r0
            int r1 = r0.f33651m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33651m = r1
            goto L18
        L13:
            s9.b$a r0 = new s9.b$a
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f33649k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33651m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f33648j
            r9.r r5 = (r9.r) r5
            v8.u.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            r0.f33648j = r5
            r0.f33651m = r3
            java.lang.Object r6 = super.h(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.t()
            if (r5 == 0) goto L4c
            v8.k0 r5 = v8.k0.f35197a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.b.h(r9.r, z8.d):java.lang.Object");
    }

    @Override // s9.f, t9.e
    @NotNull
    protected t9.e<T> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return new b(this.f33647e, gVar, i10, aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(@NotNull h9.p<? super r9.r<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(pVar, gVar, i10, aVar);
        this.f33647e = pVar;
    }
}
