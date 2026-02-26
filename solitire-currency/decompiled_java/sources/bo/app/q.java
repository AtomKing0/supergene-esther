package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.coroutine.BrazeCoroutineScope;
import java.util.Map;
import java.util.Set;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements SharedPreferences {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SharedPreferences f3670b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b2 f3671c;

    public q(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i("persistent.com.appboy.storage.sdk_enabled_cache", "name");
        this.f3669a = context;
        this.f3671c = kotlinx.coroutines.k.d(BrazeCoroutineScope.INSTANCE, null, null, new o(this, null), 3, null);
    }

    public final void a() throws InterruptedException {
        if (!this.f3671c.i()) {
            kotlinx.coroutines.j.b(null, new p(this, null), 1, null);
        }
        SharedPreferences sharedPreferences = this.f3669a.getSharedPreferences("persistent.com.appboy.storage.sdk_enabled_cache", 0);
        kotlin.jvm.internal.t.h(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.f3670b = sharedPreferences;
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.contains(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        kotlin.jvm.internal.t.h(editorEdit, "prefs.edit()");
        return editorEdit;
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        Map<String, ?> all = sharedPreferences.getAll();
        kotlin.jvm.internal.t.h(all, "prefs.all");
        return all;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z10) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getBoolean(str, z10);
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f10) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getFloat(str, f10);
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i10) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getInt(str, i10);
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j10) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getLong(str, j10);
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        return sharedPreferences.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) throws InterruptedException {
        a();
        SharedPreferences sharedPreferences = this.f3670b;
        if (sharedPreferences == null) {
            kotlin.jvm.internal.t.A("prefs");
            sharedPreferences = null;
        }
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
