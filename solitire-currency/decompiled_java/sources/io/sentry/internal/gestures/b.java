package io.sentry.internal.gestures;

import io.sentry.util.w;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UiElement.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    final WeakReference<Object> f27920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    final String f27921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    final String f27922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    final String f27923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    final String f27924e;

    /* JADX INFO: compiled from: UiElement.java */
    public enum a {
        CLICKABLE,
        SCROLLABLE
    }

    public b(@Nullable Object obj, @Nullable String str, @Nullable String str2, @Nullable String str3, @NotNull String str4) {
        this.f27920a = new WeakReference<>(obj);
        this.f27921b = str;
        this.f27922c = str2;
        this.f27923d = str3;
        this.f27924e = str4;
    }

    @Nullable
    public String a() {
        return this.f27921b;
    }

    @NotNull
    public String b() {
        String str = this.f27922c;
        return str != null ? str : (String) w.c(this.f27923d, "UiElement.tag can't be null");
    }

    @NotNull
    public String c() {
        return this.f27924e;
    }

    @Nullable
    public String d() {
        return this.f27922c;
    }

    @Nullable
    public String e() {
        return this.f27923d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return w.a(this.f27921b, bVar.f27921b) && w.a(this.f27922c, bVar.f27922c) && w.a(this.f27923d, bVar.f27923d);
    }

    @Nullable
    public Object f() {
        return this.f27920a.get();
    }

    public int hashCode() {
        return w.b(this.f27920a, this.f27922c, this.f27923d);
    }
}
