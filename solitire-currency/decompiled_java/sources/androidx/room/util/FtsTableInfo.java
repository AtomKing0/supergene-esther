package androidx.room.util;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import f9.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Set;
import kotlin.collections.d0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import p9.r;
import v8.k0;

/* JADX INFO: compiled from: FtsTableInfo.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @NotNull
    public final Set<String> columns;

    @NotNull
    public final String name;

    @NotNull
    public final Set<String> options;

    /* JADX INFO: compiled from: FtsTableInfo.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Set setB = y0.b();
            Cursor cursorQuery = supportSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
            try {
                Cursor cursor = cursorQuery;
                if (cursor.getColumnCount() > 0) {
                    int columnIndex = cursor.getColumnIndex("name");
                    while (cursor.moveToNext()) {
                        String string = cursor.getString(columnIndex);
                        t.h(string, "cursor.getString(nameIndex)");
                        setB.add(string);
                    }
                }
                k0 k0Var = k0.f35197a;
                c.a(cursorQuery, null);
                return y0.a(setB);
            } finally {
            }
        }

        private final Set<String> readOptions(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
            try {
                Cursor cursor = cursorQuery;
                String sql = cursor.moveToFirst() ? cursor.getString(cursor.getColumnIndexOrThrow("sql")) : "";
                c.a(cursorQuery, null);
                t.h(sql, "sql");
                return parseOptions(sql);
            } finally {
            }
        }

        @VisibleForTesting
        @NotNull
        public final Set<String> parseOptions(@NotNull String createStatement) {
            boolean z10;
            Character ch;
            t.i(createStatement, "createStatement");
            if (createStatement.length() == 0) {
                return z0.e();
            }
            String strSubstring = createStatement.substring(r.d0(createStatement, '(', 0, false, 6, null) + 1, r.j0(createStatement, ')', 0, false, 6, null));
            t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList arrayList = new ArrayList();
            ArrayDeque arrayDeque = new ArrayDeque();
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            while (i11 < strSubstring.length()) {
                char cCharAt = strSubstring.charAt(i11);
                int i13 = i12 + 1;
                if ((cCharAt == '\'' || cCharAt == '\"') || cCharAt == '`') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    } else {
                        Character ch2 = (Character) arrayDeque.peek();
                        if (ch2 != null && ch2.charValue() == cCharAt) {
                            arrayDeque.pop();
                        }
                    }
                } else if (cCharAt == '[') {
                    if (arrayDeque.isEmpty()) {
                        arrayDeque.push(Character.valueOf(cCharAt));
                    }
                } else if (cCharAt == ']') {
                    if (!arrayDeque.isEmpty() && (ch = (Character) arrayDeque.peek()) != null && ch.charValue() == '[') {
                        arrayDeque.pop();
                    }
                } else if (cCharAt == ',' && arrayDeque.isEmpty()) {
                    String strSubstring2 = strSubstring.substring(i10 + 1, i12);
                    t.h(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                    int length = strSubstring2.length() - 1;
                    int i14 = 0;
                    boolean z11 = false;
                    while (i14 <= length) {
                        boolean z12 = t.k(strSubstring2.charAt(!z11 ? i14 : length), 32) <= 0;
                        if (z11) {
                            if (!z12) {
                                break;
                            }
                            length--;
                        } else if (z12) {
                            i14++;
                        } else {
                            z11 = true;
                        }
                    }
                    arrayList.add(strSubstring2.subSequence(i14, length + 1).toString());
                    i10 = i12;
                }
                i11++;
                i12 = i13;
            }
            String strSubstring3 = strSubstring.substring(i10 + 1);
            t.h(strSubstring3, "this as java.lang.String).substring(startIndex)");
            arrayList.add(r.b1(strSubstring3).toString());
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                String str = (String) obj;
                String[] strArr = FtsTableInfo.FTS_OPTIONS;
                int length2 = strArr.length;
                int i15 = 0;
                while (true) {
                    if (i15 >= length2) {
                        z10 = false;
                        break;
                    }
                    if (q.K(str, strArr[i15], false, 2, null)) {
                        z10 = true;
                        break;
                    }
                    i15++;
                }
                if (z10) {
                    arrayList2.add(obj);
                }
            }
            return d0.T0(arrayList2);
        }

        @SuppressLint({"SyntheticAccessor"})
        @NotNull
        public final FtsTableInfo read(@NotNull SupportSQLiteDatabase database, @NotNull String tableName) {
            t.i(database, "database");
            t.i(tableName, "tableName");
            return new FtsTableInfo(tableName, readColumns(database, tableName), readOptions(database, tableName));
        }
    }

    public FtsTableInfo(@NotNull String name, @NotNull Set<String> columns, @NotNull Set<String> options) {
        t.i(name, "name");
        t.i(columns, "columns");
        t.i(options, "options");
        this.name = name;
        this.columns = columns;
        this.options = options;
    }

    @VisibleForTesting
    @NotNull
    public static final Set<String> parseOptions(@NotNull String str) {
        return Companion.parseOptions(str);
    }

    @SuppressLint({"SyntheticAccessor"})
    @NotNull
    public static final FtsTableInfo read(@NotNull SupportSQLiteDatabase supportSQLiteDatabase, @NotNull String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FtsTableInfo)) {
            return false;
        }
        FtsTableInfo ftsTableInfo = (FtsTableInfo) obj;
        if (t.d(this.name, ftsTableInfo.name) && t.d(this.columns, ftsTableInfo.columns)) {
            return t.d(this.options, ftsTableInfo.options);
        }
        return false;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    @NotNull
    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(@NotNull String name, @NotNull Set<String> columns, @NotNull String createSql) {
        this(name, columns, Companion.parseOptions(createSql));
        t.i(name, "name");
        t.i(columns, "columns");
        t.i(createSql, "createSql");
    }
}
