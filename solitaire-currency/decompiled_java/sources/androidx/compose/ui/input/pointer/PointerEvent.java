package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: PointerEvent.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;

    @NotNull
    private final List<PointerInputChange> changes;

    @Nullable
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(@NotNull List<PointerInputChange> changes, @Nullable InternalPointerEvent internalPointerEvent) {
        t.i(changes, "changes");
        this.changes = changes;
        this.internalPointerEvent = internalPointerEvent;
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        this.buttons = PointerButtons.m2811constructorimpl(motionEvent$ui_release != null ? motionEvent$ui_release.getButtonState() : 0);
        MotionEvent motionEvent$ui_release2 = getMotionEvent$ui_release();
        this.keyboardModifiers = PointerKeyboardModifiers.m2922constructorimpl(motionEvent$ui_release2 != null ? motionEvent$ui_release2.getMetaState() : 0);
        this.type = m2817calculatePointerEventType7fucELk();
    }

    /* JADX INFO: renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m2817calculatePointerEventType7fucELk() {
        MotionEvent motionEvent$ui_release = getMotionEvent$ui_release();
        if (motionEvent$ui_release != null) {
            int actionMasked = motionEvent$ui_release.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                        }
                        return PointerEventType.Companion.m2834getPress7fucELk();
                    }
                    return PointerEventType.Companion.m2833getMove7fucELk();
                }
                return PointerEventType.Companion.m2835getRelease7fucELk();
            }
            return PointerEventType.Companion.m2834getPress7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            PointerInputChange pointerInputChange = list.get(i10);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m2835getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.Companion.m2834getPress7fucELk();
            }
        }
        return PointerEventType.Companion.m2833getMove7fucELk();
    }

    @NotNull
    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.input.pointer.PointerEvent copy(@org.jetbrains.annotations.NotNull java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r28, @org.jetbrains.annotations.Nullable android.view.MotionEvent r29) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            r2 = r29
            java.lang.String r3 = "changes"
            kotlin.jvm.internal.t.i(r1, r3)
            if (r2 != 0) goto L15
            androidx.compose.ui.input.pointer.PointerEvent r2 = new androidx.compose.ui.input.pointer.PointerEvent
            r3 = 0
            r2.<init>(r1, r3)
            goto Lbd
        L15:
            android.view.MotionEvent r3 = r27.getMotionEvent$ui_release()
            boolean r3 = kotlin.jvm.internal.t.d(r2, r3)
            if (r3 == 0) goto L28
            androidx.compose.ui.input.pointer.PointerEvent r2 = new androidx.compose.ui.input.pointer.PointerEvent
            androidx.compose.ui.input.pointer.InternalPointerEvent r3 = r0.internalPointerEvent
            r2.<init>(r1, r3)
            goto Lbd
        L28:
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            r3.<init>()
            int r4 = r28.size()
            r6 = 0
        L32:
            if (r6 >= r4) goto L48
            java.lang.Object r7 = r1.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            long r8 = r7.m2872getIdJ3iCeTQ()
            androidx.compose.ui.input.pointer.PointerId r8 = androidx.compose.ui.input.pointer.PointerId.m2857boximpl(r8)
            r3.put(r8, r7)
            int r6 = r6 + 1
            goto L32
        L48:
            java.util.ArrayList r4 = new java.util.ArrayList
            int r6 = r28.size()
            r4.<init>(r6)
            int r6 = r28.size()
            r7 = 0
        L56:
            if (r7 >= r6) goto La9
            java.lang.Object r8 = r1.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            androidx.compose.ui.input.pointer.PointerInputEventData r14 = new androidx.compose.ui.input.pointer.PointerInputEventData
            long r10 = r8.m2872getIdJ3iCeTQ()
            long r12 = r8.getUptimeMillis()
            long r15 = r8.m2873getPositionF1C5BW0()
            long r17 = r8.m2873getPositionF1C5BW0()
            boolean r19 = r8.getPressed()
            int r20 = r8.m2876getTypeT8wyACA()
            androidx.compose.ui.input.pointer.InternalPointerEvent r9 = r0.internalPointerEvent
            r26 = r6
            if (r9 == 0) goto L8a
            long r5 = r8.m2872getIdJ3iCeTQ()
            boolean r5 = r9.m2807issuesEnterExitEvent0FcD4WY(r5)
            r6 = 1
            if (r5 != r6) goto L8a
            goto L8b
        L8a:
            r6 = 0
        L8b:
            r21 = 0
            r22 = 0
            r24 = 384(0x180, float:5.38E-43)
            r25 = 0
            r9 = r14
            r5 = r14
            r14 = r15
            r16 = r17
            r18 = r19
            r19 = r20
            r20 = r6
            r9.<init>(r10, r12, r14, r16, r18, r19, r20, r21, r22, r24, r25)
            r4.add(r5)
            int r7 = r7 + 1
            r6 = r26
            goto L56
        La9:
            androidx.compose.ui.input.pointer.PointerInputEvent r5 = new androidx.compose.ui.input.pointer.PointerInputEvent
            long r6 = r29.getEventTime()
            r5.<init>(r6, r4, r2)
            androidx.compose.ui.input.pointer.InternalPointerEvent r2 = new androidx.compose.ui.input.pointer.InternalPointerEvent
            r2.<init>(r3, r5)
            androidx.compose.ui.input.pointer.PointerEvent r3 = new androidx.compose.ui.input.pointer.PointerEvent
            r3.<init>(r1, r2)
            r2 = r3
        Lbd:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerEvent.copy(java.util.List, android.view.MotionEvent):androidx.compose.ui.input.pointer.PointerEvent");
    }

    /* JADX INFO: renamed from: getButtons-ry648PA, reason: not valid java name */
    public final int m2818getButtonsry648PA() {
        return this.buttons;
    }

    @NotNull
    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    @Nullable
    public final InternalPointerEvent getInternalPointerEvent$ui_release() {
        return this.internalPointerEvent;
    }

    /* JADX INFO: renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name */
    public final int m2819getKeyboardModifiersk7X9c1A() {
        return this.keyboardModifiers;
    }

    @Nullable
    public final MotionEvent getMotionEvent$ui_release() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    /* JADX INFO: renamed from: getType-7fucELk, reason: not valid java name */
    public final int m2820getType7fucELk() {
        return this.type;
    }

    /* JADX INFO: renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m2821setTypeEhbLWgg$ui_release(int i10) {
        this.type = i10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PointerEvent(@NotNull List<PointerInputChange> changes) {
        this(changes, null);
        t.i(changes, "changes");
    }
}
