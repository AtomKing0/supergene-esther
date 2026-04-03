package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import androidx.annotation.Nullable;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfew {
    public final List zza;
    public final zzfeo zzb;
    public final List zzc;

    @Nullable
    public final zzbvb zzd;

    zzfew(JsonReader jsonReader, @Nullable zzbvb zzbvbVar) throws IllegalStateException, JSONException, IOException, NumberFormatException, AssertionError {
        Bundle bundle;
        this.zzd = zzbvbVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzbS)).booleanValue() && zzbvbVar != null && (bundle = zzbvbVar.zzm) != null) {
            bundle.putLong(zzdrt.SERVER_RESPONSE_PARSE_START.zza(), com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
        }
        List listEmptyList = Collections.emptyList();
        ArrayList arrayList = new ArrayList();
        jsonReader.beginObject();
        zzfeo zzfeoVar = null;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if ("responses".equals(strNextName)) {
                jsonReader.beginArray();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if ("ad_configs".equals(strNextName2)) {
                        listEmptyList = new ArrayList();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            listEmptyList.add(new zzfel(jsonReader));
                        }
                        jsonReader.endArray();
                    } else if (strNextName2.equals("common")) {
                        zzfeoVar = new zzfeo(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                jsonReader.endArray();
            } else if (strNextName.equals("actions")) {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    jsonReader.beginObject();
                    String strNextString = null;
                    JSONObject jSONObjectZzi = null;
                    while (jsonReader.hasNext()) {
                        String strNextName3 = jsonReader.nextName();
                        if ("name".equals(strNextName3)) {
                            strNextString = jsonReader.nextString();
                        } else if ("info".equals(strNextName3)) {
                            jSONObjectZzi = com.google.android.gms.ads.internal.util.zzbs.zzi(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    if (strNextString != null) {
                        arrayList.add(new zzfev(strNextString, jSONObjectZzi));
                    }
                    jsonReader.endObject();
                }
                jsonReader.endArray();
            }
        }
        this.zzc = arrayList;
        this.zza = listEmptyList;
        this.zzb = zzfeoVar == null ? new zzfeo(new JsonReader(new StringReader(JsonUtils.EMPTY_JSON))) : zzfeoVar;
    }

    public static zzfew zza(Reader reader, @Nullable zzbvb zzbvbVar) throws zzfep {
        try {
            try {
                return new zzfew(new JsonReader(reader), zzbvbVar);
            } finally {
                IOUtils.closeQuietly(reader);
            }
        } catch (IOException | AssertionError | IllegalStateException | NumberFormatException | JSONException e10) {
            throw new zzfep("unable to parse ServerResponse", e10);
        }
    }
}
