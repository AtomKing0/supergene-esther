package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.b;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GlideContext.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends ContextWrapper {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final k<?, ?> f8191k = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v0.b f8192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f8193b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final l1.f f8194c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final b.a f8195d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<k1.e<Object>> f8196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f8197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u0.k f8198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f8199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f8200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private k1.f f8201j;

    public d(@NonNull Context context, @NonNull v0.b bVar, @NonNull h hVar, @NonNull l1.f fVar, @NonNull b.a aVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<k1.e<Object>> list, @NonNull u0.k kVar, boolean z10, int i10) {
        super(context.getApplicationContext());
        this.f8192a = bVar;
        this.f8193b = hVar;
        this.f8194c = fVar;
        this.f8195d = aVar;
        this.f8196e = list;
        this.f8197f = map;
        this.f8198g = kVar;
        this.f8199h = z10;
        this.f8200i = i10;
    }

    @NonNull
    public <X> l1.i<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f8194c.a(imageView, cls);
    }

    @NonNull
    public v0.b b() {
        return this.f8192a;
    }

    public List<k1.e<Object>> c() {
        return this.f8196e;
    }

    public synchronized k1.f d() {
        if (this.f8201j == null) {
            this.f8201j = this.f8195d.build().L();
        }
        return this.f8201j;
    }

    @NonNull
    public <T> k<?, T> e(@NonNull Class<T> cls) {
        k<?, T> kVar = (k) this.f8197f.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.f8197f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f8191k : kVar;
    }

    @NonNull
    public u0.k f() {
        return this.f8198g;
    }

    public int g() {
        return this.f8200i;
    }

    @NonNull
    public h h() {
        return this.f8193b;
    }

    public boolean i() {
        return this.f8199h;
    }
}
