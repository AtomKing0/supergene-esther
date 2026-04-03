package com.moloco.sdk.acm.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@Dao
public interface d {

    public static final class a {

        /* JADX INFO: renamed from: com.moloco.sdk.acm.db.d$a$a, reason: collision with other inner class name */
        @kotlin.coroutines.jvm.internal.f(c = "com.moloco.sdk.acm.db.MetricsDAO$DefaultImpls", f = "MetricsDAO.kt", l = {58, 62}, m = "deleteAndReturnDeletedEvents")
        public static final class C0288a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public Object f17336j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public Object f17337k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public Object f17338l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public /* synthetic */ Object f17339m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f17340n;

            public C0288a(z8.d<? super C0288a> dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f17339m = obj;
                this.f17340n |= Integer.MIN_VALUE;
                return a.a(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00a3 -> B:32:0x00a5). Please report as a decompilation issue!!! */
        @androidx.room.Transaction
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static java.lang.Object a(@org.jetbrains.annotations.NotNull com.moloco.sdk.acm.db.d r9, @org.jetbrains.annotations.NotNull z8.d<? super java.util.List<com.moloco.sdk.acm.db.b>> r10) {
            /*
                boolean r0 = r10 instanceof com.moloco.sdk.acm.db.d.a.C0288a
                if (r0 == 0) goto L13
                r0 = r10
                com.moloco.sdk.acm.db.d$a$a r0 = (com.moloco.sdk.acm.db.d.a.C0288a) r0
                int r1 = r0.f17340n
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f17340n = r1
                goto L18
            L13:
                com.moloco.sdk.acm.db.d$a$a r0 = new com.moloco.sdk.acm.db.d$a$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f17339m
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f17340n
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L49
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r9 = r0.f17336j
                java.util.List r9 = (java.util.List) r9
                v8.u.b(r10)
                goto L6c
            L30:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L38:
                java.lang.Object r9 = r0.f17338l
                java.util.List r9 = (java.util.List) r9
                java.lang.Object r2 = r0.f17337k
                java.util.List r2 = (java.util.List) r2
                java.lang.Object r5 = r0.f17336j
                com.moloco.sdk.acm.db.d r5 = (com.moloco.sdk.acm.db.d) r5
                v8.u.b(r10)
                r10 = r2
                goto La5
            L49:
                v8.u.b(r10)
                java.util.ArrayList r10 = new java.util.ArrayList
                r10.<init>()
            L51:
                java.util.List r2 = r9.b()
                boolean r5 = r2.isEmpty()
                if (r5 == 0) goto L6d
                r0.f17336j = r10
                r2 = 0
                r0.f17337k = r2
                r0.f17338l = r2
                r0.f17340n = r3
                java.lang.Object r9 = r9.d(r0)
                if (r9 != r1) goto L6b
                return r1
            L6b:
                r9 = r10
            L6c:
                return r9
            L6d:
                java.util.ArrayList r5 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.t.v(r2, r6)
                r5.<init>(r6)
                java.util.Iterator r6 = r2.iterator()
            L7c:
                boolean r7 = r6.hasNext()
                if (r7 == 0) goto L94
                java.lang.Object r7 = r6.next()
                com.moloco.sdk.acm.db.b r7 = (com.moloco.sdk.acm.db.b) r7
                long r7 = r7.c()
                java.lang.Long r7 = kotlin.coroutines.jvm.internal.b.e(r7)
                r5.add(r7)
                goto L7c
            L94:
                r0.f17336j = r9
                r0.f17337k = r10
                r0.f17338l = r2
                r0.f17340n = r4
                java.lang.Object r5 = r9.c(r5, r0)
                if (r5 != r1) goto La3
                return r1
            La3:
                r5 = r9
                r9 = r2
            La5:
                r10.addAll(r9)
                r9 = r5
                goto L51
            */
            throw new UnsupportedOperationException("Method not decompiled: com.moloco.sdk.acm.db.d.a.a(com.moloco.sdk.acm.db.d, z8.d):java.lang.Object");
        }
    }

    @Transaction
    @Nullable
    Object a(@NotNull z8.d<? super List<b>> dVar);

    @Insert(onConflict = 1)
    long b(@NotNull b bVar);

    @Query("SELECT * FROM events LIMIT 900")
    @NotNull
    List<b> b();

    @Query("DELETE FROM events WHERE id IN (:ids)")
    @Nullable
    Object c(@NotNull List<Long> list, @NotNull z8.d<? super k0> dVar);

    @Query("DELETE FROM sqlite_sequence WHERE name='events'")
    @Nullable
    Object d(@NotNull z8.d<? super k0> dVar);
}
