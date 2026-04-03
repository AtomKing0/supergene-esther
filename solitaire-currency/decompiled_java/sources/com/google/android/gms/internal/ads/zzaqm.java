package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.ironsource.nb;
import com.ironsource.v8;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzaqm extends zzaph {
    private final Object zza;

    @Nullable
    @GuardedBy("mLock")
    private final zzapm zzb;

    public zzaqm(int i10, String str, zzapm zzapmVar, @Nullable zzapl zzaplVar) {
        super(i10, str, zzaplVar);
        this.zza = new Object();
        this.zzb = zzapmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaph
    protected final zzapn zzh(zzapd zzapdVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapdVar.zzb;
            Map map = zzapdVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(nb.K)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                int i10 = 1;
                while (true) {
                    if (i10 >= strArrSplit.length) {
                        break;
                    }
                    String[] strArrSplit2 = strArrSplit[i10].trim().split(v8.i.f15833b, 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals(nb.M)) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                    i10++;
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapdVar.zzb);
        }
        return zzapn.zzb(str, zzaqe.zzb(zzapdVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzaph
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzapm zzapmVar;
        synchronized (this.zza) {
            zzapmVar = this.zzb;
        }
        zzapmVar.zza(str);
    }
}
