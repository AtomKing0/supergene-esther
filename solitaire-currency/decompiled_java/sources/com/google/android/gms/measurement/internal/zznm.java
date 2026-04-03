package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzoi;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqk;
import com.google.android.gms.measurement.internal.zziq;
import com.ironsource.ad;
import com.ironsource.v8;
import io.sentry.protocol.App;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznm extends zzmy {
    zznm(zznd zzndVar) {
        super(zzndVar);
    }

    static int zza(zzft.zzj.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i10 = 0; i10 < zzaVar.zzd(); i10++) {
            if (str.equals(zzaVar.zzk(i10).zzg())) {
                return i10;
            }
        }
        return -1;
    }

    private static Bundle zzb(List<zzft.zzg> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzg zzgVar : list) {
            String strZzg = zzgVar.zzg();
            if (zzgVar.zzj()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zza()));
            } else if (zzgVar.zzk()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zzb()));
            } else if (zzgVar.zzn()) {
                bundle.putString(strZzg, zzgVar.zzh());
            } else if (zzgVar.zzl()) {
                bundle.putString(strZzg, String.valueOf(zzgVar.zzd()));
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    protected final boolean zzc() {
        return false;
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

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznb zzo() {
        return super.zzo();
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

    final List<Integer> zzu() {
        Map<String, String> mapZza = zzbh.zza(this.zzf.zza());
        if (mapZza == null || mapZza.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = zzbh.zzap.zza(null).intValue();
        for (Map.Entry<String, String> entry : mapZza.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i10 = Integer.parseInt(entry.getValue());
                    if (i10 != 0) {
                        arrayList.add(Integer.valueOf(i10));
                        if (arrayList.size() >= iIntValue) {
                            zzj().zzu().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e10) {
                    zzj().zzu().zza("Experiment ID NumberFormatException", e10);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static Bundle zzc(List<zzft.zzn> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzn zznVar : list) {
            String strZzg = zznVar.zzg();
            if (zznVar.zzi()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zza()));
            } else if (zznVar.zzj()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zzb()));
            } else if (zznVar.zzm()) {
                bundle.putString(strZzg, zznVar.zzh());
            } else if (zznVar.zzk()) {
                bundle.putString(strZzg, String.valueOf(zznVar.zzc()));
            }
        }
        return bundle;
    }

    final long zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zza(str.getBytes(Charset.forName("UTF-8")));
    }

    @WorkerThread
    final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzq().zzt();
        MessageDigest messageDigestZzu = zznt.zzu();
        if (messageDigestZzu == null) {
            zzj().zzg().zza("Failed to get MD5");
            return 0L;
        }
        return zznt.zza(messageDigestZzu.digest(bArr));
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    static Bundle zza(List<zzft.zzg> list) {
        Bundle bundle = new Bundle();
        for (zzft.zzg zzgVar : list) {
            String strZzg = zzgVar.zzg();
            if (zzgVar.zzj()) {
                bundle.putDouble(strZzg, zzgVar.zza());
            } else if (zzgVar.zzk()) {
                bundle.putFloat(strZzg, zzgVar.zzb());
            } else if (zzgVar.zzn()) {
                bundle.putString(strZzg, zzgVar.zzh());
            } else if (zzgVar.zzl()) {
                bundle.putLong(strZzg, zzgVar.zzd());
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    static Object zzb(zzft.zze zzeVar, String str) {
        zzft.zzg zzgVarZza = zza(zzeVar, str);
        if (zzgVarZza == null) {
            return null;
        }
        if (zzgVarZza.zzn()) {
            return zzgVarZza.zzh();
        }
        if (zzgVarZza.zzl()) {
            return Long.valueOf(zzgVarZza.zzd());
        }
        if (zzgVarZza.zzj()) {
            return Double.valueOf(zzgVarZza.zza());
        }
        if (zzgVarZza.zzc() <= 0) {
            return null;
        }
        List<zzft.zzg> listZzi = zzgVarZza.zzi();
        ArrayList arrayList = new ArrayList();
        for (zzft.zzg zzgVar : listZzi) {
            if (zzgVar != null) {
                Bundle bundle = new Bundle();
                for (zzft.zzg zzgVar2 : zzgVar.zzi()) {
                    if (zzgVar2.zzn()) {
                        bundle.putString(zzgVar2.zzg(), zzgVar2.zzh());
                    } else if (zzgVar2.zzl()) {
                        bundle.putLong(zzgVar2.zzg(), zzgVar2.zzd());
                    } else if (zzgVar2.zzj()) {
                        bundle.putDouble(zzgVar2.zzg(), zzgVar2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    final boolean zzc(String str) {
        if (zzoi.zza() && zze().zza(zzbh.zzcx)) {
            return false;
        }
        Preconditions.checkNotNull(str);
        zzf zzfVarZze = zzh().zze(str);
        return zzfVarZze != null && zzf().zzn() && zzfVarZze.zzao() && zzm().zzk(str);
    }

    final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i10 = gZIPInputStream.read(bArr2);
                if (i10 > 0) {
                    byteArrayOutputStream.write(bArr2, 0, i10);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e10) {
            zzj().zzg().zza("Failed to ungzip content", e10);
            throw e10;
        }
    }

    private final Bundle zza(Map<String, Object> map, boolean z10) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z10) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    arrayList2.add(zza((Map<String, Object>) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    static boolean zzb(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e10) {
            zzj().zzg().zza("Failed to gzip content", e10);
            throw e10;
        }
    }

    final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzj().zzg().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    final zzbf zza(com.google.android.gms.internal.measurement.zzad zzadVar) {
        Object obj;
        Bundle bundleZza = zza(zzadVar.zzc(), true);
        String string = (!bundleZza.containsKey("_o") || (obj = bundleZza.get("_o")) == null) ? App.TYPE : obj.toString();
        String strZzb = zzit.zzb(zzadVar.zzb());
        if (strZzb == null) {
            strZzb = zzadVar.zzb();
        }
        return new zzbf(strZzb, new zzba(bundleZza), string, zzadVar.zza());
    }

    @TargetApi(30)
    final zzmv zza(String str, zzft.zzj.zza zzaVar, zzft.zze.zza zzaVar2, String str2) throws Throwable {
        int iIndexOf;
        if (!zzpy.zza() || !zze().zze(str, zzbh.zzcg)) {
            return null;
        }
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Set setZza = zznp.zza(zze().zzd(str, zzbh.zzbd).split(","));
        Uri.Builder builderZza = zzo().zza(str);
        zza(builderZza, "gmp_app_id", zzaVar.zzx(), (Set<String>) setZza);
        zza(builderZza, "gmp_version", "87000", (Set<String>) setZza);
        String strZzu = zzaVar.zzu();
        zzae zzaeVarZze = zze();
        zzfo<Boolean> zzfoVar = zzbh.zzcj;
        String str3 = "";
        if (zzaeVarZze.zze(str, zzfoVar) && zzm().zzp(str)) {
            strZzu = "";
        }
        zza(builderZza, "app_instance_id", strZzu, (Set<String>) setZza);
        zza(builderZza, "rdid", zzaVar.zzz(), (Set<String>) setZza);
        zza(builderZza, "bundle_id", zzaVar.zzt(), (Set<String>) setZza);
        String strZze = zzaVar2.zze();
        String strZza = zzit.zza(strZze);
        if (!TextUtils.isEmpty(strZza)) {
            strZze = strZza;
        }
        zza(builderZza, "app_event_name", strZze, (Set<String>) setZza);
        zza(builderZza, App.JsonKeys.APP_VERSION, String.valueOf(zzaVar.zzb()), (Set<String>) setZza);
        String strZzy = zzaVar.zzy();
        if (!zze().zze(str, zzfoVar) || !zzm().zzt(str)) {
            str3 = strZzy;
        } else if (zze().zze(str, zzbh.zzbw)) {
            if (!TextUtils.isEmpty(strZzy) && (iIndexOf = strZzy.indexOf(".")) != -1) {
                strZzy = strZzy.substring(0, iIndexOf);
            }
            str3 = strZzy;
        }
        zza(builderZza, "os_version", str3, (Set<String>) setZza);
        zza(builderZza, "timestamp", String.valueOf(zzaVar2.zzc()), (Set<String>) setZza);
        if (zzaVar.zzad()) {
            zza(builderZza, ad.f11260q, "1", (Set<String>) setZza);
        }
        zza(builderZza, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), (Set<String>) setZza);
        zza(builderZza, "trigger_uri_source", "1", (Set<String>) setZza);
        zza(builderZza, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), (Set<String>) setZza);
        zza(builderZza, "request_uuid", str2, (Set<String>) setZza);
        zza(builderZza, zze().zzd(str, zzbh.zzbc).split("\\|"), zzb(zzaVar2.zzf()), (Set<String>) setZza);
        zza(builderZza, zze().zzd(str, zzbh.zzbb).split("\\|"), zzc(zzaVar.zzab()), (Set<String>) setZza);
        if (zze().zza(zzbh.zzco)) {
            zza(builderZza, "dma", zzaVar.zzac() ? "1" : "0", (Set<String>) setZza);
            if (!zzaVar.zzw().isEmpty()) {
                zza(builderZza, "dma_cps", zzaVar.zzw(), (Set<String>) setZza);
            }
        }
        return new zzmv(builderZza.build().toString(), jCurrentTimeMillis, 1);
    }

    @TargetApi(30)
    final zzmv zza(String str, zzft.zzj zzjVar, zzft.zze.zza zzaVar, String str2) throws Throwable {
        int iIndexOf;
        if (!zzpy.zza() || !zze().zze(str, zzbh.zzcg)) {
            return null;
        }
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        Set setZza = zznp.zza(zze().zzd(str, zzbh.zzbd).split(","));
        Uri.Builder builderZza = zzo().zza(str);
        zza(builderZza, "gmp_app_id", zzjVar.zzah(), (Set<String>) setZza);
        zza(builderZza, "gmp_version", "87000", (Set<String>) setZza);
        String strZzy = zzjVar.zzy();
        zzae zzaeVarZze = zze();
        zzfo<Boolean> zzfoVar = zzbh.zzcj;
        String str3 = "";
        if (zzaeVarZze.zze(str, zzfoVar) && zzm().zzp(str)) {
            strZzy = "";
        }
        zza(builderZza, "app_instance_id", strZzy, (Set<String>) setZza);
        zza(builderZza, "rdid", zzjVar.zzal(), (Set<String>) setZza);
        zza(builderZza, "bundle_id", zzjVar.zzx(), (Set<String>) setZza);
        String strZze = zzaVar.zze();
        String strZza = zzit.zza(strZze);
        if (!TextUtils.isEmpty(strZza)) {
            strZze = strZza;
        }
        zza(builderZza, "app_event_name", strZze, (Set<String>) setZza);
        zza(builderZza, App.JsonKeys.APP_VERSION, String.valueOf(zzjVar.zzb()), (Set<String>) setZza);
        String strH_ = zzjVar.h_();
        if (!zze().zze(str, zzfoVar) || !zzm().zzt(str)) {
            str3 = strH_;
        } else if (zze().zze(str, zzbh.zzbw)) {
            if (!TextUtils.isEmpty(strH_) && (iIndexOf = strH_.indexOf(".")) != -1) {
                strH_ = strH_.substring(0, iIndexOf);
            }
            str3 = strH_;
        }
        zza(builderZza, "os_version", str3, (Set<String>) setZza);
        zza(builderZza, "timestamp", String.valueOf(zzaVar.zzc()), (Set<String>) setZza);
        if (zzjVar.zzat()) {
            zza(builderZza, ad.f11260q, "1", (Set<String>) setZza);
        }
        zza(builderZza, "privacy_sandbox_version", String.valueOf(zzjVar.zza()), (Set<String>) setZza);
        zza(builderZza, "trigger_uri_source", "1", (Set<String>) setZza);
        zza(builderZza, "trigger_uri_timestamp", String.valueOf(jCurrentTimeMillis), (Set<String>) setZza);
        zza(builderZza, "request_uuid", str2, (Set<String>) setZza);
        zza(builderZza, zze().zzd(str, zzbh.zzbc).split("\\|"), zzb(zzaVar.zzf()), (Set<String>) setZza);
        zza(builderZza, zze().zzd(str, zzbh.zzbb).split("\\|"), zzc(zzjVar.zzaq()), (Set<String>) setZza);
        if (zze().zza(zzbh.zzco)) {
            zza(builderZza, "dma", zzjVar.zzas() ? "1" : "0", (Set<String>) setZza);
            if (!zzjVar.zzad().isEmpty()) {
                zza(builderZza, "dma_cps", zzjVar.zzad(), (Set<String>) setZza);
            }
        }
        return new zzmv(builderZza.build().toString(), jCurrentTimeMillis, 1);
    }

    final zzft.zze zza(zzay zzayVar) {
        zzft.zze.zza zzaVarZza = zzft.zze.zze().zza(zzayVar.zzd);
        for (String str : zzayVar.zze) {
            zzft.zzg.zza zzaVarZza2 = zzft.zzg.zze().zza(str);
            Object objZzc = zzayVar.zze.zzc(str);
            Preconditions.checkNotNull(objZzc);
            zza(zzaVarZza2, objZzc);
            zzaVarZza.zza(zzaVarZza2);
        }
        return (zzft.zze) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZza.zzah());
    }

    static zzft.zzg zza(zzft.zze zzeVar, String str) {
        for (zzft.zzg zzgVar : zzeVar.zzh()) {
            if (zzgVar.zzg().equals(str)) {
                return zzgVar;
            }
        }
        return null;
    }

    static <BuilderT extends com.google.android.gms.internal.measurement.zzlf> BuilderT zza(BuilderT buildert, byte[] bArr) throws com.google.android.gms.internal.measurement.zzkb {
        com.google.android.gms.internal.measurement.zzjg zzjgVarZza = com.google.android.gms.internal.measurement.zzjg.zza();
        if (zzjgVarZza != null) {
            return (BuilderT) buildert.zza(bArr, zzjgVarZza);
        }
        return (BuilderT) buildert.zza(bArr);
    }

    final String zza(zzft.zzi zziVar) {
        zzft.zzb zzbVarZzt;
        if (zziVar == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzft.zzj zzjVar : zziVar.zzd()) {
            if (zzjVar != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzjVar.zzbk()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzjVar.zze()));
                }
                if (zzqk.zza() && zze().zze(zzjVar.zzx(), zzbh.zzbs) && zzjVar.zzbn()) {
                    zza(sb, 1, "session_stitching_token", zzjVar.zzam());
                }
                zza(sb, 1, "platform", zzjVar.zzak());
                if (zzjVar.zzbf()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzjVar.zzm()));
                }
                if (zzjVar.zzbs()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzjVar.zzs()));
                }
                if (zzjVar.zzbd()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzjVar.zzk()));
                }
                if (zzjVar.zzay()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzjVar.zzi()));
                }
                zza(sb, 1, "gmp_app_id", zzjVar.zzah());
                zza(sb, 1, "admob_app_id", zzjVar.zzw());
                zza(sb, 1, "app_id", zzjVar.zzx());
                zza(sb, 1, App.JsonKeys.APP_VERSION, zzjVar.zzaa());
                if (zzjVar.zzav()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzjVar.zzb()));
                }
                zza(sb, 1, "firebase_instance_id", zzjVar.zzag());
                if (zzjVar.zzbc()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzjVar.zzj()));
                }
                zza(sb, 1, "app_store", zzjVar.zzz());
                if (zzjVar.zzbr()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzjVar.zzr()));
                }
                if (zzjVar.zzbo()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzjVar.zzp()));
                }
                if (zzjVar.zzbe()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzjVar.zzl()));
                }
                if (zzjVar.zzbj()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzjVar.zzo()));
                }
                if (zzjVar.zzbi()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzjVar.zzn()));
                }
                zza(sb, 1, "app_instance_id", zzjVar.zzy());
                zza(sb, 1, "resettable_device_id", zzjVar.zzal());
                zza(sb, 1, "ds_id", zzjVar.zzaf());
                if (zzjVar.zzbh()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzjVar.zzat()));
                }
                zza(sb, 1, "os_version", zzjVar.h_());
                zza(sb, 1, "device_model", zzjVar.zzae());
                zza(sb, 1, "user_default_language", zzjVar.zzan());
                if (zzjVar.zzbq()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzjVar.zzg()));
                }
                if (zzjVar.zzax()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzjVar.zzc()));
                }
                if (zzjVar.zzbm()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzjVar.zzau()));
                }
                zza(sb, 1, "health_monitor", zzjVar.zzai());
                if (zzjVar.zzbl()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzjVar.zzf()));
                }
                if (zzjVar.zzba()) {
                    zza(sb, 1, "consent_signals", zzjVar.zzac());
                }
                if (zzjVar.zzbg()) {
                    zza(sb, 1, "is_dma_region", Boolean.valueOf(zzjVar.zzas()));
                }
                if (zzjVar.zzbb()) {
                    zza(sb, 1, "core_platform_services", zzjVar.zzad());
                }
                if (zzjVar.zzaz()) {
                    zza(sb, 1, "consent_diagnostics", zzjVar.zzab());
                }
                if (zzjVar.zzbp()) {
                    zza(sb, 1, "target_os_version", Long.valueOf(zzjVar.zzq()));
                }
                if (zzpy.zza() && zze().zze(zzjVar.zzx(), zzbh.zzcg)) {
                    zza(sb, 1, "ad_services_version", Integer.valueOf(zzjVar.zza()));
                    if (zzjVar.zzaw() && (zzbVarZzt = zzjVar.zzt()) != null) {
                        zza(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zza(sb, 2, "eligible", Boolean.valueOf(zzbVarZzt.zzf()));
                        zza(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzbVarZzt.zzh()));
                        zza(sb, 2, "pre_r", Boolean.valueOf(zzbVarZzt.zzi()));
                        zza(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzbVarZzt.zzj()));
                        zza(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzbVarZzt.zze()));
                        zza(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzbVarZzt.zzd()));
                        zza(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzbVarZzt.zzg()));
                        zza(sb, 2);
                        sb.append("}\n");
                    }
                }
                List<zzft.zzn> listZzaq = zzjVar.zzaq();
                if (listZzaq != null) {
                    for (zzft.zzn zznVar : listZzaq) {
                        if (zznVar != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            zza(sb, 2, "set_timestamp_millis", zznVar.zzl() ? Long.valueOf(zznVar.zzd()) : null);
                            zza(sb, 2, "name", zzi().zzc(zznVar.zzg()));
                            zza(sb, 2, "string_value", zznVar.zzh());
                            zza(sb, 2, "int_value", zznVar.zzk() ? Long.valueOf(zznVar.zzc()) : null);
                            zza(sb, 2, "double_value", zznVar.zzi() ? Double.valueOf(zznVar.zza()) : null);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzft.zzc> listZzao = zzjVar.zzao();
                zzjVar.zzx();
                if (listZzao != null) {
                    for (zzft.zzc zzcVar : listZzao) {
                        if (zzcVar != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzcVar.zzg()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zzcVar.zza()));
                            }
                            if (zzcVar.zzh()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zzcVar.zzf()));
                            }
                            zza(sb, 2, "current_data", zzcVar.zzd());
                            if (zzcVar.zzi()) {
                                zza(sb, 2, "previous_data", zzcVar.zze());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzft.zze> listZzap = zzjVar.zzap();
                if (listZzap != null) {
                    for (zzft.zze zzeVar : listZzap) {
                        if (zzeVar != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, "name", zzi().zza(zzeVar.zzg()));
                            if (zzeVar.zzk()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzeVar.zzd()));
                            }
                            if (zzeVar.zzj()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzeVar.zzc()));
                            }
                            if (zzeVar.zzi()) {
                                zza(sb, 2, "count", Integer.valueOf(zzeVar.zza()));
                            }
                            if (zzeVar.zzb() != 0) {
                                zza(sb, 2, zzeVar.zzh());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    final String zza(zzfh.zzb zzbVar) {
        if (zzbVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzbVar.zzl()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzbVar.zzb()));
        }
        zza(sb, 0, "event_name", zzi().zza(zzbVar.zzf()));
        String strZza = zza(zzbVar.zzh(), zzbVar.zzi(), zzbVar.zzj());
        if (!strZza.isEmpty()) {
            zza(sb, 0, "filter_type", strZza);
        }
        if (zzbVar.zzk()) {
            zza(sb, 1, "event_count_filter", zzbVar.zze());
        }
        if (zzbVar.zza() > 0) {
            sb.append("  filters {\n");
            Iterator<zzfh.zzc> it = zzbVar.zzg().iterator();
            while (it.hasNext()) {
                zza(sb, 2, it.next());
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    private static String zza(boolean z10, boolean z11, boolean z12) {
        StringBuilder sb = new StringBuilder();
        if (z10) {
            sb.append("Dynamic ");
        }
        if (z11) {
            sb.append("Sequence ");
        }
        if (z12) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    final String zza(zzfh.zze zzeVar) {
        if (zzeVar == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzeVar.zzi()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzeVar.zza()));
        }
        zza(sb, 0, "property_name", zzi().zzc(zzeVar.zze()));
        String strZza = zza(zzeVar.zzf(), zzeVar.zzg(), zzeVar.zzh());
        if (!strZza.isEmpty()) {
            zza(sb, 0, "filter_type", strZza);
        }
        zza(sb, 1, zzeVar.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i10;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().zzu().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    zzj().zzu().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i11 = size2;
            i10 = size;
            size = i11;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i10);
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            long j10 = 0;
            for (int i11 = 0; i11 < 64; i11++) {
                int i12 = (i10 << 6) + i11;
                if (i12 < bitSet.length()) {
                    if (bitSet.get(i12)) {
                        j10 |= 1 << i11;
                    }
                }
            }
            arrayList.add(Long.valueOf(j10));
        }
        return arrayList;
    }

    final Map<String, Object> zza(Bundle bundle, boolean z10) {
        HashMap map = new HashMap();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z11 = obj instanceof Parcelable[];
            if (z11 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z10) {
                    ArrayList arrayList = new ArrayList();
                    if (z11) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(zza((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i10 = 0;
                        while (i10 < size) {
                            Object obj2 = arrayList2.get(i10);
                            i10++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(zza((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(zza((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    static void zza(zzft.zze.zza zzaVar, String str, Object obj) {
        List<zzft.zzg> listZzf = zzaVar.zzf();
        int i10 = 0;
        while (true) {
            if (i10 >= listZzf.size()) {
                i10 = -1;
                break;
            } else if (str.equals(listZzf.get(i10).zzg())) {
                break;
            } else {
                i10++;
            }
        }
        zzft.zzg.zza zzaVarZza = zzft.zzg.zze().zza(str);
        if (obj instanceof Long) {
            zzaVarZza.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zzaVarZza.zzb((String) obj);
        } else if (obj instanceof Double) {
            zzaVarZza.zza(((Double) obj).doubleValue());
        }
        if (i10 >= 0) {
            zzaVar.zza(i10, zzaVarZza);
        } else {
            zzaVar.zza(zzaVarZza);
        }
    }

    private static void zza(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zza(builder, str3, string, set);
            }
        }
    }

    private static void zza(StringBuilder sb, int i10, String str, zzft.zzl zzlVar) {
        if (zzlVar == null) {
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzlVar.zzb() != 0) {
            zza(sb, 4);
            sb.append("results: ");
            int i11 = 0;
            for (Long l10 : zzlVar.zzi()) {
                int i12 = i11 + 1;
                if (i11 != 0) {
                    sb.append(", ");
                }
                sb.append(l10);
                i11 = i12;
            }
            sb.append('\n');
        }
        if (zzlVar.zzd() != 0) {
            zza(sb, 4);
            sb.append("status: ");
            int i13 = 0;
            for (Long l11 : zzlVar.zzk()) {
                int i14 = i13 + 1;
                if (i13 != 0) {
                    sb.append(", ");
                }
                sb.append(l11);
                i13 = i14;
            }
            sb.append('\n');
        }
        if (zzlVar.zza() != 0) {
            zza(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i15 = 0;
            for (zzft.zzd zzdVar : zzlVar.zzh()) {
                int i16 = i15 + 1;
                if (i15 != 0) {
                    sb.append(", ");
                }
                sb.append(zzdVar.zzf() ? Integer.valueOf(zzdVar.zza()) : null);
                sb.append(":");
                sb.append(zzdVar.zze() ? Long.valueOf(zzdVar.zzb()) : null);
                i15 = i16;
            }
            sb.append("}\n");
        }
        if (zzlVar.zzc() != 0) {
            zza(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i17 = 0;
            for (zzft.zzm zzmVar : zzlVar.zzj()) {
                int i18 = i17 + 1;
                if (i17 != 0) {
                    sb.append(", ");
                }
                sb.append(zzmVar.zzf() ? Integer.valueOf(zzmVar.zzb()) : null);
                sb.append(": [");
                Iterator<Long> it = zzmVar.zze().iterator();
                int i19 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i20 = i19 + 1;
                    if (i19 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i19 = i20;
                }
                sb.append(v8.i.f15839e);
                i17 = i18;
            }
            sb.append("}\n");
        }
        zza(sb, 3);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i10, List<zzft.zzg> list) {
        if (list == null) {
            return;
        }
        int i11 = i10 + 1;
        for (zzft.zzg zzgVar : list) {
            if (zzgVar != null) {
                zza(sb, i11);
                sb.append("param {\n");
                zza(sb, i11, "name", zzgVar.zzm() ? zzi().zzb(zzgVar.zzg()) : null);
                zza(sb, i11, "string_value", zzgVar.zzn() ? zzgVar.zzh() : null);
                zza(sb, i11, "int_value", zzgVar.zzl() ? Long.valueOf(zzgVar.zzd()) : null);
                zza(sb, i11, "double_value", zzgVar.zzj() ? Double.valueOf(zzgVar.zza()) : null);
                if (zzgVar.zzc() > 0) {
                    zza(sb, i11, zzgVar.zzi());
                }
                zza(sb, i11);
                sb.append("}\n");
            }
        }
    }

    private final void zza(StringBuilder sb, int i10, zzfh.zzc zzcVar) {
        if (zzcVar == null) {
            return;
        }
        zza(sb, i10);
        sb.append("filter {\n");
        if (zzcVar.zzg()) {
            zza(sb, i10, "complement", Boolean.valueOf(zzcVar.zzf()));
        }
        if (zzcVar.zzi()) {
            zza(sb, i10, "param_name", zzi().zzb(zzcVar.zze()));
        }
        if (zzcVar.zzj()) {
            int i11 = i10 + 1;
            zzfh.zzf zzfVarZzd = zzcVar.zzd();
            if (zzfVarZzd != null) {
                zza(sb, i11);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzfVarZzd.zzj()) {
                    zza(sb, i11, "match_type", zzfVarZzd.zzb().name());
                }
                if (zzfVarZzd.zzi()) {
                    zza(sb, i11, "expression", zzfVarZzd.zze());
                }
                if (zzfVarZzd.zzh()) {
                    zza(sb, i11, "case_sensitive", Boolean.valueOf(zzfVarZzd.zzg()));
                }
                if (zzfVarZzd.zza() > 0) {
                    zza(sb, i11 + 1);
                    sb.append("expression_list {\n");
                    for (String str : zzfVarZzd.zzf()) {
                        zza(sb, i11 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i11);
                sb.append("}\n");
            }
        }
        if (zzcVar.zzh()) {
            zza(sb, i10 + 1, "number_filter", zzcVar.zzc());
        }
        zza(sb, i10);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i10, String str, zzfh.zzd zzdVar) {
        if (zzdVar == null) {
            return;
        }
        zza(sb, i10);
        sb.append(str);
        sb.append(" {\n");
        if (zzdVar.zzh()) {
            zza(sb, i10, "comparison_type", zzdVar.zza().name());
        }
        if (zzdVar.zzj()) {
            zza(sb, i10, "match_as_float", Boolean.valueOf(zzdVar.zzg()));
        }
        if (zzdVar.zzi()) {
            zza(sb, i10, "comparison_value", zzdVar.zzd());
        }
        if (zzdVar.zzl()) {
            zza(sb, i10, "min_comparison_value", zzdVar.zzf());
        }
        if (zzdVar.zzk()) {
            zza(sb, i10, "max_comparison_value", zzdVar.zze());
        }
        zza(sb, i10);
        sb.append("}\n");
    }

    private static void zza(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static void zza(StringBuilder sb, int i10, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i10 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    final void zza(zzft.zzj.zza zzaVar) {
        zzj().zzp().zza("Checking account type status for ad personalization signals");
        if (zzc(zzaVar.zzt())) {
            zzj().zzc().zza("Turning off ad personalization due to account type");
            zzft.zzn zznVar = (zzft.zzn) ((com.google.android.gms.internal.measurement.zzjt) zzft.zzn.zze().zza("_npa").zzb(zzf().zzc()).zza(1L).zzah());
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= zzaVar.zzd()) {
                    break;
                }
                if ("_npa".equals(zzaVar.zzk(i10).zzg())) {
                    zzaVar.zza(i10, zznVar);
                    z10 = true;
                    break;
                }
                i10++;
            }
            if (!z10) {
                zzaVar.zza(zznVar);
            }
            if (zzon.zza() && zze().zza(zzbh.zzco)) {
                zzaj zzajVarZza = zzaj.zza(zzaVar.zzv());
                zzajVarZza.zza(zziq.zza.AD_PERSONALIZATION, zzai.CHILD_ACCOUNT);
                zzaVar.zzf(zzajVarZza.toString());
            }
        }
    }

    final void zza(zzft.zzg.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzft.zzg.zza zzaVarZze = zzft.zzg.zze();
                    for (String str : bundle.keySet()) {
                        zzft.zzg.zza zzaVarZza = zzft.zzg.zze().zza(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zzaVarZza.zza(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zzaVarZza.zzb((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zzaVarZza.zza(((Double) obj2).doubleValue());
                        }
                        zzaVarZze.zza(zzaVarZza);
                    }
                    if (zzaVarZze.zza() > 0) {
                        arrayList.add((zzft.zzg) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZze.zzah()));
                    }
                }
            }
            zzaVar.zza(arrayList);
            return;
        }
        zzj().zzg().zza("Ignoring invalid (type) event param value", obj);
    }

    final void zza(zzft.zzn.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zzc().zzb().zza();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzj().zzg().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    @WorkerThread
    static boolean zza(zzbf zzbfVar, zzn zznVar) {
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotNull(zznVar);
        return (TextUtils.isEmpty(zznVar.zzb) && TextUtils.isEmpty(zznVar.zzp)) ? false : true;
    }

    static boolean zza(List<Long> list, int i10) {
        if (i10 < (list.size() << 6)) {
            return ((1 << (i10 % 64)) & list.get(i10 / 64).longValue()) != 0;
        }
        return false;
    }

    final boolean zza(long j10, long j11) {
        return j10 == 0 || j11 <= 0 || Math.abs(zzb().currentTimeMillis() - j10) > j11;
    }
}
