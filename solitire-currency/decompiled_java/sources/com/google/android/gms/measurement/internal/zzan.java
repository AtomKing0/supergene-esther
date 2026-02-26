package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.media3.common.PlaybackException;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzfh;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.internal.measurement.zzoh;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzpy;
import com.google.android.gms.internal.measurement.zzqv;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.sentry.protocol.App;
import io.sentry.protocol.TransactionInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzan extends zzmy {
    private static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    private static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    private static final String[] zzc = {App.JsonKeys.APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;", "sgtm_preview_key", "ALTER TABLE apps ADD COLUMN sgtm_preview_key TEXT;", "dma_consent_state", "ALTER TABLE apps ADD COLUMN dma_consent_state INTEGER;", "daily_realtime_dcu_count", "ALTER TABLE apps ADD COLUMN daily_realtime_dcu_count INTEGER;", "bundle_delivery_index", "ALTER TABLE apps ADD COLUMN bundle_delivery_index INTEGER;", "serialized_npa_metadata", "ALTER TABLE apps ADD COLUMN serialized_npa_metadata TEXT;"};
    private static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    private static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    private static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    private static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;"};
    private static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzat zzl;
    private final zzms zzm;

    zzan(zznd zzndVar) {
        super(zzndVar);
        this.zzm = new zzms(zzb());
        this.zzl = new zzat(this, zza(), "google_app_measurement.db");
    }

    @VisibleForTesting
    private final boolean zzan() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final long b_() {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", null);
                if (!cursorRawQuery.moveToFirst()) {
                    cursorRawQuery.close();
                    return -1L;
                }
                long j10 = cursorRawQuery.getLong(0);
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error querying raw events", e10);
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0L);
    }

    @WorkerThread
    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0L);
    }

    @VisibleForTesting
    @WorkerThread
    final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e10) {
            zzj().zzu().zza("Error opening database", e10);
            throw e10;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.database.Cursor] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String f_() throws java.lang.Throwable {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch: java.lang.Throwable -> L20 android.database.sqlite.SQLiteException -> L25
            boolean r2 = r0.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            if (r2 == 0) goto L1a
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch: android.database.sqlite.SQLiteException -> L1e java.lang.Throwable -> L3a
            r0.close()
            return r1
        L1a:
            r0.close()
            return r1
        L1e:
            r2 = move-exception
            goto L27
        L20:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L3b
        L25:
            r2 = move-exception
            r0 = r1
        L27:
            com.google.android.gms.measurement.internal.zzgb r3 = r6.zzj()     // Catch: java.lang.Throwable -> L3a
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch: java.lang.Throwable -> L3a
            if (r0 == 0) goto L39
            r0.close()
        L39:
            return r1
        L3a:
            r1 = move-exception
        L3b:
            if (r0 == 0) goto L40
            r0.close()
        L40:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.f_():java.lang.String");
    }

    @VisibleForTesting
    @WorkerThread
    protected final long zzb(String str, String str2) {
        long jZza;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        long j10 = 0;
        try {
            try {
                jZza = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1L);
            } catch (SQLiteException e10) {
                e = e10;
            }
            if (jZza == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", (Integer) 0);
                contentValues.put("previous_install_count", (Integer) 0);
                if (sQLiteDatabaseE_.insertWithOnConflict("app2", null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert column (got -1). appId", zzgb.zza(str), str2);
                    return -1L;
                }
                jZza = 0;
                zzj().zzg().zza("Error inserting column. appId", zzgb.zza(str), str2, e);
                sQLiteDatabaseE_.endTransaction();
                return j10;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + jZza));
                if (sQLiteDatabaseE_.update("app2", contentValues2, "app_id = ?", new String[]{str}) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzgb.zza(str), str2);
                    return -1L;
                }
                sQLiteDatabaseE_.setTransactionSuccessful();
                return jZza;
            } catch (SQLiteException e11) {
                e = e11;
                j10 = jZza;
            }
        } finally {
            sQLiteDatabaseE_.endTransaction();
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0083: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x0083 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.os.Bundle zzd(java.lang.String r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r5.zzt()
            r5.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.e_()     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            r4 = 0
            r3[r4] = r6     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L6b android.database.sqlite.SQLiteException -> L6d
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            if (r2 != 0) goto L2e
            com.google.android.gms.measurement.internal.zzgb r6 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            java.lang.String r2 = "Default event parameters not found"
            r6.zza(r2)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            r1.close()
            return r0
        L2e:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze$zza r3 = com.google.android.gms.internal.measurement.zzft.zze.zze()     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzlf r2 = com.google.android.gms.measurement.internal.zznm.zza(r3, r2)     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze$zza r2 = (com.google.android.gms.internal.measurement.zzft.zze.zza) r2     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzlg r2 = r2.zzah()     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.internal.measurement.zzft$zze r2 = (com.google.android.gms.internal.measurement.zzft.zze) r2     // Catch: java.io.IOException -> L53 android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            r5.g_()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            java.util.List r6 = r2.zzh()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            android.os.Bundle r6 = com.google.android.gms.measurement.internal.zznm.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            r1.close()
            return r6
        L53:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgb r3 = r5.zzj()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzgb.zza(r6)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            r3.zza(r4, r6, r2)     // Catch: android.database.sqlite.SQLiteException -> L69 java.lang.Throwable -> L82
            r1.close()
            return r0
        L69:
            r6 = move-exception
            goto L6f
        L6b:
            r6 = move-exception
            goto L84
        L6d:
            r6 = move-exception
            r1 = r0
        L6f:
            com.google.android.gms.measurement.internal.zzgb r2 = r5.zzj()     // Catch: java.lang.Throwable -> L82
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzg()     // Catch: java.lang.Throwable -> L82
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r6)     // Catch: java.lang.Throwable -> L82
            if (r1 == 0) goto L81
            r1.close()
        L81:
            return r0
        L82:
            r6 = move-exception
            r0 = r1
        L84:
            if (r0 == 0) goto L89
            r0.close()
        L89:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzd(java.lang.String):android.os.Bundle");
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0334  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzf zze(java.lang.String r47) {
        /*
            Method dump skipped, instruction units count: 824
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0084: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:28:0x0084 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzap zzf(java.lang.String r12) throws java.lang.Throwable {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzt()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.e_()     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r10 = 0
            r5[r10] = r12     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L68 android.database.sqlite.SQLiteException -> L6a
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            if (r2 != 0) goto L33
            r1.close()
            return r0
        L33:
            byte[] r2 = r1.getBlob(r10)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            java.lang.String r3 = r1.getString(r9)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            boolean r5 = r1.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            if (r5 == 0) goto L57
            com.google.android.gms.measurement.internal.zzgb r5 = r11.zzj()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzg()     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzgb.zza(r12)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r5.zza(r6, r7)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
        L57:
            if (r2 != 0) goto L5d
            r1.close()
            return r0
        L5d:
            com.google.android.gms.measurement.internal.zzap r5 = new com.google.android.gms.measurement.internal.zzap     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r5.<init>(r2, r3, r4)     // Catch: android.database.sqlite.SQLiteException -> L66 java.lang.Throwable -> L83
            r1.close()
            return r5
        L66:
            r2 = move-exception
            goto L6c
        L68:
            r12 = move-exception
            goto L85
        L6a:
            r2 = move-exception
            r1 = r0
        L6c:
            com.google.android.gms.measurement.internal.zzgb r3 = r11.zzj()     // Catch: java.lang.Throwable -> L83
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: java.lang.Throwable -> L83
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzgb.zza(r12)     // Catch: java.lang.Throwable -> L83
            r3.zza(r4, r12, r2)     // Catch: java.lang.Throwable -> L83
            if (r1 == 0) goto L82
            r1.close()
        L82:
            return r0
        L83:
            r12 = move-exception
            r0 = r1
        L85:
            if (r0 == 0) goto L8a
            r0.close()
        L8a:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzf(java.lang.String):com.google.android.gms.measurement.internal.zzap");
    }

    public final zzax zzg(String str) {
        if (!zzon.zza() || !zze().zza(zzbh.zzco)) {
            return zzax.zza;
        }
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzax.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    public final zziq zzh(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        if (!zzon.zza() || !zze().zza(zzbh.zzco)) {
            return zziq.zzb(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
        }
        zziq zziqVar = (zziq) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, new zzaq() { // from class: com.google.android.gms.measurement.internal.zzam
            @Override // com.google.android.gms.measurement.internal.zzaq
            public final Object zza(Cursor cursor) {
                return zziq.zza(cursor.getString(0), cursor.getInt(1));
            }
        });
        return zziqVar == null ? zziq.zza : zziqVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzmv> zzi(java.lang.String r14) {
        /*
            r13 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r13.zzt()
            r13.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r13.e_()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r3 = "trigger_uris"
            java.lang.String r4 = "trigger_uri"
            java.lang.String r5 = "timestamp_millis"
            java.lang.String r6 = "source"
            java.lang.String[] r4 = new java.lang.String[]{r4, r5, r6}     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            java.lang.String r5 = "app_id=?"
            r11 = 1
            java.lang.String[] r6 = new java.lang.String[r11]     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r12 = 0
            r6[r12] = r14     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 != 0) goto L3a
            r1.close()
            return r0
        L3a:
            java.lang.String r2 = r1.getString(r12)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 != 0) goto L42
            java.lang.String r2 = ""
        L42:
            long r3 = r1.getLong(r11)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r5 = 2
            int r5 = r1.getInt(r5)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            com.google.android.gms.measurement.internal.zzmv r6 = new com.google.android.gms.measurement.internal.zzmv     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r6.<init>(r2, r3, r5)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            r0.add(r6)     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            boolean r2 = r1.moveToNext()     // Catch: java.lang.Throwable -> L5d android.database.sqlite.SQLiteException -> L5f
            if (r2 != 0) goto L3a
            r1.close()
            return r0
        L5d:
            r14 = move-exception
            goto L7b
        L5f:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgb r2 = r13.zzj()     // Catch: java.lang.Throwable -> L5d
            com.google.android.gms.measurement.internal.zzgd r2 = r2.zzg()     // Catch: java.lang.Throwable -> L5d
            java.lang.String r3 = "Error querying trigger uris. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzgb.zza(r14)     // Catch: java.lang.Throwable -> L5d
            r2.zza(r3, r14, r0)     // Catch: java.lang.Throwable -> L5d
            java.util.List r14 = java.util.Collections.emptyList()     // Catch: java.lang.Throwable -> L5d
            if (r1 == 0) goto L7a
            r1.close()
        L7a:
            return r14
        L7b:
            if (r1 == 0) goto L80
            r1.close()
        L80:
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzi(java.lang.String):java.util.List");
    }

    @WorkerThread
    public final List<zznq> zzj(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, null, null, "rowid", "1000");
                if (!cursorQuery.moveToFirst()) {
                    cursorQuery.close();
                    return arrayList;
                }
                do {
                    String string = cursorQuery.getString(0);
                    String string2 = cursorQuery.getString(1);
                    if (string2 == null) {
                        string2 = "";
                    }
                    String str2 = string2;
                    long j10 = cursorQuery.getLong(2);
                    Object objZza = zza(cursorQuery, 3);
                    if (objZza == null) {
                        zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzgb.zza(str));
                    } else {
                        arrayList.add(new zznq(str, str2, string, j10, objZza));
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayList;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error querying user properties. appId", zzgb.zza(str), e10);
                List<zznq> listEmptyList = Collections.emptyList();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return listEmptyList;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }

    final Map<Integer, zzft.zzl> zzk(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, zzft.zzl> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                ArrayMap arrayMap = new ArrayMap();
                do {
                    int i10 = cursorQuery.getInt(0);
                    try {
                        arrayMap.put(Integer.valueOf(i10), (zzft.zzl) ((com.google.android.gms.internal.measurement.zzjt) ((zzft.zzl.zza) zznm.zza(zzft.zzl.zze(), cursorQuery.getBlob(1))).zzah()));
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzgb.zza(str), Integer.valueOf(i10), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filter results. appId", zzgb.zza(str), e11);
                Map<Integer, zzft.zzl> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<zzfh.zzb>> zzl(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfh.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfh.zzb zzbVar = (zzfh.zzb) ((com.google.android.gms.internal.measurement.zzjt) ((zzfh.zzb.zza) zznm.zza(zzfh.zzb.zzc(), cursorQuery.getBlob(1))).zzah());
                        if (zzbVar.zzk()) {
                            int i10 = cursorQuery.getInt(0);
                            List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                                arrayMap.put(Integer.valueOf(i10), arrayList);
                            }
                            arrayList.add(zzbVar);
                        }
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgb.zza(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e11);
                Map<Integer, List<zzfh.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    final Map<Integer, List<Integer>> zzm(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
                if (!cursorRawQuery.moveToFirst()) {
                    Map<Integer, List<Integer>> mapEmptyMap = Collections.emptyMap();
                    cursorRawQuery.close();
                    return mapEmptyMap;
                }
                do {
                    int i10 = cursorRawQuery.getInt(0);
                    List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        arrayMap.put(Integer.valueOf(i10), arrayList);
                    }
                    arrayList.add(Integer.valueOf(cursorRawQuery.getInt(1)));
                } while (cursorRawQuery.moveToNext());
                cursorRawQuery.close();
                return arrayMap;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error querying scoped filters. appId", zzgb.zza(str), e10);
                Map<Integer, List<Integer>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zzp() {
        zzak();
        e_().beginTransaction();
    }

    @WorkerThread
    public final void zzu() {
        zzak();
        e_().endTransaction();
    }

    @WorkerThread
    final void zzv() {
        int iDelete;
        zzt();
        zzak();
        if (zzan()) {
            long jZza = zzn().zza.zza();
            long jElapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(jElapsedRealtime - jZza) > zzbh.zzy.zza(null).longValue()) {
                zzn().zza.zza(jElapsedRealtime);
                zzt();
                zzak();
                if (!zzan() || (iDelete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzae.zzm())})) <= 0) {
                    return;
                }
                zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(iDelete));
            }
        }
    }

    @WorkerThread
    public final void zzw() {
        zzak();
        e_().setTransactionSuccessful();
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting conditional property", zzgb.zza(str), zzi().zzc(str2), e10);
            return 0;
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0123  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zzac zzc(java.lang.String r30, java.lang.String r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzac");
    }

    final Map<Integer, List<zzfh.zze>> zzg(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfh.zze>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfh.zze zzeVar = (zzfh.zze) ((com.google.android.gms.internal.measurement.zzjt) ((zzfh.zze.zza) zznm.zza(zzfh.zze.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzeVar);
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter", zzgb.zza(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e11);
                Map<Integer, List<zzfh.zze>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting user property. appId", zzgb.zza(str), zzi().zzc(str2), e10);
        }
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            return e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(PlaybackException.CUSTOM_ERROR_CODE_BASE, zze().zzb(str, zzbh.zzp))))});
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzgb.zza(str), e10);
            return 0L;
        }
    }

    /* JADX WARN: Not initialized variable reg: 14, insn: 0x0147: MOVE (r18 I:??[OBJECT, ARRAY]) = (r14 I:??[OBJECT, ARRAY]), block:B:64:0x0147 */
    @WorkerThread
    public final zzbb zzd(String str, String str2) {
        Cursor cursorQuery;
        Cursor cursor;
        Cursor cursor2;
        Boolean boolValueOf;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        Cursor cursor3 = null;
        try {
            try {
                cursorQuery = e_().query("events", (String[]) new ArrayList(Arrays.asList("lifetime_count", "current_bundle_count", "last_fire_timestamp", "last_bundled_timestamp", "last_bundled_day", "last_sampled_complex_event_id", "last_sampling_rate", "last_exempt_from_sampling", "current_session_count")).toArray(new String[0]), "app_id=? and name=?", new String[]{str, str2}, null, null, null);
                try {
                    if (!cursorQuery.moveToFirst()) {
                        cursorQuery.close();
                        return null;
                    }
                    long j10 = cursorQuery.getLong(0);
                    long j11 = cursorQuery.getLong(1);
                    long j12 = cursorQuery.getLong(2);
                    long j13 = cursorQuery.isNull(3) ? 0L : cursorQuery.getLong(3);
                    Long lValueOf = cursorQuery.isNull(4) ? null : Long.valueOf(cursorQuery.getLong(4));
                    Long lValueOf2 = cursorQuery.isNull(5) ? null : Long.valueOf(cursorQuery.getLong(5));
                    Long lValueOf3 = cursorQuery.isNull(6) ? null : Long.valueOf(cursorQuery.getLong(6));
                    if (cursorQuery.isNull(7)) {
                        boolValueOf = null;
                    } else {
                        try {
                            boolValueOf = Boolean.valueOf(cursorQuery.getLong(7) == 1);
                        } catch (SQLiteException e10) {
                            e = e10;
                        }
                    }
                    cursor2 = cursorQuery;
                    try {
                        zzbb zzbbVar = new zzbb(str, str2, j10, j11, cursorQuery.isNull(8) ? 0L : cursorQuery.getLong(8), j12, j13, lValueOf, lValueOf2, lValueOf3, boolValueOf);
                        if (cursor2.moveToNext()) {
                            zzj().zzg().zza("Got multiple records for event aggregates, expected one. appId", zzgb.zza(str));
                        }
                        cursor2.close();
                        return zzbbVar;
                    } catch (SQLiteException e11) {
                        e = e11;
                        cursorQuery = cursor2;
                    } catch (Throwable th) {
                        th = th;
                        cursor3 = cursor2;
                        if (cursor3 != null) {
                            cursor3.close();
                        }
                        throw th;
                    }
                } catch (SQLiteException e12) {
                    e = e12;
                } catch (Throwable th2) {
                    th = th2;
                    cursor2 = cursorQuery;
                }
            } catch (Throwable th3) {
                th = th3;
                cursor3 = cursor;
            }
        } catch (SQLiteException e13) {
            e = e13;
            cursorQuery = null;
        } catch (Throwable th4) {
            th = th4;
        }
        zzj().zzg().zza("Error querying events. appId", zzgb.zza(str), zzi().zza(str2), e);
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final long zza(zzft.zzj zzjVar) throws IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        byte[] bArrZzbv = zzjVar.zzbv();
        long jZza = g_().zza(bArrZzbv);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjVar.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(jZza));
        contentValues.put(TtmlNode.TAG_METADATA, bArrZzbv);
        try {
            e_().insertWithOnConflict("raw_events_metadata", null, contentValues, 4);
            return jZza;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzgb.zza(zzjVar.zzx()), e10);
            throw e10;
        }
    }

    final Map<Integer, List<zzfh.zzb>> zzf(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            try {
                Cursor cursorQuery = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    Map<Integer, List<zzfh.zzb>> mapEmptyMap = Collections.emptyMap();
                    cursorQuery.close();
                    return mapEmptyMap;
                }
                do {
                    try {
                        zzfh.zzb zzbVar = (zzfh.zzb) ((com.google.android.gms.internal.measurement.zzjt) ((zzfh.zzb.zza) zznm.zza(zzfh.zzb.zzc(), cursorQuery.getBlob(1))).zzah());
                        int i10 = cursorQuery.getInt(0);
                        List arrayList = (List) arrayMap.get(Integer.valueOf(i10));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                            arrayMap.put(Integer.valueOf(i10), arrayList);
                        }
                        arrayList.add(zzbVar);
                    } catch (IOException e10) {
                        zzj().zzg().zza("Failed to merge filter. appId", zzgb.zza(str), e10);
                    }
                } while (cursorQuery.moveToNext());
                cursorQuery.close();
                return arrayMap;
            } catch (SQLiteException e11) {
                zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e11);
                Map<Integer, List<zzfh.zzb>> mapEmptyMap2 = Collections.emptyMap();
                if (0 != 0) {
                    cursor.close();
                }
                return mapEmptyMap2;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        return zza("select first_open_count from app2 where app_id=?", new String[]{str}, -1L);
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            try {
                Cursor cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j10 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j10;
                }
                throw new SQLiteException("Database returned empty set");
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j10) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    long j11 = cursorRawQuery.getLong(0);
                    cursorRawQuery.close();
                    return j11;
                }
                cursorRawQuery.close();
                return j10;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0097, code lost:
    
        zzj().zzg().zza("Read more than the max allowed user properties, ignoring excess", 1000);
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011b  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zznq> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x008b: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:29:0x008b */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzft.zze, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r4 = 0
            r3[r4] = r8     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            r6 = 1
            r3[r6] = r5     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L73 android.database.sqlite.SQLiteException -> L75
            boolean r2 = r1.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            if (r2 != 0) goto L35
            com.google.android.gms.measurement.internal.zzgb r8 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r8 = r8.zzp()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L35:
            byte[] r2 = r1.getBlob(r4)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            long r3 = r1.getLong(r6)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze$zza r4 = com.google.android.gms.internal.measurement.zzft.zze.zze()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzlf r2 = com.google.android.gms.measurement.internal.zznm.zza(r4, r2)     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze$zza r2 = (com.google.android.gms.internal.measurement.zzft.zze.zza) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzlg r2 = r2.zzah()     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzjt r2 = (com.google.android.gms.internal.measurement.zzjt) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.internal.measurement.zzft$zze r2 = (com.google.android.gms.internal.measurement.zzft.zze) r2     // Catch: java.io.IOException -> L5b android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r8
        L5b:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzgb r3 = r7.zzj()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r3 = r3.zzg()     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzgb.zza(r8)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r3.zza(r4, r8, r9, r2)     // Catch: android.database.sqlite.SQLiteException -> L71 java.lang.Throwable -> L8a
            r1.close()
            return r0
        L71:
            r8 = move-exception
            goto L77
        L73:
            r8 = move-exception
            goto L8c
        L75:
            r8 = move-exception
            r1 = r0
        L77:
            com.google.android.gms.measurement.internal.zzgb r9 = r7.zzj()     // Catch: java.lang.Throwable -> L8a
            com.google.android.gms.measurement.internal.zzgd r9 = r9.zzg()     // Catch: java.lang.Throwable -> L8a
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch: java.lang.Throwable -> L8a
            if (r1 == 0) goto L89
            r1.close()
        L89:
            return r0
        L8a:
            r8 = move-exception
            r0 = r1
        L8c:
            if (r0 == 0) goto L91
            r0.close()
        L91:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    @WorkerThread
    public final zzao zza(long j10, String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        return zza(j10, str, 1L, false, false, z12, false, z14, z15);
    }

    @WorkerThread
    public final zzao zza(long j10, String str, long j11, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        String[] strArr = {str};
        zzao zzaoVar = new zzao();
        Cursor cursor = null;
        try {
            try {
                SQLiteDatabase sQLiteDatabaseE_ = e_();
                Cursor cursorQuery = sQLiteDatabaseE_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count", "daily_realtime_dcu_count"}, "app_id=?", new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst()) {
                    zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzgb.zza(str));
                    cursorQuery.close();
                    return zzaoVar;
                }
                if (cursorQuery.getLong(0) == j10) {
                    zzaoVar.zzb = cursorQuery.getLong(1);
                    zzaoVar.zza = cursorQuery.getLong(2);
                    zzaoVar.zzc = cursorQuery.getLong(3);
                    zzaoVar.zzd = cursorQuery.getLong(4);
                    zzaoVar.zze = cursorQuery.getLong(5);
                    if (zzon.zza() && zze().zza(zzbh.zzcs)) {
                        zzaoVar.zzf = cursorQuery.getLong(6);
                    }
                }
                if (z10) {
                    zzaoVar.zzb += j11;
                }
                if (z11) {
                    zzaoVar.zza += j11;
                }
                if (z12) {
                    zzaoVar.zzc += j11;
                }
                if (z13) {
                    zzaoVar.zzd += j11;
                }
                if (z14) {
                    zzaoVar.zze += j11;
                }
                if (zzon.zza() && zze().zza(zzbh.zzcs) && z15) {
                    zzaoVar.zzf += j11;
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("day", Long.valueOf(j10));
                contentValues.put("daily_public_events_count", Long.valueOf(zzaoVar.zza));
                contentValues.put("daily_events_count", Long.valueOf(zzaoVar.zzb));
                contentValues.put("daily_conversions_count", Long.valueOf(zzaoVar.zzc));
                contentValues.put("daily_error_events_count", Long.valueOf(zzaoVar.zzd));
                contentValues.put("daily_realtime_events_count", Long.valueOf(zzaoVar.zze));
                if (zzon.zza() && zze().zza(zzbh.zzcs)) {
                    contentValues.put("daily_realtime_dcu_count", Long.valueOf(zzaoVar.zzf));
                }
                sQLiteDatabaseE_.update("apps", contentValues, "app_id=?", strArr);
                cursorQuery.close();
                return zzaoVar;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error updating daily counts. appId", zzgb.zza(str), e10);
                if (0 != 0) {
                    cursor.close();
                }
                return zzaoVar;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.measurement.internal.zznq zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.e_()     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r1 = 0
            r14[r1] = r19     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r2 = 1
            r14[r2] = r8     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch: java.lang.Throwable -> L80 android.database.sqlite.SQLiteException -> L84
            boolean r3 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7c
            if (r3 != 0) goto L3d
            r10.close()
            return r9
        L3d:
            long r5 = r10.getLong(r1)     // Catch: java.lang.Throwable -> L78 android.database.sqlite.SQLiteException -> L7c
            r11 = r18
            java.lang.Object r7 = r11.zza(r10, r2)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            if (r7 != 0) goto L4d
            r10.close()
            return r9
        L4d:
            java.lang.String r3 = r10.getString(r0)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zznq r0 = new com.google.android.gms.measurement.internal.zznq     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            boolean r1 = r10.moveToNext()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            if (r1 == 0) goto L72
            com.google.android.gms.measurement.internal.zzgb r1 = r18.zzj()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgb.zza(r19)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
            r1.zza(r2, r3)     // Catch: android.database.sqlite.SQLiteException -> L76 java.lang.Throwable -> La7
        L72:
            r10.close()
            return r0
        L76:
            r0 = move-exception
            goto L88
        L78:
            r0 = move-exception
            r11 = r18
            goto La8
        L7c:
            r0 = move-exception
            r11 = r18
            goto L88
        L80:
            r0 = move-exception
            r11 = r18
            goto La9
        L84:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L88:
            com.google.android.gms.measurement.internal.zzgb r1 = r18.zzj()     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: java.lang.Throwable -> La7
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzgb.zza(r19)     // Catch: java.lang.Throwable -> La7
            com.google.android.gms.measurement.internal.zzfw r4 = r18.zzi()     // Catch: java.lang.Throwable -> La7
            java.lang.String r4 = r4.zzc(r8)     // Catch: java.lang.Throwable -> La7
            r1.zza(r2, r3, r4, r0)     // Catch: java.lang.Throwable -> La7
            if (r10 == 0) goto La6
            r10.close()
        La6:
            return r9
        La7:
            r0 = move-exception
        La8:
            r9 = r10
        La9:
            if (r9 == 0) goto Lae
            r9.close()
        Lae:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zznq");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        try {
            long jZzb = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int iMax = Math.max(0, Math.min(2000, zze().zzb(str, zzbh.zzaf)));
            if (jZzb <= iMax) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                Integer num = list.get(i10);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String str2 = "(" + TextUtils.join(",", arrayList) + ")";
            StringBuilder sb = new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb.append(str2);
            sb.append(" order by rowid desc limit -1 offset ?)");
            return sQLiteDatabaseE_.delete("audience_filter_values", sb.toString(), new String[]{str, Integer.toString(iMax)}) > 0;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Database error querying filters. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    @VisibleForTesting
    @WorkerThread
    private final Object zza(Cursor cursor, int i10) {
        int type = cursor.getType(i10);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        }
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i10));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i10));
        }
        if (type == 3) {
            return cursor.getString(i10);
        }
        if (type != 4) {
            zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
            return null;
        }
        zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzaq<T> r5) throws java.lang.Throwable {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch: java.lang.Throwable -> L2a android.database.sqlite.SQLiteException -> L2c
            boolean r4 = r3.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L28 java.lang.Throwable -> L41
            if (r4 != 0) goto L20
            com.google.android.gms.measurement.internal.zzgb r4 = r2.zzj()     // Catch: android.database.sqlite.SQLiteException -> L28 java.lang.Throwable -> L41
            com.google.android.gms.measurement.internal.zzgd r4 = r4.zzp()     // Catch: android.database.sqlite.SQLiteException -> L28 java.lang.Throwable -> L41
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch: android.database.sqlite.SQLiteException -> L28 java.lang.Throwable -> L41
            r3.close()
            return r0
        L20:
            java.lang.Object r4 = r5.zza(r3)     // Catch: android.database.sqlite.SQLiteException -> L28 java.lang.Throwable -> L41
            r3.close()
            return r4
        L28:
            r4 = move-exception
            goto L2e
        L2a:
            r4 = move-exception
            goto L43
        L2c:
            r4 = move-exception
            r3 = r0
        L2e:
            com.google.android.gms.measurement.internal.zzgb r5 = r2.zzj()     // Catch: java.lang.Throwable -> L41
            com.google.android.gms.measurement.internal.zzgd r5 = r5.zzg()     // Catch: java.lang.Throwable -> L41
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L40
            r3.close()
        L40:
            return r0
        L41:
            r4 = move-exception
            r0 = r3
        L43:
            if (r0 == 0) goto L48
            r0.close()
        L48:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzaq):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r5v0, types: [long] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String zza(long r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r4.zzt()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e_()     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            r6 = 0
            r3[r6] = r5     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch: java.lang.Throwable -> L3c android.database.sqlite.SQLiteException -> L3e
            boolean r1 = r5.moveToFirst()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            if (r1 != 0) goto L32
            com.google.android.gms.measurement.internal.zzgb r6 = r4.zzj()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.zzgd r6 = r6.zzp()     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r0
        L32:
            java.lang.String r6 = r5.getString(r6)     // Catch: android.database.sqlite.SQLiteException -> L3a java.lang.Throwable -> L53
            r5.close()
            return r6
        L3a:
            r6 = move-exception
            goto L40
        L3c:
            r6 = move-exception
            goto L55
        L3e:
            r6 = move-exception
            r5 = r0
        L40:
            com.google.android.gms.measurement.internal.zzgb r1 = r4.zzj()     // Catch: java.lang.Throwable -> L53
            com.google.android.gms.measurement.internal.zzgd r1 = r1.zzg()     // Catch: java.lang.Throwable -> L53
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch: java.lang.Throwable -> L53
            if (r5 == 0) goto L52
            r5.close()
        L52:
            return r0
        L53:
            r6 = move-exception
            r0 = r5
        L55:
            if (r0 == 0) goto L5a
            r0.close()
        L5a:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(long):java.lang.String");
    }

    @WorkerThread
    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursorRawQuery = null;
        try {
            try {
                cursorRawQuery = e_().rawQuery(str, strArr);
                if (cursorRawQuery.moveToFirst()) {
                    String string = cursorRawQuery.getString(0);
                    cursorRawQuery.close();
                    return string;
                }
                cursorRawQuery.close();
                return str2;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Database error", str, e10);
                throw e10;
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0181 A[EDGE_INSN: B:91:0x0181->B:72:0x0181 BREAK  A[LOOP:0: B:17:0x0054->B:71:0x017e], SYNTHETIC] */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzft.zzj, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 425
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, int, int):java.util.List");
    }

    @WorkerThread
    public final List<zzac> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + ProxyConfig.MATCH_ALL_SCHEMES);
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0050, code lost:
    
        zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.measurement.internal.zzac> zza(java.lang.String r27, java.lang.String[] r28) {
        /*
            Method dump skipped, instruction units count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzan.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    @VisibleForTesting
    @WorkerThread
    final void zza(List<Long> list) {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzan()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error incrementing retry count. error", e10);
            }
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else {
            if (obj instanceof Double) {
                contentValues.put(str, (Double) obj);
                return;
            }
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    final void zza(String str, List<zzfh.zza> list) {
        boolean z10;
        boolean z11;
        Preconditions.checkNotNull(list);
        for (int i10 = 0; i10 < list.size(); i10++) {
            zzfh.zza.C0197zza c0197zzaZzby = list.get(i10).zzby();
            if (c0197zzaZzby.zza() != 0) {
                for (int i11 = 0; i11 < c0197zzaZzby.zza(); i11++) {
                    zzfh.zzb.zza zzaVarZzby = c0197zzaZzby.zza(i11).zzby();
                    zzfh.zzb.zza zzaVar = (zzfh.zzb.zza) ((zzjt.zza) zzaVarZzby.clone());
                    String strZzb = zzit.zzb(zzaVarZzby.zzb());
                    if (strZzb != null) {
                        zzaVar.zza(strZzb);
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    for (int i12 = 0; i12 < zzaVarZzby.zza(); i12++) {
                        zzfh.zzc zzcVarZza = zzaVarZzby.zza(i12);
                        String strZza = zzis.zza(zzcVarZza.zze());
                        if (strZza != null) {
                            zzaVar.zza(i12, (zzfh.zzc) ((com.google.android.gms.internal.measurement.zzjt) zzcVarZza.zzby().zza(strZza).zzah()));
                            z11 = true;
                        }
                    }
                    if (z11) {
                        c0197zzaZzby = c0197zzaZzby.zza(i11, zzaVar);
                        list.set(i10, (zzfh.zza) ((com.google.android.gms.internal.measurement.zzjt) c0197zzaZzby.zzah()));
                    }
                }
            }
            if (c0197zzaZzby.zzb() != 0) {
                for (int i13 = 0; i13 < c0197zzaZzby.zzb(); i13++) {
                    zzfh.zze zzeVarZzb = c0197zzaZzby.zzb(i13);
                    String strZza2 = zziv.zza(zzeVarZzb.zze());
                    if (strZza2 != null) {
                        c0197zzaZzby = c0197zzaZzby.zza(i13, zzeVarZzb.zzby().zza(strZza2));
                        list.set(i10, (zzfh.zza) ((com.google.android.gms.internal.measurement.zzjt) c0197zzaZzby.zzah()));
                    }
                }
            }
        }
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase sQLiteDatabaseE_ = e_();
        sQLiteDatabaseE_.beginTransaction();
        try {
            zzak();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase sQLiteDatabaseE_2 = e_();
            sQLiteDatabaseE_2.delete("property_filters", "app_id=?", new String[]{str});
            sQLiteDatabaseE_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzfh.zza zzaVar2 : list) {
                zzak();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zzaVar2);
                if (!zzaVar2.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzgb.zza(str));
                } else {
                    int iZza = zzaVar2.zza();
                    Iterator<zzfh.zzb> it = zzaVar2.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                break;
                            }
                        } else {
                            Iterator<zzfh.zze> it2 = zzaVar2.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzgb.zza(str), Integer.valueOf(iZza));
                                        break;
                                    }
                                } else {
                                    Iterator<zzfh.zzb> it3 = zzaVar2.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, iZza, it3.next())) {
                                                z10 = false;
                                                break;
                                            }
                                        } else {
                                            z10 = true;
                                            break;
                                        }
                                    }
                                    if (z10) {
                                        Iterator<zzfh.zze> it4 = zzaVar2.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, iZza, it4.next())) {
                                                    z10 = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z10) {
                                        zzak();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase sQLiteDatabaseE_3 = e_();
                                        sQLiteDatabaseE_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                        sQLiteDatabaseE_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(iZza)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzfh.zza zzaVar3 : list) {
                arrayList.add(zzaVar3.zzg() ? Integer.valueOf(zzaVar3.zza()) : null);
            }
            zzb(str, arrayList);
            sQLiteDatabaseE_.setTransactionSuccessful();
        } finally {
            sQLiteDatabaseE_.endTransaction();
        }
    }

    @WorkerThread
    public final void zza(zzf zzfVar) {
        Preconditions.checkNotNull(zzfVar);
        zzt();
        zzak();
        String strZzaa = zzfVar.zzaa();
        Preconditions.checkNotNull(strZzaa);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", strZzaa);
        contentValues.put("app_instance_id", zzfVar.zzab());
        contentValues.put("gmp_app_id", zzfVar.zzaf());
        contentValues.put("resettable_device_id_hash", zzfVar.zzah());
        contentValues.put("last_bundle_index", Long.valueOf(zzfVar.zzt()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzfVar.zzu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzfVar.zzs()));
        contentValues.put(App.JsonKeys.APP_VERSION, zzfVar.zzad());
        contentValues.put("app_store", zzfVar.zzac());
        contentValues.put("gmp_version", Long.valueOf(zzfVar.zzq()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzfVar.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzfVar.zzap()));
        contentValues.put("day", Long.valueOf(zzfVar.zzm()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzfVar.zzk()));
        contentValues.put("daily_events_count", Long.valueOf(zzfVar.zzj()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzfVar.zzh()));
        contentValues.put("config_fetched_time", Long.valueOf(zzfVar.zzg()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzfVar.zzp()));
        contentValues.put("app_version_int", Long.valueOf(zzfVar.zze()));
        contentValues.put("firebase_instance_id", zzfVar.zzae());
        contentValues.put("daily_error_events_count", Long.valueOf(zzfVar.zzi()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzfVar.zzl()));
        contentValues.put("health_monitor_sample", zzfVar.zzag());
        contentValues.put("android_id", Long.valueOf(zzfVar.zzd()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzfVar.zzao()));
        contentValues.put("admob_app_id", zzfVar.zzy());
        contentValues.put("dynamite_version", Long.valueOf(zzfVar.zzo()));
        contentValues.put("session_stitching_token", zzfVar.zzaj());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzfVar.zzar()));
        contentValues.put("target_os_version", Long.valueOf(zzfVar.zzw()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzfVar.zzv()));
        if (zzpy.zza() && zze().zze(strZzaa, zzbh.zzcg)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzfVar.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzfVar.zzf()));
        }
        if (zzoh.zza() && zze().zze(strZzaa, zzbh.zzct)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzfVar.zzas()));
        }
        if (zzon.zza() && zze().zze(strZzaa, zzbh.zzco)) {
            contentValues.put("npa_metadata_value", zzfVar.zzx());
        }
        if (zzqv.zza() && zze().zze(strZzaa, zzbh.zzbt)) {
            zzq();
            if (zznt.zzf(strZzaa)) {
                contentValues.put("bundle_delivery_index", Long.valueOf(zzfVar.zzr()));
            }
        }
        if (zzqv.zza() && zze().zze(strZzaa, zzbh.zzbu)) {
            contentValues.put("sgtm_preview_key", zzfVar.zzak());
        }
        if (zzon.zza() && zze().zze(strZzaa, zzbh.zzcs)) {
            contentValues.put("dma_consent_state", Integer.valueOf(zzfVar.zzc()));
            contentValues.put("daily_realtime_dcu_count", Integer.valueOf(zzfVar.zzb()));
        }
        if (zznw.zza() && zze().zze(strZzaa, zzbh.zzda)) {
            contentValues.put("serialized_npa_metadata", zzfVar.zzai());
        }
        List<String> listZzal = zzfVar.zzal();
        if (listZzal != null) {
            if (listZzal.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", strZzaa);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", listZzal));
            }
        }
        if (zzoo.zza() && zze().zza(zzbh.zzbo) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (sQLiteDatabaseE_.update("apps", contentValues, "app_id = ?", new String[]{strZzaa}) == 0 && sQLiteDatabaseE_.insertWithOnConflict("apps", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzgb.zza(strZzaa));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing app. appId", zzgb.zza(strZzaa), e10);
        }
    }

    public final void zza(String str, zziq zziqVar) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zziqVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zziqVar.zzh());
        if (zzon.zza() && zze().zza(zzbh.zzco)) {
            contentValues.put("consent_source", Integer.valueOf(zziqVar.zza()));
            zza("consent_settings", "app_id", contentValues);
            return;
        }
        try {
            if (e_().insertWithOnConflict("consent_settings", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update consent setting (got -1). appId", zzgb.zza(str));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing consent setting. appId, error", zzgb.zza(str), e10);
        }
    }

    public final void zza(String str, zzax zzaxVar) {
        if (zzon.zza() && zze().zza(zzbh.zzco)) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zzaxVar);
            zzt();
            zzak();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("dma_consent_settings", zzaxVar.zzf());
            zza("consent_settings", "app_id", contentValues);
        }
    }

    @WorkerThread
    public final void zza(zzbb zzbbVar) {
        Preconditions.checkNotNull(zzbbVar);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbbVar.zza);
        contentValues.put("name", zzbbVar.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbbVar.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbbVar.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbbVar.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbbVar.zzg));
        contentValues.put("last_bundled_day", zzbbVar.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbbVar.zzi);
        contentValues.put("last_sampling_rate", zzbbVar.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbbVar.zze));
        Boolean bool = zzbbVar.zzk;
        contentValues.put("last_exempt_from_sampling", (bool == null || !bool.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict("events", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzgb.zza(zzbbVar.zza));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzgb.zza(zzbbVar.zza), e10);
        }
    }

    @WorkerThread
    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase sQLiteDatabaseE_ = e_();
            if (contentValues.getAsString(str2) == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzgb.zza(str2));
                return;
            }
            if (sQLiteDatabaseE_.update(str, contentValues, str2 + " = ?", new String[]{r1}) == 0 && sQLiteDatabaseE_.insertWithOnConflict(str, null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzgb.zza(str), zzgb.zza(str2));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing into table. key", zzgb.zza(str), zzgb.zza(str2), e10);
        }
    }

    @WorkerThread
    public final boolean zza(zzft.zzj zzjVar, boolean z10) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzjVar);
        Preconditions.checkNotEmpty(zzjVar.zzx());
        Preconditions.checkState(zzjVar.zzbe());
        zzv();
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzjVar.zzl() < jCurrentTimeMillis - zzae.zzm() || zzjVar.zzl() > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzgb.zza(zzjVar.zzx()), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzjVar.zzl()));
        }
        try {
            byte[] bArrZzb = g_().zzb(zzjVar.zzbv());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(bArrZzb.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzjVar.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzjVar.zzl()));
            contentValues.put("data", bArrZzb);
            contentValues.put("has_realtime", Integer.valueOf(z10 ? 1 : 0));
            if (zzjVar.zzbl()) {
                contentValues.put("retry_count", Integer.valueOf(zzjVar.zzf()));
            }
            try {
                if (e_().insert("queue", null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzgb.zza(zzjVar.zzx()));
                return false;
            } catch (SQLiteException e10) {
                zzj().zzg().zza("Error storing bundle. appId", zzgb.zza(zzjVar.zzx()), e10);
                return false;
            }
        } catch (IOException e11) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzgb.zza(zzjVar.zzx()), e11);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i10, zzfh.zzb zzbVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbVar);
        if (zzbVar.zzf().isEmpty()) {
            zzj().zzu().zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i10), String.valueOf(zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null));
            return false;
        }
        byte[] bArrZzbv = zzbVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzbVar.zzl() ? Integer.valueOf(zzbVar.zzb()) : null);
        contentValues.put("event_name", zzbVar.zzf());
        contentValues.put("session_scoped", zzbVar.zzm() ? Boolean.valueOf(zzbVar.zzj()) : null);
        contentValues.put("data", bArrZzbv);
        try {
            if (e_().insertWithOnConflict("event_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzgb.zza(str));
            return true;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing event filter. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i10, zzfh.zze zzeVar) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzeVar);
        if (zzeVar.zze().isEmpty()) {
            zzj().zzu().zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzgb.zza(str), Integer.valueOf(i10), String.valueOf(zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null));
            return false;
        }
        byte[] bArrZzbv = zzeVar.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i10));
        contentValues.put("filter_id", zzeVar.zzi() ? Integer.valueOf(zzeVar.zza()) : null);
        contentValues.put("property_name", zzeVar.zze());
        contentValues.put("session_scoped", zzeVar.zzj() ? Boolean.valueOf(zzeVar.zzh()) : null);
        contentValues.put("data", bArrZzbv);
        try {
            if (e_().insertWithOnConflict("property_filters", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing property filter. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean zza(zzay zzayVar, long j10, boolean z10) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzayVar);
        Preconditions.checkNotEmpty(zzayVar.zza);
        byte[] bArrZzbv = g_().zza(zzayVar).zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzayVar.zza);
        contentValues.put("name", zzayVar.zzb);
        contentValues.put("timestamp", Long.valueOf(zzayVar.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j10));
        contentValues.put("data", bArrZzbv);
        contentValues.put("realtime", Integer.valueOf(z10 ? 1 : 0));
        try {
            if (e_().insert("raw_events", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzgb.zza(zzayVar.zza));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing raw event. appId", zzgb.zza(zzayVar.zza), e10);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(String str, zzmv zzmvVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmvVar);
        Preconditions.checkNotEmpty(str);
        long jCurrentTimeMillis = zzb().currentTimeMillis();
        if (zzmvVar.zzb < jCurrentTimeMillis - zzae.zzm() || zzmvVar.zzb > zzae.zzm() + jCurrentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzgb.zza(str), Long.valueOf(jCurrentTimeMillis), Long.valueOf(zzmvVar.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmvVar.zza);
        contentValues.put(TransactionInfo.JsonKeys.SOURCE, Integer.valueOf(zzmvVar.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmvVar.zzb));
        try {
            if (e_().insert("trigger_uris", null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    public final boolean zza(String str, Long l10, long j10, zzft.zze zzeVar) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzeVar);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l10);
        byte[] bArrZzbv = zzeVar.zzbv();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l10);
        contentValues.put("children_to_process", Long.valueOf(j10));
        contentValues.put("main_event", bArrZzbv);
        try {
            if (e_().insertWithOnConflict("main_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing complex main event. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzac zzacVar) {
        Preconditions.checkNotNull(zzacVar);
        zzt();
        zzak();
        String str = zzacVar.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzacVar.zzc.zza) == null && zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
            return false;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzacVar.zzb);
        contentValues.put("name", zzacVar.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzacVar.zzc.zza()));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, Boolean.valueOf(zzacVar.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzacVar.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzacVar.zzh));
        zzq();
        contentValues.put("timed_out_event", zznt.zza((Parcelable) zzacVar.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzacVar.zzd));
        zzq();
        contentValues.put("triggered_event", zznt.zza((Parcelable) zzacVar.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzacVar.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzacVar.zzj));
        zzq();
        contentValues.put("expired_event", zznt.zza((Parcelable) zzacVar.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzgb.zza(str));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing conditional user property", zzgb.zza(str), e10);
        }
        return true;
    }

    final boolean zza(String str, Bundle bundle) {
        zzt();
        zzak();
        byte[] bArrZzbv = g_().zza(new zzay(this.zzu, "", str, "dep", 0L, 0L, bundle)).zzbv();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(bArrZzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("parameters", bArrZzbv);
        try {
            if (e_().insertWithOnConflict("default_event_params", null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzgb.zza(str));
            return false;
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzgb.zza(str), e10);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zznq zznqVar) {
        Preconditions.checkNotNull(zznqVar);
        zzt();
        zzak();
        if (zze(zznqVar.zza, zznqVar.zzc) == null) {
            if (zznt.zzh(zznqVar.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zznqVar.zza}) >= zze().zza(zznqVar.zza, zzbh.zzag, 25, 100)) {
                    return false;
                }
            } else if (!"_npa".equals(zznqVar.zzc) && zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zznqVar.zza, zznqVar.zzb}) >= 25) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zznqVar.zza);
        contentValues.put("origin", zznqVar.zzb);
        contentValues.put("name", zznqVar.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zznqVar.zzd));
        zza(contentValues, "value", zznqVar.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzgb.zza(zznqVar.zza));
            }
        } catch (SQLiteException e10) {
            zzj().zzg().zza("Error storing user property. appId", zzgb.zza(zznqVar.zza), e10);
        }
        return true;
    }
}
