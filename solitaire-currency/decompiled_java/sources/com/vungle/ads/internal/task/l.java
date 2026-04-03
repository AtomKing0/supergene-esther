package com.vungle.ads.internal.task;

import android.content.Context;
import com.vungle.ads.internal.util.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleJobCreator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class l implements c {

    @NotNull
    private final Context context;

    @NotNull
    private final q pathProvider;

    public l(@NotNull Context context, @NotNull q pathProvider) {
        t.i(context, "context");
        t.i(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    @Override // com.vungle.ads.internal.task.c
    @NotNull
    public b create(@NotNull String tag) throws k {
        t.i(tag, "tag");
        if (tag.length() == 0) {
            throw new k("Job tag is null");
        }
        if (t.d(tag, a.TAG)) {
            return new a(this.context, this.pathProvider);
        }
        if (t.d(tag, i.TAG)) {
            return new i(this.context, this.pathProvider);
        }
        throw new k("Unknown Job Type " + tag);
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final q getPathProvider() {
        return this.pathProvider;
    }
}
