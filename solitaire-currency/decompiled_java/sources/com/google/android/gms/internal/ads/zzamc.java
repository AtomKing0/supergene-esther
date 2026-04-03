package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzamc implements zzanr {
    private final List zza;

    public zzamc(int i10, List list) {
        this.zza = list;
    }

    private final zzani zzb(zzanq zzanqVar) {
        return new zzani(zzd(zzanqVar));
    }

    private final zzanv zzc(zzanq zzanqVar) {
        return new zzanv(zzd(zzanqVar));
    }

    private final List zzd(zzanq zzanqVar) {
        String str;
        int i10;
        List listSingletonList;
        zzek zzekVar = new zzek(zzanqVar.zze);
        List arrayList = this.zza;
        while (zzekVar.zzb() > 0) {
            int iZzm = zzekVar.zzm();
            int iZzd = zzekVar.zzd() + zzekVar.zzm();
            if (iZzm == 134) {
                arrayList = new ArrayList();
                int iZzm2 = zzekVar.zzm() & 31;
                for (int i11 = 0; i11 < iZzm2; i11++) {
                    String strZzA = zzekVar.zzA(3, zzfuj.zzc);
                    int iZzm3 = zzekVar.zzm();
                    boolean z10 = (iZzm3 & 128) != 0;
                    if (z10) {
                        i10 = iZzm3 & 63;
                        str = MimeTypes.APPLICATION_CEA708;
                    } else {
                        str = MimeTypes.APPLICATION_CEA608;
                        i10 = 1;
                    }
                    byte bZzm = (byte) zzekVar.zzm();
                    zzekVar.zzL(1);
                    if (z10) {
                        int i12 = bZzm & 64;
                        int i13 = zzdk.zza;
                        listSingletonList = Collections.singletonList(i12 != 0 ? new byte[]{1} : new byte[]{0});
                    } else {
                        listSingletonList = null;
                    }
                    zzad zzadVar = new zzad();
                    zzadVar.zzX(str);
                    zzadVar.zzO(strZzA);
                    zzadVar.zzw(i10);
                    zzadVar.zzL(listSingletonList);
                    arrayList.add(zzadVar.zzad());
                }
            }
            zzekVar.zzK(iZzd);
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanr
    @Nullable
    public final zzant zza(int i10, zzanq zzanqVar) {
        if (i10 != 2) {
            if (i10 == 3 || i10 == 4) {
                return new zzamz(new zzamr(zzanqVar.zzb, zzanqVar.zza()));
            }
            if (i10 == 21) {
                return new zzamz(new zzamp());
            }
            if (i10 == 27) {
                return new zzamz(new zzamm(zzb(zzanqVar), false, false));
            }
            if (i10 == 36) {
                return new zzamz(new zzamo(zzb(zzanqVar)));
            }
            if (i10 == 45) {
                return new zzamz(new zzams());
            }
            if (i10 == 89) {
                return new zzamz(new zzame(zzanqVar.zzd));
            }
            if (i10 == 172) {
                return new zzamz(new zzalz(zzanqVar.zzb, zzanqVar.zza()));
            }
            if (i10 == 257) {
                return new zzanh(new zzamy(MimeTypes.APPLICATION_AIT));
            }
            if (i10 != 128) {
                if (i10 != 129) {
                    if (i10 != 138) {
                        if (i10 == 139) {
                            return new zzamz(new zzamd(zzanqVar.zzb, zzanqVar.zza(), 5408));
                        }
                        switch (i10) {
                            case 15:
                                return new zzamz(new zzamb(false, zzanqVar.zzb, zzanqVar.zza()));
                            case 16:
                                return new zzamz(new zzamk(zzc(zzanqVar)));
                            case 17:
                                return new zzamz(new zzamq(zzanqVar.zzb, zzanqVar.zza()));
                            default:
                                switch (i10) {
                                    case 134:
                                        return new zzanh(new zzamy(MimeTypes.APPLICATION_SCTE35));
                                    case 135:
                                        break;
                                    case 136:
                                        break;
                                    default:
                                        return null;
                                }
                                break;
                        }
                    }
                    return new zzamz(new zzamd(zzanqVar.zzb, zzanqVar.zza(), 4096));
                }
                return new zzamz(new zzalx(zzanqVar.zzb, zzanqVar.zza()));
            }
        }
        return new zzamz(new zzamh(zzc(zzanqVar)));
    }

    public zzamc() {
        this(0);
    }

    public zzamc(int i10) {
        this.zza = zzfxr.zzm();
    }
}
