package com.google.android.gms.internal.drive;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.GmsVersion;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class zzid extends com.google.android.gms.drive.metadata.internal.zzm<AppVisibleCustomProperties> {
    public static final com.google.android.gms.drive.metadata.internal.zzg zzlc = new zzie();

    public zzid(int i10) {
        super("customProperties", Arrays.asList("hasCustomProperties", "sqlId"), Arrays.asList("customPropertiesExtra", "customPropertiesExtraHolder"), GmsVersion.VERSION_LONGHORN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(DataHolder dataHolder) {
        Bundle metadata = dataHolder.getMetadata();
        if (metadata == null) {
            return;
        }
        synchronized (dataHolder) {
            DataHolder dataHolder2 = (DataHolder) metadata.getParcelable("customPropertiesExtraHolder");
            if (dataHolder2 != null) {
                dataHolder2.close();
                metadata.remove("customPropertiesExtraHolder");
            }
        }
    }

    private static AppVisibleCustomProperties zzf(DataHolder dataHolder, int i10, int i11) {
        Bundle metadata = dataHolder.getMetadata();
        SparseArray sparseParcelableArray = metadata.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (metadata.getParcelable("customPropertiesExtraHolder") != null) {
                synchronized (dataHolder) {
                    DataHolder dataHolder2 = (DataHolder) dataHolder.getMetadata().getParcelable("customPropertiesExtraHolder");
                    if (dataHolder2 != null) {
                        try {
                            Bundle metadata2 = dataHolder2.getMetadata();
                            String string = metadata2.getString("entryIdColumn");
                            String string2 = metadata2.getString("keyColumn");
                            String string3 = metadata2.getString("visibilityColumn");
                            String string4 = metadata2.getString("valueColumn");
                            LongSparseArray longSparseArray = new LongSparseArray();
                            for (int i12 = 0; i12 < dataHolder2.getCount(); i12++) {
                                int windowIndex = dataHolder2.getWindowIndex(i12);
                                long j10 = dataHolder2.getLong(string, i12, windowIndex);
                                String string5 = dataHolder2.getString(string2, i12, windowIndex);
                                int integer = dataHolder2.getInteger(string3, i12, windowIndex);
                                com.google.android.gms.drive.metadata.internal.zzc zzcVar = new com.google.android.gms.drive.metadata.internal.zzc(new CustomPropertyKey(string5, integer), dataHolder2.getString(string4, i12, windowIndex));
                                AppVisibleCustomProperties.zza zzaVar = (AppVisibleCustomProperties.zza) longSparseArray.get(j10);
                                if (zzaVar == null) {
                                    zzaVar = new AppVisibleCustomProperties.zza();
                                    longSparseArray.put(j10, zzaVar);
                                }
                                zzaVar.zza(zzcVar);
                            }
                            SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
                            for (int i13 = 0; i13 < dataHolder.getCount(); i13++) {
                                AppVisibleCustomProperties.zza zzaVar2 = (AppVisibleCustomProperties.zza) longSparseArray.get(dataHolder.getLong("sqlId", i13, dataHolder.getWindowIndex(i13)));
                                if (zzaVar2 != null) {
                                    sparseArray.append(i13, zzaVar2.zzbb());
                                }
                            }
                            dataHolder.getMetadata().putSparseParcelableArray("customPropertiesExtra", sparseArray);
                        } finally {
                            dataHolder2.close();
                            dataHolder.getMetadata().remove("customPropertiesExtraHolder");
                        }
                    }
                }
                sparseParcelableArray = metadata.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzjb;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i10, AppVisibleCustomProperties.zzjb);
    }

    @Override // com.google.android.gms.drive.metadata.zza
    protected final /* synthetic */ Object zzc(DataHolder dataHolder, int i10, int i11) {
        return zzf(dataHolder, i10, i11);
    }
}
