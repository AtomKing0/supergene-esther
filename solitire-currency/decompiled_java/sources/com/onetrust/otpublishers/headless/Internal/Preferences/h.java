package com.onetrust.otpublishers.headless.Internal.Preferences;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f21895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharedPreferences f21896b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f21897c;

    public h(@NonNull Context context, @NonNull SharedPreferences sharedPreferences, @NonNull String str) {
        this.f21896b = sharedPreferences;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("com.onetrust.otpublishers.headless.preference.OTT_USER_" + new com.onetrust.otpublishers.headless.Internal.profile.d(context).n(str), 0);
        this.f21897c = sharedPreferences2;
        this.f21895a = new d(sharedPreferences, sharedPreferences2);
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).contains(str);
    }

    @Override // android.content.SharedPreferences
    @NonNull
    public final SharedPreferences.Editor edit() {
        return this.f21895a;
    }

    @Override // android.content.SharedPreferences
    @Nullable
    @Deprecated
    public final Map<String, ?> getAll() {
        return null;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getBoolean(str, z10);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f10) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getFloat(str, f10);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i10) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getInt(str, i10);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j10) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getLong(str, j10);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public final String getString(String str, @Nullable String str2) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    @Nullable
    public final Set<String> getStringSet(String str, @Nullable Set<String> set) {
        return (com.onetrust.otpublishers.headless.Internal.Constants.a.a(str) ? this.f21897c : this.f21896b).getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f21896b.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.f21897c.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(@Nullable SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f21896b.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        this.f21897c.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
