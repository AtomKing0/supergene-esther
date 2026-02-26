package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzake implements zzadp {
    private final zzadp zza;
    private final zzajy zzb;

    @Nullable
    private zzaka zzg;
    private zzaf zzh;
    private int zzd = 0;
    private int zze = 0;
    private byte[] zzf = zzet.zzf;
    private final zzek zzc = new zzek();

    public zzake(zzadp zzadpVar, zzajy zzajyVar) {
        this.zza = zzadpVar;
        this.zzb = zzajyVar;
    }

    private final void zzc(int i10) {
        int length = this.zzf.length;
        int i11 = this.zze;
        if (length - i11 >= i10) {
            return;
        }
        int i12 = i11 - this.zzd;
        int iMax = Math.max(i12 + i12, i10 + i12);
        byte[] bArr = this.zzf;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.zzd, bArr2, 0, i12);
        this.zzd = 0;
        this.zze = i12;
        this.zzf = bArr2;
    }

    final /* synthetic */ void zza(long j10, int i10, zzajs zzajsVar) {
        zzdi.zzb(this.zzh);
        zzfxr zzfxrVar = zzajsVar.zza;
        long j11 = zzajsVar.zzc;
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(zzfxrVar.size());
        Iterator<E> it = zzfxrVar.iterator();
        while (it.hasNext()) {
            arrayList.add(((zzdb) it.next()).zza());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayList);
        bundle.putLong("d", j11);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        zzek zzekVar = this.zzc;
        int length = bArrMarshall.length;
        zzekVar.zzI(bArrMarshall, length);
        this.zza.zzq(this.zzc, length);
        long j12 = zzajsVar.zzb;
        if (j12 == C.TIME_UNSET) {
            zzdi.zzf(this.zzh.zzq == Long.MAX_VALUE);
        } else {
            long j13 = this.zzh.zzq;
            j10 = j13 == Long.MAX_VALUE ? j10 + j12 : j12 + j13;
        }
        this.zza.zzs(j10, i10, length, 0, null);
    }

    public final void zzb() {
        zzaka zzakaVar = this.zzg;
        if (zzakaVar != null) {
            zzakaVar.zzb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ int zzf(zzp zzpVar, int i10, boolean z10) {
        return zzadn.zza(this, zzpVar, i10, z10);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final int zzg(zzp zzpVar, int i10, boolean z10, int i11) throws IOException {
        if (this.zzg == null) {
            return this.zza.zzg(zzpVar, i10, z10, 0);
        }
        zzc(i10);
        int iZza = zzpVar.zza(this.zzf, this.zze, i10);
        if (iZza != -1) {
            this.zze += iZza;
            return iZza;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzl(zzaf zzafVar) {
        String str = zzafVar.zzm;
        str.getClass();
        zzdi.zzd(zzbn.zzb(str) == 3);
        if (!zzafVar.equals(this.zzh)) {
            this.zzh = zzafVar;
            this.zzg = this.zzb.zzc(zzafVar) ? this.zzb.zzb(zzafVar) : null;
        }
        if (this.zzg == null) {
            this.zza.zzl(zzafVar);
            return;
        }
        zzadp zzadpVar = this.zza;
        zzad zzadVarZzb = zzafVar.zzb();
        zzadVarZzb.zzX(MimeTypes.APPLICATION_MEDIA3_CUES);
        zzadVarZzb.zzz(zzafVar.zzm);
        zzadVarZzb.zzab(Long.MAX_VALUE);
        zzadVarZzb.zzD(this.zzb.zza(zzafVar));
        zzadpVar.zzl(zzadVarZzb.zzad());
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final /* synthetic */ void zzq(zzek zzekVar, int i10) {
        zzadn.zzb(this, zzekVar, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzr(zzek zzekVar, int i10, int i11) {
        if (this.zzg == null) {
            this.zza.zzr(zzekVar, i10, i11);
            return;
        }
        zzc(i10);
        zzekVar.zzG(this.zzf, this.zze, i10);
        this.zze += i10;
    }

    @Override // com.google.android.gms.internal.ads.zzadp
    public final void zzs(final long j10, final int i10, int i11, int i12, @Nullable zzado zzadoVar) {
        if (this.zzg == null) {
            this.zza.zzs(j10, i10, i11, i12, zzadoVar);
            return;
        }
        zzdi.zze(zzadoVar == null, "DRM on subtitles is not supported");
        int i13 = (this.zze - i12) - i11;
        this.zzg.zza(this.zzf, i13, i11, zzajz.zza(), new zzdn() { // from class: com.google.android.gms.internal.ads.zzakd
            @Override // com.google.android.gms.internal.ads.zzdn
            public final void zza(Object obj) {
                this.zza.zza(j10, i10, (zzajs) obj);
            }
        });
        int i14 = i13 + i11;
        this.zzd = i14;
        if (i14 == this.zze) {
            this.zzd = 0;
            this.zze = 0;
        }
    }
}
