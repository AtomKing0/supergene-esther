package t;

import android.graphics.Bitmap;
import androidx.annotation.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.d0;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;

/* JADX INFO: compiled from: WeakMemoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f34004c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final LinkedHashMap<c.b, ArrayList<b>> f34005a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f34006b;

    /* JADX INFO: compiled from: WeakMemoryCache.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: WeakMemoryCache.kt */
    @VisibleForTesting
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final WeakReference<Bitmap> f34008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f34009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f34010d;

        public b(int i10, @NotNull WeakReference<Bitmap> weakReference, @NotNull Map<String, ? extends Object> map, int i11) {
            this.f34007a = i10;
            this.f34008b = weakReference;
            this.f34009c = map;
            this.f34010d = i11;
        }

        @NotNull
        public final WeakReference<Bitmap> a() {
            return this.f34008b;
        }

        @NotNull
        public final Map<String, Object> b() {
            return this.f34009c;
        }

        public final int c() {
            return this.f34007a;
        }

        public final int d() {
            return this.f34010d;
        }
    }

    private final void e() {
        int i10 = this.f34006b;
        this.f34006b = i10 + 1;
        if (i10 >= 10) {
            d();
        }
    }

    @Override // t.i
    public synchronized void a(int i10) {
        if (i10 >= 10 && i10 != 20) {
            d();
        }
    }

    @Override // t.i
    @Nullable
    public synchronized c.C0690c b(@NotNull c.b bVar) {
        ArrayList<b> arrayList = this.f34005a.get(bVar);
        c.C0690c c0690c = null;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            b bVar2 = arrayList.get(i10);
            Bitmap bitmap = bVar2.a().get();
            c.C0690c c0690c2 = bitmap != null ? new c.C0690c(bitmap, bVar2.b()) : null;
            if (c0690c2 != null) {
                c0690c = c0690c2;
                break;
            }
            i10++;
        }
        e();
        return c0690c;
    }

    @Override // t.i
    public synchronized void c(@NotNull c.b bVar, @NotNull Bitmap bitmap, @NotNull Map<String, ? extends Object> map, int i10) {
        LinkedHashMap<c.b, ArrayList<b>> linkedHashMap = this.f34005a;
        ArrayList<b> arrayList = linkedHashMap.get(bVar);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            linkedHashMap.put(bVar, arrayList);
        }
        ArrayList<b> arrayList2 = arrayList;
        int iIdentityHashCode = System.identityHashCode(bitmap);
        b bVar2 = new b(iIdentityHashCode, new WeakReference(bitmap), map, i10);
        int size = arrayList2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size) {
                arrayList2.add(bVar2);
                break;
            }
            b bVar3 = arrayList2.get(i11);
            if (i10 < bVar3.d()) {
                i11++;
            } else if (bVar3.c() == iIdentityHashCode && bVar3.a().get() == bitmap) {
                arrayList2.set(i11, bVar2);
            } else {
                arrayList2.add(i11, bVar2);
            }
        }
        e();
    }

    @VisibleForTesting
    public final void d() {
        WeakReference<Bitmap> weakReferenceA;
        this.f34006b = 0;
        Iterator<ArrayList<b>> it = this.f34005a.values().iterator();
        while (it.hasNext()) {
            ArrayList<b> next = it.next();
            if (next.size() <= 1) {
                b bVar = (b) d0.k0(next);
                if (((bVar == null || (weakReferenceA = bVar.a()) == null) ? null : weakReferenceA.get()) == null) {
                    it.remove();
                }
            } else {
                int size = next.size();
                int i10 = 0;
                for (int i11 = 0; i11 < size; i11++) {
                    int i12 = i11 - i10;
                    if (next.get(i12).a().get() == null) {
                        next.remove(i12);
                        i10++;
                    }
                }
                if (next.isEmpty()) {
                    it.remove();
                }
            }
        }
    }
}
