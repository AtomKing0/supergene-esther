package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import androidx.annotation.Nullable;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgl implements zzgn {
    @Override // com.google.android.gms.internal.measurement.zzgn
    @Nullable
    public final String zza(ContentResolver contentResolver, String str) throws zzgq {
        Cursor cursorQuery = contentResolver.query(zzgf.zza, null, null, new String[]{str}, null);
        try {
            if (cursorQuery == null) {
                throw new zzgq("Failed to connect to GservicesProvider");
            }
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return null;
            }
            String string = cursorQuery.getString(1);
            cursorQuery.close();
            return string;
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgn
    public final <T extends Map<String, String>> T zza(ContentResolver contentResolver, String[] strArr, zzgo<T> zzgoVar) throws zzgq {
        Cursor cursorQuery = contentResolver.query(zzgf.zzb, null, null, strArr, null);
        try {
            if (cursorQuery != null) {
                T t10 = (T) zzgoVar.zza(cursorQuery.getCount());
                while (cursorQuery.moveToNext()) {
                    t10.put(cursorQuery.getString(0), cursorQuery.getString(1));
                }
                cursorQuery.close();
                return t10;
            }
            throw new zzgq("Failed to connect to GservicesProvider");
        } catch (Throwable th) {
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
