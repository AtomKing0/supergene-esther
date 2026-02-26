package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import s0.e;
import u0.t;
import u0.v;
import y0.n;
import y0.o;
import y0.p;

/* JADX INFO: compiled from: Registry.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j1.a f8214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final j1.e f8215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final j1.f f8216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s0.f f8217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final g1.f f8218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final j1.b f8219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j1.d f8220h = new j1.d();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final j1.c f8221i = new j1.c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f8222j;

    /* JADX INFO: compiled from: Registry.java */
    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders for model: " + obj);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* JADX INFO: compiled from: Registry.java */
    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public h() {
        Pools.Pool<List<Throwable>> poolE = p1.a.e();
        this.f8222j = poolE;
        this.f8213a = new p(poolE);
        this.f8214b = new j1.a();
        this.f8215c = new j1.e();
        this.f8216d = new j1.f();
        this.f8217e = new s0.f();
        this.f8218f = new g1.f();
        this.f8219g = new j1.b();
        r(Arrays.asList("Gif", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    private <Data, TResource, Transcode> List<u0.i<Data, TResource, Transcode>> f(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.f8215c.d(cls, cls2)) {
            for (Class cls5 : this.f8218f.b(cls4, cls3)) {
                arrayList.add(new u0.i(cls, cls4, cls5, this.f8215c.b(cls, cls4), this.f8218f.a(cls4, cls5), this.f8222j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <Data, TResource> h a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull r0.j<Data, TResource> jVar) {
        e("legacy_append", cls, cls2, jVar);
        return this;
    }

    @NonNull
    public <Model, Data> h b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull o<Model, Data> oVar) {
        this.f8213a.a(cls, cls2, oVar);
        return this;
    }

    @NonNull
    public <Data> h c(@NonNull Class<Data> cls, @NonNull r0.d<Data> dVar) {
        this.f8214b.a(cls, dVar);
        return this;
    }

    @NonNull
    public <TResource> h d(@NonNull Class<TResource> cls, @NonNull r0.k<TResource> kVar) {
        this.f8216d.a(cls, kVar);
        return this;
    }

    @NonNull
    public <Data, TResource> h e(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull r0.j<Data, TResource> jVar) {
        this.f8215c.a(str, jVar, cls, cls2);
        return this;
    }

    @NonNull
    public List<ImageHeaderParser> g() {
        List<ImageHeaderParser> listB = this.f8219g.b();
        if (listB.isEmpty()) {
            throw new b();
        }
        return listB;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> h(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVarA = this.f8221i.a(cls, cls2, cls3);
        if (this.f8221i.c(tVarA)) {
            return null;
        }
        if (tVarA == null) {
            List<u0.i<Data, TResource, Transcode>> listF = f(cls, cls2, cls3);
            tVarA = listF.isEmpty() ? null : new t<>(cls, cls2, cls3, listF, this.f8222j);
            this.f8221i.d(cls, cls2, cls3, tVarA);
        }
        return tVarA;
    }

    @NonNull
    public <Model> List<n<Model, ?>> i(@NonNull Model model) {
        List<n<Model, ?>> listD = this.f8213a.d(model);
        if (listD.isEmpty()) {
            throw new c(model);
        }
        return listD;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.f8220h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f8213a.c(cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.f8215c.d(it.next(), cls2)) {
                    if (!this.f8218f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.f8220h.b(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <X> r0.k<X> k(@NonNull v<X> vVar) throws d {
        r0.k<X> kVarB = this.f8216d.b(vVar.a());
        if (kVarB != null) {
            return kVarB;
        }
        throw new d(vVar.a());
    }

    @NonNull
    public <X> s0.e<X> l(@NonNull X x10) {
        return this.f8217e.a(x10);
    }

    @NonNull
    public <X> r0.d<X> m(@NonNull X x10) throws e {
        r0.d<X> dVarB = this.f8214b.b(x10.getClass());
        if (dVarB != null) {
            return dVarB;
        }
        throw new e(x10.getClass());
    }

    public boolean n(@NonNull v<?> vVar) {
        return this.f8216d.b(vVar.a()) != null;
    }

    @NonNull
    public h o(@NonNull ImageHeaderParser imageHeaderParser) {
        this.f8219g.a(imageHeaderParser);
        return this;
    }

    @NonNull
    public <TResource, Transcode> h p(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull g1.e<TResource, Transcode> eVar) {
        this.f8218f.c(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public h q(@NonNull e.a<?> aVar) {
        this.f8217e.b(aVar);
        return this;
    }

    @NonNull
    public final h r(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.addAll(list);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.f8215c.e(arrayList);
        return this;
    }
}
