package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.Color;
import android.view.View;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    public static final void a(@Nullable String str, @NotNull View view) {
        t.i(view, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        view.setBackgroundColor(Color.parseColor(str));
    }
}
