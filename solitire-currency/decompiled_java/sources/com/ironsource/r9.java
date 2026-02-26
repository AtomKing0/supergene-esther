package com.ironsource;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f14663a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Object f14664b = new Object();

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    @Nullable
    public final SQLiteDatabase a(@NotNull SQLiteOpenHelper sqliteOpenHelper) {
        kotlin.jvm.internal.t.i(sqliteOpenHelper, "sqliteOpenHelper");
        return a(this, false, sqliteOpenHelper, 1, null);
    }

    public static /* synthetic */ SQLiteDatabase a(r9 r9Var, boolean z10, SQLiteOpenHelper sQLiteOpenHelper, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return r9Var.a(z10, sQLiteOpenHelper);
    }

    @Nullable
    public final SQLiteDatabase a(boolean z10, @NotNull SQLiteOpenHelper sqliteOpenHelper) {
        SQLiteDatabase writableDatabase;
        kotlin.jvm.internal.t.i(sqliteOpenHelper, "sqliteOpenHelper");
        synchronized (f14664b) {
            writableDatabase = z10 ? sqliteOpenHelper.getWritableDatabase() : sqliteOpenHelper.getReadableDatabase();
        }
        return writableDatabase;
    }
}
