package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTextToolbar.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public final class TextToolbarHelperMethods {

    @NotNull
    public static final TextToolbarHelperMethods INSTANCE = new TextToolbarHelperMethods();

    private TextToolbarHelperMethods() {
    }

    @DoNotInline
    @RequiresApi(23)
    public final void invalidateContentRect(@NotNull ActionMode actionMode) {
        kotlin.jvm.internal.t.i(actionMode, "actionMode");
        actionMode.invalidateContentRect();
    }

    @DoNotInline
    @RequiresApi(23)
    @Nullable
    public final ActionMode startActionMode(@NotNull View view, @NotNull ActionMode.Callback actionModeCallback, int i10) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(actionModeCallback, "actionModeCallback");
        return view.startActionMode(actionModeCallback, i10);
    }
}
