package androidx.compose.ui.platform;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.text.input.TextInputService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LocalSoftwareKeyboardController.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalComposeUiApi
public final class LocalSoftwareKeyboardController {
    public static final int $stable = 0;

    @NotNull
    public static final LocalSoftwareKeyboardController INSTANCE = new LocalSoftwareKeyboardController();

    @NotNull
    private static final ProvidableCompositionLocal<SoftwareKeyboardController> LocalSoftwareKeyboardController = CompositionLocalKt.compositionLocalOf$default(null, LocalSoftwareKeyboardController$LocalSoftwareKeyboardController$1.INSTANCE, 1, null);

    private LocalSoftwareKeyboardController() {
    }

    @Composable
    private final SoftwareKeyboardController delegatingController(Composer composer, int i10) {
        composer.startReplaceableGroup(1835581880);
        TextInputService textInputService = (TextInputService) composer.consume(CompositionLocalsKt.getLocalTextInputService());
        if (textInputService == null) {
            composer.endReplaceableGroup();
            return null;
        }
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(textInputService);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DelegatingSoftwareKeyboardController(textInputService);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DelegatingSoftwareKeyboardController delegatingSoftwareKeyboardController = (DelegatingSoftwareKeyboardController) objRememberedValue;
        composer.endReplaceableGroup();
        return delegatingSoftwareKeyboardController;
    }

    @Composable
    @Nullable
    public final SoftwareKeyboardController getCurrent(@Nullable Composer composer, int i10) {
        composer.startReplaceableGroup(-1059476185);
        SoftwareKeyboardController softwareKeyboardControllerDelegatingController = (SoftwareKeyboardController) composer.consume(LocalSoftwareKeyboardController);
        if (softwareKeyboardControllerDelegatingController == null) {
            softwareKeyboardControllerDelegatingController = delegatingController(composer, i10 & 14);
        }
        composer.endReplaceableGroup();
        return softwareKeyboardControllerDelegatingController;
    }

    @NotNull
    public final ProvidedValue<SoftwareKeyboardController> provides(@NotNull SoftwareKeyboardController softwareKeyboardController) {
        kotlin.jvm.internal.t.i(softwareKeyboardController, "softwareKeyboardController");
        return LocalSoftwareKeyboardController.provides(softwareKeyboardController);
    }

    @ExperimentalComposeUiApi
    public static /* synthetic */ void getCurrent$annotations() {
    }
}
