package com.moloco.sdk.internal.services;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class b {

    @StabilityInferred(parameters = 0)
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f18412a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String carrier) {
            super(null);
            kotlin.jvm.internal.t.i(carrier, "carrier");
            this.f18412a = carrier;
        }

        @NotNull
        public final String a() {
            return this.f18412a;
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.internal.services.b$b, reason: collision with other inner class name */
    @StabilityInferred(parameters = 0)
    public static final class C0326b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final C0326b f18413a = new C0326b();

        public C0326b() {
            super(null);
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f18414a = new c();

        public c() {
            super(null);
        }
    }

    public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
        this();
    }

    public b() {
    }
}
