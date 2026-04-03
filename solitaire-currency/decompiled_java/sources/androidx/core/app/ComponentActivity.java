package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ComponentActivity.kt */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {

    @NotNull
    private final SimpleArrayMap<Class<? extends ExtraData>, ExtraData> extraDataMap = new SimpleArrayMap<>();

    @NotNull
    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    /* JADX INFO: compiled from: ComponentActivity.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ExtraData {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
    
        if (r4.equals("--list-dumpables") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
    
        if (r4.equals("--dump-dumpable") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0056, code lost:
    
        if (android.os.Build.VERSION.SDK_INT < 33) goto L41;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean shouldSkipDump(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto Lf
            int r2 = r4.length
            if (r2 != 0) goto L9
            r2 = r0
            goto La
        L9:
            r2 = r1
        La:
            if (r2 == 0) goto Ld
            goto Lf
        Ld:
            r2 = r1
            goto L10
        Lf:
            r2 = r0
        L10:
            if (r2 != 0) goto L6d
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L5b;
                case 100470631: goto L49;
                case 472614934: goto L40;
                case 1159329357: goto L2e;
                case 1455016274: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L6d
        L1c:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L25
            goto L6d
        L25:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r4 < r2) goto L2c
            goto L2d
        L2c:
            r0 = r1
        L2d:
            return r0
        L2e:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L37
            goto L6d
        L37:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L3e
            goto L3f
        L3e:
            r0 = r1
        L3f:
            return r0
        L40:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L52
            goto L6d
        L49:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L52
            goto L6d
        L52:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            return r0
        L5b:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L64
            goto L6d
        L64:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L6b
            goto L6c
        L6b:
            r0 = r1
        L6c:
            return r0
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.ComponentActivity.shouldSkipDump(java.lang.String[]):boolean");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NotNull KeyEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.t.h(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, event)) {
            return true;
        }
        return KeyEventDispatcher.dispatchKeyEvent(this, decorView, this, event);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(@NotNull KeyEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        View decorView = getWindow().getDecorView();
        kotlin.jvm.internal.t.h(decorView, "window.decorView");
        if (KeyEventDispatcher.dispatchBeforeHierarchy(decorView, event)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(event);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Nullable
    public <T extends ExtraData> T getExtraData(@NotNull Class<T> extraDataClass) {
        kotlin.jvm.internal.t.i(extraDataClass, "extraDataClass");
        return (T) this.extraDataMap.get(extraDataClass);
    }

    @NotNull
    public Lifecycle getLifecycle() {
        return this.lifecycleRegistry;
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        ReportFragment.Companion.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onSaveInstanceState(@NotNull Bundle outState) {
        kotlin.jvm.internal.t.i(outState, "outState");
        this.lifecycleRegistry.setCurrentState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(outState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void putExtraData(@NotNull ExtraData extraData) {
        kotlin.jvm.internal.t.i(extraData, "extraData");
        this.extraDataMap.put(extraData.getClass(), extraData);
    }

    protected final boolean shouldDumpInternalState(@Nullable String[] strArr) {
        return !shouldSkipDump(strArr);
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(@NotNull KeyEvent event) {
        kotlin.jvm.internal.t.i(event, "event");
        return super.dispatchKeyEvent(event);
    }

    private static /* synthetic */ void getExtraDataMap$annotations() {
    }

    private static /* synthetic */ void getLifecycleRegistry$annotations() {
    }
}
