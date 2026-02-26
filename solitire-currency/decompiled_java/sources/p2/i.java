package p2;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.media3.extractor.ts.TsExtractor;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: DefaultExtractorsFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements r {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f32508n = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final a f32509o = new a(new a.InterfaceC0650a() { // from class: p2.g
        @Override // p2.i.a.InterfaceC0650a
        public final Constructor getConstructor() {
            return i.d();
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final a f32510p = new a(new a.InterfaceC0650a() { // from class: p2.h
        @Override // p2.i.a.InterfaceC0650a
        public final Constructor getConstructor() {
            return i.e();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f32511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f32512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f32515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f32516g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f32517h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f32518i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f32519j;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f32521l;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f32520k = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f32522m = TsExtractor.DEFAULT_TIMESTAMP_SEARCH_BYTES;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: DefaultExtractorsFactory.java */
    static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0650a f32523a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f32524b = new AtomicBoolean(false);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        @GuardedBy("extensionLoaded")
        private Constructor<? extends l> f32525c;

        /* JADX INFO: renamed from: p2.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: DefaultExtractorsFactory.java */
        public interface InterfaceC0650a {
            @Nullable
            Constructor<? extends l> getConstructor() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException;
        }

        public a(InterfaceC0650a interfaceC0650a) {
            this.f32523a = interfaceC0650a;
        }

        @Nullable
        private Constructor<? extends l> b() {
            synchronized (this.f32524b) {
                if (this.f32524b.get()) {
                    return this.f32525c;
                }
                try {
                    return this.f32523a.getConstructor();
                } catch (ClassNotFoundException unused) {
                    this.f32524b.set(true);
                    return this.f32525c;
                } catch (Exception e10) {
                    throw new RuntimeException("Error instantiating extension", e10);
                }
            }
        }

        @Nullable
        public l a(Object... objArr) {
            Constructor<? extends l> constructorB = b();
            if (constructorB == null) {
                return null;
            }
            try {
                return constructorB.newInstance(objArr);
            } catch (Exception e10) {
                throw new IllegalStateException("Unexpected error creating extractor", e10);
            }
        }
    }

    private void c(int i10, List<l> list) {
        switch (i10) {
            case 0:
                list.add(new z2.b());
                break;
            case 1:
                list.add(new z2.e());
                break;
            case 2:
                list.add(new z2.h((this.f32512c ? 2 : 0) | this.f32513d | (this.f32511b ? 1 : 0)));
                break;
            case 3:
                list.add(new q2.b((this.f32512c ? 2 : 0) | this.f32514e | (this.f32511b ? 1 : 0)));
                break;
            case 4:
                l lVarA = f32509o.a(Integer.valueOf(this.f32515f));
                if (lVarA == null) {
                    list.add(new s2.d(this.f32515f));
                } else {
                    list.add(lVarA);
                }
                break;
            case 5:
                list.add(new t2.c());
                break;
            case 6:
                list.add(new v2.e(this.f32516g));
                break;
            case 7:
                list.add(new w2.f((this.f32512c ? 2 : 0) | this.f32519j | (this.f32511b ? 1 : 0)));
                break;
            case 8:
                list.add(new x2.g(this.f32518i));
                list.add(new x2.k(this.f32517h));
                break;
            case 9:
                list.add(new y2.d());
                break;
            case 10:
                list.add(new z2.a0());
                break;
            case 11:
                list.add(new z2.h0(this.f32520k, this.f32521l, this.f32522m));
                break;
            case 12:
                list.add(new a3.b());
                break;
            case 14:
                list.add(new u2.a());
                break;
            case 15:
                l lVarA2 = f32510p.a(new Object[0]);
                if (lVarA2 != null) {
                    list.add(lVarA2);
                }
                break;
            case 16:
                list.add(new r2.b());
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static Constructor<? extends l> d() throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(l.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<? extends l> e() throws NoSuchMethodException, ClassNotFoundException {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(l.class).getConstructor(new Class[0]);
    }

    @Override // p2.r
    public synchronized l[] createExtractors() {
        return createExtractors(Uri.EMPTY, new HashMap());
    }

    @Override // p2.r
    public synchronized l[] createExtractors(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = f32508n;
        arrayList = new ArrayList(iArr.length);
        int iB = a4.l.b(map);
        if (iB != -1) {
            c(iB, arrayList);
        }
        int iC = a4.l.c(uri);
        if (iC != -1 && iC != iB) {
            c(iC, arrayList);
        }
        for (int i10 : iArr) {
            if (i10 != iB && i10 != iC) {
                c(i10, arrayList);
            }
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }
}
