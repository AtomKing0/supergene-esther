package androidx.compose.ui.window;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Outline;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.R;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.platform.e2;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import h9.a;
import h9.p;
import java.util.UUID;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: AndroidDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class DialogWrapper extends Dialog implements ViewRootForInspector {

    @NotNull
    private final View composeView;

    @NotNull
    private final DialogLayout dialogLayout;
    private final float maxSupportedElevation;

    @NotNull
    private a<k0> onDismissRequest;

    @NotNull
    private DialogProperties properties;

    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogWrapper(@NotNull a<k0> onDismissRequest, @NotNull DialogProperties properties, @NotNull View composeView, @NotNull LayoutDirection layoutDirection, @NotNull Density density, @NotNull UUID dialogId) {
        super(new ContextThemeWrapper(composeView.getContext(), R.style.DialogWindowTheme));
        t.i(onDismissRequest, "onDismissRequest");
        t.i(properties, "properties");
        t.i(composeView, "composeView");
        t.i(layoutDirection, "layoutDirection");
        t.i(density, "density");
        t.i(dialogId, "dialogId");
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        this.composeView = composeView;
        float fM3673constructorimpl = Dp.m3673constructorimpl(30);
        this.maxSupportedElevation = fM3673constructorimpl;
        Window window = getWindow();
        if (window == null) {
            throw new IllegalStateException("Dialog has no window".toString());
        }
        window.requestFeature(1);
        window.setBackgroundDrawableResource(android.R.color.transparent);
        Context context = getContext();
        t.h(context, "context");
        DialogLayout dialogLayout = new DialogLayout(context, window);
        dialogLayout.setTag(R.id.compose_view_saveable_id_tag, "Dialog:" + dialogId);
        dialogLayout.setClipChildren(false);
        dialogLayout.setElevation(density.mo296toPx0680j_4(fM3673constructorimpl));
        dialogLayout.setOutlineProvider(new ViewOutlineProvider() { // from class: androidx.compose.ui.window.DialogWrapper$1$2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(@NotNull View view, @NotNull Outline result) {
                t.i(view, "view");
                t.i(result, "result");
                result.setRect(0, 0, view.getWidth(), view.getHeight());
                result.setAlpha(0.0f);
            }
        });
        this.dialogLayout = dialogLayout;
        View decorView = window.getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup != null) {
            _init_$disableClipping(viewGroup);
        }
        setContentView(dialogLayout);
        ViewTreeLifecycleOwner.set(dialogLayout, ViewTreeLifecycleOwner.get(composeView));
        ViewTreeViewModelStoreOwner.set(dialogLayout, ViewTreeViewModelStoreOwner.get(composeView));
        ViewTreeSavedStateRegistryOwner.set(dialogLayout, ViewTreeSavedStateRegistryOwner.get(composeView));
        updateParameters(this.onDismissRequest, this.properties, layoutDirection);
    }

    private static final void _init_$disableClipping(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        if (viewGroup instanceof DialogLayout) {
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                _init_$disableClipping(viewGroup2);
            }
        }
    }

    private final void setLayoutDirection(LayoutDirection layoutDirection) {
        DialogLayout dialogLayout = this.dialogLayout;
        int i10 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 != 2) {
            throw new q();
        }
        dialogLayout.setLayoutDirection(i11);
    }

    private final void setSecurePolicy(SecureFlagPolicy secureFlagPolicy) {
        boolean zShouldApplySecureFlag = SecureFlagPolicy_androidKt.shouldApplySecureFlag(secureFlagPolicy, AndroidPopup_androidKt.isFlagSecureEnabled(this.composeView));
        Window window = getWindow();
        t.f(window);
        window.setFlags(zShouldApplySecureFlag ? 8192 : -8193, 8192);
    }

    public final void disposeComposition() {
        this.dialogLayout.disposeComposition();
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    @NotNull
    public AbstractComposeView getSubCompositionView() {
        return this.dialogLayout;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* synthetic */ View getViewRoot() {
        return e2.b(this);
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.properties.getDismissOnBackPress()) {
            this.onDismissRequest.invoke();
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        t.i(event, "event");
        boolean zOnTouchEvent = super.onTouchEvent(event);
        if (zOnTouchEvent && this.properties.getDismissOnClickOutside()) {
            this.onDismissRequest.invoke();
        }
        return zOnTouchEvent;
    }

    public final void setContent(@NotNull CompositionContext parentComposition, @NotNull p<? super Composer, ? super Integer, k0> children) {
        t.i(parentComposition, "parentComposition");
        t.i(children, "children");
        this.dialogLayout.setContent(parentComposition, children);
    }

    public final void updateParameters(@NotNull a<k0> onDismissRequest, @NotNull DialogProperties properties, @NotNull LayoutDirection layoutDirection) {
        t.i(onDismissRequest, "onDismissRequest");
        t.i(properties, "properties");
        t.i(layoutDirection, "layoutDirection");
        this.onDismissRequest = onDismissRequest;
        this.properties = properties;
        setSecurePolicy(properties.getSecurePolicy());
        setLayoutDirection(layoutDirection);
        this.dialogLayout.setUsePlatformDefaultWidth(properties.getUsePlatformDefaultWidth());
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
    }
}
