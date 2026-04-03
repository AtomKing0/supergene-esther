package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class i {

    @StabilityInferred(parameters = 0)
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21314a;

        public a(long j10) {
            super(null);
            this.f21314a = j10;
        }

        public final long a() {
            return this.f21314a;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f21315a = new b();

        public b() {
            super(null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21316a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f21317b;

        public c(long j10, long j11) {
            super(null);
            this.f21316a = j10;
            this.f21317b = j11;
        }

        public final long a() {
            return this.f21316a;
        }

        public final long b() {
            return this.f21317b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f21316a == cVar.f21316a && this.f21317b == cVar.f21317b;
        }

        public int hashCode() {
            return (androidx.compose.animation.a.a(this.f21316a) * 31) + androidx.compose.animation.a.a(this.f21317b);
        }

        @NotNull
        public String toString() {
            return "Position(currentPositionMillis=" + this.f21316a + ", totalDurationMillis=" + this.f21317b + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f21318a;

        public d(long j10) {
            super(null);
            this.f21318a = j10;
        }

        public final long a() {
            return this.f21318a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof d) && this.f21318a == ((d) obj).f21318a;
        }

        public int hashCode() {
            return androidx.compose.animation.a.a(this.f21318a);
        }

        @NotNull
        public String toString() {
            return "Preparing(totalDurationMillis=" + this.f21318a + ')';
        }
    }

    public /* synthetic */ i(kotlin.jvm.internal.k kVar) {
        this();
    }

    public i() {
    }
}
