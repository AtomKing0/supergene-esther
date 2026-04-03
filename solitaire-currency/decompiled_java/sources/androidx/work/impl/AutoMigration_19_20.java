package androidx.work.impl;

import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkDatabaseMigrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutoMigration_19_20 implements AutoMigrationSpec {
    @Override // androidx.room.migration.AutoMigrationSpec
    public void onPostMigrate(@NotNull SupportSQLiteDatabase db2) {
        t.i(db2, "db");
        db2.execSQL("UPDATE WorkSpec SET `last_enqueue_time` = -1 WHERE `last_enqueue_time` = 0");
    }
}
