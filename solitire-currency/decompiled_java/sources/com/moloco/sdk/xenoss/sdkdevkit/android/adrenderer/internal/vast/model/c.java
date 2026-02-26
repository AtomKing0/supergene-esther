package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class c {

    @StabilityInferred(parameters = 0)
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final q f20608a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull q inline) {
            super(null);
            kotlin.jvm.internal.t.i(inline, "inline");
            this.f20608a = inline;
        }

        @NotNull
        public final q a() {
            return this.f20608a;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final d f20609a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull d wrapper) {
            super(null);
            kotlin.jvm.internal.t.i(wrapper, "wrapper");
            this.f20609a = wrapper;
        }

        @NotNull
        public final d a() {
            return this.f20609a;
        }
    }

    public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
        this();
    }

    public c() {
    }
}
