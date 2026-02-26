package androidx.compose.ui.window;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.R;
import androidx.compose.ui.UiComposable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.platform.e2;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import h9.a;
import h9.p;
import j9.c;
import java.util.UUID;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: AndroidPopup.android.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
public final class PopupLayout extends AbstractComposeView implements ViewRootForInspector {

    @NotNull
    private final State canCalculatePosition$delegate;

    @NotNull
    private final View composeView;

    @NotNull
    private final MutableState content$delegate;

    @NotNull
    private final int[] locationOnScreen;
    private final float maxSupportedElevation;

    @Nullable
    private a<k0> onDismissRequest;

    @NotNull
    private final WindowManager.LayoutParams params;

    @Nullable
    private IntRect parentBounds;

    @NotNull
    private final MutableState parentLayoutCoordinates$delegate;

    @NotNull
    private LayoutDirection parentLayoutDirection;

    @NotNull
    private final MutableState popupContentSize$delegate;

    @NotNull
    private final PopupLayoutHelper popupLayoutHelper;

    @NotNull
    private PopupPositionProvider positionProvider;

    @NotNull
    private final Rect previousWindowVisibleFrame;

    @NotNull
    private PopupProperties properties;
    private boolean shouldCreateCompositionOnAttachedToWindow;

    @NotNull
    private String testTag;

    @NotNull
    private final WindowManager windowManager;

