package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
class zzhao extends AbstractMap {
    private boolean zzc;
    private volatile zzham zzd;
    private List zza = Collections.emptyList();
    private Map zzb = Collections.emptyMap();
    private Map zze = Collections.emptyMap();

    private zzhao() {
    }

    private final int zzk(Comparable comparable) {
        int size = this.zza.size() - 1;
        int i10 = 0;
        if (size >= 0) {
            int iCompareTo = comparable.compareTo(((zzhai) this.zza.get(size)).zza());
            if (iCompareTo > 0) {
                return -(size + 2);
            }
            if (iCompareTo == 0) {
                return size;
            }
        }
        while (i10 <= size) {
            int i11 = (i10 + size) / 2;
            int iCompareTo2 = comparable.compareTo(((zzhai) this.zza.get(i11)).zza());
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

    /* JADX INFO: Access modifiers changed from: private */
    public final Object zzl(int i10) {
        zzn();
        Object value = ((zzhai) this.zza.remove(i10)).getValue();
        if (!this.zzb.isEmpty()) {
            Iterator it = zzm().entrySet().iterator();
            List list = this.zza;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new zzhai(this, (Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return value;
    }

    private final SortedMap zzm() {
        zzn();
        if (this.zzb.isEmpty() && !(this.zzb instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzb = treeMap;
            this.zze = treeMap.descendingMap();
        }
        return (SortedMap) this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzn() {
        if (this.zzc) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzn();
        if (!this.zza.isEmpty()) {
            this.zza.clear();
        }
        if (this.zzb.isEmpty()) {
            return;
        }
        this.zzb.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zzk(comparable) >= 0 || this.zzb.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.zzd == null) {
            this.zzd = new zzham(this, null);
        }
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhao)) {
            return super.equals(obj);
        }
        zzhao zzhaoVar = (zzhao) obj;
        int size = size();
        if (size != zzhaoVar.size()) {
            return false;
        }
        int iZzb = zzb();
        if (iZzb != zzhaoVar.zzb()) {
            return entrySet().equals(zzhaoVar.entrySet());
        }
        for (int i10 = 0; i10 < iZzb; i10++) {
            if (!zzg(i10).equals(zzhaoVar.zzg(i10))) {
                return false;
            }
        }
        if (iZzb != size) {
            return this.zzb.equals(zzhaoVar.zzb);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        return iZzk >= 0 ? ((zzhai) this.zza.get(iZzk)).getValue() : this.zzb.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int iZzb = zzb();
        int iHashCode = 0;
        for (int i10 = 0; i10 < iZzb; i10++) {
            iHashCode += ((zzhai) this.zza.get(i10)).hashCode();
        }
        return this.zzb.size() > 0 ? iHashCode + this.zzb.hashCode() : iHashCode;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzn();
        Comparable comparable = (Comparable) obj;
        int iZzk = zzk(comparable);
        if (iZzk >= 0) {
            return zzl(iZzk);
        }
        if (this.zzb.isEmpty()) {
            return null;
        }
        return this.zzb.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zza.size() + this.zzb.size();
    }

    public void zza() {
        if (this.zzc) {
            return;
        }
        this.zzb = this.zzb.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zzb);
        this.zze = this.zze.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.zze);
        this.zzc = true;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final Iterable zzc() {
        return this.zzb.isEmpty() ? Collections.emptySet() : this.zzb.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        zzn();
        int iZzk = zzk(comparable);
        if (iZzk >= 0) {
            return ((zzhai) this.zza.get(iZzk)).setValue(obj);
        }
        zzn();
        if (this.zza.isEmpty() && !(this.zza instanceof ArrayList)) {
            this.zza = new ArrayList(16);
        }
        int i10 = -(iZzk + 1);
        if (i10 >= 16) {
            return zzm().put(comparable, obj);
        }
        if (this.zza.size() == 16) {
            zzhai zzhaiVar = (zzhai) this.zza.remove(15);
            zzm().put(zzhaiVar.zza(), zzhaiVar.getValue());
        }
        this.zza.add(i10, new zzhai(this, comparable, obj));
        return null;
    }

    public final Map.Entry zzg(int i10) {
        return (Map.Entry) this.zza.get(i10);
    }

    public final boolean zzj() {
        return this.zzc;
    }

    /* synthetic */ zzhao(zzhan zzhanVar) {
    }
}
