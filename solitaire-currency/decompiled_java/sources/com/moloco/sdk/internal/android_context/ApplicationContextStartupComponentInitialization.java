package com.moloco.sdk.internal.android_context;

import android.content.Context;
import androidx.startup.Initializer;
import com.moloco.sdk.internal.MolocoLogger;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
public final class ApplicationContextStartupComponentInitialization implements Initializer<k0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17526a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f17527b;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public a() {
        }
    }

    public void a(@NotNull Context context) {
        t.i(context, "context");
        b.a(context);
        f17527b = true;
        MolocoLogger.info$default(MolocoLogger.INSTANCE, "ApplicationContextStartupComponentInitialization", "initialized", null, false, 12, null);
    }

    @Override // androidx.startup.Initializer
    public /* bridge */ /* synthetic */ k0 create(Context context) {
        a(context);
        return k0.f35197a;
    }

    @Override // androidx.startup.Initializer
    @NotNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return v.l();
    }
}
