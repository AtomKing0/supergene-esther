package com.onetrust.otpublishers.headless.Internal.Preferences;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements SharedPreferences.Editor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences.Editor f21887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences.Editor f21888b;

    public d(@NonNull SharedPreferences sharedPreferences, @NonNull SharedPreferences sharedPreferences2) {
        this.f21887a = sharedPreferences.edit();
        this.f21888b = sharedPreferences2.edit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.f21887a.apply();
        this.f21888b.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor clear() {
        this.f21887a.clear();
        this.f21888b.clear();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        return this.f21887a.commit() && this.f21888b.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putBoolean(String str, boolean z10) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putBoolean(str, z10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putFloat(String str, float f10) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putFloat(str, f10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putInt(String str, int i10) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putInt(str, i10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putLong(String str, long j10) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putLong(str, j10);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putString(String str, @Nullable String str2) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putString(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor putStringSet(String str, @Nullable Set<String> set) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).putStringSet(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    @NonNull
    public final SharedPreferences.Editor remove(String str) {
        (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21888b : this.f21887a).remove(str);
        return this;
    }
}
