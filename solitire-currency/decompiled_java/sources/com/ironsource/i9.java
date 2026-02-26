package com.ironsource;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.v8;
import java.lang.Thread;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i9 {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f12567k = "1.0.6";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f12568l = "";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ce f12569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f12572d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f12573e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ContextProvider f12574f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f12575g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f12576h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f12577i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12578j;

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f12580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12581b;

        b(Context context, String str) {
            this.f12580a = context;
            this.f12581b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String strP = i9.this.f12569a.p(this.f12580a);
                if (!TextUtils.isEmpty(strP)) {
                    i9.this.f12571c = strP;
                }
                String strA = i9.this.f12569a.a(this.f12580a);
                if (!TextUtils.isEmpty(strA)) {
                    i9.this.f12573e = strA;
                }
                SharedPreferences.Editor editorEdit = this.f12580a.getSharedPreferences("CRep", 0).edit();
                editorEdit.putString("String1", i9.this.f12571c);
                editorEdit.putString("sId", this.f12581b);
                editorEdit.apply();
            } catch (Exception e10) {
                IronLog.INTERNAL.error(e10.toString());
            }
        }
    }

    class c extends j9 {
        c(JSONObject jSONObject) {
            super(jSONObject);
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    private static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile i9 f12584a = new i9(null);

        private d() {
        }
    }

    private i9() {
        this.f12578j = false;
        this.f12569a = el.N().f();
        this.f12574f = ContextProvider.getInstance();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.f12575g = defaultUncaughtExceptionHandler;
        this.f12577i = " ";
        this.f12576h = "https://o-crash.mediation.unity3d.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new g9(defaultUncaughtExceptionHandler));
    }

    static List<wb> c() {
        return null;
    }

    public static i9 d() {
        return d.f12584a;
    }

    Context a() {
        return this.f12574f.getApplicationContext();
    }

    public String b() {
        return f12567k;
    }

    String e() {
        return this.f12577i;
    }

    /* synthetic */ i9(a aVar) {
        this();
    }

    private String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null) {
                    return "none";
                }
                return networkCapabilities.hasTransport(1) ? r8.f14655b : networkCapabilities.hasTransport(0) ? r8.f14660g : "none";
            } catch (Exception e10) {
                IronLog.INTERNAL.error(e10.toString());
                return "none";
            }
        }
        return "none";
    }

    private void a(Context context, HashSet<String> hashSet) {
        String strA = a(a());
        if (strA.equals("none")) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
        String string = sharedPreferences.getString("String1", this.f12571c);
        String string2 = sharedPreferences.getString("sId", this.f12572d);
        List<wb> listB = s9.b();
        IronLog.INTERNAL.verbose("reportList size " + listB.size());
        for (wb wbVar : listB) {
            JSONObject jSONObject = new JSONObject();
            String strB = wbVar.b();
            String strE = wbVar.e();
            String strD = wbVar.d();
            String packageName = context.getPackageName();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("crashDate", strB);
                jSONObject2.put("stacktraceCrash", strE);
                jSONObject2.put("crashType", strD);
                jSONObject2.put("CrashReporterVersion", f12567k);
                jSONObject2.put(v8.i.f15863q, "8.4.0");
                jSONObject2.put(v8.i.f15872x, this.f12569a.b(context));
                jSONObject2.put(v8.i.W, v3.b(context, packageName));
                jSONObject2.put(v8.i.f15857n, this.f12569a.o());
                jSONObject2.put("network", strA);
                jSONObject2.put(v8.i.f15861p, this.f12569a.k());
                jSONObject2.put(v8.i.f15853l, this.f12569a.e());
                jSONObject2.put("deviceOS", this.f12569a.l());
                jSONObject2.put("advertisingId", string);
                jSONObject2.put(v8.i.f15851k, this.f12569a.g());
                jSONObject2.put("systemProperties", System.getProperties());
                jSONObject2.put("bundleId", packageName);
                jSONObject2.put("sId", string2);
                if (!TextUtils.isEmpty(this.f12573e)) {
                    jSONObject2.put(v8.i.M, Boolean.parseBoolean(this.f12573e));
                }
                if (hashSet == null || hashSet.isEmpty()) {
                    jSONObject = jSONObject2;
                } else {
                    for (String str : hashSet) {
                        try {
                            if (jSONObject2.has(str)) {
                                jSONObject.put(str, jSONObject2.opt(str));
                            }
                        } catch (Exception e10) {
                            IronLog.INTERNAL.error(e10.toString());
                        }
                    }
                }
            } catch (Exception unused) {
            }
            if (jSONObject.length() == 0) {
                Log.d("ISCrashReport", " Is Empty");
            } else {
                new Thread(new c(jSONObject)).start();
            }
        }
        s9.a();
    }

    public void a(Throwable th) {
        IronLog.INTERNAL.verbose("isInitialized=" + this.f12578j);
        if (!this.f12578j || th == null) {
            return;
        }
        new wb(new h9(th).b(), "" + System.currentTimeMillis(), "Caught_IS_Crash").a();
    }

    public void a(HashSet<String> hashSet, String str, String str2, boolean z10, String str3, int i10, boolean z11) {
        Context applicationContext = this.f12574f.getApplicationContext();
        if (applicationContext != null) {
            Log.d("automation_log", "init ISCrashReporter");
            if (!TextUtils.isEmpty(str2)) {
                this.f12577i = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.f12576h = str;
            }
            this.f12572d = str3;
            if (z10) {
                new com.ironsource.a(i10).a(z11).b(true).a(new a()).start();
            }
            a(applicationContext, hashSet);
            new Thread(new b(applicationContext, str3)).start();
        }
        this.f12578j = true;
        IronLog.INTERNAL.verbose("initialized");
    }

    class a implements com.ironsource.b {
        a() {
        }

        @Override // com.ironsource.b
        public void a() {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            StringBuilder sb = new StringBuilder(128);
            for (Thread thread : allStackTraces.keySet()) {
                StackTraceElement[] stackTrace = thread.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    sb.append("*** Thread Name ");
                    sb.append(thread.getName());
                    sb.append(" Thread ID ");
                    sb.append(thread.getId());
                    sb.append(" ");
                    sb.append("(");
                    sb.append(thread.getState().toString());
                    sb.append(")");
                    sb.append(" ***\n");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append(" ");
                        sb.append(thread.getState().toString());
                        sb.append("\n");
                    }
                }
            }
            i9.f12568l = sb.toString();
        }

        @Override // com.ironsource.b
        public void b() {
        }
    }
}
