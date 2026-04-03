package androidx.room;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RoomOpenHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class RoomOpenHelper extends SupportSQLiteOpenHelper.Callback {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private DatabaseConfiguration configuration;

    @NotNull
    private final Delegate delegate;

    @NotNull
    private final String identityHash;

    @NotNull
    private final String legacyHash;

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean hasEmptySchema$room_runtime_release(@NotNull SupportSQLiteDatabase db2) {
            kotlin.jvm.internal.t.i(db2, "db");
            Cursor cursorQuery = db2.query("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                Cursor cursor = cursorQuery;
                boolean z10 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) == 0) {
                        z10 = true;
                    }
                }
                f9.c.a(cursorQuery, null);
                return z10;
            } finally {
            }
        }

        public final boolean hasRoomMasterTable$room_runtime_release(@NotNull SupportSQLiteDatabase db2) {
            kotlin.jvm.internal.t.i(db2, "db");
            Cursor cursorQuery = db2.query("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                Cursor cursor = cursorQuery;
                boolean z10 = false;
                if (cursor.moveToFirst()) {
                    if (cursor.getInt(0) != 0) {
                        z10 = true;
                    }
                }
                f9.c.a(cursorQuery, null);
                return z10;
            } finally {
            }
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static abstract class Delegate {
        public final int version;

        public Delegate(int i10) {
            this.version = i10;
        }

        public abstract void createAllTables(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void dropAllTables(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onCreate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public abstract void onOpen(@NotNull SupportSQLiteDatabase supportSQLiteDatabase);

        public void onPostMigrate(@NotNull SupportSQLiteDatabase database) {
            kotlin.jvm.internal.t.i(database, "database");
        }

        public void onPreMigrate(@NotNull SupportSQLiteDatabase database) {
            kotlin.jvm.internal.t.i(database, "database");
        }

        @NotNull
        public ValidationResult onValidateSchema(@NotNull SupportSQLiteDatabase db2) {
            kotlin.jvm.internal.t.i(db2, "db");
            validateMigration(db2);
            return new ValidationResult(true, null);
        }

        protected void validateMigration(@NotNull SupportSQLiteDatabase db2) {
            kotlin.jvm.internal.t.i(db2, "db");
            throw new UnsupportedOperationException("validateMigration is deprecated");
        }
    }

    /* JADX INFO: compiled from: RoomOpenHelper.kt */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static class ValidationResult {

        @Nullable
        public final String expectedFoundMsg;
        public final boolean isValid;

        public ValidationResult(boolean z10, @Nullable String str) {
            this.isValid = z10;
            this.expectedFoundMsg = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@NotNull DatabaseConfiguration configuration, @NotNull Delegate delegate, @NotNull String identityHash, @NotNull String legacyHash) {
        super(delegate.version);
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(identityHash, "identityHash");
        kotlin.jvm.internal.t.i(legacyHash, "legacyHash");
        this.configuration = configuration;
        this.delegate = delegate;
        this.identityHash = identityHash;
        this.legacyHash = legacyHash;
    }

    private final void checkIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (!Companion.hasRoomMasterTable$room_runtime_release(supportSQLiteDatabase)) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(supportSQLiteDatabase);
            if (validationResultOnValidateSchema.isValid) {
                this.delegate.onPostMigrate(supportSQLiteDatabase);
                updateIdentity(supportSQLiteDatabase);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
        }
        Cursor cursorQuery = supportSQLiteDatabase.query(new SimpleSQLiteQuery(RoomMasterTable.READ_QUERY));
        try {
            Cursor cursor = cursorQuery;
            String string = cursor.moveToFirst() ? cursor.getString(0) : null;
            f9.c.a(cursorQuery, null);
            if (kotlin.jvm.internal.t.d(this.identityHash, string) || kotlin.jvm.internal.t.d(this.legacyHash, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.identityHash + ", found: " + string);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                f9.c.a(cursorQuery, th);
                throw th2;
            }
        }
    }

    private final void createMasterTableIfNotExists(SupportSQLiteDatabase supportSQLiteDatabase) {
        supportSQLiteDatabase.execSQL(RoomMasterTable.CREATE_QUERY);
    }

    private final void updateIdentity(SupportSQLiteDatabase supportSQLiteDatabase) {
        createMasterTableIfNotExists(supportSQLiteDatabase);
        supportSQLiteDatabase.execSQL(RoomMasterTable.createInsertQuery(this.identityHash));
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onConfigure(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        super.onConfigure(db2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onCreate(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        boolean zHasEmptySchema$room_runtime_release = Companion.hasEmptySchema$room_runtime_release(db2);
        this.delegate.createAllTables(db2);
        if (!zHasEmptySchema$room_runtime_release) {
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(db2);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
        }
        updateIdentity(db2);
        this.delegate.onCreate(db2);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onDowngrade(@NotNull SupportSQLiteDatabase db2, int i10, int i11) {
        kotlin.jvm.internal.t.i(db2, "db");
        onUpgrade(db2, i10, i11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onOpen(@NotNull SupportSQLiteDatabase db2) {
        kotlin.jvm.internal.t.i(db2, "db");
        super.onOpen(db2);
        checkIdentity(db2);
        this.delegate.onOpen(db2);
        this.configuration = null;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
    public void onUpgrade(@NotNull SupportSQLiteDatabase db2, int i10, int i11) {
        List<Migration> listFindMigrationPath;
        kotlin.jvm.internal.t.i(db2, "db");
        DatabaseConfiguration databaseConfiguration = this.configuration;
        boolean z10 = false;
        if (databaseConfiguration != null && (listFindMigrationPath = databaseConfiguration.migrationContainer.findMigrationPath(i10, i11)) != null) {
            this.delegate.onPreMigrate(db2);
            Iterator<T> it = listFindMigrationPath.iterator();
            while (it.hasNext()) {
                ((Migration) it.next()).migrate(db2);
            }
            ValidationResult validationResultOnValidateSchema = this.delegate.onValidateSchema(db2);
            if (!validationResultOnValidateSchema.isValid) {
                throw new IllegalStateException("Migration didn't properly handle: " + validationResultOnValidateSchema.expectedFoundMsg);
            }
            this.delegate.onPostMigrate(db2);
            updateIdentity(db2);
            z10 = true;
        }
        if (z10) {
            return;
        }
        DatabaseConfiguration databaseConfiguration2 = this.configuration;
        if (databaseConfiguration2 != null && !databaseConfiguration2.isMigrationRequired(i10, i11)) {
            this.delegate.dropAllTables(db2);
            this.delegate.createAllTables(db2);
            return;
        }
        throw new IllegalStateException("A migration from " + i10 + " to " + i11 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RoomOpenHelper(@NotNull DatabaseConfiguration configuration, @NotNull Delegate delegate, @NotNull String legacyHash) {
        this(configuration, delegate, "", legacyHash);
        kotlin.jvm.internal.t.i(configuration, "configuration");
        kotlin.jvm.internal.t.i(delegate, "delegate");
        kotlin.jvm.internal.t.i(legacyHash, "legacyHash");
    }
}
