package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b1.a0;
import b1.c0;
import b1.e0;
import b1.l;
import b1.q;
import b1.t;
import b1.w;
import b1.z;
import c1.a;
import com.bumptech.glide.load.ImageHeaderParser;
import h1.m;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s0.k;
import y0.a;
import y0.b;
import y0.d;
import y0.e;
import y0.f;
import y0.k;
import y0.s;
import y0.u;
import y0.v;
import y0.w;
import y0.x;
import z0.a;
import z0.b;
import z0.c;
import z0.d;
import z0.e;

/* JADX INFO: compiled from: Glide.java */
/* JADX INFO: loaded from: classes2.dex */
public class b implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile b f8157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static volatile boolean f8158m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u0.k f8159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.d f8160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w0.h f8161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d f8162d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h f8163e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final v0.b f8164f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final m f8165g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final h1.d f8166h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f8168j;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<j> f8167i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private e f8169k = e.NORMAL;

    /* JADX INFO: compiled from: Glide.java */
    public interface a {
        @NonNull
        k1.f build();
    }

    b(@NonNull Context context, @NonNull u0.k kVar, @NonNull w0.h hVar, @NonNull v0.d dVar, @NonNull v0.b bVar, @NonNull m mVar, @NonNull h1.d dVar2, int i10, @NonNull a aVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<k1.e<Object>> list, boolean z10, boolean z11, int i11, int i12) {
        r0.j gVar;
        r0.j a0Var;
        this.f8159a = kVar;
        this.f8160b = dVar;
        this.f8164f = bVar;
        this.f8161c = hVar;
        this.f8165g = mVar;
        this.f8166h = dVar2;
        this.f8168j = aVar;
        Resources resources = context.getResources();
        h hVar2 = new h();
        this.f8163e = hVar2;
        hVar2.o(new l());
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 27) {
            hVar2.o(new t());
        }
        List<ImageHeaderParser> listG = hVar2.g();
        f1.a aVar2 = new f1.a(context, listG, dVar, bVar);
        r0.j<ParcelFileDescriptor, Bitmap> jVarG = e0.g(dVar);
        if (!z11 || i13 < 28) {
            q qVar = new q(hVar2.g(), resources.getDisplayMetrics(), dVar, bVar);
            gVar = new b1.g(qVar);
            a0Var = new a0(qVar, bVar);
        } else {
            a0Var = new w();
            gVar = new b1.i();
        }
        d1.d dVar3 = new d1.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar4 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar3 = new s.a(resources);
        b1.c cVar2 = new b1.c(bVar);
        g1.a aVar4 = new g1.a();
        g1.d dVar5 = new g1.d();
        ContentResolver contentResolver = context.getContentResolver();
        h hVarQ = hVar2.c(ByteBuffer.class, new y0.c()).c(InputStream.class, new y0.t(bVar)).e("Bitmap", ByteBuffer.class, Bitmap.class, gVar).e("Bitmap", InputStream.class, Bitmap.class, a0Var).e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, jVarG).e("Bitmap", AssetFileDescriptor.class, Bitmap.class, e0.c(dVar)).b(Bitmap.class, Bitmap.class, v.a.a()).e("Bitmap", Bitmap.class, Bitmap.class, new c0()).d(Bitmap.class, cVar2).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new b1.a(resources, gVar)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new b1.a(resources, a0Var)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new b1.a(resources, jVarG)).d(BitmapDrawable.class, new b1.b(dVar, cVar2)).e("Gif", InputStream.class, f1.c.class, new f1.j(listG, aVar2, bVar)).e("Gif", ByteBuffer.class, f1.c.class, aVar2).d(f1.c.class, new f1.d()).b(q0.a.class, q0.a.class, v.a.a()).e("Bitmap", q0.a.class, Bitmap.class, new f1.h(dVar)).a(Uri.class, Drawable.class, dVar3).a(Uri.class, Bitmap.class, new z(dVar3, dVar)).q(new a.C0150a()).b(File.class, ByteBuffer.class, new d.b()).b(File.class, InputStream.class, new f.e()).a(File.class, File.class, new e1.a()).b(File.class, ParcelFileDescriptor.class, new f.b()).b(File.class, File.class, v.a.a()).q(new k.a(bVar));
        Class cls = Integer.TYPE;
        hVarQ.b(cls, InputStream.class, cVar).b(cls, ParcelFileDescriptor.class, bVar2).b(Integer.class, InputStream.class, cVar).b(Integer.class, ParcelFileDescriptor.class, bVar2).b(Integer.class, Uri.class, dVar4).b(cls, AssetFileDescriptor.class, aVar3).b(Integer.class, AssetFileDescriptor.class, aVar3).b(cls, Uri.class, dVar4).b(String.class, InputStream.class, new e.c()).b(Uri.class, InputStream.class, new e.c()).b(String.class, InputStream.class, new u.c()).b(String.class, ParcelFileDescriptor.class, new u.b()).b(String.class, AssetFileDescriptor.class, new u.a()).b(Uri.class, InputStream.class, new b.a()).b(Uri.class, InputStream.class, new a.c(context.getAssets())).b(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).b(Uri.class, InputStream.class, new c.a(context)).b(Uri.class, InputStream.class, new d.a(context)).b(Uri.class, InputStream.class, new w.d(contentResolver)).b(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).b(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).b(Uri.class, InputStream.class, new x.a()).b(URL.class, InputStream.class, new e.a()).b(Uri.class, File.class, new k.a(context)).b(y0.g.class, InputStream.class, new a.C0760a()).b(byte[].class, ByteBuffer.class, new b.a()).b(byte[].class, InputStream.class, new b.d()).b(Uri.class, Uri.class, v.a.a()).b(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new d1.e()).p(Bitmap.class, BitmapDrawable.class, new g1.b(resources)).p(Bitmap.class, byte[].class, aVar4).p(Drawable.class, byte[].class, new g1.c(dVar, aVar4, dVar5)).p(f1.c.class, byte[].class, dVar5);
        this.f8162d = new d(context, bVar, hVar2, new l1.f(), aVar, map, list, kVar, z10, i10);
    }

    @GuardedBy("Glide.class")
    private static void a(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        if (f8158m) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f8158m = true;
        m(context, generatedAppGlideModule);
        f8158m = false;
    }

    @NonNull
    public static b c(@NonNull Context context) {
        if (f8157l == null) {
            GeneratedAppGlideModule generatedAppGlideModuleD = d(context.getApplicationContext());
            synchronized (b.class) {
                if (f8157l == null) {
                    a(context, generatedAppGlideModuleD);
                }
            }
        }
        return f8157l;
    }

    @Nullable
    private static GeneratedAppGlideModule d(Context context) {
        try {
            return (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext());
        } catch (ClassNotFoundException unused) {
            if (Log.isLoggable("Glide", 5)) {
                Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            }
            return null;
        } catch (IllegalAccessException e10) {
            q(e10);
            return null;
        } catch (InstantiationException e11) {
            q(e11);
            return null;
        } catch (NoSuchMethodException e12) {
            q(e12);
            return null;
        } catch (InvocationTargetException e13) {
            q(e13);
            return null;
        }
    }

    @NonNull
    private static m l(@Nullable Context context) {
        o1.j.e(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return c(context).k();
    }

    @GuardedBy("Glide.class")
    private static void m(@NonNull Context context, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        n(context, new c(), generatedAppGlideModule);
    }

    @GuardedBy("Glide.class")
    private static void n(@NonNull Context context, @NonNull c cVar, @Nullable GeneratedAppGlideModule generatedAppGlideModule) {
        Context applicationContext = context.getApplicationContext();
        List<i1.b> listEmptyList = Collections.emptyList();
        if (generatedAppGlideModule == null || generatedAppGlideModule.c()) {
            listEmptyList = new i1.d(applicationContext).a();
        }
        if (generatedAppGlideModule != null && !generatedAppGlideModule.d().isEmpty()) {
            Set<Class<?>> setD = generatedAppGlideModule.d();
            Iterator<i1.b> it = listEmptyList.iterator();
            while (it.hasNext()) {
                i1.b next = it.next();
                if (setD.contains(next.getClass())) {
                    if (Log.isLoggable("Glide", 3)) {
                        Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + next);
                    }
                    it.remove();
                }
            }
        }
        if (Log.isLoggable("Glide", 3)) {
            Iterator<i1.b> it2 = listEmptyList.iterator();
            while (it2.hasNext()) {
                Log.d("Glide", "Discovered GlideModule from manifest: " + it2.next().getClass());
            }
        }
        cVar.b(generatedAppGlideModule != null ? generatedAppGlideModule.e() : null);
        Iterator<i1.b> it3 = listEmptyList.iterator();
        while (it3.hasNext()) {
            it3.next().a(applicationContext, cVar);
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.b(applicationContext, cVar);
        }
        b bVarA = cVar.a(applicationContext);
        for (i1.b bVar : listEmptyList) {
            try {
                bVar.b(applicationContext, bVarA, bVarA.f8163e);
            } catch (AbstractMethodError e10) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + bVar.getClass().getName(), e10);
            }
        }
        if (generatedAppGlideModule != null) {
            generatedAppGlideModule.a(applicationContext, bVarA, bVarA.f8163e);
        }
        applicationContext.registerComponentCallbacks(bVarA);
        f8157l = bVarA;
    }

    private static void q(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    @NonNull
    public static j t(@NonNull Context context) {
        return l(context).k(context);
    }

    @NonNull
    public static j u(@NonNull View view) {
        return l(view.getContext()).l(view);
    }

    public void b() {
        o1.k.a();
        this.f8161c.b();
        this.f8160b.b();
        this.f8164f.b();
    }

    @NonNull
    public v0.b e() {
        return this.f8164f;
    }

    @NonNull
    public v0.d f() {
        return this.f8160b;
    }

    h1.d g() {
        return this.f8166h;
    }

    @NonNull
    public Context h() {
        return this.f8162d.getBaseContext();
    }

    @NonNull
    d i() {
        return this.f8162d;
    }

    @NonNull
    public h j() {
        return this.f8163e;
    }

    @NonNull
    public m k() {
        return this.f8165g;
    }

    void o(j jVar) {
        synchronized (this.f8167i) {
            if (this.f8167i.contains(jVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.f8167i.add(jVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        b();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        r(i10);
    }

    boolean p(@NonNull l1.h<?> hVar) {
        synchronized (this.f8167i) {
            Iterator<j> it = this.f8167i.iterator();
            while (it.hasNext()) {
                if (it.next().w(hVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void r(int i10) {
        o1.k.a();
        Iterator<j> it = this.f8167i.iterator();
        while (it.hasNext()) {
            it.next().onTrimMemory(i10);
        }
        this.f8161c.a(i10);
        this.f8160b.a(i10);
        this.f8164f.a(i10);
    }

    void s(j jVar) {
        synchronized (this.f8167i) {
            if (!this.f8167i.contains(jVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.f8167i.remove(jVar);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
