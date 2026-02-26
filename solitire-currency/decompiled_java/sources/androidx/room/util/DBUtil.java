package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import f9.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.u;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;
import v8.k0;

/* JADX INFO: compiled from: DBUtil.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class DBUtil {
    @Nullable
    public static final CancellationSignal createCancellationSignal() {
        return SupportSQLiteCompat.Api16Impl.createCancellationSignal();
    }

    public static final void dropFtsSyncTriggers(@NotNull SupportSQLiteDatabase db2) {
        t.i(db2, "db");
        List listC = u.c();
        Cursor cursorQuery = db2.query("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = cursorQuery;
            while (cursor.moveToNext()) {
                listC.add(cursor.getString(0));
            }
            k0 k0Var = k0.f35197a;
            c.a(cursorQuery, null);
            for (String triggerName : u.a(listC)) {
                t.h(triggerName, "triggerName");
                if (q.K(triggerName, "room_fts_content_sync_", false, 2, null)) {
                    db2.execSQL("DROP TRIGGER IF EXISTS " + triggerName);
                }
            }
        } finally {
        }
    }

    public static final void foreignKeyCheck(@NotNull SupportSQLiteDatabase db2, @NotNull String tableName) {
        t.i(db2, "db");
        t.i(tableName, "tableName");
        Cursor cursorQuery = db2.query("PRAGMA foreign_key_check(`" + tableName + "`)");
        try {
            Cursor cursor = cursorQuery;
            if (cursor.getCount() > 0) {
                throw new SQLiteConstraintException(processForeignKeyCheckFailure(cursor));
            }
            k0 k0Var = k0.f35197a;
            c.a(cursorQuery, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(cursorQuery, th);
                throw th2;
            }
        }
    }

    private static final String processForeignKeyCheckFailure(Cursor cursor) {
        StringBuilder sb = new StringBuilder();
        int count = cursor.getCount();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (cursor.moveToNext()) {
            if (cursor.isFirst()) {
                sb.append("Foreign key violation(s) detected in '");
                sb.append(cursor.getString(0));
                sb.append("'.\n");
            }
            String constraintIndex = cursor.getString(3);
            if (!linkedHashMap.containsKey(constraintIndex)) {
                t.h(constraintIndex, "constraintIndex");
                String string = cursor.getString(2);
                t.h(string, "cursor.getString(2)");
                linkedHashMap.put(constraintIndex, string);
            }
        }
        sb.append("Number of different violations discovered: ");
        sb.append(linkedHashMap.keySet().size());
        sb.append("\n");
        sb.append("Number of rows in violation: ");
        sb.append(count);
        sb.append("\n");
        sb.append("Violation(s) detected in the following constraint(s):\n");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            sb.append("\tParent Table = ");
            sb.append(str2);
            sb.append(", Foreign Key Constraint Index = ");
            sb.append(str);
            sb.append("\n");
        }
        String string2 = sb.toString();
        t.h(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    @NotNull
    public static final Cursor query(@NotNull RoomDatabase db2, @NotNull SupportSQLiteQuery sqLiteQuery, boolean z10) {
        t.i(db2, "db");
        t.i(sqLiteQuery, "sqLiteQuery");
        return query(db2, sqLiteQuery, z10, null);
    }

    public static final int readVersion(@NotNull File databaseFile) throws IOException {
        t.i(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(byteBufferAllocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            byteBufferAllocate.rewind();
            int i10 = byteBufferAllocate.getInt();
            c.a(channel, null);
            return i10;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                c.a(channel, th);
                throw th2;
            }
        }
    }

    @NotNull
    public static final Cursor query(@NotNull RoomDatabase db2, @NotNull SupportSQLiteQuery sqLiteQuery, boolean z10, @Nullable CancellationSignal cancellationSignal) {
        t.i(db2, "db");
        t.i(sqLiteQuery, "sqLiteQuery");
        Cursor cursorQuery = db2.query(sqLiteQuery, cancellationSignal);
        if (!z10 || !(cursorQuery instanceof AbstractWindowedCursor)) {
            return cursorQuery;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) cursorQuery;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(cursorQuery) : cursorQuery;
    }
}
