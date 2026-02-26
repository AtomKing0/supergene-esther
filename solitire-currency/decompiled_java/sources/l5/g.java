package l5;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ComponentDiscovery.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final T f30859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c<T> f30860b;

    /* JADX INFO: compiled from: ComponentDiscovery.java */
    private static class b implements c<Context> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<? extends Service> f30861a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f30861a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f30861a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // l5.g.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private b(Class<? extends Service> cls) {
            this.f30861a = cls;
        }
    }

    /* JADX INFO: compiled from: ComponentDiscovery.java */
    @VisibleForTesting
    interface c<T> {
        List<String> a(T t10);
    }

    @VisibleForTesting
    g(T t10, c<T> cVar) {
        this.f30859a = t10;
        this.f30860b = cVar;
    }

    public static g<Context> c(Context context, Class<? extends Service> cls) {
        return new g<>(context, new b(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new w(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e10) {
            throw new w(String.format("Could not instantiate %s.", str), e10);
        } catch (InstantiationException e11) {
            throw new w(String.format("Could not instantiate %s.", str), e11);
        } catch (NoSuchMethodException e12) {
            throw new w(String.format("Could not instantiate %s", str), e12);
        } catch (InvocationTargetException e13) {
            throw new w(String.format("Could not instantiate %s", str), e13);
        }
    }

    public List<w5.b<ComponentRegistrar>> b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f30860b.a(this.f30859a)) {
            arrayList.add(new w5.b() { // from class: l5.f
                @Override // w5.b
                public final Object get() {
                    return g.d(str);
                }
            });
        }
        return arrayList;
    }
}
