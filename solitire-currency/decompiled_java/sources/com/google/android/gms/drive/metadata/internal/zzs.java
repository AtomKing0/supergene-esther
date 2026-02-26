package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes3.dex */
public final class zzs extends com.google.android.gms.drive.metadata.zzb<String> {
    public zzs(String str, int i10) {
        super(str, Collections.singleton(str), Collections.emptySet(), GmsVersion.VERSION_JARLSBERG);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ void zza(Bundle bundle, Object obj) {
        bundle.putStringArrayList(getName(), new ArrayList<>((Collection) obj));
    }

    @Override // com.google.android.gms.drive.metadata.zza
    @Nullable
    protected final /* synthetic */ Object zzb(Bundle bundle) {
        return bundle.getStringArrayList(getName());
    }

    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    @Nullable
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i10, int i11) {
        return zzc(dataHolder, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb
    @Nullable
    /* JADX INFO: renamed from: zzd */
    public final Collection<String> zzc(DataHolder dataHolder, int i10, int i11) {
        try {
            String string = dataHolder.getString(getName(), i10, i11);
            if (string == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = new JSONArray(string);
            for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                arrayList.add(jSONArray.getString(i12));
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (JSONException e10) {
            throw new IllegalStateException("DataHolder supplied invalid JSON", e10);
        }
    }
}
