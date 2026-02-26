package androidx.core.os;

import android.os.PersistableBundle;
import androidx.annotation.RequiresApi;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import v8.s;

/* JADX INFO: compiled from: PersistableBundle.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PersistableBundleKt {
    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf(@NotNull s<String, ? extends Object>... sVarArr) {
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(sVarArr.length);
        for (s<String, ? extends Object> sVar : sVarArr) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, sVar.a(), sVar.b());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle toPersistableBundle(@NotNull Map<String, ? extends Object> map) {
        PersistableBundle persistableBundleCreatePersistableBundle = PersistableBundleApi21ImplKt.createPersistableBundle(map.size());
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            PersistableBundleApi21ImplKt.putValue(persistableBundleCreatePersistableBundle, entry.getKey(), entry.getValue());
        }
        return persistableBundleCreatePersistableBundle;
    }

    @RequiresApi(21)
    @NotNull
    public static final PersistableBundle persistableBundleOf() {
        return PersistableBundleApi21ImplKt.createPersistableBundle(0);
    }
}
