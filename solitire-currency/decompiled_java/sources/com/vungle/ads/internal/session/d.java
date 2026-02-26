package com.vungle.ads.internal.session;

import android.content.Context;
import com.vungle.ads.internal.model.m;
import com.vungle.ads.internal.util.i;
import com.vungle.ads.internal.util.p;
import com.vungle.ads.internal.util.q;
import h9.l;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: UnclosedAdDetector.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    @NotNull
    private static final String FILENAME = "unclosed_ad";

    @NotNull
    private final Context context;

    @NotNull
    private final com.vungle.ads.internal.executor.a executors;

    @NotNull
    private File file;

    @NotNull
    private final q pathProvider;

    @NotNull
    private final String sessionId;

    @NotNull
    private final CopyOnWriteArrayList<m> unclosedAdList;

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private static final kotlinx.serialization.json.a json = kotlinx.serialization.json.m.b(null, a.INSTANCE, 1, null);

    /* JADX INFO: compiled from: UnclosedAdDetector.kt */
    static final class a extends v implements l<kotlinx.serialization.json.c, k0> {
        public static final a INSTANCE = new a();

        a() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(kotlinx.serialization.json.c cVar) {
            invoke2(cVar);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull kotlinx.serialization.json.c Json) {
            t.i(Json, "$this$Json");
            Json.f(true);
            Json.d(true);
            Json.e(false);
            Json.c(true);
        }
    }

    /* JADX INFO: compiled from: UnclosedAdDetector.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(k kVar) {
            this();
        }
    }

    public d(@NotNull Context context, @NotNull String sessionId, @NotNull com.vungle.ads.internal.executor.a executors, @NotNull q pathProvider) throws IOException {
        t.i(context, "context");
        t.i(sessionId, "sessionId");
        t.i(executors, "executors");
        t.i(pathProvider, "pathProvider");
        this.context = context;
        this.sessionId = sessionId;
        this.executors = executors;
        this.pathProvider = pathProvider;
        this.file = pathProvider.getUnclosedAdFile(FILENAME);
        this.unclosedAdList = new CopyOnWriteArrayList<>();
        File file = this.file;
        if (file == null || file.exists()) {
            return;
        }
        this.file.createNewFile();
    }

    private final /* synthetic */ <T> T decodeJson(String str) {
        kotlinx.serialization.json.a aVar = json;
        fa.c cVarA = aVar.a();
        t.o(6, "T");
        KSerializer<Object> kSerializerB = z9.l.b(cVarA, null);
        t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (T) aVar.b(kSerializerB, str);
    }

    private final List<m> readUnclosedAdFromFile() {
        return (List) new com.vungle.ads.internal.executor.b(this.executors.getIoExecutor().submit(new Callable() { // from class: com.vungle.ads.internal.session.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d.m4098readUnclosedAdFromFile$lambda2(this.f24388a);
            }
        })).get(1000L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: readUnclosedAdFromFile$lambda-2, reason: not valid java name */
    public static final List m4098readUnclosedAdFromFile$lambda2(d this$0) {
        t.i(this$0, "this$0");
        try {
            String string = i.INSTANCE.readString(this$0.file);
            if (string == null || string.length() == 0) {
                return new ArrayList();
            }
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.k(List.class, KTypeProjection.Companion.invariant(o0.j(m.class))));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            return (List) aVar.b(kSerializerB, string);
        } catch (Exception e10) {
            p.Companion.e("UnclosedAdDetector", "Fail to read unclosed ad file " + e10.getMessage());
            return new ArrayList();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: retrieveUnclosedAd$lambda-1, reason: not valid java name */
    public static final void m4099retrieveUnclosedAd$lambda1(d this$0) {
        t.i(this$0, "this$0");
        try {
            i.deleteAndLogIfFailed(this$0.file);
        } catch (Exception e10) {
            p.Companion.e("UnclosedAdDetector", "Fail to delete file " + e10.getMessage());
        }
    }

    private final void writeUnclosedAdToFile(List<m> list) {
        try {
            kotlinx.serialization.json.a aVar = json;
            KSerializer<Object> kSerializerB = z9.l.b(aVar.a(), o0.k(List.class, KTypeProjection.Companion.invariant(o0.j(m.class))));
            t.g(kSerializerB, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            final String strC = aVar.c(kSerializerB, list);
            this.executors.getIoExecutor().execute(new Runnable() { // from class: com.vungle.ads.internal.session.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.m4100writeUnclosedAdToFile$lambda3(this.f24386a, strC);
                }
            });
        } catch (Throwable th) {
            p.Companion.e("UnclosedAdDetector", "Fail to write unclosed ad file " + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: writeUnclosedAdToFile$lambda-3, reason: not valid java name */
    public static final void m4100writeUnclosedAdToFile$lambda3(d this$0, String jsonContent) {
        t.i(this$0, "this$0");
        t.i(jsonContent, "$jsonContent");
        i.INSTANCE.writeString(this$0.file, jsonContent);
    }

    public final void addUnclosedAd(@NotNull m ad) {
        t.i(ad, "ad");
        ad.setSessionId(this.sessionId);
        this.unclosedAdList.add(ad);
        writeUnclosedAdToFile(this.unclosedAdList);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final com.vungle.ads.internal.executor.a getExecutors() {
        return this.executors;
    }

    @NotNull
    public final q getPathProvider() {
        return this.pathProvider;
    }

    public final void removeUnclosedAd(@NotNull m ad) {
        t.i(ad, "ad");
        if (this.unclosedAdList.contains(ad)) {
            this.unclosedAdList.remove(ad);
            writeUnclosedAdToFile(this.unclosedAdList);
        }
    }

    @NotNull
    public final List<m> retrieveUnclosedAd() {
        ArrayList arrayList = new ArrayList();
        List<m> unclosedAdFromFile = readUnclosedAdFromFile();
        if (unclosedAdFromFile != null) {
            arrayList.addAll(unclosedAdFromFile);
        }
        this.executors.getIoExecutor().execute(new Runnable() { // from class: com.vungle.ads.internal.session.a
            @Override // java.lang.Runnable
            public final void run() {
                d.m4099retrieveUnclosedAd$lambda1(this.f24385a);
            }
        });
        return arrayList;
    }
}
