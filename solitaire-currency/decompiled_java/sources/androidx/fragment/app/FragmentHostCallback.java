package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FragmentHostCallback.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentHostCallback<H> extends FragmentContainer {

    @Nullable
    private final Activity activity;

    @NotNull
    private final Context context;

    @NotNull
    private final FragmentManager fragmentManager;

    @NotNull
    private final Handler handler;
    private final int windowAnimations;

    public FragmentHostCallback(@Nullable Activity activity, @NotNull Context context, @NotNull Handler handler, int i10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(handler, "handler");
        this.activity = activity;
        this.context = context;
        this.handler = handler;
        this.windowAnimations = i10;
        this.fragmentManager = new FragmentManagerImpl();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Nullable
    public final Activity getActivity() {
        return this.activity;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @NotNull
    public final Handler getHandler() {
        return this.handler;
    }

    public void onDump(@NotNull String prefix, @Nullable FileDescriptor fileDescriptor, @NotNull PrintWriter writer, @Nullable String[] strArr) {
        kotlin.jvm.internal.t.i(prefix, "prefix");
        kotlin.jvm.internal.t.i(writer, "writer");
    }

    @Override // androidx.fragment.app.FragmentContainer
    @Nullable
    public View onFindViewById(int i10) {
        return null;
    }

    public abstract H onGetHost();

    @NotNull
    public LayoutInflater onGetLayoutInflater() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.context);
        kotlin.jvm.internal.t.h(layoutInflaterFrom, "from(context)");
        return layoutInflaterFrom;
    }

    public int onGetWindowAnimations() {
        return this.windowAnimations;
    }

    @Override // androidx.fragment.app.FragmentContainer
    public boolean onHasView() {
        return true;
    }

    public boolean onHasWindowAnimations() {
        return true;
    }

    public void onRequestPermissionsFromFragment(@NotNull Fragment fragment, @NotNull String[] permissions, int i10) {
        kotlin.jvm.internal.t.i(fragment, "fragment");
        kotlin.jvm.internal.t.i(permissions, "permissions");
    }

    public boolean onShouldSaveFragmentState(@NotNull Fragment fragment) {
        kotlin.jvm.internal.t.i(fragment, "fragment");
        return true;
    }

    public boolean onShouldShowRequestPermissionRationale(@NotNull String permission) {
        kotlin.jvm.internal.t.i(permission, "permission");
        return false;
    }

    public void onStartActivityFromFragment(@NotNull Fragment fragment, @NotNull Intent intent, int i10) {
        kotlin.jvm.internal.t.i(fragment, "fragment");
        kotlin.jvm.internal.t.i(intent, "intent");
        onStartActivityFromFragment(fragment, intent, i10, null);
    }

    public void onStartIntentSenderFromFragment(@NotNull Fragment fragment, @NotNull IntentSender intent, int i10, @Nullable Intent intent2, int i11, int i12, int i13, @Nullable Bundle bundle) throws IntentSender.SendIntentException {
        kotlin.jvm.internal.t.i(fragment, "fragment");
        kotlin.jvm.internal.t.i(intent, "intent");
        if (!(i10 == -1)) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host".toString());
        }
        Activity activity = this.activity;
        if (activity == null) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host".toString());
        }
        ActivityCompat.startIntentSenderForResult(activity, intent, i10, intent2, i11, i12, i13, bundle);
    }

    public void onStartActivityFromFragment(@NotNull Fragment fragment, @NotNull Intent intent, int i10, @Nullable Bundle bundle) {
        kotlin.jvm.internal.t.i(fragment, "fragment");
        kotlin.jvm.internal.t.i(intent, "intent");
        if (!(i10 == -1)) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host".toString());
        }
        ContextCompat.startActivity(this.context, intent, bundle);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(@NotNull Context context, @NotNull Handler handler, int i10) {
        this(context instanceof Activity ? (Activity) context : null, context, handler, i10);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(handler, "handler");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FragmentHostCallback(@NotNull FragmentActivity activity) {
        this(activity, activity, new Handler(), 0);
        kotlin.jvm.internal.t.i(activity, "activity");
    }

    public void onSupportInvalidateOptionsMenu() {
    }
}
