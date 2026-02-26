package com.google.android.material.internal;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Locale;

/* JADX INFO: compiled from: ManufacturerUtils.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class i {
    @NonNull
    private static String a() {
        String str = Build.MANUFACTURER;
        return str != null ? str.toLowerCase(Locale.ENGLISH) : "";
    }

    public static boolean b() {
        return a().equals("meizu");
    }
}
