package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.Selectable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextState {

    @NotNull
    private final MutableState drawScopeInvalidation$delegate;

    @Nullable
    private LayoutCoordinates layoutCoordinates;

    @Nullable
    private TextLayoutResult layoutResult;

    @NotNull
    private l<? super TextLayoutResult, k0> onTextLayout;
    private long previousGlobalPosition;

    @Nullable
    private Selectable selectable;
    private final long selectableId;
    private long selectionBackgroundColor;

    @NotNull
    private TextDelegate textDelegate;

    public TextState(@NotNull TextDelegate textDelegate, long j10) {
        t.i(textDelegate, "textDelegate");
        this.textDelegate = textDelegate;
        this.selectableId = j10;
        this.onTextLayout = TextState$onTextLayout$1.INSTANCE;
        this.previousGlobalPosition = Offset.Companion.m1383getZeroF1C5BW0();
        this.selectionBackgroundColor = Color.Companion.m1634getUnspecified0d7_KjU();
        this.drawScopeInvalidation$delegate = SnapshotStateKt.mutableStateOf(k0.f35197a, SnapshotStateKt.neverEqualPolicy());
    }

    private final void setDrawScopeInvalidation(k0 k0Var) {
        this.drawScopeInvalidation$delegate.setValue(k0Var);
    }

    @NotNull
    public final k0 getDrawScopeInvalidation() {
        this.drawScopeInvalidation$delegate.getValue();
        return k0.f35197a;
    }

    @Nullable
    public final LayoutCoordinates getLayoutCoordinates() {
        return this.layoutCoordinates;
    }

    @Nullable
    public final TextLayoutResult getLayoutResult() {
        return this.layoutResult;
    }

    @NotNull
    public final l<TextLayoutResult, k0> getOnTextLayout() {
        return this.onTextLayout;
    }

    /* JADX INFO: renamed from: getPreviousGlobalPosition-F1C5BW0, reason: not valid java name */
    public final long m749getPreviousGlobalPositionF1C5BW0() {
        return this.previousGlobalPosition;
    }

    @Nullable
    public final Selectable getSelectable() {
        return this.selectable;
    }

    public final long getSelectableId() {
        return this.selectableId;
    }

    /* JADX INFO: renamed from: getSelectionBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m750getSelectionBackgroundColor0d7_KjU() {
        return this.selectionBackgroundColor;
    }

    @NotNull
    public final TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public final void setLayoutCoordinates(@Nullable LayoutCoordinates layoutCoordinates) {
        this.layoutCoordinates = layoutCoordinates;
    }

    public final void setLayoutResult(@Nullable TextLayoutResult textLayoutResult) {
        setDrawScopeInvalidation(k0.f35197a);
        this.layoutResult = textLayoutResult;
    }

    public final void setOnTextLayout(@NotNull l<? super TextLayoutResult, k0> lVar) {
        t.i(lVar, "<set-?>");
        this.onTextLayout = lVar;
    }

    /* JADX INFO: renamed from: setPreviousGlobalPosition-k-4lQ0M, reason: not valid java name */
    public final void m751setPreviousGlobalPositionk4lQ0M(long j10) {
        this.previousGlobalPosition = j10;
    }

    public final void setSelectable(@Nullable Selectable selectable) {
        this.selectable = selectable;
    }

    /* JADX INFO: renamed from: setSelectionBackgroundColor-8_81llA, reason: not valid java name */
    public final void m752setSelectionBackgroundColor8_81llA(long j10) {
        this.selectionBackgroundColor = j10;
    }

    public final void setTextDelegate(@NotNull TextDelegate textDelegate) {
        t.i(textDelegate, "<set-?>");
        this.textDelegate = textDelegate;
    }
}
