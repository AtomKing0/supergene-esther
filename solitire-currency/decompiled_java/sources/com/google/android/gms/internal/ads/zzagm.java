package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.services.UnityAdsConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzagm extends zzagd {
    public static final Parcelable.Creator<zzagm> CREATOR = new zzagl();

    @Nullable
    public final String zza;
    public final zzfxr zzb;

    /* JADX WARN: Multi-variable type inference failed */
    public zzagm(String str, @Nullable String str2, List list) {
        super(str);
        zzdi.zzd(!list.isEmpty());
        this.zza = str2;
        zzfxr zzfxrVarZzk = zzfxr.zzk(list);
        this.zzb = zzfxrVarZzk;
    }

    private static List zzb(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
            } else if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagm.class == obj.getClass()) {
            zzagm zzagmVar = (zzagm) obj;
            if (zzet.zzG(this.zzf, zzagmVar.zzf) && zzet.zzG(this.zza, zzagmVar.zza) && this.zzb.equals(zzagmVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zzf.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str = this.zza;
        return (((iHashCode * 31) + (str != null ? str.hashCode() : 0)) * 31) + this.zzb.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzagd
    public final String toString() {
        return this.zzf + ": description=" + this.zza + ": values=" + String.valueOf(this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeStringArray((String[]) this.zzb.toArray(new String[0]));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzagd, com.google.android.gms.internal.ads.zzbj
    public final void zza(zzbf zzbfVar) {
        switch (this.zzf) {
            case "TT2":
            case "TIT2":
                zzbfVar.zzq((CharSequence) this.zzb.get(0));
                break;
            case "TP1":
            case "TPE1":
                zzbfVar.zze((CharSequence) this.zzb.get(0));
                break;
            case "TP2":
            case "TPE2":
                zzbfVar.zzc((CharSequence) this.zzb.get(0));
                break;
            case "TAL":
            case "TALB":
                zzbfVar.zzd((CharSequence) this.zzb.get(0));
                break;
            case "TRK":
            case "TRCK":
                String str = (String) this.zzb.get(0);
                int i10 = zzet.zza;
                String[] strArrSplit = str.split(UnityAdsConstants.DefaultUrls.AD_ASSET_PATH, -1);
                try {
                    int i11 = Integer.parseInt(strArrSplit[0]);
                    Integer numValueOf = strArrSplit.length > 1 ? Integer.valueOf(Integer.parseInt(strArrSplit[1])) : null;
                    zzbfVar.zzs(Integer.valueOf(i11));
                    zzbfVar.zzr(numValueOf);
                    break;
                } catch (NumberFormatException unused) {
                    return;
                }
                break;
            case "TYE":
            case "TYER":
                try {
                    zzbfVar.zzl(Integer.valueOf(Integer.parseInt((String) this.zzb.get(0))));
                    break;
                } catch (NumberFormatException unused2) {
                    return;
                }
                break;
            case "TDA":
            case "TDAT":
                try {
                    String str2 = (String) this.zzb.get(0);
                    int i12 = Integer.parseInt(str2.substring(2, 4));
                    int i13 = Integer.parseInt(str2.substring(0, 2));
                    zzbfVar.zzk(Integer.valueOf(i12));
                    zzbfVar.zzj(Integer.valueOf(i13));
                    break;
                } catch (NumberFormatException | StringIndexOutOfBoundsException unused3) {
                    return;
                }
                break;
            case "TDRC":
                List listZzb = zzb((String) this.zzb.get(0));
                int size = listZzb.size();
                if (size != 1) {
                    if (size != 2) {
                        if (size == 3) {
                            zzbfVar.zzj((Integer) listZzb.get(2));
                        }
                    }
                    zzbfVar.zzk((Integer) listZzb.get(1));
                }
                zzbfVar.zzl((Integer) listZzb.get(0));
                break;
            case "TDRL":
                List listZzb2 = zzb((String) this.zzb.get(0));
                int size2 = listZzb2.size();
                if (size2 != 1) {
                    if (size2 != 2) {
                        if (size2 == 3) {
                            zzbfVar.zzm((Integer) listZzb2.get(2));
                        }
                    }
                    zzbfVar.zzn((Integer) listZzb2.get(1));
                }
                zzbfVar.zzo((Integer) listZzb2.get(0));
                break;
            case "TCM":
            case "TCOM":
                zzbfVar.zzf((CharSequence) this.zzb.get(0));
                break;
            case "TP3":
            case "TPE3":
                zzbfVar.zzg((CharSequence) this.zzb.get(0));
                break;
            case "TXT":
            case "TEXT":
                zzbfVar.zzt((CharSequence) this.zzb.get(0));
                break;
            case "TCON":
                Integer numZzf = zzgap.zzf((String) this.zzb.get(0), 10);
                if (numZzf == null) {
                    zzbfVar.zzi((CharSequence) this.zzb.get(0));
                    break;
                } else {
                    String strZza = zzage.zza(numZzf.intValue());
                    if (strZza != null) {
                        zzbfVar.zzi(strZza);
                    }
                    break;
                }
                break;
        }
    }
}
