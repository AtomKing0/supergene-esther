package androidx.compose.runtime;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ParcelableSnapshotMutableState.kt */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ParcelableSnapshotMutableState<T> extends SnapshotMutableStateImpl<T> implements Parcelable {
    private static final int PolicyNeverEquals = 0;
    private static final int PolicyReferentialEquality = 2;
    private static final int PolicyStructuralEquality = 1;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final Parcelable.Creator<ParcelableSnapshotMutableState<Object>> CREATOR = new Parcelable.ClassLoaderCreator<ParcelableSnapshotMutableState<Object>>() { // from class: androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableSnapshotMutableState<Object>[] newArray(int i10) {
            return new ParcelableSnapshotMutableState[i10];
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.ClassLoaderCreator
        @NotNull
        public ParcelableSnapshotMutableState<Object> createFromParcel(@NotNull Parcel parcel, @Nullable ClassLoader classLoader) {
            SnapshotMutationPolicy snapshotMutationPolicyNeverEqualPolicy;
            t.i(parcel, "parcel");
            if (classLoader == null) {
                classLoader = ParcelableSnapshotMutableState$Companion$CREATOR$1.class.getClassLoader();
            }
            Object value = parcel.readValue(classLoader);
            int i10 = parcel.readInt();
            if (i10 == 0) {
                snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.neverEqualPolicy();
            } else if (i10 == 1) {
                snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.structuralEqualityPolicy();
            } else if (i10 == 2) {
                snapshotMutationPolicyNeverEqualPolicy = SnapshotStateKt.referentialEqualityPolicy();
            } else {
                throw new IllegalStateException("Unsupported MutableState policy " + i10 + " was restored");
            }
            return new ParcelableSnapshotMutableState<>(value, snapshotMutationPolicyNeverEqualPolicy);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public ParcelableSnapshotMutableState<Object> createFromParcel(@NotNull Parcel parcel) {
            t.i(parcel, "parcel");
            return createFromParcel(parcel, (ClassLoader) null);
        }
    };

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParcelableSnapshotMutableState(T t10, @NotNull SnapshotMutationPolicy<T> policy) {
        super(t10, policy);
        t.i(policy, "policy");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i10) {
        int i11;
        t.i(parcel, "parcel");
        parcel.writeValue(getValue());
        SnapshotMutationPolicy<T> policy = getPolicy();
        if (t.d(policy, SnapshotStateKt.neverEqualPolicy())) {
            i11 = 0;
        } else if (t.d(policy, SnapshotStateKt.structuralEqualityPolicy())) {
            i11 = 1;
        } else {
            if (!t.d(policy, SnapshotStateKt.referentialEqualityPolicy())) {
                throw new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
            }
            i11 = 2;
        }
        parcel.writeInt(i11);
    }

    /* JADX INFO: compiled from: ParcelableSnapshotMutableState.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
