package androidx.room.util;

import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import f9.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ViewInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public final String name;

    @Nullable
    public final String sql;

    /* JADX INFO: compiled from: ViewInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ViewInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String viewName) {
            ViewInfo viewInfo;
            t.i(database, "database");
            t.i(viewName, "viewName");
            Cursor cursorQuery = database.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + viewName + '\'');
            try {
                Cursor cursor = cursorQuery;
                if (cursor.moveToFirst()) {
                    String string = cursor.getString(0);
                    t.h(string, "cursor.getString(0)");
                    viewInfo = new ViewInfo(string, cursor.getString(1));
                } else {
                    viewInfo = new ViewInfo(viewName, null);
                }
                c.a(cursorQuery, null);
                return viewInfo;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    c.a(cursorQuery, th);
                    throw th2;
                }
            }
        }
    }

    public ViewInfo(@NotNull String name, @Nullable String str) {
        t.i(name, "name");
        this.name = name;
        this.sql = str;
    }

    @NotNull
    public static final ViewInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (t.d(this.name, viewInfo.name)) {
            String str = this.sql;
            String str2 = viewInfo.sql;
            if (str != null ? t.d(str, str2) : str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        String str = this.sql;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
