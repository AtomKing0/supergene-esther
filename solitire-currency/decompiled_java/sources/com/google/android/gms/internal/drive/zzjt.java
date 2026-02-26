package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class zzjt implements zzns {
    private final zzjr zznx;

    private zzjt(zzjr zzjrVar) {
        zzjr zzjrVar2 = (zzjr) zzkm.zza(zzjrVar, "output");
        this.zznx = zzjrVar2;
        zzjrVar2.zzoh = this;
    }

    public static zzjt zza(zzjr zzjrVar) {
        zzjt zzjtVar = zzjrVar.zzoh;
        return zzjtVar != null ? zzjtVar : new zzjt(zzjrVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzak(int i10) throws IOException {
        this.zznx.zzb(i10, 3);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzal(int i10) throws IOException {
        this.zznx.zzb(i10, 4);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, boolean z10) throws IOException {
        this.zznx.zzb(i10, z10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i10, int i11) throws IOException {
        this.zznx.zzc(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final int zzcd() {
        return zzkk.zze.zzsi;
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzd(int i10, int i11) throws IOException {
        this.zznx.zzd(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zze(int i10, int i11) throws IOException {
        this.zznx.zze(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzf(int i10, int i11) throws IOException {
        this.zznx.zzf(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzg(int i10, List<Double> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zza(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzb = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzb += zzjr.zzb(list.get(i12).doubleValue());
        }
        this.zznx.zzy(iZzb);
        while (i11 < list.size()) {
            this.zznx.zza(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzh(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zzc(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzah = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzah += zzjr.zzah(list.get(i12).intValue());
        }
        this.zznx.zzy(iZzah);
        while (i11 < list.size()) {
            this.zznx.zzx(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzi(int i10, long j10) throws IOException {
        this.zznx.zza(i10, j10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzj(int i10, long j10) throws IOException {
        this.zznx.zzc(i10, j10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzk(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zzf(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzag = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzag += zzjr.zzag(list.get(i12).intValue());
        }
        this.zznx.zzy(iZzag);
        while (i11 < list.size()) {
            this.zznx.zzaa(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzl(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zzc(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzs = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzs += zzjr.zzs(list.get(i12).longValue());
        }
        this.zznx.zzy(iZzs);
        while (i11 < list.size()) {
            this.zznx.zzn(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzm(int i10, int i11) throws IOException {
        this.zznx.zzf(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzn(int i10, int i11) throws IOException {
        this.zznx.zzc(i10, i11);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, long j10) throws IOException {
        this.zznx.zzb(i10, j10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i10, long j10) throws IOException {
        this.zznx.zzc(i10, j10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzd(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zza(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzp = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzp += zzjr.zzp(list.get(i12).longValue());
        }
        this.zznx.zzy(iZzp);
        while (i11 < list.size()) {
            this.zznx.zzl(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zze(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zzc(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzr = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzr += zzjr.zzr(list.get(i12).longValue());
        }
        this.zznx.zzy(iZzr);
        while (i11 < list.size()) {
            this.zznx.zzn(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzf(int i10, List<Float> list, boolean z10) throws IOException {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.zznx.zza(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.zznx.zzb(i10, 2);
        int iZzb = 0;
        for (int i12 = 0; i12 < list.size(); i12++) {
            iZzb += zzjr.zzb(list.get(i12).floatValue());
        }
        this.zznx.zzy(iZzb);
        while (i11 < list.size()) {
            this.zznx.zza(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, float f10) throws IOException {
        this.zznx.zza(i10, f10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, Object obj, zzmf zzmfVar) throws IOException {
        zzjr zzjrVar = this.zznx;
        zzjrVar.zzb(i10, 3);
        zzmfVar.zza((zzlq) obj, zzjrVar.zzoh);
        zzjrVar.zzb(i10, 4);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzc(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzo = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzo += zzjr.zzo(list.get(i12).longValue());
            }
            this.zznx.zzy(iZzo);
            while (i11 < list.size()) {
                this.zznx.zzl(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zza(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzi(int i10, List<Boolean> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzd = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzd += zzjr.zzd(list.get(i12).booleanValue());
            }
            this.zznx.zzy(iZzd);
            while (i11 < list.size()) {
                this.zznx.zzc(list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zzb(i10, list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzj(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzad = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzad += zzjr.zzad(list.get(i12).intValue());
            }
            this.zznx.zzy(iZzad);
            while (i11 < list.size()) {
                this.zznx.zzy(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zzd(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzm(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzae = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzae += zzjr.zzae(list.get(i12).intValue());
            }
            this.zznx.zzy(iZzae);
            while (i11 < list.size()) {
                this.zznx.zzz(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zze(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzn(int i10, List<Long> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzq = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzq += zzjr.zzq(list.get(i12).longValue());
            }
            this.zznx.zzy(iZzq);
            while (i11 < list.size()) {
                this.zznx.zzm(list.get(i11).longValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zzb(i10, list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, double d10) throws IOException {
        this.zznx.zza(i10, d10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, long j10) throws IOException {
        this.zznx.zza(i10, j10);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, String str) throws IOException {
        this.zznx.zza(i10, str);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, zzjc zzjcVar) throws IOException {
        this.zznx.zza(i10, zzjcVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzaf = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzaf += zzjr.zzaf(list.get(i12).intValue());
            }
            this.zznx.zzy(iZzaf);
            while (i11 < list.size()) {
                this.zznx.zzaa(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zzf(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, Object obj, zzmf zzmfVar) throws IOException {
        this.zznx.zza(i10, (zzlq) obj, zzmfVar);
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, Object obj) throws IOException {
        if (obj instanceof zzjc) {
            this.zznx.zzb(i10, (zzjc) obj);
        } else {
            this.zznx.zza(i10, (zzlq) obj);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, List<Integer> list, boolean z10) throws IOException {
        int i11 = 0;
        if (z10) {
            this.zznx.zzb(i10, 2);
            int iZzac = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                iZzac += zzjr.zzac(list.get(i12).intValue());
            }
            this.zznx.zzy(iZzac);
            while (i11 < list.size()) {
                this.zznx.zzx(list.get(i11).intValue());
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zzc(i10, list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, List<zzjc> list) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.zznx.zza(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zzb(int i10, List<?> list, zzmf zzmfVar) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzb(i10, list.get(i11), zzmfVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, List<String> list) throws IOException {
        int i11 = 0;
        if (list instanceof zzkz) {
            zzkz zzkzVar = (zzkz) list;
            while (i11 < list.size()) {
                Object objZzao = zzkzVar.zzao(i11);
                if (objZzao instanceof String) {
                    this.zznx.zza(i10, (String) objZzao);
                } else {
                    this.zznx.zza(i10, (zzjc) objZzao);
                }
                i11++;
            }
            return;
        }
        while (i11 < list.size()) {
            this.zznx.zza(i10, list.get(i11));
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final void zza(int i10, List<?> list, zzmf zzmfVar) throws IOException {
        for (int i11 = 0; i11 < list.size(); i11++) {
            zza(i10, list.get(i11), zzmfVar);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzns
    public final <K, V> void zza(int i10, zzlj<K, V> zzljVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zznx.zzb(i10, 2);
            this.zznx.zzy(zzli.zza(zzljVar, entry.getKey(), entry.getValue()));
            zzli.zza(this.zznx, zzljVar, entry.getKey(), entry.getValue());
        }
    }
}
