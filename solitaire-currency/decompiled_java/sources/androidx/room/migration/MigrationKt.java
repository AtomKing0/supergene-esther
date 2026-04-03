package androidx.room.migration;

import androidx.sqlite.db.SupportSQLiteDatabase;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Migration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MigrationKt {
    @NotNull
    public static final Migration Migration(int i10, int i11, @NotNull l<? super SupportSQLiteDatabase, k0> migrate) {
        t.i(migrate, "migrate");
        return new MigrationImpl(i10, i11, migrate);
    }
}
