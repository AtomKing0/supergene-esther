package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    public static final void a(@NotNull Drawable drawable, @Nullable String str) {
        t.i(drawable, "<this>");
        drawable.setTint(Color.parseColor(str));
    }
}
