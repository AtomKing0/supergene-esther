package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgef {
    private final List zza = new ArrayList();
    private final zzgln zzb = zzgln.zza;
    private boolean zzc = false;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            ((zzged) it.next()).zza = false;
        }
    }

    public final zzgef zza(zzged zzgedVar) {
        if (zzgedVar.zzf != null) {
            throw new IllegalStateException("Entry has already been added to a KeysetHandle.Builder");
        }
        if (zzgedVar.zza) {
            zzd();
        }
        zzgedVar.zzf = this;
        this.zza.add(zzgedVar);
        return this;
    }

    public final zzgej zzb() throws GeneralSecurityException {
        int i10;
        int i11;
        if (this.zzc) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        char c10 = 1;
        this.zzc = true;
        List list = this.zza;
        zzgte zzgteVarZzd = zzgth.zzd();
        ArrayList arrayList = new ArrayList(list.size());
        List list2 = this.zza;
        int i12 = 0;
        int i13 = 0;
        while (i13 < list2.size() - 1) {
            int i14 = i13 + 1;
            if (((zzged) list2.get(i13)).zze == zzgee.zza && ((zzged) list2.get(i14)).zze != zzgee.zza) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
            i13 = i14;
        }
        HashSet hashSet = new HashSet();
        Integer num = null;
        for (zzged zzgedVar : this.zza) {
            zzgea unused = zzgedVar.zzb;
            if (zzgedVar.zze == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            int i15 = 4;
            if (zzgedVar.zze == zzgee.zza) {
                i10 = i12;
                while (true) {
                    if (i10 != 0 && !hashSet.contains(Integer.valueOf(i10))) {
                        break;
                    }
                    SecureRandom secureRandom = new SecureRandom();
                    byte[] bArr = new byte[i15];
                    int i16 = i12;
                    while (i16 == 0) {
                        secureRandom.nextBytes(bArr);
                        i16 = ((bArr[2] & 255) << 8) | ((bArr[i12] & 255) << 24) | ((bArr[c10] & 255) << 16) | (bArr[3] & 255);
                        i12 = 0;
                        i15 = 4;
                    }
                    i10 = i16;
                }
            } else {
                zzgee unused2 = zzgedVar.zze;
                i10 = 0;
            }
            Integer numValueOf = Integer.valueOf(i10);
            if (hashSet.contains(numValueOf)) {
                throw new GeneralSecurityException("Id " + i10 + " is used twice in the keyset");
            }
            hashSet.add(numValueOf);
            zzged.zza(zzgedVar);
            zzgdy zzgdyVarZza = zzgma.zzb().zza(zzgedVar.zzd, c10 != zzgedVar.zzd.zza() ? null : numValueOf);
            zzgeh zzgehVar = new zzgeh(zzgdyVarZza, zzgedVar.zzb, i10, zzgedVar.zza, null);
            zzgea zzgeaVar = zzgedVar.zzb;
            zzgnl zzgnlVar = (zzgnl) zzgmk.zzc().zzd(zzgdyVarZza, zzgnl.class, zzger.zza());
            Integer numZzf = zzgnlVar.zzf();
            if (numZzf != null && numZzf.intValue() != i10) {
                throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
            }
            zzgea zzgeaVar2 = zzgea.zza;
            if (zzgeaVar2.equals(zzgeaVar)) {
                i11 = 3;
            } else if (zzgea.zzb.equals(zzgeaVar)) {
                i11 = 4;
            } else {
                if (!zzgea.zzc.equals(zzgeaVar)) {
                    throw new IllegalStateException("Unknown key status");
                }
                i11 = 5;
            }
            zzgtf zzgtfVarZzd = zzgtg.zzd();
            zzgst zzgstVarZza = zzgsv.zza();
            zzgstVarZza.zzb(zzgnlVar.zzg());
            zzgstVarZza.zzc(zzgnlVar.zze());
            zzgstVarZza.zza(zzgnlVar.zzb());
            zzgtfVarZzd.zza(zzgstVarZza);
            zzgtfVarZzd.zzd(i11);
            zzgtfVarZzd.zzb(i10);
            zzgtfVarZzd.zzc(zzgnlVar.zzc());
            zzgteVarZzd.zza((zzgtg) zzgtfVarZzd.zzbr());
            if (zzgedVar.zza) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                if (zzgedVar.zzb != zzgeaVar2) {
                    throw new GeneralSecurityException("Primary key is not enabled");
                }
                num = numValueOf;
            }
            arrayList.add(zzgehVar);
            c10 = 1;
            i12 = 0;
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        zzgteVarZzd.zzb(num.intValue());
        zzgth zzgthVar = (zzgth) zzgteVarZzd.zzbr();
        zzgej.zzh(zzgthVar);
        return new zzgej(zzgthVar, arrayList, this.zzb, null);
    }
}
