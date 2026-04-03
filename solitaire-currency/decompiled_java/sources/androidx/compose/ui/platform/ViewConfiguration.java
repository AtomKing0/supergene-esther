package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ViewConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ViewConfiguration {

    /* JADX INFO: compiled from: ViewConfiguration.kt */
    public static final class DefaultImpls {
        @Deprecated
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public static long m3216getMinimumTouchTargetSizeMYxV2XQ(@NotNull ViewConfiguration viewConfiguration) {
            return a2.a(viewConfiguration);
        }
    }

    long getDoubleTapMinTimeMillis();

    long getDoubleTapTimeoutMillis();

    long getLongPressTimeoutMillis();

    /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ */
    long mo3104getMinimumTouchTargetSizeMYxV2XQ();

    float getTouchSlop();
}
