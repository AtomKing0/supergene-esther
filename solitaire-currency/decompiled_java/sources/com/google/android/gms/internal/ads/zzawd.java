package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApkChecksum;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.ByteArrayInputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawd extends zzaxd {
    private static final zzaxe zzh = new zzaxe();
    private final Context zzi;

    public zzawd(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11, Context context, zzarh zzarhVar) {
        super(zzavpVar, "iz9pI8M74OdFMOjBXhk6CVKK/c29GtinDT3TfbuphLdYOSnoV+Rg8WuW9whaa7rD", "AMztxBQmasdCMrU1nlH2RhtlfSPsjcYFxTHFmKvCDYM=", zzaroVar, i10, 27);
        this.zzi = context;
    }

    private final String zzc() {
        try {
            if (this.zza.zzl() != null) {
                this.zza.zzl().get();
            }
            zzasj zzasjVarZzc = this.zza.zzc();
            if (zzasjVarZzc == null || !zzasjVarZzc.zzaj()) {
                return null;
            }
            return zzasjVarZzc.zzh();
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        int i10;
        zzata zzataVar;
        AtomicReference atomicReferenceZza = zzh.zza(this.zzi.getPackageName());
        synchronized (atomicReferenceZza) {
            zzata zzataVar2 = (zzata) atomicReferenceZza.get();
            if (zzataVar2 == null || zzavs.zzd(zzataVar2.zza) || zzataVar2.zza.equals(ExifInterface.LONGITUDE_EAST) || zzataVar2.zza.equals("0000000000000000000000000000000000000000000000000000000000000000")) {
                if (zzavs.zzd(null)) {
                    (!zzavs.zzd(null) ? Boolean.FALSE : Boolean.FALSE).booleanValue();
                    i10 = 3;
                } else {
                    i10 = 5;
                }
                Boolean boolValueOf = Boolean.valueOf(i10 == 3);
                Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzch);
                String strZzb = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcg)).booleanValue() ? zzb() : null;
                if (bool.booleanValue() && this.zza.zzp() && zzavs.zzd(strZzb)) {
                    strZzb = zzc();
                }
                zzata zzataVar3 = new zzata((String) this.zze.invoke(null, this.zzi, boolValueOf, strZzb));
                if (zzavs.zzd(zzataVar3.zza) || zzataVar3.zza.equals(ExifInterface.LONGITUDE_EAST)) {
                    int i11 = i10 - 1;
                    if (i11 == 3) {
                        String strZzc = zzc();
                        if (!zzavs.zzd(strZzc)) {
                            zzataVar3.zza = strZzc;
                        }
                    } else if (i11 == 4) {
                        throw null;
                    }
                }
                atomicReferenceZza.set(zzataVar3);
            }
            zzataVar = (zzata) atomicReferenceZza.get();
        }
        synchronized (this.zzd) {
            if (zzataVar != null) {
                this.zzd.zzx(zzataVar.zza);
                this.zzd.zzX(zzataVar.zzb);
                this.zzd.zzZ(zzataVar.zzc);
                this.zzd.zzi(zzataVar.zzd);
                this.zzd.zzw(zzataVar.zze);
            }
        }
    }

    protected final String zzb() {
        try {
            CertificateFactory certificateFactory = CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509);
            byte[] bArrZzf = zzavs.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzci));
            ArrayList arrayList = new ArrayList();
            arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(bArrZzf)));
            if (!Build.TYPE.equals("user")) {
                arrayList.add(certificateFactory.generateCertificate(new ByteArrayInputStream(zzavs.zzf((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcj)))));
            }
            Context context = this.zzi;
            String packageName = context.getPackageName();
            this.zza.zzk();
            if (Build.VERSION.SDK_INT <= 30 && !Build.VERSION.CODENAME.equals(ExifInterface.LATITUDE_SOUTH)) {
                return null;
            }
            final zzgdc zzgdcVarZze = zzgdc.zze();
            context.getPackageManager().requestChecksums(packageName, false, 8, arrayList, new PackageManager.OnChecksumsReadyListener() { // from class: com.google.android.gms.internal.ads.zzaxf
                @Override // android.content.pm.PackageManager.OnChecksumsReadyListener
                public final void onChecksumsReady(List list) {
                    zzgdc zzgdcVar = zzgdcVarZze;
                    if (list == null) {
                        zzgdcVar.zzc(null);
                        return;
                    }
                    try {
                        int size = list.size();
                        for (int i10 = 0; i10 < size; i10++) {
                            ApkChecksum apkChecksum = (ApkChecksum) list.get(i10);
                            if (apkChecksum.getType() == 8) {
                                zzgdcVar.zzc(zzavs.zzb(apkChecksum.getValue()));
                                return;
                            }
                        }
                        zzgdcVar.zzc(null);
                    } catch (Throwable unused) {
                        zzgdcVar.zzc(null);
                    }
                }
            });
            return (String) zzgdcVarZze.get();
        } catch (PackageManager.NameNotFoundException | InterruptedException | NoClassDefFoundError | CertificateEncodingException | CertificateException | ExecutionException unused) {
            return null;
        }
    }
}
