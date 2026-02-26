package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.android.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class SemanticsPropertiesAndroid {
    public static final int $stable = 0;

    @NotNull
    public static final SemanticsPropertiesAndroid INSTANCE = new SemanticsPropertiesAndroid();

    @NotNull
    private static final SemanticsPropertyKey<Boolean> TestTagsAsResourceId = new SemanticsPropertyKey<>("TestTagsAsResourceId", SemanticsPropertiesAndroid$TestTagsAsResourceId$1.INSTANCE);

    private SemanticsPropertiesAndroid() {
    }

    @ExperimentalComposeUiApi
    @NotNull
    public final SemanticsPropertyKey<Boolean> getTestTagsAsResourceId() {
        return TestTagsAsResourceId;
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getTestTagsAsResourceId$annotations() {
    }
}
