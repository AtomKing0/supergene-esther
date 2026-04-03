package androidx.activity;

import android.content.res.Resources;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EdgeToEdge.kt */
/* JADX INFO: loaded from: classes.dex */
final class SystemBarStyle$Companion$auto$1 extends v implements h9.l<Resources, Boolean> {
    public static final SystemBarStyle$Companion$auto$1 INSTANCE = new SystemBarStyle$Companion$auto$1();

    SystemBarStyle$Companion$auto$1() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull Resources resources) {
        t.i(resources, "resources");
        return Boolean.valueOf((resources.getConfiguration().uiMode & 48) == 32);
    }
}
