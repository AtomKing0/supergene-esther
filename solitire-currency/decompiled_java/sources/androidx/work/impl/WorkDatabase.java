package androidx.work.impl;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.work.Clock;
import androidx.work.Data;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.model.Dependency;
import androidx.work.impl.model.DependencyDao;
import androidx.work.impl.model.Preference;
import androidx.work.impl.model.PreferenceDao;
import androidx.work.impl.model.RawWorkInfoDao;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkName;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkProgress;
import androidx.work.impl.model.WorkProgressDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTag;
import androidx.work.impl.model.WorkTagDao;
import androidx.work.impl.model.WorkTypeConverters;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkDatabase.kt */
/* JADX INFO: loaded from: classes2.dex */
@TypeConverters({Data.class, WorkTypeConverters.class})
@Database(autoMigrations = {@AutoMigration(from = 13, to = 14), @AutoMigration(from = 14, spec = AutoMigration_14_15.class, to = 15), @AutoMigration(from = 16, to = 17), @AutoMigration(from = 17, to = 18), @AutoMigration(from = 18, to = 19), @AutoMigration(from = 19, spec = AutoMigration_19_20.class, to = 20)}, entities = {Dependency.class, WorkSpec.class, WorkTag.class, SystemIdInfo.class, WorkName.class, WorkProgress.class, Preference.class}, version = 20)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class WorkDatabase extends RoomDatabase {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: WorkDatabase.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final SupportSQLiteOpenHelper create$lambda$0(Context context, SupportSQLiteOpenHelper.Configuration configuration) {
            t.i(context, "$context");
            t.i(configuration, "configuration");
            SupportSQLiteOpenHelper.Configuration.Builder builder = SupportSQLiteOpenHelper.Configuration.Companion.builder(context);
            builder.name(configuration.name).callback(configuration.callback).noBackupDirectory(true).allowDataLossOnRecovery(true);
            return new FrameworkSQLiteOpenHelperFactory().create(builder.build());
        }

        @NotNull
        public final WorkDatabase create(@NotNull final Context context, @NotNull Executor queryExecutor, @NotNull Clock clock, boolean z10) {
            t.i(context, "context");
            t.i(queryExecutor, "queryExecutor");
            t.i(clock, "clock");
            return (WorkDatabase) (z10 ? Room.inMemoryDatabaseBuilder(context, WorkDatabase.class).allowMainThreadQueries() : Room.databaseBuilder(context, WorkDatabase.class, WorkDatabasePathHelperKt.WORK_DATABASE_NAME).openHelperFactory(new SupportSQLiteOpenHelper.Factory() { // from class: androidx.work.impl.f
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
                public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
                    return WorkDatabase.Companion.create$lambda$0(context, configuration);
                }
            })).setQueryExecutor(queryExecutor).addCallback(new CleanupCallback(clock)).addMigrations(Migration_1_2.INSTANCE).addMigrations(new RescheduleMigration(context, 2, 3)).addMigrations(Migration_3_4.INSTANCE).addMigrations(Migration_4_5.INSTANCE).addMigrations(new RescheduleMigration(context, 5, 6)).addMigrations(Migration_6_7.INSTANCE).addMigrations(Migration_7_8.INSTANCE).addMigrations(Migration_8_9.INSTANCE).addMigrations(new WorkMigration9To10(context)).addMigrations(new RescheduleMigration(context, 10, 11)).addMigrations(Migration_11_12.INSTANCE).addMigrations(Migration_12_13.INSTANCE).addMigrations(Migration_15_16.INSTANCE).addMigrations(Migration_16_17.INSTANCE).fallbackToDestructiveMigration().build();
        }
    }

    @NotNull
    public static final WorkDatabase create(@NotNull Context context, @NotNull Executor executor, @NotNull Clock clock, boolean z10) {
        return Companion.create(context, executor, clock, z10);
    }

    @NotNull
    public abstract DependencyDao dependencyDao();

    @NotNull
    public abstract PreferenceDao preferenceDao();

    @NotNull
    public abstract RawWorkInfoDao rawWorkInfoDao();

    @NotNull
    public abstract SystemIdInfoDao systemIdInfoDao();

    @NotNull
    public abstract WorkNameDao workNameDao();

    @NotNull
    public abstract WorkProgressDao workProgressDao();

    @NotNull
    public abstract WorkSpecDao workSpecDao();

    @NotNull
    public abstract WorkTagDao workTagDao();
}
