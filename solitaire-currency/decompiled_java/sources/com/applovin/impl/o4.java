package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import com.applovin.impl.r5;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class o4 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static com.applovin.impl.sdk.j f6463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static SharedPreferences f6464c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f6465a;

    public o4(com.applovin.impl.sdk.j jVar) {
        this.f6465a = com.applovin.impl.sdk.j.n().getSharedPreferences("com.applovin.sdk.preferences." + jVar.b0(), 0);
        f6463b = jVar;
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        a(str, obj, (SharedPreferences) null, editor);
    }

    public void b(n4 n4Var, Object obj) {
        b(n4Var, obj, this.f6465a);
    }

    public void a(String str, Object obj, SharedPreferences sharedPreferences) {
        a(str, obj, sharedPreferences, (SharedPreferences.Editor) null);
    }

    public void b(n4 n4Var, Object obj, SharedPreferences sharedPreferences) {
        a(n4Var.a(), obj, sharedPreferences);
    }

    public static void a(String str, Object obj, SharedPreferences sharedPreferences, SharedPreferences.Editor editor) {
        boolean z10 = editor != null;
        if (!z10) {
            editor = sharedPreferences.edit();
        }
        if (obj != null) {
            if (obj instanceof Boolean) {
                editor.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Float) {
                editor.putFloat(str, ((Float) obj).floatValue());
            } else if (obj instanceof Integer) {
                editor.putInt(str, ((Integer) obj).intValue());
            } else if (obj instanceof Long) {
                editor.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                editor.putLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
            } else if (obj instanceof String) {
                editor.putString(str, (String) obj);
            } else if (obj instanceof Set) {
                editor.putStringSet(str, (Set) obj);
            } else {
                com.applovin.impl.sdk.n.h("SharedPreferencesManager", "Unable to put default value of invalid type: " + obj);
                return;
            }
        } else {
            editor.remove(str);
        }
        if (z10) {
            return;
        }
        a(editor);
    }

    public static void b(n4 n4Var, Object obj, Context context) {
        a(n4Var.a(), obj, a(context), (SharedPreferences.Editor) null);
    }

    public void b(n4 n4Var) {
        a(this.f6465a.edit().remove(n4Var.a()));
    }

    public Object a(n4 n4Var, Object obj) {
        return a(n4Var, obj, this.f6465a);
    }

    public Object a(n4 n4Var, Object obj, SharedPreferences sharedPreferences) {
        return a(n4Var.a(), obj, n4Var.b(), sharedPreferences);
    }

    public static Object a(n4 n4Var, Object obj, Context context) {
        return a(n4Var.a(), obj, n4Var.b(), a(context));
    }

    public static Object a(n4 n4Var, Object obj, SharedPreferences sharedPreferences, boolean z10) {
        return a(n4Var.a(), obj, n4Var.b(), sharedPreferences, z10);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return a(str, obj, cls, sharedPreferences, true);
    }

    public static Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences, boolean z10) {
        Object stringSet;
        long jLongValue;
        int iIntValue;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!sharedPreferences.contains(str)) {
                return obj;
            }
            if (Boolean.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
                } else {
                    stringSet = Boolean.valueOf(sharedPreferences.getBoolean(str, false));
                }
            } else if (Float.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
                } else {
                    stringSet = Float.valueOf(sharedPreferences.getFloat(str, 0.0f));
                }
            } else if (Integer.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Long.class)) {
                        iIntValue = ((Long) obj).intValue();
                    } else {
                        iIntValue = ((Integer) obj).intValue();
                    }
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, iIntValue));
                } else {
                    stringSet = Integer.valueOf(sharedPreferences.getInt(str, 0));
                }
            } else if (Long.class.equals(cls)) {
                if (obj != null) {
                    if (obj.getClass().equals(Integer.class)) {
                        jLongValue = ((Integer) obj).longValue();
                    } else {
                        jLongValue = ((Long) obj).longValue();
                    }
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, jLongValue));
                } else {
                    stringSet = Long.valueOf(sharedPreferences.getLong(str, 0L));
                }
            } else if (Double.class.equals(cls)) {
                if (obj != null) {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, Double.doubleToRawLongBits(((Double) obj).doubleValue()))));
                } else {
                    stringSet = Double.valueOf(Double.longBitsToDouble(sharedPreferences.getLong(str, 0L)));
                }
            } else if (String.class.equals(cls)) {
                stringSet = sharedPreferences.getString(str, (String) obj);
            } else {
                stringSet = Set.class.isAssignableFrom(cls) ? sharedPreferences.getStringSet(str, (Set) obj) : obj;
            }
            return stringSet != null ? cls.cast(stringSet) : obj;
        } catch (Throwable th) {
            if (z10) {
                try {
                    com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Error getting value for key: " + str, th);
                } finally {
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                }
            }
            return obj;
        }
    }

    public Object a(n4 n4Var) {
        Object objA = a(n4Var, null);
        b(n4Var);
        return objA;
    }

    public void a(SharedPreferences sharedPreferences) {
        a(sharedPreferences.edit().clear());
    }

    public static void a(final SharedPreferences.Editor editor) {
        try {
            if (z6.h()) {
                com.applovin.impl.sdk.j jVar = f6463b;
                if (jVar != null && jVar.j0() != null) {
                    r5 r5VarJ0 = f6463b.j0();
                    com.applovin.impl.sdk.j jVar2 = f6463b;
                    Objects.requireNonNull(editor);
                    r5VarJ0.a((w4) new f6(jVar2, true, "commitSharedPreferencesChanges", new Runnable() { // from class: com.applovin.impl.yb
                        @Override // java.lang.Runnable
                        public final void run() {
                            editor.commit();
                        }
                    }), r5.b.OTHER);
                } else {
                    editor.apply();
                }
            } else {
                editor.commit();
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("SharedPreferencesManager", "Unable to apply changes", th);
            try {
                f6463b.A().a("SharedPreferencesManager", "persistChanges", th);
            } catch (Throwable unused) {
            }
        }
    }

    private static SharedPreferences a(Context context) {
        if (f6464c == null) {
            f6464c = context.getSharedPreferences("com.applovin.sdk.shared", 0);
        }
        return f6464c;
    }
}
