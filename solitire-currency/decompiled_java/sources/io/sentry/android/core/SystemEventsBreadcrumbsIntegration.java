package io.sentry.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.applovin.sdk.AppLovinEventTypes;
import io.sentry.Breadcrumb;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.protocol.Device;
import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: loaded from: classes5.dex */
public final class SystemEventsBreadcrumbsIntegration implements io.sentry.v1, Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @TestOnly
    @Nullable
    volatile b f27094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @TestOnly
    @Nullable
    volatile a f27095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final u1 f27096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f27097e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f27098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final String[] f27099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f27100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f27101i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile IntentFilter f27102j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27103k;

    final class a implements DefaultLifecycleObserver {
        a() {
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.a(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.b(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.c(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            androidx.lifecycle.c.d(this, lifecycleOwner);
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStart(@NonNull LifecycleOwner lifecycleOwner) {
            if (SystemEventsBreadcrumbsIntegration.this.f27098f == null || SystemEventsBreadcrumbsIntegration.this.f27097e == null) {
                return;
            }
            io.sentry.k1 k1VarA = SystemEventsBreadcrumbsIntegration.this.f27103k.a();
            try {
                SystemEventsBreadcrumbsIntegration.this.f27101i = false;
                if (k1VarA != null) {
                    k1VarA.close();
                }
                SystemEventsBreadcrumbsIntegration systemEventsBreadcrumbsIntegration = SystemEventsBreadcrumbsIntegration.this;
                systemEventsBreadcrumbsIntegration.G0(systemEventsBreadcrumbsIntegration.f27098f, SystemEventsBreadcrumbsIntegration.this.f27097e, false);
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // androidx.lifecycle.DefaultLifecycleObserver
        public void onStop(@NonNull LifecycleOwner lifecycleOwner) {
            SystemEventsBreadcrumbsIntegration.this.K0();
        }
    }

    static final class b extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final io.sentry.f1 f27105a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final SentryAndroidOptions f27106b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final io.sentry.android.core.internal.util.h f27107c = new io.sentry.android.core.internal.util.h(io.sentry.android.core.internal.util.b.b(), 60000, 0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final char[] f27108d = new char[64];

        b(@NotNull io.sentry.f1 f1Var, @NotNull SentryAndroidOptions sentryAndroidOptions) {
            this.f27105a = f1Var;
            this.f27106b = sentryAndroidOptions;
        }

        @NotNull
        private Breadcrumb b(long j10, @NotNull Intent intent, @Nullable String str, boolean z10) {
            Breadcrumb breadcrumb = new Breadcrumb(j10);
            breadcrumb.setType("system");
            breadcrumb.setCategory("device.event");
            String strC = c(str);
            if (strC != null) {
                breadcrumb.setData("action", strC);
            }
            if (z10) {
                Float fC = j1.c(intent, this.f27106b);
                if (fC != null) {
                    breadcrumb.setData(AppLovinEventTypes.USER_COMPLETED_LEVEL, fC);
                }
                Boolean boolT = j1.t(intent, this.f27106b);
                if (boolT != null) {
                    breadcrumb.setData(Device.JsonKeys.CHARGING, boolT);
                }
            } else {
                Bundle extras = intent.getExtras();
                HashMap map = new HashMap();
                if (extras != null && !extras.isEmpty()) {
                    for (String str2 : extras.keySet()) {
                        try {
                            Object obj = extras.get(str2);
                            if (obj != null) {
                                map.put(str2, obj.toString());
                            }
                        } catch (Throwable th) {
                            this.f27106b.getLogger().a(SentryLevel.ERROR, th, "%s key of the %s action threw an error.", str2, str);
                        }
                    }
                    breadcrumb.setData("extras", map);
                }
            }
            breadcrumb.setLevel(SentryLevel.INFO);
            return breadcrumb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(long j10, Intent intent, String str, boolean z10) {
            Breadcrumb breadcrumbB = b(j10, intent, str, z10);
            io.sentry.l0 l0Var = new io.sentry.l0();
            l0Var.j("android:intent", intent);
            this.f27105a.addBreadcrumb(breadcrumbB, l0Var);
        }

        @TestOnly
        @Nullable
        String c(@Nullable String str) {
            if (str == null) {
                return null;
            }
            int length = str.length();
            int length2 = this.f27108d.length;
            for (int i10 = length - 1; i10 >= 0; i10--) {
                char cCharAt = str.charAt(i10);
                if (cCharAt == '.') {
                    char[] cArr = this.f27108d;
                    return new String(cArr, length2, cArr.length - length2);
                }
                if (length2 == 0) {
                    return io.sentry.util.d0.e(str);
                }
                length2--;
                this.f27108d[length2] = cCharAt;
            }
            return str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, @NotNull final Intent intent) {
            final String action = intent.getAction();
            final boolean zEquals = "android.intent.action.BATTERY_CHANGED".equals(action);
            if (zEquals && this.f27107c.a()) {
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                this.f27106b.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.o2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27431a.d(jCurrentTimeMillis, intent, action, zEquals);
                    }
                });
            } catch (Throwable unused) {
            }
        }
    }

    public SystemEventsBreadcrumbsIntegration(@NotNull Context context) {
        this(context, S());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryAndroidOptions sentryAndroidOptions, final boolean z10) {
        if (sentryAndroidOptions.isEnableSystemEventBreadcrumbs()) {
            io.sentry.k1 k1VarA = this.f27103k.a();
            try {
                if (!this.f27100h && !this.f27101i) {
                    if (this.f27094b == null) {
                        if (k1VarA != null) {
                            k1VarA.close();
                        }
                        try {
                            sentryAndroidOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.m2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    this.f27412a.h0(f1Var, sentryAndroidOptions, z10);
                                }
                            });
                            return;
                        } catch (Throwable unused) {
                            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Failed to start SystemEventsBreadcrumbsIntegration on executor thread.", new Object[0]);
                            return;
                        }
                    }
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    private void I0() {
        if (this.f27095c != null) {
            if (io.sentry.android.core.internal.util.d.e().a()) {
                i0();
            } else {
                this.f27096d.b(new Runnable() { // from class: io.sentry.android.core.l2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27404a.i0();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public void i0() {
        a aVar = this.f27095c;
        if (aVar != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(aVar);
        }
        this.f27095c = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        io.sentry.k1 k1VarA = this.f27103k.a();
        try {
            this.f27101i = true;
            b bVar = this.f27094b;
            this.f27094b = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
            if (bVar != null) {
                this.f27093a.unregisterReceiver(bVar);
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void O(@NotNull final SentryAndroidOptions sentryAndroidOptions) {
        try {
            ProcessLifecycleOwner.Companion companion = ProcessLifecycleOwner.Companion;
            if (io.sentry.android.core.internal.util.d.e().a()) {
                W(sentryAndroidOptions);
            } else {
                this.f27096d.b(new Runnable() { // from class: io.sentry.android.core.n2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27423a.W(sentryAndroidOptions);
                    }
                });
            }
        } catch (ClassNotFoundException unused) {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "androidx.lifecycle is not available, SystemEventsBreadcrumbsIntegration won't be able to register/unregister an internal BroadcastReceiver. This may result in an increased ANR rate on Android 14 and above.", new Object[0]);
        } catch (Throwable th) {
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "SystemEventsBreadcrumbsIntegration could not register lifecycle observer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void W(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        this.f27095c = new a();
        try {
            ProcessLifecycleOwner.get().getLifecycle().addObserver(this.f27095c);
        } catch (Throwable th) {
            this.f27095c = null;
            sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "SystemEventsBreadcrumbsIntegration failed to get Lifecycle and could not install lifecycle observer.", th);
        }
    }

    @NotNull
    private static String[] S() {
        return new String[]{"android.intent.action.ACTION_SHUTDOWN", "android.intent.action.AIRPLANE_MODE", "android.intent.action.BATTERY_CHANGED", "android.intent.action.CAMERA_BUTTON", "android.intent.action.CONFIGURATION_CHANGED", "android.intent.action.DATE_CHANGED", "android.intent.action.DEVICE_STORAGE_LOW", "android.intent.action.DEVICE_STORAGE_OK", "android.intent.action.DOCK_EVENT", "android.intent.action.DREAMING_STARTED", "android.intent.action.DREAMING_STOPPED", "android.intent.action.INPUT_METHOD_CHANGED", "android.intent.action.LOCALE_CHANGED", "android.intent.action.SCREEN_OFF", "android.intent.action.SCREEN_ON", "android.intent.action.TIMEZONE_CHANGED", "android.intent.action.TIME_SET", "android.os.action.DEVICE_IDLE_MODE_CHANGED", "android.os.action.POWER_SAVE_MODE_CHANGED"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h0(io.sentry.f1 f1Var, SentryAndroidOptions sentryAndroidOptions, boolean z10) {
        io.sentry.k1 k1VarA = this.f27103k.a();
        try {
            if (!this.f27100h && !this.f27101i && this.f27094b == null) {
                this.f27094b = new b(f1Var, sentryAndroidOptions);
                if (this.f27102j == null) {
                    this.f27102j = new IntentFilter();
                    for (String str : this.f27099g) {
                        this.f27102j.addAction(str);
                    }
                }
                try {
                    e1.A(this.f27093a, sentryAndroidOptions, this.f27094b, this.f27102j);
                    if (z10) {
                        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration installed.", new Object[0]);
                        io.sentry.util.p.a("SystemEventsBreadcrumbs");
                    }
                } catch (Throwable th) {
                    sentryAndroidOptions.setEnableSystemEventBreadcrumbs(false);
                    sentryAndroidOptions.getLogger().b(SentryLevel.ERROR, "Failed to initialize SystemEventsBreadcrumbsIntegration.", th);
                }
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th2) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(f1Var, "Scopes are required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f27097e = sentryAndroidOptions;
        this.f27098f = f1Var;
        sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.f27097e.isEnableSystemEventBreadcrumbs()));
        if (this.f27097e.isEnableSystemEventBreadcrumbs()) {
            O(this.f27097e);
            G0(this.f27098f, this.f27097e, true);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        io.sentry.k1 k1VarA = this.f27103k.a();
        try {
            this.f27100h = true;
            this.f27102j = null;
            if (k1VarA != null) {
                k1VarA.close();
            }
            I0();
            K0();
            SentryAndroidOptions sentryAndroidOptions = this.f27097e;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "SystemEventsBreadcrumbsIntegration remove.", new Object[0]);
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private SystemEventsBreadcrumbsIntegration(@NotNull Context context, @NotNull String[] strArr) {
        this(context, strArr, new u1());
    }

    SystemEventsBreadcrumbsIntegration(@NotNull Context context, @NotNull String[] strArr, @NotNull u1 u1Var) {
        this.f27100h = false;
        this.f27101i = false;
        this.f27102j = null;
        this.f27103k = new io.sentry.util.a();
        this.f27093a = e1.h(context);
        this.f27099g = strArr;
        this.f27096d = u1Var;
    }
}
