package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkd implements zzns {
    private final /* synthetic */ zziy zza;

    zzkd(zziy zziyVar) {
        this.zza = zziyVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzns
    public final void zza(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.zza.zzb(TtmlNode.TEXT_EMPHASIS_AUTO, str2, bundle);
        } else {
            this.zza.zza(TtmlNode.TEXT_EMPHASIS_AUTO, str2, bundle, str);
        }
    }
}
