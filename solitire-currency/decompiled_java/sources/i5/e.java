package i5;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.core.os.UserManagerCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import l5.o;
import l5.x;

/* JADX INFO: compiled from: FirebaseApp.java */
/* JADX INFO: loaded from: classes3.dex */
public class e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Object f26595k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy("LOCK")
    static final Map<String, e> f26596l = new ArrayMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f26597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f26598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k f26599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final o f26600d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final x<c6.a> f26603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final w5.b<u5.f> f26604h;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f26601e = new AtomicBoolean(false);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f26602f = new AtomicBoolean();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List<a> f26605i = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final List<Object> f26606j = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: FirebaseApp.java */
    @KeepForSdk
    public interface a {
        @KeepForSdk
        void onBackgroundStateChanged(boolean z10);
    }

    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(14)
    private static class b implements BackgroundDetector.BackgroundStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static AtomicReference<b> f26607a = new AtomicReference<>();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f26607a.get() == null) {
                    b bVar = new b();
                    if (androidx.compose.animation.core.d.a(f26607a, null, bVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z10) {
            synchronized (e.f26595k) {
                for (e eVar : new ArrayList(e.f26596l.values())) {
                    if (eVar.f26601e.get()) {
                        eVar.x(z10);
                    }
                }
            }
        }
    }

    /* JADX INFO: compiled from: FirebaseApp.java */
    @TargetApi(24)
    private static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static AtomicReference<c> f26608b = new AtomicReference<>();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f26609a;

        public c(Context context) {
            this.f26609a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f26608b.get() == null) {
                c cVar = new c(context);
                if (androidx.compose.animation.core.d.a(f26608b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f26609a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (e.f26595k) {
                Iterator<e> it = e.f26596l.values().iterator();
                while (it.hasNext()) {
                    it.next().o();
                }
            }
            c();
        }
    }

    protected e(final Context context, String str, k kVar) {
        this.f26597a = (Context) Preconditions.checkNotNull(context);
        this.f26598b = Preconditions.checkNotEmpty(str);
        this.f26599c = (k) Preconditions.checkNotNull(kVar);
        l lVarB = FirebaseInitProvider.b();
        g6.c.b("Firebase");
        g6.c.b("ComponentDiscovery");
        List<w5.b<ComponentRegistrar>> listB = l5.g.c(context, ComponentDiscoveryService.class).b();
        g6.c.a();
        g6.c.b("Runtime");
        o.b bVarG = o.k(m5.l.INSTANCE).d(listB).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(l5.c.s(context, Context.class, new Class[0])).b(l5.c.s(this, e.class, new Class[0])).b(l5.c.s(kVar, k.class, new Class[0])).g(new g6.b());
        if (UserManagerCompat.isUserUnlocked(context) && FirebaseInitProvider.c()) {
            bVarG.b(l5.c.s(lVarB, l.class, new Class[0]));
        }
        o oVarE = bVarG.e();
        this.f26600d = oVarE;
        g6.c.a();
        this.f26603g = new x<>(new w5.b() { // from class: i5.c
            @Override // w5.b
            public final Object get() {
                return this.f26592a.u(context);
            }
        });
        this.f26604h = oVarE.g(u5.f.class);
        g(new a() { // from class: i5.d
            @Override // i5.e.a
            public final void onBackgroundStateChanged(boolean z10) {
                this.f26594a.v(z10);
            }
        });
        g6.c.a();
    }

    private void h() {
        Preconditions.checkState(!this.f26602f.get(), "FirebaseApp was deleted");
    }

    @NonNull
    public static e k() {
        e eVar;
        synchronized (f26595k) {
            eVar = f26596l.get("[DEFAULT]");
            if (eVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
            eVar.f26604h.get().l();
        }
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (!UserManagerCompat.isUserUnlocked(this.f26597a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + l());
            c.b(this.f26597a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + l());
        this.f26600d.n(t());
        this.f26604h.get().l();
    }

    @Nullable
    public static e p(@NonNull Context context) {
        synchronized (f26595k) {
            if (f26596l.containsKey("[DEFAULT]")) {
                return k();
            }
            k kVarA = k.a(context);
            if (kVarA == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return q(context, kVarA);
        }
    }

    @NonNull
    public static e q(@NonNull Context context, @NonNull k kVar) {
        return r(context, kVar, "[DEFAULT]");
    }

    @NonNull
    public static e r(@NonNull Context context, @NonNull k kVar, @NonNull String str) {
        e eVar;
        b.b(context);
        String strW = w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f26595k) {
            Map<String, e> map = f26596l;
            Preconditions.checkState(!map.containsKey(strW), "FirebaseApp name " + strW + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            eVar = new e(context, strW, kVar);
            map.put(strW, eVar);
        }
        eVar.o();
        return eVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c6.a u(Context context) {
        return new c6.a(context, n(), (t5.c) this.f26600d.a(t5.c.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(boolean z10) {
        if (z10) {
            return;
        }
        this.f26604h.get().l();
    }

    private static String w(@NonNull String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(boolean z10) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator<a> it = this.f26605i.iterator();
        while (it.hasNext()) {
            it.next().onBackgroundStateChanged(z10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f26598b.equals(((e) obj).l());
        }
        return false;
    }

    @KeepForSdk
    public void g(a aVar) {
        h();
        if (this.f26601e.get() && BackgroundDetector.getInstance().isInBackground()) {
            aVar.onBackgroundStateChanged(true);
        }
        this.f26605i.add(aVar);
    }

    public int hashCode() {
        return this.f26598b.hashCode();
    }

    @KeepForSdk
    public <T> T i(Class<T> cls) {
        h();
        return (T) this.f26600d.a(cls);
    }

    @NonNull
    public Context j() {
        h();
        return this.f26597a;
    }

    @NonNull
    public String l() {
        h();
        return this.f26598b;
    }

    @NonNull
    public k m() {
        h();
        return this.f26599c;
    }

    @KeepForSdk
    public String n() {
        return Base64Utils.encodeUrlSafeNoPadding(l().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(m().c().getBytes(Charset.defaultCharset()));
    }

    @KeepForSdk
    public boolean s() {
        h();
        return this.f26603g.get().b();
    }

    @KeepForSdk
    @VisibleForTesting
    public boolean t() {
        return "[DEFAULT]".equals(l());
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f26598b).add("options", this.f26599c).toString();
    }
}
