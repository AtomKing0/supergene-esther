package androidx.sqlite.db;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SupportSQLiteQuery.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface SupportSQLiteQuery {
    void bindTo(@NotNull SupportSQLiteProgram supportSQLiteProgram);

    int getArgCount();

    @NotNull
    String getSql();
}
