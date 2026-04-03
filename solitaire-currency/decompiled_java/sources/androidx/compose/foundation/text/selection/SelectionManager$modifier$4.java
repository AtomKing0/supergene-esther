package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.key.KeyEvent;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SelectionManager.kt */
/* JADX INFO: loaded from: classes.dex */
final class SelectionManager$modifier$4 extends v implements l<KeyEvent, Boolean> {
    final /* synthetic */ SelectionManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SelectionManager$modifier$4(SelectionManager selectionManager) {
        super(1);
        this.this$0 = selectionManager;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
        return m814invokeZmokQxo(keyEvent.m2749unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m814invokeZmokQxo(@NotNull android.view.KeyEvent it) {
        boolean z10;
        t.i(it, "it");
        if (SelectionManager_androidKt.m818isCopyKeyEventZmokQxo(it)) {
            this.this$0.copy$foundation_release();
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
