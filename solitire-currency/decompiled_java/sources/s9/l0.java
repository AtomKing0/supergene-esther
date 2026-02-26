package s9;

import java.util.List;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes5.dex */
final class l0 implements i0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f33727b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f33728c;

    /* JADX INFO: compiled from: SharingStarted.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", l = {178, 180, 182, 183, 185}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.q<i<? super g0>, Integer, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33729j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33730k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ int f33731l;

        a(z8.d<? super a> dVar) {
            super(3, dVar);
        }

        @Nullable
        public final Object f(@NotNull i<? super g0> iVar, int i10, @Nullable z8.d<? super v8.k0> dVar) {
            a aVar = l0.this.new a(dVar);
            aVar.f33730k = iVar;
            aVar.f33731l = i10;
            return aVar.invokeSuspend(v8.k0.f35197a);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Object invoke(i<? super g0> iVar, Integer num, z8.d<? super v8.k0> dVar) {
            return f(iVar, num.intValue(), dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0070  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x009b A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
            /*
                r9 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r9.f33729j
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L3c
                if (r1 == r6) goto L38
                if (r1 == r5) goto L30
                if (r1 == r4) goto L28
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                goto L38
            L18:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L20:
                java.lang.Object r1 = r9.f33730k
                s9.i r1 = (s9.i) r1
                v8.u.b(r10)
                goto L8e
            L28:
                java.lang.Object r1 = r9.f33730k
                s9.i r1 = (s9.i) r1
                v8.u.b(r10)
                goto L7d
            L30:
                java.lang.Object r1 = r9.f33730k
                s9.i r1 = (s9.i) r1
                v8.u.b(r10)
                goto L64
            L38:
                v8.u.b(r10)
                goto L9c
            L3c:
                v8.u.b(r10)
                java.lang.Object r10 = r9.f33730k
                r1 = r10
                s9.i r1 = (s9.i) r1
                int r10 = r9.f33731l
                if (r10 <= 0) goto L53
                s9.g0 r10 = s9.g0.START
                r9.f33729j = r6
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L9c
                return r0
            L53:
                s9.l0 r10 = s9.l0.this
                long r6 = s9.l0.c(r10)
                r9.f33730k = r1
                r9.f33729j = r5
                java.lang.Object r10 = kotlinx.coroutines.y0.a(r6, r9)
                if (r10 != r0) goto L64
                return r0
            L64:
                s9.l0 r10 = s9.l0.this
                long r5 = s9.l0.b(r10)
                r7 = 0
                int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r10 <= 0) goto L8e
                s9.g0 r10 = s9.g0.STOP
                r9.f33730k = r1
                r9.f33729j = r4
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L7d
                return r0
            L7d:
                s9.l0 r10 = s9.l0.this
                long r4 = s9.l0.b(r10)
                r9.f33730k = r1
                r9.f33729j = r3
                java.lang.Object r10 = kotlinx.coroutines.y0.a(r4, r9)
                if (r10 != r0) goto L8e
                return r0
            L8e:
                s9.g0 r10 = s9.g0.STOP_AND_RESET_REPLAY_CACHE
                r3 = 0
                r9.f33730k = r3
                r9.f33729j = r2
                java.lang.Object r10 = r1.emit(r10, r9)
                if (r10 != r0) goto L9c
                return r0
            L9c:
                v8.k0 r10 = v8.k0.f35197a
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.l0.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: SharingStarted.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", f = "SharingStarted.kt", l = {}, m = "invokeSuspend")
    static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<g0, z8.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33733j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33734k;

        b(z8.d<? super b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            b bVar = new b(dVar);
            bVar.f33734k = obj;
            return bVar;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull g0 g0Var, @Nullable z8.d<? super Boolean> dVar) {
            return ((b) create(g0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.f33733j != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            v8.u.b(obj);
            return kotlin.coroutines.jvm.internal.b.a(((g0) this.f33734k) != g0.START);
        }
    }

    public l0(long j10, long j11) {
        this.f33727b = j10;
        this.f33728c = j11;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j10 + " ms) cannot be negative").toString());
        }
        if (j11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j11 + " ms) cannot be negative").toString());
    }

    @Override // s9.i0
    @NotNull
    public h<g0> a(@NotNull m0<Integer> m0Var) {
        return j.p(j.q(j.O(m0Var, new a(null)), new b(null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l0) {
            l0 l0Var = (l0) obj;
            if (this.f33727b == l0Var.f33727b && this.f33728c == l0Var.f33728c) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (androidx.compose.animation.a.a(this.f33727b) * 31) + androidx.compose.animation.a.a(this.f33728c);
    }

    @NotNull
    public String toString() {
        List listD = kotlin.collections.u.d(2);
        if (this.f33727b > 0) {
            listD.add("stopTimeout=" + this.f33727b + "ms");
        }
        if (this.f33728c < Long.MAX_VALUE) {
            listD.add("replayExpiration=" + this.f33728c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + kotlin.collections.d0.r0(kotlin.collections.u.a(listD), null, null, null, 0, null, null, 63, null) + ')';
    }
}
