package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.m0;

/* JADX INFO: loaded from: classes4.dex */
public interface i extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui.h {

    @StabilityInferred(parameters = 0)
    public static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20823a;

        /* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i$a$a, reason: collision with other inner class name */
        @StabilityInferred(parameters = 0)
        public static final class C0434a extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h f20824b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f20825c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0434a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h viewModel, boolean z10) {
                super(z10, null);
                t.i(viewModel, "viewModel");
                this.f20824b = viewModel;
                this.f20825c = z10;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.f20825c;
            }

            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.companion.h b() {
                return this.f20824b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0434a)) {
                    return false;
                }
                C0434a c0434a = (C0434a) obj;
                return t.d(this.f20824b, c0434a.f20824b) && this.f20825c == c0434a.f20825c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.f20824b.hashCode() * 31;
                boolean z10 = this.f20825c;
                ?? r12 = z10;
                if (z10) {
                    r12 = 1;
                }
                return iHashCode + r12;
            }

            @NotNull
            public String toString() {
                return "Companion(viewModel=" + this.f20824b + ", isLastAdPart=" + this.f20825c + ')';
            }
        }

        @StabilityInferred(parameters = 0)
        public static final class b extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e f20826b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f20827c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e viewModel, boolean z10) {
                super(z10, null);
                t.i(viewModel, "viewModel");
                this.f20826b = viewModel;
                this.f20827c = z10;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.f20827c;
            }

            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.dec.e b() {
                return this.f20826b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return t.d(this.f20826b, bVar.f20826b) && this.f20827c == bVar.f20827c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.f20826b.hashCode() * 31;
                boolean z10 = this.f20827c;
                ?? r12 = z10;
                if (z10) {
                    r12 = 1;
                }
                return iHashCode + r12;
            }

            @NotNull
            public String toString() {
                return "DEC(viewModel=" + this.f20826b + ", isLastAdPart=" + this.f20827c + ')';
            }
        }

        @StabilityInferred(parameters = 0)
        public static final class c extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k f20828b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f20829c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k viewModel, boolean z10) {
                super(z10, null);
                t.i(viewModel, "viewModel");
                this.f20828b = viewModel;
                this.f20829c = z10;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.f20829c;
            }

            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear.k b() {
                return this.f20828b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof c)) {
                    return false;
                }
                c cVar = (c) obj;
                return t.d(this.f20828b, cVar.f20828b) && this.f20829c == cVar.f20829c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.f20828b.hashCode() * 31;
                boolean z10 = this.f20829c;
                ?? r12 = z10;
                if (z10) {
                    r12 = 1;
                }
                return iHashCode + r12;
            }

            @NotNull
            public String toString() {
                return "Linear(viewModel=" + this.f20828b + ", isLastAdPart=" + this.f20829c + ')';
            }
        }

        @StabilityInferred(parameters = 0)
        public static final class d extends a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i f20830b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final boolean f20831c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.i viewModel, boolean z10) {
                super(z10, null);
                t.i(viewModel, "viewModel");
                this.f20830b = viewModel;
                this.f20831c = z10;
            }

            @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.ad.i.a
            public boolean a() {
                return this.f20831c;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof d)) {
                    return false;
                }
                d dVar = (d) obj;
                return t.d(this.f20830b, dVar.f20830b) && this.f20831c == dVar.f20831c;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iHashCode = this.f20830b.hashCode() * 31;
                boolean z10 = this.f20831c;
                ?? r12 = z10;
                if (z10) {
                    r12 = 1;
                }
                return iHashCode + r12;
            }

            @NotNull
            public String toString() {
                return "Mraid(viewModel=" + this.f20830b + ", isLastAdPart=" + this.f20831c + ')';
            }
        }

        public /* synthetic */ a(boolean z10, kotlin.jvm.internal.k kVar) {
            this(z10);
        }

        public boolean a() {
            return this.f20823a;
        }

        public a(boolean z10) {
            this.f20823a = z10;
        }
    }

    void A();

    void B();

    @NotNull
    m0<a> j();

    @NotNull
    m0<Boolean> n();

    void y();
}
