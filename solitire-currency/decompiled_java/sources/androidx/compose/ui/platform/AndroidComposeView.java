package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusManagerImpl;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconDefaults;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.semantics.SemanticsEntity;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidComposeView.android.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor", "VisibleForTests"})
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;

    @Nullable
    private static Method getBooleanMethod;

    @Nullable
    private static Class<?> systemPropertiesClass;

    @Nullable
    private AndroidViewsHandler _androidViewsHandler;

    @Nullable
    private final AndroidAutofill _autofill;

    @NotNull
    private final FocusManagerImpl _focusManager;

    @NotNull
    private final InputModeManagerImpl _inputModeManager;

    @NotNull
    private final WindowInfoImpl _windowInfo;

    @NotNull
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;

    @NotNull
    private final AndroidAccessibilityManager accessibilityManager;

    @NotNull
    private final AutofillTree autofillTree;

    @NotNull
    private final CanvasHolder canvasHolder;

    @NotNull
    private final AndroidClipboardManager clipboardManager;

    @NotNull
    private h9.l<? super Configuration, v8.k0> configurationChangeObserver;
    private int currentFontWeightAdjustment;

    @NotNull
    private Density density;

    @Nullable
    private PointerIcon desiredPointerIcon;

    @NotNull
    private final List<OwnedLayer> dirtyLayers;

    @NotNull
    private final MutableVector<h9.a<v8.k0>> endApplyChangesListeners;

    @NotNull
    private final MutableState fontFamilyResolver$delegate;

    @NotNull
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;

    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;

    @NotNull
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;

    @NotNull
    private final KeyInputModifier keyInputModifier;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;

    @NotNull
    private final WeakCache<OwnedLayer> layerCache;

    @NotNull
    private final MutableState layoutDirection$delegate;

    @NotNull
    private final CalculateMatrixToWindow matrixToWindow;

    @NotNull
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;

    @NotNull
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;

    @Nullable
    private Constraints onMeasureConstraints;

    @Nullable
    private h9.l<? super ViewTreeOwners, v8.k0> onViewTreeOwnersAvailable;

    @NotNull
    private final PointerIconService pointerIconService;

    @NotNull
    private final PointerInputEventProcessor pointerInputEventProcessor;

    @Nullable
    private List<OwnedLayer> postponedDirtyLayers;

    @Nullable
    private MotionEvent previousMotionEvent;
    private long relayoutTime;

    @NotNull
    private final h9.a<v8.k0> resendMotionEventOnLayout;

    @NotNull
    private final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;

    @NotNull
    private final LayoutNode root;

    @NotNull
    private final RootForTest rootForTest;

    @NotNull
    private final Modifier rotaryInputModifier;

    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;

    @NotNull
    private final SemanticsModifierCore semanticsModifier;

    @NotNull
    private final SemanticsOwner semanticsOwner;

    @NotNull
    private final Runnable sendHoverExitEvent;

    @NotNull
    private final LayoutNodeDrawScope sharedDrawScope;
    private boolean showLayoutBounds;

    @NotNull
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete;

    @NotNull
    private final TextInputService textInputService;

    @NotNull
    private final TextInputServiceAndroid textInputServiceAndroid;

    @NotNull
    private final TextToolbar textToolbar;

    @NotNull
    private final int[] tmpPositionArray;

    @NotNull
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;

    @NotNull
    private final ViewConfiguration viewConfiguration;

    @Nullable
    private DrawChildContainer viewLayersContainer;

    @NotNull
    private final float[] viewToWindowMatrix;

    @NotNull
    private final MutableState viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;

    @NotNull
    private final float[] windowToViewMatrix;

    /* JADX INFO: compiled from: AndroidComposeView.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @SuppressLint({"PrivateApi", "BanUncheckedReflection"})
        public final boolean getIsShowingLayoutBounds() {
            try {
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class cls = AndroidComposeView.systemPropertiesClass;
                    AndroidComposeView.getBooleanMethod = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
                }
                Method method = AndroidComposeView.getBooleanMethod;
                Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
                Boolean bool = objInvoke instanceof Boolean ? (Boolean) objInvoke : null;
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    /* JADX INFO: compiled from: AndroidComposeView.android.kt */
    @StabilityInferred(parameters = 0)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;

        @NotNull
        private final LifecycleOwner lifecycleOwner;

        @NotNull
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(@NotNull LifecycleOwner lifecycleOwner, @NotNull SavedStateRegistryOwner savedStateRegistryOwner) {
            kotlin.jvm.internal.t.i(lifecycleOwner, "lifecycleOwner");
            kotlin.jvm.internal.t.i(savedStateRegistryOwner, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner;
            this.savedStateRegistryOwner = savedStateRegistryOwner;
        }

        @NotNull
        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        @NotNull
        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1] */
    public AndroidComposeView(@NotNull Context context) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        Offset.Companion companion = Offset.Companion;
        this.lastDownPointerPosition = companion.m1382getUnspecifiedF1C5BW0();
        int i10 = 1;
        this.superclassInitComplete = true;
        this.sharedDrawScope = new LayoutNodeDrawScope(null, i10, 0 == true ? 1 : 0);
        this.density = AndroidDensity_androidKt.Density(context);
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(SemanticsModifierCore.Companion.generateSemanticsId(), false, false, AndroidComposeView$semanticsModifier$1.INSTANCE);
        this.semanticsModifier = semanticsModifierCore;
        FocusManagerImpl focusManagerImpl = new FocusManagerImpl(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0);
        this._focusManager = focusManagerImpl;
        this._windowInfo = new WindowInfoImpl();
        KeyInputModifier keyInputModifier = new KeyInputModifier(new AndroidComposeView$keyInputModifier$1(this), null);
        this.keyInputModifier = keyInputModifier;
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier modifierOnRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = modifierOnRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, i10, 0 == true ? 1 : 0);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setModifier(companion2.then(semanticsModifierCore).then(modifierOnRotaryScrollEvent).then(focusManagerImpl.getModifier()).then(keyInputModifier));
        layoutNode.setDensity(getDensity());
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        this._autofill = autofillSupported() ? new AndroidAutofill(this, getAutofillTree()) : null;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(context);
        kotlin.jvm.internal.t.h(viewConfiguration, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration);
        this.globalPosition = IntOffset.Companion.m3801getZeronOccac();
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m1776constructorimpl$default(null, 1, null);
        this.windowToViewMatrix = Matrix.m1776constructorimpl$default(null, 1, null);
        this.lastMatrixRecalculationAnimationTime = -1L;
        this.windowPosition = companion.m1381getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.globalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.compose.ui.platform.d
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                AndroidComposeView.m3152globalLayoutListener$lambda1(this.f799a);
            }
        };
        this.scrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: androidx.compose.ui.platform.e
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                AndroidComposeView.m3154scrollChangedListener$lambda2(this.f800a);
            }
        };
        this.touchModeChangeListener = new ViewTreeObserver.OnTouchModeChangeListener() { // from class: androidx.compose.ui.platform.f
            @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
            public final void onTouchModeChanged(boolean z10) {
                AndroidComposeView.m3157touchModeChangeListener$lambda3(this.f801a, z10);
            }
        };
        TextInputServiceAndroid textInputServiceAndroid = new TextInputServiceAndroid(this);
        this.textInputServiceAndroid = textInputServiceAndroid;
        this.textInputService = AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(textInputServiceAndroid);
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        kotlin.jvm.internal.t.h(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        kotlin.jvm.internal.t.h(configuration2, "context.resources.configuration");
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), null, 2, null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        this._inputModeManager = new InputModeManagerImpl(isInTouchMode() ? InputMode.Companion.m2158getTouchaOaMEAU() : InputMode.Companion.m2157getKeyboardaOaMEAU(), new AndroidComposeView$_inputModeManager$1(this), null);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new h9.a[16], 0);
        this.resendMotionEventRunnable = new Runnable() { // from class: androidx.compose.ui.platform.AndroidComposeView$resendMotionEventRunnable$1
            @Override // java.lang.Runnable
            public void run() {
                this.this$0.removeCallbacks(this);
                MotionEvent motionEvent = this.this$0.previousMotionEvent;
                if (motionEvent != null) {
                    boolean z10 = false;
                    boolean z11 = motionEvent.getToolType(0) == 3;
                    int actionMasked = motionEvent.getActionMasked();
                    if (!z11 ? actionMasked != 1 : !(actionMasked == 10 || actionMasked == 1)) {
                        z10 = true;
                    }
                    if (z10) {
                        int i11 = 7;
                        if (actionMasked != 7 && actionMasked != 9) {
                            i11 = 2;
                        }
                        AndroidComposeView androidComposeView = this.this$0;
                        androidComposeView.sendSimulatedEvent(motionEvent, i11, androidComposeView.relayoutTime, false);
                    }
                }
            }
        };
        this.sendHoverExitEvent = new Runnable() { // from class: androidx.compose.ui.platform.g
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeView.m3155sendHoverExitEvent$lambda5(this.f802a);
            }
        };
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        int i11 = Build.VERSION.SDK_INT;
        this.matrixToWindow = i11 >= 29 ? new CalculateMatrixToWindowApi29() : new CalculateMatrixToWindowApi21();
        setWillNotDraw(false);
        setFocusable(true);
        if (i11 >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        setTransitionGroup(true);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        h9.l<ViewRootForTest, v8.k0> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (i11 >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new PointerIconService() { // from class: androidx.compose.ui.platform.AndroidComposeView$pointerIconService$1
            @Override // androidx.compose.ui.input.pointer.PointerIconService
            @NotNull
            public PointerIcon getCurrent() {
                PointerIcon pointerIcon = this.this$0.desiredPointerIcon;
                return pointerIcon == null ? PointerIconDefaults.INSTANCE.getDefault() : pointerIcon;
            }

            @Override // androidx.compose.ui.input.pointer.PointerIconService
            public void setCurrent(@NotNull PointerIcon value) {
                kotlin.jvm.internal.t.i(value, "value");
                this.this$0.desiredPointerIcon = value;
            }
        };
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    private final v8.s<Integer, Integer> convertMeasureSpec(int i10) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (mode == Integer.MIN_VALUE) {
            return v8.y.a(0, Integer.valueOf(size));
        }
        if (mode == 0) {
            return v8.y.a(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return v8.y.a(Integer.valueOf(size), Integer.valueOf(size));
        }
        throw new IllegalStateException();
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i10, View view) throws NoSuchMethodException {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (kotlin.jvm.internal.t.d(declaredMethod.invoke(view, new Object[0]), Integer.valueOf(i10))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            kotlin.jvm.internal.t.h(childAt, "currentView.getChildAt(i)");
            View viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i10, childAt);
            if (viewFindViewByAccessibilityIdRootedAtCurrentView != null) {
                return viewFindViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: globalLayoutListener$lambda-1, reason: not valid java name */
    public static final void m3152globalLayoutListener$lambda1(AndroidComposeView this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: renamed from: handleMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m3153handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z10 = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            this.desiredPointerIcon = null;
            Trace.beginSection("AndroidOwner:onTouch");
            try {
                int actionMasked = motionEvent.getActionMasked();
                MotionEvent motionEvent2 = this.previousMotionEvent;
                boolean z11 = motionEvent2 != null && motionEvent2.getToolType(0) == 3;
                if (motionEvent2 != null && hasChangedDevices(motionEvent, motionEvent2)) {
                    if (isDevicePressEvent(motionEvent2)) {
                        this.pointerInputEventProcessor.processCancel();
                    } else if (motionEvent2.getActionMasked() != 10 && z11) {
                        sendSimulatedEvent$default(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, null);
                    }
                }
                if (motionEvent.getToolType(0) != 3) {
                    z10 = false;
                }
                if (!z11 && z10 && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                    sendSimulatedEvent$default(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, null);
                }
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                int iM3156sendMotionEvent8iAsVTc = m3156sendMotionEvent8iAsVTc(motionEvent);
                Trace.endSection();
                if (Build.VERSION.SDK_INT >= 24) {
                    AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this, this.desiredPointerIcon);
                }
                return iM3156sendMotionEvent8iAsVTc;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } finally {
            this.forceUseMatrixCache = false;
        }
    }

    private final boolean handleRotaryEvent(MotionEvent motionEvent) {
        android.view.ViewConfiguration viewConfiguration = android.view.ViewConfiguration.get(getContext());
        float f10 = -motionEvent.getAxisValue(26);
        RotaryScrollEvent rotaryScrollEvent = new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration, getContext()) * f10, f10 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration, getContext()), motionEvent.getEventTime());
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release != null) {
            return activeFocusModifier$ui_release.propagateRotaryEvent(rotaryScrollEvent);
        }
        return false;
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        return (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) ? false : true;
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            int i10 = 0;
            do {
                invalidateLayers(content[i10]);
                i10++;
            } while (i10 < size);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int i10 = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, null);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            LayoutNode[] content = mutableVector.getContent();
            do {
                invalidateLayoutNodeMeasurement(content[i10]);
                i10++;
            } while (i10 < size);
        }
    }

    private final boolean isBadMotionEvent(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        if (!((Float.isInfinite(x10) || Float.isNaN(x10)) ? false : true)) {
            return true;
        }
        float y10 = motionEvent.getY();
        if (!((Float.isInfinite(y10) || Float.isNaN(y10)) ? false : true)) {
            return true;
        }
        float rawX = motionEvent.getRawX();
        if (!((Float.isInfinite(rawX) || Float.isNaN(rawX)) ? false : true)) {
            return true;
        }
        float rawY = motionEvent.getRawY();
        return !(!Float.isInfinite(rawY) && !Float.isNaN(rawY));
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        return motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (0.0f <= x10 && x10 <= ((float) getWidth())) {
            if (0.0f <= y10 && y10 <= ((float) getHeight())) {
                return true;
            }
        }
        return false;
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.previousMotionEvent) == null) {
            return true;
        }
        if (motionEvent.getRawX() == motionEvent2.getRawX()) {
            return !((motionEvent.getRawY() > motionEvent2.getRawY() ? 1 : (motionEvent.getRawY() == motionEvent2.getRawY() ? 0 : -1)) == 0);
        }
        return true;
    }

    private final void recalculateWindowPosition() {
        if (this.forceUseMatrixCache) {
            return;
        }
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (jCurrentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
            this.lastMatrixRecalculationAnimationTime = jCurrentAnimationTimeMillis;
            recalculateWindowViewTransforms();
            ViewParent parent = getParent();
            View view = this;
            while (parent instanceof ViewGroup) {
                view = (View) parent;
                parent = ((ViewGroup) view).getParent();
            }
            view.getLocationOnScreen(this.tmpPositionArray);
            int[] iArr = this.tmpPositionArray;
            float f10 = iArr[0];
            float f11 = iArr[1];
            view.getLocationInWindow(iArr);
            int[] iArr2 = this.tmpPositionArray;
            this.windowPosition = OffsetKt.Offset(f10 - iArr2[0], f11 - iArr2[1]);
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.mo3170calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m3187invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (isLayoutRequested() || !isAttachedToWindow()) {
            return;
        }
        if (this.wasMeasuredWithMultipleConstraints && layoutNode != null) {
            while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                layoutNode = layoutNode.getParent$ui_release();
            }
            if (layoutNode == getRoot()) {
                requestLayout();
                return;
            }
        }
        if (getWidth() == 0 || getHeight() == 0) {
            requestLayout();
        } else {
            invalidate();
        }
    }

    static /* synthetic */ void scheduleMeasureAndLayout$default(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: scrollChangedListener$lambda-2, reason: not valid java name */
    public static final void m3154scrollChangedListener$lambda2(AndroidComposeView this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.updatePositionCacheAndDispatch();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: sendHoverExitEvent$lambda-5, reason: not valid java name */
    public static final void m3155sendHoverExitEvent$lambda5(AndroidComposeView this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.hoverExitReceived = false;
        MotionEvent motionEvent = this$0.previousMotionEvent;
        kotlin.jvm.internal.t.f(motionEvent);
        if (!(motionEvent.getActionMasked() == 10)) {
            throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
        }
        this$0.m3156sendMotionEvent8iAsVTc(motionEvent);
    }

    /* JADX INFO: renamed from: sendMotionEvent-8iAsVTc, reason: not valid java name */
    private final int m3156sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventDataPrevious;
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (pointerInputEventConvertToPointerInputEvent$ui_release == null) {
            this.pointerInputEventProcessor.processCancel();
            return PointerInputEventProcessorKt.ProcessResult(false, false);
        }
        List<PointerInputEventData> pointers = pointerInputEventConvertToPointerInputEvent$ui_release.getPointers();
        ListIterator<PointerInputEventData> listIterator = pointers.listIterator(pointers.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pointerInputEventDataPrevious = null;
                break;
            }
            pointerInputEventDataPrevious = listIterator.previous();
            if (pointerInputEventDataPrevious.getDown()) {
                break;
            }
        }
        PointerInputEventData pointerInputEventData = pointerInputEventDataPrevious;
        if (pointerInputEventData != null) {
            this.lastDownPointerPosition = pointerInputEventData.m2887getPositionF1C5BW0();
        }
        int iM2892processBIzXfog = this.pointerInputEventProcessor.m2892processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
        int actionMasked = motionEvent.getActionMasked();
        if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m2947getDispatchedToAPointerInputModifierimpl(iM2892processBIzXfog)) {
            return iM2892processBIzXfog;
        }
        this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
        return iM2892processBIzXfog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i10, long j10, boolean z10) {
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                actionIndex = motionEvent.getActionIndex();
            }
        } else if (i10 != 9 && i10 != 10) {
            actionIndex = 0;
        }
        int pointerCount = motionEvent.getPointerCount() - (actionIndex >= 0 ? 1 : 0);
        if (pointerCount == 0) {
            return;
        }
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        for (int i11 = 0; i11 < pointerCount; i11++) {
            pointerPropertiesArr[i11] = new MotionEvent.PointerProperties();
        }
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i12 = 0; i12 < pointerCount; i12++) {
            pointerCoordsArr[i12] = new MotionEvent.PointerCoords();
        }
        int i13 = 0;
        while (i13 < pointerCount) {
            int i14 = ((actionIndex < 0 || i13 < actionIndex) ? 0 : 1) + i13;
            motionEvent.getPointerProperties(i14, pointerPropertiesArr[i13]);
            MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i13];
            motionEvent.getPointerCoords(i14, pointerCoords);
            long jMo2940localToScreenMKHz9U = mo2940localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
            pointerCoords.x = Offset.m1367getXimpl(jMo2940localToScreenMKHz9U);
            pointerCoords.y = Offset.m1368getYimpl(jMo2940localToScreenMKHz9U);
            i13++;
        }
        MotionEvent event = MotionEvent.obtain(motionEvent.getDownTime() == motionEvent.getEventTime() ? j10 : motionEvent.getDownTime(), j10, i10, pointerCount, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), z10 ? 0 : motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
        MotionEventAdapter motionEventAdapter = this.motionEventAdapter;
        kotlin.jvm.internal.t.h(event, "event");
        PointerInputEvent pointerInputEventConvertToPointerInputEvent$ui_release = motionEventAdapter.convertToPointerInputEvent$ui_release(event, this);
        kotlin.jvm.internal.t.f(pointerInputEventConvertToPointerInputEvent$ui_release);
        this.pointerInputEventProcessor.m2892processBIzXfog(pointerInputEventConvertToPointerInputEvent$ui_release, this, true);
        event.recycle();
    }

    static /* synthetic */ void sendSimulatedEvent$default(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i10, long j10, boolean z10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            z10 = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i10, j10, z10);
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: touchModeChangeListener$lambda-3, reason: not valid java name */
    public static final void m3157touchModeChangeListener$lambda3(AndroidComposeView this$0, boolean z10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0._inputModeManager.m2161setInputModeiuPiT84(z10 ? InputMode.Companion.m2158getTouchaOaMEAU() : InputMode.Companion.m2157getKeyboardaOaMEAU());
        this$0._focusManager.fetchUpdatedFocusProperties();
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        boolean z10 = false;
        if (IntOffset.m3791getXimpl(this.globalPosition) != this.tmpPositionArray[0] || IntOffset.m3792getYimpl(this.globalPosition) != this.tmpPositionArray[1]) {
            int[] iArr = this.tmpPositionArray;
            this.globalPosition = IntOffsetKt.IntOffset(iArr[0], iArr[1]);
            z10 = true;
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z10);
    }

    public final void addAndroidView(@NotNull AndroidViewHolder view, @NotNull final LayoutNode layoutNode) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(view, layoutNode);
        getAndroidViewsHandler$ui_release().addView(view);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, view);
        ViewCompat.setImportantForAccessibility(view, 1);
        ViewCompat.setAccessibilityDelegate(view, new AccessibilityDelegateCompat() { // from class: androidx.compose.ui.platform.AndroidComposeView.addAndroidView.1
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public void onInitializeAccessibilityNodeInfo(@NotNull View host, @NotNull AccessibilityNodeInfoCompat info) {
                kotlin.jvm.internal.t.i(host, "host");
                kotlin.jvm.internal.t.i(info, "info");
                super.onInitializeAccessibilityNodeInfo(host, info);
                SemanticsEntity outerSemantics = SemanticsNodeKt.getOuterSemantics(layoutNode);
                kotlin.jvm.internal.t.f(outerSemantics);
                SemanticsNode parent = new SemanticsNode(outerSemantics, false).getParent();
                kotlin.jvm.internal.t.f(parent);
                int id = parent.getId();
                if (id == this.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
                    id = -1;
                }
                info.setParent(this, id);
            }
        });
    }

    @Override // android.view.View
    public void autofill(@NotNull SparseArray<AutofillValue> values) {
        AndroidAutofill androidAutofill;
        kotlin.jvm.internal.t.i(values, "values");
        if (!autofillSupported() || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.performAutofill(androidAutofill, values);
    }

    @Nullable
    public final Object boundsUpdatesEventLoop(@NotNull z8.d<? super v8.k0> dVar) {
        Object objBoundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(dVar);
        return objBoundsUpdatesEventLoop == a9.d.e() ? objBoundsUpdatesEventLoop : v8.k0.f35197a;
    }

    @Override // androidx.compose.ui.node.Owner
    /* JADX INFO: renamed from: calculateLocalPosition-MK-Hz9U */
    public long mo3147calculateLocalPositionMKHz9U(long j10) {
        recalculateWindowPosition();
        return Matrix.m1782mapMKHz9U(this.windowToViewMatrix, j10);
    }

    @Override // androidx.compose.ui.node.Owner
    /* JADX INFO: renamed from: calculatePositionInWindow-MK-Hz9U */
    public long mo3148calculatePositionInWindowMKHz9U(long j10) {
        recalculateWindowPosition();
        return Matrix.m1782mapMKHz9U(this.viewToWindowMatrix, j10);
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i10) {
        return this.accessibilityDelegate.m3162canScroll0AR0LA0$ui_release(false, i10, this.lastDownPointerPosition);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i10) {
        return this.accessibilityDelegate.m3162canScroll0AR0LA0$ui_release(true, i10, this.lastDownPointerPosition);
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public OwnedLayer createLayer(@NotNull h9.l<? super Canvas, v8.k0> drawBlock, @NotNull h9.a<v8.k0> invalidateParentLayer) {
        DrawChildContainer viewLayerContainer;
        kotlin.jvm.internal.t.i(drawBlock, "drawBlock");
        kotlin.jvm.internal.t.i(invalidateParentLayer, "invalidateParentLayer");
        OwnedLayer ownedLayerPop = this.layerCache.pop();
        if (ownedLayerPop != null) {
            ownedLayerPop.reuseLayer(drawBlock, invalidateParentLayer);
            return ownedLayerPop;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, drawBlock, invalidateParentLayer);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.Companion;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            if (companion.getShouldUseDispatchDraw()) {
                Context context = getContext();
                kotlin.jvm.internal.t.h(context, "context");
                viewLayerContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                kotlin.jvm.internal.t.h(context2, "context");
                viewLayerContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = viewLayerContainer;
            addView(viewLayerContainer);
        }
        DrawChildContainer drawChildContainer = this.viewLayersContainer;
        kotlin.jvm.internal.t.f(drawChildContainer);
        return new ViewLayer(this, drawChildContainer, drawBlock, invalidateParentLayer);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        androidx.compose.ui.node.b.d(this, false, 1, null);
        this.isDrawingContent = true;
        CanvasHolder canvasHolder = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder.getAndroidCanvas().getInternalCanvas();
        canvasHolder.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder.getAndroidCanvas());
        canvasHolder.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.dirtyLayers.get(i10).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int iSave = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(iSave);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            kotlin.jvm.internal.t.f(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        return event.getActionMasked() == 8 ? event.isFromSource(4194304) ? handleRotaryEvent(event) : (isBadMotionEvent(event) || !isAttachedToWindow()) ? super.dispatchGenericMotionEvent(event) : ProcessResult.m2947getDispatchedToAPointerInputModifierimpl(m3153handleMotionEvent8iAsVTc(event)) : super.dispatchGenericMotionEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(@NotNull MotionEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(event) || !isAttachedToWindow()) {
            return false;
        }
        if (event.isFromSource(InputDeviceCompat.SOURCE_TOUCHSCREEN) && event.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(event);
        }
        int actionMasked = event.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(event)) {
                if (event.getToolType(0) != 3) {
                    MotionEvent motionEvent = this.previousMotionEvent;
                    if (motionEvent != null) {
                        motionEvent.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(event);
                    this.hoverExitReceived = true;
                    post(this.sendHoverExitEvent);
                    return false;
                }
                if (event.getButtonState() != 0) {
                    return false;
                }
            }
        } else if (!isPositionChanged(event)) {
            return false;
        }
        return ProcessResult.m2947getDispatchedToAPointerInputModifierimpl(m3153handleMotionEvent8iAsVTc(event));
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        return isFocused() ? mo3151sendKeyEventZmokQxo(androidx.compose.ui.input.key.KeyEvent.m2744constructorimpl(event)) : super.dispatchKeyEvent(event);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        kotlin.jvm.internal.t.i(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            kotlin.jvm.internal.t.f(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int iM3153handleMotionEvent8iAsVTc = m3153handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m2946getAnyMovementConsumedimpl(iM3153handleMotionEvent8iAsVTc)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m2947getDispatchedToAPointerInputModifierimpl(iM3153handleMotionEvent8iAsVTc);
    }

    public final void drawAndroidView(@NotNull AndroidViewHolder view, @NotNull android.graphics.Canvas canvas) {
        kotlin.jvm.internal.t.i(view, "view");
        kotlin.jvm.internal.t.i(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(view, canvas);
    }

    @Nullable
    public final View findViewByAccessibilityIdTraversal(int i10) throws IllegalAccessException, InvocationTargetException {
        View viewFindViewByAccessibilityIdRootedAtCurrentView = null;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", Integer.TYPE);
                declaredMethod.setAccessible(true);
                Object objInvoke = declaredMethod.invoke(this, Integer.valueOf(i10));
                if (objInvoke instanceof View) {
                    viewFindViewByAccessibilityIdRootedAtCurrentView = (View) objInvoke;
                }
            } else {
                viewFindViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i10, this);
            }
        } catch (NoSuchMethodException unused) {
        }
        return viewFindViewByAccessibilityIdRootedAtCurrentView;
    }

    @Override // androidx.compose.ui.node.Owner
    public void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    @NotNull
    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            kotlin.jvm.internal.t.h(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        kotlin.jvm.internal.t.f(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Override // androidx.compose.ui.node.Owner
    @Nullable
    public Autofill getAutofill() {
        return this._autofill;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @NotNull
    public final h9.l<Configuration, v8.k0> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    @NotNull
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.node.Owner
    @Nullable
    /* JADX INFO: renamed from: getFocusDirection-P8AzH3I */
    public FocusDirection mo3149getFocusDirectionP8AzH3I(@NotNull KeyEvent keyEvent) {
        kotlin.jvm.internal.t.i(keyEvent, "keyEvent");
        long jM2760getKeyZmokQxo = KeyEvent_androidKt.m2760getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.Companion;
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2688getTabEK5gGoQ())) {
            return FocusDirection.m1300boximpl(KeyEvent_androidKt.m2766isShiftPressedZmokQxo(keyEvent) ? FocusDirection.Companion.m1314getPreviousdhqQ8s() : FocusDirection.Companion.m1312getNextdhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2529getDirectionRightEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1315getRightdhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2528getDirectionLeftEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1311getLeftdhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2530getDirectionUpEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1316getUpdhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2525getDirectionDownEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1309getDowndhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2524getDirectionCenterEK5gGoQ()) ? true : Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2538getEnterEK5gGoQ()) ? true : Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2630getNumPadEnterEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1310getIndhqQ8s());
        }
        if (Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2467getBackEK5gGoQ()) ? true : Key.m2165equalsimpl0(jM2760getKeyZmokQxo, companion.m2541getEscapeEK5gGoQ())) {
            return FocusDirection.m1300boximpl(FocusDirection.Companion.m1313getOutdhqQ8s());
        }
        return null;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public FocusManager getFocusManager() {
        return this._focusManager;
    }

    @Override // android.view.View
    public void getFocusedRect(@NotNull Rect rect) {
        v8.k0 k0Var;
        androidx.compose.ui.geometry.Rect rectFocusRect;
        kotlin.jvm.internal.t.i(rect, "rect");
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release == null || (rectFocusRect = FocusTraversalKt.focusRect(activeFocusModifier$ui_release)) == null) {
            k0Var = null;
        } else {
            rect.left = j9.c.c(rectFocusRect.getLeft());
            rect.top = j9.c.c(rectFocusRect.getTop());
            rect.right = j9.c.c(rectFocusRect.getRight());
            rect.bottom = j9.c.c(rectFocusRect.getBottom());
            k0Var = v8.k0.f35197a;
        }
        if (k0Var == null) {
            super.getFocusedRect(rect);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View, android.view.ViewParent, androidx.compose.ui.node.Owner
    @NotNull
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public LayoutNode getRoot() {
        return this.root;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @Override // androidx.compose.ui.node.RootForTest
    @NotNull
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    @Override // androidx.compose.ui.node.Owner
    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @Override // androidx.compose.ui.node.Owner, androidx.compose.ui.node.RootForTest
    @NotNull
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    public boolean isLifecycleInResumedState() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        return ((viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.RESUMED;
    }

    @Nullable
    public final Object keyboardVisibilityEventLoop(@NotNull z8.d<? super v8.k0> dVar) {
        Object objTextInputCommandEventLoop = this.textInputServiceAndroid.textInputCommandEventLoop(dVar);
        return objTextInputCommandEventLoop == a9.d.e() ? objTextInputCommandEventLoop : v8.k0.f35197a;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: localToScreen-MK-Hz9U */
    public long mo2940localToScreenMKHz9U(long j10) {
        recalculateWindowPosition();
        long jM1782mapMKHz9U = Matrix.m1782mapMKHz9U(this.viewToWindowMatrix, j10);
        return OffsetKt.Offset(Offset.m1367getXimpl(jM1782mapMKHz9U) + Offset.m1367getXimpl(this.windowPosition), Offset.m1368getYimpl(jM1782mapMKHz9U) + Offset.m1368getYimpl(this.windowPosition));
    }

    @Override // androidx.compose.ui.node.Owner
    public void measureAndLayout(boolean z10) {
        h9.a<v8.k0> aVar;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (z10) {
            try {
                aVar = this.resendMotionEventOnLayout;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            aVar = null;
        }
        if (this.measureAndLayoutDelegate.measureAndLayout(aVar)) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
        v8.k0 k0Var = v8.k0.f35197a;
        Trace.endSection();
    }

    @Override // androidx.compose.ui.node.Owner
    /* JADX INFO: renamed from: measureAndLayout-0kLqBqw */
    public void mo3150measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j10) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m3136measureAndLayout0kLqBqw(layoutNode, j10);
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, null);
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            Trace.endSection();
        }
    }

    public final void notifyLayerIsDirty$ui_release(@NotNull OwnedLayer layer, boolean z10) {
        kotlin.jvm.internal.t.i(layer, "layer");
        if (!z10) {
            if (!this.isDrawingContent && !this.dirtyLayers.remove(layer)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            if (!this.isDrawingContent) {
                this.dirtyLayers.add(layer);
                return;
            }
            List arrayList = this.postponedDirtyLayers;
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.postponedDirtyLayers = arrayList;
            }
            arrayList.add(layer);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onAttach(@NotNull LayoutNode node) {
        kotlin.jvm.internal.t.i(node, "node");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == viewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == viewTreeOwners.getLifecycleOwner()))) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            }
            if (savedStateRegistryOwner == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
            if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
                lifecycle.removeObserver(this);
            }
            lifecycleOwner2.getLifecycle().addObserver(this);
            ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
            setViewTreeOwners(viewTreeOwners2);
            h9.l<? super ViewTreeOwners, v8.k0> lVar = this.onViewTreeOwnersAvailable;
            if (lVar != null) {
                lVar.invoke(viewTreeOwners2);
            }
            this.onViewTreeOwnersAvailable = null;
        }
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        kotlin.jvm.internal.t.f(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    public boolean onCheckIsTextEditor() {
        return this.textInputServiceAndroid.isEditorFocused();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@NotNull Configuration newConfig) {
        kotlin.jvm.internal.t.i(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        Context context = getContext();
        kotlin.jvm.internal.t.h(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(newConfig) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(newConfig);
            Context context2 = getContext();
            kotlin.jvm.internal.t.h(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(newConfig);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.a(this, lifecycleOwner);
    }

    @Override // android.view.View
    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo outAttrs) {
        kotlin.jvm.internal.t.i(outAttrs, "outAttrs");
        return this.textInputServiceAndroid.createInputConnection(outAttrs);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.b(this, lifecycleOwner);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onDetach(@NotNull LayoutNode node) {
        kotlin.jvm.internal.t.i(node, "node");
        this.measureAndLayoutDelegate.onNodeDetached(node);
        requestClearInvalidObservations();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null && (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) != null && (lifecycle = lifecycleOwner.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    @Override // android.view.View
    protected void onDraw(@NotNull android.graphics.Canvas canvas) {
        kotlin.jvm.internal.t.i(canvas, "canvas");
    }

    @Override // androidx.compose.ui.node.Owner
    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i10 = 0; i10 < size; i10++) {
                h9.a<v8.k0> aVar = this.endApplyChangesListeners.getContent()[i10];
                this.endApplyChangesListeners.set(i10, null);
                if (aVar != null) {
                    aVar.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z10, int i10, @Nullable Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        Log.d(FocusTag, "Owner FocusChanged(" + z10 + ')');
        FocusManagerImpl focusManagerImpl = this._focusManager;
        if (z10) {
            focusManagerImpl.takeFocus();
        } else {
            focusManagerImpl.releaseFocus();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i12 - i10, i13 - i11);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onLayoutChange(@NotNull LayoutNode layoutNode) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            v8.s<Integer, Integer> sVarConvertMeasureSpec = convertMeasureSpec(i10);
            int iIntValue = sVarConvertMeasureSpec.a().intValue();
            int iIntValue2 = sVarConvertMeasureSpec.b().intValue();
            v8.s<Integer, Integer> sVarConvertMeasureSpec2 = convertMeasureSpec(i11);
            long jConstraints = ConstraintsKt.Constraints(iIntValue, iIntValue2, sVarConvertMeasureSpec2.a().intValue(), sVarConvertMeasureSpec2.b().intValue());
            Constraints constraints = this.onMeasureConstraints;
            boolean zM3634equalsimpl0 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m3629boximpl(jConstraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    zM3634equalsimpl0 = Constraints.m3634equalsimpl0(constraints.m3647unboximpl(), jConstraints);
                }
                if (!zM3634equalsimpl0) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m3137updateRootConstraintsBRTryo0(jConstraints);
            this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            v8.k0 k0Var = v8.k0.f35197a;
        } finally {
            Trace.endSection();
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.c(this, lifecycleOwner);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(@Nullable ViewStructure viewStructure, int i10) {
        AndroidAutofill androidAutofill;
        if (!autofillSupported() || viewStructure == null || (androidAutofill = this._autofill) == null) {
            return;
        }
        AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean z10) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, z10)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean z10) {
        kotlin.jvm.internal.t.i(layoutNode, "layoutNode");
        if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, z10)) {
            scheduleMeasureAndLayout$default(this, null, 1, null);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(@NotNull LifecycleOwner owner) {
        kotlin.jvm.internal.t.i(owner, "owner");
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        if (this.superclassInitComplete) {
            LayoutDirection layoutDirectionLayoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(i10);
            setLayoutDirection(layoutDirectionLayoutDirectionFromInt);
            this._focusManager.setLayoutDirection(layoutDirectionLayoutDirectionFromInt);
        }
    }

    @Override // androidx.compose.ui.node.Owner
    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.e(this, lifecycleOwner);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        androidx.lifecycle.c.f(this, lifecycleOwner);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        boolean isShowingLayoutBounds;
        this._windowInfo.setWindowFocused(z10);
        super.onWindowFocusChanged(z10);
        if (!z10 || getShowLayoutBounds() == (isShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            return;
        }
        setShowLayoutBounds(isShowingLayoutBounds);
        invalidateDescendants();
    }

    public final boolean recycle$ui_release(@NotNull OwnedLayer layer) {
        kotlin.jvm.internal.t.i(layer, "layer");
        if (this.viewLayersContainer != null) {
            ViewLayer.Companion.getShouldUseDispatchDraw();
        }
        this.layerCache.push(layer);
        return true;
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnEndApplyChangesListener(@NotNull h9.a<v8.k0> listener) {
        kotlin.jvm.internal.t.i(listener, "listener");
        if (this.endApplyChangesListeners.contains(listener)) {
            return;
        }
        this.endApplyChangesListeners.add(listener);
    }

    @Override // androidx.compose.ui.node.Owner
    public void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener listener) {
        kotlin.jvm.internal.t.i(listener, "listener");
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(listener);
        scheduleMeasureAndLayout$default(this, null, 1, null);
    }

    public final void removeAndroidView(@NotNull AndroidViewHolder view) {
        kotlin.jvm.internal.t.i(view, "view");
        getAndroidViewsHandler$ui_release().removeView(view);
        HashMap<LayoutNode, AndroidViewHolder> layoutNodeToHolder = getAndroidViewsHandler$ui_release().getLayoutNodeToHolder();
        kotlin.jvm.internal.t0.d(layoutNodeToHolder).remove(getAndroidViewsHandler$ui_release().getHolderToLayoutNode().remove(view));
        ViewCompat.setImportantForAccessibility(view, 0);
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    @Override // androidx.compose.ui.input.pointer.PositionCalculator
    /* JADX INFO: renamed from: screenToLocal-MK-Hz9U */
    public long mo2941screenToLocalMKHz9U(long j10) {
        recalculateWindowPosition();
        return Matrix.m1782mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m1367getXimpl(j10) - Offset.m1367getXimpl(this.windowPosition), Offset.m1368getYimpl(j10) - Offset.m1368getYimpl(this.windowPosition)));
    }

    @Override // androidx.compose.ui.node.RootForTest
    /* JADX INFO: renamed from: sendKeyEvent-ZmokQxo */
    public boolean mo3151sendKeyEventZmokQxo(@NotNull KeyEvent keyEvent) {
        kotlin.jvm.internal.t.i(keyEvent, "keyEvent");
        return this.keyInputModifier.m2767processKeyInputZmokQxo(keyEvent);
    }

    public final void setConfigurationChangeObserver(@NotNull h9.l<? super Configuration, v8.k0> lVar) {
        kotlin.jvm.internal.t.i(lVar, "<set-?>");
        this.configurationChangeObserver = lVar;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j10) {
        this.lastMatrixRecalculationAnimationTime = j10;
    }

    public final void setOnViewTreeOwnersAvailable(@NotNull h9.l<? super ViewTreeOwners, v8.k0> callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            callback.invoke(viewTreeOwners);
        }
        if (isAttachedToWindow()) {
            return;
        }
        this.onViewTreeOwnersAvailable = callback;
    }

    @Override // androidx.compose.ui.node.Owner
    public void setShowLayoutBounds(boolean z10) {
        this.showLayoutBounds = z10;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @Override // androidx.compose.ui.node.Owner
    @NotNull
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long jM1782mapMKHz9U = Matrix.m1782mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m1367getXimpl(jM1782mapMKHz9U), motionEvent.getRawY() - Offset.m1368getYimpl(jM1782mapMKHz9U));
    }

    public static /* synthetic */ void getFontLoader$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public static /* synthetic */ void getTextInputService$annotations() {
    }

    @Override // androidx.compose.ui.platform.ViewRootForTest
    @NotNull
    public View getView() {
        return this;
    }
}
