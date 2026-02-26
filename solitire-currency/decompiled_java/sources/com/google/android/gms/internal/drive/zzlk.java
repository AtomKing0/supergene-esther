package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class zzlk<K, V> extends LinkedHashMap<K, V> {
    private static final zzlk zzty;
    private boolean zznh;

    static {
        zzlk zzlkVar = new zzlk();
        zzty = zzlkVar;
        zzlkVar.zznh = false;
    }

    private zzlk() {
        this.zznh = true;
    }

    public static <K, V> zzlk<K, V> zzdw() {
        return zzty;
    }

    private final void zzdy() {
        if (!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzg(Object obj) {
        if (obj instanceof byte[]) {
            return zzkm.hashCode((byte[]) obj);
        }
        if (obj instanceof zzkn) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzdy();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlk.equals(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzg = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            iZzg += zzg(entry.getValue()) ^ zzg(entry.getKey());
        }
        return iZzg;
    }

    public final boolean isMutable() {
        return this.zznh;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k10, V v10) {
        zzdy();
        zzkm.checkNotNull(k10);
        zzkm.checkNotNull(v10);
        return (V) super.put(k10, v10);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzdy();
        for (K k10 : map.keySet()) {
            zzkm.checkNotNull(k10);
            zzkm.checkNotNull(map.get(k10));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzdy();
        return (V) super.remove(obj);
    }

    public final void zza(zzlk<K, V> zzlkVar) {
        zzdy();
        if (zzlkVar.isEmpty()) {
            return;
        }
        putAll(zzlkVar);
    }

    public final void zzbp() {
        this.zznh = false;
    }

    public final zzlk<K, V> zzdx() {
        return isEmpty() ? new zzlk<>() : new zzlk<>(this);
    }

    private zzlk(Map<K, V> map) {
        super(map);
        this.zznh = true;
    }
}
