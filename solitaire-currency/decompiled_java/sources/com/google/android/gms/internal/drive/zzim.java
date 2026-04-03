package com.google.android.gms.internal.drive;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class zzim extends com.google.android.gms.drive.metadata.internal.zzm<DriveId> {
    public static final zzim zzlj = new zzim();

    private zzim() {
        super("driveId", Arrays.asList("sqlId", "resourceId", "mimeType"), Arrays.asList("dbInstanceId"), GmsVersion.VERSION_HALLOUMI);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final boolean zzb(DataHolder dataHolder, int i10, int i11) {
        Iterator<String> it = zzaz().iterator();
        while (it.hasNext()) {
            if (!dataHolder.hasColumn(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i10, int i11) {
        long j10 = dataHolder.getMetadata().getLong("dbInstanceId");
        boolean zEquals = DriveFolder.MIME_TYPE.equals(dataHolder.getString(zzhs.zzki.getName(), i10, i11));
        String string = dataHolder.getString("resourceId", i10, i11);
        return new DriveId("generated-android-null".equals(string) ? null : string, Long.valueOf(dataHolder.getLong("sqlId", i10, i11)).longValue(), j10, zEquals ? 1 : 0);
    }
}
