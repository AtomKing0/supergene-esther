package com.moloco.sdk.internal.services.usertracker;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final d f18818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final b f18819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final y9.a f18820c;

    @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", l = {48, 33, 36}, m = "getIdentifier")
    public static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Object f18821j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Object f18822k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public /* synthetic */ Object f18823l;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f18825n;

        public a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f18823l = obj;
            this.f18825n |= Integer.MIN_VALUE;
            return f.this.c(this);
        }
    }

    public f(@NotNull d idGenerator, @NotNull b idRepository) {
        t.i(idGenerator, "idGenerator");
        t.i(idRepository, "idRepository");
        this.f18818a = idGenerator;
        this.f18819b = idRepository;
        this.f18820c = y9.c.b(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0089 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:21:0x004c, B:34:0x0085, B:36:0x0089), top: B:47:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.moloco.sdk.internal.services.usertracker.e
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(@org.jetbrains.annotations.NotNull z8.d<? super java.lang.String> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.moloco.sdk.internal.services.usertracker.f.a
            if (r0 == 0) goto L13
            r0 = r9
            com.moloco.sdk.internal.services.usertracker.f$a r0 = (com.moloco.sdk.internal.services.usertracker.f.a) r0
            int r1 = r0.f18825n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18825n = r1
            goto L18
        L13:
            com.moloco.sdk.internal.services.usertracker.f$a r0 = new com.moloco.sdk.internal.services.usertracker.f$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f18823l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f18825n
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L5f
            if (r2 == r5) goto L52
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            java.lang.Object r1 = r0.f18822k
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.f18821j
            y9.a r0 = (y9.a) r0
            v8.u.b(r9)     // Catch: java.lang.Throwable -> L39
            goto La0
        L39:
            r9 = move-exception
            goto La8
        L3c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L44:
            java.lang.Object r2 = r0.f18822k
            y9.a r2 = (y9.a) r2
            java.lang.Object r4 = r0.f18821j
            com.moloco.sdk.internal.services.usertracker.f r4 = (com.moloco.sdk.internal.services.usertracker.f) r4
            v8.u.b(r9)     // Catch: java.lang.Throwable -> L50
            goto L85
        L50:
            r9 = move-exception
            goto La9
        L52:
            java.lang.Object r2 = r0.f18822k
            y9.a r2 = (y9.a) r2
            java.lang.Object r5 = r0.f18821j
            com.moloco.sdk.internal.services.usertracker.f r5 = (com.moloco.sdk.internal.services.usertracker.f) r5
            v8.u.b(r9)
            r9 = r2
            goto L72
        L5f:
            v8.u.b(r9)
            y9.a r9 = r8.f18820c
            r0.f18821j = r8
            r0.f18822k = r9
            r0.f18825n = r5
            java.lang.Object r2 = r9.e(r6, r0)
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r8
        L72:
            com.moloco.sdk.internal.services.usertracker.b r2 = r5.f18819b     // Catch: java.lang.Throwable -> La4
            r0.f18821j = r5     // Catch: java.lang.Throwable -> La4
            r0.f18822k = r9     // Catch: java.lang.Throwable -> La4
            r0.f18825n = r4     // Catch: java.lang.Throwable -> La4
            java.lang.Object r2 = r2.c(r0)     // Catch: java.lang.Throwable -> La4
            if (r2 != r1) goto L81
            return r1
        L81:
            r4 = r5
            r7 = r2
            r2 = r9
            r9 = r7
        L85:
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.lang.Throwable -> L50
            if (r9 != 0) goto L9e
            com.moloco.sdk.internal.services.usertracker.d r9 = r4.f18818a     // Catch: java.lang.Throwable -> L50
            java.lang.String r9 = r9.a()     // Catch: java.lang.Throwable -> L50
            com.moloco.sdk.internal.services.usertracker.b r4 = r4.f18819b     // Catch: java.lang.Throwable -> L50
            r0.f18821j = r2     // Catch: java.lang.Throwable -> L50
            r0.f18822k = r9     // Catch: java.lang.Throwable -> L50
            r0.f18825n = r3     // Catch: java.lang.Throwable -> L50
            java.lang.Object r0 = r4.b(r9, r0)     // Catch: java.lang.Throwable -> L50
            if (r0 != r1) goto L9e
            return r1
        L9e:
            r1 = r9
            r0 = r2
        La0:
            r0.g(r6)
            return r1
        La4:
            r0 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        La8:
            r2 = r0
        La9:
            r2.g(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.internal.services.usertracker.f.c(z8.d):java.lang.Object");
    }
}
