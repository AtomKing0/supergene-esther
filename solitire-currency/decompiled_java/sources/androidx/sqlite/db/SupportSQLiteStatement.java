package androidx.sqlite.db;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SupportSQLiteStatement.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SupportSQLiteStatement extends SupportSQLiteProgram {
    void execute();

    long executeInsert();

    int executeUpdateDelete();

    long simpleQueryForLong();

    @Nullable
    String simpleQueryForString();
}
