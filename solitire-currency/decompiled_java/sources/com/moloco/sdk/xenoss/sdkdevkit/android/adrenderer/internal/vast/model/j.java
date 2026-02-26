package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class j {

    @StabilityInferred(parameters = 0)
    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final List<g> f20636a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull List<g> companions) {
            super(null);
            kotlin.jvm.internal.t.i(companions, "companions");
            this.f20636a = companions;
        }

        @NotNull
        public final List<g> a() {
            return this.f20636a;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final r f20637a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull r linear) {
            super(null);
            kotlin.jvm.internal.t.i(linear, "linear");
            this.f20637a = linear;
        }

        @NotNull
        public final r a() {
            return this.f20637a;
        }
    }

    public /* synthetic */ j(kotlin.jvm.internal.k kVar) {
        this();
    }

    public j() {
    }
}
