package com.onetrust.otpublishers.headless.Internal.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.onetrust.otpublishers.headless.Internal.Helper.v;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f21885a;

    public a(@NonNull Context context) {
        this.f21885a = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public final void a(String str) {
        if (this.f21885a.contains(str)) {
            this.f21885a.edit().remove(str).apply();
        }
    }

    public final void b(@NonNull String str, int i10) {
        this.f21885a.edit().putInt(str, i10).apply();
    }

    public final void c(@NonNull String str, @Nullable String str2) {
        v.a(this.f21885a, str, str2);
    }

    public final int d(String str) {
        return this.f21885a.getInt(str, -1);
    }

    public final String e(String str) {
        return this.f21885a.getString(str, "");
    }
}
