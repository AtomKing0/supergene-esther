package com.google.android.exoplayer2.ui;

import a4.o0;
import android.graphics.Color;
import androidx.annotation.ColorInt;

/* JADX INFO: compiled from: HtmlUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class c {
    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(@ColorInt int i10) {
        return o0.z("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Double.valueOf(((double) Color.alpha(i10)) / 255.0d));
    }
}
