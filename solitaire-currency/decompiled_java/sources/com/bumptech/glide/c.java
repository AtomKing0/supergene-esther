package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.b;
import h1.m;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import w0.a;
import w0.i;

/* JADX INFO: compiled from: GlideBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private u0.k f8171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private v0.d f8172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private v0.b f8173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private w0.h f8174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private x0.a f8175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private x0.a f8176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private a.InterfaceC0717a f8177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private w0.i f8178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h1.d f8179j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private m.b f8182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private x0.a f8183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f8184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private List<k1.e<Object>> f8185p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8186q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f8187r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, k<?, ?>> f8170a = new ArrayMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f8180k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private b.a f8181l = new a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f8188s = 700;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f8189t = 128;

    /* JADX INFO: compiled from: GlideBuilder.java */
    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public k1.f build() {
            return new k1.f();
        }
    }

    @NonNull
    b a(@NonNull Context context) {
        if (this.f8175f == null) {
            this.f8175f = x0.a.f();
        }
        if (this.f8176g == null) {
            this.f8176g = x0.a.d();
        }
        if (this.f8183n == null) {
            this.f8183n = x0.a.b();
        }
        if (this.f8178i == null) {
            this.f8178i = new i.a(context).a();
        }
        if (this.f8179j == null) {
            this.f8179j = new h1.f();
        }
        if (this.f8172c == null) {
            int iB = this.f8178i.b();
            if (iB > 0) {
                this.f8172c = new v0.j(iB);
            } else {
                this.f8172c = new v0.e();
            }
        }
        if (this.f8173d == null) {
            this.f8173d = new v0.i(this.f8178i.a());
        }
        if (this.f8174e == null) {
            this.f8174e = new w0.g(this.f8178i.d());
        }
        if (this.f8177h == null) {
            this.f8177h = new w0.f(context);
        }
        if (this.f8171b == null) {
            this.f8171b = new u0.k(this.f8174e, this.f8177h, this.f8176g, this.f8175f, x0.a.h(), this.f8183n, this.f8184o);
        }
        List<k1.e<Object>> list = this.f8185p;
        if (list == null) {
            this.f8185p = Collections.emptyList();
        } else {
            this.f8185p = Collections.unmodifiableList(list);
        }
        return new b(context, this.f8171b, this.f8174e, this.f8172c, this.f8173d, new m(this.f8182m), this.f8179j, this.f8180k, this.f8181l, this.f8170a, this.f8185p, this.f8186q, this.f8187r, this.f8188s, this.f8189t);
    }

    void b(@Nullable m.b bVar) {
        this.f8182m = bVar;
    }
}