    /* JADX INFO: renamed from: androidx.compose.ui.window.PopupLayout$Content$4, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidPopup.android.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(int i10) {
            super(2);
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            PopupLayout.this.Content(composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: compiled from: AndroidPopup.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ PopupLayout(a aVar, PopupProperties popupProperties, String str, View view, Density density, PopupPositionProvider popupPositionProvider, UUID uuid, PopupLayoutHelper popupLayoutHelper, int i10, k kVar) {
        PopupLayoutHelper popupLayoutHelperImpl29;
        if ((i10 & 128) != 0) {
            popupLayoutHelperImpl29 = Build.VERSION.SDK_INT >= 29 ? new PopupLayoutHelperImpl29() : new PopupLayoutHelperImpl();
        } else {
            popupLayoutHelperImpl29 = popupLayoutHelper;
        }
        this(aVar, popupProperties, str, view, density, popupPositionProvider, uuid, popupLayoutHelperImpl29);
    }

    private final void applyNewFlags(int i10) {
        WindowManager.LayoutParams layoutParams = this.params;
        layoutParams.flags = i10;
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, layoutParams);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = (layoutParams.flags & (-8552473)) | 262144;
        layoutParams.type = 1002;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(R.string.default_popup_window_title));
        return layoutParams;
    }

    private final p<Composer, Integer, k0> getContent() {
        return (p) this.content$delegate.getValue();
    }

    private final int getDisplayHeight() {
        return c.c(getContext().getResources().getConfiguration().screenHeightDp * getContext().getResources().getDisplayMetrics().density);
    }

    private final int getDisplayWidth() {
        return c.c(getContext().getResources().getConfiguration().screenWidthDp * getContext().getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates getParentLayoutCoordinates() {
        return (LayoutCoordinates) this.parentLayoutCoordinates$delegate.getValue();
    }

    private final void setClippingEnabled(boolean z10) {
        applyNewFlags(z10 ? this.params.flags & (-513) : this.params.flags | 512);
    }

    private final void setContent(p<? super Composer, ? super Integer, k0> pVar) {
        this.content$delegate.setValue(pVar);
    }

    private final void setIsFocusable(boolean z10) {
        applyNewFlags(!z10 ? this.params.flags | 8 : this.params.flags & (-9));
    }

    private final void setParentLayoutCoordinates(LayoutCoordinates layoutCoordinates) {
        this.parentLayoutCoordinates$delegate.setValue(layoutCoordinates);
    }

    private final void setSecurePolicy(SecureFlagPolicy secureFlagPolicy) {
        applyNewFlags(SecureFlagPolicy_androidKt.shouldApplySecureFlag(secureFlagPolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView)) ? this.params.flags | 8192 : this.params.flags & (-8193));
    }

    private final void superSetLayoutDirection(LayoutDirection layoutDirection) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 != 2) {
            throw new q();
        }
        super.setLayoutDirection(i11);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    @Composable
    @UiComposable
    public void Content(@Nullable Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-857613600);
        getContent().mo4invoke(composerStartRestartGroup, 0);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(i10));
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        this.windowManager.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        KeyEvent.DispatcherState keyDispatcherState;
        t.i(event, "event");
        if (event.getKeyCode() == 4 && this.properties.getDismissOnBackPress()) {
            if (getKeyDispatcherState() == null) {
                return super.dispatchKeyEvent(event);
            }
            if (event.getAction() == 0 && event.getRepeatCount() == 0) {
                KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                if (keyDispatcherState2 != null) {
                    keyDispatcherState2.startTracking(event, this);
                }
                return true;
            }
            if (event.getAction() == 1 && (keyDispatcherState = getKeyDispatcherState()) != null && keyDispatcherState.isTracking(event) && !event.isCanceled()) {
                a<k0> aVar = this.onDismissRequest;
                if (aVar != null) {
                    aVar.invoke();
                }
                return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public final boolean getCanCalculatePosition() {
        return ((Boolean) this.canCalculatePosition$delegate.getValue()).booleanValue();
    }

    @NotNull
    public final WindowManager.LayoutParams getParams$ui_release() {
        return this.params;
    }

    @NotNull
    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m3921getPopupContentSizebOM6tXw() {
        return (IntSize) this.popupContentSize$delegate.getValue();
    }

    @NotNull
    public final PopupPositionProvider getPositionProvider() {
        return this.positionProvider;
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    protected boolean getShouldCreateCompositionOnAttachedToWindow() {
        return this.shouldCreateCompositionOnAttachedToWindow;
    }

    @NotNull
    public final String getTestTag() {
        return this.testTag;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* synthetic */ View getViewRoot() {
        return e2.b(this);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnLayout$ui_release(boolean z10, int i10, int i11, int i12, int i13) {
        super.internalOnLayout$ui_release(z10, i10, i11, i12, i13);
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.params.width = childAt.getMeasuredWidth();
        this.params.height = childAt.getMeasuredHeight();
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    public void internalOnMeasure$ui_release(int i10, int i11) {
        if (this.properties.getUsePlatformDefaultWidth()) {
            super.internalOnMeasure$ui_release(i10, i11);
        } else {
            super.internalOnMeasure$ui_release(View.MeasureSpec.makeMeasureSpec(getDisplayWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getDisplayHeight(), Integer.MIN_VALUE));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent motionEvent) {
        if (!this.properties.getDismissOnClickOutside()) {
            return super.onTouchEvent(motionEvent);
        }
        boolean z10 = false;
        if ((motionEvent != null && motionEvent.getAction() == 0) && (motionEvent.getX() < 0.0f || motionEvent.getX() >= getWidth() || motionEvent.getY() < 0.0f || motionEvent.getY() >= getHeight())) {
            a<k0> aVar = this.onDismissRequest;
            if (aVar != null) {
                aVar.invoke();
            }
            return true;
        }
        if (motionEvent != null && motionEvent.getAction() == 4) {
            z10 = true;
        }
        if (!z10) {
            return super.onTouchEvent(motionEvent);
        }
        a<k0> aVar2 = this.onDismissRequest;
        if (aVar2 != null) {
            aVar2.invoke();
        }
        return true;
    }

    public final void pollForLocationOnScreenChange() {
        int[] iArr = this.locationOnScreen;
        int i10 = iArr[0];
        int i11 = iArr[1];
        this.composeView.getLocationOnScreen(iArr);
        int[] iArr2 = this.locationOnScreen;
        if (i10 == iArr2[0] && i11 == iArr2[1]) {
            return;
        }
        updateParentBounds$ui_release();
    }

    public final void setParentLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<set-?>");
        this.parentLayoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m3922setPopupContentSizefhxjrPA(@Nullable IntSize intSize) {
        this.popupContentSize$delegate.setValue(intSize);
    }

    public final void setPositionProvider(@NotNull PopupPositionProvider popupPositionProvider) {
        t.i(popupPositionProvider, "<set-?>");
        this.positionProvider = popupPositionProvider;
    }

    public final void setTestTag(@NotNull String str) {
        t.i(str, "<set-?>");
        this.testTag = str;
    }

    public final void show() {
        this.windowManager.addView(this, this.params);
    }

    public final void updateParameters(@Nullable a<k0> aVar, @NotNull PopupProperties properties, @NotNull String testTag, @NotNull LayoutDirection layoutDirection) {
        t.i(properties, "properties");
        t.i(testTag, "testTag");
        t.i(layoutDirection, "layoutDirection");
        this.onDismissRequest = aVar;
        this.properties = properties;
        this.testTag = testTag;
        setIsFocusable(properties.getFocusable());
        setSecurePolicy(properties.getSecurePolicy());
        setClippingEnabled(properties.getClippingEnabled());
        superSetLayoutDirection(layoutDirection);
    }

    @VisibleForTesting(otherwise = 2)
    public final void updateParentBounds$ui_release() {
        LayoutCoordinates parentLayoutCoordinates = getParentLayoutCoordinates();
        if (parentLayoutCoordinates == null) {
            return;
        }
        long jMo2989getSizeYbymL2g = parentLayoutCoordinates.mo2989getSizeYbymL2g();
        long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
        IntRect intRectM3823IntRectVbeCjmY = IntRectKt.m3823IntRectVbeCjmY(IntOffsetKt.IntOffset(c.c(Offset.m1367getXimpl(jPositionInWindow)), c.c(Offset.m1368getYimpl(jPositionInWindow))), jMo2989getSizeYbymL2g);
        if (t.d(intRectM3823IntRectVbeCjmY, this.parentBounds)) {
            return;
        }
        this.parentBounds = intRectM3823IntRectVbeCjmY;
        updatePosition();
    }

    public final void updateParentLayoutCoordinates(@NotNull LayoutCoordinates parentLayoutCoordinates) {
        t.i(parentLayoutCoordinates, "parentLayoutCoordinates");
        setParentLayoutCoordinates(parentLayoutCoordinates);
        updateParentBounds$ui_release();
    }

    public final void updatePosition() {
        IntSize intSizeM3921getPopupContentSizebOM6tXw;
        IntRect intRect = this.parentBounds;
        if (intRect == null || (intSizeM3921getPopupContentSizebOM6tXw = m3921getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long jM3837unboximpl = intSizeM3921getPopupContentSizebOM6tXw.m3837unboximpl();
        Rect rect = this.previousWindowVisibleFrame;
        this.popupLayoutHelper.getWindowVisibleDisplayFrame(this.composeView, rect);
        IntRect intBounds = AndroidPopup_androidKt.toIntBounds(rect);
        long jIntSize = IntSizeKt.IntSize(intBounds.getWidth(), intBounds.getHeight());
        long jMo758calculatePositionllwVHH4 = this.positionProvider.mo758calculatePositionllwVHH4(intRect, jIntSize, this.parentLayoutDirection, jM3837unboximpl);
        this.params.x = IntOffset.m3791getXimpl(jMo758calculatePositionllwVHH4);
        this.params.y = IntOffset.m3792getYimpl(jMo758calculatePositionllwVHH4);
        if (this.properties.getExcludeFromSystemGesture()) {
            this.popupLayoutHelper.setGestureExclusionRects(this, IntSize.m3833getWidthimpl(jIntSize), IntSize.m3832getHeightimpl(jIntSize));
        }
        this.popupLayoutHelper.updateViewLayout(this.windowManager, this, this.params);
    }

    public final void setContent(@NotNull CompositionContext parent, @NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(parent, "parent");
        t.i(content, "content");
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public PopupLayout(@Nullable a<k0> aVar, @NotNull PopupProperties properties, @NotNull String testTag, @NotNull View composeView, @NotNull Density density, @NotNull PopupPositionProvider initialPositionProvider, @NotNull UUID popupId, @NotNull PopupLayoutHelper popupLayoutHelper) {
        t.i(properties, "properties");
        t.i(testTag, "testTag");
        t.i(composeView, "composeView");
        t.i(density, "density");
        t.i(initialPositionProvider, "initialPositionProvider");
        t.i(popupId, "popupId");
        t.i(popupLayoutHelper, "popupLayoutHelper");
        Context context = composeView.getContext();
        t.h(context, "composeView.context");
        super(context, null, 0, 6, null);
        this.onDismissRequest = aVar;
        this.properties = properties;
        this.testTag = testTag;
        this.composeView = composeView;
        this.popupLayoutHelper = popupLayoutHelper;
        Object systemService = composeView.getContext().getSystemService("window");
        if (systemService != null) {
            this.windowManager = (WindowManager) systemService;
            this.params = createLayoutParams();
            this.positionProvider = initialPositionProvider;
            this.parentLayoutDirection = LayoutDirection.Ltr;
            this.popupContentSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.parentLayoutCoordinates$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
            this.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new PopupLayout$canCalculatePosition$2(this));
            float fM3673constructorimpl = Dp.m3673constructorimpl(30);
            this.maxSupportedElevation = fM3673constructorimpl;
            this.previousWindowVisibleFrame = new Rect();
            setId(android.R.id.content);
            ViewTreeLifecycleOwner.set(this, ViewTreeLifecycleOwner.get(composeView));
            ViewTreeViewModelStoreOwner.set(this, ViewTreeViewModelStoreOwner.get(composeView));
            ViewTreeSavedStateRegistryOwner.set(this, ViewTreeSavedStateRegistryOwner.get(composeView));
            setTag(R.id.compose_view_saveable_id_tag, "Popup:" + popupId);
            setClipChildren(false);
            setElevation(density.mo296toPx0680j_4(fM3673constructorimpl));
            setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.ui.window.PopupLayout.2
                @Override // android.view.ViewOutlineProvider
                public void getOutline(@NotNull View view, @NotNull Outline result) {
                    t.i(view, "view");
                    t.i(result, "result");
                    result.setRect(0, 0, view.getWidth(), view.getHeight());
                    result.setAlpha(0.0f);
                }
            });
            this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$AndroidPopup_androidKt.INSTANCE.m3920getLambda1$ui_release(), null, 2, null);
            this.locationOnScreen = new int[2];
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getParams$ui_release$annotations() {
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    @NotNull
    public AbstractComposeView getSubCompositionView() {
        return this;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
    }
}
