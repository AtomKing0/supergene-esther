package io.sentry.config;

import io.sentry.u8;
import java.util.ArrayList;
import java.util.Properties;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PropertiesProviderFactory.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class h {
    @NotNull
    public static g a() {
        Properties propertiesA;
        Properties propertiesA2;
        u8 u8Var = new u8();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j());
        arrayList.add(new d());
        String property = System.getProperty("sentry.properties.file");
        if (property != null && (propertiesA2 = new e(property, u8Var).a()) != null) {
            arrayList.add(new i(propertiesA2));
        }
        String str = System.getenv("SENTRY_PROPERTIES_FILE");
        if (str != null && (propertiesA = new e(str, u8Var).a()) != null) {
            arrayList.add(new i(propertiesA));
        }
        Properties propertiesA3 = new b(u8Var).a();
        if (propertiesA3 != null) {
            arrayList.add(new i(propertiesA3));
        }
        Properties propertiesA4 = new e("sentry.properties", u8Var).a();
        if (propertiesA4 != null) {
            arrayList.add(new i(propertiesA4));
        }
        return new c(arrayList);
    }
}
