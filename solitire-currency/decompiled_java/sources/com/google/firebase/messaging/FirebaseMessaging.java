package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.u0;
import com.google.firebase.messaging.z0;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import v5.a;

/* JADX INFO: loaded from: classes3.dex */
public class FirebaseMessaging {
    private static final String EXTRA_DUMMY_P_INTENT = "app";
    static final String GMS_PACKAGE = "com.google.android.gms";

    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";
    private static final long MAX_DELAY_SEC = TimeUnit.HOURS.toSeconds(8);
    private static final long MIN_DELAY_SEC = 30;
    private static final String SEND_INTENT_ACTION = "com.google.android.gcm.intent.SEND";
    private static final String SUBTYPE_DEFAULT = "";
    static final String TAG = "FirebaseMessaging";

    @GuardedBy("FirebaseMessaging.class")
    private static z0 store;

    @GuardedBy("FirebaseMessaging.class")
    @VisibleForTesting
    static ScheduledExecutorService syncExecutor;

    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting
    static w1.i transportFactory;
    private final a autoInit;
    private final Context context;
    private final Executor fileExecutor;
    private final i5.e firebaseApp;
    private final x5.e fis;
    private final e0 gmsRpc;

    @Nullable
    private final v5.a iid;
    private final Executor initExecutor;
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    private final j0 metadata;
    private final u0 requestDeduplicator;

    @GuardedBy("this")
    private boolean syncScheduledOrRunning;
    private final Executor taskExecutor;
    private final Task<e1> topicsSubscriberTask;

    /* JADX INFO: Access modifiers changed from: private */
    class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final t5.d f10332a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @GuardedBy("this")
        private boolean f10333b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        @GuardedBy("this")
        private t5.b<i5.b> f10334c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        @GuardedBy("this")
        private Boolean f10335d;

