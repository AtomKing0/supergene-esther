package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.core.app.NotificationCompat;
import androidx.media3.common.PlaybackException;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzpm;
import com.google.android.gms.internal.measurement.zzqv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.ironsource.v8;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import io.sentry.protocol.TransactionInfo;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznt extends zzil {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd;
    private int zze;
    private MeasurementManagerFutures zzf;
    private Boolean zzg;
    private Integer zzh;

    zznt(zzho zzhoVar) {
        super(zzhoVar);
        this.zzh = null;
        this.zzd = new AtomicLong(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0090  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final int zza(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Object r19, android.os.Bundle r20, java.util.List<java.lang.String> r21, boolean r22, boolean r23) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznt.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    static int zzc() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(PlaybackException.CUSTOM_ERROR_CODE_BASE);
    }

    private final int zzk(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private final int zzl(String str) {
        if (!zzc("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private static int zzm(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return ("_lgclid".equals(str) || "_gbraid".equals(str)) ? 100 : 36;
    }

    static MessageDigest zzu() {
        MessageDigest messageDigest;
        for (int i10 = 0; i10 < 2; i10++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    @TargetApi(30)
    @WorkerThread
    private final boolean zzy() {
        Integer num;
        if (this.zzg == null) {
            MeasurementManagerFutures measurementManagerFuturesZzn = zzn();
            boolean z10 = false;
            if (measurementManagerFuturesZzn == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = measurementManagerFuturesZzn.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z10 = true;
                        }
                    } catch (InterruptedException e10) {
                        e = e10;
                        num2 = num;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                    } catch (CancellationException e11) {
                        e = e11;
                        num2 = num;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                    } catch (ExecutionException e12) {
                        e = e12;
                        num2 = num;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                    } catch (TimeoutException e13) {
                        e = e13;
                        num2 = num;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                    }
                }
                this.zzg = Boolean.valueOf(z10);
            } catch (InterruptedException e14) {
                e = e14;
            } catch (CancellationException e15) {
                e = e15;
            } catch (ExecutionException e16) {
                e = e16;
            } catch (TimeoutException e17) {
                e = e17;
            }
            zzj().zzp().zza("Measurement manager api status result", num);
        }
        return this.zzg.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    @WorkerThread
    protected final void zzaa() {
        zzt();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                zzj().zzu().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(jNextLong);
    }

    final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (zza("user property", zziv.zza, str)) {
            return !zza("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    public final int zzg() {
        if (this.zzh == null) {
            this.zzh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / 1000);
        }
        return this.zzh.intValue();
    }

    @WorkerThread
    final long zzh() {
        zzt();
        if (!zzd(this.zzu.zzh().zzad())) {
            return 0L;
        }
        long j10 = Build.VERSION.SDK_INT < 30 ? 4L : SdkExtensions.getExtensionVersion(30) < 4 ? 8L : zzc() < zzbh.zzav.zza(null).intValue() ? 16L : 0L;
        if (!zze("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j10 |= 2;
        }
        if (j10 == 0 && !zzy()) {
            j10 |= 64;
        }
        if (j10 == 0) {
            return 1L;
        }
        return j10;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    final MeasurementManagerFutures zzn() {
        if (this.zzf == null) {
            this.zzf = MeasurementManagerFutures.from(zza());
        }
        return this.zzf;
    }

    @Override // com.google.android.gms.measurement.internal.zzil
    protected final boolean zzo() {
        return true;
    }

    final String zzp() {
        byte[] bArr = new byte[16];
        zzv().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @WorkerThread
    final SecureRandom zzv() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    @WorkerThread
    final boolean zzw() {
        zzt();
        return zzh() == 1;
    }

    public final boolean zzx() {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static boolean zzd(String str) {
        return zze(zzbh.zzba.zza(null), str);
    }

    static boolean zzf(String str) {
        return zze(zzbh.zzbv.zza(null), str);
    }

    public static boolean zzj(String str) {
        for (String str2 : zzb) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    final boolean zze(String str) {
        zzt();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    public final boolean zzi(String str) {
        List<ResolveInfo> listQueryIntentActivities;
        return (TextUtils.isEmpty(str) || (listQueryIntentActivities = zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    static boolean zzg(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    @VisibleForTesting
    private static boolean zzn(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @WorkerThread
    final long zzc(String str) {
        if (zza().getPackageManager() == null) {
            return 0L;
        }
        int i10 = 0;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                i10 = applicationInfo.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().zzn().zza("PackageManager failed to find running app: app_id", str);
        }
        return i10;
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    private static boolean zze(String str, String str2) {
        return str.equals(ProxyConfig.MATCH_ALL_SCHEMES) || Arrays.asList(str.split(",")).contains(str2);
    }

    final Object zzb(String str, Object obj) {
        int iZza;
        if ("_ev".equals(str)) {
            return zza(zze().zzb((String) null, false), obj, true, true, (String) null);
        }
        if (zzg(str)) {
            iZza = zze().zzb((String) null, false);
        } else {
            iZza = zze().zza((String) null, false);
        }
        return zza(iZza, obj, false, true, (String) null);
    }

    public final long zzm() {
        long andIncrement;
        long j10;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long jNextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
                int i10 = this.zze + 1;
                this.zze = i10;
                j10 = jNextLong + ((long) i10);
            }
            return j10;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1L, 1L);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    final boolean zzd(String str, String str2) {
        if (zzqv.zza() && zze().zza(zzbh.zzbu) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzn().equals(str);
    }

    final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzm(str), obj, true, false, (String) null);
        }
        return zza(zzm(str), obj, false, false, (String) null);
    }

    static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    final boolean zzc(String str, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            zzj().zzh().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public static ArrayList<Bundle> zzb(List<zzac> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzac zzacVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzacVar.zza);
            bundle.putString("origin", zzacVar.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, zzacVar.zzd);
            bundle.putString("name", zzacVar.zzc.zza);
            zzin.zza(bundle, Preconditions.checkNotNull(zzacVar.zzc.zza()));
            bundle.putBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, zzacVar.zze);
            String str = zzacVar.zzf;
            if (str != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, str);
            }
            zzbf zzbfVar = zzacVar.zzg;
            if (zzbfVar != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbfVar.zza);
                zzba zzbaVar = zzbfVar.zzb;
                if (zzbaVar != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbaVar.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, zzacVar.zzh);
            zzbf zzbfVar2 = zzacVar.zzi;
            if (zzbfVar2 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbfVar2.zza);
                zzba zzbaVar2 = zzbfVar2.zzb;
                if (zzbaVar2 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbaVar2.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, zzacVar.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, zzacVar.zzj);
            zzbf zzbfVar3 = zzacVar.zzk;
            if (zzbfVar3 != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbfVar3.zza);
                zzba zzbaVar3 = zzbfVar3.zzb;
                if (zzbaVar3 != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbaVar3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private static boolean zzc(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    final int zza(String str, Object obj) {
        boolean zZza;
        if ("_ldl".equals(str)) {
            zZza = zza("user property referrer", str, zzm(str), obj);
        } else {
            zZza = zza("user property", str, zzm(str), obj);
        }
        return zZza ? 0 : 7;
    }

    private static boolean zzb(Bundle bundle, int i10) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i10);
        return true;
    }

    final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            zzj().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    final int zza(String str) {
        if (!zzb(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (zza(NotificationCompat.CATEGORY_EVENT, zzit.zza, zzit.zzb, str)) {
            return !zza(NotificationCompat.CATEGORY_EVENT, 40, str) ? 2 : 0;
        }
        return 13;
    }

    public final int zza(int i10) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), 12451000);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0072  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0065 -> B:18:0x0072). Please report as a decompilation issue!!! */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final long zza(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            r6.zzt()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            java.security.MessageDigest r1 = zzu()
            r2 = -1
            if (r1 != 0) goto L23
            com.google.android.gms.measurement.internal.zzgb r7 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzg()
            java.lang.String r8 = "Could not get MD5 instance"
            r7.zza(r8)
            goto L73
        L23:
            r4 = 0
            if (r0 == 0) goto L72
            boolean r8 = r6.zzb(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            if (r8 != 0) goto L72
            com.google.android.gms.common.wrappers.PackageManagerWrapper r7 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.Context r8 = r6.zza()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            r0 = 64
            android.content.pm.PackageInfo r7 = r7.getPackageInfo(r8, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            android.content.pm.Signature[] r7 = r7.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            if (r7 == 0) goto L56
            int r8 = r7.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            if (r8 <= 0) goto L56
            r8 = 0
            r7 = r7[r8]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            byte[] r7 = r1.digest(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            long r2 = zza(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            goto L73
        L56:
            com.google.android.gms.measurement.internal.zzgb r7 = r6.zzj()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            com.google.android.gms.measurement.internal.zzgd r7 = r7.zzu()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            java.lang.String r8 = "Could not get signatures"
            r7.zza(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L64
            goto L73
        L64:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzgb r8 = r6.zzj()
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzg()
            java.lang.String r0 = "Package name not found"
            r8.zza(r0, r7)
        L72:
            r2 = r4
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznt.zza(android.content.Context, java.lang.String):long");
    }

    @VisibleForTesting
    private final boolean zzb(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance(AndroidStaticDeviceInfoDataSource.CERTIFICATE_TYPE_X509).generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e10) {
            zzj().zzg().zza("Package name not found", e10);
            return true;
        } catch (CertificateException e11) {
            zzj().zzg().zza("Error obtaining certificate", e11);
            return true;
        }
    }

    @VisibleForTesting
    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i10 = 0;
        Preconditions.checkState(bArr.length > 0);
        long j10 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j10 += (((long) bArr[length]) & 255) << i10;
            i10 += 8;
        }
        return j10;
    }

    public static long zza(zzba zzbaVar) {
        long length = 0;
        if (zzbaVar == null) {
            return 0L;
        }
        Iterator<String> it = zzbaVar.iterator();
        while (it.hasNext()) {
            Object objZzc = zzbaVar.zzc(it.next());
            if (objZzc instanceof Parcelable[]) {
                length += (long) ((Parcelable[]) objZzc).length;
            }
        }
        return length;
    }

    static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static long zza(long j10, long j11) {
        return (j10 + (j11 * 60000)) / com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zzno> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzno zznoVar : list) {
            String str = zznoVar.zzd;
            if (str != null) {
                bundle.putString(zznoVar.zza, str);
            } else {
                Long l10 = zznoVar.zzc;
                if (l10 != null) {
                    bundle.putLong(zznoVar.zza, l10.longValue());
                } else {
                    Double d10 = zznoVar.zzf;
                    if (d10 != null) {
                        bundle.putDouble(zznoVar.zza, d10.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    final Bundle zza(Uri uri, boolean z10, boolean z11) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = z11 ? uri.getQueryParameter("gbraid") : null;
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = z10 ? uri.getQueryParameter("sfmc_id") : null;
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && ((!z11 || TextUtils.isEmpty(queryParameter5)) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && (!z10 || TextUtils.isEmpty(queryParameter9)))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString(TransactionInfo.JsonKeys.SOURCE, queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (z11 && !TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("term", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("content", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("aclid", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("cp1", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("anid", queryParameter14);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter15 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("source_platform", queryParameter15);
            }
            String queryParameter16 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("creative_format", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("marketing_tactic", queryParameter17);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (z10 && !TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e10) {
            zzj().zzu().zza("Install referrer url isn't a hierarchical URI", e10);
            return null;
        }
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i10 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i10 < parcelableArr.length) {
                        if (parcelableArr[i10] instanceof Bundle) {
                            parcelableArr[i10] = new Bundle((Bundle) parcelableArr[i10]);
                        }
                        i10++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i10 < list.size()) {
                        Object obj2 = list.get(i10);
                        if (obj2 instanceof Bundle) {
                            list.set(i10, new Bundle((Bundle) obj2));
                        }
                        i10++;
                    }
                }
            }
        }
        return bundle2;
    }

    final Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objZzb = zzb(str2, bundle.get(str2));
                if (objZzb == null) {
                    zzj().zzv().zza("Param value can't be null", zzi().zzb(str2));
                } else {
                    zza(bundle2, str2, objZzb);
                }
            }
        }
        return bundle2;
    }

    final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z10) {
        int iZzl;
        int i10;
        zznt zzntVar = this;
        boolean zZza = zza(str2, zzit.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iZzg = zze().zzg();
        int i11 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                iZzl = !z10 ? zzntVar.zzl(str3) : 0;
                if (iZzl == 0) {
                    iZzl = zzntVar.zzk(str3);
                }
            } else {
                iZzl = 0;
            }
            if (iZzl != 0) {
                zza(bundle2, iZzl, str3, iZzl == 3 ? str3 : null);
                bundle2.remove(str3);
                i10 = iZzg;
            } else {
                i10 = iZzg;
                int iZza = zza(str, str2, str3, bundle.get(str3), bundle2, list, z10, zZza);
                if (iZza == 17) {
                    zza(bundle2, iZza, str3, Boolean.FALSE);
                } else if (iZza != 0 && !"_ev".equals(str3)) {
                    zza(bundle2, iZza, iZza == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (zzh(str3)) {
                    int i12 = i11 + 1;
                    if (i12 > i10) {
                        zzj().zzh().zza("Event can't contain more than " + i10 + " params", zzi().zza(str2), zzi().zza(bundle));
                        zzb(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i11 = i12;
                }
            }
            iZzg = i10;
            zzntVar = this;
        }
        return bundle2;
    }

    final zzbf zza(String str, String str2, Bundle bundle, String str3, long j10, boolean z10, boolean z11) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            Bundle bundleZza = zza(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
            if (z10) {
                bundleZza = zza(bundleZza, str);
            }
            Preconditions.checkNotNull(bundleZza);
            return new zzbf(str2, new zzba(bundleZza), str3, j10);
        }
        zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str2));
        throw new IllegalArgumentException();
    }

    private final Object zza(int i10, Object obj, boolean z10, boolean z11, String str) {
        Bundle bundleZza;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            if (!z11 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (bundleZza = zza((Bundle) parcelable, (String) null)) != null && !bundleZza.isEmpty()) {
                    arrayList.add(bundleZza);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return zza(String.valueOf(obj), i10, z10);
    }

    public static String zza(String str, int i10, boolean z10) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i10) {
            return str;
        }
        if (!z10) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i10)) + "...";
    }

    public final URL zza(long j10, String str, String str2, long j11, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j10), Integer.valueOf(zzg())), str2, str, Long.valueOf(j11));
            if (str.equals(zze().zzo())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat(v8.i.f15835c);
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException | MalformedURLException e10) {
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e10.getMessage());
            return null;
        }
    }

    @WorkerThread
    final void zza(Bundle bundle, long j10) {
        long j11 = bundle.getLong("_et");
        if (j11 != 0) {
            zzj().zzu().zza("Params already contained engagement", Long.valueOf(j11));
        }
        bundle.putLong("_et", j10 + j11);
    }

    private static void zza(Bundle bundle, int i10, String str, Object obj) {
        if (zzb(bundle, i10)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    @WorkerThread
    public static void zza(zzks zzksVar, Bundle bundle, boolean z10) {
        if (bundle == null || zzksVar == null || (bundle.containsKey("_sc") && !z10)) {
            if (bundle != null && zzksVar == null && z10) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = zzksVar.zza;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = zzksVar.zzb;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzksVar.zzc);
    }

    final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzq().zza(bundle, str, bundle2.get(str));
            }
        }
    }

    final void zza(Parcelable[] parcelableArr, int i10, boolean z10) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i11 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zza(str, zzis.zzd) && (i11 = i11 + 1) > i10) {
                    if (z10) {
                        zzj().zzh().zza("Param can't contain more than " + i10 + " item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                        zzb(bundle, 28);
                    } else {
                        zzj().zzh().zza("Param cannot contain item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                        zzb(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    final void zza(zzgf zzgfVar, int i10) {
        int i11 = 0;
        for (String str : new TreeSet(zzgfVar.zzb.keySet())) {
            if (zzh(str) && (i11 = i11 + 1) > i10) {
                zzj().zzh().zza("Event can't contain more than " + i10 + " params", zzi().zza(zzgfVar.zza), zzi().zza(zzgfVar.zzb));
                zzb(zzgfVar.zzb, 5);
                zzgfVar.zzb.remove(str);
            }
        }
    }

    public static void zza(zzns zznsVar, int i10, String str, String str2, int i11) {
        zza(zznsVar, (String) null, i10, str, str2, i11);
    }

    static void zza(zzns zznsVar, String str, int i10, String str2, String str3, int i11) {
        Bundle bundle = new Bundle();
        zzb(bundle, i10);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i10 == 6 || i10 == 7 || i10 == 2) {
            bundle.putLong("_el", i11);
        }
        zznsVar.zza(str, "_err", bundle);
    }

    final void zza(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzj().zzv().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, boolean z10) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, z10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning boolean value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, arrayList);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning bundle list to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, Bundle bundle) {
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning bundle value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, bArr);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning byte array to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, i10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning int value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, long j10) {
        Bundle bundle = new Bundle();
        bundle.putLong(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, j10);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning long value to wrapper", e10);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdi zzdiVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ, str);
        try {
            zzdiVar.zza(bundle);
        } catch (RemoteException e10) {
            this.zzu.zzj().zzu().zza("Error returning string value to wrapper", e10);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z10) {
        int iZzl;
        String str4;
        int iZza;
        if (bundle == null) {
            return;
        }
        int iZzc = zze().zzc();
        int i10 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                iZzl = !z10 ? zzl(str5) : 0;
                if (iZzl == 0) {
                    iZzl = zzk(str5);
                }
            } else {
                iZzl = 0;
            }
            if (iZzl != 0) {
                zza(bundle, iZzl, str5, iZzl == 3 ? str5 : null);
                bundle.remove(str5);
            } else {
                if (zza(bundle.get(str5))) {
                    zzj().zzv().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    iZza = 22;
                    str4 = str5;
                } else {
                    str4 = str5;
                    iZza = zza(str, str2, str5, bundle.get(str5), bundle, list, z10, false);
                }
                if (iZza != 0 && !"_ev".equals(str4)) {
                    zza(bundle, iZza, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (zzh(str4) && !zza(str4, zzis.zzd)) {
                    int i11 = i10 + 1;
                    if (!zza(231100000, true)) {
                        zzj().zzh().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str2), zzi().zza(bundle));
                        zzb(bundle, 23);
                        bundle.remove(str4);
                    } else if (i11 > iZzc) {
                        if (zzpm.zza() && zze().zza(zzbh.zzcd)) {
                            zzj().zzh().zza("Item can't contain more than " + iZzc + " item-scoped custom params", zzi().zza(str2), zzi().zza(bundle));
                            zzb(bundle, 28);
                            bundle.remove(str4);
                        } else {
                            zzj().zzh().zza("Item cannot contain custom parameters", zzi().zza(str2), zzi().zza(bundle));
                            zzb(bundle, 23);
                            bundle.remove(str4);
                        }
                    }
                    i10 = i11;
                }
            }
        }
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    final boolean zza(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzn(str)) {
                return true;
            }
            if (this.zzu.zzae()) {
                zzj().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgb.zza(str));
            }
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (zzn(str2)) {
                return true;
            }
            zzj().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzgb.zza(str2));
            return false;
        }
        if (this.zzu.zzae()) {
            zzj().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    final boolean zza(String str, int i10, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i10) {
            return true;
        }
        zzj().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i10), str2);
        return false;
    }

    final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    final boolean zza(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z10;
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        int length = strArr3.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = false;
                break;
            }
            if (str2.startsWith(strArr3[i10])) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            zzj().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        }
        if (strArr == null || !zza(str2, strArr) || (strArr2 != null && zza(str2, strArr2))) {
            return true;
        }
        zzj().zzh().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    final boolean zza(String str, String str2, int i10, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i10) {
                zzj().zzv().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    static boolean zza(Bundle bundle, int i10) {
        int i11 = 0;
        if (bundle.size() <= i10) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i11++;
            if (i11 > i10) {
                bundle.remove(str);
            }
        }
        return true;
    }

    static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean zza(int i10, boolean z10) {
        Boolean boolZzab = this.zzu.zzr().zzab();
        if (zzg() < i10 / 1000) {
            return (boolZzab == null || boolZzab.booleanValue()) ? false : true;
        }
        return true;
    }

    static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    static boolean zza(Context context, boolean z10) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    @SuppressLint({"ApplySharedPref"})
    final boolean zza(String str, double d10) {
        try {
            SharedPreferences.Editor editorEdit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString(NotificationSchedulerKeys.KEY_DEEPLINK, str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d10));
            return editorEdit.commit();
        } catch (RuntimeException e10) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e10);
            return false;
        }
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }
}
