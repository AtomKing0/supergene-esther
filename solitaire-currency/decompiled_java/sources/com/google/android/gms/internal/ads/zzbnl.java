package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbnl {
    private static final Charset zzc = Charset.forName("UTF-8");
    public static final zzbni zza = new zzbnk();
    public static final zzbng zzb = new zzbng() { // from class: com.google.android.gms.internal.ads.zzbnj
        @Override // com.google.android.gms.internal.ads.zzbng
        public final Object zza(JSONObject jSONObject) {
            return zzbnl.zza(jSONObject);
        }
    };

    static /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
