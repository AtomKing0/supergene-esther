package androidx.compose.ui.input;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.ExperimentalComposeUiApi;
import h9.l;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InputModeManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class InputModeManagerImpl implements InputModeManager {

    @NotNull
    private final MutableState inputMode$delegate;

    @NotNull
    private final l<InputMode, Boolean> onRequestInputModeChange;

    public /* synthetic */ InputModeManagerImpl(int i10, l lVar, k kVar) {
        this(i10, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.input.InputModeManager
    /* JADX INFO: renamed from: getInputMode-aOaMEAU */
    public int mo2159getInputModeaOaMEAU() {
        return ((InputMode) this.inputMode$delegate.getValue()).m2156unboximpl();
    }

    @Override // androidx.compose.ui.input.InputModeManager
    @ExperimentalComposeUiApi
    /* JADX INFO: renamed from: requestInputMode-iuPiT84 */
    public boolean mo2160requestInputModeiuPiT84(int i10) {
        return this.onRequestInputModeChange.invoke(InputMode.m2150boximpl(i10)).booleanValue();
    }

    /* JADX INFO: renamed from: setInputMode-iuPiT84, reason: not valid java name */
    public void m2161setInputModeiuPiT84(int i10) {
        this.inputMode$delegate.setValue(InputMode.m2150boximpl(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private InputModeManagerImpl(int i10, l<? super InputMode, Boolean> lVar) {
        this.onRequestInputModeChange = lVar;
        this.inputMode$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(InputMode.m2150boximpl(i10), null, 2, null);
    }
}
