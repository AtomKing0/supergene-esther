package a0;

import androidx.annotation.MainThread;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: Lifecycles.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: compiled from: Lifecycles.kt */
    @kotlin.coroutines.jvm.internal.f(c = "coil.util.-Lifecycles", f = "Lifecycles.kt", l = {44}, m = "awaitStarted")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f34k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f35l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f36m;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f35l = obj;
            this.f36m |= Integer.MIN_VALUE;
            return g.a(null, this);
        }
    }

    /* JADX INFO: compiled from: Lifecycles.kt */
    public static final class b implements DefaultLifecycleObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.o<k0> f37a;

        /* JADX WARN: Multi-variable type inference failed */
        b(kotlinx.coroutines.o<? super k0> oVar) {
            this.f37a = oVar;
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.a(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.b(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.d(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
            kotlinx.coroutines.o<k0> oVar = this.f37a;
            t.a aVar = v8.t.f35208b;
            oVar.resumeWith(v8.t.b(k0.f35197a));
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.f(this, lifecycleOwner);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, a0.g$b, java.lang.Object] */
    @androidx.annotation.MainThread
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull androidx.lifecycle.Lifecycle r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof a0.g.a
            if (r0 == 0) goto L13
            r0 = r7
            a0.g$a r0 = (a0.g.a) r0
            int r1 = r0.f36m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f36m = r1
            goto L18
        L13:
            a0.g$a r0 = new a0.g$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f35l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f36m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f34k
            kotlin.jvm.internal.n0 r6 = (kotlin.jvm.internal.n0) r6
            java.lang.Object r0 = r0.f33j
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            v8.u.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L85
        L31:
            r7 = move-exception
            goto L96
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            v8.u.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.getCurrentState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.STARTED
            boolean r7 = r7.isAtLeast(r2)
            if (r7 == 0) goto L4d
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L4d:
            kotlin.jvm.internal.n0 r7 = new kotlin.jvm.internal.n0
            r7.<init>()
            r0.f33j = r6     // Catch: java.lang.Throwable -> L91
            r0.f34k = r7     // Catch: java.lang.Throwable -> L91
            r0.f36m = r3     // Catch: java.lang.Throwable -> L91
            kotlinx.coroutines.p r2 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L91
            z8.d r4 = a9.b.c(r0)     // Catch: java.lang.Throwable -> L91
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L91
            r2.C()     // Catch: java.lang.Throwable -> L91
            a0.g$b r3 = new a0.g$b     // Catch: java.lang.Throwable -> L91
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L91
            r7.f29834a = r3     // Catch: java.lang.Throwable -> L91
            kotlin.jvm.internal.t.f(r3)     // Catch: java.lang.Throwable -> L91
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3     // Catch: java.lang.Throwable -> L91
            r6.addObserver(r3)     // Catch: java.lang.Throwable -> L91
            java.lang.Object r2 = r2.z()     // Catch: java.lang.Throwable -> L91
            java.lang.Object r3 = a9.b.e()     // Catch: java.lang.Throwable -> L91
            if (r2 != r3) goto L80
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: java.lang.Throwable -> L91
        L80:
            if (r2 != r1) goto L83
            return r1
        L83:
            r0 = r6
            r6 = r7
        L85:
            T r6 = r6.f29834a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L8e
            r0.removeObserver(r6)
        L8e:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L91:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L96:
            T r6 = r6.f29834a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L9f
            r0.removeObserver(r6)
        L9f:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a0.g.a(androidx.lifecycle.Lifecycle, z8.d):java.lang.Object");
    }

    @MainThread
    public static final void b(@NotNull Lifecycle lifecycle, @NotNull LifecycleObserver lifecycleObserver) {
        lifecycle.removeObserver(lifecycleObserver);
        lifecycle.addObserver(lifecycleObserver);
    }
}
