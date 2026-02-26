package androidx.datastore.core.handlers;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.CorruptionHandler;
import h9.l;
import java.io.IOException;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: ReplaceFileCorruptionHandler.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ReplaceFileCorruptionHandler<T> implements CorruptionHandler<T> {

    @NotNull
    private final l<CorruptionException, T> produceNewData;

    /* JADX WARN: Multi-variable type inference failed */
    public ReplaceFileCorruptionHandler(@NotNull l<? super CorruptionException, ? extends T> produceNewData) {
        t.i(produceNewData, "produceNewData");
        this.produceNewData = produceNewData;
    }

    @Override // androidx.datastore.core.CorruptionHandler
    @Nullable
    public Object handleCorruption(@NotNull CorruptionException corruptionException, @NotNull d<? super T> dVar) throws IOException {
        return this.produceNewData.invoke(corruptionException);
    }
}
