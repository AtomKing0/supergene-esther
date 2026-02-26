package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;

/* JADX INFO: compiled from: ContentScale.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ContentScaleKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillHeight-iLBOSCw, reason: not valid java name */
    public static final float m2983computeFillHeightiLBOSCw(long j10, long j11) {
        return Size.m1433getHeightimpl(j11) / Size.m1433getHeightimpl(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMaxDimension-iLBOSCw, reason: not valid java name */
    public static final float m2984computeFillMaxDimensioniLBOSCw(long j10, long j11) {
        return Math.max(m2986computeFillWidthiLBOSCw(j10, j11), m2983computeFillHeightiLBOSCw(j10, j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillMinDimension-iLBOSCw, reason: not valid java name */
    public static final float m2985computeFillMinDimensioniLBOSCw(long j10, long j11) {
        return Math.min(m2986computeFillWidthiLBOSCw(j10, j11), m2983computeFillHeightiLBOSCw(j10, j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: computeFillWidth-iLBOSCw, reason: not valid java name */
    public static final float m2986computeFillWidthiLBOSCw(long j10, long j11) {
        return Size.m1436getWidthimpl(j11) / Size.m1436getWidthimpl(j10);
    }
}
