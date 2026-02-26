package androidx.compose.ui.node;

import android.view.KeyEvent;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RootForTest.kt */
/* JADX INFO: loaded from: classes.dex */
public interface RootForTest {
    @NotNull
    Density getDensity();

    @NotNull
    SemanticsOwner getSemanticsOwner();

    @NotNull
    TextInputService getTextInputService();

    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo, reason: not valid java name */
    boolean mo3151sendKeyEventZmokQxo(@NotNull KeyEvent keyEvent);
}
