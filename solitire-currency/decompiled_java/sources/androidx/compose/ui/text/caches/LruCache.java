package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import com.ironsource.nb;
import h9.a;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LruCache.kt */
/* JADX INFO: loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;

    @NotNull
    private final LinkedHashSet<K> keySet;

    @NotNull
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;

    @NotNull
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public LruCache(int i10) {
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        this.maxSize = i10;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    private final int safeSizeOf(K k10, V v10) {
        int iSizeOf = sizeOf(k10, v10);
        if (iSizeOf >= 0) {
            return iSizeOf;
        }
        throw new IllegalStateException(("Negative size: " + k10 + nb.T + v10).toString());
    }

    @Nullable
    protected V create(K k10) {
        return null;
    }

    public final int createCount() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.createCount;
        }
        return i10;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final int evictionCount() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.evictionCount;
        }
        return i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final V get(K k10) {
        synchronized (this.monitor) {
            V v10 = this.map.get(k10);
            if (v10 != null) {
                this.keySet.remove(k10);
                this.keySet.add(k10);
                this.hitCount++;
                return v10;
            }
            this.missCount++;
            V vCreate = create(k10);
            if (vCreate == null) {
                return null;
            }
            synchronized (this.monitor) {
                this.createCount++;
                Object objPut = this.map.put(k10, vCreate);
                this.keySet.remove(k10);
                this.keySet.add(k10);
                if (objPut != null) {
                    this.map.put(k10, objPut);
                    v10 = (V) objPut;
                } else {
                    this.size = size() + safeSizeOf(k10, vCreate);
                }
                k0 k0Var = k0.f35197a;
            }
            if (v10 != null) {
                entryRemoved(false, k10, vCreate, v10);
                return v10;
            }
            trimToSize(this.maxSize);
            return vCreate;
        }
    }

    public final int hitCount() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.hitCount;
        }
        return i10;
    }

    public final int maxSize() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.maxSize;
        }
        return i10;
    }

    public final int missCount() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.missCount;
        }
        return i10;
    }

    @Nullable
    public final V put(K k10, V v10) {
        V vPut;
        if (k10 == null || v10 == null) {
            throw null;
        }
        synchronized (this.monitor) {
            this.putCount++;
            this.size = size() + safeSizeOf(k10, v10);
            vPut = this.map.put(k10, v10);
            if (vPut != null) {
                this.size = size() - safeSizeOf(k10, vPut);
            }
            if (this.keySet.contains(k10)) {
                this.keySet.remove(k10);
            }
            this.keySet.add(k10);
        }
        if (vPut != null) {
            entryRemoved(false, k10, vPut, v10);
        }
        trimToSize(this.maxSize);
        return vPut;
    }

    public final int putCount() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.putCount;
        }
        return i10;
    }

    @Nullable
    public final V remove(K k10) {
        V vRemove;
        k10.getClass();
        synchronized (this.monitor) {
            vRemove = this.map.remove(k10);
            this.keySet.remove(k10);
            if (vRemove != null) {
                this.size = size() - safeSizeOf(k10, vRemove);
            }
            k0 k0Var = k0.f35197a;
        }
        if (vRemove != null) {
            entryRemoved(false, k10, vRemove, null);
        }
        return vRemove;
    }

    public void resize(int i10) {
        if (!(i10 > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        synchronized (this.monitor) {
            this.maxSize = i10;
            k0 k0Var = k0.f35197a;
        }
        trimToSize(i10);
    }

    public final int size() {
        int i10;
        synchronized (this.monitor) {
            i10 = this.size;
        }
        return i10;
    }

    protected int sizeOf(K k10, V v10) {
        return 1;
    }

    @NotNull
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.monitor) {
            linkedHashMap = new LinkedHashMap();
            for (K k10 : this.keySet) {
                V v10 = this.map.get(k10);
                t.f(v10);
                linkedHashMap.put(k10, v10);
            }
        }
        return linkedHashMap;
    }

    public final <R> R synchronizedValue$ui_text_release(@NotNull a<? extends R> block) {
        R rInvoke;
        t.i(block, "block");
        synchronized (this.monitor) {
            try {
                rInvoke = block.invoke();
                r.b(1);
            } catch (Throwable th) {
                r.b(1);
                r.a(1);
                throw th;
            }
        }
        r.a(1);
        return rInvoke;
    }

    @NotNull
    public String toString() {
        String str;
        synchronized (this.monitor) {
            int i10 = this.hitCount;
            int i11 = this.missCount + i10;
            str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i11 != 0 ? (i10 * 100) / i11 : 0) + "%]";
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void trimToSize(int r8) {
        /*
            r7 = this;
        L0:
            androidx.compose.ui.text.platform.SynchronizedObject r0 = r7.monitor
            monitor-enter(r0)
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L91
            if (r1 < 0) goto L89
            java.util.HashMap<K, V> r1 = r7.map     // Catch: java.lang.Throwable -> L91
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L17
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L91
            if (r1 != 0) goto L89
        L17:
            java.util.HashMap<K, V> r1 = r7.map     // Catch: java.lang.Throwable -> L91
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L91
            java.util.LinkedHashSet<K> r2 = r7.keySet     // Catch: java.lang.Throwable -> L91
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L91
            if (r1 != r2) goto L89
            int r1 = r7.size()     // Catch: java.lang.Throwable -> L91
            r2 = 1
            r3 = 0
            if (r1 <= r8) goto L74
            java.util.HashMap<K, V> r1 = r7.map     // Catch: java.lang.Throwable -> L91
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L91
            if (r1 != 0) goto L74
            java.util.LinkedHashSet<K> r1 = r7.keySet     // Catch: java.lang.Throwable -> L91
            java.lang.Object r1 = kotlin.collections.t.h0(r1)     // Catch: java.lang.Throwable -> L91
            java.util.HashMap<K, V> r4 = r7.map     // Catch: java.lang.Throwable -> L91
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L91
            if (r4 == 0) goto L6c
            java.util.HashMap<K, V> r5 = r7.map     // Catch: java.lang.Throwable -> L91
            java.util.Map r5 = kotlin.jvm.internal.t0.d(r5)     // Catch: java.lang.Throwable -> L91
            r5.remove(r1)     // Catch: java.lang.Throwable -> L91
            java.util.LinkedHashSet<K> r5 = r7.keySet     // Catch: java.lang.Throwable -> L91
            java.util.Collection r5 = kotlin.jvm.internal.t0.a(r5)     // Catch: java.lang.Throwable -> L91
            r5.remove(r1)     // Catch: java.lang.Throwable -> L91
            int r5 = r7.size()     // Catch: java.lang.Throwable -> L91
            kotlin.jvm.internal.t.f(r1)     // Catch: java.lang.Throwable -> L91
            kotlin.jvm.internal.t.f(r4)     // Catch: java.lang.Throwable -> L91
            int r6 = r7.safeSizeOf(r1, r4)     // Catch: java.lang.Throwable -> L91
            int r5 = r5 - r6
            r7.size = r5     // Catch: java.lang.Throwable -> L91
            int r5 = r7.evictionCount     // Catch: java.lang.Throwable -> L91
            int r5 = r5 + r2
            r7.evictionCount = r5     // Catch: java.lang.Throwable -> L91
            goto L76
        L6c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L91
            java.lang.String r1 = "inconsistent state"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L91
            throw r8     // Catch: java.lang.Throwable -> L91
        L74:
            r1 = r3
            r4 = r1
        L76:
            v8.k0 r5 = v8.k0.f35197a     // Catch: java.lang.Throwable -> L91
            monitor-exit(r0)
            if (r1 != 0) goto L7e
            if (r4 != 0) goto L7e
            return
        L7e:
            kotlin.jvm.internal.t.f(r1)
            kotlin.jvm.internal.t.f(r4)
            r7.entryRemoved(r2, r1, r4, r3)
            goto L0
        L89:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L91
            java.lang.String r1 = "map/keySet size inconsistency"
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L91
            throw r8     // Catch: java.lang.Throwable -> L91
        L91:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.caches.LruCache.trimToSize(int):void");
    }

    protected void entryRemoved(boolean z10, K k10, V v10, @Nullable V v11) {
    }
}
