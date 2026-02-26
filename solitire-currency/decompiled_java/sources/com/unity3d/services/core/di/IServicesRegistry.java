package com.unity3d.services.core.di;

import java.util.Map;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.l;

/* JADX INFO: compiled from: IServicesRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IServicesRegistry {

    /* JADX INFO: compiled from: IServicesRegistry.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getService$default(IServicesRegistry iServicesRegistry, String str, KClass kClass, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getService");
            }
            if ((i10 & 1) != 0) {
                str = "";
            }
            return iServicesRegistry.getService(str, kClass);
        }
    }

    <T> T getService(@NotNull String str, @NotNull KClass<?> kClass);

    @NotNull
    Map<ServiceKey, l<?>> getServices();

    <T> T resolveService(@NotNull ServiceKey serviceKey);

    @Nullable
    <T> T resolveServiceOrNull(@NotNull ServiceKey serviceKey);

    <T> void updateService(@NotNull ServiceKey serviceKey, @NotNull l<? extends T> lVar);
}
