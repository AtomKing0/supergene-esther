package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.Color;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final void a(@NotNull SwitchCompat switchCompat, @Nullable String str, @Nullable String str2) {
        t.i(switchCompat, "<this>");
        if (str == null || str.length() == 0) {
            switchCompat.getTrackDrawable().setTint(ContextCompat.getColor(switchCompat.getContext(), p6.a.f32627e));
        } else {
            switchCompat.getTrackDrawable().setTint(Color.parseColor(str));
        }
        if (str2 == null || str2.length() == 0) {
            switchCompat.getThumbDrawable().setTint(ContextCompat.getColor(switchCompat.getContext(), p6.a.f32625c));
        } else {
            switchCompat.getThumbDrawable().setTint(Color.parseColor(str2));
        }
    }
}
