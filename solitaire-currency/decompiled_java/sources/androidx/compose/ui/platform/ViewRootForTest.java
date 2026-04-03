package androidx.compose.ui.platform;

import android.view.View;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.node.RootForTest;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewRootForTest.android.kt */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public interface ViewRootForTest extends RootForTest {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    boolean getHasPendingMeasureOrLayout();

    @NotNull
    View getView();

    void invalidateDescendants();

    boolean isLifecycleInResumedState();

    /* JADX INFO: compiled from: ViewRootForTest.android.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @Nullable
        private static h9.l<? super ViewRootForTest, v8.k0> onViewCreatedCallback;

        private Companion() {
        }

        @Nullable
        public final h9.l<ViewRootForTest, v8.k0> getOnViewCreatedCallback() {
            return onViewCreatedCallback;
        }

        public final void setOnViewCreatedCallback(@Nullable h9.l<? super ViewRootForTest, v8.k0> lVar) {
            onViewCreatedCallback = lVar;
        }

        @VisibleForTesting
        public static /* synthetic */ void getOnViewCreatedCallback$annotations() {
        }
    }
}
