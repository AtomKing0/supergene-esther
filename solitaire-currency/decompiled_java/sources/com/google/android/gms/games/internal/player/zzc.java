package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzc extends DataBufferRef implements zza {
    private final zzd zza;

    public zzc(DataHolder dataHolder, int i10, zzd zzdVar) {
        super(dataHolder, i10);
        this.zza = zzdVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(@Nullable Object obj) {
        return MostRecentGameInfoEntity.zzi(this, obj);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    public final String toString() {
        return MostRecentGameInfoEntity.zzh(this);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        zzb.zza(new MostRecentGameInfoEntity(this), parcel, i10);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final long zza() {
        return getLong(this.zza.zzu);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzb() {
        return parseUri(this.zza.zzx);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzc() {
        return parseUri(this.zza.zzw);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return parseUri(this.zza.zzv);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zze() {
        return getString(this.zza.zzs);
    }

    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzf() {
        return getString(this.zza.zzt);
    }
}
