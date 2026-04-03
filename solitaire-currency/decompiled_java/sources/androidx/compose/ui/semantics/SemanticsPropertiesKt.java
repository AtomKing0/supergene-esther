package androidx.compose.ui.semantics;

import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import h9.l;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.g;
import v8.k0;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsPropertiesKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {o0.e(new a0(SemanticsPropertiesKt.class, "stateDescription", "getStateDescription(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "progressBarRangeInfo", "getProgressBarRangeInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "paneTitle", "getPaneTitle(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "liveRegion", "getLiveRegion(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "focused", "getFocused(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "horizontalScrollAxisRange", "getHorizontalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "verticalScrollAxisRange", "getVerticalScrollAxisRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/ScrollAxisRange;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "role", "getRole(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "testTag", "getTestTag(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/lang/String;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "editableText", "getEditableText(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/text/AnnotatedString;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "textSelectionRange", "getTextSelectionRange(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)J", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "imeAction", "getImeAction(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)I", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "selected", "getSelected(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Z", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "collectionInfo", "getCollectionInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionInfo;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "collectionItemInfo", "getCollectionItemInfo(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/semantics/CollectionItemInfo;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "toggleableState", "getToggleableState(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Landroidx/compose/ui/state/ToggleableState;", 1)), o0.e(new a0(SemanticsPropertiesKt.class, "customActions", "getCustomActions(Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;)Ljava/util/List;", 1))};

    @NotNull
    private static final SemanticsPropertyKey collectionInfo$delegate;

    @NotNull
    private static final SemanticsPropertyKey collectionItemInfo$delegate;

    @NotNull
    private static final SemanticsPropertyKey customActions$delegate;

    @NotNull
    private static final SemanticsPropertyKey editableText$delegate;

    @NotNull
    private static final SemanticsPropertyKey focused$delegate;

    @NotNull
    private static final SemanticsPropertyKey horizontalScrollAxisRange$delegate;

    @NotNull
    private static final SemanticsPropertyKey imeAction$delegate;

    @NotNull
    private static final SemanticsPropertyKey liveRegion$delegate;

    @NotNull
    private static final SemanticsPropertyKey paneTitle$delegate;

    @NotNull
    private static final SemanticsPropertyKey progressBarRangeInfo$delegate;

    @NotNull
    private static final SemanticsPropertyKey role$delegate;

    @NotNull
    private static final SemanticsPropertyKey selected$delegate;

    @NotNull
    private static final SemanticsPropertyKey stateDescription$delegate;

    @NotNull
    private static final SemanticsPropertyKey testTag$delegate;

    @NotNull
    private static final SemanticsPropertyKey textSelectionRange$delegate;

    @NotNull
    private static final SemanticsPropertyKey toggleableState$delegate;

    @NotNull
    private static final SemanticsPropertyKey verticalScrollAxisRange$delegate;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.semantics.SemanticsPropertiesKt$ActionPropertyKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: SemanticsProperties.kt */
    public static final class AnonymousClass1<T> extends v implements p<AccessibilityAction<T>, AccessibilityAction<T>, AccessibilityAction<T>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final AccessibilityAction<T> mo4invoke(@Nullable AccessibilityAction<T> accessibilityAction, @NotNull AccessibilityAction<T> childValue) {
            String label;
            g action;
            t.i(childValue, "childValue");
            if (accessibilityAction == null || (label = accessibilityAction.getLabel()) == null) {
                label = childValue.getLabel();
            }
            if (accessibilityAction == null || (action = accessibilityAction.getAction()) == null) {
                action = childValue.getAction();
            }
            return new AccessibilityAction<>(label, action);
        }
    }

    static {
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        stateDescription$delegate = semanticsProperties.getStateDescription();
        progressBarRangeInfo$delegate = semanticsProperties.getProgressBarRangeInfo();
        paneTitle$delegate = semanticsProperties.getPaneTitle();
        liveRegion$delegate = semanticsProperties.getLiveRegion();
        focused$delegate = semanticsProperties.getFocused();
        horizontalScrollAxisRange$delegate = semanticsProperties.getHorizontalScrollAxisRange();
        verticalScrollAxisRange$delegate = semanticsProperties.getVerticalScrollAxisRange();
        role$delegate = semanticsProperties.getRole();
        testTag$delegate = semanticsProperties.getTestTag();
        editableText$delegate = semanticsProperties.getEditableText();
        textSelectionRange$delegate = semanticsProperties.getTextSelectionRange();
        imeAction$delegate = semanticsProperties.getImeAction();
        selected$delegate = semanticsProperties.getSelected();
        collectionInfo$delegate = semanticsProperties.getCollectionInfo();
        collectionItemInfo$delegate = semanticsProperties.getCollectionItemInfo();
        toggleableState$delegate = semanticsProperties.getToggleableState();
        customActions$delegate = SemanticsActions.INSTANCE.getCustomActions();
    }

    private static final <T extends g<? extends Boolean>> SemanticsPropertyKey<AccessibilityAction<T>> ActionPropertyKey(String str) {
        return new SemanticsPropertyKey<>(str, AnonymousClass1.INSTANCE);
    }

    public static final void collapse(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCollapse(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void collapse$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        collapse(semanticsPropertyReceiver, str, aVar);
    }

    public static final void copyText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCopyText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void copyText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        copyText(semanticsPropertyReceiver, str, aVar);
    }

    public static final void cutText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getCutText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void cutText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        cutText(semanticsPropertyReceiver, str, aVar);
    }

    public static final void dialog(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsDialog(), k0.f35197a);
    }

    public static final void disabled(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getDisabled(), k0.f35197a);
    }

    public static final void dismiss(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getDismiss(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void dismiss$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        dismiss(semanticsPropertyReceiver, str, aVar);
    }

    public static final void error(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String description) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(description, "description");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getError(), description);
    }

    public static final void expand(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getExpand(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void expand$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        expand(semanticsPropertyReceiver, str, aVar);
    }

    @NotNull
    public static final CollectionInfo getCollectionInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (CollectionInfo) collectionInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[13]);
    }

    @NotNull
    public static final CollectionItemInfo getCollectionItemInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (CollectionItemInfo) collectionItemInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[14]);
    }

    @NotNull
    public static final String getContentDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (String) throwSemanticsGetNotSupported();
    }

    @NotNull
    public static final List<CustomAccessibilityAction> getCustomActions(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (List) customActions$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[16]);
    }

    @NotNull
    public static final AnnotatedString getEditableText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (AnnotatedString) editableText$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[9]);
    }

    public static final boolean getFocused(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((Boolean) focused$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[4])).booleanValue();
    }

    @NotNull
    public static final ScrollAxisRange getHorizontalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (ScrollAxisRange) horizontalScrollAxisRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[5]);
    }

    public static final int getImeAction(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((ImeAction) imeAction$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[11])).m3462unboximpl();
    }

    public static final int getLiveRegion(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((LiveRegionMode) liveRegion$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[3])).m3224unboximpl();
    }

    @NotNull
    public static final String getPaneTitle(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (String) paneTitle$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[2]);
    }

    @NotNull
    public static final ProgressBarRangeInfo getProgressBarRangeInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (ProgressBarRangeInfo) progressBarRangeInfo$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[1]);
    }

    public static final int getRole(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((Role) role$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[7])).m3233unboximpl();
    }

    public static final boolean getSelected(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((Boolean) selected$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[12])).booleanValue();
    }

    @NotNull
    public static final String getStateDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (String) stateDescription$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[0]);
    }

    @NotNull
    public static final String getTestTag(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (String) testTag$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[8]);
    }

    @NotNull
    public static final AnnotatedString getText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (AnnotatedString) throwSemanticsGetNotSupported();
    }

    public static final void getTextLayoutResult(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable l<? super List<TextLayoutResult>, Boolean> lVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getGetTextLayoutResult(), new AccessibilityAction(str, lVar));
    }

    public static /* synthetic */ void getTextLayoutResult$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        getTextLayoutResult(semanticsPropertyReceiver, str, lVar);
    }

    public static final long getTextSelectionRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return ((TextRange) textSelectionRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[10])).m3339unboximpl();
    }

    @NotNull
    public static final ToggleableState getToggleableState(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (ToggleableState) toggleableState$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[15]);
    }

    @NotNull
    public static final ScrollAxisRange getVerticalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        return (ScrollAxisRange) verticalScrollAxisRange$delegate.getValue(semanticsPropertyReceiver, $$delegatedProperties[6]);
    }

    public static final void heading(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getHeading(), k0.f35197a);
    }

    public static final void indexForKey(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull l<Object, Integer> mapping) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(mapping, "mapping");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIndexForKey(), mapping);
    }

    @ExperimentalComposeUiApi
    public static final void invisibleToUser(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getInvisibleToUser(), k0.f35197a);
    }

    public static final void onClick(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnClick(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void onClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        onClick(semanticsPropertyReceiver, str, aVar);
    }

    public static final void onLongClick(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getOnLongClick(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void onLongClick$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        onLongClick(semanticsPropertyReceiver, str, aVar);
    }

    public static final void password(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getPassword(), k0.f35197a);
    }

    public static final void pasteText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getPasteText(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void pasteText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        pasteText(semanticsPropertyReceiver, str, aVar);
    }

    public static final void popup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getIsPopup(), k0.f35197a);
    }

    public static final void requestFocus(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable h9.a<Boolean> aVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getRequestFocus(), new AccessibilityAction(str, aVar));
    }

    public static /* synthetic */ void requestFocus$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        requestFocus(semanticsPropertyReceiver, str, aVar);
    }

    public static final void scrollBy(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable p<? super Float, ? super Float, Boolean> pVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollBy(), new AccessibilityAction(str, pVar));
    }

    public static /* synthetic */ void scrollBy$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        scrollBy(semanticsPropertyReceiver, str, pVar);
    }

    public static final void scrollToIndex(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @NotNull l<? super Integer, Boolean> action) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(action, "action");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getScrollToIndex(), new AccessibilityAction(str, action));
    }

    public static /* synthetic */ void scrollToIndex$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        scrollToIndex(semanticsPropertyReceiver, str, lVar);
    }

    public static final void selectableGroup(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getSelectableGroup(), k0.f35197a);
    }

    public static final void setCollectionInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull CollectionInfo collectionInfo) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(collectionInfo, "<set-?>");
        collectionInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[13], collectionInfo);
    }

    public static final void setCollectionItemInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull CollectionItemInfo collectionItemInfo) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(collectionItemInfo, "<set-?>");
        collectionItemInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[14], collectionItemInfo);
    }

    public static final void setContentDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String value) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(value, "value");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getContentDescription(), u.e(value));
    }

    public static final void setCustomActions(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull List<CustomAccessibilityAction> list) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(list, "<set-?>");
        customActions$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[16], list);
    }

    public static final void setEditableText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull AnnotatedString annotatedString) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(annotatedString, "<set-?>");
        editableText$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[9], annotatedString);
    }

    public static final void setFocused(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        t.i(semanticsPropertyReceiver, "<this>");
        focused$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[4], Boolean.valueOf(z10));
    }

    public static final void setHorizontalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ScrollAxisRange scrollAxisRange) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(scrollAxisRange, "<set-?>");
        horizontalScrollAxisRange$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[5], scrollAxisRange);
    }

    /* JADX INFO: renamed from: setImeAction-4L7nppU, reason: not valid java name */
    public static final void m3245setImeAction4L7nppU(@NotNull SemanticsPropertyReceiver imeAction, int i10) {
        t.i(imeAction, "$this$imeAction");
        imeAction$delegate.setValue(imeAction, $$delegatedProperties[11], ImeAction.m3456boximpl(i10));
    }

    /* JADX INFO: renamed from: setLiveRegion-hR3wRGc, reason: not valid java name */
    public static final void m3246setLiveRegionhR3wRGc(@NotNull SemanticsPropertyReceiver liveRegion, int i10) {
        t.i(liveRegion, "$this$liveRegion");
        liveRegion$delegate.setValue(liveRegion, $$delegatedProperties[3], LiveRegionMode.m3218boximpl(i10));
    }

    public static final void setPaneTitle(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(str, "<set-?>");
        paneTitle$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[2], str);
    }

    public static final void setProgress(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable l<? super Float, Boolean> lVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetProgress(), new AccessibilityAction(str, lVar));
    }

    public static /* synthetic */ void setProgress$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        setProgress(semanticsPropertyReceiver, str, lVar);
    }

    public static final void setProgressBarRangeInfo(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ProgressBarRangeInfo progressBarRangeInfo) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(progressBarRangeInfo, "<set-?>");
        progressBarRangeInfo$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[1], progressBarRangeInfo);
    }

    /* JADX INFO: renamed from: setRole-kuIjeqM, reason: not valid java name */
    public static final void m3247setRolekuIjeqM(@NotNull SemanticsPropertyReceiver role, int i10) {
        t.i(role, "$this$role");
        role$delegate.setValue(role, $$delegatedProperties[7], Role.m3227boximpl(i10));
    }

    public static final void setSelected(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, boolean z10) {
        t.i(semanticsPropertyReceiver, "<this>");
        selected$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[12], Boolean.valueOf(z10));
    }

    public static final void setSelection(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable q<? super Integer, ? super Integer, ? super Boolean, Boolean> qVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetSelection(), new AccessibilityAction(str, qVar));
    }

    public static /* synthetic */ void setSelection$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, q qVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        setSelection(semanticsPropertyReceiver, str, qVar);
    }

    public static final void setStateDescription(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(str, "<set-?>");
        stateDescription$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[0], str);
    }

    public static final void setTestTag(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull String str) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(str, "<set-?>");
        testTag$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[8], str);
    }

    public static final void setText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull AnnotatedString value) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(value, "value");
        semanticsPropertyReceiver.set(SemanticsProperties.INSTANCE.getText(), u.e(value));
    }

    public static /* synthetic */ void setText$default(SemanticsPropertyReceiver semanticsPropertyReceiver, String str, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        setText(semanticsPropertyReceiver, str, lVar);
    }

    /* JADX INFO: renamed from: setTextSelectionRange-FDrldGo, reason: not valid java name */
    public static final void m3248setTextSelectionRangeFDrldGo(@NotNull SemanticsPropertyReceiver textSelectionRange, long j10) {
        t.i(textSelectionRange, "$this$textSelectionRange");
        textSelectionRange$delegate.setValue(textSelectionRange, $$delegatedProperties[10], TextRange.m3323boximpl(j10));
    }

    public static final void setToggleableState(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ToggleableState toggleableState) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(toggleableState, "<set-?>");
        toggleableState$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[15], toggleableState);
    }

    public static final void setVerticalScrollAxisRange(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @NotNull ScrollAxisRange scrollAxisRange) {
        t.i(semanticsPropertyReceiver, "<this>");
        t.i(scrollAxisRange, "<set-?>");
        verticalScrollAxisRange$delegate.setValue(semanticsPropertyReceiver, $$delegatedProperties[6], scrollAxisRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T throwSemanticsGetNotSupported() {
        throw new UnsupportedOperationException("You cannot retrieve a semantics property directly - use one of the SemanticsConfiguration.getOr* methods instead");
    }

    public static final void setText(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver, @Nullable String str, @Nullable l<? super AnnotatedString, Boolean> lVar) {
        t.i(semanticsPropertyReceiver, "<this>");
        semanticsPropertyReceiver.set(SemanticsActions.INSTANCE.getSetText(), new AccessibilityAction(str, lVar));
    }
}
