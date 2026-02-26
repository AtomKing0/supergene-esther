package kotlinx.coroutines;

import java.util.Collection;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: compiled from: Await.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {66}, m = "joinAll")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f29890j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f29891k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f29892l;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f29891k = obj;
            this.f29892l |= Integer.MIN_VALUE;
            return f.c(null, this);
        }
    }

    @Nullable
    public static final <T> Object a(@NotNull Collection<? extends v0<? extends T>> collection, @NotNull z8.d<? super List<? extends T>> dVar) {
        return collection.isEmpty() ? kotlin.collections.v.l() : new e((v0[]) collection.toArray(new v0[0])).c(dVar);
    }

    @Nullable
    public static final <T> Object b(@NotNull v0<? extends T>[] v0VarArr, @NotNull z8.d<? super List<? extends T>> dVar) {
        return v0VarArr.length == 0 ? kotlin.collections.v.l() : new e(v0VarArr).c(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlinx.coroutines.b2> r4, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.f.a
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.f$a r0 = (kotlinx.coroutines.f.a) r0
            int r1 = r0.f29892l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29892l = r1
            goto L18
        L13:
            kotlinx.coroutines.f$a r0 = new kotlinx.coroutines.f$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f29891k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f29892l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f29890j
            java.util.Iterator r4 = (java.util.Iterator) r4
            v8.u.b(r5)
            goto L3e
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r5)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
        L3e:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L55
            java.lang.Object r5 = r4.next()
            kotlinx.coroutines.b2 r5 = (kotlinx.coroutines.b2) r5
            r0.f29890j = r4
            r0.f29892l = r3
            java.lang.Object r5 = r5.z(r0)
            if (r5 != r1) goto L3e
            return r1
        L55:
            v8.k0 r4 = v8.k0.f35197a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f.c(java.util.Collection, z8.d):java.lang.Object");
    }
}
