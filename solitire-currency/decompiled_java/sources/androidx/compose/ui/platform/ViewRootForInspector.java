package androidx.compose.ui.platform;

import android.view.View;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewRootForInspector.android.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ViewRootForInspector {

    /* JADX INFO: compiled from: ViewRootForInspector.android.kt */
    public static final class DefaultImpls {
        @Deprecated
        @Nullable
        public static AbstractComposeView getSubCompositionView(@NotNull ViewRootForInspector viewRootForInspector) {
            return e2.a(viewRootForInspector);
        }

        @Deprecated
        @Nullable
        public static View getViewRoot(@NotNull ViewRootForInspector viewRootForInspector) {
            return e2.b(viewRootForInspector);
        }
    }

    @Nullable
    AbstractComposeView getSubCompositionView();

    @Nullable
    View getViewRoot();
}
