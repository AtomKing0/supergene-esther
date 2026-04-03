package com.ironsource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.SystemClock;
import android.provider.BaseColumns;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class q9 extends SQLiteOpenHelper implements ie {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static q9 f14450f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f14451g = " TEXT";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final String f14452h = " INTEGER";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14453i = ",";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r9 f14454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f14455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f14456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14458e;

    static abstract class a implements BaseColumns {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final String f14459a = "events";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f14460b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f14461c = "eventid";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f14462d = "timestamp";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f14463e = "type";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f14464f = "data";

        a() {
        }
    }

    public q9(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f14454a = new r9();
        this.f14455b = 4;
        this.f14456c = 400;
        this.f14457d = "DROP TABLE IF EXISTS events";
        this.f14458e = "CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )";
    }

    private ContentValues a(kb kbVar, String str) {
        if (kbVar == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues(4);
        contentValues.put("eventid", Integer.valueOf(kbVar.c()));
        contentValues.put("timestamp", Long.valueOf(kbVar.d()));
        contentValues.put("type", str);
        contentValues.put("data", kbVar.a());
        return contentValues;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033 A[Catch: all -> 0x0045, DONT_GENERATE, PHI: r5
      0x0033: PHI (r5v4 android.database.sqlite.SQLiteDatabase) = (r5v3 android.database.sqlite.SQLiteDatabase), (r5v5 android.database.sqlite.SQLiteDatabase) binds: [B:16:0x0031, B:7:0x0016] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:6:0x0012, B:17:0x0033, B:15:0x002d, B:22:0x003b, B:24:0x0041, B:25:0x0044, B:13:0x001d), top: B:29:0x0001, inners: #1 }] */
    @Override // com.ironsource.ie
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "type = ?"
            r1 = 1
            java.lang.String[] r2 = new java.lang.String[r1]     // Catch: java.lang.Throwable -> L45
            r3 = 0
            r2[r3] = r5     // Catch: java.lang.Throwable -> L45
            android.database.sqlite.SQLiteDatabase r5 = r4.a(r1)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r1 = "events"
            r5.delete(r1, r0, r2)     // Catch: java.lang.Throwable -> L19
            boolean r0 = r5.isOpen()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L36
            goto L33
        L19:
            r0 = move-exception
            goto L1d
        L1b:
            r0 = move-exception
            r5 = 0
        L1d:
            com.ironsource.i9 r1 = com.ironsource.i9.d()     // Catch: java.lang.Throwable -> L38
            r1.a(r0)     // Catch: java.lang.Throwable -> L38
            java.lang.String r1 = "IronSource"
            java.lang.String r2 = "Exception while clearing events: "
            android.util.Log.e(r1, r2, r0)     // Catch: java.lang.Throwable -> L38
            if (r5 == 0) goto L36
            boolean r0 = r5.isOpen()     // Catch: java.lang.Throwable -> L45
            if (r0 == 0) goto L36
        L33:
            r5.close()     // Catch: java.lang.Throwable -> L45
        L36:
            monitor-exit(r4)
            return
        L38:
            r0 = move-exception
            if (r5 == 0) goto L44
            boolean r1 = r5.isOpen()     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L44
            r5.close()     // Catch: java.lang.Throwable -> L45
        L44:
            throw r0     // Catch: java.lang.Throwable -> L45
        L45:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q9.b(java.lang.String):void");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY,eventid INTEGER,timestamp INTEGER,type TEXT,data TEXT )");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sQLiteDatabase);
    }

    private synchronized SQLiteDatabase a(boolean z10) throws Throwable {
        int i10 = 0;
        while (true) {
            try {
                if (z10) {
                    return this.f14454a.a(true, this);
                }
                return this.f14454a.a(false, this);
            } catch (Throwable th) {
                i9.d().a(th);
                i10++;
                if (i10 >= 4) {
                    throw th;
                }
                SystemClock.sleep(i10 * 400);
            }
        }
    }

    public static synchronized q9 a(Context context, String str, int i10) {
        if (f14450f == null) {
            f14450f = new q9(context, str, i10);
        }
        return f14450f;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[Catch: all -> 0x00b6, DONT_GENERATE, PHI: r11
      0x0099: PHI (r11v2 android.database.sqlite.SQLiteDatabase) = (r11v1 android.database.sqlite.SQLiteDatabase), (r11v3 android.database.sqlite.SQLiteDatabase) binds: [B:39:0x0097, B:26:0x0071] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:22:0x0064, B:24:0x006a, B:25:0x006d, B:40:0x0099, B:34:0x0088, B:36:0x008e, B:38:0x0093, B:45:0x00a1, B:47:0x00a7, B:49:0x00ac, B:51:0x00b2, B:52:0x00b5, B:32:0x0078), top: B:60:0x0001, inners: #3 }] */
    @Override // com.ironsource.ie
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.ArrayList<com.ironsource.kb> a(java.lang.String r13) {
        /*
            r12 = this;
            monitor-enter(r12)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lb6
            r0.<init>()     // Catch: java.lang.Throwable -> Lb6
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r11 = r12.a(r1)     // Catch: java.lang.Throwable -> L76
            java.lang.String r6 = "type = ?"
            r3 = 1
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch: java.lang.Throwable -> L74
            r7[r1] = r13     // Catch: java.lang.Throwable -> L74
            java.lang.String r10 = "timestamp ASC"
            java.lang.String r4 = "events"
            r5 = 0
            r8 = 0
            r9 = 0
            r3 = r11
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L74
            int r13 = r2.getCount()     // Catch: java.lang.Throwable -> L74
            if (r13 <= 0) goto L64
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L74
        L28:
            boolean r13 = r2.isAfterLast()     // Catch: java.lang.Throwable -> L74
            if (r13 != 0) goto L61
            java.lang.String r13 = "eventid"
            int r13 = r2.getColumnIndex(r13)     // Catch: java.lang.Throwable -> L74
            if (r13 >= 0) goto L37
            goto L28
        L37:
            int r13 = r2.getInt(r13)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "timestamp"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L74
            if (r1 >= 0) goto L44
            goto L28
        L44:
            long r3 = r2.getLong(r1)     // Catch: java.lang.Throwable -> L74
            java.lang.String r1 = "data"
            int r1 = r2.getColumnIndex(r1)     // Catch: java.lang.Throwable -> L74
            if (r1 >= 0) goto L51
            goto L28
        L51:
            java.lang.String r1 = r2.getString(r1)     // Catch: java.lang.Throwable -> L74
            com.ironsource.kb r5 = new com.ironsource.kb     // Catch: java.lang.Throwable -> L74
            r5.<init>(r13, r3, r1)     // Catch: java.lang.Throwable -> L74
            r0.add(r5)     // Catch: java.lang.Throwable -> L74
            r2.moveToNext()     // Catch: java.lang.Throwable -> L74
            goto L28
        L61:
            r2.close()     // Catch: java.lang.Throwable -> L74
        L64:
            boolean r13 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb6
            if (r13 != 0) goto L6d
            r2.close()     // Catch: java.lang.Throwable -> Lb6
        L6d:
            boolean r13 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb6
            if (r13 == 0) goto L9c
            goto L99
        L74:
            r13 = move-exception
            goto L78
        L76:
            r13 = move-exception
            r11 = r2
        L78:
            com.ironsource.i9 r1 = com.ironsource.i9.d()     // Catch: java.lang.Throwable -> L9e
            r1.a(r13)     // Catch: java.lang.Throwable -> L9e
            java.lang.String r1 = "IronSource"
            java.lang.String r3 = "Exception while loading events: "
            android.util.Log.e(r1, r3, r13)     // Catch: java.lang.Throwable -> L9e
            if (r2 == 0) goto L91
            boolean r13 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb6
            if (r13 != 0) goto L91
            r2.close()     // Catch: java.lang.Throwable -> Lb6
        L91:
            if (r11 == 0) goto L9c
            boolean r13 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb6
            if (r13 == 0) goto L9c
        L99:
            r11.close()     // Catch: java.lang.Throwable -> Lb6
        L9c:
            monitor-exit(r12)
            return r0
        L9e:
            r13 = move-exception
            if (r2 == 0) goto Laa
            boolean r0 = r2.isClosed()     // Catch: java.lang.Throwable -> Lb6
            if (r0 != 0) goto Laa
            r2.close()     // Catch: java.lang.Throwable -> Lb6
        Laa:
            if (r11 == 0) goto Lb5
            boolean r0 = r11.isOpen()     // Catch: java.lang.Throwable -> Lb6
            if (r0 == 0) goto Lb5
            r11.close()     // Catch: java.lang.Throwable -> Lb6
        Lb5:
            throw r13     // Catch: java.lang.Throwable -> Lb6
        Lb6:
            r13 = move-exception
            monitor-exit(r12)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.q9.a(java.lang.String):java.util.ArrayList");
    }

    @Override // com.ironsource.ie
    public synchronized void a(List<kb> list, String str) {
        SQLiteDatabase sQLiteDatabaseA;
        if (list != null) {
            if (!list.isEmpty()) {
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    sQLiteDatabaseA = a(true);
                    try {
                        Iterator<kb> it = list.iterator();
                        while (it.hasNext()) {
                            ContentValues contentValuesA = a(it.next(), str);
                            if (sQLiteDatabaseA != null && contentValuesA != null) {
                                sQLiteDatabaseA.insert("events", null, contentValuesA);
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        sQLiteDatabase = sQLiteDatabaseA;
                        try {
                            i9.d().a(th);
                            Log.e("IronSource", "Exception while saving events: ", th);
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabaseA = sQLiteDatabase;
                            }
                        } catch (Throwable th2) {
                            if (sQLiteDatabase != null && sQLiteDatabase.isOpen()) {
                                sQLiteDatabase.close();
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
                if (sQLiteDatabaseA != null && sQLiteDatabaseA.isOpen()) {
                    sQLiteDatabaseA.close();
                }
            }
        }
    }
}
