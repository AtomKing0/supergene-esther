package com.google.firebase.installations;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f10324b = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f10325c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static i f10326d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b6.a f10327a;

    private i(b6.a aVar) {
        this.f10327a = aVar;
    }

    public static i c() {
        return d(b6.b.a());
    }

    public static i d(b6.a aVar) {
        if (f10326d == null) {
            f10326d = new i(aVar);
        }
        return f10326d;
    }

    static boolean g(@Nullable String str) {
        return f10325c.matcher(str).matches();
    }

    static boolean h(@Nullable String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f10327a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(@NonNull z5.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + f10324b;
    }
}
