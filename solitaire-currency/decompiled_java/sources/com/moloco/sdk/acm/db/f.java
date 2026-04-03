package com.moloco.sdk.acm.db;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.moloco.sdk.acm.db.d;
import h9.l;
import io.sentry.protocol.SentrySpan;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements com.moloco.sdk.acm.db.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f17342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> f17343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.moloco.sdk.acm.db.a f17344c = new com.moloco.sdk.acm.db.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final EntityInsertionAdapter<com.moloco.sdk.acm.db.b> f17345d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SharedSQLiteStatement f17346e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SharedSQLiteStatement f17347f;

    public class a extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.moloco.sdk.acm.db.b bVar) {
            supportSQLiteStatement.bindLong(1, bVar.c());
            if (bVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, bVar.d());
            }
            supportSQLiteStatement.bindLong(3, bVar.f());
            String strB = f.this.f17344c.b(bVar.b());
            if (strB == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, strB);
            }
            if (bVar.a() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, bVar.a().longValue());
            }
            String strC = f.this.f17344c.c(bVar.e());
            if (strC == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, strC);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR REPLACE INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class b extends EntityInsertionAdapter<com.moloco.sdk.acm.db.b> {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.EntityInsertionAdapter
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void bind(SupportSQLiteStatement supportSQLiteStatement, com.moloco.sdk.acm.db.b bVar) {
            supportSQLiteStatement.bindLong(1, bVar.c());
            if (bVar.d() == null) {
                supportSQLiteStatement.bindNull(2);
            } else {
                supportSQLiteStatement.bindString(2, bVar.d());
            }
            supportSQLiteStatement.bindLong(3, bVar.f());
            String strB = f.this.f17344c.b(bVar.b());
            if (strB == null) {
                supportSQLiteStatement.bindNull(4);
            } else {
                supportSQLiteStatement.bindString(4, strB);
            }
            if (bVar.a() == null) {
                supportSQLiteStatement.bindNull(5);
            } else {
                supportSQLiteStatement.bindLong(5, bVar.a().longValue());
            }
            String strC = f.this.f17344c.c(bVar.e());
            if (strC == null) {
                supportSQLiteStatement.bindNull(6);
            } else {
                supportSQLiteStatement.bindString(6, strC);
            }
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "INSERT OR ABORT INTO `events` (`id`,`name`,`timestamp`,`eventType`,`data`,`tags`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }
    }

    public class c extends SharedSQLiteStatement {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM events";
        }
    }

    public class d extends SharedSQLiteStatement {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // androidx.room.SharedSQLiteStatement
        public String createQuery() {
            return "DELETE FROM sqlite_sequence WHERE name='events'";
        }
    }

    public class e implements Callable<k0> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0 call() throws Exception {
            SupportSQLiteStatement supportSQLiteStatementAcquire = f.this.f17347f.acquire();
            f.this.f17342a.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeUpdateDelete();
                f.this.f17342a.setTransactionSuccessful();
                return k0.f35197a;
            } finally {
                f.this.f17342a.endTransaction();
                f.this.f17347f.release(supportSQLiteStatementAcquire);
            }
        }
    }

    /* JADX INFO: renamed from: com.moloco.sdk.acm.db.f$f, reason: collision with other inner class name */
    public class CallableC0289f implements Callable<k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f17353a;

        public CallableC0289f(List list) {
            this.f17353a = list;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public k0 call() throws Exception {
            StringBuilder sbNewStringBuilder = StringUtil.newStringBuilder();
            sbNewStringBuilder.append("DELETE FROM events WHERE id IN (");
            StringUtil.appendPlaceholders(sbNewStringBuilder, this.f17353a.size());
            sbNewStringBuilder.append(")");
            SupportSQLiteStatement supportSQLiteStatementCompileStatement = f.this.f17342a.compileStatement(sbNewStringBuilder.toString());
            Iterator it = this.f17353a.iterator();
            int i10 = 1;
            while (it.hasNext()) {
                supportSQLiteStatementCompileStatement.bindLong(i10, ((Long) it.next()).longValue());
                i10++;
            }
            f.this.f17342a.beginTransaction();
            try {
                supportSQLiteStatementCompileStatement.executeUpdateDelete();
                f.this.f17342a.setTransactionSuccessful();
                return k0.f35197a;
            } finally {
                f.this.f17342a.endTransaction();
            }
        }
    }

    public f(RoomDatabase roomDatabase) {
        this.f17342a = roomDatabase;
        this.f17343b = new a(roomDatabase);
        this.f17345d = new b(roomDatabase);
        this.f17346e = new c(roomDatabase);
        this.f17347f = new d(roomDatabase);
    }

    public static List<Class<?>> g() {
        return Collections.emptyList();
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object a(z8.d<? super List<com.moloco.sdk.acm.db.b>> dVar) {
        return RoomDatabaseKt.withTransaction(this.f17342a, new l() { // from class: com.moloco.sdk.acm.db.e
            @Override // h9.l
            public final Object invoke(Object obj) {
                return this.f17341a.i((z8.d) obj);
            }
        }, dVar);
    }

    @Override // com.moloco.sdk.acm.db.d
    public long b(com.moloco.sdk.acm.db.b bVar) {
        this.f17342a.assertNotSuspendingTransaction();
        this.f17342a.beginTransaction();
        try {
            long jInsertAndReturnId = this.f17343b.insertAndReturnId(bVar);
            this.f17342a.setTransactionSuccessful();
            return jInsertAndReturnId;
        } finally {
            this.f17342a.endTransaction();
        }
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object c(List<Long> list, z8.d<? super k0> dVar) {
        return CoroutinesRoom.execute(this.f17342a, true, new CallableC0289f(list), dVar);
    }

    @Override // com.moloco.sdk.acm.db.d
    public Object d(z8.d<? super k0> dVar) {
        return CoroutinesRoom.execute(this.f17342a, true, new e(), dVar);
    }

    public final /* synthetic */ Object i(z8.d dVar) {
        return d.a.a(this, dVar);
    }

    @Override // com.moloco.sdk.acm.db.d
    public List<com.moloco.sdk.acm.db.b> b() {
        RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT * FROM events LIMIT 900", 0);
        this.f17342a.assertNotSuspendingTransaction();
        Cursor cursorQuery = DBUtil.query(this.f17342a, roomSQLiteQueryAcquire, false, null);
        try {
            int columnIndexOrThrow = CursorUtil.getColumnIndexOrThrow(cursorQuery, "id");
            int columnIndexOrThrow2 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "name");
            int columnIndexOrThrow3 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "timestamp");
            int columnIndexOrThrow4 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "eventType");
            int columnIndexOrThrow5 = CursorUtil.getColumnIndexOrThrow(cursorQuery, "data");
            int columnIndexOrThrow6 = CursorUtil.getColumnIndexOrThrow(cursorQuery, SentrySpan.JsonKeys.TAGS);
            ArrayList arrayList = new ArrayList(cursorQuery.getCount());
            while (cursorQuery.moveToNext()) {
                arrayList.add(new com.moloco.sdk.acm.db.b(cursorQuery.getLong(columnIndexOrThrow), cursorQuery.isNull(columnIndexOrThrow2) ? null : cursorQuery.getString(columnIndexOrThrow2), cursorQuery.getLong(columnIndexOrThrow3), this.f17344c.a(cursorQuery.isNull(columnIndexOrThrow4) ? null : cursorQuery.getString(columnIndexOrThrow4)), cursorQuery.isNull(columnIndexOrThrow5) ? null : Long.valueOf(cursorQuery.getLong(columnIndexOrThrow5)), this.f17344c.d(cursorQuery.isNull(columnIndexOrThrow6) ? null : cursorQuery.getString(columnIndexOrThrow6))));
            }
            return arrayList;
        } finally {
            cursorQuery.close();
            roomSQLiteQueryAcquire.release();
        }
    }
}
