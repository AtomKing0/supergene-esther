package com.onetrust.otpublishers.headless.UI.Helper;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class m {
    @NotNull
    public static final <T extends ViewBinding> b<T> a(@NotNull Fragment fragment, @NotNull h9.l<? super View, ? extends T> viewBindingFactory) {
        t.i(fragment, "<this>");
        t.i(viewBindingFactory, "viewBindingFactory");
        return new b<>(fragment, viewBindingFactory);
    }
}
