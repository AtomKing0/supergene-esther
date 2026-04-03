package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusOrderModifier;
import androidx.compose.ui.focus.FocusOrderModifierToProperties;
import androidx.compose.ui.focus.FocusPropertiesModifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.input.pointer.PointerInputFilter;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.DpSize;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: LayoutNode.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LayoutNode implements Measurable, Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;

    @NotNull
    private final Comparator<LayoutNode> ZComparator;

    @NotNull
    private final MutableVector<LayoutNode> _foldedChildren;

    @Nullable
    private LayoutNode _foldedParent;

    @Nullable
    private LayoutNodeWrapper _innerLayerWrapper;

    @Nullable
    private MutableVector<LayoutNode> _unfoldedChildren;

    @NotNull
    private final MutableVector<LayoutNode> _zSortedChildren;

    @NotNull
    private final LayoutNodeAlignmentLines alignmentLines;
    private boolean canMultiMeasure;

    @NotNull
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerWrapperIsDirty;

    @NotNull
    private final LayoutNodeWrapper innerLayoutNodeWrapper;

    @NotNull
    private final IntrinsicsPolicy intrinsicsPolicy;

    @NotNull
    private UsageByParent intrinsicsUsageByParent;
    private boolean isPlaced;
    private final boolean isVirtual;

    @NotNull
    private LayoutDirection layoutDirection;
    private boolean layoutPending;

    @NotNull
    private LayoutState layoutState;
    private boolean measurePending;

    @NotNull
    private MeasurePolicy measurePolicy;

    @NotNull
    private final MeasureScope measureScope;

    @NotNull
    private UsageByParent measuredByParent;

    @NotNull
    private Modifier modifier;

    @NotNull
    private final ModifierLocalProviderEntity modifierLocalsHead;

    @NotNull
    private ModifierLocalProviderEntity modifierLocalsTail;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;

    @Nullable
    private l<? super Owner, k0> onAttach;

    @Nullable
    private l<? super Owner, k0> onDetach;

    @Nullable
    private MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> onPositionedCallbacks;

    @NotNull
    private final OuterMeasurablePlaceable outerMeasurablePlaceable;

    @Nullable
    private Owner owner;
    private int placeOrder;

    @NotNull
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;

    @Nullable
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;

    @NotNull
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;

    @NotNull
    private MutableVector<ModifiedLayoutNode> wrapperCache;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.ui.layout.MeasurePolicy
        /* JADX INFO: renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo8measure3p2s80s(MeasureScope measureScope, List list, long j10) {
            return (MeasureResult) m3105measure3p2s80s(measureScope, (List<? extends Measurable>) list, j10);
        }

        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m3105measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
            t.i(measure, "$this$measure");
            t.i(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };

    @NotNull
    private static final h9.a<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;

    @NotNull
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        /* JADX INFO: renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo3104getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.Companion.m3781getZeroMYxV2XQ();
        }

        @Override // androidx.compose.ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }
    };

    @NotNull
    private static final ProvidableModifierLocal ModifierLocalNothing = ModifierLocalKt.modifierLocalOf(LayoutNode$Companion$ModifierLocalNothing$1.INSTANCE);

    @NotNull
    private static final LayoutNode$Companion$SentinelModifierLocalProvider$1 SentinelModifierLocalProvider = new ModifierLocalProvider() { // from class: androidx.compose.ui.node.LayoutNode$Companion$SentinelModifierLocalProvider$1
        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return androidx.compose.ui.b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return androidx.compose.ui.b.b(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return androidx.compose.ui.b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return androidx.compose.ui.b.d(this, obj, pVar);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public ProvidableModifierLocal getKey() {
            return LayoutNode.ModifierLocalNothing;
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public Void getValue() {
            throw new IllegalStateException("Sentinel ModifierLocal shouldn't be read".toString());
        }
    };

    /* JADX INFO: compiled from: LayoutNode.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final h9.a<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        @NotNull
        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    public enum LayoutState {
        Measuring,
        LayingOut,
        Idle
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {

        @NotNull
        private final String error;

        public NoIntrinsicsMeasurePolicy(@NotNull String error) {
            t.i(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return ((Number) m3106maxIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i10)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return ((Number) m3107maxIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i10)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return ((Number) m3108minIntrinsicHeight(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i10)).intValue();
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return ((Number) m3109minIntrinsicWidth(intrinsicMeasureScope, (List<? extends IntrinsicMeasurable>) list, i10)).intValue();
        }

        @NotNull
        /* JADX INFO: renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m3106maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m3107maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m3108minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        /* JADX INFO: renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m3109minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
            t.i(intrinsicMeasureScope, "<this>");
            t.i(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* JADX INFO: compiled from: LayoutNode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            iArr[LayoutState.Idle.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNode$hasNewPositioningCallback$1, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutNode.kt */
    static final class AnonymousClass1 extends v implements p<Modifier.Element, Boolean, Boolean> {
        final /* synthetic */ MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> $onPositionedCallbacks;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector) {
            super(2);
            this.$onPositionedCallbacks = mutableVector;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Boolean mo4invoke(Modifier.Element element, Boolean bool) {
            return invoke(element, bool.booleanValue());
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
        @org.jetbrains.annotations.NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier.Element r7, boolean r8) {
            /*
                r6 = this;
                java.lang.String r0 = "mod"
                kotlin.jvm.internal.t.i(r7, r0)
                if (r8 != 0) goto L35
                boolean r8 = r7 instanceof androidx.compose.ui.layout.OnGloballyPositionedModifier
                r0 = 0
                if (r8 == 0) goto L36
                androidx.compose.runtime.collection.MutableVector<v8.s<androidx.compose.ui.node.LayoutNodeWrapper, androidx.compose.ui.layout.OnGloballyPositionedModifier>> r8 = r6.$onPositionedCallbacks
                r1 = 0
                if (r8 == 0) goto L33
                int r2 = r8.getSize()
                if (r2 <= 0) goto L31
                java.lang.Object[] r8 = r8.getContent()
                r3 = r0
            L1c:
                r4 = r8[r3]
                r5 = r4
                v8.s r5 = (v8.s) r5
                java.lang.Object r5 = r5.d()
                boolean r5 = kotlin.jvm.internal.t.d(r7, r5)
                if (r5 == 0) goto L2d
                r1 = r4
                goto L31
            L2d:
                int r3 = r3 + 1
                if (r3 < r2) goto L1c
            L31:
                v8.s r1 = (v8.s) r1
            L33:
                if (r1 != 0) goto L36
            L35:
                r0 = 1
            L36:
                java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.AnonymousClass1.invoke(androidx.compose.ui.Modifier$Element, boolean):java.lang.Boolean");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNode$markReusedModifiers$2, reason: invalid class name */
    /* JADX INFO: compiled from: LayoutNode.kt */
    static final class AnonymousClass2 extends v implements p<k0, Modifier.Element, k0> {
        AnonymousClass2() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(k0 k0Var, Modifier.Element element) {
            invoke2(k0Var, element);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull k0 k0Var, @NotNull Modifier.Element mod) {
            Object obj;
            t.i(k0Var, "<anonymous parameter 0>");
            t.i(mod, "mod");
            MutableVector mutableVector = LayoutNode.this.wrapperCache;
            int size = mutableVector.getSize();
            if (size > 0) {
                int i10 = size - 1;
                Object[] content = mutableVector.getContent();
                do {
                    obj = content[i10];
                    ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) obj;
                    if (modifiedLayoutNode.getModifier() == mod && !modifiedLayoutNode.getToBeReusedForSameModifier()) {
                        break;
                    } else {
                        i10--;
                    }
                } while (i10 >= 0);
                obj = null;
            } else {
                obj = null;
            }
            ModifiedLayoutNode modifiedLayoutNode2 = (ModifiedLayoutNode) obj;
            if (modifiedLayoutNode2 == null) {
                return;
            }
            modifiedLayoutNode2.setToBeReusedForSameModifier(true);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.node.LayoutNode$setModifierLocals$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: LayoutNode.kt */
    static final class C09991 extends v implements p<ModifierLocalProviderEntity, Modifier.Element, ModifierLocalProviderEntity> {
        final /* synthetic */ MutableVector<ModifierLocalConsumerEntity> $consumers;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09991(MutableVector<ModifierLocalConsumerEntity> mutableVector) {
            super(2);
            this.$consumers = mutableVector;
        }

        @Override // h9.p
        @NotNull
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final ModifierLocalProviderEntity mo4invoke(@NotNull ModifierLocalProviderEntity lastProvider, @NotNull Modifier.Element mod) {
            t.i(lastProvider, "lastProvider");
            t.i(mod, "mod");
            if (mod instanceof FocusOrderModifier) {
                FocusOrderModifier focusOrderModifier = (FocusOrderModifier) mod;
                FocusPropertiesModifier focusPropertiesModifierFindFocusPropertiesModifier = LayoutNode.this.findFocusPropertiesModifier(focusOrderModifier, this.$consumers);
                if (focusPropertiesModifierFindFocusPropertiesModifier == null) {
                    FocusOrderModifierToProperties focusOrderModifierToProperties = new FocusOrderModifierToProperties(focusOrderModifier);
                    focusPropertiesModifierFindFocusPropertiesModifier = new FocusPropertiesModifier(focusOrderModifierToProperties, InspectableValueKt.isDebugInspectorInfoEnabled() ? new LayoutNode$setModifierLocals$1$invoke$lambda1$$inlined$debugInspectorInfo$1(focusOrderModifierToProperties) : InspectableValueKt.getNoInspectorInfo());
                }
                LayoutNode.this.addModifierLocalConsumer(focusPropertiesModifierFindFocusPropertiesModifier, lastProvider, this.$consumers);
                lastProvider = LayoutNode.this.addModifierLocalProvider(focusPropertiesModifierFindFocusPropertiesModifier, lastProvider);
            }
            if (mod instanceof ModifierLocalConsumer) {
                LayoutNode.this.addModifierLocalConsumer((ModifierLocalConsumer) mod, lastProvider, this.$consumers);
            }
            return mod instanceof ModifierLocalProvider ? LayoutNode.this.addModifierLocalProvider((ModifierLocalProvider) mod, lastProvider) : lastProvider;
        }
    }

    public LayoutNode() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: ZComparator$lambda-52, reason: not valid java name */
    public static final int m3096ZComparator$lambda52(LayoutNode layoutNode, LayoutNode layoutNode2) {
        float f10 = layoutNode.zIndex;
        float f11 = layoutNode2.zIndex;
        return (f10 > f11 ? 1 : (f10 == f11 ? 0 : -1)) == 0 ? t.k(layoutNode.placeOrder, layoutNode2.placeOrder) : Float.compare(f10, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addModifierLocalConsumer(ModifierLocalConsumer modifierLocalConsumer, ModifierLocalProviderEntity modifierLocalProviderEntity, MutableVector<ModifierLocalConsumerEntity> mutableVector) {
        int i10;
        ModifierLocalConsumerEntity modifierLocalConsumerEntityRemoveAt;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            i10 = 0;
            do {
                if (content[i10].getModifier() == modifierLocalConsumer) {
                    break;
                } else {
                    i10++;
                }
            } while (i10 < size);
            i10 = -1;
        } else {
            i10 = -1;
        }
        if (i10 < 0) {
            modifierLocalConsumerEntityRemoveAt = new ModifierLocalConsumerEntity(modifierLocalProviderEntity, modifierLocalConsumer);
        } else {
            modifierLocalConsumerEntityRemoveAt = mutableVector.removeAt(i10);
            modifierLocalConsumerEntityRemoveAt.setProvider(modifierLocalProviderEntity);
        }
        modifierLocalProviderEntity.getConsumers().add(modifierLocalConsumerEntityRemoveAt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModifierLocalProviderEntity addModifierLocalProvider(ModifierLocalProvider<?> modifierLocalProvider, ModifierLocalProviderEntity modifierLocalProviderEntity) {
        ModifierLocalProviderEntity next = modifierLocalProviderEntity.getNext();
        while (next != null && next.getModifier() != modifierLocalProvider) {
            next = next.getNext();
        }
        if (next == null) {
            next = new ModifierLocalProviderEntity(this, modifierLocalProvider);
        } else {
            ModifierLocalProviderEntity prev = next.getPrev();
            if (prev != null) {
                prev.setNext(next.getNext());
            }
            ModifierLocalProviderEntity next2 = next.getNext();
            if (next2 != null) {
                next2.setPrev(next.getPrev());
            }
        }
        next.setNext(modifierLocalProviderEntity.getNext());
        ModifierLocalProviderEntity next3 = modifierLocalProviderEntity.getNext();
        if (next3 != null) {
            next3.setPrev(next);
        }
        modifierLocalProviderEntity.setNext(next);
        next.setPrev(modifierLocalProviderEntity);
        return next;
    }

    private final void alignmentLinesQueriedByModifier() {
        if (this.layoutState != LayoutState.Measuring) {
            this.alignmentLines.setUsedByModifierLayout$ui_release(true);
            return;
        }
        this.alignmentLines.setUsedByModifierMeasurement$ui_release(true);
        if (this.alignmentLines.getDirty$ui_release()) {
            markLayoutPending$ui_release();
        }
    }

    private final void clearSubtreeIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage();
                }
                i10++;
            } while (i10 < size);
        }
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i10++;
            } while (i10 < size);
        }
    }

    private final void copyWrappersToCache() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!t.d(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            this.wrapperCache.add(modifiedLayoutNode);
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped$ui_release();
        }
    }

    private final String debugTreeToString(int i10) {
        StringBuilder sb = new StringBuilder();
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("  ");
        }
        sb.append("|-");
        sb.append(toString());
        sb.append('\n');
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i12 = 0;
            do {
                sb.append(content[i12].debugTreeToString(i10 + 1));
                i12++;
            } while (i12 < size);
        }
        String string = sb.toString();
        t.h(string, "tree.toString()");
        if (i10 != 0) {
            return string;
        }
        String strSubstring = string.substring(0, string.length() - 1);
        t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        return layoutNode.debugTreeToString(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FocusPropertiesModifier findFocusPropertiesModifier(FocusOrderModifier focusOrderModifier, MutableVector<ModifierLocalConsumerEntity> mutableVector) {
        ModifierLocalConsumerEntity modifierLocalConsumerEntity;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifierLocalConsumerEntity[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                modifierLocalConsumerEntity = content[i10];
                ModifierLocalConsumerEntity modifierLocalConsumerEntity2 = modifierLocalConsumerEntity;
                if ((modifierLocalConsumerEntity2.getModifier() instanceof FocusPropertiesModifier) && (((FocusPropertiesModifier) modifierLocalConsumerEntity2.getModifier()).getFocusPropertiesScope() instanceof FocusOrderModifierToProperties) && ((FocusOrderModifierToProperties) ((FocusPropertiesModifier) modifierLocalConsumerEntity2.getModifier()).getFocusPropertiesScope()).getModifier() == focusOrderModifier) {
                    break;
                }
                i10++;
            } while (i10 < size);
            modifierLocalConsumerEntity = null;
        } else {
            modifierLocalConsumerEntity = null;
        }
        ModifierLocalConsumerEntity modifierLocalConsumerEntity3 = modifierLocalConsumerEntity;
        ModifierLocalConsumer modifier = modifierLocalConsumerEntity3 != null ? modifierLocalConsumerEntity3.getModifier() : null;
        if (modifier instanceof FocusPropertiesModifier) {
            return (FocusPropertiesModifier) modifier;
        }
        return null;
    }

    private final void forEachDelegate(l<? super ModifiedLayoutNode, k0> lVar) {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!t.d(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            lVar.invoke(modifiedLayoutNode);
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped$ui_release();
        }
    }

    private final void forEachDelegateIncludingInner(l<? super LayoutNodeWrapper, k0> lVar) {
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release()) {
            lVar.invoke(outerLayoutNodeWrapper$ui_release);
        }
    }

    private final void forEachModifierLocalProvider(l<? super ModifierLocalProviderEntity, k0> lVar) {
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            lVar.invoke(next);
        }
    }

    private final LayoutNodeWrapper getInnerLayerWrapper() {
        if (this.innerLayerWrapperIsDirty) {
            LayoutNodeWrapper wrappedBy$ui_release = this.innerLayoutNodeWrapper;
            LayoutNodeWrapper wrappedBy$ui_release2 = getOuterLayoutNodeWrapper$ui_release().getWrappedBy$ui_release();
            this._innerLayerWrapper = null;
            while (true) {
                if (t.d(wrappedBy$ui_release, wrappedBy$ui_release2)) {
                    break;
                }
                if ((wrappedBy$ui_release != null ? wrappedBy$ui_release.getLayer() : null) != null) {
                    this._innerLayerWrapper = wrappedBy$ui_release;
                    break;
                }
                wrappedBy$ui_release = wrappedBy$ui_release != null ? wrappedBy$ui_release.getWrappedBy$ui_release() : null;
            }
        }
        LayoutNodeWrapper layoutNodeWrapper = this._innerLayerWrapper;
        if (layoutNodeWrapper == null || layoutNodeWrapper.getLayer() != null) {
            return layoutNodeWrapper;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final boolean hasNewPositioningCallback() {
        return ((Boolean) getModifier().foldOut(Boolean.FALSE, new AnonymousClass1(this.onPositionedCallbacks))).booleanValue();
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m3097hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j10, HitTestResult hitTestResult, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        boolean z12 = z10;
        if ((i10 & 8) != 0) {
            z11 = true;
        }
        layoutNode.m3100hitTestM_7yMNQ$ui_release(j10, hitTestResult, z12, z11);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (parent$ui_release = getParent$ui_release()) == null) {
            return;
        }
        parent$ui_release.unfoldedVirtualChildrenListDirty = true;
    }

    private final void markNodeAndSubtreeAsPlaced() {
        this.isPlaced = true;
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release()) {
            if (outerLayoutNodeWrapper$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                outerLayoutNodeWrapper$ui_release.invalidateLayer();
            }
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.placeOrder != Integer.MAX_VALUE) {
                    layoutNode.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout(layoutNode);
                }
                i10++;
            } while (i10 < size);
        }
    }

    private final void markReusedModifiers(Modifier modifier) {
        MutableVector<ModifiedLayoutNode> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        if (size > 0) {
            ModifiedLayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].setToBeReusedForSameModifier(false);
                i10++;
            } while (i10 < size);
        }
        modifier.foldIn(k0.f35197a, new AnonymousClass2());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            int i10 = 0;
            this.isPlaced = false;
            MutableVector<LayoutNode> mutableVector = get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                do {
                    content[i10].markSubtreeAsNotPlaced();
                    i10++;
                } while (i10 < size);
            }
        }
    }

    private final void onBeforeLayoutChildren() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                if (layoutNode.measurePending && layoutNode.measuredByParent == UsageByParent.InMeasureBlock && m3099remeasure_Sx5XlM$ui_release$default(layoutNode, null, 1, null)) {
                    requestRemeasure$ui_release$default(this, false, 1, null);
                }
                i10++;
            } while (i10 < size);
        }
    }

    private final void onChildRemoved(LayoutNode layoutNode) {
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(null);
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> mutableVector = layoutNode._foldedChildren;
            int size = mutableVector.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector.getContent();
                int i10 = 0;
                do {
                    content[i10].getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(null);
                    i10++;
                } while (i10 < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onZSortedChildrenInvalidated() {
        if (!this.isVirtual) {
            this.zSortedChildrenInvalidated = true;
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.onZSortedChildrenInvalidated();
        }
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i10 = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> mutableVector2 = this._foldedChildren;
            int size = mutableVector2.getSize();
            if (size > 0) {
                LayoutNode[] content = mutableVector2.getContent();
                do {
                    LayoutNode layoutNode = content[i10];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i10++;
                } while (i10 < size);
            }
        }
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m3099remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            constraints = layoutNode.outerMeasurablePlaceable.m3140getLastConstraintsDWUhwKw();
        }
        return layoutNode.m3103remeasure_Sx5XlM$ui_release(constraints);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        layoutNode.requestRelayout$ui_release(z10);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        layoutNode.requestRemeasure$ui_release(z10);
    }

    private final void rescheduleRemeasureOrRelayout(LayoutNode layoutNode) {
        if (WhenMappings.$EnumSwitchMapping$0[layoutNode.layoutState.ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.layoutState);
        }
        if (layoutNode.measurePending) {
            layoutNode.requestRemeasure$ui_release(true);
        } else if (layoutNode.layoutPending) {
            layoutNode.requestRelayout$ui_release(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ModifiedLayoutNode reuseLayoutNodeWrapper(LayoutNodeWrapper layoutNodeWrapper, LayoutModifier layoutModifier) {
        int i10;
        if (this.wrapperCache.isEmpty()) {
            return null;
        }
        MutableVector<ModifiedLayoutNode> mutableVector = this.wrapperCache;
        int size = mutableVector.getSize();
        int i11 = -1;
        if (size > 0) {
            i10 = size - 1;
            ModifiedLayoutNode[] content = mutableVector.getContent();
            do {
                ModifiedLayoutNode modifiedLayoutNode = content[i10];
                if (modifiedLayoutNode.getToBeReusedForSameModifier() && modifiedLayoutNode.getModifier() == layoutModifier) {
                    break;
                }
                i10--;
            } while (i10 >= 0);
            i10 = -1;
        } else {
            i10 = -1;
        }
        if (i10 < 0) {
            MutableVector<ModifiedLayoutNode> mutableVector2 = this.wrapperCache;
            int size2 = mutableVector2.getSize();
            if (size2 > 0) {
                int i12 = size2 - 1;
                ModifiedLayoutNode[] content2 = mutableVector2.getContent();
                while (true) {
                    if (!content2[i12].getToBeReusedForSameModifier()) {
                        i11 = i12;
                        break;
                    }
                    i12--;
                    if (i12 < 0) {
                        break;
                    }
                }
            }
            i10 = i11;
        }
        if (i10 < 0) {
            return null;
        }
        ModifiedLayoutNode modifiedLayoutNodeRemoveAt = this.wrapperCache.removeAt(i10);
        modifiedLayoutNodeRemoveAt.setModifier(layoutModifier);
        modifiedLayoutNodeRemoveAt.setWrapped(layoutNodeWrapper);
        return modifiedLayoutNodeRemoveAt;
    }

    private final void setModifierLocals(Modifier modifier) {
        int i10 = 0;
        MutableVector mutableVector = new MutableVector(new ModifierLocalConsumerEntity[16], 0);
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            mutableVector.addAll(mutableVector.getSize(), next.getConsumers());
            next.getConsumers().clear();
        }
        ModifierLocalProviderEntity modifierLocalProviderEntity = (ModifierLocalProviderEntity) modifier.foldIn(this.modifierLocalsHead, new C09991(mutableVector));
        this.modifierLocalsTail = modifierLocalProviderEntity;
        this.modifierLocalsTail.setNext(null);
        if (isAttached()) {
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                do {
                    ((ModifierLocalConsumerEntity) content[i10]).detach();
                    i10++;
                } while (i10 < size);
            }
            for (ModifierLocalProviderEntity next2 = modifierLocalProviderEntity.getNext(); next2 != null; next2 = next2.getNext()) {
                next2.detach();
            }
            for (ModifierLocalProviderEntity next3 = this.modifierLocalsHead; next3 != null; next3 = next3.getNext()) {
                next3.attachDelayed();
            }
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release()) {
            if (outerLayoutNodeWrapper$ui_release.getLayer() != null) {
                return false;
            }
            if (EntityList.m3075has0OSVbXo(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3081getDrawEntityTypeEEbPh1w())) {
                return true;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void attach$ui_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.Owner r9) {
        /*
            Method dump skipped, instruction units count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    @NotNull
    public final Map<AlignmentLine, Integer> calculateAlignmentLines$ui_release() {
        if (!this.outerMeasurablePlaceable.getDuringAlignmentLinesQuery$ui_release()) {
            alignmentLinesQueriedByModifier();
        }
        layoutChildren$ui_release();
        return this.alignmentLines.getLastCalculation();
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            sb.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null);
            throw new IllegalStateException(sb.toString().toString());
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
        }
        this.alignmentLines.reset$ui_release();
        l<? super Owner, k0> lVar = this.onDetach;
        if (lVar != null) {
            lVar.invoke(owner);
        }
        for (ModifierLocalProviderEntity next = this.modifierLocalsHead; next != null; next = next.getNext()) {
            next.detach();
        }
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release()) {
            outerLayoutNodeWrapper$ui_release.detach();
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner.onSemanticsChange();
        }
        owner.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector<LayoutNode> mutableVector = this._foldedChildren;
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                content[i10].detach$ui_release();
                i10++;
            } while (i10 < size);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector;
        int size;
        if (this.layoutState != LayoutState.Idle || this.layoutPending || this.measurePending || !isPlaced() || (mutableVector = this.onPositionedCallbacks) == null || (size = mutableVector.getSize()) <= 0) {
            return;
        }
        s<LayoutNodeWrapper, OnGloballyPositionedModifier>[] content = mutableVector.getContent();
        int i10 = 0;
        do {
            s<LayoutNodeWrapper, OnGloballyPositionedModifier> sVar = content[i10];
            sVar.d().onGloballyPositioned(sVar.c());
            i10++;
        } while (i10 < size);
    }

    public final void draw$ui_release(@NotNull Canvas canvas) {
        t.i(canvas, "canvas");
        getOuterLayoutNodeWrapper$ui_release().draw(canvas);
    }

    @Override // androidx.compose.ui.layout.Remeasurement
    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        Constraints constraintsM3140getLastConstraintsDWUhwKw = this.outerMeasurablePlaceable.m3140getLastConstraintsDWUhwKw();
        if (constraintsM3140getLastConstraintsDWUhwKw != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo3150measureAndLayout0kLqBqw(this, constraintsM3140getLastConstraintsDWUhwKw.m3647unboximpl());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            b.d(owner2, false, 1, null);
        }
    }

    @NotNull
    public final LayoutNodeAlignmentLines getAlignmentLines$ui_release() {
        return this.alignmentLines;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    @NotNull
    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    @NotNull
    public LayoutCoordinates getCoordinates() {
        return this.innerLayoutNodeWrapper;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    @NotNull
    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asMutableList();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getHeight() {
        return this.outerMeasurablePlaceable.getHeight();
    }

    public final boolean getInnerLayerWrapperIsDirty$ui_release() {
        return this.innerLayerWrapperIsDirty;
    }

    @NotNull
    public final LayoutNodeWrapper getInnerLayoutNodeWrapper$ui_release() {
        return this.innerLayoutNodeWrapper;
    }

    @NotNull
    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    @NotNull
    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutPending;
    }

    @NotNull
    public final LayoutState getLayoutState$ui_release() {
        return this.layoutState;
    }

    @NotNull
    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    public final boolean getMeasurePending$ui_release() {
        return this.measurePending;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final MeasureScope getMeasureScope$ui_release() {
        return this.measureScope;
    }

    @NotNull
    public final UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        MutableVector mutableVector = new MutableVector(new ModifierInfo[16], 0);
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!t.d(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            OwnedLayer layer = modifiedLayoutNode.getLayer();
            mutableVector.add(new ModifierInfo(modifiedLayoutNode.getModifier(), modifiedLayoutNode, layer));
            for (LayoutNodeEntity<?, ?> next : modifiedLayoutNode.m3125getEntitiesCHwCgZE()) {
                for (; next != null; next = next.getNext()) {
                    mutableVector.add(new ModifierInfo(next.getModifier(), modifiedLayoutNode, layer));
                }
            }
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped$ui_release();
        }
        for (LayoutNodeEntity<?, ?> next2 : this.innerLayoutNodeWrapper.m3125getEntitiesCHwCgZE()) {
            for (; next2 != null; next2 = next2.getNext()) {
                Modifier modifier = next2.getModifier();
                LayoutNodeWrapper layoutNodeWrapper2 = this.innerLayoutNodeWrapper;
                mutableVector.add(new ModifierInfo(modifier, layoutNodeWrapper2, layoutNodeWrapper2.getLayer()));
            }
        }
        return mutableVector.asMutableList();
    }

    @NotNull
    public final ModifierLocalProviderEntity getModifierLocalsHead$ui_release() {
        return this.modifierLocalsHead;
    }

    @NotNull
    public final ModifierLocalProviderEntity getModifierLocalsTail$ui_release() {
        return this.modifierLocalsTail;
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    @Nullable
    public final l<Owner, k0> getOnAttach$ui_release() {
        return this.onAttach;
    }

    @Nullable
    public final l<Owner, k0> getOnDetach$ui_release() {
        return this.onDetach;
    }

    @NotNull
    public final MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> getOrCreateOnPositionedCallbacks$ui_release() {
        MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector = this.onPositionedCallbacks;
        if (mutableVector != null) {
            return mutableVector;
        }
        MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector2 = new MutableVector<>(new s[16], 0);
        this.onPositionedCallbacks = mutableVector2;
        return mutableVector2;
    }

    @NotNull
    public final LayoutNodeWrapper getOuterLayoutNodeWrapper$ui_release() {
        return this.outerMeasurablePlaceable.getOuterWrapper();
    }

    @Nullable
    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    @Nullable
    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        boolean z10 = false;
        if (layoutNode != null && layoutNode.isVirtual) {
            z10 = true;
        }
        if (!z10) {
            return layoutNode;
        }
        if (layoutNode != null) {
            return layoutNode.getParent$ui_release();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    @Nullable
    public Object getParentData() {
        return this.outerMeasurablePlaceable.getParentData();
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    @Nullable
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    @Nullable
    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo, androidx.compose.ui.node.ComposeUiNode
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public int getWidth() {
        return this.outerMeasurablePlaceable.getWidth();
    }

    @NotNull
    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(this.ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @NotNull
    public final MutableVector<LayoutNode> get_children$ui_release() {
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren;
        }
        recreateUnfoldedChildrenIfDirty();
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        t.f(mutableVector);
        return mutableVector;
    }

    public final void handleMeasureResult$ui_release(@NotNull MeasureResult measureResult) {
        t.i(measureResult, "measureResult");
        this.innerLayoutNodeWrapper.setMeasureResult$ui_release(measureResult);
    }

    /* JADX INFO: renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3100hitTestM_7yMNQ$ui_release(long j10, @NotNull HitTestResult<PointerInputFilter> hitTestResult, boolean z10, boolean z11) {
        t.i(hitTestResult, "hitTestResult");
        getOuterLayoutNodeWrapper$ui_release().m3128hitTestYqVAtuI(LayoutNodeWrapper.Companion.getPointerInputSource(), getOuterLayoutNodeWrapper$ui_release().m3124fromParentPositionMKHz9U(j10), hitTestResult, z10, z11);
    }

    /* JADX INFO: renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3101hitTestSemanticsM_7yMNQ$ui_release(long j10, @NotNull HitTestResult<SemanticsEntity> hitSemanticsEntities, boolean z10, boolean z11) {
        t.i(hitSemanticsEntities, "hitSemanticsEntities");
        getOuterLayoutNodeWrapper$ui_release().m3128hitTestYqVAtuI(LayoutNodeWrapper.Companion.getSemanticsSource(), getOuterLayoutNodeWrapper$ui_release().m3124fromParentPositionMKHz9U(j10), hitSemanticsEntities, true, z11);
    }

    public final void ignoreRemeasureRequests$ui_release(@NotNull h9.a<k0> block) {
        t.i(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insertAt$ui_release(int i10, @NotNull LayoutNode instance) {
        MutableVector<LayoutNode> mutableVector;
        int size;
        t.i(instance, "instance");
        int i11 = 0;
        LayoutNodeWrapper layoutNodeWrapper = null;
        if ((instance._foldedParent == null) != true) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot insert ");
            sb.append(instance);
            sb.append(" because it already has a parent. This tree: ");
            sb.append(debugTreeToString$default(this, 0, 1, null));
            sb.append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            sb.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null);
            throw new IllegalStateException(sb.toString().toString());
        }
        if ((instance.owner == null) != true) {
            throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null)).toString());
        }
        instance._foldedParent = this;
        this._foldedChildren.add(i10, instance);
        onZSortedChildrenInvalidated();
        if (instance.isVirtual) {
            if (!(!this.isVirtual)) {
                throw new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
            }
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = instance.getOuterLayoutNodeWrapper$ui_release();
        if (this.isVirtual) {
            LayoutNode layoutNode2 = this._foldedParent;
            if (layoutNode2 != null) {
                layoutNodeWrapper = layoutNode2.innerLayoutNodeWrapper;
            }
        } else {
            layoutNodeWrapper = this.innerLayoutNodeWrapper;
        }
        outerLayoutNodeWrapper$ui_release.setWrappedBy$ui_release(layoutNodeWrapper);
        if (instance.isVirtual && (size = (mutableVector = instance._foldedChildren).getSize()) > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                content[i11].getOuterLayoutNodeWrapper$ui_release().setWrappedBy$ui_release(this.innerLayoutNodeWrapper);
                i11++;
            } while (i11 < size);
        }
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
    }

    public final void invalidateLayer$ui_release() {
        LayoutNodeWrapper innerLayerWrapper = getInnerLayerWrapper();
        if (innerLayerWrapper != null) {
            innerLayerWrapper.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!t.d(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            OwnedLayer layer = modifiedLayoutNode.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped$ui_release();
        }
        OwnedLayer layer2 = this.innerLayoutNodeWrapper.getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    @Override // androidx.compose.ui.layout.LayoutInfo
    public boolean isPlaced() {
        return this.isPlaced;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return isAttached();
    }

    public final void layoutChildren$ui_release() {
        this.alignmentLines.recalculateQueryOwner$ui_release();
        if (this.layoutPending) {
            onBeforeLayoutChildren();
        }
        if (this.layoutPending) {
            this.layoutPending = false;
            this.layoutState = LayoutState.LayingOut;
            LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeLayoutSnapshotReads$ui_release(this, new LayoutNode$layoutChildren$1(this));
            this.layoutState = LayoutState.Idle;
        }
        if (this.alignmentLines.getUsedDuringParentLayout$ui_release()) {
            this.alignmentLines.setPreviousUsedDuringParentLayout$ui_release(true);
        }
        if (this.alignmentLines.getDirty$ui_release() && this.alignmentLines.getRequired$ui_release()) {
            this.alignmentLines.recalculate();
        }
    }

    public final void markLayoutPending$ui_release() {
        this.layoutPending = true;
    }

    public final void markMeasurePending$ui_release() {
        this.measurePending = true;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int i10) {
        return this.outerMeasurablePlaceable.maxIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int i10) {
        return this.outerMeasurablePlaceable.maxIntrinsicWidth(i10);
    }

    @Override // androidx.compose.ui.layout.Measurable
    @NotNull
    /* JADX INFO: renamed from: measure-BRTryo0 */
    public Placeable mo2987measureBRTryo0(long j10) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage();
        }
        return this.outerMeasurablePlaceable.mo2987measureBRTryo0(j10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int i10) {
        return this.outerMeasurablePlaceable.minIntrinsicHeight(i10);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int i10) {
        return this.outerMeasurablePlaceable.minIntrinsicWidth(i10);
    }

    public final void move$ui_release(int i10, int i11, int i12) {
        if (i10 == i11) {
            return;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            this._foldedChildren.add(i10 > i11 ? i11 + i13 : (i11 + i12) - 2, this._foldedChildren.removeAt(i10 > i11 ? i10 + i13 : i10));
        }
        onZSortedChildrenInvalidated();
        invalidateUnfoldedVirtualChildren();
        requestRemeasure$ui_release$default(this, false, 1, null);
    }

    public final void onAlignmentsChanged$ui_release() {
        if (this.alignmentLines.getDirty$ui_release()) {
            return;
        }
        this.alignmentLines.setDirty$ui_release(true);
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release == null) {
            return;
        }
        if (this.alignmentLines.getUsedDuringParentMeasurement$ui_release()) {
            requestRemeasure$ui_release$default(parent$ui_release, false, 1, null);
        } else if (this.alignmentLines.getPreviousUsedDuringParentLayout$ui_release()) {
            requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
        }
        if (this.alignmentLines.getUsedByModifierMeasurement$ui_release()) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        }
        if (this.alignmentLines.getUsedByModifierLayout$ui_release()) {
            requestRelayout$ui_release$default(parent$ui_release, false, 1, null);
        }
        parent$ui_release.onAlignmentsChanged$ui_release();
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        for (LayoutNodeEntity<?, ?> next = this.innerLayoutNodeWrapper.m3125getEntitiesCHwCgZE()[EntityList.Companion.m3082getOnPlacedEntityTypeEEbPh1w()]; next != null; next = next.getNext()) {
            ((OnPlacedModifier) ((SimpleEntity) next).getModifier()).onPlaced(this.innerLayoutNodeWrapper);
        }
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent$ui_release = getParent$ui_release();
        float zIndex = this.innerLayoutNodeWrapper.getZIndex();
        LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release();
        LayoutNodeWrapper layoutNodeWrapper = this.innerLayoutNodeWrapper;
        while (!t.d(outerLayoutNodeWrapper$ui_release, layoutNodeWrapper)) {
            ModifiedLayoutNode modifiedLayoutNode = (ModifiedLayoutNode) outerLayoutNodeWrapper$ui_release;
            zIndex += modifiedLayoutNode.getZIndex();
            outerLayoutNodeWrapper$ui_release = modifiedLayoutNode.getWrapped$ui_release();
        }
        if (!(zIndex == this.zIndex)) {
            this.zIndex = zIndex;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.layoutState == LayoutState.LayingOut) {
            if (!(this.placeOrder == Integer.MAX_VALUE)) {
                throw new IllegalStateException("Place was called on a node which was placed already".toString());
            }
            int i10 = parent$ui_release.nextChildPlaceOrder;
            this.placeOrder = i10;
            parent$ui_release.nextChildPlaceOrder = i10 + 1;
        }
        layoutChildren$ui_release();
    }

    /* JADX INFO: renamed from: performMeasure-BRTryo0$ui_release, reason: not valid java name */
    public final void m3102performMeasureBRTryo0$ui_release(long j10) {
        LayoutState layoutState = LayoutState.Measuring;
        this.layoutState = layoutState;
        this.measurePending = false;
        LayoutNodeKt.requireOwner(this).getSnapshotObserver().observeMeasureSnapshotReads$ui_release(this, new LayoutNode$performMeasure$1(this, j10));
        if (this.layoutState == layoutState) {
            markLayoutPending$ui_release();
            this.layoutState = LayoutState.Idle;
        }
    }

    public final void place$ui_release(int i10, int i11) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int measuredWidth = this.outerMeasurablePlaceable.getMeasuredWidth();
        LayoutDirection layoutDirection = getLayoutDirection();
        int parentWidth = companion.getParentWidth();
        LayoutDirection parentLayoutDirection = companion.getParentLayoutDirection();
        Placeable.PlacementScope.parentWidth = measuredWidth;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection;
        Placeable.PlacementScope.placeRelative$default(companion, this.outerMeasurablePlaceable, i10, i11, 0.0f, 4, null);
        Placeable.PlacementScope.parentWidth = parentWidth;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection;
    }

    /* JADX INFO: renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m3103remeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage();
        }
        return this.outerMeasurablePlaceable.m3141remeasureBRTryo0(constraints.m3647unboximpl());
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                this._foldedChildren.clear();
                return;
            }
            onChildRemoved(this._foldedChildren.getContent()[size]);
        }
    }

    public final void removeAt$ui_release(int i10, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("count (" + i11 + ") must be greater than 0").toString());
        }
        int i12 = (i11 + i10) - 1;
        if (i10 > i12) {
            return;
        }
        while (true) {
            onChildRemoved(this._foldedChildren.removeAt(i12));
            if (i12 == i10) {
                return;
            } else {
                i12--;
            }
        }
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            this.outerMeasurablePlaceable.replace();
        } finally {
            this.relayoutWithoutParentInProgress = false;
        }
    }

    public final void requestRelayout$ui_release(boolean z10) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, z10);
    }

    public final void requestRemeasure$ui_release(boolean z10) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestMeasure(this, z10);
        this.outerMeasurablePlaceable.invalidateIntrinsicsParent(z10);
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                LayoutNode layoutNode = content[i10];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i10++;
            } while (i10 < size);
        }
    }

    public final void setCanMultiMeasure$ui_release(boolean z10) {
        this.canMultiMeasure = z10;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setDensity(@NotNull Density value) {
        t.i(value, "value");
        if (t.d(this.density, value)) {
            return;
        }
        this.density = value;
        onDensityOrLayoutDirectionChanged();
    }

    public final void setDepth$ui_release(int i10) {
        this.depth = i10;
    }

    public final void setInnerLayerWrapperIsDirty$ui_release(boolean z10) {
        this.innerLayerWrapperIsDirty = z10;
    }

    public final void setIntrinsicsUsageByParent$ui_release(@NotNull UsageByParent usageByParent) {
        t.i(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setLayoutDirection(@NotNull LayoutDirection value) {
        t.i(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setMeasurePolicy(@NotNull MeasurePolicy value) {
        t.i(value, "value");
        if (t.d(this.measurePolicy, value)) {
            return;
        }
        this.measurePolicy = value;
        this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
        requestRemeasure$ui_release$default(this, false, 1, null);
    }

    public final void setMeasuredByParent$ui_release(@NotNull UsageByParent usageByParent) {
        t.i(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setModifier(@NotNull Modifier value) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        Owner owner;
        t.i(value, "value");
        if (t.d(value, this.modifier)) {
            return;
        }
        if (!t.d(getModifier(), Modifier.Companion) && !(!this.isVirtual)) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = value;
        boolean zShouldInvalidateParentLayer = shouldInvalidateParentLayer();
        copyWrappersToCache();
        LayoutNodeWrapper wrapped$ui_release = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release, wrapped$ui_release) && outerLayoutNodeWrapper$ui_release != null; outerLayoutNodeWrapper$ui_release = outerLayoutNodeWrapper$ui_release.getWrapped$ui_release()) {
            EntityList.m3067clearimpl(outerLayoutNodeWrapper$ui_release.m3125getEntitiesCHwCgZE());
        }
        markReusedModifiers(value);
        LayoutNodeWrapper outerWrapper = this.outerMeasurablePlaceable.getOuterWrapper();
        if (SemanticsNodeKt.getOuterSemantics(this) != null && isAttached()) {
            Owner owner2 = this.owner;
            t.f(owner2);
            owner2.onSemanticsChange();
        }
        boolean zHasNewPositioningCallback = hasNewPositioningCallback();
        MutableVector<s<LayoutNodeWrapper, OnGloballyPositionedModifier>> mutableVector = this.onPositionedCallbacks;
        if (mutableVector != null) {
            mutableVector.clear();
        }
        this.innerLayoutNodeWrapper.onInitialize();
        LayoutNodeWrapper layoutNodeWrapper = (LayoutNodeWrapper) getModifier().foldOut(this.innerLayoutNodeWrapper, new LayoutNode$modifier$outerWrapper$1(this));
        setModifierLocals(value);
        LayoutNode parent$ui_release3 = getParent$ui_release();
        layoutNodeWrapper.setWrappedBy$ui_release(parent$ui_release3 != null ? parent$ui_release3.innerLayoutNodeWrapper : null);
        this.outerMeasurablePlaceable.setOuterWrapper(layoutNodeWrapper);
        if (isAttached()) {
            MutableVector<ModifiedLayoutNode> mutableVector2 = this.wrapperCache;
            int size = mutableVector2.getSize();
            if (size > 0) {
                ModifiedLayoutNode[] content = mutableVector2.getContent();
                int i10 = 0;
                do {
                    content[i10].detach();
                    i10++;
                } while (i10 < size);
            }
            LayoutNodeWrapper wrapped$ui_release2 = this.innerLayoutNodeWrapper.getWrapped$ui_release();
            for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release2 = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release2, wrapped$ui_release2) && outerLayoutNodeWrapper$ui_release2 != null; outerLayoutNodeWrapper$ui_release2 = outerLayoutNodeWrapper$ui_release2.getWrapped$ui_release()) {
                if (outerLayoutNodeWrapper$ui_release2.isAttached()) {
                    for (LayoutNodeEntity<?, ?> next : outerLayoutNodeWrapper$ui_release2.m3125getEntitiesCHwCgZE()) {
                        for (; next != null; next = next.getNext()) {
                            next.onAttach();
                        }
                    }
                } else {
                    outerLayoutNodeWrapper$ui_release2.attach();
                }
            }
        }
        this.wrapperCache.clear();
        LayoutNodeWrapper wrapped$ui_release3 = this.innerLayoutNodeWrapper.getWrapped$ui_release();
        for (LayoutNodeWrapper outerLayoutNodeWrapper$ui_release3 = getOuterLayoutNodeWrapper$ui_release(); !t.d(outerLayoutNodeWrapper$ui_release3, wrapped$ui_release3) && outerLayoutNodeWrapper$ui_release3 != null; outerLayoutNodeWrapper$ui_release3 = outerLayoutNodeWrapper$ui_release3.getWrapped$ui_release()) {
            outerLayoutNodeWrapper$ui_release3.onModifierChanged();
        }
        if (!t.d(outerWrapper, this.innerLayoutNodeWrapper) || !t.d(layoutNodeWrapper, this.innerLayoutNodeWrapper)) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        } else if (this.layoutState == LayoutState.Idle && !this.measurePending && zHasNewPositioningCallback) {
            requestRemeasure$ui_release$default(this, false, 1, null);
        } else if (EntityList.m3075has0OSVbXo(this.innerLayoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3082getOnPlacedEntityTypeEEbPh1w()) && (owner = this.owner) != null) {
            owner.registerOnLayoutCompletedListener(this);
        }
        Object parentData = getParentData();
        this.outerMeasurablePlaceable.recalculateParentData();
        if (!t.d(parentData, getParentData()) && (parent$ui_release2 = getParent$ui_release()) != null) {
            requestRemeasure$ui_release$default(parent$ui_release2, false, 1, null);
        }
        if ((zShouldInvalidateParentLayer || shouldInvalidateParentLayer()) && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z10) {
        this.needsOnPositionedDispatch = z10;
    }

    public final void setOnAttach$ui_release(@Nullable l<? super Owner, k0> lVar) {
        this.onAttach = lVar;
    }

    public final void setOnDetach$ui_release(@Nullable l<? super Owner, k0> lVar) {
        this.onDetach = lVar;
    }

    public final void setSubcompositionsState$ui_release(@Nullable LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    @Override // androidx.compose.ui.node.ComposeUiNode
    public void setViewConfiguration(@NotNull ViewConfiguration viewConfiguration) {
        t.i(viewConfiguration, "<set-?>");
        this.viewConfiguration = viewConfiguration;
    }

    @NotNull
    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public LayoutNode(boolean z10) {
        this.isVirtual = z10;
        this._foldedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.layoutState = LayoutState.Idle;
        this.wrapperCache = new MutableVector<>(new ModifiedLayoutNode[16], 0);
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.measureScope = new LayoutNode$measureScope$1(this);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.alignmentLines = new LayoutNodeAlignmentLines(this);
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.measuredByParent = usageByParent;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        InnerPlaceable innerPlaceable = new InnerPlaceable(this);
        this.innerLayoutNodeWrapper = innerPlaceable;
        this.outerMeasurablePlaceable = new OuterMeasurablePlaceable(this, innerPlaceable);
        this.innerLayerWrapperIsDirty = true;
        ModifierLocalProviderEntity modifierLocalProviderEntity = new ModifierLocalProviderEntity(this, SentinelModifierLocalProvider);
        this.modifierLocalsHead = modifierLocalProviderEntity;
        this.modifierLocalsTail = modifierLocalProviderEntity;
        this.modifier = Modifier.Companion;
        this.ZComparator = new Comparator() { // from class: androidx.compose.ui.node.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return LayoutNode.m3096ZComparator$lambda52((LayoutNode) obj, (LayoutNode) obj2);
            }
        };
    }

    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public static /* synthetic */ void get_children$ui_release$annotations() {
    }

    public /* synthetic */ LayoutNode(boolean z10, int i10, k kVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
