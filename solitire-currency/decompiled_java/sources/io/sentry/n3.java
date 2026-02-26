package io.sentry;

import java.lang.reflect.InvocationTargetException;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OptionsContainer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class n3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Class<T> f28011a;

    private n3(@NotNull Class<T> cls) {
        this.f28011a = cls;
    }

    @NotNull
    public static <T> n3<T> a(@NotNull Class<T> cls) {
        return new n3<>(cls);
    }

    @NotNull
    public T b() throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        return this.f28011a.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    }
}
