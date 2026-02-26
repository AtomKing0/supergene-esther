package androidx.compose.foundation.lazy.grid;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LazyGridItemInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public interface LazyGridItemInfo {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int UnknownColumn = -1;
    public static final int UnknownRow = -1;

    /* JADX INFO: compiled from: LazyGridItemInfo.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int UnknownColumn = -1;
        public static final int UnknownRow = -1;

        private Companion() {
        }
    }

    int getColumn();

    int getIndex();

    @NotNull
    Object getKey();

    /* JADX INFO: renamed from: getOffset-nOcc-ac, reason: not valid java name */
    long mo560getOffsetnOccac();

    int getRow();

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo561getSizeYbymL2g();
}
