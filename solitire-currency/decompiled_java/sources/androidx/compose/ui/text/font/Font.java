package androidx.compose.ui.text.font;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Font.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public interface Font {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long MaximumAsyncTimeout = 15000;

    /* JADX INFO: compiled from: Font.kt */
    public interface ResourceLoader {
        @NotNull
        Object load(@NotNull Font font);
    }

    @ExperimentalTextApi
    /* JADX INFO: renamed from: getLoadingStrategy-PKNRLFQ */
    int mo3362getLoadingStrategyPKNRLFQ();

    /* JADX INFO: renamed from: getStyle-_-LCdwA */
    int mo3361getStyle_LCdwA();

    @NotNull
    FontWeight getWeight();

    /* JADX INFO: compiled from: Font.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long MaximumAsyncTimeout = 15000;

        private Companion() {
        }

        @ExperimentalTextApi
        public static /* synthetic */ void getMaximumAsyncTimeout$ui_text_release$annotations() {
        }
    }
}
