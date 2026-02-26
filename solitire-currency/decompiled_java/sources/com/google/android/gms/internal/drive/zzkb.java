package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzkb<FieldDescriptorType extends zzkd<FieldDescriptorType>> {
    private static final zzkb zzov = new zzkb(true);
    private boolean zzot;
    private boolean zzou = false;
    final zzmi<FieldDescriptorType, Object> zzos = zzmi.zzav(16);

    private zzkb() {
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzos.get(fielddescriptortype);
        return obj instanceof zzkt ? zzkt.zzdp() : obj;
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzcr() == zznr.MESSAGE) {
            if (key.zzcs()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzlq) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (!(value instanceof zzlq)) {
                    if (value instanceof zzkt) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((zzlq) value).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzkt) {
            value = zzkt.zzdp();
        }
        if (key.zzcs()) {
            Object objZza = zza(key);
            if (objZza == null) {
                objZza = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) objZza).add(zze(it.next()));
            }
            this.zzos.put(key, objZza);
            return;
        }
        if (key.zzcr() != zznr.MESSAGE) {
            this.zzos.put(key, zze(value));
            return;
        }
        Object objZza2 = zza(key);
        if (objZza2 == null) {
            this.zzos.put(key, zze(value));
        } else {
            this.zzos.put(key, objZza2 instanceof zzlx ? key.zza((zzlx) objZza2, (zzlx) value) : key.zza(((zzlq) objZza2).zzcy(), (zzlq) value).zzdf());
        }
    }

    public static <T extends zzkd<T>> zzkb<T> zzcn() {
        return zzov;
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        return (key.zzcr() != zznr.MESSAGE || key.zzcs() || key.zzct()) ? zzb((zzkd<?>) key, value) : value instanceof zzkt ? zzjr.zzb(entry.getKey().zzcp(), (zzkt) value) : zzjr.zzb(entry.getKey().zzcp(), (zzlq) value);
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzlx) {
            return ((zzlx) obj).zzef();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzkb zzkbVar = new zzkb();
        for (int i10 = 0; i10 < this.zzos.zzer(); i10++) {
            Map.Entry<K, Object> entryZzaw = this.zzos.zzaw(i10);
            zzkbVar.zza((zzkd) entryZzaw.getKey(), entryZzaw.getValue());
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zzkbVar.zza((zzkd) entry.getKey(), entry.getValue());
        }
        zzkbVar.zzou = this.zzou;
        return zzkbVar;
    }

    final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zzou ? new zzkw(this.zzos.zzet().iterator()) : this.zzos.zzet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkb) {
            return this.zzos.equals(((zzkb) obj).zzos);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzos.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzot;
    }

    public final boolean isInitialized() {
        for (int i10 = 0; i10 < this.zzos.zzer(); i10++) {
            if (!zzb(this.zzos.zzaw(i10))) {
                return false;
            }
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            if (!zzb((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzou ? new zzkw(this.zzos.entrySet().iterator()) : this.zzos.entrySet().iterator();
    }

    public final void zzbp() {
        if (this.zzot) {
            return;
        }
        this.zzos.zzbp();
        this.zzot = true;
    }

    public final int zzco() {
        int iZzd = 0;
        for (int i10 = 0; i10 < this.zzos.zzer(); i10++) {
            iZzd += zzd(this.zzos.zzaw(i10));
        }
        Iterator it = this.zzos.zzes().iterator();
        while (it.hasNext()) {
            iZzd += zzd((Map.Entry) it.next());
        }
        return iZzd;
    }

    private zzkb(boolean z10) {
        zzbp();
    }

    private final void zza(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzcs()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    zza(fielddescriptortype.zzcq(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zza(fielddescriptortype.zzcq(), obj);
        }
        if (obj instanceof zzkt) {
            this.zzou = true;
        }
        this.zzos.put(fielddescriptortype, obj);
    }

    private static int zzb(zznm zznmVar, Object obj) {
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                return zzjr.zzb(((Double) obj).doubleValue());
            case 2:
                return zzjr.zzb(((Float) obj).floatValue());
            case 3:
                return zzjr.zzo(((Long) obj).longValue());
            case 4:
                return zzjr.zzp(((Long) obj).longValue());
            case 5:
                return zzjr.zzac(((Integer) obj).intValue());
            case 6:
                return zzjr.zzr(((Long) obj).longValue());
            case 7:
                return zzjr.zzaf(((Integer) obj).intValue());
            case 8:
                return zzjr.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzjr.zzd((zzlq) obj);
            case 10:
                if (obj instanceof zzkt) {
                    return zzjr.zza((zzkt) obj);
                }
                return zzjr.zzc((zzlq) obj);
            case 11:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzm((String) obj);
            case 12:
                if (obj instanceof zzjc) {
                    return zzjr.zzb((zzjc) obj);
                }
                return zzjr.zzc((byte[]) obj);
            case 13:
                return zzjr.zzad(((Integer) obj).intValue());
            case 14:
                return zzjr.zzag(((Integer) obj).intValue());
            case 15:
                return zzjr.zzs(((Long) obj).longValue());
            case 16:
                return zzjr.zzae(((Integer) obj).intValue());
            case 17:
                return zzjr.zzq(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzkn) {
                    return zzjr.zzah(((zzkn) obj).zzcp());
                }
                return zzjr.zzah(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0011. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void zza(com.google.android.gms.internal.drive.zznm r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.drive.zzkm.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.drive.zzkc.zzow
            com.google.android.gms.internal.drive.zznr r2 = r2.zzfj()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L41;
                case 2: goto L3e;
                case 3: goto L3b;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L32;
                case 7: goto L29;
                case 8: goto L20;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzlq
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkt
            if (r2 == 0) goto L1e
            goto L43
        L1e:
            r0 = r1
            goto L43
        L20:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzkn
            if (r2 == 0) goto L1e
            goto L43
        L29:
            boolean r2 = r3 instanceof com.google.android.gms.internal.drive.zzjc
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L43
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzkb.zza(com.google.android.gms.internal.drive.zznm, java.lang.Object):void");
    }

    public final void zza(zzkb<FieldDescriptorType> zzkbVar) {
        for (int i10 = 0; i10 < zzkbVar.zzos.zzer(); i10++) {
            zzc(zzkbVar.zzos.zzaw(i10));
        }
        Iterator it = zzkbVar.zzos.zzes().iterator();
        while (it.hasNext()) {
            zzc((Map.Entry) it.next());
        }
    }

    static void zza(zzjr zzjrVar, zznm zznmVar, int i10, Object obj) throws IOException {
        if (zznmVar == zznm.zzxd) {
            zzlq zzlqVar = (zzlq) obj;
            zzkm.zzf(zzlqVar);
            zzjrVar.zzb(i10, 3);
            zzlqVar.zzb(zzjrVar);
            zzjrVar.zzb(i10, 4);
        }
        zzjrVar.zzb(i10, zznmVar.zzfk());
        switch (zzkc.zzox[zznmVar.ordinal()]) {
            case 1:
                zzjrVar.zza(((Double) obj).doubleValue());
                break;
            case 2:
                zzjrVar.zza(((Float) obj).floatValue());
                break;
            case 3:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 4:
                zzjrVar.zzl(((Long) obj).longValue());
                break;
            case 5:
                zzjrVar.zzx(((Integer) obj).intValue());
                break;
            case 6:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 7:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 8:
                zzjrVar.zzc(((Boolean) obj).booleanValue());
                break;
            case 9:
                ((zzlq) obj).zzb(zzjrVar);
                break;
            case 10:
                zzjrVar.zzb((zzlq) obj);
                break;
            case 11:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                } else {
                    zzjrVar.zzl((String) obj);
                }
                break;
            case 12:
                if (obj instanceof zzjc) {
                    zzjrVar.zza((zzjc) obj);
                } else {
                    byte[] bArr = (byte[]) obj;
                    zzjrVar.zzd(bArr, 0, bArr.length);
                }
                break;
            case 13:
                zzjrVar.zzy(((Integer) obj).intValue());
                break;
            case 14:
                zzjrVar.zzaa(((Integer) obj).intValue());
                break;
            case 15:
                zzjrVar.zzn(((Long) obj).longValue());
                break;
            case 16:
                zzjrVar.zzz(((Integer) obj).intValue());
                break;
            case 17:
                zzjrVar.zzm(((Long) obj).longValue());
                break;
            case 18:
                if (obj instanceof zzkn) {
                    zzjrVar.zzx(((zzkn) obj).zzcp());
                } else {
                    zzjrVar.zzx(((Integer) obj).intValue());
                }
                break;
        }
    }

    public static int zzb(zzkd<?> zzkdVar, Object obj) {
        zznm zznmVarZzcq = zzkdVar.zzcq();
        int iZzcp = zzkdVar.zzcp();
        if (zzkdVar.zzcs()) {
            int iZza = 0;
            if (zzkdVar.zzct()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    iZza += zzb(zznmVarZzcq, it.next());
                }
                return zzjr.zzab(iZzcp) + iZza + zzjr.zzaj(iZza);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                iZza += zza(zznmVarZzcq, iZzcp, it2.next());
            }
            return iZza;
        }
        return zza(zznmVarZzcq, iZzcp, obj);
    }

    static int zza(zznm zznmVar, int i10, Object obj) {
        int iZzab = zzjr.zzab(i10);
        if (zznmVar == zznm.zzxd) {
            zzkm.zzf((zzlq) obj);
            iZzab <<= 1;
        }
        return iZzab + zzb(zznmVar, obj);
    }
}
