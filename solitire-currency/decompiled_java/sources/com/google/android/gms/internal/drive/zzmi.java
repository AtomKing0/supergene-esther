package com.google.android.gms.internal.drive;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes3.dex */
class zzmi<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private boolean zzot;
    private final int zzvd;
    private List<zzmp> zzve;
    private Map<K, V> zzvf;
    private volatile zzmr zzvg;
    private Map<K, V> zzvh;
    private volatile zzml zzvi;

    private zzmi(int i10) {
        this.zzvd = i10;
        this.zzve = Collections.emptyList();
        this.zzvf = Collections.emptyMap();
        this.zzvh = Collections.emptyMap();
    }

    static <FieldDescriptorType extends zzkd<FieldDescriptorType>> zzmi<FieldDescriptorType, Object> zzav(int i10) {
        return new zzmj(i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzax(int i10) {
        zzeu();
        V v10 = (V) this.zzve.remove(i10).getValue();
        if (!this.zzvf.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzev().entrySet().iterator();
            this.zzve.add(new zzmp(this, it.next()));
            it.remove();
        }
        return v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzeu() {
        if (this.zzot) {
            throw new UnsupportedOperationException();
        }
    }

    private final SortedMap<K, V> zzev() {
        zzeu();
        if (this.zzvf.isEmpty() && !(this.zzvf instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzvf = treeMap;
            this.zzvh = treeMap.descendingMap();
        }
        return (SortedMap) this.zzvf;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzeu();
        if (!this.zzve.isEmpty()) {
            this.zzve.clear();
        }
        if (this.zzvf.isEmpty()) {
            return;
        }
        this.zzvf.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza(comparable) >= 0 || this.zzvf.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zzvg == null) {
            this.zzvg = new zzmr(this, null);
        }
        return this.zzvg;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmi)) {
            return super.equals(obj);
        }
        zzmi zzmiVar = (zzmi) obj;
        int size = size();
        if (size != zzmiVar.size()) {
            return false;
        }
        int iZzer = zzer();
        if (iZzer != zzmiVar.zzer()) {
            return entrySet().equals(zzmiVar.entrySet());
        }
        for (int i10 = 0; i10 < iZzer; i10++) {
            if (!zzaw(i10).equals(zzmiVar.zzaw(i10))) {
                return false;
            }
        }
        if (iZzer != size) {
            return this.zzvf.equals(zzmiVar.zzvf);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        return iZza >= 0 ? (V) this.zzve.get(iZza).getValue() : this.zzvf.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int iZzer = zzer();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iZzer; i10++) {
            iHashCode += this.zzve.get(i10).hashCode();
        }
        return this.zzvf.size() > 0 ? iHashCode + this.zzvf.hashCode() : iHashCode;
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzeu();
        Comparable comparable = (Comparable) obj;
        int iZza = zza(comparable);
        if (iZza >= 0) {
            return zzax(iZza);
        }
        if (this.zzvf.isEmpty()) {
            return null;
        }
        return this.zzvf.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzve.size() + this.zzvf.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final V put(K k10, V v10) {
        zzeu();
        int iZza = zza(k10);
        if (iZza >= 0) {
            return (V) this.zzve.get(iZza).setValue(v10);
        }
        zzeu();
        if (this.zzve.isEmpty() && !(this.zzve instanceof ArrayList)) {
            this.zzve = new ArrayList(this.zzvd);
        }
        int i10 = -(iZza + 1);
        if (i10 >= this.zzvd) {
            return zzev().put(k10, v10);
        }
        int size = this.zzve.size();
        int i11 = this.zzvd;
        if (size == i11) {
            zzmp zzmpVarRemove = this.zzve.remove(i11 - 1);
            zzev().put((Comparable) zzmpVarRemove.getKey(), zzmpVarRemove.getValue());
        }
        this.zzve.add(i10, new zzmp(this, k10, v10));
        return null;
    }

    public final Map.Entry<K, V> zzaw(int i10) {
        return this.zzve.get(i10);
    }

    public void zzbp() {
        if (this.zzot) {
            return;
        }
        this.zzvf = this.zzvf.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvf);
        this.zzvh = this.zzvh.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzvh);
        this.zzot = true;
    }

    public final int zzer() {
        return this.zzve.size();
    }

    public final Iterable<Map.Entry<K, V>> zzes() {
        return this.zzvf.isEmpty() ? zzmm.zzex() : this.zzvf.entrySet();
    }

    final Set<Map.Entry<K, V>> zzet() {
        if (this.zzvi == null) {
            this.zzvi = new zzml(this, null);
        }
        return this.zzvi;
    }

    /* synthetic */ zzmi(int i10, zzmj zzmjVar) {
        this(i10);
    }

    private final int zza(K k10) {
        int size = this.zzve.size() - 1;
        if (size >= 0) {
            int iCompareTo = k10.compareTo((Comparable) this.zzve.get(size).getKey());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int iCompareTo2 = k10.compareTo((Comparable) this.zzve.get(i11).getKey());
            if (iCompareTo2 < 0) {
                size = i11 - 1;
            } else {
                if (iCompareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }
}
