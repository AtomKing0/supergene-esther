package androidx.datastore.core;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
final class UnInitialized extends State<Object> {

    @NotNull
    public static final UnInitialized INSTANCE = new UnInitialized();

    private UnInitialized() {
        super(null);
    }
}
