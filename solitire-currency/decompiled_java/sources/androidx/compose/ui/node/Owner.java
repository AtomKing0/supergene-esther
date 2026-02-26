package androidx.compose.ui.node;

import android.view.KeyEvent;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.platform.AccessibilityManager;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Owner.kt */
/* JADX INFO: loaded from: classes.dex */
public interface Owner {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: Owner.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static boolean enableExtraAssertions;

        private Companion() {
        }

        public final boolean getEnableExtraAssertions() {
            return enableExtraAssertions;
        }

        public final void setEnableExtraAssertions(boolean z10) {
            enableExtraAssertions = z10;
        }
    }

    /* JADX INFO: compiled from: Owner.kt */
    public interface OnLayoutCompletedListener {
        void onLayoutComplete();
    }

    /* JADX INFO: renamed from: calculateLocalPosition-MK-Hz9U, reason: not valid java name */
    long mo3147calculateLocalPositionMKHz9U(long j10);

    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U, reason: not valid java name */
    long mo3148calculatePositionInWindowMKHz9U(long j10);

    @NotNull
    OwnedLayer createLayer(@NotNull l<? super Canvas, k0> lVar, @NotNull h9.a<k0> aVar);

    void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode);

    @NotNull
    AccessibilityManager getAccessibilityManager();

    @ExperimentalComposeUiApi
    @Nullable
    Autofill getAutofill();

    @ExperimentalComposeUiApi
    @NotNull
    AutofillTree getAutofillTree();

    @NotNull
    ClipboardManager getClipboardManager();

    @NotNull
    Density getDensity();

    @Nullable
    /* JADX INFO: renamed from: getFocusDirection-P8AzH3I, reason: not valid java name */
    FocusDirection mo3149getFocusDirectionP8AzH3I(@NotNull KeyEvent keyEvent);

    @NotNull
    FocusManager getFocusManager();

    @NotNull
    FontFamily.Resolver getFontFamilyResolver();

    @NotNull
    Font.ResourceLoader getFontLoader();

    @NotNull
    HapticFeedback getHapticFeedBack();

    @NotNull
    InputModeManager getInputModeManager();

    @NotNull
    LayoutDirection getLayoutDirection();

    long getMeasureIteration();

    @NotNull
    PointerIconService getPointerIconService();

    @NotNull
    LayoutNode getRoot();

    @NotNull
    RootForTest getRootForTest();

    @NotNull
    LayoutNodeDrawScope getSharedDrawScope();

    boolean getShowLayoutBounds();

    @NotNull
    OwnerSnapshotObserver getSnapshotObserver();

    @NotNull
    TextInputService getTextInputService();

    @NotNull
    TextToolbar getTextToolbar();

    @NotNull
    ViewConfiguration getViewConfiguration();

    @NotNull
    WindowInfo getWindowInfo();

    void measureAndLayout(boolean z10);

    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw, reason: not valid java name */
    void mo3150measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j10);

    void onAttach(@NotNull LayoutNode layoutNode);

    void onDetach(@NotNull LayoutNode layoutNode);

    void onEndApplyChanges();

    void onLayoutChange(@NotNull LayoutNode layoutNode);

    void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean z10);

    void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean z10);

    void onSemanticsChange();

    void registerOnEndApplyChangesListener(@NotNull h9.a<k0> aVar);

    void registerOnLayoutCompletedListener(@NotNull OnLayoutCompletedListener onLayoutCompletedListener);

    boolean requestFocus();

    @InternalCoreApi
    void setShowLayoutBounds(boolean z10);
}
