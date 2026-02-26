package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.input.ImeAction;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: KeyboardActionRunner.kt */
/* JADX INFO: loaded from: classes.dex */
public final class KeyboardActionRunner implements KeyboardActionScope {
    public FocusManager focusManager;
    public KeyboardActions keyboardActions;

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    /* JADX INFO: renamed from: defaultKeyboardAction-KlQnJC8, reason: not valid java name */
    public void mo673defaultKeyboardActionKlQnJC8(int i10) {
        ImeAction.Companion companion = ImeAction.Companion;
        if (ImeAction.m3459equalsimpl0(i10, companion.m3466getNexteUduSuo())) {
            getFocusManager().mo1317moveFocus3ESFkO8(FocusDirection.Companion.m1312getNextdhqQ8s());
        } else {
            if (ImeAction.m3459equalsimpl0(i10, companion.m3468getPreviouseUduSuo())) {
                getFocusManager().mo1317moveFocus3ESFkO8(FocusDirection.Companion.m1314getPreviousdhqQ8s());
                return;
            }
            if (ImeAction.m3459equalsimpl0(i10, companion.m3464getDoneeUduSuo()) ? true : ImeAction.m3459equalsimpl0(i10, companion.m3465getGoeUduSuo()) ? true : ImeAction.m3459equalsimpl0(i10, companion.m3469getSearcheUduSuo()) ? true : ImeAction.m3459equalsimpl0(i10, companion.m3470getSendeUduSuo()) ? true : ImeAction.m3459equalsimpl0(i10, companion.m3463getDefaulteUduSuo())) {
                return;
            }
            ImeAction.m3459equalsimpl0(i10, companion.m3467getNoneeUduSuo());
        }
    }

    @NotNull
    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        t.A("focusManager");
        return null;
    }

    @NotNull
    public final KeyboardActions getKeyboardActions() {
        KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        t.A("keyboardActions");
        return null;
    }

    /* JADX INFO: renamed from: runAction-KlQnJC8, reason: not valid java name */
    public final void m674runActionKlQnJC8(int i10) {
        l<KeyboardActionScope, k0> onSend;
        ImeAction.Companion companion = ImeAction.Companion;
        k0 k0Var = null;
        if (ImeAction.m3459equalsimpl0(i10, companion.m3464getDoneeUduSuo())) {
            onSend = getKeyboardActions().getOnDone();
        } else if (ImeAction.m3459equalsimpl0(i10, companion.m3465getGoeUduSuo())) {
            onSend = getKeyboardActions().getOnGo();
        } else if (ImeAction.m3459equalsimpl0(i10, companion.m3466getNexteUduSuo())) {
            onSend = getKeyboardActions().getOnNext();
        } else if (ImeAction.m3459equalsimpl0(i10, companion.m3468getPreviouseUduSuo())) {
            onSend = getKeyboardActions().getOnPrevious();
        } else if (ImeAction.m3459equalsimpl0(i10, companion.m3469getSearcheUduSuo())) {
            onSend = getKeyboardActions().getOnSearch();
        } else if (ImeAction.m3459equalsimpl0(i10, companion.m3470getSendeUduSuo())) {
            onSend = getKeyboardActions().getOnSend();
        } else {
            if (!(ImeAction.m3459equalsimpl0(i10, companion.m3463getDefaulteUduSuo()) ? true : ImeAction.m3459equalsimpl0(i10, companion.m3467getNoneeUduSuo()))) {
                throw new IllegalStateException("invalid ImeAction".toString());
            }
            onSend = null;
        }
        if (onSend != null) {
            onSend.invoke(this);
            k0Var = k0.f35197a;
        }
        if (k0Var == null) {
            mo673defaultKeyboardActionKlQnJC8(i10);
        }
    }

    public final void setFocusManager(@NotNull FocusManager focusManager) {
        t.i(focusManager, "<set-?>");
        this.focusManager = focusManager;
    }

    public final void setKeyboardActions(@NotNull KeyboardActions keyboardActions) {
        t.i(keyboardActions, "<set-?>");
        this.keyboardActions = keyboardActions;
    }
}
