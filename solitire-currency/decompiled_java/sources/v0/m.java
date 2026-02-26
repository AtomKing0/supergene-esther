package v0;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ironsource.v8;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: SizeConfigStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(19)
public class m implements k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Bitmap.Config[] f35014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Bitmap.Config[] f35015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Bitmap.Config[] f35016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Bitmap.Config[] f35017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Bitmap.Config[] f35018h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f35019a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g<b, Bitmap> f35020b = new g<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f35021c = new HashMap();

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f35022a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f35022a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35022a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35022a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f35022a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    static final class b implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c f35023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f35024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Bitmap.Config f35025c;

        public b(c cVar) {
            this.f35023a = cVar;
        }

        @Override // v0.l
        public void a() {
            this.f35023a.c(this);
        }

        public void b(int i10, Bitmap.Config config) {
            this.f35024b = i10;
            this.f35025c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f35024b == bVar.f35024b && o1.k.c(this.f35025c, bVar.f35025c);
        }

        public int hashCode() {
            int i10 = this.f35024b * 31;
            Bitmap.Config config = this.f35025c;
            return i10 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return m.h(this.f35024b, this.f35025c);
        }
    }

    /* JADX INFO: compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    static class c extends v0.c<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // v0.c
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a() {
            return new b(this);
        }

        public b e(int i10, Bitmap.Config config) {
            b bVarB = b();
            bVarB.b(i10, config);
            return bVarB;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f35014d = configArr;
        f35015e = configArr;
        f35016f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f35017g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f35018h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num2 = navigableMapJ.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                navigableMapJ.remove(num);
                return;
            } else {
                navigableMapJ.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    private b g(int i10, Bitmap.Config config) {
        b bVarE = this.f35019a.e(i10, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer numCeilingKey = j(config2).ceilingKey(Integer.valueOf(i10));
            if (numCeilingKey != null && numCeilingKey.intValue() <= i10 * 8) {
                if (numCeilingKey.intValue() == i10) {
                    if (config2 == null) {
                        if (config == null) {
                            return bVarE;
                        }
                    } else if (config2.equals(config)) {
                        return bVarE;
                    }
                }
                this.f35019a.c(bVarE);
                return this.f35019a.e(numCeilingKey.intValue(), config2);
            }
        }
        return bVarE;
    }

    static String h(int i10, Bitmap.Config config) {
        return v8.i.f15837d + i10 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f35015e;
        }
        int i10 = a.f35022a[config.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new Bitmap.Config[]{config} : f35018h : f35017g : f35016f : f35014d;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f35021c.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.f35021c.put(config, treeMap);
        return treeMap;
    }

    @Override // v0.k
    public String a(Bitmap bitmap) {
        return h(o1.k.g(bitmap), bitmap.getConfig());
    }

    @Override // v0.k
    public String b(int i10, int i11, Bitmap.Config config) {
        return h(o1.k.f(i10, i11, config), config);
    }

    @Override // v0.k
    public void c(Bitmap bitmap) {
        b bVarE = this.f35019a.e(o1.k.g(bitmap), bitmap.getConfig());
        this.f35020b.d(bVarE, bitmap);
        NavigableMap<Integer, Integer> navigableMapJ = j(bitmap.getConfig());
        Integer num = navigableMapJ.get(Integer.valueOf(bVarE.f35024b));
        navigableMapJ.put(Integer.valueOf(bVarE.f35024b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // v0.k
    @Nullable
    public Bitmap d(int i10, int i11, Bitmap.Config config) {
        b bVarG = g(o1.k.f(i10, i11, config), config);
        Bitmap bitmapA = this.f35020b.a(bVarG);
        if (bitmapA != null) {
            f(Integer.valueOf(bVarG.f35024b), bitmapA);
            bitmapA.reconfigure(i10, i11, config);
        }
        return bitmapA;
    }

    @Override // v0.k
    public int e(Bitmap bitmap) {
        return o1.k.g(bitmap);
    }

    @Override // v0.k
    @Nullable
    public Bitmap removeLast() {
        Bitmap bitmapF = this.f35020b.f();
        if (bitmapF != null) {
            f(Integer.valueOf(o1.k.g(bitmapF)), bitmapF);
        }
        return bitmapF;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f35020b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f35021c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f35021c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }
}
