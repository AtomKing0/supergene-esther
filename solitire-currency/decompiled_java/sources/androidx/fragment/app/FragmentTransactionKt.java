package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.IdRes;

/* JADX INFO: compiled from: FragmentTransaction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FragmentTransactionKt {
    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, @IdRes int i10, String str, Bundle bundle) {
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.t.h(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.t.h(fragmentTransactionAdd, "add(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction replace(FragmentTransaction fragmentTransaction, @IdRes int i10, String str, Bundle bundle) {
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.t.h(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }

    public static /* synthetic */ FragmentTransaction replace$default(FragmentTransaction fragmentTransaction, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionReplace = fragmentTransaction.replace(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.t.h(fragmentTransactionReplace, "replace(containerViewId, F::class.java, args, tag)");
        return fragmentTransactionReplace;
    }

    public static final /* synthetic */ <F extends Fragment> FragmentTransaction add(FragmentTransaction fragmentTransaction, String tag, Bundle bundle) {
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, tag);
        kotlin.jvm.internal.t.h(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }

    public static /* synthetic */ FragmentTransaction add$default(FragmentTransaction fragmentTransaction, String tag, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.t.i(fragmentTransaction, "<this>");
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.o(4, "F");
        FragmentTransaction fragmentTransactionAdd = fragmentTransaction.add(Fragment.class, bundle, tag);
        kotlin.jvm.internal.t.h(fragmentTransactionAdd, "add(F::class.java, args, tag)");
        return fragmentTransactionAdd;
    }
}
