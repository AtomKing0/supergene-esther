package com.ironsource;

import com.ironsource.wd;
import java.util.LinkedHashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class cs implements wd, wd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k9 f11709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final og f11710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<String, zr> f11711c;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f11712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f11713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private Long f11714c;

        public a(int i10, long j10, @Nullable Long l10) {
            this.f11712a = i10;
            this.f11713b = j10;
            this.f11714c = l10;
        }

        public final int a() {
            return this.f11712a;
        }

        public final long b() {
            return this.f11713b;
        }

        @Nullable
        public final Long c() {
            return this.f11714c;
        }

        public final int d() {
            return this.f11712a;
        }

        public final long e() {
            return this.f11713b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f11712a == aVar.f11712a && this.f11713b == aVar.f11713b && kotlin.jvm.internal.t.d(this.f11714c, aVar.f11714c);
        }

        @Nullable
        public final Long f() {
            return this.f11714c;
        }

        public int hashCode() {
            int iA = ((this.f11712a * 31) + androidx.compose.animation.a.a(this.f11713b)) * 31;
            Long l10 = this.f11714c;
            return iA + (l10 == null ? 0 : l10.hashCode());
        }

        @NotNull
        public String toString() {
            return "ShowCountCappingInfo(currentNumberOfShows=" + this.f11712a + ", currentTime=" + this.f11713b + ", currentTimeThreshold=" + this.f11714c + ')';
        }

        @NotNull
        public final a a(int i10, long j10, @Nullable Long l10) {
            return new a(i10, j10, l10);
        }

        public static /* synthetic */ a a(a aVar, int i10, long j10, Long l10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i10 = aVar.f11712a;
            }
            if ((i11 & 2) != 0) {
                j10 = aVar.f11713b;
            }
            if ((i11 & 4) != 0) {
                l10 = aVar.f11714c;
            }
            return aVar.a(i10, j10, l10);
        }

        public final void a(int i10) {
            this.f11712a = i10;
        }

        public final void a(long j10) {
            this.f11713b = j10;
        }

        public final void a(@Nullable Long l10) {
            this.f11714c = l10;
        }
    }

    public cs(@NotNull k9 currentTimeProvider, @NotNull og serviceDataRepository) {
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        kotlin.jvm.internal.t.i(serviceDataRepository, "serviceDataRepository");
        this.f11709a = currentTimeProvider;
        this.f11710b = serviceDataRepository;
        this.f11711c = new LinkedHashMap();
    }

    private final a c(String str) {
        return new a(this.f11710b.a(str), this.f11709a.a(), this.f11710b.b(str));
    }

    @Override // com.ironsource.wd
    @NotNull
    public f8 a(@NotNull String identifier) {
        kotlin.jvm.internal.t.i(identifier, "identifier");
        zr zrVar = this.f11711c.get(identifier);
        if (zrVar != null && a(zrVar, identifier)) {
            return new f8(true, h8.ShowCount);
        }
        return new f8(false, null, 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    @Override // com.ironsource.wd.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(@org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "identifier"
            kotlin.jvm.internal.t.i(r9, r0)
            java.util.Map<java.lang.String, com.ironsource.zr> r0 = r8.f11711c
            java.lang.Object r0 = r0.get(r9)
            com.ironsource.zr r0 = (com.ironsource.zr) r0
            if (r0 != 0) goto L10
            return
        L10:
            com.ironsource.cs$a r1 = r8.c(r9)
            int r2 = r1.d()
            r3 = 1
            if (r2 == 0) goto L30
            long r4 = r1.e()
            java.lang.Long r2 = r1.f()
            if (r2 == 0) goto L2a
            long r6 = r2.longValue()
            goto L2c
        L2a:
            r6 = 0
        L2c:
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 < 0) goto L47
        L30:
            long r4 = r1.e()
            com.ironsource.g8 r0 = r0.b()
            r2 = 0
            long r6 = com.ironsource.g8.a(r0, r2, r3, r2)
            long r4 = r4 + r6
            com.ironsource.og r0 = r8.f11710b
            r0.a(r4, r9)
            r0 = 0
            r1.a(r0)
        L47:
            int r0 = r1.d()
            int r0 = r0 + r3
            r1.a(r0)
            com.ironsource.og r0 = r8.f11710b
            int r1 = r1.d()
            r0.a(r1, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.cs.b(java.lang.String):void");
    }

    @Override // com.ironsource.wd.a
    @NotNull
    public Object a(@NotNull String identifier, @NotNull h8 cappingType, @NotNull ud cappingConfig) {
        Object objA;
        kotlin.jvm.internal.t.i(identifier, "identifier");
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        kotlin.jvm.internal.t.i(cappingConfig, "cappingConfig");
        Object objC = cappingConfig.c();
        if (!v8.t.h(objC)) {
            Throwable thE = v8.t.e(objC);
            if (thE != null) {
                objA = v8.u.a(thE);
            }
            return v8.t.b(objA);
        }
        zr zrVar = (zr) objC;
        if (zrVar != null) {
            this.f11711c.put(identifier, zrVar);
        }
        objA = v8.k0.f35197a;
        return v8.t.b(objA);
    }

    @NotNull
    public final Map<String, zr> a() {
        return this.f11711c;
    }

    private final boolean a(zr zrVar, String str) {
        a aVarC = c(str);
        Long lF = aVarC.f();
        if (lF != null) {
            return aVarC.d() >= zrVar.a() && this.f11709a.a() < lF.longValue();
        }
        return false;
    }
}
