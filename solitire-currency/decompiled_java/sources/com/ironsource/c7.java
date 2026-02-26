package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c7 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11533c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b f11534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c6 f11535b;

    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.c7$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0253a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11536a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.TIMED_LOAD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[c.TIMED_SHOW.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f11536a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final c7 a(@NotNull k1 adTools, @NotNull p6 bannerContainer, @NotNull b config, @NotNull c6 bannerAdProperties, @NotNull d7 bannerStrategyListener, @NotNull g6 createBannerAdUnitFactory) {
            kotlin.jvm.internal.t.i(adTools, "adTools");
            kotlin.jvm.internal.t.i(bannerContainer, "bannerContainer");
            kotlin.jvm.internal.t.i(config, "config");
            kotlin.jvm.internal.t.i(bannerAdProperties, "bannerAdProperties");
            kotlin.jvm.internal.t.i(bannerStrategyListener, "bannerStrategyListener");
            kotlin.jvm.internal.t.i(createBannerAdUnitFactory, "createBannerAdUnitFactory");
            int i10 = C0253a.f11536a[config.e().ordinal()];
            if (i10 == 1) {
                return new kt(adTools, bannerContainer, config, bannerAdProperties, bannerStrategyListener, createBannerAdUnitFactory);
            }
            if (i10 == 2) {
                return new lt(adTools, bannerContainer, config, bannerAdProperties, bannerStrategyListener, createBannerAdUnitFactory);
            }
            throw new v8.q();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c f11537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f11538b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f11539c;

        public b(@NotNull c strategyType, long j10, boolean z10) {
            kotlin.jvm.internal.t.i(strategyType, "strategyType");
            this.f11537a = strategyType;
            this.f11538b = j10;
            this.f11539c = z10;
        }

        public static /* synthetic */ b a(b bVar, c cVar, long j10, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                cVar = bVar.f11537a;
            }
            if ((i10 & 2) != 0) {
                j10 = bVar.f11538b;
            }
            if ((i10 & 4) != 0) {
                z10 = bVar.f11539c;
            }
            return bVar.a(cVar, j10, z10);
        }

        public final long b() {
            return this.f11538b;
        }

        public final boolean c() {
            return this.f11539c;
        }

        public final long d() {
            return this.f11538b;
        }

        @NotNull
        public final c e() {
            return this.f11537a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f11537a == bVar.f11537a && this.f11538b == bVar.f11538b && this.f11539c == bVar.f11539c;
        }

        public final boolean f() {
            return this.f11539c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v5 */
        public int hashCode() {
            int iHashCode = ((this.f11537a.hashCode() * 31) + androidx.compose.animation.a.a(this.f11538b)) * 31;
            boolean z10 = this.f11539c;
            ?? r12 = z10;
            if (z10) {
                r12 = 1;
            }
            return iHashCode + r12;
        }

        @NotNull
        public String toString() {
            return "Config(strategyType=" + this.f11537a + ", refreshInterval=" + this.f11538b + ", isAutoRefreshEnabled=" + this.f11539c + ')';
        }

        @NotNull
        public final b a(@NotNull c strategyType, long j10, boolean z10) {
            kotlin.jvm.internal.t.i(strategyType, "strategyType");
            return new b(strategyType, j10, z10);
        }

        @NotNull
        public final c a() {
            return this.f11537a;
        }
    }

    public enum c {
        TIMED_LOAD,
        TIMED_SHOW
    }

    public c7(@NotNull b config, @NotNull c6 bannerAdProperties) {
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(bannerAdProperties, "bannerAdProperties");
        this.f11534a = config;
        this.f11535b = bannerAdProperties;
    }

    public abstract void a();

    protected final long b() {
        Long lI = this.f11535b.i();
        return lI != null ? lI.longValue() : this.f11534a.d();
    }

    protected final boolean c() {
        Boolean boolH = this.f11535b.h();
        return boolH != null ? boolH.booleanValue() : this.f11534a.f();
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();
}
