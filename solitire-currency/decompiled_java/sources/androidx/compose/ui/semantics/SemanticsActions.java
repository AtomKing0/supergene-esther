package androidx.compose.ui.semantics;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import h9.l;
import h9.p;
import h9.q;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsActions {
    public static final int $stable = 0;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> Collapse;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> CopyText;

    @NotNull
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> CutText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> Dismiss;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> Expand;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<l<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;

    @NotNull
    public static final SemanticsActions INSTANCE = new SemanticsActions();

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> OnClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> OnLongClick;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> PasteText;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> RequestFocus;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<p<Float, Float, Boolean>>> ScrollBy;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<l<Integer, Boolean>>> ScrollToIndex;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<l<Float, Boolean>>> SetProgress;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<q<Integer, Integer, Boolean, Boolean>>> SetSelection;

    @NotNull
    private static final SemanticsPropertyKey<AccessibilityAction<l<AnnotatedString, Boolean>>> SetText;

    static {
        SemanticsPropertiesKt.AnonymousClass1 anonymousClass1 = SemanticsPropertiesKt.AnonymousClass1.INSTANCE;
        GetTextLayoutResult = new SemanticsPropertyKey<>("GetTextLayoutResult", anonymousClass1);
        OnClick = new SemanticsPropertyKey<>("OnClick", anonymousClass1);
        OnLongClick = new SemanticsPropertyKey<>("OnLongClick", anonymousClass1);
        ScrollBy = new SemanticsPropertyKey<>("ScrollBy", anonymousClass1);
        ScrollToIndex = new SemanticsPropertyKey<>("ScrollToIndex", anonymousClass1);
        SetProgress = new SemanticsPropertyKey<>("SetProgress", anonymousClass1);
        SetSelection = new SemanticsPropertyKey<>("SetSelection", anonymousClass1);
        SetText = new SemanticsPropertyKey<>("SetText", anonymousClass1);
        CopyText = new SemanticsPropertyKey<>("CopyText", anonymousClass1);
        CutText = new SemanticsPropertyKey<>("CutText", anonymousClass1);
        PasteText = new SemanticsPropertyKey<>("PasteText", anonymousClass1);
        Expand = new SemanticsPropertyKey<>("Expand", anonymousClass1);
        Collapse = new SemanticsPropertyKey<>("Collapse", anonymousClass1);
        Dismiss = new SemanticsPropertyKey<>("Dismiss", anonymousClass1);
        RequestFocus = new SemanticsPropertyKey<>("RequestFocus", anonymousClass1);
        CustomActions = new SemanticsPropertyKey<>("CustomActions", null, 2, null);
    }

    private SemanticsActions() {
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getCollapse() {
        return Collapse;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getCopyText() {
        return CopyText;
    }

    @NotNull
    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getCutText() {
        return CutText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getDismiss() {
        return Dismiss;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getExpand() {
        return Expand;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<l<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getOnClick() {
        return OnClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getPasteText() {
        return PasteText;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<h9.a<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<p<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<l<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<l<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<q<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    @NotNull
    public final SemanticsPropertyKey<AccessibilityAction<l<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }
}
