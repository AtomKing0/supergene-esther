package u5;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import l5.e0;
import org.json.JSONArray;
import org.json.JSONObject;
import u5.j;

/* JADX INFO: compiled from: DefaultHeartBeatController.java */
/* JADX INFO: loaded from: classes3.dex */
public class f implements i, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final w5.b<q> f34625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f34626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w5.b<f6.i> f34627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<g> f34628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f34629e;

    private f(final Context context, final String str, Set<g> set, w5.b<f6.i> bVar, Executor executor) {
        this((w5.b<q>) new w5.b() { // from class: u5.e
            @Override // w5.b
            public final Object get() {
                return f.j(context, str);
            }
        }, set, executor, bVar, context);
    }

    @NonNull
    public static l5.c<f> g() {
        final e0 e0VarA = e0.a(k5.a.class, Executor.class);
        return l5.c.d(f.class, i.class, j.class).b(l5.r.i(Context.class)).b(l5.r.i(i5.e.class)).b(l5.r.l(g.class)).b(l5.r.k(f6.i.class)).b(l5.r.j(e0VarA)).f(new l5.h() { // from class: u5.d
            @Override // l5.h
            public final Object a(l5.e eVar) {
                return f.h(e0VarA, eVar);
            }
        }).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f h(e0 e0Var, l5.e eVar) {
        return new f((Context) eVar.a(Context.class), ((i5.e) eVar.a(i5.e.class)).n(), (Set<g>) eVar.f(g.class), (w5.b<f6.i>) eVar.g(f6.i.class), (Executor) eVar.d(e0Var));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String i() throws Exception {
        String string;
        synchronized (this) {
            q qVar = this.f34625a.get();
            List<r> listC = qVar.c();
            qVar.b();
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < listC.size(); i10++) {
                r rVar = listC.get(i10);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("agent", rVar.c());
                jSONObject.put("dates", new JSONArray((Collection) rVar.b()));
                jSONArray.put(jSONObject);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("heartbeats", jSONArray);
            jSONObject2.put("version", "2");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                try {
                    gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                    gZIPOutputStream.close();
                    base64OutputStream.close();
                    string = byteArrayOutputStream.toString("UTF-8");
                } finally {
                }
            } finally {
            }
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q j(Context context, String str) {
        return new q(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void k() throws Exception {
        synchronized (this) {
            this.f34625a.get().k(System.currentTimeMillis(), this.f34627c.get().getUserAgent());
        }
        return null;
    }

    @Override // u5.i
    public Task<String> a() {
        return UserManagerCompat.isUserUnlocked(this.f34626b) ^ true ? Tasks.forResult("") : Tasks.call(this.f34629e, new Callable() { // from class: u5.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f34621a.i();
            }
        });
    }

    @Override // u5.j
    @NonNull
    public synchronized j.a b(@NonNull String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        q qVar = this.f34625a.get();
        if (!qVar.i(jCurrentTimeMillis)) {
            return j.a.NONE;
        }
        qVar.g();
        return j.a.GLOBAL;
    }

    public Task<Void> l() {
        return this.f34628d.size() <= 0 ? Tasks.forResult(null) : UserManagerCompat.isUserUnlocked(this.f34626b) ^ true ? Tasks.forResult(null) : Tasks.call(this.f34629e, new Callable() { // from class: u5.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f34620a.k();
            }
        });
    }

    @VisibleForTesting
    f(w5.b<q> bVar, Set<g> set, Executor executor, w5.b<f6.i> bVar2, Context context) {
        this.f34625a = bVar;
        this.f34628d = set;
        this.f34629e = executor;
        this.f34627c = bVar2;
        this.f34626b = context;
    }
}
