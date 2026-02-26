package androidx.compose.ui.hapticfeedback;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PlatformHapticFeedback.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PlatformHapticFeedbackType {

    @NotNull
    public static final PlatformHapticFeedbackType INSTANCE = new PlatformHapticFeedbackType();
    private static final int LongPress = HapticFeedbackType.m2140constructorimpl(0);
    private static final int TextHandleMove = HapticFeedbackType.m2140constructorimpl(9);

    private PlatformHapticFeedbackType() {
    }

    /* JADX INFO: renamed from: getLongPress-5zf0vsI, reason: not valid java name */
    public final int m2148getLongPress5zf0vsI() {
        return LongPress;
    }

    /* JADX INFO: renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
    public final int m2149getTextHandleMove5zf0vsI() {
        return TextHandleMove;
    }
}
