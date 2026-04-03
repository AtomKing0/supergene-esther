package com.vungle.ads.internal.omsdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.iab.omid.library.vungle.Omid;
import com.vungle.ads.internal.util.i;
import com.vungle.ads.internal.util.p;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OMInjector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String OM_SDK_JS = "omsdk.js";

    @NotNull
    private static final String OM_SESSION_JS = "omsdk-session.js";

    @NotNull
    private final AtomicReference<Context> contextRef;

    @NotNull
    private final Handler uiHandler;

    /* JADX INFO: compiled from: OMInjector.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public c(@NotNull Context context) {
        t.i(context, "context");
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.contextRef = new AtomicReference<>(context.getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: init$lambda-0, reason: not valid java name */
    public static final void m4069init$lambda0(c this$0) {
        t.i(this$0, "this$0");
        try {
            if (Omid.isActive()) {
                return;
            }
            Omid.activate(this$0.contextRef.get());
        } catch (NoClassDefFoundError e10) {
            p.Companion.e("OMSDK", "error: " + e10.getLocalizedMessage());
        }
    }

    private final File writeToFile(String str, File file) throws Throwable {
        FileWriter fileWriter = null;
        try {
            FileWriter fileWriter2 = new FileWriter(file);
            try {
                fileWriter2.write(str);
                fileWriter2.flush();
                i.INSTANCE.closeQuietly(fileWriter2);
                return file;
            } catch (Throwable th) {
                th = th;
                fileWriter = fileWriter2;
                i.INSTANCE.closeQuietly(fileWriter);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void init() {
        this.uiHandler.post(new Runnable() { // from class: com.vungle.ads.internal.omsdk.b
            @Override // java.lang.Runnable
            public final void run() {
                c.m4069init$lambda0(this.f24361a);
            }
        });
    }

    @WorkerThread
    @NotNull
    public final List<File> injectJsFiles(@NotNull File dir) throws IOException {
        t.i(dir, "dir");
        ArrayList arrayList = new ArrayList();
        e eVar = e.INSTANCE;
        arrayList.add(writeToFile(eVar.getOM_JS$vungle_ads_release(), new File(dir, OM_SDK_JS)));
        arrayList.add(writeToFile(eVar.getOM_SESSION_JS$vungle_ads_release(), new File(dir, OM_SESSION_JS)));
        return arrayList;
    }
}
