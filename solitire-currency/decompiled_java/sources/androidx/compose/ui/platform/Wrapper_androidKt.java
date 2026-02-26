package androidx.compose.ui.platform;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.ui.R;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.UiApplier;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.WeakHashMap;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Wrapper.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Wrapper_androidKt {

    @NotNull
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    @NotNull
    private static final String TAG = "Wrapper";

    @MainThread
    @NotNull
    public static final Composition createSubcomposition(@NotNull LayoutNode container, @NotNull CompositionContext parent) {
        kotlin.jvm.internal.t.i(container, "container");
        kotlin.jvm.internal.t.i(parent, "parent");
        return CompositionKt.Composition(new UiApplier(container), parent);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private static final Composition doSetContent(AndroidComposeView androidComposeView, CompositionContext compositionContext, h9.p<? super Composer, ? super Integer, v8.k0> pVar) {
        if (inspectionWanted(androidComposeView)) {
            androidComposeView.setTag(R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            enableDebugInspectorInfo();
        }
        Composition Composition = CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), compositionContext);
        View view = androidComposeView.getView();
        int i10 = R.id.wrapped_composition_tag;
        Object tag = view.getTag(i10);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, Composition);
            androidComposeView.getView().setTag(i10, wrappedComposition);
        }
        wrappedComposition.setContent(pVar);
        return wrappedComposition;
    }

    private static final void enableDebugInspectorInfo() {
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            return;
        }
        try {
            Field declaredField = InspectableValueKt.class.getDeclaredField("isDebugInspectorInfoEnabled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(null, true);
        } catch (Exception unused) {
            Log.w(TAG, "Could not access isDebugInspectorInfoEnabled. Please set explicitly.");
        }
    }

    private static final boolean inspectionWanted(AndroidComposeView androidComposeView) {
        return Build.VERSION.SDK_INT >= 29 && (WrapperVerificationHelperMethods.INSTANCE.attributeSourceResourceMap(androidComposeView).isEmpty() ^ true);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    public static final Composition setContent(@NotNull AbstractComposeView abstractComposeView, @NotNull CompositionContext parent, @NotNull h9.p<? super Composer, ? super Integer, v8.k0> content) {
        kotlin.jvm.internal.t.i(abstractComposeView, "<this>");
        kotlin.jvm.internal.t.i(parent, "parent");
        kotlin.jvm.internal.t.i(content, "content");
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            Context context = abstractComposeView.getContext();
            kotlin.jvm.internal.t.h(context, "context");
            androidComposeView = new AndroidComposeView(context);
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        return doSetContent(androidComposeView, parent, content);
    }
}
