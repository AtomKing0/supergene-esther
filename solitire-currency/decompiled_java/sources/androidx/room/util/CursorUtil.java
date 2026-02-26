package androidx.room.util;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import f9.c;
import h9.l;
import kotlin.collections.p;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: CursorUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CursorUtil {
    @NotNull
    public static final Cursor copyAndClose(@NotNull Cursor c10) {
        t.i(c10, "c");
        Cursor cursor = c10;
        try {
            Cursor cursor2 = cursor;
            MatrixCursor matrixCursor = new MatrixCursor(cursor2.getColumnNames(), cursor2.getCount());
            while (cursor2.moveToNext()) {
                Object[] objArr = new Object[cursor2.getColumnCount()];
                int columnCount = c10.getColumnCount();
                for (int i10 = 0; i10 < columnCount; i10++) {
                    int type = cursor2.getType(i10);
                    if (type == 0) {
                        objArr[i10] = null;
                    } else if (type == 1) {
                        objArr[i10] = Long.valueOf(cursor2.getLong(i10));
                    } else if (type == 2) {
                        objArr[i10] = Double.valueOf(cursor2.getDouble(i10));
                    } else if (type == 3) {
                        objArr[i10] = cursor2.getString(i10);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i10] = cursor2.getBlob(i10);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            c.a(cursor, null);
            return matrixCursor;
        } finally {
        }
    }

    private static final int findColumnIndexBySuffix(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT > 25) {
            return -1;
        }
        if (str.length() == 0) {
            return -1;
        }
        String[] columnNames = cursor.getColumnNames();
        t.h(columnNames, "columnNames");
        return findColumnIndexBySuffix(columnNames, str);
    }

    public static final int getColumnIndex(@NotNull Cursor c10, @NotNull String name) {
        t.i(c10, "c");
        t.i(name, "name");
        int columnIndex = c10.getColumnIndex(name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = c10.getColumnIndex('`' + name + '`');
        return columnIndex2 >= 0 ? columnIndex2 : findColumnIndexBySuffix(c10, name);
    }

    public static final int getColumnIndexOrThrow(@NotNull Cursor c10, @NotNull String name) {
        String strD0;
        t.i(c10, "c");
        t.i(name, "name");
        int columnIndex = getColumnIndex(c10, name);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = c10.getColumnNames();
            t.h(columnNames, "c.columnNames");
            strD0 = p.d0(columnNames, null, null, null, 0, null, null, 63, null);
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            strD0 = "unknown";
        }
        throw new IllegalArgumentException("column '" + name + "' does not exist. Available columns: " + strD0);
    }

    public static final <R> R useCursor(@NotNull Cursor cursor, @NotNull l<? super Cursor, ? extends R> block) {
        t.i(cursor, "<this>");
        t.i(block, "block");
        Cursor cursor2 = cursor;
        try {
            R rInvoke = block.invoke(cursor2);
            r.b(1);
            c.a(cursor2, null);
            r.a(1);
            return rInvoke;
        } finally {
        }
    }

    @NotNull
    public static final Cursor wrapMappedColumns(@NotNull Cursor cursor, @NotNull final String[] columnNames, @NotNull final int[] mapping) {
        t.i(cursor, "cursor");
        t.i(columnNames, "columnNames");
        t.i(mapping, "mapping");
        if (columnNames.length == mapping.length) {
            return new CursorWrapper(cursor) { // from class: androidx.room.util.CursorUtil.wrapMappedColumns.2
                @Override // android.database.CursorWrapper, android.database.Cursor
                public int getColumnIndex(@NotNull String columnName) {
                    t.i(columnName, "columnName");
                    String[] strArr = columnNames;
                    int[] iArr = mapping;
                    int length = strArr.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (i10 < length) {
                        int i12 = i11 + 1;
                        if (q.x(strArr[i10], columnName, true)) {
                            return iArr[i11];
                        }
                        i10++;
                        i11 = i12;
                    }
                    return super.getColumnIndex(columnName);
                }
            };
        }
        throw new IllegalStateException("Expected columnNames.length == mapping.length".toString());
    }

    @VisibleForTesting(otherwise = 2)
    public static final int findColumnIndexBySuffix(@NotNull String[] columnNames, @NotNull String name) {
        t.i(columnNames, "columnNames");
        t.i(name, "name");
        String str = '.' + name;
        String str2 = '.' + name + '`';
        int length = columnNames.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            String str3 = columnNames[i10];
            int i12 = i11 + 1;
            if (str3.length() >= name.length() + 2) {
                if (q.w(str3, str, false, 2, null)) {
                    return i11;
                }
                if (str3.charAt(0) == '`' && q.w(str3, str2, false, 2, null)) {
                    return i11;
                }
            }
            i10++;
            i11 = i12;
        }
        return -1;
    }
}
