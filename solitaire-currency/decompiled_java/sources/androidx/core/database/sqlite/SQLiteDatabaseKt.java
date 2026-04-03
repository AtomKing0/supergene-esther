package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import h9.l;
import kotlin.jvm.internal.r;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SQLiteDatabase.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SQLiteDatabaseKt {
    public static final <T> T transaction(@NotNull SQLiteDatabase sQLiteDatabase, boolean z10, @NotNull l<? super SQLiteDatabase, ? extends T> lVar) {
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T tInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return tInvoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if (z10) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object objInvoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return objInvoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }
}
