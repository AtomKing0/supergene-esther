package androidx.datastore.migrations;

import java.util.LinkedHashSet;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SharedPreferencesMigration.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SharedPreferencesMigrationKt {

    @NotNull
    private static final Set<String> MIGRATE_ALL_KEYS = new LinkedHashSet();

    @NotNull
    public static final Set<String> getMIGRATE_ALL_KEYS() {
        return MIGRATE_ALL_KEYS;
    }
}
