package com.ironsource;

import android.os.Looper;
import android.util.Log;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class i4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f12541a = new a(null);

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final void a() {
            if (kotlin.jvm.internal.t.d(Looper.myLooper(), Looper.getMainLooper())) {
                Log.e("AssertThread", "ALERT UI THREAD: " + Thread.currentThread().getStackTrace()[4].getMethodName());
            }
        }
    }

    public static final void a() {
        f12541a.a();
    }
}
