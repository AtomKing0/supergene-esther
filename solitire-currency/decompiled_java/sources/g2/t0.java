package g2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SchemaManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class t0 extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f25846c = "INSERT INTO global_log_event_state VALUES (" + System.currentTimeMillis() + ")";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static int f25847d = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final a f25848e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f25849f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a f25850g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a f25851h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a f25852i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final List<a> f25853j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25855b;

    /* JADX INFO: compiled from: SchemaManager.java */
    public interface a {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        a aVar = new a() { // from class: g2.o0
            @Override // g2.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.z(sQLiteDatabase);
            }
        };
        f25848e = aVar;
        a aVar2 = new a() { // from class: g2.p0
            @Override // g2.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.B(sQLiteDatabase);
            }
        };
        f25849f = aVar2;
        a aVar3 = new a() { // from class: g2.q0
            @Override // g2.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN payload_encoding TEXT");
            }
        };
        f25850g = aVar3;
        a aVar4 = new a() { // from class: g2.r0
            @Override // g2.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.L(sQLiteDatabase);
            }
        };
        f25851h = aVar4;
        a aVar5 = new a() { // from class: g2.s0
            @Override // g2.t0.a
            public final void a(SQLiteDatabase sQLiteDatabase) {
                t0.O(sQLiteDatabase);
            }
        };
        f25852i = aVar5;
        f25853j = Arrays.asList(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    t0(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
        this.f25855b = false;
        this.f25854a = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void L(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        sQLiteDatabase.execSQL("CREATE TABLE log_event_dropped (log_source VARCHAR(45) NOT NULL,reason INTEGER NOT NULL,events_dropped_count BIGINT NOT NULL,PRIMARY KEY(log_source, reason))");
        sQLiteDatabase.execSQL("CREATE TABLE global_log_event_state (last_metrics_upload_ms BIGINT PRIMARY KEY)");
        sQLiteDatabase.execSQL(f25846c);
    }

    private void R(SQLiteDatabase sQLiteDatabase, int i10) {
        x(sQLiteDatabase);
        S(sQLiteDatabase, 0, i10);
    }

    private void S(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        List<a> list = f25853j;
        if (i11 <= list.size()) {
            while (i10 < i11) {
                f25853j.get(i10).a(sQLiteDatabase);
                i10++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i10 + " to " + i11 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    private void x(SQLiteDatabase sQLiteDatabase) {
        if (this.f25855b) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)");
        sQLiteDatabase.execSQL("CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)");
        sQLiteDatabase.execSQL("CREATE INDEX events_backend_id on events(context_id)");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f25855b = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        R(sQLiteDatabase, this.f25854a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        sQLiteDatabase.execSQL("DROP TABLE events");
        sQLiteDatabase.execSQL("DROP TABLE event_metadata");
        sQLiteDatabase.execSQL("DROP TABLE transport_contexts");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS event_payloads");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS log_event_dropped");
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS global_log_event_state");
        R(sQLiteDatabase, i11);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        x(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        x(sQLiteDatabase);
        S(sQLiteDatabase, i10, i11);
    }
}
