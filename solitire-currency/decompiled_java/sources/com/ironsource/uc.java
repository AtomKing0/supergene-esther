package com.ironsource;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class uc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final a f15583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b1 f15584b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final c f15585a;

        public a(@NotNull c strategyType) {
            kotlin.jvm.internal.t.i(strategyType, "strategyType");
            this.f15585a = strategyType;
        }

        public static /* synthetic */ a a(a aVar, c cVar, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                cVar = aVar.f15585a;
            }
            return aVar.a(cVar);
        }

        @NotNull
        public final c b() {
            return this.f15585a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f15585a == ((a) obj).f15585a;
        }

        public int hashCode() {
            return this.f15585a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Config(strategyType=" + this.f15585a + ')';
        }

        @NotNull
        public final a a(@NotNull c strategyType) {
            kotlin.jvm.internal.t.i(strategyType, "strategyType");
            return new a(strategyType);
        }

        @NotNull
        public final c a() {
            return this.f15585a;
        }
    }

    public static final class b {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15586a;

            static {
                int[] iArr = new int[c.values().length];
                try {
                    iArr[c.MANUAL_LOAD.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f15586a = iArr;
            }
        }

        @NotNull
        public final uc a(@NotNull k1 adTools, @NotNull a config, @NotNull b1 adProperties, @NotNull wc fullScreenStrategyListener, @NotNull sc createFullscreenAdUnitFactory) {
            kotlin.jvm.internal.t.i(adTools, "adTools");
            kotlin.jvm.internal.t.i(config, "config");
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            kotlin.jvm.internal.t.i(fullScreenStrategyListener, "fullScreenStrategyListener");
            kotlin.jvm.internal.t.i(createFullscreenAdUnitFactory, "createFullscreenAdUnitFactory");
            if (a.f15586a[config.b().ordinal()] == 1) {
                return new vc(adTools, config, adProperties, fullScreenStrategyListener, createFullscreenAdUnitFactory);
            }
            throw new v8.q();
        }
    }

    public enum c {
        MANUAL_LOAD
    }

    public uc(@NotNull a config, @NotNull b1 adProperties) {
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        this.f15583a = config;
        this.f15584b = adProperties;
    }

    public abstract void a();

    public abstract void a(@NotNull Activity activity);
}
