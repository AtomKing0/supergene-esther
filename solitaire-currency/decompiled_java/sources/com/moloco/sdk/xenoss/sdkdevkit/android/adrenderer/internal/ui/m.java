package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public abstract class m {

    @StabilityInferred(parameters = 0)
    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f19891a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19892b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19893c;

        public /* synthetic */ a(boolean z10, int i10, int i11, kotlin.jvm.internal.k kVar) {
            this(z10, i10, i11);
        }

        public final int a() {
            return this.f19893c;
        }

        public final boolean b() {
            return this.f19891a;
        }

        public final int c() {
            return this.f19892b;
        }

        public a(boolean z10, int i10, int i11) {
            super(null);
            this.f19891a = z10;
            this.f19892b = i10;
            this.f19893c = i11;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final Painter f19894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final String f19895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f19896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final Shape f19897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f19898e;

        public /* synthetic */ b(Painter painter, String str, long j10, Shape shape, long j11, kotlin.jvm.internal.k kVar) {
            this(painter, str, j10, shape, j11);
        }

        public final long a() {
            return this.f19898e;
        }

        @NotNull
        public final Shape b() {
            return this.f19897d;
        }

        @Nullable
        public final String c() {
            return this.f19895b;
        }

        public final long d() {
            return this.f19896c;
        }

        @NotNull
        public final Painter e() {
            return this.f19894a;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Painter painter, String str, long j10, Shape backgroundShape, long j11) {
            super(null);
            kotlin.jvm.internal.t.i(painter, "painter");
            kotlin.jvm.internal.t.i(backgroundShape, "backgroundShape");
            this.f19894a = painter;
            this.f19895b = str;
            this.f19896c = j10;
            this.f19897d = backgroundShape;
            this.f19898e = j11;
        }
    }

    @StabilityInferred(parameters = 0)
    public static final class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final String f19899a;

        @NotNull
        public final String a() {
            return this.f19899a;
        }
    }

    public /* synthetic */ m(kotlin.jvm.internal.k kVar) {
        this();
    }

    public m() {
    }
}
