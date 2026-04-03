package androidx.compose.ui.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Size;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ContentScale.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public interface ContentScale {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA, reason: not valid java name */
    long mo2978computeScaleFactorH7hwNQA(long j10, long j11);

    /* JADX INFO: compiled from: ContentScale.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final ContentScale Crop = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Crop$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                float fM2984computeFillMaxDimensioniLBOSCw = ContentScaleKt.m2984computeFillMaxDimensioniLBOSCw(j10, j11);
                return ScaleFactorKt.ScaleFactor(fM2984computeFillMaxDimensioniLBOSCw, fM2984computeFillMaxDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Fit = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Fit$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                float fM2985computeFillMinDimensioniLBOSCw = ContentScaleKt.m2985computeFillMinDimensioniLBOSCw(j10, j11);
                return ScaleFactorKt.ScaleFactor(fM2985computeFillMinDimensioniLBOSCw, fM2985computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillHeight = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillHeight$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                float fM2983computeFillHeightiLBOSCw = ContentScaleKt.m2983computeFillHeightiLBOSCw(j10, j11);
                return ScaleFactorKt.ScaleFactor(fM2983computeFillHeightiLBOSCw, fM2983computeFillHeightiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale FillWidth = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillWidth$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                float fM2986computeFillWidthiLBOSCw = ContentScaleKt.m2986computeFillWidthiLBOSCw(j10, j11);
                return ScaleFactorKt.ScaleFactor(fM2986computeFillWidthiLBOSCw, fM2986computeFillWidthiLBOSCw);
            }
        };

        @NotNull
        private static final ContentScale Inside = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$Inside$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                if (Size.m1436getWidthimpl(j10) <= Size.m1436getWidthimpl(j11) && Size.m1433getHeightimpl(j10) <= Size.m1433getHeightimpl(j11)) {
                    return ScaleFactorKt.ScaleFactor(1.0f, 1.0f);
                }
                float fM2985computeFillMinDimensioniLBOSCw = ContentScaleKt.m2985computeFillMinDimensioniLBOSCw(j10, j11);
                return ScaleFactorKt.ScaleFactor(fM2985computeFillMinDimensioniLBOSCw, fM2985computeFillMinDimensioniLBOSCw);
            }
        };

        @NotNull
        private static final FixedScale None = new FixedScale(1.0f);

        @NotNull
        private static final ContentScale FillBounds = new ContentScale() { // from class: androidx.compose.ui.layout.ContentScale$Companion$FillBounds$1
            @Override // androidx.compose.ui.layout.ContentScale
            /* JADX INFO: renamed from: computeScaleFactor-H7hwNQA */
            public long mo2978computeScaleFactorH7hwNQA(long j10, long j11) {
                return ScaleFactorKt.ScaleFactor(ContentScaleKt.m2986computeFillWidthiLBOSCw(j10, j11), ContentScaleKt.m2983computeFillHeightiLBOSCw(j10, j11));
            }
        };

        private Companion() {
        }

        @NotNull
        public final ContentScale getCrop() {
            return Crop;
        }

        @NotNull
        public final ContentScale getFillBounds() {
            return FillBounds;
        }

        @NotNull
        public final ContentScale getFillHeight() {
            return FillHeight;
        }

        @NotNull
        public final ContentScale getFillWidth() {
            return FillWidth;
        }

        @NotNull
        public final ContentScale getFit() {
            return Fit;
        }

        @NotNull
        public final ContentScale getInside() {
            return Inside;
        }

        @NotNull
        public final FixedScale getNone() {
            return None;
        }

        @Stable
        public static /* synthetic */ void getCrop$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillBounds$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillHeight$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFillWidth$annotations() {
        }

        @Stable
        public static /* synthetic */ void getFit$annotations() {
        }

        @Stable
        public static /* synthetic */ void getInside$annotations() {
        }

        @Stable
        public static /* synthetic */ void getNone$annotations() {
        }
    }
}
