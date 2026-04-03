package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextRange;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldScroll.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class TextFieldScrollerPosition {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final Saver<TextFieldScrollerPosition, Object> Saver = ListSaverKt.listSaver(TextFieldScrollerPosition$Companion$Saver$1.INSTANCE, TextFieldScrollerPosition$Companion$Saver$2.INSTANCE);

    @NotNull
    private final MutableState maximum$delegate;

    @NotNull
    private final MutableState offset$delegate;

    @NotNull
    private final MutableState orientation$delegate;

    @NotNull
    private Rect previousCursorRect;
    private long previousSelection;

    /* JADX INFO: compiled from: TextFieldScroll.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final Saver<TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.Saver;
        }
    }

    public TextFieldScrollerPosition(@NotNull Orientation initialOrientation, float f10) {
        t.i(initialOrientation, "initialOrientation");
        this.offset$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(f10), null, 2, null);
        this.maximum$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Float.valueOf(0.0f), null, 2, null);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.m3340getZerod9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(initialOrientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    private final void setMaximum(float f10) {
        this.maximum$delegate.setValue(Float.valueOf(f10));
    }

    public final void coerceOffset$foundation_release(float f10, float f11, int i10) {
        float offset = getOffset();
        float f12 = i10;
        float f13 = offset + f12;
        setOffset(getOffset() + ((f11 <= f13 && (f10 >= offset || f11 - f10 <= f12)) ? (f10 >= offset || f11 - f10 > f12) ? 0.0f : f10 - offset : f11 - f13));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getMaximum() {
        return ((Number) this.maximum$delegate.getValue()).floatValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final float getOffset() {
        return ((Number) this.offset$delegate.getValue()).floatValue();
    }

    /* JADX INFO: renamed from: getOffsetToFollow-5zc-tL8, reason: not valid java name */
    public final int m732getOffsetToFollow5zctL8(long j10) {
        return TextRange.m3335getStartimpl(j10) != TextRange.m3335getStartimpl(this.previousSelection) ? TextRange.m3335getStartimpl(j10) : TextRange.m3330getEndimpl(j10) != TextRange.m3330getEndimpl(this.previousSelection) ? TextRange.m3330getEndimpl(j10) : TextRange.m3333getMinimpl(j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final Orientation getOrientation() {
        return (Orientation) this.orientation$delegate.getValue();
    }

    /* JADX INFO: renamed from: getPreviousSelection-d9O1mEE, reason: not valid java name */
    public final long m733getPreviousSelectiond9O1mEE() {
        return this.previousSelection;
    }

    public final void setOffset(float f10) {
        this.offset$delegate.setValue(Float.valueOf(f10));
    }

    public final void setOrientation(@NotNull Orientation orientation) {
        t.i(orientation, "<set-?>");
        this.orientation$delegate.setValue(orientation);
    }

    /* JADX INFO: renamed from: setPreviousSelection-5zc-tL8, reason: not valid java name */
    public final void m734setPreviousSelection5zctL8(long j10) {
        this.previousSelection = j10;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void update(@org.jetbrains.annotations.NotNull androidx.compose.foundation.gestures.Orientation r5, @org.jetbrains.annotations.NotNull androidx.compose.ui.geometry.Rect r6, int r7, int r8) {
        /*
            r4 = this;
            java.lang.String r0 = "orientation"
            kotlin.jvm.internal.t.i(r5, r0)
            java.lang.String r0 = "cursorRect"
            kotlin.jvm.internal.t.i(r6, r0)
            int r8 = r8 - r7
            float r8 = (float) r8
            r4.setMaximum(r8)
            float r0 = r6.getLeft()
            androidx.compose.ui.geometry.Rect r1 = r4.previousCursorRect
            float r1 = r1.getLeft()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L21
            r0 = r1
            goto L22
        L21:
            r0 = r2
        L22:
            if (r0 == 0) goto L37
            float r0 = r6.getTop()
            androidx.compose.ui.geometry.Rect r3 = r4.previousCursorRect
            float r3 = r3.getTop()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L34
            r0 = r1
            goto L35
        L34:
            r0 = r2
        L35:
            if (r0 != 0) goto L58
        L37:
            androidx.compose.foundation.gestures.Orientation r0 = androidx.compose.foundation.gestures.Orientation.Vertical
            if (r5 != r0) goto L3c
            goto L3d
        L3c:
            r1 = r2
        L3d:
            if (r1 == 0) goto L44
            float r5 = r6.getTop()
            goto L48
        L44:
            float r5 = r6.getLeft()
        L48:
            if (r1 == 0) goto L4f
            float r0 = r6.getBottom()
            goto L53
        L4f:
            float r0 = r6.getRight()
        L53:
            r4.coerceOffset$foundation_release(r5, r0, r7)
            r4.previousCursorRect = r6
        L58:
            float r5 = r4.getOffset()
            r6 = 0
            float r5 = n9.m.m(r5, r6, r8)
            r4.setOffset(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextFieldScrollerPosition.update(androidx.compose.foundation.gestures.Orientation, androidx.compose.ui.geometry.Rect, int, int):void");
    }

    public /* synthetic */ TextFieldScrollerPosition(Orientation orientation, float f10, int i10, k kVar) {
        this(orientation, (i10 & 2) != 0 ? 0.0f : f10);
    }

    public TextFieldScrollerPosition() {
        this(Orientation.Vertical, 0.0f, 2, null);
    }
}
