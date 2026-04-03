package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfx extends SQLiteOpenHelper {
    private final /* synthetic */ zzfu zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfx(zzfu zzfuVar, Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.zza = zzfuVar;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        try {
            return super.getWritableDatabase();
        } catch (SQLiteDatabaseLockedException e10) {
            throw e10;
        } catch (SQLiteException unused) {
            this.zza.zzj().zzg().zza("Opening the local database failed, dropping and recreating it");
            if (!this.zza.zza().getDatabasePath("google_app_measurement_local.db").delete()) {
                this.zza.zzj().zzg().zza("Failed to delete corrupted local db file", "google_app_measurement_local.db");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e11) {
                this.zza.zzj().zzg().zza("Failed to open local database. Events will bypass local storage", e11);
                return null;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        zzas.zza(this.zza.zzj(), sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        zzas.zza(this.zza.zzj(), sQLiteDatabase, "messages", "create table if not exists messages ( type INTEGER NOT NULL, entry BLOB NOT NULL)", "type,entry", null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @WorkerThread
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
