package com.applovin.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import com.applovin.adview.AppLovinFullscreenActivity;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    class a extends com.applovin.impl.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference f4987a = new WeakReference(null);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f4988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b f4989c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f4990d;

        a(Class cls, b bVar, c cVar) {
            this.f4988b = cls;
            this.f4989c = bVar;
            this.f4990d = cVar;
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (this.f4988b.isInstance(activity) && this.f4987a.get() == null) {
                this.f4987a = new WeakReference(activity);
                this.f4989c.a(activity);
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f4988b.isInstance(activity) && !activity.isChangingConfigurations() && this.f4987a.get() == activity) {
                this.f4990d.b(this);
            }
        }
    }

    public interface b {
        void a(Activity activity);
    }

    public static void a(Context context, Class cls, c cVar, b bVar) {
        cVar.a(new a(cls, bVar, cVar));
        a(context, cls);
    }

    public static String b(AppLovinFullscreenActivity appLovinFullscreenActivity) {
        try {
            return appLovinFullscreenActivity.getPackageManager().getActivityInfo(new ComponentName(appLovinFullscreenActivity, appLovinFullscreenActivity.getClass()), 0).taskAffinity;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void a(Context context, Class cls) {
        Intent intent = new Intent(context, (Class<?>) cls);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void a(boolean z10, Activity activity) {
        if (z10 && k0.b()) {
            WindowInsetsController insetsController = activity.getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.setSystemBarsBehavior(2);
                insetsController.hide(WindowInsets.Type.systemBars());
                return;
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(5894);
                return;
            }
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public static boolean a(Activity activity) {
        return activity == null || activity.isFinishing() || activity.isChangingConfigurations() || activity.isDestroyed();
    }

    public static Activity a(View view) {
        if (view == null) {
            return null;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    public static String a(AppLovinFullscreenActivity appLovinFullscreenActivity) {
        ComponentName componentName;
        if (!k0.i()) {
            return null;
        }
        try {
            List<ActivityManager.AppTask> appTasks = ((ActivityManager) appLovinFullscreenActivity.getSystemService("activity")).getAppTasks();
            if (appTasks != null && !appTasks.isEmpty()) {
                Iterator<ActivityManager.AppTask> it = appTasks.iterator();
                while (it.hasNext()) {
                    ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
                    ComponentName componentName2 = taskInfo.topActivity;
                    String name = appLovinFullscreenActivity.getClass().getName();
                    if (componentName2 != null && componentName2.getClassName().equals(name) && (componentName = taskInfo.baseActivity) != null) {
                        return appLovinFullscreenActivity.getPackageManager().getActivityInfo(componentName, 0).taskAffinity;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
