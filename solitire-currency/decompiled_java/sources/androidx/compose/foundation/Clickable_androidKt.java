package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Clickable.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: androidx.compose.foundation.Clickable_androidKt$isComposeRootInScrollableContainer$1, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.android.kt */
    static final class AnonymousClass1 extends v implements h9.a<Boolean> {
        final /* synthetic */ View $view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(View view) {
            super(0);
            this.$view = view;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            return Boolean.valueOf(Clickable_androidKt.isInScrollableViewGroup(this.$view));
        }
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* JADX INFO: renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m200isClickZmokQxo(@NotNull KeyEvent isClick) {
        t.i(isClick, "$this$isClick");
        if (!KeyEventType.m2753equalsimpl0(KeyEvent_androidKt.m2761getTypeZmokQxo(isClick), KeyEventType.Companion.m2758getKeyUpCS__XNY())) {
            return false;
        }
        int iM2770getNativeKeyCodeYVgTNJs = Key_androidKt.m2770getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m2760getKeyZmokQxo(isClick));
        return iM2770getNativeKeyCodeYVgTNJs == 23 || iM2770getNativeKeyCodeYVgTNJs == 66 || iM2770getNativeKeyCodeYVgTNJs == 160;
    }

    @Composable
    @NotNull
    public static final h9.a<Boolean> isComposeRootInScrollableContainer(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1990508712);
        AnonymousClass1 anonymousClass1 = new AnonymousClass1((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView()));
        composer.endReplaceableGroup();
        return anonymousClass1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }
}
