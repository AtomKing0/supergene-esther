package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class m8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final pp f13200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final hi f13201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final n6 f13202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final jl f13203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final t3 f13204e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final dt f13205f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final c1 f13206g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private pp f13207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private hi f13208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private n6 f13209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        private jl f13210d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        private t3 f13211e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private dt f13212f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private c1 f13213g;

        public a() {
            this(null, null, null, null, null, null, null, 127, null);
        }

        @NotNull
        public final a a(@Nullable c1 c1Var) {
            this.f13213g = c1Var;
            return this;
        }

        @NotNull
        public final a b(@Nullable dt dtVar) {
            this.f13212f = dtVar;
            return this;
        }

        @Nullable
        public final hi c() {
            return this.f13208b;
        }

        @Nullable
        public final n6 d() {
            return this.f13209c;
        }

        @Nullable
        public final jl e() {
            return this.f13210d;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.d(this.f13207a, aVar.f13207a) && kotlin.jvm.internal.t.d(this.f13208b, aVar.f13208b) && kotlin.jvm.internal.t.d(this.f13209c, aVar.f13209c) && kotlin.jvm.internal.t.d(this.f13210d, aVar.f13210d) && kotlin.jvm.internal.t.d(this.f13211e, aVar.f13211e) && kotlin.jvm.internal.t.d(this.f13212f, aVar.f13212f) && kotlin.jvm.internal.t.d(this.f13213g, aVar.f13213g);
        }

        @Nullable
        public final t3 f() {
            return this.f13211e;
        }

        @Nullable
        public final dt g() {
            return this.f13212f;
        }

        @Nullable
        public final c1 h() {
            return this.f13213g;
        }

        public int hashCode() {
            pp ppVar = this.f13207a;
            int iHashCode = (ppVar == null ? 0 : ppVar.hashCode()) * 31;
            hi hiVar = this.f13208b;
            int iHashCode2 = (iHashCode + (hiVar == null ? 0 : hiVar.hashCode())) * 31;
            n6 n6Var = this.f13209c;
            int iHashCode3 = (iHashCode2 + (n6Var == null ? 0 : n6Var.hashCode())) * 31;
            jl jlVar = this.f13210d;
            int iHashCode4 = (iHashCode3 + (jlVar == null ? 0 : jlVar.hashCode())) * 31;
            t3 t3Var = this.f13211e;
            int iHashCode5 = (iHashCode4 + (t3Var == null ? 0 : t3Var.hashCode())) * 31;
            dt dtVar = this.f13212f;
            int iHashCode6 = (iHashCode5 + (dtVar == null ? 0 : dtVar.hashCode())) * 31;
            c1 c1Var = this.f13213g;
            return iHashCode6 + (c1Var != null ? c1Var.hashCode() : 0);
        }

        @Nullable
        public final c1 i() {
            return this.f13213g;
        }

        @Nullable
        public final t3 j() {
            return this.f13211e;
        }

        @Nullable
        public final n6 k() {
            return this.f13209c;
        }

        @Nullable
        public final hi l() {
            return this.f13208b;
        }

        @Nullable
        public final jl m() {
            return this.f13210d;
        }

        @Nullable
        public final pp n() {
            return this.f13207a;
        }

        @Nullable
        public final dt o() {
            return this.f13212f;
        }

        @NotNull
        public String toString() {
            return "Builder(rewardedVideoConfigurations=" + this.f13207a + ", interstitialConfigurations=" + this.f13208b + ", bannerConfigurations=" + this.f13209c + ", nativeAdConfigurations=" + this.f13210d + ", applicationConfigurations=" + this.f13211e + ", testSuiteSettings=" + this.f13212f + ", adQualityConfigurations=" + this.f13213g + ')';
        }

        public a(@Nullable pp ppVar, @Nullable hi hiVar, @Nullable n6 n6Var, @Nullable jl jlVar, @Nullable t3 t3Var, @Nullable dt dtVar, @Nullable c1 c1Var) {
            this.f13207a = ppVar;
            this.f13208b = hiVar;
            this.f13209c = n6Var;
            this.f13210d = jlVar;
            this.f13211e = t3Var;
            this.f13212f = dtVar;
            this.f13213g = c1Var;
        }

        @NotNull
        public final a a(@Nullable hi hiVar) {
            this.f13208b = hiVar;
            return this;
        }

        @Nullable
        public final pp b() {
            return this.f13207a;
        }

        public /* synthetic */ a(pp ppVar, hi hiVar, n6 n6Var, jl jlVar, t3 t3Var, dt dtVar, c1 c1Var, int i10, kotlin.jvm.internal.k kVar) {
            this((i10 & 1) != 0 ? null : ppVar, (i10 & 2) != 0 ? null : hiVar, (i10 & 4) != 0 ? null : n6Var, (i10 & 8) != 0 ? null : jlVar, (i10 & 16) != 0 ? null : t3Var, (i10 & 32) != 0 ? null : dtVar, (i10 & 64) != 0 ? null : c1Var);
        }

        @NotNull
        public final a a(@Nullable jl jlVar) {
            this.f13210d = jlVar;
            return this;
        }

        public final void b(@Nullable c1 c1Var) {
            this.f13213g = c1Var;
        }

        public static /* synthetic */ a a(a aVar, pp ppVar, hi hiVar, n6 n6Var, jl jlVar, t3 t3Var, dt dtVar, c1 c1Var, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                ppVar = aVar.f13207a;
            }
            if ((i10 & 2) != 0) {
                hiVar = aVar.f13208b;
            }
            hi hiVar2 = hiVar;
            if ((i10 & 4) != 0) {
                n6Var = aVar.f13209c;
            }
            n6 n6Var2 = n6Var;
            if ((i10 & 8) != 0) {
                jlVar = aVar.f13210d;
            }
            jl jlVar2 = jlVar;
            if ((i10 & 16) != 0) {
                t3Var = aVar.f13211e;
            }
            t3 t3Var2 = t3Var;
            if ((i10 & 32) != 0) {
                dtVar = aVar.f13212f;
            }
            dt dtVar2 = dtVar;
            if ((i10 & 64) != 0) {
                c1Var = aVar.f13213g;
            }
            return aVar.a(ppVar, hiVar2, n6Var2, jlVar2, t3Var2, dtVar2, c1Var);
        }

        public final void b(@Nullable hi hiVar) {
            this.f13208b = hiVar;
        }

        @NotNull
        public final a a(@Nullable n6 n6Var) {
            this.f13209c = n6Var;
            return this;
        }

        public final void b(@Nullable jl jlVar) {
            this.f13210d = jlVar;
        }

        @NotNull
        public final a a(@Nullable pp ppVar) {
            this.f13207a = ppVar;
            return this;
        }

        public final void b(@Nullable n6 n6Var) {
            this.f13209c = n6Var;
        }

        @NotNull
        public final a a(@Nullable pp ppVar, @Nullable hi hiVar, @Nullable n6 n6Var, @Nullable jl jlVar, @Nullable t3 t3Var, @Nullable dt dtVar, @Nullable c1 c1Var) {
            return new a(ppVar, hiVar, n6Var, jlVar, t3Var, dtVar, c1Var);
        }

        public final void b(@Nullable pp ppVar) {
            this.f13207a = ppVar;
        }

        @NotNull
        public final a a(@Nullable t3 t3Var) {
            this.f13211e = t3Var;
            return this;
        }

        public final void b(@Nullable t3 t3Var) {
            this.f13211e = t3Var;
        }

        @NotNull
        public final m8 a() {
            return new m8(this.f13207a, this.f13208b, this.f13209c, this.f13210d, this.f13211e, this.f13212f, this.f13213g, null);
        }

        public final void a(@Nullable dt dtVar) {
            this.f13212f = dtVar;
        }
    }

    private m8(pp ppVar, hi hiVar, n6 n6Var, jl jlVar, t3 t3Var, dt dtVar, c1 c1Var) {
        this.f13200a = ppVar;
        this.f13201b = hiVar;
        this.f13202c = n6Var;
        this.f13203d = jlVar;
        this.f13204e = t3Var;
        this.f13205f = dtVar;
        this.f13206g = c1Var;
    }

    @Nullable
    public final c1 a() {
        return this.f13206g;
    }

    @Nullable
    public final t3 b() {
        return this.f13204e;
    }

    @Nullable
    public final n6 c() {
        return this.f13202c;
    }

    @Nullable
    public final hi d() {
        return this.f13201b;
    }

    @Nullable
    public final jl e() {
        return this.f13203d;
    }

    @Nullable
    public final pp f() {
        return this.f13200a;
    }

    @Nullable
    public final dt g() {
        return this.f13205f;
    }

    @NotNull
    public String toString() {
        return "configurations(\n" + this.f13200a + '\n' + this.f13201b + '\n' + this.f13202c + '\n' + this.f13203d + ')';
    }

    public /* synthetic */ m8(pp ppVar, hi hiVar, n6 n6Var, jl jlVar, t3 t3Var, dt dtVar, c1 c1Var, kotlin.jvm.internal.k kVar) {
        this(ppVar, hiVar, n6Var, jlVar, t3Var, dtVar, c1Var);
    }
}
