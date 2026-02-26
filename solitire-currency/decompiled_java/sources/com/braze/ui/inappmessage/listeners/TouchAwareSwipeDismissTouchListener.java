package com.braze.ui.inappmessage.listeners;

import android.view.MotionEvent;
import android.view.View;
import com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TouchAwareSwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TouchAwareSwipeDismissTouchListener extends SwipeDismissTouchListener {

    @Nullable
    private ITouchListener touchListener;

    /* JADX INFO: compiled from: TouchAwareSwipeDismissTouchListener.kt */
    public interface ITouchListener {
        void onTouchEnded();

        void onTouchStartedOrContinued();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TouchAwareSwipeDismissTouchListener(@NotNull View view, @Nullable Object obj, @Nullable SwipeDismissTouchListener.DismissCallbacks dismissCallbacks) {
        super(view, obj, dismissCallbacks);
        t.i(view, "view");
    }

    @Override // com.braze.ui.inappmessage.listeners.SwipeDismissTouchListener, android.view.View.OnTouchListener
    public boolean onTouch(@NotNull View view, @NotNull MotionEvent motionEvent) {
        ITouchListener iTouchListener;
        t.i(view, "view");
        t.i(motionEvent, "motionEvent");
        int action = motionEvent.getAction();
        if (action == 0) {
            ITouchListener iTouchListener2 = this.touchListener;
            if (iTouchListener2 != null) {
                iTouchListener2.onTouchStartedOrContinued();
            }
        } else if ((action == 1 || action == 3) && (iTouchListener = this.touchListener) != null) {
            iTouchListener.onTouchEnded();
        }
        return super.onTouch(view, motionEvent);
    }

    public final void setTouchListener(@NotNull ITouchListener newTouchListener) {
        t.i(newTouchListener, "newTouchListener");
        this.touchListener = newTouchListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TouchAwareSwipeDismissTouchListener(@NotNull View view, @Nullable SwipeDismissTouchListener.DismissCallbacks dismissCallbacks) {
        this(view, null, dismissCallbacks);
        t.i(view, "view");
    }
}
