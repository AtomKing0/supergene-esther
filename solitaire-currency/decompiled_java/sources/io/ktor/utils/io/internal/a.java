package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.a0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AwaitingSlot.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26816a = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "suspension");

    @NotNull
    private volatile /* synthetic */ Object suspension = null;

    /* JADX INFO: renamed from: io.ktor.utils.io.internal.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {24}, m = "sleep")
    static final class C0576a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26817j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f26818k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26820m;

        C0576a(z8.d<? super C0576a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26818k = obj;
            this.f26820m |= Integer.MIN_VALUE;
            return a.this.d(null, this);
        }
    }

    /* JADX INFO: compiled from: AwaitingSlot.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.internal.AwaitingSlot", f = "AwaitingSlot.kt", l = {57}, m = "trySuspend")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f26821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f26822k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f26824m;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26822k = obj;
            this.f26824m |= Integer.MIN_VALUE;
            return a.this.e(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(h9.a<java.lang.Boolean> r7, z8.d<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof io.ktor.utils.io.internal.a.b
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.internal.a$b r0 = (io.ktor.utils.io.internal.a.b) r0
            int r1 = r0.f26824m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26824m = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.a$b r0 = new io.ktor.utils.io.internal.a$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f26822k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26824m
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L34
            if (r2 != r4) goto L2c
            int r7 = r0.f26821j
            v8.u.b(r8)
            goto L5e
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            v8.u.b(r8)
            r8 = 0
            kotlinx.coroutines.a0 r2 = kotlinx.coroutines.f2.b(r8, r4, r8)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.io.internal.a.f26816a
            boolean r8 = androidx.concurrent.futures.a.a(r5, r6, r8, r2)
            if (r8 == 0) goto L5d
            java.lang.Object r7 = r7.invoke()
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L5d
            r0.f26821j = r4
            r0.f26824m = r4
            java.lang.Object r7 = r2.z(r0)
            if (r7 != r1) goto L5b
            return r1
        L5b:
            r7 = r4
            goto L5e
        L5d:
            r7 = r3
        L5e:
            if (r7 == 0) goto L61
            r3 = r4
        L61:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.b.a(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.a.e(h9.a, z8.d):java.lang.Object");
    }

    public final void b(@Nullable Throwable th) {
        a0 a0Var = (a0) f26816a.getAndSet(this, null);
        if (a0Var == null) {
            return;
        }
        if (th != null) {
            a0Var.c(th);
        } else {
            a0Var.complete();
        }
    }

    public final void c() {
        a0 a0Var = (a0) f26816a.getAndSet(this, null);
        if (a0Var != null) {
            a0Var.complete();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(@org.jetbrains.annotations.NotNull h9.a<java.lang.Boolean> r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.utils.io.internal.a.C0576a
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.utils.io.internal.a$a r0 = (io.ktor.utils.io.internal.a.C0576a) r0
            int r1 = r0.f26820m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26820m = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.a$a r0 = new io.ktor.utils.io.internal.a$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f26818k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26820m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f26817j
            io.ktor.utils.io.internal.a r5 = (io.ktor.utils.io.internal.a) r5
            v8.u.b(r6)
            goto L44
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            v8.u.b(r6)
            r0.f26817j = r4
            r0.f26820m = r3
            java.lang.Object r6 = r4.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            r5 = r4
        L44:
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L4f
            v8.k0 r5 = v8.k0.f35197a
            return r5
        L4f:
            r5.c()
            v8.k0 r5 = v8.k0.f35197a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.a.d(h9.a, z8.d):java.lang.Object");
    }
}
