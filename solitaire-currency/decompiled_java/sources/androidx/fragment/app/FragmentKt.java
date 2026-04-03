package androidx.fragment.app;

import android.os.Bundle;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Fragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentKt {
    public static final void clearFragmentResult(@NotNull Fragment fragment, @NotNull String requestKey) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(requestKey);
    }

    public static final void clearFragmentResultListener(@NotNull Fragment fragment, @NotNull String requestKey) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(requestKey, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(requestKey);
    }

    public static final void setFragmentResult(@NotNull Fragment fragment, @NotNull String requestKey, @NotNull Bundle result) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(requestKey, "requestKey");
        kotlin.jvm.internal.t.i(result, "result");
        fragment.getParentFragmentManager().setFragmentResult(requestKey, result);
    }

    public static final void setFragmentResultListener(@NotNull Fragment fragment, @NotNull String requestKey, @NotNull final h9.p<? super String, ? super Bundle, k0> listener) {
        kotlin.jvm.internal.t.i(fragment, "<this>");
        kotlin.jvm.internal.t.i(requestKey, "requestKey");
        kotlin.jvm.internal.t.i(listener, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(requestKey, fragment, new FragmentResultListener() { // from class: androidx.fragment.app.r
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                FragmentKt.setFragmentResultListener$lambda$0(listener, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setFragmentResultListener$lambda$0(h9.p tmp0, String p02, Bundle p12) {
        kotlin.jvm.internal.t.i(tmp0, "$tmp0");
        kotlin.jvm.internal.t.i(p02, "p0");
        kotlin.jvm.internal.t.i(p12, "p1");
        tmp0.mo4invoke(p02, p12);
    }
}
