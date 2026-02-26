package androidx.compose.material.internal;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.platform.e2;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import h9.a;
import h9.p;
import java.util.UUID;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
final class PopupLayout extends AbstractComposeView implements ViewRootForInspector, ViewTreeObserver.OnGlobalLayoutListener {

    @NotNull
    private final State canCalculatePosition$delegate;

    @NotNull
    private final View composeView;

    @NotNull
    private final MutableState content$delegate;

    @NotNull
    private final p<Offset, IntRect, Boolean> dismissOnOutsideClick;
    private final float maxSupportedElevation;

    @Nullable
    private a<k0> onDismissRequest;

    @NotNull
    private final WindowManager.LayoutParams params;

    @NotNull
    private final MutableState parentBounds$delegate;

    @NotNull
    private LayoutDirection parentLayoutDirection;

    @NotNull
    private final MutableState popupContentSize$delegate;

    @NotNull
    private PopupPositionProvider positionProvider;

    @NotNull
    private final Rect previousWindowVisibleFrame;
    private boolean shouldCreateCompositionOnAttachedToWindow;

    @NotNull
    private String testTag;

    @NotNull
    private final Rect tmpWindowVisibleFrame;

    @NotNull
    private final WindowManager windowManager;

    /* JADX INFO: renamed from: androidx.compose.material.internal.PopupLayout$Content$4, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
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

    /* JADX INFO: compiled from: ExposedDropdownMenuPopup.kt */
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
    public PopupLayout(@Nullable a<k0> aVar, @NotNull String testTag, @NotNull View composeView, @NotNull Density density, @NotNull PopupPositionProvider initialPositionProvider, @NotNull UUID popupId) {
        t.i(testTag, "testTag");
        t.i(composeView, "composeView");
        t.i(density, "density");
        t.i(initialPositionProvider, "initialPositionProvider");
        t.i(popupId, "popupId");
        Context context = composeView.getContext();
        t.h(context, "composeView.context");
        super(context, null, 0, 6, null);
        this.onDismissRequest = aVar;
        this.testTag = testTag;
        this.composeView = composeView;
        Object systemService = composeView.getContext().getSystemService("window");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
        }
        this.windowManager = (WindowManager) systemService;
        this.params = createLayoutParams();
        this.positionProvider = initialPositionProvider;
        this.parentLayoutDirection = LayoutDirection.Ltr;
        this.parentBounds$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.popupContentSize$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.canCalculatePosition$delegate = SnapshotStateKt.derivedStateOf(new PopupLayout$canCalculatePosition$2(this));
        float fM3673constructorimpl = Dp.m3673constructorimpl(30);
        this.maxSupportedElevation = fM3673constructorimpl;
        this.previousWindowVisibleFrame = new Rect();
        this.tmpWindowVisibleFrame = new Rect();
        this.dismissOnOutsideClick = PopupLayout$dismissOnOutsideClick$1.INSTANCE;
        setId(R.id.content);
        ViewTreeLifecycleOwner.set(this, ViewTreeLifecycleOwner.get(composeView));
        ViewTreeViewModelStoreOwner.set(this, ViewTreeViewModelStoreOwner.get(composeView));
        ViewTreeSavedStateRegistryOwner.set(this, ViewTreeSavedStateRegistryOwner.get(composeView));
        composeView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        setTag(androidx.compose.ui.R.id.compose_view_saveable_id_tag, "Popup:" + popupId);
        setClipChildren(false);
        setElevation(density.mo296toPx0680j_4(fM3673constructorimpl));
        setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.material.internal.PopupLayout.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(@NotNull View view, @NotNull Outline result) {
                t.i(view, "view");
                t.i(result, "result");
                result.setRect(0, 0, view.getWidth(), view.getHeight());
                result.setAlpha(0.0f);
            }
        });
        this.content$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposableSingletons$ExposedDropdownMenuPopupKt.INSTANCE.m1221getLambda1$material_release(), null, 2, null);
    }

    private final WindowManager.LayoutParams createLayoutParams() {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.flags = 393248;
        layoutParams.softInputMode = 1;
        layoutParams.type = 1000;
        layoutParams.token = this.composeView.getApplicationWindowToken();
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.setTitle(this.composeView.getContext().getResources().getString(androidx.compose.ui.R.string.default_popup_window_title));
        return layoutParams;
    }

    private final p<Composer, Integer, k0> getContent() {
        return (p) this.content$delegate.getValue();
    }

    private final void setContent(p<? super Composer, ? super Integer, k0> pVar) {
        this.content$delegate.setValue(pVar);
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

    private final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.compose.ui.platform.AbstractComposeView
    @Composable
    public void Content(@Nullable Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1288867704);
        getContent().mo4invoke(composerStartRestartGroup, 0);
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(i10));
    }

    public final void dismiss() {
        ViewTreeLifecycleOwner.set(this, null);
        this.composeView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        this.windowManager.removeViewImmediate(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        KeyEvent.DispatcherState keyDispatcherState;
        t.i(event, "event");
        if (event.getKeyCode() == 4) {
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

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final IntRect getParentBounds() {
        return (IntRect) this.parentBounds$delegate.getValue();
    }

    @NotNull
    public final LayoutDirection getParentLayoutDirection() {
        return this.parentLayoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    /* JADX INFO: renamed from: getPopupContentSize-bOM6tXw, reason: not valid java name */
    public final IntSize m1225getPopupContentSizebOM6tXw() {
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

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.composeView.getWindowVisibleDisplayFrame(this.tmpWindowVisibleFrame);
        if (t.d(this.tmpWindowVisibleFrame, this.previousWindowVisibleFrame)) {
            return;
        }
        updatePosition();
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0091  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@org.jetbrains.annotations.Nullable android.view.MotionEvent r9) {
        /*
            r8 = this;
            if (r9 != 0) goto L7
            boolean r9 = super.onTouchEvent(r9)
            return r9
        L7:
            int r0 = r9.getAction()
            r1 = 0
            if (r0 != 0) goto L38
            float r0 = r9.getX()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r9.getX()
            int r2 = r8.getWidth()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
            float r0 = r9.getY()
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L3f
            float r0 = r9.getY()
            int r2 = r8.getHeight()
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L3f
        L38:
            int r0 = r9.getAction()
            r2 = 4
            if (r0 != r2) goto L99
        L3f:
            androidx.compose.ui.unit.IntRect r0 = r8.getParentBounds()
            r2 = 1
            if (r0 == 0) goto L8e
            h9.p<androidx.compose.ui.geometry.Offset, androidx.compose.ui.unit.IntRect, java.lang.Boolean> r3 = r8.dismissOnOutsideClick
            float r4 = r9.getX()
            int r4 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            r5 = 0
            if (r4 != 0) goto L53
            r4 = r2
            goto L54
        L53:
            r4 = r5
        L54:
            if (r4 == 0) goto L66
            float r4 = r9.getY()
            int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r1 != 0) goto L60
            r1 = r2
            goto L61
        L60:
            r1 = r5
        L61:
            if (r1 != 0) goto L64
            goto L66
        L64:
            r1 = 0
            goto L82
        L66:
            android.view.WindowManager$LayoutParams r1 = r8.params
            int r1 = r1.x
            float r1 = (float) r1
            float r4 = r9.getX()
            float r1 = r1 + r4
            android.view.WindowManager$LayoutParams r4 = r8.params
            int r4 = r4.y
            float r4 = (float) r4
            float r6 = r9.getY()
            float r4 = r4 + r6
            long r6 = androidx.compose.ui.geometry.OffsetKt.Offset(r1, r4)
            androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m1356boximpl(r6)
        L82:
            java.lang.Object r0 = r3.mo4invoke(r1, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L8f
        L8e:
            r5 = r2
        L8f:
            if (r5 == 0) goto L99
            h9.a<v8.k0> r9 = r8.onDismissRequest
            if (r9 == 0) goto L98
            r9.invoke()
        L98:
            return r2
        L99:
            boolean r9 = super.onTouchEvent(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.internal.PopupLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setParentBounds(@Nullable IntRect intRect) {
        this.parentBounds$delegate.setValue(intRect);
    }

    public final void setParentLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        t.i(layoutDirection, "<set-?>");
        this.parentLayoutDirection = layoutDirection;
    }

    /* JADX INFO: renamed from: setPopupContentSize-fhxjrPA, reason: not valid java name */
    public final void m1226setPopupContentSizefhxjrPA(@Nullable IntSize intSize) {
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

    public final void updateParameters(@Nullable a<k0> aVar, @NotNull String testTag, @NotNull LayoutDirection layoutDirection) {
        t.i(testTag, "testTag");
        t.i(layoutDirection, "layoutDirection");
        this.onDismissRequest = aVar;
        this.testTag = testTag;
        superSetLayoutDirection(layoutDirection);
    }

    public final void updatePosition() {
        IntSize intSizeM1225getPopupContentSizebOM6tXw;
        IntRect parentBounds = getParentBounds();
        if (parentBounds == null || (intSizeM1225getPopupContentSizebOM6tXw = m1225getPopupContentSizebOM6tXw()) == null) {
            return;
        }
        long jM3837unboximpl = intSizeM1225getPopupContentSizebOM6tXw.m3837unboximpl();
        Rect rect = this.previousWindowVisibleFrame;
        this.composeView.getWindowVisibleDisplayFrame(rect);
        IntRect intBounds = toIntBounds(rect);
        long jMo758calculatePositionllwVHH4 = this.positionProvider.mo758calculatePositionllwVHH4(parentBounds, IntSizeKt.IntSize(intBounds.getWidth(), intBounds.getHeight()), this.parentLayoutDirection, jM3837unboximpl);
        this.params.x = IntOffset.m3791getXimpl(jMo758calculatePositionllwVHH4);
        this.params.y = IntOffset.m3792getYimpl(jMo758calculatePositionllwVHH4);
        this.windowManager.updateViewLayout(this, this.params);
    }

    public final void setContent(@NotNull CompositionContext parent, @NotNull p<? super Composer, ? super Integer, k0> content) {
        t.i(parent, "parent");
        t.i(content, "content");
        setParentCompositionContext(parent);
        setContent(content);
        this.shouldCreateCompositionOnAttachedToWindow = true;
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
