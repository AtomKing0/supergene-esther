package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextToolbar.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidTextToolbar implements TextToolbar {

    @Nullable
    private ActionMode actionMode;

    @NotNull
    private TextToolbarStatus status;

    @NotNull
    private final TextActionModeCallback textActionModeCallback;

    @NotNull
    private final View view;

    public AndroidTextToolbar(@NotNull View view) {
        kotlin.jvm.internal.t.i(view, "view");
        this.view = view;
        this.textActionModeCallback = new TextActionModeCallback(new AndroidTextToolbar$textActionModeCallback$1(this), null, null, null, null, null, 62, null);
        this.status = TextToolbarStatus.Hidden;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    @NotNull
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(@NotNull Rect rect, @Nullable h9.a<v8.k0> aVar, @Nullable h9.a<v8.k0> aVar2, @Nullable h9.a<v8.k0> aVar3, @Nullable h9.a<v8.k0> aVar4) {
        kotlin.jvm.internal.t.i(rect, "rect");
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(aVar);
        this.textActionModeCallback.setOnCutRequested(aVar3);
        this.textActionModeCallback.setOnPasteRequested(aVar2);
        this.textActionModeCallback.setOnSelectAllRequested(aVar4);
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }
}
