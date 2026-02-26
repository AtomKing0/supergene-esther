package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class d {

    @StabilityInferred(parameters = 0)
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f21356a = new a();

        public a() {
            super(null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f21357a = new b();

        public b() {
            super(null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f21358a = new c();

        public c() {
            super(null);
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.d$d, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0464d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l f21359a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0464d(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l error) {
            super(null);
            t.i(error, "error");
            this.f21359a = error;
        }

        @NotNull
        public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.l a() {
            return this.f21359a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof C0464d) && this.f21359a == ((C0464d) obj).f21359a;
        }

        public int hashCode() {
            return this.f21359a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Error(error=" + this.f21359a + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final e f21360a = new e();

        public e() {
            super(null);
        }
    }

    public /* synthetic */ d(kotlin.jvm.internal.k kVar) {
        this();
    }

    public d() {
    }
}
