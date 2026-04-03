package com.moloco.sdk.internal.services.init;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {

    @StabilityInferred(parameters = 0)
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final com.moloco.sdk.internal.services.init.b f18753a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull com.moloco.sdk.internal.services.init.b type) {
            super(null);
            t.i(type, "type");
            this.f18753a = type;
        }

        @NotNull
        public final com.moloco.sdk.internal.services.init.b a() {
            return this.f18753a;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18754a;

        public b(int i10) {
            super(null);
            this.f18754a = i10;
        }

        public final int a() {
            return this.f18754a;
        }
    }

    public /* synthetic */ h(kotlin.jvm.internal.k kVar) {
        this();
    }

    public h() {
    }
}
