package androidx.compose.runtime.external.kotlinx.collections.immutable;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImmutableList.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a<E> {
    @NotNull
    public static ImmutableList a(ImmutableList immutableList, int i10, int i11) {
        return new ImmutableList.SubList(immutableList, i10, i11);
    }
}
