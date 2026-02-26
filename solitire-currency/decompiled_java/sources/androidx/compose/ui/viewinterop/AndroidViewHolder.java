package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.pointer.PointerInteropFilter_androidKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.platform.NestedScrollInteropConnectionKt;
import androidx.compose.ui.platform.WindowRecomposer_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: AndroidViewHolder.android.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AndroidViewHolder extends ViewGroup implements NestedScrollingParent3 {

    @NotNull
    private Density density;

    @NotNull
    private final NestedScrollDispatcher dispatcher;
    private boolean hasUpdateBlock;
    private int lastHeightMeasureSpec;
    private int lastWidthMeasureSpec;

    @NotNull
    private final LayoutNode layoutNode;

    @Nullable
    private LifecycleOwner lifecycleOwner;

    @NotNull
    private final int[] location;

    @NotNull
    private Modifier modifier;

    @NotNull
    private final NestedScrollingParentHelper nestedScrollingParentHelper;

    @NotNull
    private final l<AndroidViewHolder, k0> onCommitAffectingUpdate;

    @Nullable
    private l<? super Density, k0> onDensityChanged;

    @Nullable
    private l<? super Modifier, k0> onModifierChanged;

    @Nullable
    private l<? super Boolean, k0> onRequestDisallowInterceptTouchEvent;

    @NotNull
    private final h9.a<k0> runUpdate;

    @Nullable
    private SavedStateRegistryOwner savedStateRegistryOwner;

    @NotNull
    private final SnapshotStateObserver snapshotObserver;

    @NotNull
    private h9.a<k0> update;

    @Nullable
    private View view;

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidViewHolder.android.kt */
    @f(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {470, 475}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ boolean $consumed;
        final /* synthetic */ long $viewVelocity;
        int label;
        final /* synthetic */ AndroidViewHolder this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z10, AndroidViewHolder androidViewHolder, long j10, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$consumed = z10;
            this.this$0 = androidViewHolder;
            this.$viewVelocity = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$consumed, this.this$0, this.$viewVelocity, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                if (this.$consumed) {
                    NestedScrollDispatcher nestedScrollDispatcher = this.this$0.dispatcher;
                    long j10 = this.$viewVelocity;
                    long jM3909getZero9UxMQ8M = Velocity.Companion.m3909getZero9UxMQ8M();
                    this.label = 2;
                    if (nestedScrollDispatcher.m2775dispatchPostFlingRZ2iAVY(j10, jM3909getZero9UxMQ8M, this) == objE) {
                        return objE;
                    }
                } else {
                    NestedScrollDispatcher nestedScrollDispatcher2 = this.this$0.dispatcher;
                    long jM3909getZero9UxMQ8M2 = Velocity.Companion.m3909getZero9UxMQ8M();
                    long j11 = this.$viewVelocity;
                    this.label = 1;
                    if (nestedScrollDispatcher2.m2775dispatchPostFlingRZ2iAVY(jM3909getZero9UxMQ8M2, j11, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1 && i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidViewHolder.android.kt */
    @f(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedPreFling$1", f = "AndroidViewHolder.android.kt", l = {488}, m = "invokeSuspend")
    static final class C10101 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ long $toBeConsumed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10101(long j10, d<? super C10101> dVar) {
            super(2, dVar);
            this.$toBeConsumed = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return AndroidViewHolder.this.new C10101(this.$toBeConsumed, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                NestedScrollDispatcher nestedScrollDispatcher = AndroidViewHolder.this.dispatcher;
                long j10 = this.$toBeConsumed;
                this.label = 1;
                if (nestedScrollDispatcher.m2777dispatchPreFlingQWom1Mo(j10, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C10101) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher dispatcher) {
        super(context);
        t.i(context, "context");
        t.i(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        if (compositionContext != null) {
            WindowRecomposer_androidKt.setCompositionContext(this, compositionContext);
        }
        setSaveFromParentEnabled(false);
        this.update = AndroidViewHolder$update$1.INSTANCE;
        Modifier.Companion companion = Modifier.Companion;
        this.modifier = companion;
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.snapshotObserver = new SnapshotStateObserver(new AndroidViewHolder$snapshotObserver$1(this));
        this.onCommitAffectingUpdate = new AndroidViewHolder$onCommitAffectingUpdate$1(this);
        this.runUpdate = new AndroidViewHolder$runUpdate$1(this);
        this.location = new int[2];
        this.lastWidthMeasureSpec = Integer.MIN_VALUE;
        this.lastHeightMeasureSpec = Integer.MIN_VALUE;
        this.nestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        final LayoutNode layoutNode = new LayoutNode(false, 1, null);
        Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(DrawModifierKt.drawBehind(PointerInteropFilter_androidKt.pointerInteropFilter(companion, this), new AndroidViewHolder$layoutNode$1$coreModifier$1(layoutNode, this)), new AndroidViewHolder$layoutNode$1$coreModifier$2(this, layoutNode));
        layoutNode.setModifier(this.modifier.then(modifierOnGloballyPositioned));
        this.onModifierChanged = new AndroidViewHolder$layoutNode$1$1(layoutNode, modifierOnGloballyPositioned);
        layoutNode.setDensity(this.density);
        this.onDensityChanged = new AndroidViewHolder$layoutNode$1$2(layoutNode);
        n0 n0Var = new n0();
        layoutNode.setOnAttach$ui_release(new AndroidViewHolder$layoutNode$1$3(this, layoutNode, n0Var));
        layoutNode.setOnDetach$ui_release(new AndroidViewHolder$layoutNode$1$4(this, n0Var));
        layoutNode.setMeasurePolicy(new MeasurePolicy() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$layoutNode$1$5
            private final int intrinsicHeight(int i10) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder.getLayoutParams();
                t.f(layoutParams);
                androidViewHolder.measure(androidViewHolder.obtainMeasureSpec(0, i10, layoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
                return this.$this_run.getMeasuredHeight();
            }

            private final int intrinsicWidth(int i10) {
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                ViewGroup.LayoutParams layoutParams = androidViewHolder2.getLayoutParams();
                t.f(layoutParams);
                androidViewHolder.measure(iMakeMeasureSpec, androidViewHolder2.obtainMeasureSpec(0, i10, layoutParams.height));
                return this.$this_run.getMeasuredWidth();
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return intrinsicHeight(i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return intrinsicWidth(i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            @NotNull
            /* JADX INFO: renamed from: measure-3p2s80s */
            public MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measure, @NotNull List<? extends Measurable> measurables, long j10) {
                t.i(measure, "$this$measure");
                t.i(measurables, "measurables");
                if (Constraints.m3643getMinWidthimpl(j10) != 0) {
                    this.$this_run.getChildAt(0).setMinimumWidth(Constraints.m3643getMinWidthimpl(j10));
                }
                if (Constraints.m3642getMinHeightimpl(j10) != 0) {
                    this.$this_run.getChildAt(0).setMinimumHeight(Constraints.m3642getMinHeightimpl(j10));
                }
                AndroidViewHolder androidViewHolder = this.$this_run;
                int iM3643getMinWidthimpl = Constraints.m3643getMinWidthimpl(j10);
                int iM3641getMaxWidthimpl = Constraints.m3641getMaxWidthimpl(j10);
                ViewGroup.LayoutParams layoutParams = this.$this_run.getLayoutParams();
                t.f(layoutParams);
                int iObtainMeasureSpec = androidViewHolder.obtainMeasureSpec(iM3643getMinWidthimpl, iM3641getMaxWidthimpl, layoutParams.width);
                AndroidViewHolder androidViewHolder2 = this.$this_run;
                int iM3642getMinHeightimpl = Constraints.m3642getMinHeightimpl(j10);
                int iM3640getMaxHeightimpl = Constraints.m3640getMaxHeightimpl(j10);
                ViewGroup.LayoutParams layoutParams2 = this.$this_run.getLayoutParams();
                t.f(layoutParams2);
                androidViewHolder.measure(iObtainMeasureSpec, androidViewHolder2.obtainMeasureSpec(iM3642getMinHeightimpl, iM3640getMaxHeightimpl, layoutParams2.height));
                return MeasureScope.CC.p(measure, this.$this_run.getMeasuredWidth(), this.$this_run.getMeasuredHeight(), null, new AndroidViewHolder$layoutNode$1$5$measure$1(this.$this_run, layoutNode), 4, null);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return intrinsicHeight(i10);
            }

            @Override // androidx.compose.ui.layout.MeasurePolicy
            public int minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> measurables, int i10) {
                t.i(intrinsicMeasureScope, "<this>");
                t.i(measurables, "measurables");
                return intrinsicWidth(i10);
            }
        });
        this.layoutNode = layoutNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int obtainMeasureSpec(int i10, int i11, int i12) {
        return (i12 >= 0 || i10 == i11) ? View.MeasureSpec.makeMeasureSpec(o.n(i12, i10, i11), 1073741824) : (i12 != -2 || i11 == Integer.MAX_VALUE) ? (i12 != -1 || i11 == Integer.MAX_VALUE) ? View.MeasureSpec.makeMeasureSpec(0, 0) : View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(i11, Integer.MIN_VALUE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean gatherTransparentRegion(@Nullable Region region) {
        if (region == null) {
            return true;
        }
        getLocationInWindow(this.location);
        int[] iArr = this.location;
        int i10 = iArr[0];
        region.op(i10, iArr[1], i10 + getWidth(), this.location[1] + getHeight(), Region.Op.DIFFERENCE);
        return true;
    }

    @NotNull
    public final Density getDensity() {
        return this.density;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Override // android.view.View
    @Nullable
    public ViewGroup.LayoutParams getLayoutParams() {
        ViewGroup.LayoutParams layoutParams;
        View view = this.view;
        return (view == null || (layoutParams = view.getLayoutParams()) == null) ? new ViewGroup.LayoutParams(-1, -1) : layoutParams;
    }

    @Nullable
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.nestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Nullable
    public final l<Density, k0> getOnDensityChanged$ui_release() {
        return this.onDensityChanged;
    }

    @Nullable
    public final l<Modifier, k0> getOnModifierChanged$ui_release() {
        return this.onModifierChanged;
    }

    @Nullable
    public final l<Boolean, k0> getOnRequestDisallowInterceptTouchEvent$ui_release() {
        return this.onRequestDisallowInterceptTouchEvent;
    }

    @Nullable
    public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
        return this.savedStateRegistryOwner;
    }

    @NotNull
    public final h9.a<k0> getUpdate() {
        return this.update;
    }

    @Nullable
    public final View getView() {
        return this.view;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    @Nullable
    public ViewParent invalidateChildInParent(@Nullable int[] iArr, @Nullable Rect rect) {
        super.invalidateChildInParent(iArr, rect);
        this.layoutNode.invalidateLayer$ui_release();
        return null;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        View view = this.view;
        return view != null ? view.isNestedScrollingEnabled() : super.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.snapshotObserver.start();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onDescendantInvalidated(@NotNull View child, @NotNull View target) {
        t.i(child, "child");
        t.i(target, "target");
        super.onDescendantInvalidated(child, target);
        this.layoutNode.invalidateLayer$ui_release();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.snapshotObserver.stop();
        this.snapshotObserver.clear();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        View view = this.view;
        if (view != null) {
            view.layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        View view = this.view;
        if (view != null) {
            view.measure(i10, i11);
        }
        View view2 = this.view;
        int measuredWidth = view2 != null ? view2.getMeasuredWidth() : 0;
        View view3 = this.view;
        setMeasuredDimension(measuredWidth, view3 != null ? view3.getMeasuredHeight() : 0);
        this.lastWidthMeasureSpec = i10;
        this.lastHeightMeasureSpec = i11;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NotNull View target, float f10, float f11, boolean z10) {
        t.i(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        k.d(this.dispatcher.getCoroutineScope(), null, null, new AnonymousClass1(z10, this, VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f10), AndroidViewHolder_androidKt.toComposeVelocity(f11)), null), 3, null);
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float f10, float f11) {
        t.i(target, "target");
        if (!isNestedScrollingEnabled()) {
            return false;
        }
        k.d(this.dispatcher.getCoroutineScope(), null, null, new C10101(VelocityKt.Velocity(AndroidViewHolder_androidKt.toComposeVelocity(f10), AndroidViewHolder_androidKt.toComposeVelocity(f11)), null), 3, null);
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int i10, int i11, @NotNull int[] consumed, int i12) {
        t.i(target, "target");
        t.i(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long jM2778dispatchPreScrollOzD1aCk = this.dispatcher.m2778dispatchPreScrollOzD1aCk(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i10), AndroidViewHolder_androidKt.toComposeOffset(i11)), AndroidViewHolder_androidKt.toNestedScrollSource(i12));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1367getXimpl(jM2778dispatchPreScrollOzD1aCk));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1368getYimpl(jM2778dispatchPreScrollOzD1aCk));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NotNull View target, int i10, int i11, int i12, int i13, int i14, @NotNull int[] consumed) {
        t.i(target, "target");
        t.i(consumed, "consumed");
        if (isNestedScrollingEnabled()) {
            long jM2776dispatchPostScrollDzOQY0M = this.dispatcher.m2776dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i10), AndroidViewHolder_androidKt.toComposeOffset(i11)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i12), AndroidViewHolder_androidKt.toComposeOffset(i13)), AndroidViewHolder_androidKt.toNestedScrollSource(i14));
            consumed[0] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1367getXimpl(jM2776dispatchPostScrollDzOQY0M));
            consumed[1] = NestedScrollInteropConnectionKt.composeToViewOffset(Offset.m1368getYimpl(jM2776dispatchPostScrollDzOQY0M));
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int i10, int i11) {
        t.i(child, "child");
        t.i(target, "target");
        this.nestedScrollingParentHelper.onNestedScrollAccepted(child, target, i10, i11);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int i10, int i11) {
        t.i(child, "child");
        t.i(target, "target");
        return ((i10 & 2) == 0 && (i10 & 1) == 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int i10) {
        t.i(target, "target");
        this.nestedScrollingParentHelper.onStopNestedScroll(target, i10);
    }

    public final void remeasure() {
        int i10;
        int i11 = this.lastWidthMeasureSpec;
        if (i11 == Integer.MIN_VALUE || (i10 = this.lastHeightMeasureSpec) == Integer.MIN_VALUE) {
            return;
        }
        measure(i11, i10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        l<? super Boolean, k0> lVar = this.onRequestDisallowInterceptTouchEvent;
        if (lVar != null) {
            lVar.invoke(Boolean.valueOf(z10));
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public final void setDensity(@NotNull Density value) {
        t.i(value, "value");
        if (value != this.density) {
            this.density = value;
            l<? super Density, k0> lVar = this.onDensityChanged;
            if (lVar != null) {
                lVar.invoke(value);
            }
        }
    }

    public final void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != this.lifecycleOwner) {
            this.lifecycleOwner = lifecycleOwner;
            ViewTreeLifecycleOwner.set(this, lifecycleOwner);
        }
    }

    public final void setModifier(@NotNull Modifier value) {
        t.i(value, "value");
        if (value != this.modifier) {
            this.modifier = value;
            l<? super Modifier, k0> lVar = this.onModifierChanged;
            if (lVar != null) {
                lVar.invoke(value);
            }
        }
    }

    public final void setOnDensityChanged$ui_release(@Nullable l<? super Density, k0> lVar) {
        this.onDensityChanged = lVar;
    }

    public final void setOnModifierChanged$ui_release(@Nullable l<? super Modifier, k0> lVar) {
        this.onModifierChanged = lVar;
    }

    public final void setOnRequestDisallowInterceptTouchEvent$ui_release(@Nullable l<? super Boolean, k0> lVar) {
        this.onRequestDisallowInterceptTouchEvent = lVar;
    }

    public final void setSavedStateRegistryOwner(@Nullable SavedStateRegistryOwner savedStateRegistryOwner) {
        if (savedStateRegistryOwner != this.savedStateRegistryOwner) {
            this.savedStateRegistryOwner = savedStateRegistryOwner;
            ViewTreeSavedStateRegistryOwner.set(this, savedStateRegistryOwner);
        }
    }

    protected final void setUpdate(@NotNull h9.a<k0> value) {
        t.i(value, "value");
        this.update = value;
        this.hasUpdateBlock = true;
        this.runUpdate.invoke();
    }

    public final void setView$ui_release(@Nullable View view) {
        if (view != this.view) {
            this.view = view;
            removeAllViews();
            if (view != null) {
                addView(view);
                this.runUpdate.invoke();
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NotNull View target, int i10, int i11, int i12, int i13, int i14) {
        t.i(target, "target");
        if (isNestedScrollingEnabled()) {
            this.dispatcher.m2776dispatchPostScrollDzOQY0M(OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i10), AndroidViewHolder_androidKt.toComposeOffset(i11)), OffsetKt.Offset(AndroidViewHolder_androidKt.toComposeOffset(i12), AndroidViewHolder_androidKt.toComposeOffset(i13)), AndroidViewHolder_androidKt.toNestedScrollSource(i14));
        }
    }
}
