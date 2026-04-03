package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import androidx.compose.ui.InternalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WindowRecomposer.android.kt */
/* JADX INFO: loaded from: classes.dex */
@InternalComposeUiApi
public interface WindowRecomposerFactory {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    @NotNull
    Recomposer createRecomposer(@NotNull View view);

    /* JADX INFO: compiled from: WindowRecomposer.android.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final WindowRecomposerFactory LifecycleAware = new WindowRecomposerFactory() { // from class: androidx.compose.ui.platform.WindowRecomposerFactory$Companion$LifecycleAware$1
            @Override // androidx.compose.ui.platform.WindowRecomposerFactory
            @NotNull
            public final Recomposer createRecomposer(@NotNull View rootView) {
                kotlin.jvm.internal.t.i(rootView, "rootView");
                return WindowRecomposer_androidKt.createLifecycleAwareWindowRecomposer$default(rootView, null, null, 3, null);
            }
        };

        private Companion() {
        }

        @NotNull
        public final WindowRecomposerFactory getLifecycleAware() {
            return LifecycleAware;
        }

        public static /* synthetic */ void getLifecycleAware$annotations() {
        }
    }
}
