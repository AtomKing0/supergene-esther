package com.google.android.gms.drive.metadata.internal;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzu extends zzm<UserMetadata> {
    public zzu(String str, int i10) {
        super(str, Arrays.asList(zza(str, "permissionId"), zza(str, "displayName"), zza(str, "picture"), zza(str, "isAuthenticatedUser"), zza(str, HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS)), Collections.emptyList(), GmsVersion.VERSION_MANCHEGO);
    }

    private static String zza(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        return sb.toString();
    }

    private final String zzh(String str) {
        return zza(getName(), str);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final boolean zzb(DataHolder dataHolder, int i10, int i11) {
        return dataHolder.hasColumn(zzh("permissionId")) && !dataHolder.hasNull(zzh("permissionId"), i10, i11);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i10, int i11) {
        String string = dataHolder.getString(zzh("permissionId"), i10, i11);
        if (string == null) {
            return null;
        }
        String string2 = dataHolder.getString(zzh("displayName"), i10, i11);
        String string3 = dataHolder.getString(zzh("picture"), i10, i11);
        Boolean boolValueOf = Boolean.valueOf(dataHolder.getBoolean(zzh("isAuthenticatedUser"), i10, i11));
        return new UserMetadata(string, string2, string3, boolValueOf.booleanValue(), dataHolder.getString(zzh(HintConstants.AUTOFILL_HINT_EMAIL_ADDRESS), i10, i11));
    }
}
