package com.onetrust.otpublishers.headless.UI.extensions;

import android.graphics.Color;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    public static final void a(@DrawableRes int i10, int i11, @NotNull ImageView imageView, @Nullable String str, @Nullable String str2, @NotNull String navigatedFrom) {
        t.i(imageView, "<this>");
        t.i(navigatedFrom, "navigatedFrom");
        e eVar = new e(i10, i11, imageView, navigatedFrom, str, str2);
        if (!(str == null || str.length() == 0)) {
            com.bumptech.glide.b.u(imageView).p(str).h().b(new k1.f().b0(i11)).v0(eVar).t0(imageView);
            return;
        }
        try {
            com.bumptech.glide.b.u(imageView).p(str2).h().b(new k1.f().b0(i11)).v0(new c(navigatedFrom, str2)).t0(imageView);
        } catch (Exception e10) {
            OTLogger.a("OneTrust", 3, "error on showing " + navigatedFrom + " logo, " + e10);
        }
    }

    public static final void b(@NotNull ImageView imageView, @Nullable String str) {
        t.i(imageView, "<this>");
        if (str == null || str.length() == 0) {
            return;
        }
        imageView.getDrawable().setTint(Color.parseColor(str));
    }
}
