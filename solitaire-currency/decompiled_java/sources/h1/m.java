package h1;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.ironsource.v8;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: RequestManagerRetriever.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements Handler.Callback {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final b f26403i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bumptech.glide.j f26404a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f26407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f26408e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    final Map<FragmentManager, k> f26405b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    final Map<androidx.fragment.app.FragmentManager, p> f26406c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayMap<View, Fragment> f26409f = new ArrayMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayMap<View, android.app.Fragment> f26410g = new ArrayMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Bundle f26411h = new Bundle();

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    class a implements b {
        a() {
        }

        @Override // h1.m.b
        @NonNull
        public com.bumptech.glide.j a(@NonNull com.bumptech.glide.b bVar, @NonNull h hVar, @NonNull n nVar, @NonNull Context context) {
            return new com.bumptech.glide.j(bVar, hVar, nVar, context);
        }
    }

    /* JADX INFO: compiled from: RequestManagerRetriever.java */
    public interface b {
        @NonNull
        com.bumptech.glide.j a(@NonNull com.bumptech.glide.b bVar, @NonNull h hVar, @NonNull n nVar, @NonNull Context context);
    }

    public m(@Nullable b bVar) {
        this.f26408e = bVar == null ? f26403i : bVar;
        this.f26407d = new Handler(Looper.getMainLooper(), this);
    }

    @TargetApi(17)
    private static void a(@NonNull Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @Nullable
    private static Activity b(@NonNull Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return b(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    @TargetApi(26)
    @Deprecated
    private void c(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        if (Build.VERSION.SDK_INT < 26) {
            d(fragmentManager, arrayMap);
            return;
        }
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), arrayMap);
            }
        }
    }

    @Deprecated
    private void d(@NonNull FragmentManager fragmentManager, @NonNull ArrayMap<View, android.app.Fragment> arrayMap) {
        android.app.Fragment fragment;
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            this.f26411h.putInt(v8.h.W, i10);
            try {
                fragment = fragmentManager.getFragment(this.f26411h, v8.h.W);
            } catch (Exception unused) {
                fragment = null;
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                arrayMap.put(fragment.getView(), fragment);
                c(fragment.getChildFragmentManager(), arrayMap);
            }
            i10 = i11;
        }
    }

    private static void e(@Nullable Collection<Fragment> collection, @NonNull Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.getView() != null) {
                map.put(fragment.getView(), fragment);
                e(fragment.getChildFragmentManager().getFragments(), map);
            }
        }
    }

    @Nullable
    @Deprecated
    private android.app.Fragment f(@NonNull View view, @NonNull Activity activity) {
        this.f26410g.clear();
        c(activity.getFragmentManager(), this.f26410g);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f26410g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f26410g.clear();
        return fragment;
    }

    @Nullable
    private Fragment g(@NonNull View view, @NonNull FragmentActivity fragmentActivity) {
        this.f26409f.clear();
        e(fragmentActivity.getSupportFragmentManager().getFragments(), this.f26409f);
        View viewFindViewById = fragmentActivity.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f26409f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f26409f.clear();
        return fragment;
    }

    @NonNull
    @Deprecated
    private com.bumptech.glide.j h(@NonNull Context context, @NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z10) {
        k kVarQ = q(fragmentManager, fragment, z10);
        com.bumptech.glide.j jVarE = kVarQ.e();
        if (jVarE != null) {
            return jVarE;
        }
        com.bumptech.glide.j jVarA = this.f26408e.a(com.bumptech.glide.b.c(context), kVarQ.c(), kVarQ.f(), context);
        kVarQ.k(jVarA);
        return jVarA;
    }

    @NonNull
    private com.bumptech.glide.j o(@NonNull Context context) {
        if (this.f26404a == null) {
            synchronized (this) {
                if (this.f26404a == null) {
                    this.f26404a = this.f26408e.a(com.bumptech.glide.b.c(context.getApplicationContext()), new h1.b(), new g(), context.getApplicationContext());
                }
            }
        }
        return this.f26404a;
    }

    @NonNull
    private k q(@NonNull FragmentManager fragmentManager, @Nullable android.app.Fragment fragment, boolean z10) {
        k kVar = (k) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (kVar == null && (kVar = this.f26405b.get(fragmentManager)) == null) {
            kVar = new k();
            kVar.j(fragment);
            if (z10) {
                kVar.c().d();
            }
            this.f26405b.put(fragmentManager, kVar);
            fragmentManager.beginTransaction().add(kVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f26407d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return kVar;
    }

    @NonNull
    private p s(@NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z10) {
        p pVar = (p) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (pVar == null && (pVar = this.f26406c.get(fragmentManager)) == null) {
            pVar = new p();
            pVar.z(fragment);
            if (z10) {
                pVar.r().d();
            }
            this.f26406c.put(fragmentManager, pVar);
            fragmentManager.beginTransaction().add(pVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f26407d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return pVar;
    }

    private static boolean t(Context context) {
        Activity activityB = b(context);
        return activityB == null || !activityB.isFinishing();
    }

    @NonNull
    private com.bumptech.glide.j u(@NonNull Context context, @NonNull androidx.fragment.app.FragmentManager fragmentManager, @Nullable Fragment fragment, boolean z10) {
        p pVarS = s(fragmentManager, fragment, z10);
        com.bumptech.glide.j jVarT = pVarS.t();
        if (jVarT != null) {
            return jVarT;
        }
        com.bumptech.glide.j jVarA = this.f26408e.a(com.bumptech.glide.b.c(context), pVarS.r(), pVarS.u(), context);
        pVarS.A(jVarA);
        return jVarA;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Object obj;
        ComponentCallbacks componentCallbacksRemove;
        Object obj2;
        ComponentCallbacks componentCallbacks;
        int i10 = message.what;
        boolean z10 = true;
        if (i10 == 1) {
            obj = (FragmentManager) message.obj;
            componentCallbacksRemove = this.f26405b.remove(obj);
        } else {
            if (i10 != 2) {
                componentCallbacks = null;
                z10 = false;
                obj2 = null;
                if (z10 && componentCallbacks == null && Log.isLoggable("RMRetriever", 5)) {
                    Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
                }
                return z10;
            }
            obj = (androidx.fragment.app.FragmentManager) message.obj;
            componentCallbacksRemove = this.f26406c.remove(obj);
        }
        ComponentCallbacks componentCallbacks2 = componentCallbacksRemove;
        obj2 = obj;
        componentCallbacks = componentCallbacks2;
        if (z10) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj2);
        }
        return z10;
    }

    @NonNull
    public com.bumptech.glide.j i(@NonNull Activity activity) {
        if (o1.k.o()) {
            return k(activity.getApplicationContext());
        }
        a(activity);
        return h(activity, activity.getFragmentManager(), null, t(activity));
    }

    @NonNull
    @TargetApi(17)
    @Deprecated
    public com.bumptech.glide.j j(@NonNull android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (o1.k.o()) {
            return k(fragment.getActivity().getApplicationContext());
        }
        return h(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.j k(@NonNull Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (o1.k.p() && !(context instanceof Application)) {
            if (context instanceof FragmentActivity) {
                return n((FragmentActivity) context);
            }
            if (context instanceof Activity) {
                return i((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return k(contextWrapper.getBaseContext());
                }
            }
        }
        return o(context);
    }

    @NonNull
    public com.bumptech.glide.j l(@NonNull View view) {
        if (o1.k.o()) {
            return k(view.getContext().getApplicationContext());
        }
        o1.j.d(view);
        o1.j.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityB = b(view.getContext());
        if (activityB == null) {
            return k(view.getContext().getApplicationContext());
        }
        if (!(activityB instanceof FragmentActivity)) {
            android.app.Fragment fragmentF = f(view, activityB);
            return fragmentF == null ? i(activityB) : j(fragmentF);
        }
        FragmentActivity fragmentActivity = (FragmentActivity) activityB;
        Fragment fragmentG = g(view, fragmentActivity);
        return fragmentG != null ? m(fragmentG) : n(fragmentActivity);
    }

    @NonNull
    public com.bumptech.glide.j m(@NonNull Fragment fragment) {
        o1.j.e(fragment.getContext(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (o1.k.o()) {
            return k(fragment.getContext().getApplicationContext());
        }
        return u(fragment.getContext(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @NonNull
    public com.bumptech.glide.j n(@NonNull FragmentActivity fragmentActivity) {
        if (o1.k.o()) {
            return k(fragmentActivity.getApplicationContext());
        }
        a(fragmentActivity);
        return u(fragmentActivity, fragmentActivity.getSupportFragmentManager(), null, t(fragmentActivity));
    }

    @NonNull
    @Deprecated
    k p(Activity activity) {
        return q(activity.getFragmentManager(), null, t(activity));
    }

    @NonNull
    p r(Context context, androidx.fragment.app.FragmentManager fragmentManager) {
        return s(fragmentManager, null, t(context));
    }
}
