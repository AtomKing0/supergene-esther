package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
public final class zzhz extends com.google.android.gms.drive.metadata.internal.zzl<DriveSpace> {
    public zzhz(int i10) {
        super("spaces", Arrays.asList("inDriveSpace", "isAppData", "inGooglePhotosSpace"), Collections.emptySet(), GmsVersion.VERSION_ORLA);
    }

    @Override // com.google.android.gms.drive.metadata.zzb, com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i10, int i11) {
        return zzc(dataHolder, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.drive.metadata.zzb
    /* JADX INFO: renamed from: zzd */
    public final Collection<DriveSpace> zzc(DataHolder dataHolder, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        if (dataHolder.getBoolean("inDriveSpace", i10, i11)) {
            arrayList.add(DriveSpace.zzah);
        }
        if (dataHolder.getBoolean("isAppData", i10, i11)) {
            arrayList.add(DriveSpace.zzai);
        }
        if (dataHolder.getBoolean("inGooglePhotosSpace", i10, i11)) {
            arrayList.add(DriveSpace.zzaj);
        }
        return arrayList;
    }
}
