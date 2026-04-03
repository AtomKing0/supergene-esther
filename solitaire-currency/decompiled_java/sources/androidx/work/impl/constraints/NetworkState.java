package androidx.work.impl.constraints;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NetworkState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NetworkState {
    private final boolean isConnected;
    private final boolean isMetered;
    private final boolean isNotRoaming;
    private final boolean isValidated;

    public NetworkState(boolean z10, boolean z11, boolean z12, boolean z13) {
        this.isConnected = z10;
        this.isValidated = z11;
        this.isMetered = z12;
        this.isNotRoaming = z13;
    }

    public static /* synthetic */ NetworkState copy$default(NetworkState networkState, boolean z10, boolean z11, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = networkState.isConnected;
        }
        if ((i10 & 2) != 0) {
            z11 = networkState.isValidated;
        }
        if ((i10 & 4) != 0) {
            z12 = networkState.isMetered;
        }
        if ((i10 & 8) != 0) {
            z13 = networkState.isNotRoaming;
        }
        return networkState.copy(z10, z11, z12, z13);
    }

    public final boolean component1() {
        return this.isConnected;
    }

    public final boolean component2() {
        return this.isValidated;
    }

    public final boolean component3() {
        return this.isMetered;
    }

    public final boolean component4() {
        return this.isNotRoaming;
    }

    @NotNull
    public final NetworkState copy(boolean z10, boolean z11, boolean z12, boolean z13) {
        return new NetworkState(z10, z11, z12, z13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        return this.isConnected == networkState.isConnected && this.isValidated == networkState.isValidated && this.isMetered == networkState.isMetered && this.isNotRoaming == networkState.isNotRoaming;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z10 = this.isConnected;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.isValidated;
        ?? r22 = z11;
        if (z11) {
            r22 = 1;
        }
        int i11 = (i10 + r22) * 31;
        boolean z12 = this.isMetered;
        ?? r23 = z12;
        if (z12) {
            r23 = 1;
        }
        int i12 = (i11 + r23) * 31;
        boolean z13 = this.isNotRoaming;
        return i12 + (z13 ? 1 : z13);
    }

    public final boolean isConnected() {
        return this.isConnected;
    }

    public final boolean isMetered() {
        return this.isMetered;
    }

    public final boolean isNotRoaming() {
        return this.isNotRoaming;
    }

    public final boolean isValidated() {
        return this.isValidated;
    }

    @NotNull
    public String toString() {
        return "NetworkState(isConnected=" + this.isConnected + ", isValidated=" + this.isValidated + ", isMetered=" + this.isMetered + ", isNotRoaming=" + this.isNotRoaming + ')';
    }
}
