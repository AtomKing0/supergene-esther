package com.moloco.sdk.internal.publisher.nativead.model;

import android.net.Uri;
import com.moloco.sdk.internal.publisher.nativead.model.a;
import com.moloco.sdk.internal.publisher.nativead.model.b;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;
import v8.n;
import v8.s;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Map<Integer, b.a> f18196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final Map<Integer, b.C0318b> f18197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final Map<Integer, b.c> f18198c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final Map<Integer, b.d> f18199d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final List<s<a.AbstractC0316a, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> f18200e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final l f18201f;

    public static final class a extends v implements h9.a<Map<Integer, ? extends b>> {
        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<Integer, b> invoke() {
            return r0.n(r0.n(r0.n(c.this.f18196a, c.this.f18197b), c.this.f18198c), c.this.f18199d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Map<Integer, b.a> data, @NotNull Map<Integer, b.C0318b> images, @NotNull Map<Integer, b.c> titles, @NotNull Map<Integer, b.d> videos, @NotNull List<? extends s<? extends a.AbstractC0316a, ? extends com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c>> failedAssets) {
        t.i(data, "data");
        t.i(images, "images");
        t.i(titles, "titles");
        t.i(videos, "videos");
        t.i(failedAssets, "failedAssets");
        this.f18196a = data;
        this.f18197b = images;
        this.f18198c = titles;
        this.f18199d = videos;
        this.f18200e = failedAssets;
        this.f18201f = n.a(new a());
    }

    @Nullable
    public final String a(int i10) {
        b.a aVar = this.f18196a.get(Integer.valueOf(i10));
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    @Nullable
    public final Uri c(int i10) {
        b.C0318b c0318b = this.f18197b.get(Integer.valueOf(i10));
        if (c0318b != null) {
            return c0318b.b();
        }
        return null;
    }

    @Nullable
    public final String e(int i10) {
        b.c cVar = this.f18198c.get(Integer.valueOf(i10));
        if (cVar != null) {
            return cVar.b();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return t.d(this.f18196a, cVar.f18196a) && t.d(this.f18197b, cVar.f18197b) && t.d(this.f18198c, cVar.f18198c) && t.d(this.f18199d, cVar.f18199d) && t.d(this.f18200e, cVar.f18200e);
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.a g(int i10) {
        b.d dVar = this.f18199d.get(Integer.valueOf(i10));
        if (dVar != null) {
            return dVar.b();
        }
        return null;
    }

    public int hashCode() {
        return (((((((this.f18196a.hashCode() * 31) + this.f18197b.hashCode()) * 31) + this.f18198c.hashCode()) * 31) + this.f18199d.hashCode()) * 31) + this.f18200e.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreparedNativeAssets(data=" + this.f18196a + ", images=" + this.f18197b + ", titles=" + this.f18198c + ", videos=" + this.f18199d + ", failedAssets=" + this.f18200e + ')';
    }
}
