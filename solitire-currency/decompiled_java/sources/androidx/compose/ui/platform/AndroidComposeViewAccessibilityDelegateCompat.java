package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;

    @NotNull
    public static final String ClassName = "android.view.View";

    @NotNull
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;

    @NotNull
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;

    @NotNull
    private final android.view.accessibility.AccessibilityManager accessibilityManager;

    @NotNull
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;

    @NotNull
    private final r9.d<v8.k0> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;

    @NotNull
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private int focusedVirtualViewId;

    @NotNull
    private final Handler handler;
    private int hoveredVirtualViewId;

    @NotNull
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;

    @NotNull
    private AccessibilityNodeProviderCompat nodeProvider;

    @NotNull
    private ArraySet<Integer> paneDisplayed;

    @Nullable
    private PendingTextTraversedEvent pendingTextTraversedEvent;

    @NotNull
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;

    @NotNull
    private SemanticsNodeCopy previousSemanticsRoot;

    @Nullable
    private Integer previousTraversedNode;

    @NotNull
    private final List<ScrollObservationScope> scrollObservationScopes;

    @NotNull
    private final Runnable semanticsChangeChecker;

    @NotNull
    private final h9.l<ScrollObservationScope, v8.k0> sendScrollEventIfNeededLambda;

    @NotNull
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;

    @NotNull
    private final AndroidComposeView view;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @RequiresApi(24)
    private static final class Api24Impl {

        @NotNull
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @DoNotInline
        public static final void addSetProgressAction(@NotNull AccessibilityNodeInfoCompat info, @NotNull SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            kotlin.jvm.internal.t.i(info, "info");
            kotlin.jvm.internal.t.i(semanticsNode, "semanticsNode");
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) == null) {
                return;
            }
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.getLabel()));
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @RequiresApi(28)
    private static final class Api28Impl {

        @NotNull
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @DoNotInline
        public static final void setScrollEventDelta(@NotNull AccessibilityEvent event, int i10, int i11) {
            kotlin.jvm.internal.t.i(event, "event");
            event.setScrollDeltaX(i10);
            event.setScrollDeltaY(i11);
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i10, @NotNull AccessibilityNodeInfo info, @NotNull String extraDataKey, @Nullable Bundle bundle) {
            kotlin.jvm.internal.t.i(info, "info");
            kotlin.jvm.internal.t.i(extraDataKey, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i10, info, extraDataKey, bundle);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        @Nullable
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i10) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(i10);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i10, int i11, @Nullable Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(i10, i11, bundle);
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    private static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;

        @NotNull
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(@NotNull SemanticsNode node, int i10, int i11, int i12, int i13, long j10) {
            kotlin.jvm.internal.t.i(node, "node");
            this.node = node;
            this.action = i10;
            this.granularity = i11;
            this.fromIndex = i12;
            this.toIndex = i13;
            this.traverseTime = j10;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        @NotNull
        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @VisibleForTesting
    public static final class SemanticsNodeCopy {

        @NotNull
        private final Set<Integer> children;

        @NotNull
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(@NotNull SemanticsNode semanticsNode, @NotNull Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes) {
            kotlin.jvm.internal.t.i(semanticsNode, "semanticsNode");
            kotlin.jvm.internal.t.i(currentSemanticsNodes, "currentSemanticsNodes");
            this.unmergedConfig = semanticsNode.getUnmergedConfig$ui_release();
            this.children = new LinkedHashSet();
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i10 = 0; i10 < size; i10++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i10);
                if (currentSemanticsNodes.containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                    this.children.add(Integer.valueOf(semanticsNode2.getId()));
                }
            }
        }

        @NotNull
        public final Set<Integer> getChildren() {
            return this.children;
        }

        @NotNull
        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat", f = "AndroidComposeViewAccessibilityDelegateCompat.android.kt", l = {1637, 1666}, m = "boundsUpdatesEventLoop")
    static final class C10011 extends kotlin.coroutines.jvm.internal.d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C10011(z8.d<? super C10011> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AndroidComposeViewAccessibilityDelegateCompat.this.boundsUpdatesEventLoop(this);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    static final class C10021 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
        final /* synthetic */ ScrollObservationScope $scrollObservationScope;
        final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10021(ScrollObservationScope scrollObservationScope, AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
            super(0);
            this.$scrollObservationScope = scrollObservationScope;
            this.this$0 = androidComposeViewAccessibilityDelegateCompat;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ v8.k0 invoke() {
            invoke2();
            return v8.k0.f35197a;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void invoke2() {
            /*
                Method dump skipped, instruction units count: 256
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.C10021.invoke2():void");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
    static final class C10031 extends kotlin.jvm.internal.v implements h9.l<LayoutNode, Boolean> {
        public static final C10031 INSTANCE = new C10031();

        C10031() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final Boolean invoke(@NotNull LayoutNode it) {
            SemanticsConfiguration semanticsConfigurationCollapsedSemanticsConfiguration;
            kotlin.jvm.internal.t.i(it, "it");
            SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(it);
            boolean z10 = false;
            if (outerSemantics != null && (semanticsConfigurationCollapsedSemanticsConfiguration = outerSemantics.collapsedSemanticsConfiguration()) != null && semanticsConfigurationCollapsedSemanticsConfiguration.isMergingSemanticsOfDescendants()) {
                z10 = true;
            }
            return Boolean.valueOf(z10);
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(@NotNull AndroidComposeView view) {
        kotlin.jvm.internal.t.i(view, "view");
        this.view = view;
        this.hoveredVirtualViewId = Integer.MIN_VALUE;
        Object systemService = view.getContext().getSystemService("accessibility");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        }
        this.accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = r9.g.b(-1, null, null, 6, null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = kotlin.collections.r0.g();
        this.paneDisplayed = new ArraySet<>();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(view.getSemanticsOwner().getUnmergedRootSemanticsNode(), kotlin.collections.r0.g());
        view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@NotNull View view2) {
                kotlin.jvm.internal.t.i(view2, "view");
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@NotNull View view2) {
                kotlin.jvm.internal.t.i(view2, "view");
                AndroidComposeViewAccessibilityDelegateCompat.this.handler.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.semanticsChangeChecker);
            }
        });
        this.semanticsChangeChecker = new Runnable() { // from class: androidx.compose.ui.platform.i
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.m3161semanticsChangeChecker$lambda26(this.f804a);
            }
        };
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i10, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        String str2;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i10));
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) == null) {
            return;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult()) || bundle == null || !kotlin.jvm.internal.t.d(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            SemanticsConfiguration unmergedConfig$ui_release2 = semanticsNode.getUnmergedConfig$ui_release();
            SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
            if (!unmergedConfig$ui_release2.contains(semanticsProperties.getTestTag()) || bundle == null || !kotlin.jvm.internal.t.d(str, ExtraDataTestTagKey) || (str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getTestTag())) == null) {
                return;
            }
            accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
            return;
        }
        int i11 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i12 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i12 > 0 && i11 >= 0) {
            if (i11 < (iterableTextForAccessibility != null ? iterableTextForAccessibility.length() : Integer.MAX_VALUE)) {
                ArrayList arrayList = new ArrayList();
                h9.l lVar = (h9.l) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
                if (kotlin.jvm.internal.t.d(lVar != null ? (Boolean) lVar.invoke(arrayList) : null, Boolean.TRUE)) {
                    TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                    ArrayList arrayList2 = new ArrayList();
                    for (int i13 = 0; i13 < i12; i13++) {
                        int i14 = i11 + i13;
                        if (i14 >= textLayoutResult.getLayoutInput().getText().length()) {
                            arrayList2.add(null);
                        } else {
                            arrayList2.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i14)));
                        }
                    }
                    Bundle extras = accessibilityNodeInfo.getExtras();
                    Object[] array = arrayList2.toArray(new RectF[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    }
                    extras.putParcelableArray(str, (Parcelable[]) array);
                    return;
                }
                return;
            }
        }
        Log.e(LogTag, "Invalid arguments for accessibility character locations");
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final boolean clearAccessibilityFocus(int i10) {
        if (!isAccessibilityFocused(i10)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i10, 65536, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AccessibilityNodeInfo createNodeInfo(int i10) {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.view.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.DESTROYED) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatObtain = AccessibilityNodeInfoCompat.obtain();
        kotlin.jvm.internal.t.h(accessibilityNodeInfoCompatObtain, "obtain()");
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i10));
        if (semanticsNodeWithAdjustedBounds == null) {
            accessibilityNodeInfoCompatObtain.recycle();
            return null;
        }
        SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode();
        if (i10 == -1) {
            Object parentForAccessibility = ViewCompat.getParentForAccessibility(this.view);
            accessibilityNodeInfoCompatObtain.setParent(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            if (semanticsNode.getParent() == null) {
                throw new IllegalStateException("semanticsNode " + i10 + " has null parent");
            }
            SemanticsNode parent = semanticsNode.getParent();
            kotlin.jvm.internal.t.f(parent);
            int id = parent.getId();
            accessibilityNodeInfoCompatObtain.setParent(this.view, id != this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId() ? id : -1);
        }
        accessibilityNodeInfoCompatObtain.setSource(this.view, i10);
        Rect adjustedBounds = semanticsNodeWithAdjustedBounds.getAdjustedBounds();
        long jMo2940localToScreenMKHz9U = this.view.mo2940localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.left, adjustedBounds.top));
        long jMo2940localToScreenMKHz9U2 = this.view.mo2940localToScreenMKHz9U(OffsetKt.Offset(adjustedBounds.right, adjustedBounds.bottom));
        accessibilityNodeInfoCompatObtain.setBoundsInScreen(new Rect((int) Math.floor(Offset.m1367getXimpl(jMo2940localToScreenMKHz9U)), (int) Math.floor(Offset.m1368getYimpl(jMo2940localToScreenMKHz9U)), (int) Math.ceil(Offset.m1367getXimpl(jMo2940localToScreenMKHz9U2)), (int) Math.ceil(Offset.m1368getYimpl(jMo2940localToScreenMKHz9U2))));
        populateAccessibilityNodeInfoProperties(i10, accessibilityNodeInfoCompatObtain, semanticsNode);
        return accessibilityNodeInfoCompatObtain.unwrap();
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i10, Integer num, Integer num2, Integer num3, String str) {
        AccessibilityEvent accessibilityEventCreateEvent$ui_release = createEvent$ui_release(i10, 8192);
        if (num != null) {
            accessibilityEventCreateEvent$ui_release.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventCreateEvent$ui_release.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventCreateEvent$ui_release.setItemCount(num3.intValue());
        }
        if (str != null) {
            accessibilityEventCreateEvent$ui_release.getText().add(str);
        }
        return accessibilityEventCreateEvent$ui_release;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.m3330getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).m3339unboximpl());
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) ? this.accessibilityCursorPosition : TextRange.m3335getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).m3339unboximpl());
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesInvalidated = false;
        }
        return this.currentSemanticsNodes;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getContentDescription()), ",", null, null, 0, null, null, 62, null);
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getText());
        if (list == null || (annotatedString = (AnnotatedString) kotlin.collections.d0.k0(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i10) {
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) {
            return null;
        }
        if (i10 == 1) {
            AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion;
            Locale locale = this.view.getContext().getResources().getConfiguration().locale;
            kotlin.jvm.internal.t.h(locale, "view.context.resources.configuration.locale");
            AccessibilityIterators.CharacterTextSegmentIterator companion2 = companion.getInstance(locale);
            companion2.initialize(iterableTextForAccessibility);
            return companion2;
        }
        if (i10 == 2) {
            AccessibilityIterators.WordTextSegmentIterator.Companion companion3 = AccessibilityIterators.WordTextSegmentIterator.Companion;
            Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
            kotlin.jvm.internal.t.h(locale2, "view.context.resources.configuration.locale");
            AccessibilityIterators.WordTextSegmentIterator companion4 = companion3.getInstance(locale2);
            companion4.initialize(iterableTextForAccessibility);
            return companion4;
        }
        if (i10 != 4) {
            if (i10 == 8) {
                AccessibilityIterators.ParagraphTextSegmentIterator companion5 = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                companion5.initialize(iterableTextForAccessibility);
                return companion5;
            }
            if (i10 != 16) {
                return null;
            }
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        h9.l lVar = (h9.l) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
        if (!kotlin.jvm.internal.t.d(lVar != null ? (Boolean) lVar.invoke(arrayList) : null, Boolean.TRUE)) {
            return null;
        }
        TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
        if (i10 == 4) {
            AccessibilityIterators.LineTextSegmentIterator companion6 = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
            companion6.initialize(iterableTextForAccessibility, textLayoutResult);
            return companion6;
        }
        AccessibilityIterators.PageTextSegmentIterator companion7 = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
        companion7.initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
        return companion7;
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    private final boolean isAccessibilityEnabled() {
        return this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled());
    }

    private final boolean isAccessibilityFocused(int i10) {
        return this.focusedVirtualViewId == i10;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        return !unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getEditableText());
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.f(v8.k0.f35197a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v38 */
    /* JADX WARN: Type inference failed for: r13v61 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v43 */
    /* JADX WARN: Type inference failed for: r14v44 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x00e6 -> B:59:0x00e7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:59:0x00e7
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final boolean performActionHelper(int r13, int r14, android.os.Bundle r15) {
        /*
            Method dump skipped, instruction units count: 1444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f10) {
        return (f10 < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f10 > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f10, float f11) {
        if (Math.signum(f10) == Math.signum(f11)) {
            return Math.abs(f10) < Math.abs(f11) ? f10 : f11;
        }
        return 0.0f;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private final boolean registerScrollingId(int i10, List<ScrollObservationScope> list) {
        boolean z10;
        ScrollObservationScope scrollObservationScopeFindById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(list, i10);
        if (scrollObservationScopeFindById != null) {
            z10 = false;
        } else {
            scrollObservationScopeFindById = new ScrollObservationScope(i10, this.scrollObservationScopes, null, null, null, null);
            z10 = true;
        }
        this.scrollObservationScopes.add(scrollObservationScopeFindById);
        return z10;
    }

    private final boolean requestAccessibilityFocus(int i10) {
        if (!isAccessibilityEnabled() || isAccessibilityFocused(i10)) {
            return false;
        }
        int i11 = this.focusedVirtualViewId;
        if (i11 != Integer.MIN_VALUE) {
            sendEventForVirtualView$default(this, i11, 65536, null, null, 12, null);
        }
        this.focusedVirtualViewId = i10;
        this.view.invalidate();
        sendEventForVirtualView$default(this, i10, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: semanticsChangeChecker$lambda-26, reason: not valid java name */
    public static final void m3161semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        androidx.compose.ui.node.b.d(this$0.view, false, 1, null);
        this$0.checkForSemanticsChanges();
        this$0.checkingForSemanticsChanges = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i10) {
        if (i10 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (isAccessibilityEnabled()) {
            return this.view.getParent().requestSendAccessibilityEvent(this.view, accessibilityEvent);
        }
        return false;
    }

    private final boolean sendEventForVirtualView(int i10, int i11, Integer num, List<String> list) {
        if (i10 == Integer.MIN_VALUE || !isAccessibilityEnabled()) {
            return false;
        }
        AccessibilityEvent accessibilityEventCreateEvent$ui_release = createEvent$ui_release(i10, i11);
        if (num != null) {
            accessibilityEventCreateEvent$ui_release.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventCreateEvent$ui_release.setContentDescription(TempListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null));
        }
        return sendEvent(accessibilityEventCreateEvent$ui_release);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ boolean sendEventForVirtualView$default(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i10, int i11, Integer num, List list, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            num = null;
        }
        if ((i12 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i10, i11, num, list);
    }

    private final void sendPaneChangeEvents(int i10, int i11, String str) {
        AccessibilityEvent accessibilityEventCreateEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(i10), 32);
        accessibilityEventCreateEvent$ui_release.setContentChangeTypes(i11);
        if (str != null) {
            accessibilityEventCreateEvent$ui_release.getText().add(str);
        }
        sendEvent(accessibilityEventCreateEvent$ui_release);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i10) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent != null) {
            if (i10 != pendingTextTraversedEvent.getNode().getId()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.getTraverseTime() <= 1000) {
                AccessibilityEvent accessibilityEventCreateEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent.getNode().getId()), 131072);
                accessibilityEventCreateEvent$ui_release.setFromIndex(pendingTextTraversedEvent.getFromIndex());
                accessibilityEventCreateEvent$ui_release.setToIndex(pendingTextTraversedEvent.getToIndex());
                accessibilityEventCreateEvent$ui_release.setAction(pendingTextTraversedEvent.getAction());
                accessibilityEventCreateEvent$ui_release.setMovementGranularity(pendingTextTraversedEvent.getGranularity());
                accessibilityEventCreateEvent$ui_release.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent.getNode()));
                sendEvent(accessibilityEventCreateEvent$ui_release);
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValid()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new C10021(scrollObservationScope, this));
        }
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i10 = 0; i10 < size; i10++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i10);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                if (!semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                linkedHashSet.add(Integer.valueOf(semanticsNode2.getId()));
            }
        }
        Iterator<Integer> it = semanticsNodeCopy.getChildren().iterator();
        while (it.hasNext()) {
            if (!linkedHashSet.contains(Integer.valueOf(it.next().intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                return;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i11);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.getId()));
                kotlin.jvm.internal.t.f(semanticsNodeCopy2);
                sendSemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> arraySet) {
        LayoutNode layoutNodeFindClosestParentNode;
        SemanticsEntity outerSemantics;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            SemanticsEntity outerSemantics2 = SemanticsNodeKt.getOuterSemantics(layoutNode);
            if (outerSemantics2 == null) {
                LayoutNode layoutNodeFindClosestParentNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1.INSTANCE);
                outerSemantics2 = layoutNodeFindClosestParentNode2 != null ? SemanticsNodeKt.getOuterSemantics(layoutNodeFindClosestParentNode2) : null;
                if (outerSemantics2 == null) {
                    return;
                }
            }
            if (!outerSemantics2.collapsedSemanticsConfiguration().isMergingSemanticsOfDescendants() && (layoutNodeFindClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, C10031.INSTANCE)) != null && (outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNodeFindClosestParentNode)) != null) {
                outerSemantics2 = outerSemantics;
            }
            int id = outerSemantics2.getModifier().getId();
            if (arraySet.add(Integer.valueOf(id))) {
                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(id), 2048, 1, null, 8, null);
            }
        }
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i10, int i11, boolean z10) {
        String iterableTextForAccessibility;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsActions.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            h9.q qVar = (h9.q) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getSetSelection())).getAction();
            if (qVar != null) {
                return ((Boolean) qVar.invoke(Integer.valueOf(i10), Integer.valueOf(i11), Boolean.valueOf(z10))).booleanValue();
            }
            return false;
        }
        if ((i10 == i11 && i11 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        }
        if (i10 < 0 || i10 != i11 || i11 > iterableTextForAccessibility.length()) {
            i10 = -1;
        }
        this.accessibilityCursorPosition = i10;
        boolean z11 = iterableTextForAccessibility.length() > 0;
        sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), z11 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z11 ? Integer.valueOf(this.accessibilityCursorPosition) : null, z11 ? Integer.valueOf(iterableTextForAccessibility.length()) : null, iterableTextForAccessibility));
        sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
        return true;
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getError()));
        }
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        SpannableString accessibilitySpannableString = null;
        SpannableString spannableString = (SpannableString) trimToSize(textForTextField != null ? AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver) : null, 100000);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (list != null && (annotatedString = (AnnotatedString) kotlin.collections.d0.k0(list)) != null) {
            accessibilitySpannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver);
        }
        SpannableString spannableString2 = (SpannableString) trimToSize(accessibilitySpannableString, 100000);
        if (spannableString == null) {
            spannableString = spannableString2;
        }
        accessibilityNodeInfoCompat.setText(spannableString);
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect rectM1404translatek4lQ0M = rect.m1404translatek4lQ0M(semanticsNode.m3241getPositionInRootF1C5BW0());
        androidx.compose.ui.geometry.Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        androidx.compose.ui.geometry.Rect rectIntersect = rectM1404translatek4lQ0M.overlaps(boundsInRoot) ? rectM1404translatek4lQ0M.intersect(boundsInRoot) : null;
        if (rectIntersect == null) {
            return null;
        }
        long jMo2940localToScreenMKHz9U = this.view.mo2940localToScreenMKHz9U(OffsetKt.Offset(rectIntersect.getLeft(), rectIntersect.getTop()));
        long jMo2940localToScreenMKHz9U2 = this.view.mo2940localToScreenMKHz9U(OffsetKt.Offset(rectIntersect.getRight(), rectIntersect.getBottom()));
        return new RectF(Offset.m1367getXimpl(jMo2940localToScreenMKHz9U), Offset.m1368getYimpl(jMo2940localToScreenMKHz9U), Offset.m1367getXimpl(jMo2940localToScreenMKHz9U2), Offset.m1368getYimpl(jMo2940localToScreenMKHz9U2));
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i10, boolean z10, boolean z11) {
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int accessibilitySelectionStart;
        int i11;
        int id = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if ((iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i10)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            accessibilitySelectionEnd = z10 ? 0 : iterableTextForAccessibility.length();
        }
        int[] iArrFollowing = z10 ? iteratorForGranularity.following(accessibilitySelectionEnd) : iteratorForGranularity.preceding(accessibilitySelectionEnd);
        if (iArrFollowing == null) {
            return false;
        }
        int i12 = iArrFollowing[0];
        int i13 = iArrFollowing[1];
        if (z11 && isAccessibilitySelectionExtendable(semanticsNode)) {
            accessibilitySelectionStart = getAccessibilitySelectionStart(semanticsNode);
            if (accessibilitySelectionStart == -1) {
                accessibilitySelectionStart = z10 ? i12 : i13;
            }
            i11 = z10 ? i13 : i12;
        } else {
            accessibilitySelectionStart = z10 ? i13 : i12;
            i11 = accessibilitySelectionStart;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, z10 ? 256 : 512, i10, i12, i13, SystemClock.uptimeMillis());
        setAccessibilitySelection(semanticsNode, accessibilitySelectionStart, i11, true);
        return true;
    }

    private final <T extends CharSequence> T trimToSize(T t10, @IntRange(from = 1) int i10) {
        boolean z10 = true;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (t10 != null && t10.length() != 0) {
            z10 = false;
        }
        if (z10 || t10.length() <= i10) {
            return t10;
        }
        int i11 = i10 - 1;
        if (Character.isHighSurrogate(t10.charAt(i11)) && Character.isLowSurrogate(t10.charAt(i10))) {
            i10 = i11;
        }
        return (T) t10.subSequence(0, i10);
    }

    private final void updateHoveredVirtualView(int i10) {
        int i11 = this.hoveredVirtualViewId;
        if (i11 == i10) {
            return;
        }
        this.hoveredVirtualViewId = i10;
        sendEventForVirtualView$default(this, i10, 128, null, null, 12, null);
        sendEventForVirtualView$default(this, i11, 256, null, null, 12, null);
    }

    private final void updateSemanticsNodesCopyAndPanes() {
        SemanticsConfiguration unmergedConfig;
        for (Integer id : this.paneDisplayed) {
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(id);
            String str = null;
            SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
            if (semanticsNode == null || !AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(semanticsNode)) {
                this.paneDisplayed.remove(id);
                kotlin.jvm.internal.t.h(id, "id");
                int iIntValue = id.intValue();
                SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(id);
                if (semanticsNodeCopy != null && (unmergedConfig = semanticsNodeCopy.getUnmergedConfig()) != null) {
                    str = (String) SemanticsConfigurationKt.getOrNull(unmergedConfig, SemanticsProperties.INSTANCE.getPaneTitle());
                }
                sendPaneChangeEvents(iIntValue, 32, str);
            }
        }
        this.previousSemanticsNodes.clear();
        for (Map.Entry<Integer, SemanticsNodeWithAdjustedBounds> entry : getCurrentSemanticsNodes().entrySet()) {
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(entry.getValue().getSemanticsNode()) && this.paneDisplayed.add(entry.getKey())) {
                sendPaneChangeEvents(entry.getKey().intValue(), 16, (String) entry.getValue().getSemanticsNode().getUnmergedConfig$ui_release().get(SemanticsProperties.INSTANCE.getPaneTitle()));
            }
            this.previousSemanticsNodes.put(entry.getKey(), new SemanticsNodeCopy(entry.getValue().getSemanticsNode(), getCurrentSemanticsNodes()));
        }
        this.previousSemanticsRoot = new SemanticsNodeCopy(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), getCurrentSemanticsNodes());
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007d A[Catch: all -> 0x0051, TryCatch #0 {all -> 0x0051, blocks: (B:13:0x0034, B:25:0x0063, B:29:0x0075, B:31:0x007d, B:33:0x0086, B:35:0x008f, B:36:0x00a0, B:38:0x00a7, B:39:0x00b0, B:18:0x004d), top: B:48:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00c3 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object boundsUpdatesEventLoop(@org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r11) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: canScroll-0AR0LA0$ui_release, reason: not valid java name */
    public final boolean m3162canScroll0AR0LA0$ui_release(boolean z10, int i10, long j10) {
        return m3163canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), z10, i10, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    /* JADX INFO: renamed from: canScroll-moWRBKg$ui_release, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m3163canScrollmoWRBKg$ui_release(@org.jetbrains.annotations.NotNull java.util.Collection<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r6, boolean r7, int r8, long r9) {
        /*
            r5 = this;
            java.lang.String r0 = "currentSemanticsNodes"
            kotlin.jvm.internal.t.i(r6, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m1382getUnspecifiedF1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m1364equalsimpl0(r9, r0)
            r1 = 0
            if (r0 != 0) goto Lbd
            boolean r0 = androidx.compose.ui.geometry.Offset.m1370isValidimpl(r9)
            if (r0 != 0) goto L1a
            goto Lbd
        L1a:
            r0 = 1
            if (r7 != r0) goto L24
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getVerticalScrollAxisRange()
            goto L2c
        L24:
            if (r7 != 0) goto Lb7
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getHorizontalScrollAxisRange()
        L2c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L39
            goto Lb6
        L39:
            java.util.Iterator r6 = r6.iterator()
        L3d:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto Lb6
            java.lang.Object r2 = r6.next()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            android.graphics.Rect r3 = r2.getAdjustedBounds()
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.graphics.RectHelper_androidKt.toComposeRect(r3)
            boolean r3 = r3.m1393containsk4lQ0M(r9)
            if (r3 != 0) goto L59
        L57:
            r2 = r1
            goto Lb3
        L59:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getConfig()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r7)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 != 0) goto L6a
            goto L57
        L6a:
            boolean r3 = r2.getReverseScrolling()
            if (r3 == 0) goto L72
            int r3 = -r8
            goto L73
        L72:
            r3 = r8
        L73:
            if (r8 != 0) goto L7c
            boolean r4 = r2.getReverseScrolling()
            if (r4 == 0) goto L7c
            r3 = -1
        L7c:
            if (r3 >= 0) goto L92
            h9.a r2 = r2.getValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L57
            goto Lb2
        L92:
            h9.a r3 = r2.getValue()
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            h9.a r2 = r2.getMaxValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L57
        Lb2:
            r2 = r0
        Lb3:
            if (r2 == 0) goto L3d
            r1 = r0
        Lb6:
            return r1
        Lb7:
            v8.q r6 = new v8.q
            r6.<init>()
            throw r6
        Lbd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m3163canScrollmoWRBKg$ui_release(java.util.Collection, boolean, int, long):boolean");
    }

    @VisibleForTesting
    @NotNull
    public final AccessibilityEvent createEvent$ui_release(int i10, int i11) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i11);
        kotlin.jvm.internal.t.h(accessibilityEventObtain, "obtain(eventType)");
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName(ClassName);
        accessibilityEventObtain.setPackageName(this.view.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.view, i10);
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i10));
        if (semanticsNodeWithAdjustedBounds != null) {
            accessibilityEventObtain.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode()));
        }
        return accessibilityEventObtain;
    }

    public final boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (!isAccessibilityEnabled()) {
            return false;
        }
        int action = event.getAction();
        if (action == 7 || action == 9) {
            int iHitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(event.getX(), event.getY());
            boolean zDispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
            updateHoveredVirtualView(iHitTestSemanticsAt$ui_release);
            if (iHitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
            return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(event);
        }
        updateHoveredVirtualView(Integer.MIN_VALUE);
        return true;
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    @NotNull
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NotNull View host) {
        kotlin.jvm.internal.t.i(host, "host");
        return this.nodeProvider;
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    @NotNull
    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    @NotNull
    public final AndroidComposeView getView() {
        return this.view;
    }

    @VisibleForTesting
    public final int hitTestSemanticsAt$ui_release(float f10, float f11) {
        LayoutNode layoutNode;
        SemanticsEntity outerSemantics = null;
        androidx.compose.ui.node.b.d(this.view, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        this.view.getRoot().m3101hitTestSemanticsM_7yMNQ$ui_release(OffsetKt.Offset(f10, f11), hitTestResult, (12 & 4) != 0, (12 & 8) != 0);
        SemanticsEntity semanticsEntity = (SemanticsEntity) kotlin.collections.d0.u0(hitTestResult);
        if (semanticsEntity != null && (layoutNode = semanticsEntity.getLayoutNode()) != null) {
            outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
        }
        if (outerSemantics != null) {
            SemanticsNode semanticsNode = new SemanticsNode(outerSemantics, false);
            LayoutNodeWrapper layoutNodeWrapperFindWrapperToGetBounds$ui_release = semanticsNode.findWrapperToGetBounds$ui_release();
            if (!semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) && !layoutNodeWrapperFindWrapperToGetBounds$ui_release.isTransparent() && this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(outerSemantics.getLayoutNode()) == null) {
                return semanticsNodeIdToAccessibilityVirtualNodeId(outerSemantics.getModifier().getId());
            }
        }
        return Integer.MIN_VALUE;
    }

    public final void onLayoutChange$ui_release(@NotNull LayoutNode layoutNode) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (!isAccessibilityEnabled() || this.checkingForSemanticsChanges) {
            return;
        }
        this.checkingForSemanticsChanges = true;
        this.handler.post(this.semanticsChangeChecker);
    }

    @VisibleForTesting
    public final void populateAccessibilityNodeInfoProperties(int i10, @NotNull AccessibilityNodeInfoCompat info, @NotNull SemanticsNode semanticsNode) {
        LayoutNodeWrapper layoutNodeWrapperFindWrapperToGetBounds$ui_release;
        int iN;
        boolean zBooleanValue;
        kotlin.jvm.internal.t.i(info, "info");
        kotlin.jvm.internal.t.i(semanticsNode, "semanticsNode");
        info.setClassName(ClassName);
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getRole());
        if (role != null) {
            int iM3233unboximpl = role.m3233unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                Role.Companion companion = Role.Companion;
                if (Role.m3230equalsimpl0(role.m3233unboximpl(), companion.m3239getTabo7Vup1c())) {
                    info.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    String str = Role.m3230equalsimpl0(iM3233unboximpl, companion.m3234getButtono7Vup1c()) ? "android.widget.Button" : Role.m3230equalsimpl0(iM3233unboximpl, companion.m3235getCheckboxo7Vup1c()) ? "android.widget.CheckBox" : Role.m3230equalsimpl0(iM3233unboximpl, companion.m3238getSwitcho7Vup1c()) ? "android.widget.Switch" : Role.m3230equalsimpl0(iM3233unboximpl, companion.m3237getRadioButtono7Vup1c()) ? "android.widget.RadioButton" : Role.m3230equalsimpl0(iM3233unboximpl, companion.m3236getImageo7Vup1c()) ? "android.widget.ImageView" : null;
                    if (!Role.m3230equalsimpl0(role.m3233unboximpl(), companion.m3236getImageo7Vup1c()) || AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$1$ancestor$1.INSTANCE) == null || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                        info.setClassName(str);
                    }
                }
            }
            v8.k0 k0Var = v8.k0.f35197a;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            info.setClassName("android.widget.EditText");
        }
        if (semanticsNode.getConfig().contains(semanticsProperties.getText())) {
            info.setClassName("android.widget.TextView");
        }
        info.setPackageName(this.view.getContext().getPackageName());
        List<SemanticsNode> replacedChildrenSortedByBounds$ui_release = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
        int size = replacedChildrenSortedByBounds$ui_release.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            SemanticsNode semanticsNode2 = replacedChildrenSortedByBounds$ui_release.get(i12);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode2.getLayoutNode$ui_release());
                if (androidViewHolder != null) {
                    info.addChild(androidViewHolder);
                } else {
                    info.addChild(this.view, semanticsNode2.getId());
                }
            }
        }
        if (this.focusedVirtualViewId == i10) {
            info.setAccessibilityFocused(true);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            info.setAccessibilityFocused(false);
            info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode, info);
        setContentInvalid(semanticsNode, info);
        SemanticsConfiguration unmergedConfig$ui_release2 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
        info.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release2, semanticsProperties2.getStateDescription()));
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getToggleableState());
        if (toggleableState != null) {
            info.setCheckable(true);
            int i13 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i13 == 1) {
                info.setChecked(true);
                if ((role == null ? false : Role.m3230equalsimpl0(role.m3233unboximpl(), Role.Companion.m3238getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                    info.setStateDescription(this.view.getContext().getResources().getString(R.string.on));
                }
            } else if (i13 == 2) {
                info.setChecked(false);
                if ((role == null ? false : Role.m3230equalsimpl0(role.m3233unboximpl(), Role.Companion.m3238getSwitcho7Vup1c())) && info.getStateDescription() == null) {
                    info.setStateDescription(this.view.getContext().getResources().getString(R.string.off));
                }
            } else if (i13 == 3 && info.getStateDescription() == null) {
                info.setStateDescription(this.view.getContext().getResources().getString(R.string.indeterminate));
            }
            v8.k0 k0Var2 = v8.k0.f35197a;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getSelected());
        if (bool != null) {
            boolean zBooleanValue2 = bool.booleanValue();
            if (role == null ? false : Role.m3230equalsimpl0(role.m3233unboximpl(), Role.Companion.m3239getTabo7Vup1c())) {
                info.setSelected(zBooleanValue2);
            } else {
                info.setCheckable(true);
                info.setChecked(zBooleanValue2);
                if (info.getStateDescription() == null) {
                    info.setStateDescription(zBooleanValue2 ? this.view.getContext().getResources().getString(R.string.selected) : this.view.getContext().getResources().getString(R.string.not_selected));
                }
            }
            v8.k0 k0Var3 = v8.k0.f35197a;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getContentDescription());
            info.setContentDescription(list != null ? (String) kotlin.collections.d0.k0(list) : null);
        }
        if (semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
            info.setScreenReaderFocusable(true);
        }
        String str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getTestTag());
        if (str2 != null) {
            SemanticsNode parent = semanticsNode;
            while (true) {
                if (parent == null) {
                    zBooleanValue = false;
                    break;
                }
                SemanticsConfiguration unmergedConfig$ui_release3 = parent.getUnmergedConfig$ui_release();
                SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.INSTANCE;
                if (unmergedConfig$ui_release3.contains(semanticsPropertiesAndroid.getTestTagsAsResourceId())) {
                    zBooleanValue = ((Boolean) parent.getUnmergedConfig$ui_release().get(semanticsPropertiesAndroid.getTestTagsAsResourceId())).booleanValue();
                    break;
                }
                parent = parent.getParent();
            }
            if (zBooleanValue) {
                info.setViewIdResourceName(str2);
            }
        }
        SemanticsConfiguration unmergedConfig$ui_release4 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties3 = SemanticsProperties.INSTANCE;
        if (((v8.k0) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release4, semanticsProperties3.getHeading())) != null) {
            info.setHeading(true);
            v8.k0 k0Var4 = v8.k0.f35197a;
        }
        info.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode));
        info.setEditable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode));
        info.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        info.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties3.getFocused()));
        if (info.isFocusable()) {
            info.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties3.getFocused())).booleanValue());
            if (info.isFocused()) {
                info.addAction(2);
            } else {
                info.addAction(1);
            }
        }
        if (semanticsNode.isFake$ui_release()) {
            SemanticsNode parent2 = semanticsNode.getParent();
            layoutNodeWrapperFindWrapperToGetBounds$ui_release = parent2 != null ? parent2.findWrapperToGetBounds$ui_release() : null;
        } else {
            layoutNodeWrapperFindWrapperToGetBounds$ui_release = semanticsNode.findWrapperToGetBounds$ui_release();
        }
        info.setVisibleToUser(!(layoutNodeWrapperFindWrapperToGetBounds$ui_release != null ? layoutNodeWrapperFindWrapperToGetBounds$ui_release.isTransparent() : false) && SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getInvisibleToUser()) == null);
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getLiveRegion());
        if (liveRegionMode != null) {
            int iM3224unboximpl = liveRegionMode.m3224unboximpl();
            LiveRegionMode.Companion companion2 = LiveRegionMode.Companion;
            info.setLiveRegion((LiveRegionMode.m3221equalsimpl0(iM3224unboximpl, companion2.m3226getPolite0phEisY()) || !LiveRegionMode.m3221equalsimpl0(iM3224unboximpl, companion2.m3225getAssertive0phEisY())) ? 1 : 2);
            v8.k0 k0Var5 = v8.k0.f35197a;
        }
        info.setClickable(false);
        SemanticsConfiguration unmergedConfig$ui_release5 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release5, semanticsActions.getOnClick());
        if (accessibilityAction != null) {
            boolean zD = kotlin.jvm.internal.t.d(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getSelected()), Boolean.TRUE);
            info.setClickable(!zD);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !zD) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            v8.k0 k0Var6 = v8.k0.f35197a;
        }
        info.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getOnLongClick());
        if (accessibilityAction2 != null) {
            info.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            v8.k0 k0Var7 = v8.k0.f35197a;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCopyText());
        if (accessibilityAction3 != null) {
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            v8.k0 k0Var8 = v8.k0.f35197a;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getSetText());
            if (accessibilityAction4 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                v8.k0 k0Var9 = v8.k0.f35197a;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCutText());
            if (accessibilityAction5 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction5.getLabel()));
                v8.k0 k0Var10 = v8.k0.f35197a;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getPasteText());
            if (accessibilityAction6 != null) {
                if (info.isFocused() && this.view.getClipboardManager().hasText()) {
                    info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction6.getLabel()));
                }
                v8.k0 k0Var11 = v8.k0.f35197a;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            info.setTextSelection(getAccessibilitySelectionStart(semanticsNode), getAccessibilitySelectionEnd(semanticsNode));
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getSetSelection());
            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, accessibilityAction7 != null ? accessibilityAction7.getLabel() : null));
            info.addAction(256);
            info.addAction(512);
            info.setMovementGranularities(11);
            List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getContentDescription());
            if ((list2 == null || list2.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                info.setMovementGranularities(info.getMovementGranularities() | 4 | 16);
            }
        }
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 26) {
            ArrayList arrayList = new ArrayList();
            CharSequence text = info.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getGetTextLayoutResult())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties3.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            if (!arrayList.isEmpty()) {
                AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
                AccessibilityNodeInfo accessibilityNodeInfoUnwrap = info.unwrap();
                kotlin.jvm.internal.t.h(accessibilityNodeInfoUnwrap, "info.unwrap()");
                accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(accessibilityNodeInfoUnwrap, arrayList);
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getSetProgress())) {
                info.setClassName("android.widget.SeekBar");
            } else {
                info.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                info.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
                if (info.getStateDescription() == null) {
                    n9.e<Float> range = progressBarRangeInfo.getRange();
                    float fM = n9.o.m(((range.getEndInclusive().floatValue() - range.getStart().floatValue()) > 0.0f ? 1 : ((range.getEndInclusive().floatValue() - range.getStart().floatValue()) == 0.0f ? 0 : -1)) == 0 ? 0.0f : (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue()), 0.0f, 1.0f);
                    if (fM == 0.0f) {
                        iN = 0;
                    } else {
                        iN = 100;
                        if (!(fM == 1.0f)) {
                            iN = n9.o.n(j9.c.c(fM * 100), 1, 99);
                        }
                    }
                    info.setStateDescription(this.view.getContext().getResources().getString(R.string.template_percent, Integer.valueOf(iN)));
                }
            } else if (info.getStateDescription() == null) {
                info.setStateDescription(this.view.getContext().getResources().getString(R.string.in_progress));
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (progressBarRangeInfo.getCurrent() < n9.o.d(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (progressBarRangeInfo.getCurrent() > n9.o.i(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (i14 >= 24) {
            Api24Impl.addSetProgressAction(info, semanticsNode);
        }
        CollectionInfoKt.setCollectionInfo(semanticsNode, info);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode, info);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getScrollBy());
        if (scrollAxisRange != null && accessibilityAction8 != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode) ? AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT : AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getVerticalScrollAxisRange());
        if (scrollAxisRange2 != null && accessibilityAction8 != null) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                info.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                info.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    info.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        info.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getExpand());
            if (accessibilityAction9 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction9.getLabel()));
                v8.k0 k0Var12 = v8.k0.f35197a;
            }
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCollapse());
            if (accessibilityAction10 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction10.getLabel()));
                v8.k0 k0Var13 = v8.k0.f35197a;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getDismiss());
            if (accessibilityAction11 != null) {
                info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction11.getLabel()));
                v8.k0 k0Var14 = v8.k0.f35197a;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getCustomActions())) {
                List list3 = (List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getCustomActions());
                int size2 = list3.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 >= iArr.length) {
                    throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
                }
                SparseArrayCompat<CharSequence> sparseArrayCompat = new SparseArrayCompat<>();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (this.labelToActionId.containsKey(i10)) {
                    Map<CharSequence, Integer> map = this.labelToActionId.get(i10);
                    List listP0 = kotlin.collections.p.p0(iArr);
                    ArrayList arrayList2 = new ArrayList();
                    int size3 = list3.size();
                    for (int i15 = 0; i15 < size3; i15++) {
                        CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list3.get(i15);
                        kotlin.jvm.internal.t.f(map);
                        if (map.containsKey(customAccessibilityAction.getLabel())) {
                            Integer num = map.get(customAccessibilityAction.getLabel());
                            kotlin.jvm.internal.t.f(num);
                            sparseArrayCompat.put(num.intValue(), customAccessibilityAction.getLabel());
                            linkedHashMap.put(customAccessibilityAction.getLabel(), num);
                            listP0.remove(num);
                            info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(num.intValue(), customAccessibilityAction.getLabel()));
                        } else {
                            arrayList2.add(customAccessibilityAction);
                        }
                    }
                    int size4 = arrayList2.size();
                    while (i11 < size4) {
                        CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i11);
                        int iIntValue = ((Number) listP0.get(i11)).intValue();
                        sparseArrayCompat.put(iIntValue, customAccessibilityAction2.getLabel());
                        linkedHashMap.put(customAccessibilityAction2.getLabel(), Integer.valueOf(iIntValue));
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(iIntValue, customAccessibilityAction2.getLabel()));
                        i11++;
                    }
                } else {
                    int size5 = list3.size();
                    while (i11 < size5) {
                        CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list3.get(i11);
                        int i16 = AccessibilityActionsResourceIds[i11];
                        sparseArrayCompat.put(i16, customAccessibilityAction3.getLabel());
                        linkedHashMap.put(customAccessibilityAction3.getLabel(), Integer.valueOf(i16));
                        info.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i16, customAccessibilityAction3.getLabel()));
                        i11++;
                    }
                }
                this.actionIdToLabel.put(i10, sparseArrayCompat);
                this.labelToActionId.put(i10, linkedHashMap);
            }
        }
    }

    @VisibleForTesting
    public final void sendSemanticsPropertyChangeEvents$ui_release(@NotNull Map<Integer, SemanticsNodeWithAdjustedBounds> newSemanticsNodes) {
        String str;
        String text;
        kotlin.jvm.internal.t.i(newSemanticsNodes, "newSemanticsNodes");
        ArrayList arrayList = new ArrayList(this.scrollObservationScopes);
        this.scrollObservationScopes.clear();
        Iterator<Integer> it = newSemanticsNodes.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            SemanticsNodeCopy semanticsNodeCopy = this.previousSemanticsNodes.get(Integer.valueOf(iIntValue));
            if (semanticsNodeCopy != null) {
                SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = newSemanticsNodes.get(Integer.valueOf(iIntValue));
                SemanticsNode semanticsNode = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.getSemanticsNode() : null;
                kotlin.jvm.internal.t.f(semanticsNode);
                while (true) {
                    boolean zPropertiesDeleted = false;
                    for (Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object> entry : semanticsNode.getUnmergedConfig$ui_release()) {
                        SemanticsPropertyKey<?> key = entry.getKey();
                        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                        if (((kotlin.jvm.internal.t.d(key, semanticsProperties.getHorizontalScrollAxisRange()) || kotlin.jvm.internal.t.d(entry.getKey(), semanticsProperties.getVerticalScrollAxisRange())) ? registerScrollingId(iIntValue, arrayList) : false) || !kotlin.jvm.internal.t.d(entry.getValue(), SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), entry.getKey()))) {
                            SemanticsPropertyKey<?> key2 = entry.getKey();
                            if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getPaneTitle())) {
                                Object value = entry.getValue();
                                if (value == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                }
                                String str2 = (String) value;
                                if (semanticsNodeCopy.hasPaneTitle()) {
                                    sendPaneChangeEvents(iIntValue, 8, str2);
                                }
                            } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getStateDescription()) ? true : kotlin.jvm.internal.t.d(key2, semanticsProperties.getToggleableState())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 64, null, 8, null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 0, null, 8, null);
                            } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getProgressBarRangeInfo())) {
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 64, null, 8, null);
                                sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 0, null, 8, null);
                            } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getSelected())) {
                                Role role = (Role) SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getRole());
                                if (!(role == null ? false : Role.m3230equalsimpl0(role.m3233unboximpl(), Role.Companion.m3239getTabo7Vup1c()))) {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 64, null, 8, null);
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 0, null, 8, null);
                                } else if (kotlin.jvm.internal.t.d(SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelected()), Boolean.TRUE)) {
                                    AccessibilityEvent accessibilityEventCreateEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 4);
                                    SemanticsNode semanticsNode2 = new SemanticsNode(semanticsNode.getOuterSemanticsEntity$ui_release(), true);
                                    List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode2.getConfig(), semanticsProperties.getContentDescription());
                                    String strFastJoinToString$default = list != null ? TempListUtilsKt.fastJoinToString$default(list, ",", null, null, 0, null, null, 62, null) : null;
                                    List list2 = (List) SemanticsConfigurationKt.getOrNull(semanticsNode2.getConfig(), semanticsProperties.getText());
                                    String strFastJoinToString$default2 = list2 != null ? TempListUtilsKt.fastJoinToString$default(list2, ",", null, null, 0, null, null, 62, null) : null;
                                    if (strFastJoinToString$default != null) {
                                        accessibilityEventCreateEvent$ui_release.setContentDescription(strFastJoinToString$default);
                                        v8.k0 k0Var = v8.k0.f35197a;
                                    }
                                    if (strFastJoinToString$default2 != null) {
                                        accessibilityEventCreateEvent$ui_release.getText().add(strFastJoinToString$default2);
                                    }
                                    sendEvent(accessibilityEventCreateEvent$ui_release);
                                } else {
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 0, null, 8, null);
                                }
                            } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getContentDescription())) {
                                int iSemanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue);
                                Object value2 = entry.getValue();
                                if (value2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                                }
                                sendEventForVirtualView(iSemanticsNodeIdToAccessibilityVirtualNodeId, 2048, 4, (List) value2);
                            } else {
                                str = "";
                                if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getEditableText())) {
                                    if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
                                        AnnotatedString textForTextField = getTextForTextField(semanticsNodeCopy.getUnmergedConfig());
                                        if (textForTextField == null) {
                                            textForTextField = "";
                                        }
                                        AnnotatedString textForTextField2 = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
                                        str = textForTextField2 != null ? textForTextField2 : "";
                                        int length = textForTextField.length();
                                        int length2 = str.length();
                                        int iJ = n9.o.j(length, length2);
                                        int i10 = 0;
                                        while (i10 < iJ && textForTextField.charAt(i10) == str.charAt(i10)) {
                                            i10++;
                                        }
                                        int i11 = 0;
                                        while (i11 < iJ - i10) {
                                            int i12 = iJ;
                                            if (textForTextField.charAt((length - 1) - i11) != str.charAt((length2 - 1) - i11)) {
                                                break;
                                            }
                                            i11++;
                                            iJ = i12;
                                        }
                                        AccessibilityEvent accessibilityEventCreateEvent$ui_release2 = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 16);
                                        accessibilityEventCreateEvent$ui_release2.setFromIndex(i10);
                                        accessibilityEventCreateEvent$ui_release2.setRemovedCount((length - i11) - i10);
                                        accessibilityEventCreateEvent$ui_release2.setAddedCount((length2 - i11) - i10);
                                        accessibilityEventCreateEvent$ui_release2.setBeforeText(textForTextField);
                                        accessibilityEventCreateEvent$ui_release2.getText().add(trimToSize(str, 100000));
                                        sendEvent(accessibilityEventCreateEvent$ui_release2);
                                    } else {
                                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 2, null, 8, null);
                                    }
                                } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getTextSelectionRange())) {
                                    AnnotatedString textForTextField3 = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
                                    if (textForTextField3 != null && (text = textForTextField3.getText()) != null) {
                                        str = text;
                                    }
                                    long jM3339unboximpl = ((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).m3339unboximpl();
                                    sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), Integer.valueOf(TextRange.m3335getStartimpl(jM3339unboximpl)), Integer.valueOf(TextRange.m3330getEndimpl(jM3339unboximpl)), Integer.valueOf(str.length()), (String) trimToSize(str, 100000)));
                                    sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
                                } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getHorizontalScrollAxisRange()) ? true : kotlin.jvm.internal.t.d(key2, semanticsProperties.getVerticalScrollAxisRange())) {
                                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                                    ScrollObservationScope scrollObservationScopeFindById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(this.scrollObservationScopes, iIntValue);
                                    kotlin.jvm.internal.t.f(scrollObservationScopeFindById);
                                    scrollObservationScopeFindById.setHorizontalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getHorizontalScrollAxisRange()));
                                    scrollObservationScopeFindById.setVerticalScrollAxisRange((ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getVerticalScrollAxisRange()));
                                    sendScrollEventIfNeeded(scrollObservationScopeFindById);
                                } else if (kotlin.jvm.internal.t.d(key2, semanticsProperties.getFocused())) {
                                    Object value3 = entry.getValue();
                                    if (value3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    if (((Boolean) value3).booleanValue()) {
                                        sendEvent(createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 8));
                                    }
                                    sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId()), 2048, 0, null, 8, null);
                                } else {
                                    SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
                                    if (kotlin.jvm.internal.t.d(key2, semanticsActions.getCustomActions())) {
                                        List list3 = (List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getCustomActions());
                                        List list4 = (List) SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), semanticsActions.getCustomActions());
                                        if (list4 != null) {
                                            LinkedHashSet linkedHashSet = new LinkedHashSet();
                                            int size = list3.size();
                                            for (int i13 = 0; i13 < size; i13++) {
                                                linkedHashSet.add(((CustomAccessibilityAction) list3.get(i13)).getLabel());
                                            }
                                            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
                                            int size2 = list4.size();
                                            for (int i14 = 0; i14 < size2; i14++) {
                                                linkedHashSet2.add(((CustomAccessibilityAction) list4.get(i14)).getLabel());
                                            }
                                            if (linkedHashSet.containsAll(linkedHashSet2) && linkedHashSet2.containsAll(linkedHashSet)) {
                                                break;
                                            }
                                        } else if (!list3.isEmpty()) {
                                        }
                                        zPropertiesDeleted = true;
                                    } else if (entry.getValue() instanceof AccessibilityAction) {
                                        Object value4 = entry.getValue();
                                        if (value4 == null) {
                                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                                        }
                                        zPropertiesDeleted = !AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals((AccessibilityAction) value4, SemanticsConfigurationKt.getOrNull(semanticsNodeCopy.getUnmergedConfig(), entry.getKey()));
                                    } else {
                                        zPropertiesDeleted = true;
                                    }
                                }
                            }
                        }
                    }
                    if (!zPropertiesDeleted) {
                        zPropertiesDeleted = AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(semanticsNode, semanticsNodeCopy);
                    }
                    if (zPropertiesDeleted) {
                        sendEventForVirtualView$default(this, semanticsNodeIdToAccessibilityVirtualNodeId(iIntValue), 2048, 0, null, 8, null);
                    }
                }
            }
        }
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z10) {
        this.accessibilityForceEnabledForTesting = z10;
    }

    public final void setHoveredVirtualViewId$ui_release(int i10) {
        this.hoveredVirtualViewId = i10;
    }

    public final void setPreviousSemanticsNodes$ui_release(@NotNull Map<Integer, SemanticsNodeCopy> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }

    @VisibleForTesting
    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }
}
