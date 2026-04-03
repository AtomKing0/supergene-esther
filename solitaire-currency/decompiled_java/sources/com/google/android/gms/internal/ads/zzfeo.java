package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfeo {
    public final List zza;
    public final String zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final long zzg;
    public final boolean zzh;
    public final String zzi;

    @Nullable
    public final zzfen zzj;
    public final Bundle zzk;
    public final String zzl;
    public final String zzm;
    public final String zzn;
    public final JSONObject zzo;
    public final JSONObject zzp;
    public final String zzq;
    public final int zzr;

    zzfeo(JsonReader jsonReader) throws IllegalStateException, JSONException, IOException, NumberFormatException {
        List listEmptyList = Collections.emptyList();
        Bundle bundle = new Bundle();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jsonReader.beginObject();
        String strNextString = "";
        String strNextString2 = "";
        String strNextString3 = strNextString2;
        String strNextString4 = strNextString3;
        String strNextString5 = strNextString4;
        int iNextInt = 0;
        int iNextInt2 = 0;
        boolean zNextBoolean = false;
        zzfen zzfenVar = null;
        long jNextLong = 0;
        int iNextInt3 = -1;
        int iMax = 1;
        String strNextString6 = strNextString5;
        String strNextString7 = strNextString6;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (Objects.equals(strNextName, "nofill_urls")) {
                listEmptyList = com.google.android.gms.ads.internal.util.zzbs.zzd(jsonReader);
            } else if ("refresh_interval".equals(strNextName)) {
                iNextInt = jsonReader.nextInt();
            } else if (Objects.equals(strNextName, "refresh_load_delay_time_interval")) {
                iNextInt3 = jsonReader.nextInt();
            } else if ("gws_query_id".equals(strNextName)) {
                strNextString = jsonReader.nextString();
            } else if ("analytics_query_ad_event_id".equals(strNextName)) {
                strNextString6 = jsonReader.nextString();
            } else if ("is_idless".equals(strNextName)) {
                zNextBoolean = jsonReader.nextBoolean();
            } else if ("response_code".equals(strNextName)) {
                iNextInt2 = jsonReader.nextInt();
            } else if ("latency".equals(strNextName)) {
                jNextLong = jsonReader.nextLong();
            } else {
                String str = strNextString5;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzhw)).booleanValue() && "public_error".equals(strNextName) && jsonReader.peek() == JsonToken.BEGIN_OBJECT) {
                    zzfenVar = new zzfen(jsonReader);
                } else if ("bidding_data".equals(strNextName)) {
                    strNextString7 = jsonReader.nextString();
                } else {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjz)).booleanValue() && Objects.equals(strNextName, "topics_should_record_observation")) {
                        jsonReader.nextBoolean();
                    } else if ("adapter_response_replacement_key".equals(strNextName)) {
                        strNextString5 = jsonReader.nextString();
                    } else if ("response_info_extras".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgf)).booleanValue()) {
                            try {
                                Bundle bundleZza = com.google.android.gms.ads.internal.util.zzbs.zza(com.google.android.gms.ads.internal.util.zzbs.zzi(jsonReader));
                                if (bundleZza != null) {
                                    bundle = bundleZza;
                                }
                            } catch (IOException | JSONException unused) {
                            } catch (IllegalStateException unused2) {
                                jsonReader.skipValue();
                            }
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestPostBody".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
                            strNextString3 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if ("adRequestUrl".equals(strNextName)) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzit)).booleanValue()) {
                            strNextString2 = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        zzbbn zzbbnVar = zzbbw.zziu;
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() && Objects.equals(strNextName, "adResponseBody")) {
                            strNextString4 = jsonReader.nextString();
                        } else if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue() && Objects.equals(strNextName, "adResponseHeaders")) {
                            jSONObject = com.google.android.gms.ads.internal.util.zzbs.zzi(jsonReader);
                        } else if (Objects.equals(strNextName, "max_parallel_renderers")) {
                            iMax = Math.max(1, jsonReader.nextInt());
                        } else {
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziB)).booleanValue() && Objects.equals(strNextName, "inspector_ad_transaction_extras")) {
                                jSONObject2 = com.google.android.gms.ads.internal.util.zzbs.zzi(jsonReader);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                    }
                }
                strNextString5 = str;
            }
        }
        String str2 = strNextString5;
        jsonReader.endObject();
        this.zza = listEmptyList;
        this.zzc = iNextInt;
        if (((Boolean) zzbdy.zzd.zze()).booleanValue()) {
            this.zzd = -1;
        } else {
            zzbdc zzbdcVar = zzbdg.zza;
            if (((Long) zzbdcVar.zze()).longValue() > -1) {
                this.zzd = ((Long) zzbdcVar.zze()).intValue();
            } else {
                this.zzd = iNextInt3;
            }
        }
        this.zzb = strNextString;
        this.zze = strNextString6;
        this.zzf = iNextInt2;
        this.zzg = jNextLong;
        this.zzj = zzfenVar;
        this.zzh = zNextBoolean;
        this.zzi = strNextString7;
        this.zzk = bundle;
        this.zzl = strNextString2;
        this.zzm = strNextString3;
        this.zzn = strNextString4;
        this.zzo = jSONObject;
        this.zzp = jSONObject2;
        this.zzq = str2;
        zzbdc zzbdcVar2 = zzbdw.zza;
        this.zzr = ((Long) zzbdcVar2.zze()).longValue() > 0 ? ((Long) zzbdcVar2.zze()).intValue() : iMax;
    }
}
