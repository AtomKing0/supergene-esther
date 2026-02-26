package io.sentry.internal.debugmeta;

import java.util.List;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NoOpDebugMetaLoader.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f27915a = new b();

    private b() {
    }

    public static b b() {
        return f27915a;
    }

    @Override // io.sentry.internal.debugmeta.a
    @Nullable
    public List<Properties> a() {
        return null;
    }
}
