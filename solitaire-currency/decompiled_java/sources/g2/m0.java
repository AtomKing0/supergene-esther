package g2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import b2.a;
import b2.c;
import h2.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import y1.i;

/* JADX INFO: compiled from: SQLiteEventStore.java */
/* JADX INFO: loaded from: classes2.dex */
@WorkerThread
public class m0 implements g2.d, h2.b, g2.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final w1.c f25823f = w1.c.b("proto");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final t0 f25824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i2.a f25825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final i2.a f25826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e f25827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u8.a<String> f25828e;

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface b<T, U> {
        U apply(T t10);
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f25829a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f25830b;

        private c(String str, String str2) {
            this.f25829a = str;
            this.f25830b = str2;
        }
    }

    /* JADX INFO: compiled from: SQLiteEventStore.java */
    interface d<T> {
        T a();
    }

    m0(i2.a aVar, i2.a aVar2, e eVar, t0 t0Var, u8.a<String> aVar3) {
        this.f25824a = t0Var;
        this.f25825b = aVar;
        this.f25826c = aVar2;
        this.f25827d = eVar;
        this.f25828e = aVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object A1(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        N1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: g2.x
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25864a.z1((Cursor) obj);
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean B1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object C1(String str, c.b bVar, long j10, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) N1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())}), new b() { // from class: g2.v
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.B1((Cursor) obj);
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j10 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(bVar.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(bVar.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j10));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object D1(long j10, y1.o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j10));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(j2.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put("priority", Integer.valueOf(j2.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object E1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f25825b.a()).execute();
        return null;
    }

    private List<k> F1(SQLiteDatabase sQLiteDatabase, final y1.o oVar, int i10) {
        final ArrayList arrayList = new ArrayList();
        Long lC1 = c1(sQLiteDatabase, oVar);
        if (lC1 == null) {
            return arrayList;
        }
        N1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{lC1.toString()}, null, null, null, String.valueOf(i10)), new b() { // from class: g2.y
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25865a.v1(arrayList, oVar, (Cursor) obj);
            }
        });
        return arrayList;
    }

    private Map<Long, Set<c>> G1(SQLiteDatabase sQLiteDatabase, List<k> list) {
        final HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < list.size(); i10++) {
            sb.append(list.get(i10).c());
            if (i10 < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        N1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), new b() { // from class: g2.t
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.w1(map, (Cursor) obj);
            }
        });
        return map;
    }

    private static byte[] H1(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void I1(a.C0147a c0147a, Map<String, List<b2.c>> map) {
        for (Map.Entry<String, List<b2.c>> entry : map.entrySet()) {
            c0147a.a(b2.d.c().c(entry.getKey()).b(entry.getValue()).a());
        }
    }

    private byte[] J1(long j10) {
        return (byte[]) N1(Y0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j10)}, null, null, "sequence_num"), new b() { // from class: g2.a0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.y1((Cursor) obj);
            }
        });
    }

    private <T> T K1(d<T> dVar, b<Throwable, T> bVar) {
        long jA = this.f25826c.a();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e10) {
                if (this.f25826c.a() >= ((long) this.f25827d.b()) + jA) {
                    return bVar.apply(e10);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static w1.c L1(@Nullable String str) {
        return str == null ? f25823f : w1.c.b(str);
    }

    private static String M1(Iterable<k> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<k> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @VisibleForTesting
    static <T> T N1(Cursor cursor, b<Cursor, T> bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private c.b U0(int i10) {
        c.b bVar = c.b.REASON_UNKNOWN;
        if (i10 == bVar.getNumber()) {
            return bVar;
        }
        c.b bVar2 = c.b.MESSAGE_TOO_OLD;
        if (i10 == bVar2.getNumber()) {
            return bVar2;
        }
        c.b bVar3 = c.b.CACHE_FULL;
        if (i10 == bVar3.getNumber()) {
            return bVar3;
        }
        c.b bVar4 = c.b.PAYLOAD_TOO_BIG;
        if (i10 == bVar4.getNumber()) {
            return bVar4;
        }
        c.b bVar5 = c.b.MAX_RETRIES_REACHED;
        if (i10 == bVar5.getNumber()) {
            return bVar5;
        }
        c.b bVar6 = c.b.INVALID_PAYLOD;
        if (i10 == bVar6.getNumber()) {
            return bVar6;
        }
        c.b bVar7 = c.b.SERVER_ERROR;
        if (i10 == bVar7.getNumber()) {
            return bVar7;
        }
        c2.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i10));
        return bVar;
    }

    private void V0(final SQLiteDatabase sQLiteDatabase) {
        K1(new d() { // from class: g2.g0
            @Override // g2.m0.d
            public final Object a() {
                return m0.i1(sQLiteDatabase);
            }
        }, new b() { // from class: g2.h0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.j1((Throwable) obj);
            }
        });
    }

    private long W0(SQLiteDatabase sQLiteDatabase, y1.o oVar) {
        Long lC1 = c1(sQLiteDatabase, oVar);
        if (lC1 != null) {
            return lC1.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put("priority", Integer.valueOf(j2.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private b2.b Z0() {
        return b2.b.b().b(b2.e.c().b(X0()).c(e.f25807a.f()).a()).a();
    }

    private long a1() {
        return Y0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private b2.f b1() {
        final long jA = this.f25825b.a();
        return (b2.f) d1(new b() { // from class: g2.c0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.n1(jA, (SQLiteDatabase) obj);
            }
        });
    }

    @Nullable
    private Long c1(SQLiteDatabase sQLiteDatabase, y1.o oVar) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(j2.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) N1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: g2.s
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.o1((Cursor) obj);
            }
        });
    }

    private boolean e1() {
        return a1() * getPageSize() >= this.f25827d.f();
    }

    private List<k> f1(List<k> list, Map<Long, Set<c>> map) {
        ListIterator<k> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                i.a aVarL = next.b().l();
                for (c cVar : map.get(Long.valueOf(next.c()))) {
                    aVarL.c(cVar.f25829a, cVar.f25830b);
                }
                listIterator.set(k.a(next.c(), next.d(), aVarL.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object g1(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), c.b.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    private long getPageSize() {
        return Y0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer h1(long j10, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j10)};
        N1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: g2.r
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25844a.g1((Cursor) obj);
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object i1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object j1(Throwable th) {
        throw new h2.a("Timed out while trying to acquire the lock.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase k1(Throwable th) {
        throw new h2.a("Timed out while trying to open db.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long l1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b2.f m1(long j10, Cursor cursor) {
        cursor.moveToNext();
        return b2.f.c().c(cursor.getLong(0)).b(j10).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b2.f n1(final long j10, SQLiteDatabase sQLiteDatabase) {
        return (b2.f) N1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: g2.d0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.m1(j10, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long o1(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean p1(y1.o oVar, SQLiteDatabase sQLiteDatabase) {
        Long lC1 = c1(sQLiteDatabase, oVar);
        return lC1 == null ? Boolean.FALSE : (Boolean) N1(Y0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lC1.toString()}), new b() { // from class: g2.z
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List q1(SQLiteDatabase sQLiteDatabase) {
        return (List) N1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: g2.k0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.r1((Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List r1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(y1.o.a().b(cursor.getString(1)).d(j2.a.b(cursor.getInt(2))).c(H1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List s1(y1.o oVar, SQLiteDatabase sQLiteDatabase) {
        List<k> listF1 = F1(sQLiteDatabase, oVar, this.f25827d.d());
        for (w1.e eVar : w1.e.values()) {
            if (eVar != oVar.d()) {
                int iD = this.f25827d.d() - listF1.size();
                if (iD <= 0) {
                    break;
                }
                listF1.addAll(F1(sQLiteDatabase, oVar.f(eVar), iD));
            }
        }
        return f1(listF1, G1(sQLiteDatabase, listF1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ b2.a t1(Map map, a.C0147a c0147a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            c.b bVarU0 = U0(cursor.getInt(1));
            long j10 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(b2.c.c().c(bVarU0).b(j10).a());
        }
        I1(c0147a, map);
        c0147a.e(b1());
        c0147a.d(Z0());
        c0147a.c(this.f25828e.get());
        return c0147a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ b2.a u1(String str, final Map map, final a.C0147a c0147a, SQLiteDatabase sQLiteDatabase) {
        return (b2.a) N1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: g2.b0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25802a.t1(map, c0147a, (Cursor) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object v1(List list, y1.o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j10 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            i.a aVarK = y1.i.a().j(cursor.getString(1)).i(cursor.getLong(2)).k(cursor.getLong(3));
            if (z10) {
                aVarK.h(new y1.h(L1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                aVarK.h(new y1.h(L1(cursor.getString(4)), J1(j10)));
            }
            if (!cursor.isNull(6)) {
                aVarK.g(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(k.a(j10, oVar, aVarK.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object w1(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j10 = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j10));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j10), hashSet);
            }
            hashSet.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long x1(y1.i iVar, y1.o oVar, SQLiteDatabase sQLiteDatabase) {
        if (e1()) {
            c(1L, c.b.CACHE_FULL, iVar.j());
            return -1L;
        }
        long jW0 = W0(sQLiteDatabase, oVar);
        int iE = this.f25827d.e();
        byte[] bArrA = iVar.e().a();
        boolean z10 = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(jW0));
        contentValues.put("transport_name", iVar.j());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.k()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i10 = 1; i10 <= iCeil; i10++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i10 - 1) * iE, Math.min(i10 * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i10));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : iVar.i().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] y1(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            byte[] bArr2 = (byte[]) arrayList.get(i10);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object z1(Cursor cursor) {
        while (cursor.moveToNext()) {
            c(cursor.getInt(0), c.b.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    @Override // g2.d
    public long D(y1.o oVar) {
        return ((Long) N1(Y0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(j2.a.a(oVar.d()))}), new b() { // from class: g2.f0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.l1((Cursor) obj);
            }
        })).longValue();
    }

    @Override // g2.d
    public void H0(final y1.o oVar, final long j10) {
        d1(new b() { // from class: g2.n
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.D1(j10, oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // g2.d
    public Iterable<k> Q(final y1.o oVar) {
        return (Iterable) d1(new b() { // from class: g2.p
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25839a.s1(oVar, (SQLiteDatabase) obj);
            }
        });
    }

    @VisibleForTesting
    long X0() {
        return a1() * getPageSize();
    }

    @Override // g2.d
    public void Y(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + M1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            d1(new b() { // from class: g2.q
                @Override // g2.m0.b
                public final Object apply(Object obj) {
                    return this.f25841a.A1(str, str2, (SQLiteDatabase) obj);
                }
            });
        }
    }

    @VisibleForTesting
    SQLiteDatabase Y0() {
        final t0 t0Var = this.f25824a;
        Objects.requireNonNull(t0Var);
        return (SQLiteDatabase) K1(new d() { // from class: g2.w
            @Override // g2.m0.d
            public final Object a() {
                return t0Var.getWritableDatabase();
            }
        }, new b() { // from class: g2.e0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.k1((Throwable) obj);
            }
        });
    }

    @Override // g2.d
    @Nullable
    public k Z(final y1.o oVar, final y1.i iVar) {
        c2.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.j(), oVar.b());
        long jLongValue = ((Long) d1(new b() { // from class: g2.i0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25812a.x1(iVar, oVar, (SQLiteDatabase) obj);
            }
        })).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return k.a(jLongValue, oVar, iVar);
    }

    @Override // g2.c
    public void a() {
        d1(new b() { // from class: g2.o
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25838a.E1((SQLiteDatabase) obj);
            }
        });
    }

    @Override // g2.c
    public void c(final long j10, final c.b bVar, final String str) {
        d1(new b() { // from class: g2.m
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.C1(str, bVar, j10, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f25824a.close();
    }

    @VisibleForTesting
    <T> T d1(b<SQLiteDatabase, T> bVar) {
        SQLiteDatabase sQLiteDatabaseY0 = Y0();
        sQLiteDatabaseY0.beginTransaction();
        try {
            T tApply = bVar.apply(sQLiteDatabaseY0);
            sQLiteDatabaseY0.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseY0.endTransaction();
        }
    }

    @Override // h2.b
    public <T> T i(b.a<T> aVar) {
        SQLiteDatabase sQLiteDatabaseY0 = Y0();
        V0(sQLiteDatabaseY0);
        try {
            T tExecute = aVar.execute();
            sQLiteDatabaseY0.setTransactionSuccessful();
            return tExecute;
        } finally {
            sQLiteDatabaseY0.endTransaction();
        }
    }

    @Override // g2.d
    public int l() {
        final long jA = this.f25825b.a() - this.f25827d.c();
        return ((Integer) d1(new b() { // from class: g2.j0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25816a.h1(jA, (SQLiteDatabase) obj);
            }
        })).intValue();
    }

    @Override // g2.d
    public void m(Iterable<k> iterable) {
        if (iterable.iterator().hasNext()) {
            Y0().compileStatement("DELETE FROM events WHERE _id in " + M1(iterable)).execute();
        }
    }

    @Override // g2.c
    public b2.a n() {
        final a.C0147a c0147aE = b2.a.e();
        final HashMap map = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (b2.a) d1(new b() { // from class: g2.u
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25856a.u1(str, map, c0147aE, (SQLiteDatabase) obj);
            }
        });
    }

    @Override // g2.d
    public boolean t0(final y1.o oVar) {
        return ((Boolean) d1(new b() { // from class: g2.l0
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return this.f25818a.p1(oVar, (SQLiteDatabase) obj);
            }
        })).booleanValue();
    }

    @Override // g2.d
    public Iterable<y1.o> u() {
        return (Iterable) d1(new b() { // from class: g2.l
            @Override // g2.m0.b
            public final Object apply(Object obj) {
                return m0.q1((SQLiteDatabase) obj);
            }
        });
    }
}
