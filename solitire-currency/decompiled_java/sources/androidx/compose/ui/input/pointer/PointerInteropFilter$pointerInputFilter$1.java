package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInteropFilter;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PointerInteropFilter.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropFilter$pointerInputFilter$1 extends PointerInputFilter {

    @NotNull
    private PointerInteropFilter.DispatchToViewState state = PointerInteropFilter.DispatchToViewState.Unknown;
    final /* synthetic */ PointerInteropFilter this$0;

    PointerInteropFilter$pointerInputFilter$1(PointerInteropFilter pointerInteropFilter) {
        this.this$0 = pointerInteropFilter;
    }

    private final void dispatchToView(PointerEvent pointerEvent) {
        boolean z10;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                z10 = false;
                break;
            } else {
                if (changes.get(i10).isConsumed()) {
                    z10 = true;
                    break;
                }
                i10++;
            }
        }
        if (z10) {
            if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
                LayoutCoordinates layoutCoordinates$ui_release = getLayoutCoordinates$ui_release();
                if (layoutCoordinates$ui_release == null) {
                    throw new IllegalStateException("layoutCoordinates not set".toString());
                }
                PointerInteropUtils_androidKt.m2918toCancelMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release.mo2991localToRootMKHz9U(Offset.Companion.m1383getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$2(this.this$0));
            }
            this.state = PointerInteropFilter.DispatchToViewState.NotDispatching;
            return;
        }
        LayoutCoordinates layoutCoordinates$ui_release2 = getLayoutCoordinates$ui_release();
        if (layoutCoordinates$ui_release2 == null) {
            throw new IllegalStateException("layoutCoordinates not set".toString());
        }
        PointerInteropUtils_androidKt.m2919toMotionEventScoped4ec7I(pointerEvent, layoutCoordinates$ui_release2.mo2991localToRootMKHz9U(Offset.Companion.m1383getZeroF1C5BW0()), new PointerInteropFilter$pointerInputFilter$1$dispatchToView$3(this, this.this$0));
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            int size2 = changes.size();
            for (int i11 = 0; i11 < size2; i11++) {
                changes.get(i11).consume();
            }
            InternalPointerEvent internalPointerEvent$ui_release = pointerEvent.getInternalPointerEvent$ui_release();
            if (internalPointerEvent$ui_release == null) {
                return;
            }
            internalPointerEvent$ui_release.setSuppressMovementConsumption(!this.this$0.getDisallowIntercept$ui_release());
        }
    }

    private final void reset() {
        this.state = PointerInteropFilter.DispatchToViewState.Unknown;
        this.this$0.setDisallowIntercept$ui_release(false);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public boolean getShareWithSiblings() {
        return true;
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    public void onCancel() {
        if (this.state == PointerInteropFilter.DispatchToViewState.Dispatching) {
            PointerInteropUtils_androidKt.emptyCancelMotionEventScope(SystemClock.uptimeMillis(), new PointerInteropFilter$pointerInputFilter$1$onCancel$1(this.this$0));
            reset();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    @Override // androidx.compose.ui.input.pointer.PointerInputFilter
    /* JADX INFO: renamed from: onPointerEvent-H0pRuoY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo2894onPointerEventH0pRuoY(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEvent r6, @org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.PointerEventPass r7, long r8) {
        /*
            r5 = this;
            java.lang.String r8 = "pointerEvent"
            kotlin.jvm.internal.t.i(r6, r8)
            java.lang.String r8 = "pass"
            kotlin.jvm.internal.t.i(r7, r8)
            java.util.List r8 = r6.getChanges()
            androidx.compose.ui.input.pointer.PointerInteropFilter r9 = r5.this$0
            boolean r9 = r9.getDisallowIntercept$ui_release()
            r0 = 0
            r1 = 1
            if (r9 != 0) goto L42
            int r9 = r8.size()
            r2 = r0
        L1d:
            if (r2 >= r9) goto L3c
            java.lang.Object r3 = r8.get(r2)
            androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
            boolean r4 = androidx.compose.ui.input.pointer.PointerEventKt.changedToDownIgnoreConsumed(r3)
            if (r4 != 0) goto L34
            boolean r3 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r3)
            if (r3 == 0) goto L32
            goto L34
        L32:
            r3 = r0
            goto L35
        L34:
            r3 = r1
        L35:
            if (r3 == 0) goto L39
            r9 = r1
            goto L3d
        L39:
            int r2 = r2 + 1
            goto L1d
        L3c:
            r9 = r0
        L3d:
            if (r9 == 0) goto L40
            goto L42
        L40:
            r9 = r0
            goto L43
        L42:
            r9 = r1
        L43:
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r2 = r5.state
            androidx.compose.ui.input.pointer.PointerInteropFilter$DispatchToViewState r3 = androidx.compose.ui.input.pointer.PointerInteropFilter.DispatchToViewState.NotDispatching
            if (r2 == r3) goto L5b
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
            if (r7 != r2) goto L52
            if (r9 == 0) goto L52
            r5.dispatchToView(r6)
        L52:
            androidx.compose.ui.input.pointer.PointerEventPass r2 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r7 != r2) goto L5b
            if (r9 != 0) goto L5b
            r5.dispatchToView(r6)
        L5b:
            androidx.compose.ui.input.pointer.PointerEventPass r6 = androidx.compose.ui.input.pointer.PointerEventPass.Final
            if (r7 != r6) goto L7c
            int r6 = r8.size()
            r7 = r0
        L64:
            if (r7 >= r6) goto L76
            java.lang.Object r9 = r8.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
            boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r9)
            if (r9 != 0) goto L73
            goto L77
        L73:
            int r7 = r7 + 1
            goto L64
        L76:
            r0 = r1
        L77:
            if (r0 == 0) goto L7c
            r5.reset()
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerInteropFilter$pointerInputFilter$1.mo2894onPointerEventH0pRuoY(androidx.compose.ui.input.pointer.PointerEvent, androidx.compose.ui.input.pointer.PointerEventPass, long):void");
    }
}
