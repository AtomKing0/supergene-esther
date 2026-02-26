package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;
import v8.c0;

/* JADX INFO: loaded from: classes4.dex */
public interface d {

    @StabilityInferred(parameters = 0)
    public static abstract class a {

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d$a$a, reason: collision with other inner class name */
        @StabilityInferred(parameters = 0)
        public static final class C0463a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C0463a f21255a = new C0463a();

            public C0463a() {
                super(null);
            }
        }

        @StabilityInferred(parameters = 0)
        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f21256a;

            public /* synthetic */ b(int i10, kotlin.jvm.internal.k kVar) {
                this(i10);
            }

            public final int a() {
                return this.f21256a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && this.f21256a == ((b) obj).f21256a;
            }

            public int hashCode() {
                return c0.e(this.f21256a);
            }

            @NotNull
            public String toString() {
                return "Countdown(seconds=" + ((Object) c0.f(this.f21256a)) + ')';
            }

            public b(int i10) {
                super(null);
                this.f21256a = i10;
            }
        }

        @StabilityInferred(parameters = 0)
        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f21257a = new c();

            public c() {
                super(null);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    @NotNull
    m0<a> l();
}
