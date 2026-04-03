package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ColorFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class ColorFilter {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final android.graphics.ColorFilter nativeColorFilter;

    /* JADX INFO: compiled from: ColorFilter.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: renamed from: tint-xETnrds$default, reason: not valid java name */
        public static /* synthetic */ ColorFilter m1639tintxETnrds$default(Companion companion, long j10, int i10, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                i10 = BlendMode.Companion.m1546getSrcIn0nO6VwU();
            }
            return companion.m1642tintxETnrds(j10, i10);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: colorMatrix-jHG-Opc, reason: not valid java name */
        public final ColorFilter m1640colorMatrixjHGOpc(@NotNull float[] colorMatrix) {
            kotlin.jvm.internal.t.i(colorMatrix, "colorMatrix");
            return AndroidColorFilter_androidKt.m1473actualColorMatrixColorFilterjHGOpc(colorMatrix);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: lighting--OWjLjI, reason: not valid java name */
        public final ColorFilter m1641lightingOWjLjI(long j10, long j11) {
            return AndroidColorFilter_androidKt.m1474actualLightingColorFilterOWjLjI(j10, j11);
        }

        @Stable
        @NotNull
        /* JADX INFO: renamed from: tint-xETnrds, reason: not valid java name */
        public final ColorFilter m1642tintxETnrds(long j10, int i10) {
            return AndroidColorFilter_androidKt.m1475actualTintColorFilterxETnrds(j10, i10);
        }
    }

    public ColorFilter(@NotNull android.graphics.ColorFilter nativeColorFilter) {
        kotlin.jvm.internal.t.i(nativeColorFilter, "nativeColorFilter");
        this.nativeColorFilter = nativeColorFilter;
    }

    @NotNull
    public final android.graphics.ColorFilter getNativeColorFilter$ui_graphics_release() {
        return this.nativeColorFilter;
    }
}
