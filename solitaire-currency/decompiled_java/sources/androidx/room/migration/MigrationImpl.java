package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Migration.kt */
/* JADX INFO: loaded from: classes2.dex */
final class MigrationImpl extends Migration {

    @NotNull
    private final l<SupportSQLiteDatabase, k0> migrateCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public MigrationImpl(int i10, int i11, @NotNull l<? super SupportSQLiteDatabase, k0> migrateCallback) {
        super(i10, i11);
        t.i(migrateCallback, "migrateCallback");
        this.migrateCallback = migrateCallback;
    }

    @NotNull
    public final l<SupportSQLiteDatabase, k0> getMigrateCallback() {
        return this.migrateCallback;
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NotNull SupportSQLiteDatabase database) {
        t.i(database, "database");
        this.migrateCallback.invoke(database);
    }
}
