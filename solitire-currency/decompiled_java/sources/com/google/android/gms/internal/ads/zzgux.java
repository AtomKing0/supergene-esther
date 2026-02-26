package com.google.android.gms.internal.ads;

import com.google.android.gms.security.ProviderInstaller;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgux implements zzguy {
    private final zzgvh zza;

    /* synthetic */ zzgux(zzgvh zzgvhVar, zzguw zzguwVar) {
        this.zza = zzgvhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguy
    public final Object zza(String str) throws GeneralSecurityException {
        Iterator it = zzguz.zzb(ProviderInstaller.PROVIDER_NAME, "AndroidOpenSSL", "Conscrypt").iterator();
        Exception exc = null;
        while (it.hasNext()) {
            try {
                return this.zza.zza(str, (Provider) it.next());
            } catch (Exception e10) {
                if (exc == null) {
                    exc = e10;
                }
            }
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
