package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Flow.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a<T> implements h<T>, c<T> {

    /* JADX INFO: renamed from: s9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Flow.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    static final class C0675a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33641j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33642k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a<T> f33643l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33644m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0675a(a<T> aVar, z8.d<? super C0675a> dVar) {
            super(dVar);
            this.f33643l = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33642k = obj;
            this.f33644m |= Integer.MIN_VALUE;
            return this.f33643l.collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // s9.h
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof s9.a.C0675a
            if (r0 == 0) goto L13
            r0 = r7
            s9.a$a r0 = (s9.a.C0675a) r0
            int r1 = r0.f33644m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33644m = r1
            goto L18
        L13:
            s9.a$a r0 = new s9.a$a
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f33642k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33644m
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.f33641j
            t9.t r6 = (t9.t) r6
            v8.u.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            v8.u.b(r7)
            t9.t r7 = new t9.t
            z8.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.f33641j = r7     // Catch: java.lang.Throwable -> L55
            r0.f33644m = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.f(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.a.collect(s9.i, z8.d):java.lang.Object");
    }

    @Nullable
    public abstract Object f(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar);
}