        a(t5.d dVar) {
            this.f10332a = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(t5.a aVar) {
            if (c()) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
        }

        @Nullable
        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context contextJ = FirebaseMessaging.this.firebaseApp.j();
            SharedPreferences sharedPreferences = contextJ.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = contextJ.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(contextJ.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void b() {
            if (this.f10333b) {
                return;
            }
            Boolean boolE = e();
            this.f10335d = boolE;
            if (boolE == null) {
                t5.b<i5.b> bVar = new t5.b() { // from class: com.google.firebase.messaging.b0
                    @Override // t5.b
                    public final void a(t5.a aVar) {
                        this.f10367a.d(aVar);
                    }
                };
                this.f10334c = bVar;
                this.f10332a.c(i5.b.class, bVar);
            }
            this.f10333b = true;
        }

        synchronized boolean c() {
            Boolean bool;
            b();
            bool = this.f10335d;
            return bool != null ? bool.booleanValue() : FirebaseMessaging.this.firebaseApp.s();
        }

        synchronized void f(boolean z10) {
            b();
            t5.b<i5.b> bVar = this.f10334c;
            if (bVar != null) {
                this.f10332a.a(i5.b.class, bVar);
                this.f10334c = null;
            }
            SharedPreferences.Editor editorEdit = FirebaseMessaging.this.firebaseApp.j().getSharedPreferences("com.google.firebase.messaging", 0).edit();
            editorEdit.putBoolean("auto_init", z10);
            editorEdit.apply();
            if (z10) {
                FirebaseMessaging.this.startSyncIfNecessary();
            }
            this.f10335d = Boolean.valueOf(z10);
        }
    }

    FirebaseMessaging(i5.e eVar, @Nullable v5.a aVar, w5.b<f6.i> bVar, w5.b<u5.j> bVar2, x5.e eVar2, @Nullable w1.i iVar, t5.d dVar) {
        this(eVar, aVar, bVar, bVar2, eVar2, iVar, dVar, new j0(eVar.j()));
    }

    @VisibleForTesting
    static synchronized void clearStoreForTest() {
        store = null;
    }

    static void clearTransportFactoryForTest() {
        transportFactory = null;
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        return getInstance(i5.e.k());
    }

    @NonNull
    private static synchronized z0 getStore(Context context) {
        if (store == null) {
            store = new z0(context);
        }
        return store;
    }

    private String getSubtype() {
        return "[DEFAULT]".equals(this.firebaseApp.l()) ? "" : this.firebaseApp.n();
    }

    @Nullable
    public static w1.i getTransportFactory() {
        return transportFactory;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: invokeOnTokenRefresh, reason: merged with bridge method [inline-methods] */
    public void lambda$new$0(String str) {
        if ("[DEFAULT]".equals(this.firebaseApp.l())) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Invoking onNewToken for app: " + this.firebaseApp.l());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new m(this.context).k(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$10(final String str, final z0.a aVar) {
        return this.gmsRpc.f().onSuccessTask(this.fileExecutor, new SuccessContinuation() { // from class: com.google.firebase.messaging.r
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return this.f10465a.lambda$blockingGetToken$9(str, aVar, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task lambda$blockingGetToken$9(String str, z0.a aVar, String str2) throws Exception {
        getStore(this.context).g(getSubtype(), str, str2, this.metadata.a());
        if (aVar == null || !str2.equals(aVar.f10501a)) {
            lambda$new$0(str2);
        }
        return Tasks.forResult(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$5(TaskCompletionSource taskCompletionSource) {
        try {
            this.iid.b(j0.c(this.firebaseApp), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$deleteToken$6(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.gmsRpc.c());
            getStore(this.context).d(getSubtype(), j0.c(this.firebaseApp));
            taskCompletionSource.setResult(null);
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$getToken$4(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(blockingGetToken());
        } catch (Exception e10) {
            taskCompletionSource.setException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$1() {
        if (isAutoInitEnabled()) {
            startSyncIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$2(e1 e1Var) {
        if (isAutoInitEnabled()) {
            e1Var.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$3() {
        p0.c(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$subscribeToTopic$7(String str, e1 e1Var) throws Exception {
        return e1Var.r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$unsubscribeFromTopic$8(String str, e1 e1Var) throws Exception {
        return e1Var.u(str);
    }

    private synchronized void startSync() {
        if (!this.syncScheduledOrRunning) {
            syncWithDelaySecondsInternal(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSyncIfNecessary() {
        v5.a aVar = this.iid;
        if (aVar != null) {
            aVar.getToken();
        } else if (tokenNeedsRefresh(getTokenWithoutTriggeringSync())) {
            startSync();
        }
    }

    String blockingGetToken() throws IOException {
        v5.a aVar = this.iid;
        if (aVar != null) {
            try {
                return (String) Tasks.await(aVar.c());
            } catch (InterruptedException | ExecutionException e10) {
                throw new IOException(e10);
            }
        }
        final z0.a tokenWithoutTriggeringSync = getTokenWithoutTriggeringSync();
        if (!tokenNeedsRefresh(tokenWithoutTriggeringSync)) {
            return tokenWithoutTriggeringSync.f10501a;
        }
        final String strC = j0.c(this.firebaseApp);
        try {
            return (String) Tasks.await(this.requestDeduplicator.b(strC, new u0.a() { // from class: com.google.firebase.messaging.x
                @Override // com.google.firebase.messaging.u0.a
                public final Task start() {
                    return this.f10485a.lambda$blockingGetToken$10(strC, tokenWithoutTriggeringSync);
                }
            }));
        } catch (InterruptedException | ExecutionException e11) {
            throw new IOException(e11);
        }
    }

    @NonNull
    public Task<Void> deleteToken() {
        if (this.iid != null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.y
                @Override // java.lang.Runnable
                public final void run() {
                    this.f10489a.lambda$deleteToken$5(taskCompletionSource);
                }
            });
            return taskCompletionSource.getTask();
        }
        if (getTokenWithoutTriggeringSync() == null) {
            return Tasks.forResult(null);
        }
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        n.e().execute(new Runnable() { // from class: com.google.firebase.messaging.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f10497a.lambda$deleteToken$6(taskCompletionSource2);
            }
        });
        return taskCompletionSource2.getTask();
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return i0.a();
    }

    @SuppressLint({"ThreadPoolCreation"})
    void enqueueTaskWithDelaySeconds(Runnable runnable, long j10) {
        synchronized (FirebaseMessaging.class) {
            if (syncExecutor == null) {
                syncExecutor = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            syncExecutor.schedule(runnable, j10, TimeUnit.SECONDS);
        }
    }

    Context getApplicationContext() {
        return this.context;
    }

    @NonNull
    public Task<String> getToken() {
        v5.a aVar = this.iid;
        if (aVar != null) {
            return aVar.c();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.initExecutor.execute(new Runnable() { // from class: com.google.firebase.messaging.a0
            @Override // java.lang.Runnable
            public final void run() {
                this.f10358a.lambda$getToken$4(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    @Nullable
    @VisibleForTesting
    z0.a getTokenWithoutTriggeringSync() {
        return getStore(this.context).e(getSubtype(), j0.c(this.firebaseApp));
    }

    Task<e1> getTopicsSubscriberTask() {
        return this.topicsSubscriberTask;
    }

    public boolean isAutoInitEnabled() {
        return this.autoInit.c();
    }

    @VisibleForTesting
    boolean isGmsCorePresent() {
        return this.metadata.g();
    }

    public boolean isNotificationDelegationEnabled() {
        return p0.d(this.context);
    }

    @Deprecated
    public void send(@NonNull r0 r0Var) {
        if (TextUtils.isEmpty(r0Var.getTo())) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent(SEND_INTENT_ACTION);
        Intent intent2 = new Intent();
        intent2.setPackage("com.google.example.invalidpackage");
        intent.putExtra("app", PendingIntent.getBroadcast(this.context, 0, intent2, AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL));
        intent.setPackage("com.google.android.gms");
        r0Var.a(intent);
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    public void setAutoInitEnabled(boolean z10) {
        this.autoInit.f(z10);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z10) {
        i0.y(z10);
    }

    @NonNull
    public Task<Void> setNotificationDelegationEnabled(boolean z10) {
        return p0.f(this.initExecutor, this.context, z10);
    }

    synchronized void setSyncScheduledOrRunning(boolean z10) {
        this.syncScheduledOrRunning = z10;
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    public Task<Void> subscribeToTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.w
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseMessaging.lambda$subscribeToTopic$7(str, (e1) obj);
            }
        });
    }

    synchronized void syncWithDelaySecondsInternal(long j10) {
        enqueueTaskWithDelaySeconds(new a1(this, Math.min(Math.max(MIN_DELAY_SEC, 2 * j10), MAX_DELAY_SEC)), j10);
        this.syncScheduledOrRunning = true;
    }

    @VisibleForTesting
    boolean tokenNeedsRefresh(@Nullable z0.a aVar) {
        return aVar == null || aVar.b(this.metadata.a());
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    public Task<Void> unsubscribeFromTopic(@NonNull final String str) {
        return this.topicsSubscriberTask.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.q
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                return FirebaseMessaging.lambda$unsubscribeFromTopic$8(str, (e1) obj);
            }
        });
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull i5.e eVar) {
        FirebaseMessaging firebaseMessaging;
        firebaseMessaging = (FirebaseMessaging) eVar.i(FirebaseMessaging.class);
        Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        return firebaseMessaging;
    }

    FirebaseMessaging(i5.e eVar, @Nullable v5.a aVar, w5.b<f6.i> bVar, w5.b<u5.j> bVar2, x5.e eVar2, @Nullable w1.i iVar, t5.d dVar, j0 j0Var) {
        this(eVar, aVar, eVar2, iVar, dVar, j0Var, new e0(eVar, j0Var, bVar, bVar2, eVar2), n.f(), n.c(), n.b());
    }

    FirebaseMessaging(i5.e eVar, @Nullable v5.a aVar, x5.e eVar2, @Nullable w1.i iVar, t5.d dVar, j0 j0Var, e0 e0Var, Executor executor, Executor executor2, Executor executor3) {
        this.syncScheduledOrRunning = false;
        transportFactory = iVar;
        this.firebaseApp = eVar;
        this.iid = aVar;
        this.fis = eVar2;
        this.autoInit = new a(dVar);
        Context contextJ = eVar.j();
        this.context = contextJ;
        p pVar = new p();
        this.lifecycleCallbacks = pVar;
        this.metadata = j0Var;
        this.taskExecutor = executor;
        this.gmsRpc = e0Var;
        this.requestDeduplicator = new u0(executor);
        this.initExecutor = executor2;
        this.fileExecutor = executor3;
        Context contextJ2 = eVar.j();
        if (contextJ2 instanceof Application) {
            ((Application) contextJ2).registerActivityLifecycleCallbacks(pVar);
        } else {
            Log.w(TAG, "Context " + contextJ2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (aVar != null) {
            aVar.a(new a.InterfaceC0711a() { // from class: com.google.firebase.messaging.s
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f10471a.lambda$new$1();
            }
        });
        Task<e1> taskF = e1.f(this, j0Var, e0Var, contextJ, n.g());
        this.topicsSubscriberTask = taskF;
        taskF.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.u
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                this.f10474a.lambda$new$2((e1) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f10477a.lambda$new$3();
            }
        });
    }
}
