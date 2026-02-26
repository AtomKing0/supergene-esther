package u5;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: HeartBeatInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public interface j {

    /* JADX INFO: compiled from: HeartBeatInfo.java */
    public enum a {
        NONE(0),
        SDK(1),
        GLOBAL(2),
        COMBINED(3);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f34635a;

        a(int i10) {
            this.f34635a = i10;
        }

        public int a() {
            return this.f34635a;
        }
    }

    @NonNull
    a b(@NonNull String str);
}
