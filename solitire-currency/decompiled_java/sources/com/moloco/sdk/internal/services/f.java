package com.moloco.sdk.internal.services;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class f {

    @StabilityInferred(parameters = 0)
    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f18673a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull String id) {
            super(null);
            kotlin.jvm.internal.t.i(id, "id");
            this.f18673a = id;
        }

        @NotNull
        public final String a() {
            return this.f18673a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && kotlin.jvm.internal.t.d(this.f18673a, ((a) obj).f18673a);
        }

        public int hashCode() {
            return this.f18673a.hashCode();
        }

        @NotNull
        public String toString() {
            return "Available(id=" + this.f18673a + ')';
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f18674a = new b();

        public b() {
            super(null);
        }
    }

    public /* synthetic */ f(kotlin.jvm.internal.k kVar) {
        this();
    }

    public f() {
    }
}
