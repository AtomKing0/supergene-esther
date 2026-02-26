package com.ironsource.environment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import com.ironsource.j;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ContextProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile ContextProvider f11950d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Activity f11951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f11952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<String, a> f11953c = new ConcurrentHashMap<>();

    public interface a {
        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private ContextProvider() {
    }

    public static ContextProvider getInstance() {
        if (f11950d == null) {
            synchronized (ContextProvider.class) {
                if (f11950d == null) {
                    f11950d = new ContextProvider();
                }
            }
        }
        return f11950d;
    }

    public Context getApplicationContext() {
        Activity activity;
        Context context = this.f11952b;
        return (context != null || (activity = this.f11951a) == null) ? context : activity.getApplicationContext();
    }

    public Activity getCurrentActiveActivity() {
        Activity activity = this.f11951a;
        return activity != null ? activity : j.f12678a.b();
    }

    public void onPause(Activity activity) {
        if (activity != null) {
            Iterator<a> it = this.f11953c.values().iterator();
            while (it.hasNext()) {
                it.next().onPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            this.f11951a = activity;
            Iterator<a> it = this.f11953c.values().iterator();
            while (it.hasNext()) {
                it.next().onResume(this.f11951a);
            }
        }
    }

    public void registerLifeCycleListener(a aVar) {
        this.f11953c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public void updateActivity(Activity activity) {
        if (activity != null) {
            this.f11951a = activity;
        }
    }

    public void updateAppContext(Context context) {
        if (context != null) {
            this.f11952b = context;
        }
    }
}
