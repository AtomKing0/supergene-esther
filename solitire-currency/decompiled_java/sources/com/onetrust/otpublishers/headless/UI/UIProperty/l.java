package com.onetrust.otpublishers.headless.UI.UIProperty;

import android.graphics.Typeface;
import android.widget.TextView;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f22782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f22783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22784c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f22785d;

    public static int a(@NonNull TextView textView, int i10) {
        Typeface typeface;
        return (i10 != -1 || (typeface = textView.getTypeface()) == null) ? i10 : typeface.getStyle();
    }

    @NonNull
    public final String toString() {
        return "FontProperty{fontName='" + this.f22782a + "', fontSize='" + this.f22783b + "', fontTextStyle='" + this.f22784c + "', typefaceKey='" + this.f22785d + "'}";
    }
}
